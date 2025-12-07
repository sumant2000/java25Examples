/**
 * Variable Capture - Understanding Scope in Lambda Expressions
 * 
 * Lambda expressions can access variables from the enclosing scope.
 * These variables must be final or effectively final.
 * 
 * Key Concepts:
 * - Effectively final: Variable not modified after initialization
 * - Closure: Lambda capturing variables from outer scope
 * - Lexical scoping: Lambda uses variables from where it's defined
 */

import java.util.function.*;

public class VariableCapture {
    
    // Instance variable
    private String instanceVar = "Instance Variable";
    
    // Static variable
    private static String staticVar = "Static Variable";
    
    public static void main(String[] args) {
        System.out.println("=== Variable Capture in Lambdas ===\n");
        
        demonstrateLocalVariableCapture();
        demonstrateEffectivelyFinal();
        demonstrateInstanceVariableAccess();
        demonstrateStaticVariableAccess();
        demonstrateClosureExample();
        demonstrateCommonPitfalls();
    }
    
    /**
     * Capturing local variables (must be final or effectively final)
     */
    private static void demonstrateLocalVariableCapture() {
        System.out.println("1. Local Variable Capture:");
        
        // Final variable - can be captured
        final String finalVar = "I am final";
        Supplier<String> supplier1 = () -> finalVar;
        System.out.println("   " + supplier1.get());
        
        // Effectively final - can be captured
        String effectivelyFinal = "I am effectively final";
        Supplier<String> supplier2 = () -> effectivelyFinal;
        System.out.println("   " + supplier2.get());
        
        // Multiple variable capture
        String name = "Alice";
        int age = 30;
        Supplier<String> info = () -> name + " is " + age + " years old";
        System.out.println("   " + info.get());
        
        System.out.println();
    }
    
    /**
     * Demonstrating what breaks effectively final
     */
    private static void demonstrateEffectivelyFinal() {
        System.out.println("2. Effectively Final Requirement:");
        
        String canCapture = "Initial value";
        
        // This works - variable is effectively final
        Runnable r1 = () -> System.out.println("   Captured: " + canCapture);
        r1.run();
        
        // Demonstrating the restriction
        String cannotCapture = "First value";
        
        // ❌ This would NOT compile (uncomment to see error):
        // cannotCapture = "Modified value";  // Modification breaks effectively final
        // Runnable r2 = () -> System.out.println(cannotCapture);  // Compilation error!
        
        // Workaround 1: Use an array or container
        String[] mutableContainer = {"Initial"};
        Runnable r3 = () -> System.out.println("   From array: " + mutableContainer[0]);
        r3.run();
        mutableContainer[0] = "Modified";
        r3.run();
        
        // Workaround 2: Use an object wrapper
        StringWrapper wrapper = new StringWrapper("Initial");
        Runnable r4 = () -> System.out.println("   From wrapper: " + wrapper.getValue());
        r4.run();
        wrapper.setValue("Modified");
        r4.run();
        
        System.out.println();
    }
    
    /**
     * Accessing instance variables
     */
    private static void demonstrateInstanceVariableAccess() {
        System.out.println("3. Instance Variable Access:");
        
        VariableCapture example = new VariableCapture();
        example.showInstanceAccess();
        
        System.out.println();
    }
    
    private void showInstanceAccess() {
        // Lambda can access instance variables
        Runnable r = () -> {
            System.out.println("   Accessing: " + instanceVar);
            System.out.println("   Using this: " + this.instanceVar);
        };
        r.run();
        
        // Lambda can modify instance variables
        Runnable modifier = () -> {
            instanceVar = "Modified Instance Variable";
            System.out.println("   Modified to: " + instanceVar);
        };
        modifier.run();
    }
    
    /**
     * Accessing static variables
     */
    private static void demonstrateStaticVariableAccess() {
        System.out.println("4. Static Variable Access:");
        
        // Lambda can access static variables
        Runnable r = () -> System.out.println("   Static var: " + staticVar);
        r.run();
        
        // Lambda can modify static variables
        Runnable modifier = () -> {
            staticVar = "Modified Static Variable";
            System.out.println("   Modified to: " + staticVar);
        };
        modifier.run();
        
        System.out.println();
    }
    
    /**
     * Closure - lambda remembers the environment
     */
    private static void demonstrateClosureExample() {
        System.out.println("5. Closure Example:");
        
        // Creating a closure
        Function<Integer, Integer> createMultiplier(int factor) {
            return x -> x * factor;  // Captures 'factor'
        }
        
        Function<Integer, Integer> multiplyBy2 = createMultiplier(2);
        Function<Integer, Integer> multiplyBy5 = createMultiplier(5);
        Function<Integer, Integer> multiplyBy10 = createMultiplier(10);
        
        System.out.println("   5 * 2 = " + multiplyBy2.apply(5));
        System.out.println("   5 * 5 = " + multiplyBy5.apply(5));
        System.out.println("   5 * 10 = " + multiplyBy10.apply(5));
        
        // Each lambda remembers its own factor
        System.out.println("   3 * 2 = " + multiplyBy2.apply(3));
        System.out.println("   3 * 10 = " + multiplyBy10.apply(3));
        
        System.out.println();
    }
    
    /**
     * Common pitfalls and gotchas
     */
    private static void demonstrateCommonPitfalls() {
        System.out.println("6. Common Pitfalls:");
        
        // Pitfall 1: Loop variable capture
        System.out.println("   Loop Variable Capture:");
        
        // ❌ Wrong way (all lambdas will see the final value)
        Runnable[] runnables = new Runnable[3];
        // for (int i = 0; i < 3; i++) {
        //     runnables[i] = () -> System.out.println(i);  // Won't compile!
        // }
        
        // ✓ Correct way - use effectively final copy
        for (int i = 0; i < 3; i++) {
            final int index = i;  // Create effectively final copy
            runnables[i] = () -> System.out.println("      Index: " + index);
        }
        
        for (Runnable r : runnables) {
            r.run();
        }
        
        // Pitfall 2: Expecting to modify local variables
        System.out.println("\n   Modifying Captured Variables:");
        int counter = 0;
        // ❌ This won't compile:
        // Runnable increment = () -> counter++;  // Cannot modify captured variable
        
        // ✓ Use wrapper
        Counter counterObj = new Counter();
        Runnable increment = () -> counterObj.increment();
        increment.run();
        increment.run();
        increment.run();
        System.out.println("      Counter value: " + counterObj.getValue());
        
        // Pitfall 3: Variable shadowing
        System.out.println("\n   Variable Shadowing:");
        String message = "Outer";
        Consumer<String> printer = (String message_param) -> {
            // Can't use 'message' as parameter name if outer variable exists
            System.out.println("      Outer message: " + message);
            System.out.println("      Parameter: " + message_param);
        };
        printer.accept("Inner");
        
        System.out.println();
    }
}

// Helper classes

class StringWrapper {
    private String value;
    
    public StringWrapper(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}

class Counter {
    private int count = 0;
    
    public void increment() {
        count++;
    }
    
    public int getValue() {
        return count;
    }
}

/**
 * Variable Capture Rules Summary:
 * 
 * 1. Local Variables:
 *    ✓ Must be final or effectively final
 *    ✓ Can read but cannot modify
 *    ✓ Captured by value (for primitives)
 * 
 * 2. Effectively Final:
 *    - Variable is not explicitly final
 *    - But never modified after initialization
 *    - Compiler treats it as if it were final
 * 
 * 3. Instance Variables:
 *    ✓ Can be accessed and modified
 *    ✓ Use 'this' keyword if needed
 *    ✓ Not subject to effectively final rule
 * 
 * 4. Static Variables:
 *    ✓ Can be accessed and modified
 *    ✓ Not subject to effectively final rule
 * 
 * 5. Parameters:
 *    ✓ Are effectively final by default
 *    ✓ Cannot be reassigned
 * 
 * Why These Restrictions?
 * - Thread safety: Captured variables could be accessed by multiple threads
 * - Simplicity: Makes reasoning about lambda behavior easier
 * - Performance: Allows compiler optimizations
 * 
 * Workarounds for Mutability:
 * 1. Use array: final int[] counter = {0};
 * 2. Use wrapper class: final Counter counter = new Counter();
 * 3. Use AtomicInteger: final AtomicInteger counter = new AtomicInteger(0);
 * 4. Use instance variables instead of local
 * 
 * Best Practices:
 * - Avoid mutable state in lambdas when possible
 * - If you need mutable state, consider if lambda is the right tool
 * - Use descriptive variable names to avoid shadowing
 * - Be aware of closure behavior when creating lambdas in loops
 * 
 * Practice:
 * - Create lambdas that capture different types of variables
 * - Implement a counter using different workarounds
 * - Understand when variables become "not effectively final"
 */
