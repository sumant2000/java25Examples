/**
 * Stream Creation - Different Ways to Create Streams
 * 
 * This program demonstrates various methods to create streams from
 * different sources including collections, arrays, files, and generators.
 */

import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

public class StreamCreation {
    
    public static void main(String[] args) {
        System.out.println("=== Stream Creation Methods ===\n");
        
        fromCollection();
        fromArray();
        usingStreamOf();
        usingStreamBuilder();
        infiniteStreams();
        primitiveStreams();
        fromOtherSources();
    }
    
    private static void fromCollection() {
        System.out.println("1. From Collections:");
        
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.println("   " + s));
        
        // Parallel stream from collection
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> parallelStream = set.parallelStream();
        System.out.print("   Parallel: ");
        parallelStream.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
    }
    
    private static void fromArray() {
        System.out.println("2. From Arrays:");
        
        String[] array = {"Java", "Python", "JavaScript"};
        
        // Method 1: Arrays.stream()
        Stream<String> stream1 = Arrays.stream(array);
        System.out.print("   Arrays.stream(): ");
        stream1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // Method 2: Stream.of() with array
        Stream<String> stream2 = Stream.of(array);
        System.out.print("   Stream.of(array): ");
        stream2.forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // Partial array
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream partialStream = Arrays.stream(numbers, 1, 4); // from index 1 to 3
        System.out.print("   Partial array: ");
        partialStream.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
    }
    
    private static void usingStreamOf() {
        System.out.println("3. Using Stream.of():");
        
        // Directly with elements
        Stream<String> stream1 = Stream.of("One", "Two", "Three");
        System.out.print("   Elements: ");
        stream1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // Single element
        Stream<String> stream2 = Stream.of("Single");
        System.out.print("   Single: ");
        stream2.forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // Empty stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("   Empty stream count: " + emptyStream.count());
        System.out.println();
    }
    
    private static void usingStreamBuilder() {
        System.out.println("4. Using Stream.Builder:");
        
        Stream.Builder<String> builder = Stream.builder();
        builder.add("A").add("B").add("C").add("D");
        Stream<String> stream = builder.build();
        
        System.out.print("   Built stream: ");
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
    }
    
    private static void infiniteStreams() {
        System.out.println("5. Infinite Streams:");
        
        // Stream.iterate() - sequential values
        System.out.print("   iterate(0, n+2): ");
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Stream.iterate() with condition (Java 9+)
        System.out.print("   iterate with limit: ");
        Stream.iterate(1, n -> n <= 20, n -> n * 2)
              .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Stream.generate() - using supplier
        System.out.print("   generate(random): ");
        Stream.generate(Math::random)
              .limit(5)
              .forEach(n -> System.out.printf("%.2f ", n));
        System.out.println();
        
        // Generate with custom supplier
        System.out.print("   generate(UUID): ");
        Stream.generate(() -> UUID.randomUUID().toString().substring(0, 8))
              .limit(3)
              .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
    }
    
    private static void primitiveStreams() {
        System.out.println("6. Primitive Streams:");
        
        // IntStream
        System.out.print("   IntStream range: ");
        IntStream.range(1, 6) // exclusive end
                 .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.print("   IntStream rangeClosed: ");
        IntStream.rangeClosed(1, 5) // inclusive end
                 .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // LongStream
        System.out.print("   LongStream: ");
        LongStream.of(100L, 200L, 300L)
                  .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // DoubleStream
        System.out.print("   DoubleStream: ");
        DoubleStream.of(1.1, 2.2, 3.3)
                    .forEach(n -> System.out.printf("%.1f ", n));
        System.out.println("\n");
    }
    
    private static void fromOtherSources() {
        System.out.println("7. From Other Sources:");
        
        // From String (chars)
        String text = "Hello";
        System.out.print("   String chars: ");
        text.chars()
            .mapToObj(c -> (char) c)
            .forEach(c -> System.out.print(c + " "));
        System.out.println();
        
        // Stream.concat() - combine streams
        Stream<String> stream1 = Stream.of("A", "B");
        Stream<String> stream2 = Stream.of("C", "D");
        Stream<String> combined = Stream.concat(stream1, stream2);
        System.out.print("   Concatenated: ");
        combined.forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // From Optional
        Optional<String> optional = Optional.of("Present");
        System.out.print("   From Optional: ");
        optional.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
