/**
 * ThreadBasics.java
 *
 * This program demonstrates the fundamentals of multithreading in Java.
 * It covers different ways to create and manage threads, basic thread operations,
 * and essential concepts for concurrent programming.
 *
 * Key Concepts:
 * - Creating threads (Thread class vs Runnable interface)
 * - Starting and running threads
 * - Thread methods (sleep, join, interrupt)
 * - Thread properties (name, priority, daemon)
 * - Lambda expressions for threads
 * - Thread vs Process
 *
 * Java Features Used: Java 8+ (Lambda expressions, method references)
 */

public class ThreadBasics {

    public static void main(String[] args) {

        System.out.println("========== THREAD BASICS DEMONSTRATION ==========\n");

        // ========== WHAT IS A THREAD? ==========

        System.out.println("--- 1. What is a Thread? ---\n");

        System.out.println("Thread: A lightweight unit of execution within a process");
        System.out.println("Process: An independent program with its own memory space");
        System.out.println("\nMain thread info:");
        Thread mainThread = Thread.currentThread();
        System.out.println("  Name: " + mainThread.getName());
        System.out.println("  Priority: " + mainThread.getPriority());
        System.out.println("  Thread ID: " + mainThread.threadId());
        System.out.println("  Is Alive: " + mainThread.isAlive());
        System.out.println("  Is Daemon: " + mainThread.isDaemon());


        // ========== METHOD 1: EXTENDING THREAD CLASS ==========

        System.out.println("\n\n--- 2. Creating Threads - Method 1: Extend Thread Class ---\n");

        MyThread thread1 = new MyThread("Thread-1");
        thread1.start(); // Start the thread

        try {
            Thread.sleep(100); // Give thread time to execute
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== METHOD 2: IMPLEMENTING RUNNABLE ==========

        System.out.println("\n--- 3. Creating Threads - Method 2: Implement Runnable ---\n");

        MyRunnable runnable = new MyRunnable("Runnable-1");
        Thread thread2 = new Thread(runnable);
        thread2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== METHOD 3: ANONYMOUS CLASS ==========

        System.out.println("\n--- 4. Creating Threads - Method 3: Anonymous Class ---\n");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous thread running: " + Thread.currentThread().getName());
                for (int i = 1; i <= 3; i++) {
                    System.out.println("  Anonymous count: " + i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        thread3.setName("Anonymous-Thread");
        thread3.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== METHOD 4: LAMBDA EXPRESSION ==========

        System.out.println("\n--- 5. Creating Threads - Method 4: Lambda Expression ---\n");

        Thread thread4 = new Thread(() -> {
            System.out.println("Lambda thread running: " + Thread.currentThread().getName());
            for (int i = 1; i <= 3; i++) {
                System.out.println("  Lambda count: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Lambda-Thread");
        thread4.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== THREAD SLEEP ==========

        System.out.println("\n\n--- 6. Thread.sleep() ---\n");

        System.out.println("Demonstrating sleep (pauses execution):");
        Thread sleepDemo = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("  Tick " + i);
                try {
                    Thread.sleep(500); // Sleep for 500ms
                } catch (InterruptedException e) {
                    System.out.println("  Thread interrupted during sleep");
                    Thread.currentThread().interrupt();
                }
            }
        }, "Sleep-Demo");
        sleepDemo.start();

        try {
            sleepDemo.join(); // Wait for sleepDemo to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== THREAD JOIN ==========

        System.out.println("\n\n--- 7. Thread.join() ---\n");

        System.out.println("Main thread waiting for worker thread to complete...");

        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Worker thread completed");
        }, "Worker-Thread");

        worker.start();

        try {
            worker.join(); // Main thread waits here
            System.out.println("Main thread continues after worker finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== THREAD PRIORITY ==========

        System.out.println("\n\n--- 8. Thread Priority ---\n");

        Thread lowPriority = new Thread(() -> {
            System.out.println("Low priority thread: " + Thread.currentThread().getPriority());
        }, "Low-Priority");
        lowPriority.setPriority(Thread.MIN_PRIORITY); // 1

        Thread normalPriority = new Thread(() -> {
            System.out.println("Normal priority thread: " + Thread.currentThread().getPriority());
        }, "Normal-Priority");
        normalPriority.setPriority(Thread.NORM_PRIORITY); // 5 (default)

        Thread highPriority = new Thread(() -> {
            System.out.println("High priority thread: " + Thread.currentThread().getPriority());
        }, "High-Priority");
        highPriority.setPriority(Thread.MAX_PRIORITY); // 10

        System.out.println("Priority range: MIN=" + Thread.MIN_PRIORITY +
                         ", NORM=" + Thread.NORM_PRIORITY +
                         ", MAX=" + Thread.MAX_PRIORITY);

        lowPriority.start();
        normalPriority.start();
        highPriority.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== DAEMON THREADS ==========

        System.out.println("\n\n--- 9. Daemon Threads ---\n");

        System.out.println("Daemon threads run in background and don't prevent JVM from exiting");

        Thread daemonThread = new Thread(() -> {
            System.out.println("Daemon thread started (will stop when main ends)");
            try {
                Thread.sleep(5000); // Long sleep
                System.out.println("Daemon thread finished"); // May not print
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Daemon-Thread");

        daemonThread.setDaemon(true); // Must be set before start()
        daemonThread.start();

        System.out.println("Daemon thread started. Main will exit soon.");
        System.out.println("Daemon status: " + daemonThread.isDaemon());


        // ========== THREAD INTERRUPTION ==========

        System.out.println("\n\n--- 10. Thread Interruption ---\n");

        Thread interruptibleThread = new Thread(() -> {
            System.out.println("Thread running, waiting for interrupt...");
            try {
                Thread.sleep(5000); // Long sleep
                System.out.println("Thread completed without interruption");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep!");
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        }, "Interruptible-Thread");

        interruptibleThread.start();

        try {
            Thread.sleep(500); // Let it start
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        interruptibleThread.interrupt(); // Interrupt the thread
        System.out.println("Sent interrupt signal to thread");

        try {
            interruptibleThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== MULTIPLE THREADS RUNNING CONCURRENTLY ==========

        System.out.println("\n\n--- 11. Multiple Threads Running Concurrently ---\n");

        System.out.println("Starting 5 threads concurrently:");

        for (int i = 1; i <= 5; i++) {
            final int threadNum = i;
            Thread t = new Thread(() -> {
                System.out.println("Thread-" + threadNum + " started");
                try {
                    Thread.sleep(100 * threadNum);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread-" + threadNum + " finished");
            }, "Concurrent-" + i);
            t.start();
        }

        try {
            Thread.sleep(600); // Wait for all to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== THREAD STATES ==========

        System.out.println("\n\n--- 12. Thread States ---\n");

        Thread stateDemo = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "State-Demo");

        System.out.println("Thread state before start: " + stateDemo.getState()); // NEW

        stateDemo.start();
        System.out.println("Thread state after start: " + stateDemo.getState()); // RUNNABLE

        try {
            Thread.sleep(50);
            System.out.println("Thread state while running: " + stateDemo.getState()); // TIMED_WAITING

            stateDemo.join();
            System.out.println("Thread state after completion: " + stateDemo.getState()); // TERMINATED
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== THREAD INFORMATION ==========

        System.out.println("\n\n--- 13. Thread Information ---\n");

        Thread infoThread = new Thread(() -> {
            Thread current = Thread.currentThread();
            System.out.println("Inside thread:");
            System.out.println("  ID: " + current.threadId());
            System.out.println("  Name: " + current.getName());
            System.out.println("  Priority: " + current.getPriority());
            System.out.println("  State: " + current.getState());
            System.out.println("  Is Daemon: " + current.isDaemon());
            System.out.println("  Is Alive: " + current.isAlive());
            System.out.println("  Thread Group: " + current.getThreadGroup().getName());
        }, "Info-Thread");

        infoThread.start();

        try {
            infoThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== PRACTICAL EXAMPLE: COUNTER ==========

        System.out.println("\n\n--- 14. Practical Example: Simple Counter ---\n");

        Counter counter = new Counter();

        Thread incrementer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
            System.out.println("Incrementer finished");
        }, "Incrementer");

        incrementer.start();

        try {
            incrementer.join();
            System.out.println("Final counter value: " + counter.getCount());
            System.out.println("Note: For thread-safe counter, use synchronization (next module)");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // ========== YIELDING ==========

        System.out.println("\n\n--- 15. Thread.yield() ---\n");

        System.out.println("yield() suggests thread scheduler to give chance to other threads");

        Thread yieldThread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread-1: " + i);
                Thread.yield(); // Hint to scheduler
            }
        }, "Yield-1");

        Thread yieldThread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread-2: " + i);
                Thread.yield(); // Hint to scheduler
            }
        }, "Yield-2");

        yieldThread1.start();
        yieldThread2.start();

        try {
            yieldThread1.join();
            yieldThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
        System.out.println("\nNote: Main thread exits, daemon threads will stop automatically.");
    }

    // ========== HELPER CLASSES ==========

    /**
     * Method 1: Extending Thread class
     */
    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("MyThread running: " + getName());
            for (int i = 1; i <= 5; i++) {
                System.out.println("  " + getName() + " count: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("MyThread finished: " + getName());
        }
    }

    /**
     * Method 2: Implementing Runnable interface (preferred)
     */
    static class MyRunnable implements Runnable {
        private final String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("MyRunnable running: " + name);
            for (int i = 1; i <= 5; i++) {
                System.out.println("  " + name + " count: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(name + " interrupted");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("MyRunnable finished: " + name);
        }
    }

    /**
     * Simple counter class (not thread-safe)
     */
    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}

/*
 * THREAD BASICS QUICK REFERENCE:
 *
 * CREATING THREADS:
 * 1. Extend Thread:
 *    class MyThread extends Thread {
 *        public void run() { }
 *    }
 *    new MyThread().start();
 *
 * 2. Implement Runnable (preferred):
 *    class MyRunnable implements Runnable {
 *        public void run() { }
 *    }
 *    new Thread(new MyRunnable()).start();
 *
 * 3. Lambda:
 *    new Thread(() -> { }).start();
 *
 * THREAD METHODS:
 * start()              - Start thread execution
 * run()                - Contains thread code (don't call directly!)
 * sleep(millis)        - Pause execution
 * join()               - Wait for thread to finish
 * join(millis)         - Wait with timeout
 * interrupt()          - Interrupt thread
 * isInterrupted()      - Check interrupt status
 * yield()              - Hint to scheduler to give up CPU
 *
 * THREAD PROPERTIES:
 * setName(name)        - Set thread name
 * getName()            - Get thread name
 * setPriority(p)       - Set priority (1-10)
 * getPriority()        - Get priority
 * setDaemon(boolean)   - Set daemon status (before start)
 * isDaemon()           - Check if daemon
 * getState()           - Get thread state
 * isAlive()            - Check if thread is running
 * threadId()           - Get unique thread ID (Java 19+)
 *
 * THREAD STATES:
 * NEW              - Created but not started
 * RUNNABLE         - Executing or ready to execute
 * BLOCKED          - Waiting for monitor lock
 * WAITING          - Waiting indefinitely
 * TIMED_WAITING    - Waiting with timeout
 * TERMINATED       - Execution finished
 *
 * THREAD PRIORITY:
 * Thread.MIN_PRIORITY   = 1
 * Thread.NORM_PRIORITY  = 5 (default)
 * Thread.MAX_PRIORITY   = 10
 *
 * BEST PRACTICES:
 * ✓ Implement Runnable instead of extending Thread
 * ✓ Give threads meaningful names
 * ✓ Always handle InterruptedException
 * ✓ Use join() to wait for thread completion
 * ✓ Set daemon threads before calling start()
 * ✓ Don't call run() directly - use start()
 * ✓ Don't start a thread twice
 * ✓ Restore interrupt status after catching InterruptedException
 *
 * COMMON MISTAKES:
 * ✗ Calling run() instead of start()
 * ✗ Starting thread twice
 * ✗ Ignoring InterruptedException
 * ✗ Using Thread.stop() (deprecated)
 * ✗ Not properly terminating threads
 *
 * DAEMON vs USER THREADS:
 * User Thread:    JVM waits for completion
 * Daemon Thread:  JVM exits without waiting
 *
 * WHEN TO USE THREADS:
 * ✓ I/O operations (file, network)
 * ✓ Background tasks
 * ✓ Parallel computation
 * ✓ Responsive UI
 * ✓ Server applications
 *
 * HOW TO RUN:
 * javac ThreadBasics.java
 * java ThreadBasics
 *
 * NEXT STEPS:
 * - Learn synchronization for thread-safe code
 * - Use ExecutorService for better thread management
 * - Study concurrent collections
 * - Explore CompletableFuture for async programming
 */
