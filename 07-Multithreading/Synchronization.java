/**
 * Synchronization.java
 *
 * This program demonstrates thread synchronization in Java - protecting shared
 * resources from concurrent access issues. Covers synchronized methods, synchronized
 * blocks, and various synchronization scenarios.
 *
 * Key Concepts:
 * - Race conditions and why synchronization is needed
 * - synchronized keyword (methods and blocks)
 * - Intrinsic locks (monitors)
 * - Object-level vs class-level synchronization
 * - Reentrancy
 * - Best practices for synchronization
 *
 * Java Features Used: Java 8+ (Lambda expressions)
 */

public class Synchronization {

    public static void main(String[] args) {

        System.out.println("========== SYNCHRONIZATION DEMONSTRATION ==========\n");

        // ========== RACE CONDITION PROBLEM ==========

        System.out.println("--- 1. Race Condition Problem (Without Synchronization) ---\n");

        UnsafeCounter unsafeCounter = new UnsafeCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Expected count: 2000");
        System.out.println("Actual count: " + unsafeCounter.getCount());
        System.out.println("Problem: Race condition caused incorrect result!\n");


        // ========== SYNCHRONIZED METHOD SOLUTION ==========

        System.out.println("\n--- 2. Synchronized Method Solution ---\n");

        SafeCounter safeCounter = new SafeCounter();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        }, "Thread-3");

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        }, "Thread-4");

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Expected count: 2000");
        System.out.println("Actual count: " + safeCounter.getCount());
        System.out.println("Success: Synchronized method protected the counter!\n");


        // ========== SYNCHRONIZED BLOCK ==========

        System.out.println("\n--- 3. Synchronized Block ---\n");

        BlockSyncCounter blockCounter = new BlockSyncCounter();

        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                blockCounter.increment();
            }
        }, "Thread-5");

        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                blockCounter.increment();
            }
        }, "Thread-6");

        t5.start();
        t6.start();

        try {
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Synchronized block result: " + blockCounter.getCount());
        System.out.println("✓ Synchronized block provides fine-grained locking\n");


        // ========== STATIC SYNCHRONIZATION ==========

        System.out.println("\n--- 4. Static Synchronization (Class-Level Lock) ---\n");

        Thread t7 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                StaticCounter.increment();
            }
        }, "Static-Thread-1");

        Thread t8 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                StaticCounter.increment();
            }
        }, "Static-Thread-2");

        t7.start();
        t8.start();

        try {
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Static counter result: " + StaticCounter.getCount());
        System.out.println("✓ Static synchronized method uses class-level lock\n");


        // ========== SYNCHRONIZED ON DIFFERENT OBJECTS ==========

        System.out.println("\n--- 5. Synchronizing on Different Objects ---\n");

        TwoCounters twoCounters = new TwoCounters();

        Thread tc1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                twoCounters.incrementCounter1();
            }
        }, "Counter1-Thread");

        Thread tc2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                twoCounters.incrementCounter2();
            }
        }, "Counter2-Thread");

        tc1.start();
        tc2.start();

        try {
            tc1.join();
            tc2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Counter1: " + twoCounters.getCounter1());
        System.out.println("Counter2: " + twoCounters.getCounter2());
        System.out.println("✓ Different locks allow parallel execution\n");


        // ========== BANK ACCOUNT EXAMPLE ==========

        System.out.println("\n--- 6. Practical Example: Bank Account ---\n");

        BankAccount account = new BankAccount(1000);
        System.out.println("Initial balance: $" + account.getBalance());

        Thread depositor = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Depositor");

        Thread withdrawer = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(150);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Withdrawer");

        depositor.start();
        withdrawer.start();

        try {
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance: $" + account.getBalance());
        System.out.println("Expected: $1000 + $500 - $450 = $1050");


        // ========== REENTRANCY DEMONSTRATION ==========

        System.out.println("\n\n--- 7. Reentrancy (Recursive Locking) ---\n");

        ReentrantExample reentrant = new ReentrantExample();
        reentrant.outerMethod();
        System.out.println("✓ Thread can reacquire lock it already owns\n");


        // ========== SYNCHRONIZED WAIT TIME ==========

        System.out.println("\n--- 8. Performance Impact ---\n");

        PerformanceTest perfTest = new PerformanceTest();

        long startTime = System.nanoTime();
        Thread p1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                perfTest.synchronizedMethod();
            }
        });
        Thread p2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                perfTest.synchronizedMethod();
            }
        });

        p1.start();
        p2.start();

        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;

        System.out.println("Time with synchronization: " + duration + "ms");
        System.out.println("Note: Synchronization has overhead but ensures correctness\n");


        // ========== DEADLOCK SCENARIO ==========

        System.out.println("\n--- 9. Deadlock Risk (Demonstration) ---\n");

        System.out.println("Deadlock can occur with nested synchronization");
        System.out.println("See Deadlock.java for detailed examples");
        System.out.println("Prevention: Always acquire locks in same order\n");


        // ========== BEST PRACTICES ==========

        System.out.println("\n--- 10. Synchronization Best Practices ---\n");

        System.out.println("✓ Synchronize only critical sections (minimize scope)");
        System.out.println("✓ Use private lock objects for fine-grained control");
        System.out.println("✓ Avoid synchronizing on public objects");
        System.out.println("✓ Keep synchronized blocks short");
        System.out.println("✓ Don't call unknown methods while holding lock");
        System.out.println("✓ Document thread-safety guarantees");
        System.out.println("✓ Consider using java.util.concurrent classes");
        System.out.println("✓ Use immutable objects when possible");


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER CLASSES ==========

    /**
     * Unsafe counter - demonstrates race condition
     */
    static class UnsafeCounter {
        private int count = 0;

        // NOT synchronized - multiple threads can execute simultaneously
        public void increment() {
            count++; // This is actually three operations: read, increment, write
        }

        public int getCount() {
            return count;
        }
    }

    /**
     * Safe counter using synchronized method
     */
    static class SafeCounter {
        private int count = 0;

        // Synchronized - only one thread can execute at a time
        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    /**
     * Counter using synchronized block for fine-grained locking
     */
    static class BlockSyncCounter {
        private int count = 0;
        private final Object lock = new Object(); // Private lock object

        public void increment() {
            // Non-critical code can run in parallel
            Thread current = Thread.currentThread();

            // Only critical section is synchronized
            synchronized (lock) {
                count++;
            }

            // More non-critical code
        }

        public int getCount() {
            synchronized (lock) {
                return count;
            }
        }
    }

    /**
     * Static synchronization - class-level lock
     */
    static class StaticCounter {
        private static int count = 0;

        // Synchronized on the class object (StaticCounter.class)
        public static synchronized void increment() {
            count++;
        }

        public static synchronized int getCount() {
            return count;
        }
    }

    /**
     * Two counters with separate locks for parallel execution
     */
    static class TwoCounters {
        private int counter1 = 0;
        private int counter2 = 0;
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void incrementCounter1() {
            synchronized (lock1) {
                counter1++;
            }
        }

        public void incrementCounter2() {
            synchronized (lock2) {
                counter2++;
            }
        }

        public int getCounter1() {
            synchronized (lock1) {
                return counter1;
            }
        }

        public int getCounter2() {
            synchronized (lock2) {
                return counter2;
            }
        }
    }

    /**
     * Thread-safe bank account
     */
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public synchronized void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println(Thread.currentThread().getName() +
                                 " deposited $" + amount +
                                 " | Balance: $" + balance);
            }
        }

        public synchronized void withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() +
                                 " withdrew $" + amount +
                                 " | Balance: $" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() +
                                 " - Insufficient funds");
            }
        }

        public synchronized double getBalance() {
            return balance;
        }
    }

    /**
     * Demonstrates reentrancy - thread can reacquire lock it owns
     */
    static class ReentrantExample {
        public synchronized void outerMethod() {
            System.out.println("In outer synchronized method");
            innerMethod(); // Can call another synchronized method
        }

        public synchronized void innerMethod() {
            System.out.println("In inner synchronized method");
            System.out.println("Same thread reacquired the lock (reentrant)");
        }
    }

    /**
     * Performance testing
     */
    static class PerformanceTest {
        private int value = 0;

        public synchronized void synchronizedMethod() {
            value++;
        }
    }
}

/*
 * SYNCHRONIZATION QUICK REFERENCE:
 *
 * SYNCHRONIZED METHOD:
 * public synchronized void method() {
 *     // Thread-safe code
 * }
 * // Lock: this object
 *
 * SYNCHRONIZED BLOCK:
 * synchronized(lock) {
 *     // Thread-safe code
 * }
 * // Lock: specified object
 *
 * STATIC SYNCHRONIZED:
 * public static synchronized void method() {
 *     // Thread-safe code
 * }
 * // Lock: Class object
 *
 * WHEN TO SYNCHRONIZE:
 * ✓ Multiple threads access shared mutable data
 * ✓ At least one thread modifies the data
 * ✓ Need to prevent race conditions
 *
 * WHAT SYNCHRONIZED DOES:
 * 1. Acquires intrinsic lock (monitor)
 * 2. Executes the code
 * 3. Releases the lock
 * 4. Only one thread can hold lock at a time
 *
 * LOCK TYPES:
 * Instance Lock:    synchronized(this) or synchronized method
 * Class Lock:       synchronized(ClassName.class) or static synchronized
 * Custom Lock:      synchronized(lockObject)
 *
 * RACE CONDITION:
 * - Occurs when multiple threads access shared data
 * - At least one thread modifies the data
 * - Result depends on thread scheduling (non-deterministic)
 * - Solution: Synchronization
 *
 * CRITICAL SECTION:
 * - Code that accesses shared resources
 * - Must be protected by synchronization
 * - Should be as small as possible
 *
 * BEST PRACTICES:
 * ✓ Minimize scope of synchronized blocks
 * ✓ Use private lock objects
 * ✓ Avoid nested synchronization (deadlock risk)
 * ✓ Don't synchronize on public objects
 * ✓ Keep critical sections short
 * ✓ Don't call unknown code while holding lock
 * ✓ Document thread-safety requirements
 *
 * PERFORMANCE TIPS:
 * ✓ Synchronize only when necessary
 * ✓ Use fine-grained locking (multiple locks)
 * ✓ Consider lock-free alternatives (atomic variables)
 * ✓ Use concurrent collections
 * ✓ Profile before optimizing
 *
 * ALTERNATIVES TO SYNCHRONIZED:
 * - AtomicInteger, AtomicLong, etc.
 * - ReentrantLock (more flexible)
 * - ReadWriteLock (optimize reads)
 * - ConcurrentHashMap, CopyOnWriteArrayList
 * - ThreadLocal (thread-isolated data)
 *
 * COMMON MISTAKES:
 * ✗ Not synchronizing all access to shared data
 * ✗ Synchronizing on different objects
 * ✗ Synchronizing too much (performance)
 * ✗ Synchronizing on literals or boxed primitives
 * ✗ Nested locks in different order (deadlock)
 *
 * SYNCHRONIZED vs VOLATILE:
 * synchronized:  Mutual exclusion + visibility
 * volatile:      Visibility only (no mutual exclusion)
 *
 * HAPPENS-BEFORE GUARANTEE:
 * - Release of lock happens-before acquire of same lock
 * - Ensures visibility of changes between threads
 *
 * INTRINSIC LOCK (MONITOR):
 * - Every object has an intrinsic lock
 * - Used by synchronized keyword
 * - Reentrant (same thread can reacquire)
 * - Released even if exception occurs
 *
 * HOW TO RUN:
 * javac Synchronization.java
 * java Synchronization
 *
 * NEXT TOPICS:
 * - ReentrantLock for advanced locking
 * - wait()/notify() for thread communication
 * - Concurrent collections
 * - Atomic variables
 * - Deadlock prevention
 */
