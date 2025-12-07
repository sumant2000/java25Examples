/**
 * Virtual Thread Basics - Lightweight Concurrency (Java 21+)
 * 
 * Virtual threads are lightweight threads managed by the JVM that enable
 * high-throughput concurrent applications with simple sequential code.
 * 
 * Java 25 Status: Stable, production-ready feature.
 */

import java.time.Duration;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class VirtualThreadBasics {
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Virtual Threads Basics ===\n");
        
        demonstrateCreation();
        demonstrateVsUnbounded();
        demonstrateScalability();
        demonstrateIOBound();
        demonstrateStructuredConcurrency();
        demonstrateComparison();
    }
    
    /**
     * Different ways to create virtual threads
     */
    private static void demonstrateCreation() throws InterruptedException {
        System.out.println("1. Creating Virtual Threads:");
        
        // Method 1: Thread.startVirtualThread()
        Thread vt1 = Thread.startVirtualThread(() -> {
            System.out.println("   Method 1: " + Thread.currentThread());
        });
        vt1.join();
        
        // Method 2: Thread.ofVirtual().start()
        Thread vt2 = Thread.ofVirtual().start(() -> {
            System.out.println("   Method 2: " + Thread.currentThread());
        });
        vt2.join();
        
        // Method 3: Virtual thread executor
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                System.out.println("   Method 3: " + Thread.currentThread());
            }).get();
        }
        
        // Method 4: Thread factory
        ThreadFactory factory = Thread.ofVirtual().factory();
        Thread vt4 = factory.newThread(() -> {
            System.out.println("   Method 4: " + Thread.currentThread());
        });
        vt4.start();
        vt4.join();
        
        System.out.println();
    }
    
    /**
     * Virtual threads vs platform threads
     */
    private static void demonstrateVsUnbounded() throws InterruptedException, ExecutionException {
        System.out.println("2. Virtual Thread Executor:");
        
        int tasks = 10_000;
        
        // Virtual thread executor - creates a virtual thread per task
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var startTime = System.currentTimeMillis();
            
            var futures = IntStream.range(0, tasks)
                .mapToObj(i -> executor.submit(() -> {
                    Thread.sleep(Duration.ofMillis(100));
                    return i;
                }))
                .toList();
            
            // Wait for all to complete
            for (var future : futures) {
                future.get();
            }
            
            var duration = System.currentTimeMillis() - startTime;
            System.out.println("   Created " + tasks + " virtual threads");
            System.out.println("   Completed in: " + duration + "ms");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrating massive scalability
     */
    private static void demonstrateScalability() {
        System.out.println("3. Scalability - Creating Many Threads:");
        
        int count = 100_000;
        
        var startTime = System.currentTimeMillis();
        
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, count).forEach(i -> {
                executor.submit(() -> {
                    try {
                        Thread.sleep(Duration.ofMillis(10));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return i;
                });
            });
        }
        
        var duration = System.currentTimeMillis() - startTime;
        System.out.println("   Created and ran " + count + " virtual threads");
        System.out.println("   Time taken: " + duration + "ms");
        System.out.println("   (Try this with platform threads - it would fail!)");
        
        System.out.println();
    }
    
    /**
     * I/O-bound operations - where virtual threads shine
     */
    private static void demonstrateIOBound() throws InterruptedException {
        System.out.println("4. I/O-Bound Operations:");
        
        int requests = 1000;
        
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var startTime = System.currentTimeMillis();
            
            var futures = IntStream.range(0, requests)
                .mapToObj(i -> executor.submit(() -> simulateNetworkRequest(i)))
                .toList();
            
            // Collect results
            int successCount = 0;
            for (var future : futures) {
                try {
                    if (future.get()) successCount++;
                } catch (Exception e) {
                    // Handle error
                }
            }
            
            var duration = System.currentTimeMillis() - startTime;
            System.out.println("   Processed " + requests + " simulated network requests");
            System.out.println("   Success: " + successCount);
            System.out.println("   Time: " + duration + "ms");
        }
        
        System.out.println();
    }
    
    /**
     * Structured Concurrency (Java 21+)
     */
    private static void demonstrateStructuredConcurrency() throws InterruptedException, ExecutionException {
        System.out.println("5. Structured Concurrency:");
        
        // Using StructuredTaskScope for related tasks
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            // Fork multiple tasks
            var future1 = scope.fork(() -> {
                Thread.sleep(Duration.ofMillis(100));
                return "Task 1 completed";
            });
            
            var future2 = scope.fork(() -> {
                Thread.sleep(Duration.ofMillis(150));
                return "Task 2 completed";
            });
            
            var future3 = scope.fork(() -> {
                Thread.sleep(Duration.ofMillis(80));
                return "Task 3 completed";
            });
            
            // Wait for all to complete or any to fail
            scope.join();
            scope.throwIfFailed();
            
            // Get results (all completed successfully)
            System.out.println("   " + future1.resultNow());
            System.out.println("   " + future2.resultNow());
            System.out.println("   " + future3.resultNow());
        }
        
        System.out.println();
    }
    
    /**
     * Comparing platform threads vs virtual threads
     */
    private static void demonstrateComparison() {
        System.out.println("6. Platform vs Virtual Threads:");
        
        // Platform thread info
        Thread platformThread = Thread.ofPlatform().unstarted(() -> {});
        System.out.println("   Platform thread: " + platformThread);
        System.out.println("   Is virtual: " + platformThread.isVirtual());
        
        // Virtual thread info
        Thread virtualThread = Thread.ofVirtual().unstarted(() -> {});
        System.out.println("   Virtual thread: " + virtualThread);
        System.out.println("   Is virtual: " + virtualThread.isVirtual());
        
        System.out.println("\n   Memory comparison (approximate):");
        System.out.println("   - Platform thread: ~1 MB per thread");
        System.out.println("   - Virtual thread: ~1 KB per thread");
        System.out.println("   - Virtual threads: 1000x more memory efficient!");
        
        System.out.println("\n   Scalability:");
        System.out.println("   - Platform threads: Limited to ~few thousand");
        System.out.println("   - Virtual threads: Millions possible");
    }
    
    /**
     * Simulate a network request (I/O-bound operation)
     */
    private static boolean simulateNetworkRequest(int id) {
        try {
            // Simulate network delay
            Thread.sleep(Duration.ofMillis(50));
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}

/**
 * Virtual Threads Summary:
 * 
 * Creation Methods:
 * 1. Thread.startVirtualThread(runnable)
 * 2. Thread.ofVirtual().start(runnable)
 * 3. Executors.newVirtualThreadPerTaskExecutor()
 * 4. Thread.ofVirtual().factory().newThread(runnable)
 * 
 * Key Characteristics:
 * - Lightweight (~1KB vs ~1MB for platform threads)
 * - Can create millions
 * - Managed by JVM, not OS
 * - Automatically scheduled on platform threads
 * - Cheap to create and destroy
 * - Blocking is OK!
 * 
 * When to Use:
 * ✓ I/O-bound operations
 * ✓ Network requests
 * ✓ Database queries
 * ✓ File operations
 * ✓ High-throughput servers
 * ✓ Microservices
 * 
 * When NOT to Use:
 * ✗ CPU-intensive calculations
 * ✗ Long-held synchronized blocks
 * ✗ Frequent native method calls
 * 
 * Benefits:
 * 1. Scale to millions of concurrent tasks
 * 2. Write simple sequential code
 * 3. No callback hell
 * 4. Better resource utilization
 * 5. Easier debugging and profiling
 * 6. Natural blocking without waste
 * 
 * Programming Model:
 * - Write synchronous code
 * - Block freely on I/O
 * - One thread per request/task
 * - No need for thread pools
 * - Structured concurrency for related tasks
 * 
 * Structured Concurrency:
 * - StructuredTaskScope groups related tasks
 * - Automatic cleanup on exit
 * - Failure handling
 * - Cancellation propagation
 * 
 * Best Practices:
 * 1. Don't pool virtual threads - create on demand
 * 2. Use for I/O-bound work
 * 3. Avoid synchronized - use ReentrantLock
 * 4. Monitor pinning with JVM flags
 * 5. Use structured concurrency for related tasks
 * 6. Keep simple sequential code
 * 7. Let virtual threads block
 * 
 * JVM Monitoring:
 * -Djdk.tracePinnedThreads=full
 * -Djdk.virtualThreadScheduler.parallelism=N
 * 
 * Practice:
 * - Build a web server with virtual threads
 * - Create a concurrent file processor
 * - Implement parallel API calls
 * - Compare performance with platform threads
 * - Use structured concurrency
 */
