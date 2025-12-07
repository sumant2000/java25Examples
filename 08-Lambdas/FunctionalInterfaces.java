/**
 * Functional Interfaces - Working with Java's Built-in Functional Interfaces
 * 
 * Java 8+ provides several functional interfaces in java.util.function package.
 * These cover most common use cases and eliminate the need to create custom
 * functional interfaces in many situations.
 */

import java.util.function.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaces {
    
    public static void main(String[] args) {
        System.out.println("=== Java Built-in Functional Interfaces ===\n");
        
        demonstratePredicate();
        demonstrateFunction();
        demonstrateConsumer();
        demonstrateSupplier();
        demonstrateBiFunctions();
        demonstrateUnaryOperator();
        demonstrateCombining();
    }
    
    /**
     * Predicate<T> - Takes one argument, returns boolean
     * Common use: Testing/filtering
     */
    private static void demonstratePredicate() {
        System.out.println("1. Predicate<T> - boolean test(T t):");
        
        // Simple predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("   Is 4 even? " + isEven.test(4));
        System.out.println("   Is 7 even? " + isEven.test(7));
        
        // String predicate
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("   Is \"\" empty? " + isEmpty.test(""));
        System.out.println("   Is \"Hello\" empty? " + isEmpty.test("Hello"));
        
        // Predicate chaining with and(), or(), negate()
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println("   Is 4 even AND positive? " + isEvenAndPositive.test(4));
        System.out.println("   Is -4 even AND positive? " + isEvenAndPositive.test(-4));
        
        System.out.println();
    }
    
    /**
     * Function<T, R> - Takes one argument of type T, returns type R
     * Common use: Transforming data
     */
    private static void demonstrateFunction() {
        System.out.println("2. Function<T, R> - R apply(T t):");
        
        // Integer to String
        Function<Integer, String> intToString = n -> "Number: " + n;
        System.out.println("   " + intToString.apply(42));
        
        // String length
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("   Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Function composition - andThen()
        Function<Integer, Integer> multiplyBy2 = n -> n * 2;
        Function<Integer, Integer> add10 = n -> n + 10;
        Function<Integer, Integer> multiplyThenAdd = multiplyBy2.andThen(add10);
        System.out.println("   (5 * 2) + 10 = " + multiplyThenAdd.apply(5));
        
        // Function composition - compose()
        Function<Integer, Integer> addThenMultiply = multiplyBy2.compose(add10);
        System.out.println("   (5 + 10) * 2 = " + addThenMultiply.apply(5));
        
        System.out.println();
    }
    
    /**
     * Consumer<T> - Takes one argument, returns nothing
     * Common use: Side effects (printing, updating)
     */
    private static void demonstrateConsumer() {
        System.out.println("3. Consumer<T> - void accept(T t):");
        
        // Simple consumer
        Consumer<String> printer = s -> System.out.println("   >> " + s);
        printer.accept("Hello from Consumer!");
        
        // Consumer with list
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Consumer<String> greet = name -> System.out.println("   Hello, " + name + "!");
        names.forEach(greet);
        
        // Consumer chaining with andThen()
        Consumer<String> printUpper = s -> System.out.println("   UPPER: " + s.toUpperCase());
        Consumer<String> printLower = s -> System.out.println("   lower: " + s.toLowerCase());
        Consumer<String> printBoth = printUpper.andThen(printLower);
        printBoth.accept("Java");
        
        System.out.println();
    }
    
    /**
     * Supplier<T> - Takes no arguments, returns type T
     * Common use: Lazy evaluation, factory methods
     */
    private static void demonstrateSupplier() {
        System.out.println("4. Supplier<T> - T get():");
        
        // Simple supplier
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("   Random: " + randomValue.get());
        System.out.println("   Random: " + randomValue.get());
        
        // Supplier for object creation
        Supplier<List<String>> listSupplier = () -> new ArrayList<>();
        List<String> list1 = listSupplier.get();
        List<String> list2 = listSupplier.get();
        System.out.println("   Created two separate lists: " + (list1 != list2));
        
        // Lazy evaluation
        Supplier<String> expensiveOperation = () -> {
            System.out.println("   Performing expensive operation...");
            return "Result";
        };
        System.out.println("   Supplier created (not executed yet)");
        System.out.println("   Now calling get(): " + expensiveOperation.get());
        
        System.out.println();
    }
    
    /**
     * BiFunction and BiConsumer - Two argument versions
     */
    private static void demonstrateBiFunctions() {
        System.out.println("5. Bi-Functions (Two Arguments):");
        
        // BiFunction<T, U, R> - Two arguments, returns result
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("   BiFunction: 5 + 3 = " + add.apply(5, 3));
        
        // BiFunction with different types
        BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
        System.out.println("   BiFunction: " + repeat.apply("Hi! ", 3));
        
        // BiConsumer<T, U> - Two arguments, no return
        BiConsumer<String, Integer> printWithIndex = (s, i) -> 
            System.out.println("   " + i + ": " + s);
        printWithIndex.accept("First", 1);
        printWithIndex.accept("Second", 2);
        
        // BiPredicate<T, U> - Two arguments, returns boolean
        BiPredicate<String, Integer> isLengthEqual = (s, n) -> s.length() == n;
        System.out.println("   BiPredicate: Is 'Hello' length 5? " + 
                         isLengthEqual.test("Hello", 5));
        
        System.out.println();
    }
    
    /**
     * UnaryOperator and BinaryOperator - Special cases of Function
     */
    private static void demonstrateUnaryOperator() {
        System.out.println("6. Operators (Special Function Types):");
        
        // UnaryOperator<T> - Takes T, returns T (same type)
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println("   UnaryOperator: 5² = " + square.apply(5));
        
        UnaryOperator<String> addExclamation = s -> s + "!";
        System.out.println("   UnaryOperator: " + addExclamation.apply("Hello"));
        
        // BinaryOperator<T> - Takes two T, returns T
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("   BinaryOperator: max(10, 20) = " + max.apply(10, 20));
        
        BinaryOperator<String> concat = (s1, s2) -> s1 + " " + s2;
        System.out.println("   BinaryOperator: " + concat.apply("Hello", "World"));
        
        System.out.println();
    }
    
    /**
     * Combining functional interfaces for complex operations
     */
    private static void demonstrateCombining() {
        System.out.println("7. Combining Functional Interfaces:");
        
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter even numbers, multiply by 2, and print
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Function<Integer, Integer> multiplyBy2 = n -> n * 2;
        Consumer<Integer> print = n -> System.out.print(n + " ");
        
        System.out.print("   Even numbers * 2: ");
        numbers.stream()
               .filter(isEven)
               .map(multiplyBy2)
               .forEach(print);
        
        System.out.println("\n");
    }
}

/**
 * Summary of Built-in Functional Interfaces:
 * 
 * 1. Predicate<T>: T -> boolean
 *    - test(T t)
 *    - Used for: Filtering, testing conditions
 * 
 * 2. Function<T, R>: T -> R
 *    - apply(T t)
 *    - Used for: Transforming data
 * 
 * 3. Consumer<T>: T -> void
 *    - accept(T t)
 *    - Used for: Side effects
 * 
 * 4. Supplier<T>: () -> T
 *    - get()
 *    - Used for: Lazy evaluation, factories
 * 
 * 5. BiFunction<T, U, R>: (T, U) -> R
 *    - apply(T t, U u)
 * 
 * 6. BiConsumer<T, U>: (T, U) -> void
 *    - accept(T t, U u)
 * 
 * 7. BiPredicate<T, U>: (T, U) -> boolean
 *    - test(T t, U u)
 * 
 * 8. UnaryOperator<T>: T -> T
 *    - apply(T t)
 * 
 * 9. BinaryOperator<T>: (T, T) -> T
 *    - apply(T t1, T t2)
 * 
 * Specialized versions exist for primitives:
 * - IntPredicate, IntFunction, IntConsumer, IntSupplier
 * - LongPredicate, LongFunction, LongConsumer, LongSupplier
 * - DoublePredicate, DoubleFunction, DoubleConsumer, DoubleSupplier
 * 
 * Practice:
 * - Try using these interfaces with collections
 * - Combine them to create complex operations
 * - Use method references where applicable
 */
