/**
 * Lambda Basics - Introduction to Lambda Expressions
 * 
 * This program demonstrates the fundamental syntax and usage of lambda expressions.
 * Lambda expressions provide a clear and concise way to represent one method interface
 * using an expression.
 */

public class LambdaBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Lambda Expression Basics ===\n");
        
        // 1. Traditional approach with anonymous class
        demonstrateTraditionalApproach();
        
        // 2. Lambda expressions - different syntaxes
        demonstrateLambdaSyntax();
        
        // 3. Lambda with different parameter counts
        demonstrateParameters();
        
        // 4. Lambda with multiple statements
        demonstrateMultipleStatements();
        
        // 5. Type inference
        demonstrateTypeInference();
    }
    
    /**
     * Traditional approach using anonymous inner class
     */
    private static void demonstrateTraditionalApproach() {
        System.out.println("1. Traditional Approach (Anonymous Inner Class):");
        
        // Creating a Runnable using anonymous inner class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("   Running using anonymous inner class");
            }
        };
        r1.run();
        System.out.println();
    }
    
    /**
     * Lambda expressions with different syntaxes
     */
    private static void demonstrateLambdaSyntax() {
        System.out.println("2. Lambda Expression Syntax:");
        
        // Lambda expression - much more concise
        Runnable r2 = () -> System.out.println("   Running using lambda expression");
        r2.run();
        
        // Lambda with block body
        Runnable r3 = () -> {
            System.out.println("   Lambda with multiple statements");
        };
        r3.run();
        System.out.println();
    }
    
    /**
     * Lambda expressions with different parameter counts
     */
    private static void demonstrateParameters() {
        System.out.println("3. Lambda Parameters:");
        
        // No parameters
        Greet greet1 = () -> "Hello, World!";
        System.out.println("   No params: " + greet1.sayHello());
        
        // Single parameter - parentheses optional
        StringOperation toUpper = s -> s.toUpperCase();
        System.out.println("   Single param: " + toUpper.apply("hello"));
        
        // Single parameter with explicit type
        StringOperation toLower = (String s) -> s.toLowerCase();
        System.out.println("   Single param (typed): " + toLower.apply("WORLD"));
        
        // Multiple parameters
        MathOperation add = (a, b) -> a + b;
        System.out.println("   Multiple params: 5 + 3 = " + add.operate(5, 3));
        
        // Multiple parameters with explicit types
        MathOperation multiply = (int a, int b) -> a * b;
        System.out.println("   Multiple params (typed): 5 * 3 = " + multiply.operate(5, 3));
        System.out.println();
    }
    
    /**
     * Lambda expressions with multiple statements
     */
    private static void demonstrateMultipleStatements() {
        System.out.println("4. Lambda with Multiple Statements:");
        
        // Multiple statements require curly braces and explicit return
        MathOperation complexOperation = (a, b) -> {
            System.out.println("   Calculating: " + a + " and " + b);
            int sum = a + b;
            int product = a * b;
            return sum * product;
        };
        
        int result = complexOperation.operate(3, 4);
        System.out.println("   Result: " + result);
        System.out.println();
    }
    
    /**
     * Type inference in lambda expressions
     */
    private static void demonstrateTypeInference() {
        System.out.println("5. Type Inference:");
        
        // Java can infer the parameter types
        MathOperation division = (a, b) -> {
            if (b == 0) {
                System.out.println("   Cannot divide by zero!");
                return 0;
            }
            return a / b;
        };
        
        System.out.println("   10 / 2 = " + division.operate(10, 2));
        System.out.println("   10 / 0 = " + division.operate(10, 0));
    }
}

// Functional Interfaces for demonstration

@FunctionalInterface
interface Greet {
    String sayHello();
}

@FunctionalInterface
interface StringOperation {
    String apply(String s);
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

/**
 * Key Takeaways:
 * 
 * 1. Lambda Syntax:
 *    - () -> expression
 *    - (param) -> expression
 *    - (param1, param2) -> expression
 *    - (params) -> { statements; return value; }
 * 
 * 2. Parentheses are optional for single parameters
 * 
 * 3. Type inference allows omitting parameter types
 * 
 * 4. Curly braces required for multiple statements
 * 
 * 5. Explicit return needed with curly braces
 * 
 * 6. Lambda expressions can only be used with functional interfaces
 * 
 * 7. Much more concise than anonymous inner classes
 * 
 * Practice:
 * - Try creating your own functional interfaces
 * - Convert anonymous inner classes to lambdas
 * - Experiment with different parameter combinations
 */
