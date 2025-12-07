/**
 * ExecutorServiceDemo.java
 *
 * This program demonstrates the Executor framework in Java - a high-level API for
 * managing threads and executing tasks. ExecutorService provides thread pools,
 * task scheduling, and better thread lifecycle management than raw threads.
 *
 * Key Concepts:
 * - ExecutorService interface
 * - Thread pools (Fixed, Cached, Single, Scheduled)
 * - Callable and Future
 * - Task submission and execution
 * - Shutdown and termination
 * - Thread pool configuration
 * - Exception handling in tasks
 *
 * Java Features Used: Java 8+ (Lambda expressions, CompletableFuture)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorServiceDemo {

    public static void main(String[] args) {

        System.out.println("========== EXECUTOR SERVICE DEMONSTRATION ==========\n");

        // ========== WHY USE EXECUTOR SERVICE? ==========

        System.out.println("--- 1. Why Use ExecutorService? ---\n");

        System.out.println("Advantages over raw threads:");
        System.out.println("✓ Thread pooling - reuse threads efficiently");
        System.out.println("✓ Task queue management");
        System.out.println("✓ Better resource management");
        System.out.println("✓ Built-in thread lifecycle management");
        System.out.println("✓ Return values from tasks (Callable/Future)");
        System.out.println("✓ Scheduled execution support");
        System.out.println("✓ Easier exception handling\n");


        // ========== FIXED THREAD POOL ==========

        System.out.println("\n--- 2. Fixed Thread Pool ---\n");

        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        System.out.println("Created fixed thread pool with 3 threads");

        // Submit 10 tasks to pool of 3 threads
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                System.out.println("Task " + taskId + " executed by " +
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        shutdownAndAwait(fixedPool, "Fixed Pool");


        // ========== CACHED THREAD POOL ==========

        System.out.println("\n\n--- 3. Cached Thread Pool ---\n");

        ExecutorService cachedPool = Executors.newCachedThreadPool();
        System.out.println("Created cached thread pool (creates threads as needed)");

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedPool.submit(() -> {
                System.out.println("Task " + taskId + " on " +
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        shutdownAndAwait(cachedPool, "Cached Pool");


        // ========== SINGLE THREAD EXECUTOR ==========

        System.out.println("\n\n--- 4. Single Thread Executor ---\n");

        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        System.out.println("Created single thread executor (tasks execute sequentially)");

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            singleExecutor.submit(() -> {
                System.out.println("Task " + taskId + " executing sequentially");
            });
        }

        shutdownAndAwait(singleExecutor, "Single Thread Executor");


        // ========== CALLABLE AND FUTURE ==========

        System.out.println("\n\n--- 5. Callable and Future (Return Values) ---\n");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Callable returns a value (unlike Runnable)
        Callable<Integer> task = () -> {
            System.out.println("Calculating sum...");
            Thread.sleep(500);
            return IntStream.rangeClosed(1, 100).sum();
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Task submitted, doing other work...");

        try {
            // Get result (blocks until ready)
            Integer result = future.get();
            System.out.println("Result: " + result);
            System.out.println("Is done: " + future.isDone());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }

        shutdownAndAwait(executor, "Callable Executor");


        // ========== MULTIPLE FUTURES ==========

        System.out.println("\n\n--- 6. Multiple Futures ---\n");

        ExecutorService multiExecutor = Executors.newFixedThreadPool(3);

        List<Future<Integer>> futures = new ArrayList<>();

        // Submit multiple tasks
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            Future<Integer> f = multiExecutor.submit(() -> {
                Thread.sleep(100 * num);
                return num * num;
            });
            futures.add(f);
        }

        System.out.println("5 tasks submitted, collecting results...");

        // Collect results
        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer result = futures.get(i).get();
                System.out.println("Result " + (i + 1) + ": " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        shutdownAndAwait(multiExecutor, "Multi Future Executor");


        // ========== INVOKEALL ==========

        System.out.println("\n\n--- 7. invokeAll (Execute All Tasks) ---\n");

        ExecutorService invokeAllExec = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            tasks.add(() -> {
                Thread.sleep(taskId * 100);
                return "Task-" + taskId + " completed";
            });
        }

        try {
            // Waits for all tasks to complete
            List<Future<String>> results = invokeAllExec.invokeAll(tasks);

            System.out.println("All tasks completed:");
            for (Future<String> result : results) {
                System.out.println("  " + result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }

        shutdownAndAwait(invokeAllExec, "InvokeAll Executor");


        // ========== INVOKEANY ==========

        System.out.println("\n\n--- 8. invokeAny (First Successful Result) ---\n");

        ExecutorService invokeAnyExec = Executors.newFixedThreadPool(3);

        List<Callable<String>> raceTasks = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            raceTasks.add(() -> {
                Thread.sleep((4 - taskId) * 100); // Task 3 finishes first
                return "Winner: Task-" + taskId;
            });
        }

        try {
            // Returns result of first completed task
            String winner = invokeAnyExec.invokeAny(raceTasks);
            System.out.println(winner);
            System.out.println("Other tasks are cancelled");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }

        shutdownAndAwait(invokeAnyExec, "InvokeAny Executor");


        // ========== SCHEDULED EXECUTOR SERVICE ==========

        System.out.println("\n\n--- 9. Scheduled Executor Service ---\n");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        System.out.println("Scheduling tasks...");

        // Schedule one-time task with delay
        scheduler.schedule(() -> {
            System.out.println("One-time task executed after 1 second");
        }, 1, TimeUnit.SECONDS);

        // Schedule recurring task at fixed rate
        ScheduledFuture<?> periodicTask = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task: " + System.currentTimeMillis());
        }, 0, 500, TimeUnit.MILLISECONDS);

        // Let it run for a bit
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Cancel periodic task
        periodicTask.cancel(false);
        System.out.println("Cancelled periodic task");

        shutdownAndAwait(scheduler, "Scheduler");


        // ========== EXCEPTION HANDLING ==========

        System.out.println("\n\n--- 10. Exception Handling in Tasks ---\n");

        ExecutorService exceptionExec = Executors.newFixedThreadPool(2);

        // Task that throws exception
        Future<Integer> faultyTask = exceptionExec.submit(() -> {
            System.out.println("Task throwing exception...");
            if (true) {
                throw new RuntimeException("Task failed!");
            }
            return 42;
        });

        try {
            Integer result = faultyTask.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException e) {
            System.err.println("Task interrupted");
        } catch (ExecutionException e) {
            System.err.println("Task threw exception: " + e.getCause().getMessage());
        }

        shutdownAndAwait(exceptionExec, "Exception Executor");


        // ========== THREAD POOL EXECUTOR (CUSTOM) ==========

        System.out.println("\n\n--- 11. Custom ThreadPoolExecutor ---\n");

        ThreadPoolExecutor customPool = new ThreadPoolExecutor(
            2,                              // Core pool size
            4,                              // Maximum pool size
            60,                             // Keep alive time
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),   // Work queue
            new ThreadPoolExecutor.CallerRunsPolicy() // Rejection policy
        );

        System.out.println("Custom pool created:");
        System.out.println("  Core size: " + customPool.getCorePoolSize());
        System.out.println("  Max size: " + customPool.getMaximumPoolSize());
        System.out.println("  Queue capacity: 10");

        // Submit tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            customPool.submit(() -> {
                System.out.println("Custom pool task " + taskId + " on " +
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        shutdownAndAwait(customPool, "Custom Pool");


        // ========== PRACTICAL EXAMPLE: PARALLEL FILE PROCESSING ==========

        System.out.println("\n\n--- 12. Practical Example: Parallel Processing ---\n");

        ExecutorService processingPool = Executors.newFixedThreadPool(3);

        List<String> files = List.of("file1.txt", "file2.txt", "file3.txt",
                                      "file4.txt", "file5.txt");

        System.out.println("Processing " + files.size() + " files in parallel:");

        List<Future<String>> processingResults = new ArrayList<>();

        for (String file : files) {
            Future<String> result = processingPool.submit(() -> {
                // Simulate file processing
                System.out.println("Processing " + file + "...");
                Thread.sleep(200);
                return file + " processed successfully";
            });
            processingResults.add(result);
        }

        // Collect results
        for (Future<String> result : processingResults) {
            try {
                System.out.println("  " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Processing error: " + e.getMessage());
            }
        }

        shutdownAndAwait(processingPool, "Processing Pool");


        // ========== EXECUTOR SERVICE STATES ==========

        System.out.println("\n\n--- 13. Executor Service States ---\n");

        ExecutorService stateExec = Executors.newFixedThreadPool(2);

        System.out.println("Is shutdown: " + stateExec.isShutdown());
        System.out.println("Is terminated: " + stateExec.isTerminated());

        stateExec.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        stateExec.shutdown();
        System.out.println("\nAfter shutdown():");
        System.out.println("Is shutdown: " + stateExec.isShutdown());
        System.out.println("Is terminated: " + stateExec.isTerminated());

        try {
            stateExec.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nAfter awaitTermination():");
        System.out.println("Is terminated: " + stateExec.isTerminated());


        // ========== BEST PRACTICES ==========

        System.out.println("\n\n--- 14. Best Practices ---\n");

        System.out.println("✓ Always shutdown ExecutorService when done");
        System.out.println("✓ Use try-finally to ensure shutdown");
        System.out.println("✓ Choose appropriate pool type for your use case");
        System.out.println("✓ Handle exceptions in submitted tasks");
        System.out.println("✓ Monitor pool statistics (size, queue, active threads)");
        System.out.println("✓ Set appropriate pool size based on workload");
        System.out.println("✓ Use Callable for tasks that return values");
        System.out.println("✓ Configure rejection policy for bounded queues");


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHOD ==========

    /**
     * Gracefully shutdown executor and wait for termination
     */
    private static void shutdownAndAwait(ExecutorService executor, String name) {
        try {
            executor.shutdown();
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.err.println(name + " did not terminate");
                }
            }
            System.out.println("✓ " + name + " shutdown complete");
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

/*
 * EXECUTOR SERVICE QUICK REFERENCE:
 *
 * CREATING EXECUTORS:
 * Executors.newFixedThreadPool(n)      - Fixed number of threads
 * Executors.newCachedThreadPool()      - Creates threads as needed
 * Executors.newSingleThreadExecutor()  - Single thread (sequential)
 * Executors.newScheduledThreadPool(n)  - Scheduled tasks
 * Executors.newWorkStealingPool()      - Fork-join pool (Java 8+)
 *
 * SUBMITTING TASKS:
 * execute(Runnable)                    - Fire and forget
 * submit(Runnable)                     - Returns Future<?>
 * submit(Callable<T>)                  - Returns Future<T>
 * invokeAll(Collection<Callable<T>>)   - Execute all, wait for all
 * invokeAny(Collection<Callable<T>>)   - Execute all, return first
 *
 * SHUTDOWN:
 * shutdown()                           - Graceful shutdown (wait for tasks)
 * shutdownNow()                        - Immediate shutdown (interrupt tasks)
 * awaitTermination(timeout, unit)      - Wait for termination
 * isShutdown()                         - Check if shutdown initiated
 * isTerminated()                       - Check if fully terminated
 *
 * FUTURE METHODS:
 * get()                                - Get result (blocks)
 * get(timeout, unit)                   - Get with timeout
 * cancel(mayInterrupt)                 - Cancel task
 * isDone()                             - Check if completed
 * isCancelled()                        - Check if cancelled
 *
 * SCHEDULED EXECUTOR:
 * schedule(task, delay, unit)          - One-time delayed execution
 * scheduleAtFixedRate(task, initial, period, unit)  - Fixed rate
 * scheduleWithFixedDelay(task, initial, delay, unit) - Fixed delay
 *
 * THREAD POOL SIZING:
 * CPU-intensive:  cores = Runtime.getRuntime().availableProcessors()
 * I/O-intensive:  cores * 2 (or more)
 * Mixed:          Depends on ratio
 *
 * REJECTION POLICIES:
 * AbortPolicy              - Throw exception (default)
 * CallerRunsPolicy         - Run in caller's thread
 * DiscardPolicy            - Silently discard
 * DiscardOldestPolicy      - Discard oldest task
 *
 * WHEN TO USE:
 * FixedThreadPool:     Known number of long-running tasks
 * CachedThreadPool:    Many short-lived tasks
 * SingleThreadExecutor: Sequential execution needed
 * ScheduledThreadPool: Periodic or delayed tasks
 *
 * BEST PRACTICES:
 * ✓ Always shutdown executor service
 * ✓ Use try-finally for guaranteed shutdown
 * ✓ Handle exceptions in tasks
 * ✓ Use Callable for return values
 * ✓ Set appropriate pool size
 * ✓ Monitor pool metrics
 * ✓ Use timeout for get()
 * ✓ Check Future status before get()
 *
 * COMMON PATTERNS:
 * // Pattern 1: Try-finally
 * ExecutorService executor = Executors.newFixedThreadPool(10);
 * try {
 *     executor.submit(task);
 * } finally {
 *     executor.shutdown();
 * }
 *
 * // Pattern 2: Collect results
 * List<Future<T>> futures = new ArrayList<>();
 * for (Task task : tasks) {
 *     futures.add(executor.submit(task));
 * }
 * for (Future<T> future : futures) {
 *     T result = future.get();
 * }
 *
 * // Pattern 3: Scheduled tasks
 * ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
 * scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
 *
 * ADVANTAGES OVER RAW THREADS:
 * ✓ Thread reuse (better performance)
 * ✓ Resource management
 * ✓ Return values from tasks
 * ✓ Task queuing
 * ✓ Scheduled execution
 * ✓ Easier exception handling
 * ✓ Built-in thread lifecycle
 *
 * CALLABLE vs RUNNABLE:
 * Runnable:  No return value, no checked exceptions
 * Callable:  Returns value, can throw checked exceptions
 *
 * THREADPOOLEXECUTOR PARAMETERS:
 * corePoolSize     - Minimum threads to keep
 * maximumPoolSize  - Maximum threads allowed
 * keepAliveTime    - Time to keep excess threads
 * workQueue        - Queue for holding tasks
 * threadFactory    - Factory for creating threads
 * handler          - Policy for rejected tasks
 *
 * HOW TO RUN:
 * javac ExecutorServiceDemo.java
 * java ExecutorServiceDemo
 *
 * NEXT TOPICS:
 * - CompletableFuture for async programming
 * - Fork-Join framework for recursive tasks
 * - Concurrent collections
 * - Virtual threads (Java 21+)
 */
