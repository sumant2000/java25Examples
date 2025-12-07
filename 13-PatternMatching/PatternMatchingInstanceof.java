/**
 * Pattern Matching for instanceof - Modern Type Checking (Java 16+)
 * 
 * Pattern matching for instanceof eliminates the need for explicit casting
 * after type checking, making code more concise and safer.
 * 
 * Java 25 Status: Stable feature with continued refinements.
 */

public class PatternMatchingInstanceof {
    
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for instanceof ===\n");
        
        demonstrateTraditionalWay();
        demonstratePatternMatching();
        demonstrateWithLogicalOperators();
        demonstrateScope();
        demonstrateNullSafety();
        demonstrateRealWorldExamples();
    }
    
    /**
     * Traditional instanceof with explicit casting
     */
    private static void demonstrateTraditionalWay() {
        System.out.println("1. Traditional instanceof (Before Java 16):");
        
        Object obj = "Hello, World!";
        
        // Old way - test, cast, use
        if (obj instanceof String) {
            String str = (String) obj;  // Explicit cast required
            System.out.println("   Length: " + str.length());
            System.out.println("   Uppercase: " + str.toUpperCase());
        }
        
        Object num = 42;
        if (num instanceof Integer) {
            Integer i = (Integer) num;  // Another explicit cast
            System.out.println("   Value: " + i);
        }
        
        System.out.println();
    }
    
    /**
     * Pattern matching - test and bind in one step
     */
    private static void demonstratePatternMatching() {
        System.out.println("2. Pattern Matching (Java 16+):");
        
        Object obj = "Hello, World!";
        
        // New way - test and bind
        if (obj instanceof String str) {  // 'str' is the pattern variable
            System.out.println("   Length: " + str.length());
            System.out.println("   Uppercase: " + str.toUpperCase());
            // No casting needed!
        }
        
        Object num = 42;
        if (num instanceof Integer i) {  // Concise and clear
            System.out.println("   Value: " + i);
            System.out.println("   Doubled: " + (i * 2));
        }
        
        // Works with any type
        Object list = new java.util.ArrayList<String>();
        if (list instanceof java.util.ArrayList<?> arrayList) {
            System.out.println("   ArrayList size: " + arrayList.size());
        }
        
        System.out.println();
    }
    
    /**
     * Combining pattern matching with logical operators
     */
    private static void demonstrateWithLogicalOperators() {
        System.out.println("3. With Logical Operators:");
        
        Object obj1 = "Hello";
        
        // AND condition - pattern variable in scope
        if (obj1 instanceof String str && str.length() > 3) {
            System.out.println("   Long string: " + str);
        }
        
        // Multiple conditions
        if (obj1 instanceof String str && !str.isEmpty() && str.charAt(0) == 'H') {
            System.out.println("   Starts with H: " + str);
        }
        
        Object obj2 = 10;
        
        // OR condition - pattern variable NOT in scope after ||
        if (!(obj2 instanceof Integer i) || i < 0) {
            System.out.println("   Not a positive integer");
        } else if (obj2 instanceof Integer i && i >= 0) {
            System.out.println("   Positive integer: " + i);
        }
        
        System.out.println();
    }
    
    /**
     * Understanding pattern variable scope
     */
    private static void demonstrateScope() {
        System.out.println("4. Pattern Variable Scope:");
        
        Object obj = "Test";
        
        // Pattern variable available in if block
        if (obj instanceof String str) {
            System.out.println("   Inside if: " + str);
            System.out.println("   Can use str here: " + str.length());
        }
        // str is NOT available here
        
        // Pattern variable available after && (flow typing)
        if (obj instanceof String str && str.length() > 2) {
            System.out.println("   After &&: " + str);
        }
        
        // Negation - variable NOT available
        if (!(obj instanceof String str)) {
            // str is NOT in scope here
            System.out.println("   Not a string");
        } else {
            // But available in else branch!
            System.out.println("   In else: " + str);
        }
        
        System.out.println();
    }
    
    /**
     * Null safety with pattern matching
     */
    private static void demonstrateNullSafety() {
        System.out.println("5. Null Safety:");
        
        Object obj1 = "Hello";
        Object obj2 = null;
        
        // Pattern matching handles null automatically
        if (obj1 instanceof String str) {
            System.out.println("   obj1 is String: " + str);
        }
        
        if (obj2 instanceof String str) {
            System.out.println("   obj2 is String: " + str);
        } else {
            System.out.println("   obj2 is null or not a String");
        }
        
        // Traditional way required null check
        if (obj2 != null && obj2 instanceof String) {
            String str = (String) obj2;
            System.out.println("   Traditional: " + str);
        }
        
        // Pattern matching is cleaner
        if (obj2 instanceof String str) {
            System.out.println("   Pattern matching: " + str);
        }
        
        System.out.println();
    }
    
    /**
     * Real-world examples
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("6. Real-World Examples:");
        
        // Example 1: Processing different types
        Object[] objects = {
            "Hello",
            42,
            3.14,
            new int[]{1, 2, 3},
            null
        };
        
        System.out.println("   Processing mixed types:");
        for (Object obj : objects) {
            String result = processObject(obj);
            System.out.println("      " + result);
        }
        
        // Example 2: Type-specific behavior
        System.out.println("\n   Shape area calculation:");
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0)
        };
        
        for (Shape shape : shapes) {
            double area = calculateArea(shape);
            System.out.println("      " + shape.getClass().getSimpleName() + 
                             " area: " + String.format("%.2f", area));
        }
    }
    
    /**
     * Helper method demonstrating pattern matching
     */
    private static String processObject(Object obj) {
        // Pattern matching makes this clean and readable
        if (obj == null) {
            return "null value";
        } else if (obj instanceof String str) {
            return "String: \"" + str + "\" (length: " + str.length() + ")";
        } else if (obj instanceof Integer i) {
            return "Integer: " + i + " (squared: " + (i * i) + ")";
        } else if (obj instanceof Double d) {
            return "Double: " + String.format("%.2f", d);
        } else if (obj instanceof int[] arr) {
            return "Array of length " + arr.length;
        } else {
            return "Unknown type: " + obj.getClass().getSimpleName();
        }
    }
    
    /**
     * Calculate area using pattern matching
     */
    private static double calculateArea(Shape shape) {
        // Using pattern matching for polymorphic behavior
        if (shape instanceof Circle c) {
            return Math.PI * c.radius() * c.radius();
        } else if (shape instanceof Rectangle r) {
            return r.width() * r.height();
        } else if (shape instanceof Triangle t) {
            return 0.5 * t.base() * t.height();
        }
        return 0.0;
    }
}

// Shape hierarchy for demonstration
sealed interface Shape permits Circle, Rectangle, Triangle {}

record Circle(double radius) implements Shape {}
record Rectangle(double width, double height) implements Shape {}
record Triangle(double base, double height) implements Shape {}

/**
 * Pattern Matching for instanceof Summary:
 * 
 * Syntax:
 *   if (object instanceof Type variable) {
 *       // use variable here
 *   }
 * 
 * Benefits:
 * 1. No explicit casting needed
 * 2. Cleaner, more readable code
 * 3. Type-safe - compiler ensures correctness
 * 4. Null-safe by default
 * 5. Works with logical operators
 * 6. Reduced boilerplate
 * 
 * Pattern Variable Scope:
 * - Available in the if block
 * - Available after && in the same if condition
 * - Available in else block when negated
 * - NOT available after || operator
 * 
 * Comparison with Traditional:
 * 
 * Traditional (3 steps):
 *   if (obj instanceof String) {
 *       String str = (String) obj;
 *       // use str
 *   }
 * 
 * Pattern Matching (1 step):
 *   if (obj instanceof String str) {
 *       // use str
 *   }
 * 
 * Best Practices:
 * 1. Use meaningful pattern variable names
 * 2. Keep pattern variables close to their use
 * 3. Leverage with logical operators
 * 4. Consider pattern matching in switch (Java 21+)
 * 5. Combine with records for powerful data extraction
 * 
 * Common Use Cases:
 * - Type checking and extraction
 * - Polymorphic behavior
 * - Input validation
 * - Data processing
 * - API response handling
 * 
 * Practice:
 * - Refactor old instanceof code to pattern matching
 * - Process heterogeneous collections
 * - Implement type-specific behavior
 * - Combine with other modern features
 */
