# Module 9: Streams API 🌊

## What is the Stream API?

The Stream API (introduced in Java 8) provides a functional approach to processing collections of objects. It allows you to express complex data processing queries in a declarative way.

## Key Concepts

### 1. What is a Stream?
A stream is a sequence of elements supporting sequential and parallel aggregate operations. It's NOT a data structure but a view of data.

### 2. Stream Pipeline
A stream pipeline consists of:
- **Source**: Collection, array, I/O channel, generator function
- **Intermediate Operations**: Transform stream (lazy evaluation)
- **Terminal Operation**: Produces result or side-effect (triggers execution)

### 3. Stream Characteristics
- **Not a data structure**: Doesn't store elements
- **Functional**: Operations don't modify source
- **Lazy**: Intermediate operations are not executed until terminal operation
- **Possibly infinite**: Can represent infinite sequences
- **Consumable**: Can be traversed only once

## Stream Operations

### Intermediate Operations (Lazy)
- `filter(Predicate)` - Select elements
- `map(Function)` - Transform elements
- `flatMap(Function)` - Flatten nested structures
- `distinct()` - Remove duplicates
- `sorted()` - Sort elements
- `peek(Consumer)` - Perform action without modifying
- `limit(n)` - Truncate stream
- `skip(n)` - Skip elements

### Terminal Operations (Eager)
- `forEach(Consumer)` - Iterate over elements
- `collect(Collector)` - Accumulate to collection
- `reduce(BinaryOperator)` - Reduce to single value
- `count()` - Count elements
- `anyMatch(Predicate)` - Check if any match
- `allMatch(Predicate)` - Check if all match
- `noneMatch(Predicate)` - Check if none match
- `findFirst()` - Get first element
- `findAny()` - Get any element
- `min(Comparator)` - Find minimum
- `max(Comparator)` - Find maximum
- `toArray()` - Convert to array

## Creating Streams

```java
// From collection
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream1 = list.stream();

// From array
String[] array = {"a", "b", "c"};
Stream<String> stream2 = Arrays.stream(array);

// Using Stream.of()
Stream<String> stream3 = Stream.of("a", "b", "c");

// Empty stream
Stream<String> stream4 = Stream.empty();

// Infinite streams
Stream<Integer> stream5 = Stream.iterate(0, n -> n + 1);
Stream<Double> stream6 = Stream.generate(Math::random);

// From file
Stream<String> stream7 = Files.lines(Paths.get("file.txt"));
```

## Common Patterns

### Filter-Map-Collect
```java
List<String> result = list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

### Reduce
```java
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);
```

### Group By
```java
Map<Integer, List<String>> grouped = words.stream()
    .collect(Collectors.groupingBy(String::length));
```

## Collectors

Common collectors in `Collectors` class:
- `toList()` - Collect to List
- `toSet()` - Collect to Set
- `toMap()` - Collect to Map
- `joining()` - Concatenate strings
- `groupingBy()` - Group elements
- `partitioningBy()` - Partition into two groups
- `counting()` - Count elements
- `summingInt()` - Sum integers
- `averagingInt()` - Average of integers
- `maxBy()` / `minBy()` - Find max/min

## Parallel Streams

```java
// Sequential stream
long count1 = list.stream().count();

// Parallel stream
long count2 = list.parallelStream().count();
```

## Best Practices

1. **Use streams for readability** - When it makes code clearer
2. **Avoid side effects** - Keep operations pure
3. **Don't reuse streams** - Streams are single-use
4. **Be cautious with parallel** - Not always faster
5. **Prefer method references** - When applicable
6. **Use appropriate collectors** - Know your collection needs
7. **Limit stream size** - Infinite streams need limit/findFirst
8. **Handle exceptions properly** - Wrap in try-catch or use custom methods

## When to Use Streams

✓ **Use when:**
- Processing collections with multiple operations
- Need declarative, functional-style code
- Transforming or filtering data
- Aggregating data
- Working with large datasets (parallel processing)

✗ **Avoid when:**
- Simple iteration is clearer
- Need to modify elements in place
- Need index access frequently
- Breaking/continuing loops based on complex conditions
- Debugging is more important than elegance

## Performance Considerations

1. **Overhead**: Streams have overhead; for small collections, loops may be faster
2. **Parallel streams**: Beneficial for CPU-intensive operations on large datasets
3. **Lazy evaluation**: Intermediate operations are fused for efficiency
4. **Boxing**: Use primitive streams (IntStream, LongStream, DoubleStream) for primitives

## Examples in This Module

1. `StreamCreation.java` - Different ways to create streams
2. `IntermediateOperations.java` - Filter, map, flatMap, distinct, sorted
3. `TerminalOperations.java` - forEach, collect, reduce, count, find
4. `StreamCollectors.java` - Working with Collectors
5. `ParallelStreams.java` - Parallel processing with streams
6. `PrimitiveStreams.java` - IntStream, LongStream, DoubleStream
7. `AdvancedStreamOperations.java` - Complex stream patterns and techniques

## Practice Exercises

1. Filter and transform a list of objects
2. Group data by multiple criteria
3. Calculate statistics from a stream
4. Flatten nested collections
5. Implement custom collectors
6. Compare parallel vs sequential performance
7. Process file contents with streams

---

**Next Module**: [10-Advanced](../10-Advanced/README.md) - Advanced Java concepts
