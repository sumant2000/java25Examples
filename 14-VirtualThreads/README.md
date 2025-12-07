# Module 14: Virtual Threads (Java 21+) 🧵

## What are Virtual Threads?

Virtual Threads are lightweight threads that dramatically reduce the effort of writing, maintaining, and observing high-throughput concurrent applications. Introduced as a preview in Java 19-20 and finalized in Java 21.

## Key Concepts

### Platform Threads vs Virtual Threads

**Platform Threads (Traditional)**:
- Mapped 1:1 to OS threads
- Expensive to create and destroy
- Limited by OS resources
- Each thread consumes ~1MB of memory
- Context switching overhead

**Virtual Threads**:
- Lightweight, managed by JVM
- Can create millions of them
- Automatically scheduled on platform threads
- Small memory footprint (~1KB)
- Cheap to create and destroy

## Why Virtual Threads?

### The Problem
```java
// Traditional approach - limited scalability
ExecutorService executor = Executors.newFixedThreadPool(200);
for (int i = 0; i < 10000; i++) {
    executor.submit(() -> {
        // Handle request
    });
}
// Limited to thread pool size
```

### The Solution
```java
// With virtual threads - unlimited scalability
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 1_000_000; i++) {
        executor.submit(() -> {
            // Handle request
        });
    }
}
// Can handle millions of concurrent tasks
```

## Creating Virtual Threads

### Method 1: Thread.ofVirtual()
```java
Thread vThread = Thread.ofVirtual().start(() -> {
    System.out.println("Virtual thread");
});
```

### Method 2: Thread.startVirtualThread()
```java
Thread vThread = Thread.startVirtualThread(() -> {
    System.out.println("Virtual thread");
});
```

### Method 3: Virtual Thread Executor
```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> {
        System.out.println("Virtual thread");
    });
}
```

### Method 4: Thread Factory
```java
ThreadFactory factory = Thread.ofVirtual().factory();
Thread vThread = factory.newThread(() -> {
    System.out.println("Virtual thread");
});
vThread.start();
```

## Structured Concurrency (Java 21+)

### StructuredTaskScope
```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Future<String> user = scope.fork(() -> fetchUser());
    Future<Integer> order = scope.fork(() -> fetchOrder());
    
    scope.join();           // Wait for all
    scope.throwIfFailed();  // Handle failures
    
    String userData = user.resultNow();
    Integer orderData = order.resultNow();
}
```

## When to Use Virtual Threads

✓ **Good for:**
- I/O-bound tasks
- High-throughput applications
- Web servers
- Database connections
- Network requests
- Many concurrent tasks

✗ **Not ideal for:**
- CPU-intensive tasks
- Tasks that hold locks for long periods
- When pinning could occur frequently

## Pinning

Virtual threads can be "pinned" to platform threads in certain scenarios:
- **Synchronized blocks**: Can prevent unmounting
- **Native methods**: Keep thread pinned

### Avoiding Pinning
```java
// Instead of synchronized
synchronized (lock) {
    // code
}

// Use ReentrantLock
Lock lock = new ReentrantLock();
lock.lock();
try {
    // code
} finally {
    lock.unlock();
}
```

## Java 25 Status

Virtual threads are a **stable feature** in Java 25 with:
- Performance improvements
- Better monitoring and debugging tools
- Enhanced JVM optimizations
- Improved integration with Java ecosystem

## Benefits

1. **Scalability**: Handle millions of concurrent tasks
2. **Simplicity**: Write sequential-looking code
3. **Resource Efficiency**: Lower memory footprint
4. **Better Throughput**: More efficient use of CPU
5. **Easier to Reason About**: No callback hell
6. **Blocking is OK**: Can block without wasting resources

## Programming Model

### Before Virtual Threads (Reactive)
```java
CompletableFuture.supplyAsync(() -> fetchUser())
    .thenApply(user -> processUser(user))
    .thenCompose(data -> fetchOrders(data))
    .thenAccept(orders -> sendResponse(orders));
// Complex, hard to debug
```

### With Virtual Threads
```java
User user = fetchUser();           // Can block!
Data data = processUser(user);
Orders orders = fetchOrders(data);
sendResponse(orders);
// Simple, sequential, readable
```

## Best Practices

1. **Create many virtual threads** - Don't pool them
2. **Use structured concurrency** - For related tasks
3. **Avoid synchronized** - Prefer ReentrantLock
4. **Monitor pinning** - Use JVM flags
5. **Keep blocking** - Don't convert to async
6. **Test at scale** - Virtual threads shine with many tasks
7. **Use thread-per-request** - Natural model

## Monitoring Virtual Threads

### JVM Flags
```bash
-Djdk.tracePinnedThreads=full
-Djdk.virtualThreadScheduler.parallelism=N
-Djdk.virtualThreadScheduler.maxPoolSize=N
```

## Examples in This Module

1. `VirtualThreadBasics.java` - Creating and using virtual threads
2. `VirtualThreadPerformance.java` - Comparing with platform threads
3. `StructuredConcurrency.java` - Using StructuredTaskScope
4. `WebServerExample.java` - HTTP server with virtual threads
5. `DatabaseConnections.java` - Database operations
6. `ThreadPinning.java` - Understanding and avoiding pinning
7. `RealWorldExamples.java` - Practical use cases

## Practice Exercises

1. Convert thread pool code to virtual threads
2. Build a concurrent web scraper
3. Implement parallel file processing
4. Create a chat server using virtual threads
5. Compare performance: platform vs virtual threads
6. Use structured concurrency for related tasks

---

**Next Module**: [15-ModernAPIs](../15-ModernAPIs/README.md) - Modern Java APIs and features
