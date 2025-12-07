/**
 * Method References - Shorthand for Lambda Expressions
 * 
 * Method references are a compact way to refer to methods without executing them.
 * They're essentially syntactic sugar for lambda expressions that simply call a method.
 * 
 * Syntax: ClassName::methodName or object::methodName
 */

import java.util.*;
import java.util.function.*;

public class MethodReferences {
    
    public static void main(String[] args) {
        System.out.println("=== Method References ===\n");
        
        demonstrateStaticMethodReference();
        demonstrateInstanceMethodReference();
        demonstrateArbitraryObjectMethodReference();
        demonstrateConstructorReference();
        demonstrateComparison();
    }
    
    /**
     * Type 1: Reference to a Static Method
     * Syntax: ClassName::staticMethodName
     */
    private static void demonstrateStaticMethodReference() {
        System.out.println("1. Static Method Reference:");
        
        // Lambda expression
        Function<String, Integer> parser1 = s -> Integer.parseInt(s);
        System.out.println("   Lambda: " + parser1.apply("123"));
        
        // Method reference (equivalent)
        Function<String, Integer> parser2 = Integer::parseInt;
        System.out.println("   Method ref: " + parser2.apply("456"));
        
        // Another example with Math
        List<Double> numbers = Arrays.asList(1.5, 2.7, 3.2, 4.8);
        
        // Lambda
        numbers.stream()
               .map(n -> Math.ceil(n))
               .forEach(n -> System.out.print("   Lambda ceil: " + n + " "));
        System.out.println();
        
        // Method reference
        numbers.stream()
               .map(Math::ceil)
               .forEach(n -> System.out.print("   MethodRef ceil: " + n + " "));
        
        System.out.println("\n");
    }
    
    /**
     * Type 2: Reference to an Instance Method of a Particular Object
     * Syntax: objectReference::instanceMethodName
     */
    private static void demonstrateInstanceMethodReference() {
        System.out.println("2. Instance Method Reference (Particular Object):");
        
        String prefix = "   >> ";
        Printer printer = new Printer(prefix);
        
        List<String> messages = Arrays.asList("Hello", "World", "Java");
        
        // Lambda
        messages.forEach(s -> printer.print(s));
        System.out.println();
        
        // Method reference (cleaner)
        messages.forEach(printer::print);
        System.out.println();
        
        // Example with System.out
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        // Lambda
        nums.forEach(n -> System.out.println("   Lambda: " + n));
        
        // Method reference
        System.out.println("   Method ref:");
        nums.forEach(System.out::println);
        
        System.out.println();
    }
    
    /**
     * Type 3: Reference to an Instance Method of an Arbitrary Object
     * Syntax: ClassName::instanceMethodName
     * The first parameter becomes the object on which the method is invoked
     */
    private static void demonstrateArbitraryObjectMethodReference() {
        System.out.println("3. Instance Method Reference (Arbitrary Object):");
        
        List<String> words = Arrays.asList("apple", "BANANA", "Cherry", "DATE");
        
        // Lambda - toLowerCase on each string
        words.stream()
             .map(s -> s.toLowerCase())
             .forEach(s -> System.out.println("   Lambda: " + s));
        
        // Method reference - much cleaner
        System.out.println("   Method ref:");
        words.stream()
             .map(String::toLowerCase)
             .forEach(s -> System.out.println("   " + s));
        
        // Sorting example
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        
        // Lambda
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("   Lambda sorted: " + names);
        
        // Method reference
        names = Arrays.asList("Charlie", "Alice", "Bob"); // reset
        names.sort(String::compareToIgnoreCase);
        System.out.println("   MethodRef sorted: " + names);
        
        System.out.println();
    }
    
    /**
     * Type 4: Reference to a Constructor
     * Syntax: ClassName::new
     */
    private static void demonstrateConstructorReference() {
        System.out.println("4. Constructor Reference:");
        
        // Creating objects with constructor reference
        // Lambda
        Supplier<List<String>> listSupplier1 = () -> new ArrayList<>();
        List<String> list1 = listSupplier1.get();
        System.out.println("   Lambda: Created " + list1.getClass().getSimpleName());
        
        // Constructor reference
        Supplier<List<String>> listSupplier2 = ArrayList::new;
        List<String> list2 = listSupplier2.get();
        System.out.println("   MethodRef: Created " + list2.getClass().getSimpleName());
        
        // Constructor with parameters
        Function<String, Person> personCreator1 = name -> new Person(name);
        Person p1 = personCreator1.apply("Alice");
        System.out.println("   Lambda: " + p1);
        
        Function<String, Person> personCreator2 = Person::new;
        Person p2 = personCreator2.apply("Bob");
        System.out.println("   MethodRef: " + p2);
        
        // Creating array
        Function<Integer, int[]> arrayCreator1 = size -> new int[size];
        int[] arr1 = arrayCreator1.apply(5);
        System.out.println("   Lambda: Created array of length " + arr1.length);
        
        Function<Integer, int[]> arrayCreator2 = int[]::new;
        int[] arr2 = arrayCreator2.apply(10);
        System.out.println("   MethodRef: Created array of length " + arr2.length);
        
        System.out.println();
    }
    
    /**
     * Comparison: When to use Lambda vs Method Reference
     */
    private static void demonstrateComparison() {
        System.out.println("5. Lambda vs Method Reference - When to Use:");
        
        List<String> items = Arrays.asList("one", "two", "three", "four", "five");
        
        System.out.println("\n   ✓ Use Method Reference when:");
        System.out.println("   - Directly calling a method without modification");
        items.forEach(System.out::println);
        
        System.out.println("\n   ✓ Use Lambda when:");
        System.out.println("   - Need to add logic or transform parameters");
        items.forEach(s -> System.out.println("   >> " + s.toUpperCase()));
        
        System.out.println("\n   - Multiple operations needed");
        items.forEach(s -> {
            String upper = s.toUpperCase();
            System.out.println("   Length of " + upper + ": " + upper.length());
        });
    }
    
    // Helper method for demonstration
    public static void printFormatted(String s) {
        System.out.println("   [" + s + "]");
    }
}

// Helper classes

class Printer {
    private String prefix;
    
    public Printer(String prefix) {
        this.prefix = prefix;
    }
    
    public void print(String message) {
        System.out.println(prefix + message);
    }
}

class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

/**
 * Method Reference Summary:
 * 
 * 1. Static Method Reference
 *    Lambda:     (args) -> ClassName.staticMethod(args)
 *    MethodRef:  ClassName::staticMethod
 *    Example:    Integer::parseInt
 * 
 * 2. Instance Method of Particular Object
 *    Lambda:     (args) -> object.instanceMethod(args)
 *    MethodRef:  object::instanceMethod
 *    Example:    System.out::println
 * 
 * 3. Instance Method of Arbitrary Object
 *    Lambda:     (obj, args) -> obj.instanceMethod(args)
 *    MethodRef:  ClassName::instanceMethod
 *    Example:    String::toLowerCase
 * 
 * 4. Constructor Reference
 *    Lambda:     (args) -> new ClassName(args)
 *    MethodRef:  ClassName::new
 *    Example:    ArrayList::new
 * 
 * Benefits:
 * - More concise and readable
 * - Reduce redundancy
 * - Clear intention
 * - Better performance (in some cases)
 * 
 * When NOT to use:
 * - When you need additional logic
 * - When transforming parameters
 * - When calling multiple methods
 * 
 * Practice:
 * - Convert lambda expressions to method references
 * - Identify which type of method reference to use
 * - Know when method references improve readability
 */
