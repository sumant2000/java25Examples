# Module 7: Multithreading & Concurrency 🧵

Welcome to Module 7! Here you'll learn how to write concurrent programs in Java, enabling your applications to perform multiple tasks simultaneously and utilize multi-core processors effectively.

## 📖 Topics Covered

1. **Thread Basics** - Creating and managing threads
2. **Thread Lifecycle** - Understanding thread states
3. **Synchronization** - Protecting shared data
4. **Thread Communication** - wait(), notify(), notifyAll()
5. **Locks & Conditions** - Advanced synchronization
6. **Thread Pools** - Executor framework
7. **Concurrent Collections** - Thread-safe data structures
8. **Atomic Variables** - Lock-free thread safety
9. **CompletableFuture** - Asynchronous programming
10. **Parallel Streams** - Data parallelism
11. **Virtual Threads** - Lightweight threads (Java 21+)
12. **Common Concurrency Problems** - Deadlock, race conditions

## 🎯 Learning Objectives

By the end of this module, you will:
- Create and manage threads effectively
- Understand thread synchronization and race conditions
- Use locks and concurrent collections
- Implement thread pools with ExecutorService
- Write asynchronous code with CompletableFuture
- Use atomic variables for lock-free concurrency
- Understand and prevent deadlocks
- Use Virtual Threads (Java 21+)
- Apply parallel processing with streams
- Build thread-safe applications
- Choose appropriate concurrency tools
- Handle concurrent exceptions

## 📝 Programs in This Module

### 1. ThreadBasics.java
Introduction to threads - creation and basic operations.

**Concepts**: Thread class, Runnable interface, start(), run(), sleep(), join()

### 2. ThreadLifecycle.java
Understanding thread states and lifecycle.

**Concepts**: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED

### 3. Synchronization.java
Protecting shared resources with synchronized keyword.

**Concepts**: synchronized methods, synchronized blocks, intrinsic locks, race conditions

### 4. ThreadCommunication.java
Inter-thread communication using wait/notify.

**Concepts**: wait(), notify(), notifyAll(), producer-consumer pattern

### 5. Deadlock.java
Understanding and preventing deadlocks.

**Concepts**: Deadlock conditions, detection, prevention strategies, lock ordering

### 6. ReentrantLocks.java
Advanced locking with ReentrantLock.

**Concepts**: ReentrantLock, tryLock(), lock conditions, fairness policy

### 7. ExecutorService.java
Thread pools and task execution framework.

**Concepts**: ExecutorService, ThreadPoolExecutor, Callable, Future, scheduled tasks

### 8. ConcurrentCollections.java
Thread-safe collections from java.util.concurrent.

**Concepts**: ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue, ConcurrentLinkedQueue

### 9. AtomicVariables.java
Lock-free thread-safe operations.

**Concepts**: AtomicInteger, AtomicLong, AtomicReference, compareAndSet()

### 10. CompletableFutureDemo.java
Asynchronous programming with CompletableFuture.

**Concepts**: supplyAsync(), thenApply(), thenCompose(), handle(), allOf(), anyOf()

### 11. VirtualThreads.java
Lightweight threads introduced in Java 21.

**Concepts**: Virtual threads, platform threads, structured concurrency

### 12. ParallelStreams.java
Parallel data processing with streams.

**Concepts**: parallelStream(), parallel(), fork-join framework, performance considerations

## 💡 Key Concepts

### Thread vs Process

**Process**:
- Independent execution unit
- Own memory space
- Heavy-weight
- Inter-process communication is complex

**Thread**:
- Lightweight execution unit within a process
- Shares memory with other threads
- Light-weight
- Easy communication through shared memory

### Thread Creation Methods

```java
// Method 1: Extend Thread class
class MyThread extends Thread {
    public void run() {
        // Thread code
    }
}
new MyThread().start();

// Method 2: Implement Runnable
class MyRunnable implements Runnable {
    public void run() {
        // Thread code
    }
}
new Thread(new MyRunnable()).start();

// Method 3: Lambda expression (Java 8+)
new Thread(() -> {
    // Thread code
}).start();

// Method 4: ExecutorService
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(() -> {
    // Thread code
});

// Method 5: Virtual Threads (Java 21+)
Thread.startVirtualThread(() -> {
    // Thread code
});
```

### Thread States

```
NEW → Created but not started
  ↓ start()
RUNNABLE → Executing or ready to execute
  ↓ synchronized/lock
BLOCKED → Waiting for monitor lock
  ↓ wait()
WAITING → Waiting indefinitely for another thread
  ↓ sleep()/wait(timeout)
TIMED_WAITING → Waiting for specified time
  ↓ run() completes
TERMINATED → Execution finished
```

### Synchronization Mechanisms

| Mechanism | Use Case | Performance | Complexity |
|-----------|----------|-------------|------------|
| **synchronized** | Simple protection | Medium | Low |
| **ReentrantLock** | Advanced locking | Medium | Medium |
| **ReadWriteLock** | Many reads, few writes | High | Medium |
| **Semaphore** | Resource pooling | Medium | Medium |
| **CountDownLatch** | Wait for events | High | Low |
| **CyclicBarrier** | Synchronize threads | High | Low |
| **Atomic variables** | Simple counters | Very High | Low |

### Concurrent Collections

| Classic Collection | Thread-Safe Alternative | Best For |
|-------------------|------------------------|----------|
| HashMap | ConcurrentHashMap | High concurrency |
| ArrayList | CopyOnWriteArrayList | Read-heavy operations |
| LinkedList | ConcurrentLinkedQueue | Non-blocking queue |
| HashSet | ConcurrentHashMap.newKeySet() | Concurrent sets |
| TreeMap | ConcurrentSkipListMap | Sorted concurrent map |
| PriorityQueue | PriorityBlockingQueue | Producer-consumer |

## 🔍 Common Concurrency Problems

### 1. Race Condition
**Problem**: Multiple threads accessing shared data without synchronization.

```java
// UNSAFE
class Counter {
    private int count = 0;
    void increment() { count++; } // Race condition!
}

// SAFE
class Counter {
    private int count = 0;
    synchronized void increment() { count++; }
}
```

### 2. Deadlock
**Problem**: Two or more threads waiting for each other forever.

```java
// DEADLOCK SCENARIO
synchronized(lock1) {
    synchronized(lock2) { } // Thread 1
}
synchronized(lock2) {
    synchronized(lock1) { } // Thread 2 - DEADLOCK!
}

// SOLUTION: Lock ordering
synchronized(lock1) {
    synchronized(lock2) { } // Always acquire locks in same order
}
```

### 3. Livelock
**Problem**: Threads keep responding to each other without progress.

### 4. Starvation
**Problem**: Thread never gets CPU time due to priority issues.

### 5. Thread Leaks
**Problem**: Threads not properly terminated, consuming resources.

## 🎓 Practice Exercises

### Exercise 1: Multi-threaded Counter
Create a program that:
- Has 10 threads incrementing a shared counter
- Each thread increments 1000 times
- Final count should be 10,000
- Ensure thread safety

### Exercise 2: Producer-Consumer
Implement producer-consumer pattern:
- Producer adds items to queue
- Consumer removes items
- Use BlockingQueue
- Multiple producers and consumers

### Exercise 3: Download Manager
Build a multi-threaded download manager:
- Download multiple files concurrently
- Show progress for each download
- Use thread pool
- Handle errors gracefully

### Exercise 4: Web Crawler
Create a concurrent web crawler:
- Visit URLs in parallel
- Extract links from pages
- Avoid duplicate URLs
- Limit concurrent requests

### Exercise 5: Parallel File Processor
Process multiple files concurrently:
- Read files in parallel
- Process content (word count, etc.)
- Aggregate results
- Use CompletableFuture

### Exercise 6: Bank Transfer System
Simulate concurrent bank transfers:
- Multiple threads transferring money
- Ensure no money is lost or created
- Prevent deadlocks
- Maintain consistency

### Exercise 7: Cache with Expiration
Implement thread-safe cache:
- Put and get operations
- Automatic expiration
- Concurrent access
- Use ConcurrentHashMap

### Exercise 8: Thread-Safe Singleton
Create different singleton patterns:
- Eager initialization
- Lazy initialization with synchronization
- Double-checked locking
- Bill Pugh Singleton

### Exercise 9: Fork-Join Task
Implement recursive task:
- Array sum using fork-join
- Compare with sequential
- Measure performance
- Find optimal threshold

### Exercise 10: Chat Server
Build simple chat server:
- Multiple clients
- Broadcast messages
- Thread per client
- Graceful shutdown

## 🐛 Common Mistakes to Avoid

1. **Starting thread twice**
   ```java
   // ❌ Wrong
   Thread t = new Thread(() -> {});
   t.start();
   t.start(); // IllegalThreadStateException
   
   // ✅ Correct
   Thread t = new Thread(() -> {});
   t.start(); // Start only once
   ```

2. **Calling run() instead of start()**
   ```java
   // ❌ Wrong - runs in current thread
   thread.run();
   
   // ✅ Correct - runs in new thread
   thread.start();
   ```

3. **Synchronizing on wrong object**
   ```java
   // ❌ Wrong - synchronizes on different objects
   synchronized(new Object()) { } // Different lock each time!
   
   // ✅ Correct - synchronize on same object
   private final Object lock = new Object();
   synchronized(lock) { }
   ```

4. **Not handling InterruptedException**
   ```java
   // ❌ Wrong - swallows exception
   try {
       Thread.sleep(1000);
   } catch (InterruptedException e) {
       // Empty catch
   }
   
   // ✅ Correct - restore interrupt status
   try {
       Thread.sleep(1000);
   } catch (InterruptedException e) {
       Thread.currentThread().interrupt();
       throw new RuntimeException(e);
   }
   ```

5. **Using Thread.stop()**
   ```java
   // ❌ Wrong - deprecated and unsafe
   thread.stop();
   
   // ✅ Correct - use interrupt
   thread.interrupt();
   ```

6. **Forgetting to shutdown ExecutorService**
   ```java
   // ❌ Wrong - executor keeps running
   ExecutorService executor = Executors.newFixedThreadPool(10);
   executor.submit(() -> {});
   
   // ✅ Correct - shutdown executor
   executor.shutdown();
   ```

## 💎 Best Practices

### 1. Prefer High-Level Concurrency Utilities
```java
// Instead of raw threads
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(() -> {});
```

### 2. Use Immutable Objects
```java
final class ImmutablePoint {
    private final int x, y;
    // No setters - thread-safe by design
}
```

### 3. Minimize Synchronized Scope
```java
// ❌ Synchronized entire method
synchronized void method() {
    // Non-critical code
    // Critical code
}

// ✅ Synchronized only critical section
void method() {
    // Non-critical code
    synchronized(lock) {
        // Critical code
    }
}
```

### 4. Use Concurrent Collections
```java
// Instead of synchronized wrapper
Map<String, String> map = new ConcurrentHashMap<>();
```

### 5. Document Thread Safety
```java
/**
 * This class is thread-safe.
 * All public methods are synchronized.
 */
public class ThreadSafeClass {
    // ...
}
```

### 6. Avoid Shared Mutable State
```java
// Prefer thread-local or immutable objects
ThreadLocal<SimpleDateFormat> formatter = 
    ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
```

### 7. Use Atomic Variables for Simple Cases
```java
// Instead of synchronized counter
AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();
```

### 8. Always Close ExecutorService
```java
ExecutorService executor = Executors.newFixedThreadPool(10);
try {
    // Submit tasks
} finally {
    executor.shutdown();
}
```

## 📊 Performance Considerations

### When to Use Multithreading

**Good Use Cases**:
- I/O operations (file, network, database)
- Independent tasks
- CPU-intensive operations on multi-core
- Background tasks
- Event handling

**Bad Use Cases**:
- Very short tasks (overhead > benefit)
- Sequential dependencies
- Single-core systems for CPU tasks
- Simple operations

### Thread Pool Sizing

```java
// CPU-intensive tasks
int cores = Runtime.getRuntime().availableProcessors();
ExecutorService executor = Executors.newFixedThreadPool(cores);

// I/O-intensive tasks
ExecutorService executor = Executors.newFixedThreadPool(cores * 2);

// Bounded queue to prevent memory issues
ThreadPoolExecutor executor = new ThreadPoolExecutor(
    corePoolSize, maxPoolSize, keepAliveTime,
    TimeUnit.SECONDS, new LinkedBlockingQueue<>(100)
);
```

## 🔗 What's Next?

After mastering multithreading, you'll move on to:
- **Module 8: Lambda Expressions** - Functional programming
- Advanced concurrency patterns in Module 10

## 📖 Additional Resources

- [Java Concurrency in Practice (Book)](https://jcip.net/)
- [Java Concurrency Tutorial (Oracle)](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [java.util.concurrent Package](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/package-summary.html)
- [Virtual Threads (JEP 444)](https://openjdk.org/jeps/444)
- [Brian Goetz on Concurrency](https://www.ibm.com/developerworks/library/j-jtp/)

## 💡 Pro Tips

1. **Start simple** - Begin with ExecutorService before raw threads
2. **Avoid premature optimization** - Single-threaded first, then parallelize
3. **Test with different thread counts** - Find optimal configuration
4. **Use profiling tools** - VisualVM, JProfiler, async-profiler
5. **Monitor thread pools** - Watch queue size and rejection policy
6. **Consider Virtual Threads** - For high-concurrency I/O (Java 21+)
7. **Use structured concurrency** - Keep thread lifecycle manageable
8. **Prefer immutability** - Thread-safe by design
9. **Document thread safety** - Make requirements clear
10. **Test under load** - Concurrency bugs appear under stress

## 🎭 Concurrency Patterns

### 1. Producer-Consumer
```java
BlockingQueue<Task> queue = new ArrayBlockingQueue<>(100);
// Producer adds, Consumer takes
```

### 2. Fork-Join
```java
ForkJoinPool pool = new ForkJoinPool();
pool.invoke(new RecursiveTask());
```

### 3. Master-Worker
```java
ExecutorService workers = Executors.newFixedThreadPool(10);
// Master distributes work to workers
```

### 4. Pipeline
```java
// Stage 1 → Stage 2 → Stage 3
// Each stage runs in separate thread
```

### 5. Thread-Local Storage
```java
ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();
```

## 📋 Concurrency Checklist

Before writing concurrent code:
- [ ] Is multithreading necessary?
- [ ] Can I use immutable objects?
- [ ] What is the shared mutable state?
- [ ] How will I protect shared state?
- [ ] Can I use concurrent collections?
- [ ] What is the appropriate thread pool size?
- [ ] How will I handle exceptions?
- [ ] How will I test for race conditions?
- [ ] Can deadlock occur?
- [ ] How will I shutdown gracefully?

## 🔒 Thread Safety Levels

1. **Immutable**: Always thread-safe (String, Integer)
2. **Thread-Safe**: Safe for concurrent use (ConcurrentHashMap)
3. **Conditionally Thread-Safe**: Some methods safe (Collections.synchronized*)
4. **Not Thread-Safe**: Requires external synchronization (ArrayList, HashMap)
5. **Thread-Hostile**: Cannot be made safe (rare)

## 🌟 Java 21 Features

### Virtual Threads
```java
// Old way - platform threads (expensive)
Thread.ofPlatform().start(() -> {});

// New way - virtual threads (lightweight)
Thread.ofVirtual().start(() -> {});
```

### Structured Concurrency (Preview)
```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Future<String> user = scope.fork(() -> findUser());
    Future<Integer> order = scope.fork(() -> fetchOrder());
    scope.join();
    // Use results
}
```

---

**Ready to master concurrent programming? Start with ThreadBasics.java!** 🚀

**Estimated Time**: 5-7 days | **Difficulty**: ⭐⭐⭐⭐ Advanced