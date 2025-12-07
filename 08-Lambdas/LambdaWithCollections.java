/**
 * Lambda with Collections - Practical Usage
 * 
 * This program demonstrates how lambda expressions are commonly used
 * with Java Collections for sorting, filtering, and transforming data.
 */

import java.util.*;
import java.util.function.Predicate;

public class LambdaWithCollections {
    
    public static void main(String[] args) {
        System.out.println("=== Lambda Expressions with Collections ===\n");
        
        demonstrateSorting();
        demonstrateFiltering();
        demonstrateForEach();
        demonstrateReplaceAll();
        demonstrateRemoveIf();
        demonstrateComputeIfAbsent();
    }
    
    /**
     * Sorting collections with lambdas
     */
    private static void demonstrateSorting() {
        System.out.println("1. Sorting with Lambdas:");
        
        List<String> names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob", "David"));
        
        // Natural order
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println("   Natural order: " + names);
        
        // Reverse order
        names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob", "David"));
        Collections.sort(names, (s1, s2) -> s2.compareTo(s1));
        System.out.println("   Reverse order: " + names);
        
        // Sort by length
        names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob", "David"));
        names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("   By length: " + names);
        
        // Using Comparator.comparing (cleaner)
        names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob", "David"));
        names.sort(Comparator.comparing(String::length));
        System.out.println("   By length (Comparator): " + names);
        
        // Complex objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        );
        
        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println("   People by age: " + people);
        
        // Using Comparator.comparing
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("   People by name: " + people);
        
        System.out.println();
    }
    
    /**
     * Filtering with lambdas and removeIf
     */
    private static void demonstrateFiltering() {
        System.out.println("2. Filtering Collections:");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        // Traditional approach (pre-Java 8)
        List<Integer> evens = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        System.out.println("   Traditional even numbers: " + evens);
        
        // Using lambda with Stream (better approach - covered in Streams module)
        List<Integer> odds = new ArrayList<>();
        numbers.forEach(n -> {
            if (n % 2 != 0) {
                odds.add(n);
            }
        });
        System.out.println("   Odd numbers: " + odds);
        
        System.out.println();
    }
    
    /**
     * forEach with lambdas
     */
    private static void demonstrateForEach() {
        System.out.println("3. forEach with Lambdas:");
        
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        
        // Traditional for loop
        System.out.print("   Traditional: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // Lambda forEach
        System.out.print("   Lambda forEach: ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();
        
        // Method reference
        System.out.print("   Method reference: ");
        fruits.forEach(System.out::print);
        System.out.println();
        
        // With index (using traditional for with lambda-like syntax)
        System.out.println("   With index:");
        for (int i = 0; i < fruits.size(); i++) {
            final int index = i;
            System.out.println("      " + index + ": " + fruits.get(index));
        }
        
        // Map forEach
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        
        System.out.println("   Map forEach:");
        scores.forEach((name, score) -> 
            System.out.println("      " + name + ": " + score));
        
        System.out.println();
    }
    
    /**
     * replaceAll - Transform all elements
     */
    private static void demonstrateReplaceAll() {
        System.out.println("4. replaceAll - Transform Elements:");
        
        List<String> words = new ArrayList<>(Arrays.asList("hello", "world", "java"));
        
        System.out.println("   Original: " + words);
        
        // Convert all to uppercase
        words.replaceAll(s -> s.toUpperCase());
        System.out.println("   After toUpperCase: " + words);
        
        // Add prefix
        words.replaceAll(s -> ">> " + s);
        System.out.println("   After adding prefix: " + words);
        
        // Numbers example
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("   Original numbers: " + numbers);
        
        numbers.replaceAll(n -> n * n);
        System.out.println("   After squaring: " + numbers);
        
        System.out.println();
    }
    
    /**
     * removeIf - Remove elements based on condition
     */
    private static void demonstrateRemoveIf() {
        System.out.println("5. removeIf - Conditional Removal:");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("   Original: " + numbers);
        
        // Remove even numbers
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("   After removing evens: " + numbers);
        
        // String example
        List<String> words = new ArrayList<>(Arrays.asList("", "hello", "", "world", "java", ""));
        System.out.println("   Original words: " + words);
        
        // Remove empty strings
        words.removeIf(String::isEmpty);
        System.out.println("   After removing empty: " + words);
        
        // Remove by length
        List<String> names = new ArrayList<>(Arrays.asList("Al", "Bob", "Charlie", "David", "Eve"));
        System.out.println("   Original names: " + names);
        
        names.removeIf(name -> name.length() > 3);
        System.out.println("   After removing long names: " + names);
        
        System.out.println();
    }
    
    /**
     * computeIfAbsent - Smart map operations
     */
    private static void demonstrateComputeIfAbsent() {
        System.out.println("6. Map Operations with Lambdas:");
        
        Map<String, List<String>> groups = new HashMap<>();
        
        // Traditional approach
        if (!groups.containsKey("A")) {
            groups.put("A", new ArrayList<>());
        }
        groups.get("A").add("Alice");
        
        // Using computeIfAbsent (much cleaner)
        groups.computeIfAbsent("A", k -> new ArrayList<>()).add("Andrew");
        groups.computeIfAbsent("B", k -> new ArrayList<>()).add("Bob");
        groups.computeIfAbsent("B", k -> new ArrayList<>()).add("Betty");
        groups.computeIfAbsent("C", k -> new ArrayList<>()).add("Charlie");
        
        System.out.println("   Groups: " + groups);
        
        // merge - Combining values
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apple", 5);
        inventory.put("Banana", 3);
        
        // Add more apples
        inventory.merge("Apple", 3, (old, new_val) -> old + new_val);
        // Add oranges
        inventory.merge("Orange", 4, (old, new_val) -> old + new_val);
        
        System.out.println("   Inventory: " + inventory);
        
        System.out.println();
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

/**
 * Key Collection Methods with Lambda Support:
 * 
 * List Operations:
 * - sort((a, b) -> ...)          : Sort with custom comparator
 * - forEach(item -> ...)         : Iterate over elements
 * - replaceAll(item -> ...)      : Transform all elements
 * - removeIf(item -> ...)        : Remove matching elements
 * 
 * Map Operations:
 * - forEach((k, v) -> ...)       : Iterate over entries
 * - computeIfAbsent(key, k -> ...): Compute value if key absent
 * - computeIfPresent(key, (k, v) -> ...): Update existing value
 * - merge(key, value, (old, new) -> ...): Merge values
 * - replaceAll((k, v) -> ...)    : Transform all values
 * 
 * Comparator Methods:
 * - Comparator.comparing(Class::method)
 * - Comparator.comparingInt(Class::method)
 * - .thenComparing(Class::method) : Secondary sort
 * - .reversed()                    : Reverse order
 * 
 * Practice:
 * - Sort a list of custom objects by multiple fields
 * - Use removeIf to clean data
 * - Build a word frequency map using computeIfAbsent
 * - Transform collections using replaceAll
 */
