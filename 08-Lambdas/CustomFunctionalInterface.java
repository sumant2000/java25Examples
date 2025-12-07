/**
 * Custom Functional Interface - Creating Your Own
 * 
 * While Java provides many built-in functional interfaces, sometimes you need
 * to create custom ones for domain-specific operations.
 * 
 * A functional interface must have exactly ONE abstract method (SAM).
 * It can have default methods, static methods, and methods from Object class.
 */

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

@FunctionalInterface
interface StringFormatter {
    String format(String input);
    
    // Default method - allowed
    default String formatTwice(String input) {
        return format(format(input));
    }
    
    // Static method - allowed
    static String addBrackets(String s) {
        return "[" + s + "]";
    }
}

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

@FunctionalInterface
interface Validator<T> {
    boolean validate(T value);
    
    default Validator<T> and(Validator<T> other) {
        return value -> this.validate(value) && other.validate(value);
    }
    
    default Validator<T> or(Validator<T> other) {
        return value -> this.validate(value) || other.validate(value);
    }
}

public class CustomFunctionalInterface {
    
    public static void main(String[] args) {
        System.out.println("=== Custom Functional Interfaces ===\n");
        
        demonstrateBasicCustomInterface();
        demonstrateWithDefaultMethods();
        demonstrateTriFunction();
        demonstrateValidator();
        demonstrateRealWorldExample();
    }
    
    /**
     * Basic custom functional interface
     */
    private static void demonstrateBasicCustomInterface() {
        System.out.println("1. Basic Custom Functional Interface:");
        
        // Implement Calculator interface
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;
        
        System.out.println("   5 + 3 = " + add.calculate(5, 3));
        System.out.println("   5 - 3 = " + subtract.calculate(5, 3));
        System.out.println("   5 * 3 = " + multiply.calculate(5, 3));
        System.out.println("   6 / 2 = " + divide.calculate(6, 2));
        
        // Using with a method
        int result = performCalculation(10, 5, multiply);
        System.out.println("   10 * 5 = " + result);
        
        System.out.println();
    }
    
    private static int performCalculation(int a, int b, Calculator calc) {
        return calc.calculate(a, b);
    }
    
    /**
     * Custom interface with default methods
     */
    private static void demonstrateWithDefaultMethods() {
        System.out.println("2. Custom Interface with Default Methods:");
        
        StringFormatter toUpper = s -> s.toUpperCase();
        StringFormatter addStars = s -> "*** " + s + " ***";
        
        String text = "hello";
        System.out.println("   Original: " + text);
        System.out.println("   toUpper: " + toUpper.format(text));
        System.out.println("   toUpper twice: " + toUpper.formatTwice(text));
        System.out.println("   addStars: " + addStars.format(text));
        System.out.println("   Static method: " + StringFormatter.addBrackets(text));
        
        System.out.println();
    }
    
    /**
     * Custom interface with three parameters
     */
    private static void demonstrateTriFunction() {
        System.out.println("3. TriFunction - Three Parameters:");
        
        // Concatenate three strings
        TriFunction<String, String, String, String> concat = 
            (s1, s2, s3) -> s1 + " " + s2 + " " + s3;
        
        System.out.println("   " + concat.apply("Hello", "Java", "World"));
        
        // Sum of three numbers
        TriFunction<Integer, Integer, Integer, Integer> sum = 
            (a, b, c) -> a + b + c;
        
        System.out.println("   Sum: " + sum.apply(5, 10, 15));
        
        // Build a full name
        TriFunction<String, String, String, String> fullName = 
            (first, middle, last) -> first + " " + middle + " " + last;
        
        System.out.println("   Full name: " + fullName.apply("John", "Doe", "Smith"));
        
        System.out.println();
    }
    
    /**
     * Custom validator with composable logic
     */
    private static void demonstrateValidator() {
        System.out.println("4. Custom Validator with Composition:");
        
        // Individual validators
        Validator<String> notEmpty = s -> s != null && !s.isEmpty();
        Validator<String> minLength = s -> s != null && s.length() >= 5;
        Validator<String> maxLength = s -> s != null && s.length() <= 20;
        Validator<String> hasNumber = s -> s != null && s.matches(".*\\d.*");
        
        // Compose validators
        Validator<String> passwordValidator = notEmpty
            .and(minLength)
            .and(maxLength)
            .and(hasNumber);
        
        String[] passwords = {"", "abc", "abcde", "abcde123", "verylongpasswordwithoutanynumber"};
        
        for (String pwd : passwords) {
            boolean valid = passwordValidator.validate(pwd);
            System.out.println("   Password '" + pwd + "': " + (valid ? "✓ Valid" : "✗ Invalid"));
        }
        
        // Number validator
        Validator<Integer> positive = n -> n > 0;
        Validator<Integer> lessThan100 = n -> n < 100;
        Validator<Integer> rangeValidator = positive.and(lessThan100);
        
        System.out.println("\n   Number 50: " + (rangeValidator.validate(50) ? "✓ Valid" : "✗ Invalid"));
        System.out.println("   Number -5: " + (rangeValidator.validate(-5) ? "✓ Valid" : "✗ Invalid"));
        System.out.println("   Number 150: " + (rangeValidator.validate(150) ? "✓ Valid" : "✗ Invalid"));
        
        System.out.println();
    }
    
    /**
     * Real-world example: Data processing pipeline
     */
    private static void demonstrateRealWorldExample() {
        System.out.println("5. Real-World Example - Data Processing:");
        
        // Custom processor interface
        DataProcessor<String> trimmer = s -> s.trim();
        DataProcessor<String> upperCaser = s -> s.toUpperCase();
        DataProcessor<String> replacer = s -> s.replace("JAVA", "Java 25");
        
        // Chain processors
        DataProcessor<String> pipeline = trimmer
            .andThen(upperCaser)
            .andThen(replacer);
        
        String[] inputs = {
            "  hello java  ",
            "welcome to java programming",
            "  learn java today  "
        };
        
        for (String input : inputs) {
            String result = pipeline.process(input);
            System.out.println("   Input:  '" + input + "'");
            System.out.println("   Output: '" + result + "'");
        }
    }
}

@FunctionalInterface
interface DataProcessor<T> {
    T process(T input);
    
    default DataProcessor<T> andThen(DataProcessor<T> after) {
        return input -> after.process(this.process(input));
    }
}

/**
 * Creating Custom Functional Interfaces - Best Practices:
 * 
 * 1. Use @FunctionalInterface Annotation:
 *    - Not required but recommended
 *    - Compiler will verify it's a valid functional interface
 *    - Makes intention clear to other developers
 * 
 * 2. One Abstract Method (SAM):
 *    - Only ONE abstract method allowed
 *    - Can have multiple default methods
 *    - Can have multiple static methods
 *    - Methods from Object class don't count
 * 
 * 3. Naming Conventions:
 *    - Use descriptive names that indicate the operation
 *    - Common patterns: -able (Comparable, Runnable)
 *    - Or action verbs (Consumer, Supplier, Validator)
 * 
 * 4. When to Create Custom:
 *    - Built-in interfaces don't fit your needs
 *    - Need domain-specific semantics
 *    - Want to add default/static helper methods
 *    - Need more than 2 parameters
 * 
 * 5. Consider Built-in First:
 *    - Check java.util.function package first
 *    - Predicate, Function, Consumer, Supplier, etc.
 *    - Only create custom when truly needed
 * 
 * 6. Generic Types:
 *    - Use generics for type safety
 *    - Makes interface reusable
 * 
 * 7. Default Methods:
 *    - Add common implementations
 *    - Enable composition (andThen, compose)
 *    - Don't overdo it - keep it simple
 * 
 * Common Patterns:
 * - Validator: T -> boolean (with composition)
 * - Transformer: T -> T (with chaining)
 * - Builder: Multiple params -> complex object
 * - Strategy: Pluggable algorithms
 * 
 * Practice:
 * - Create a Comparator-like interface
 * - Build a data transformation pipeline
 * - Implement a validation framework
 * - Create a custom event handler system
 */
