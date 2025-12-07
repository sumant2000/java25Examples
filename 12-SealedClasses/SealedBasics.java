/**
 * Sealed Classes Basics - Restricted Inheritance (Java 17+)
 * 
 * Sealed classes restrict which other classes or interfaces may extend
 * or implement them, providing more control over your class hierarchies.
 * 
 * Java 25 Status: Stable, production-ready feature.
 */

// Basic sealed class with permitted subclasses
sealed class Shape
    permits Circle, Rectangle, Triangle {
    
    public abstract double area();
}

// Permitted subclasses must be final, sealed, or non-sealed
final class Circle extends Shape {
    private final double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    
    public double radius() {
        return radius;
    }
}

final class Rectangle extends Shape {
    private final double width;
    private final double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double area() {
        return width * height;
    }
    
    public double width() {
        return width;
    }
    
    public double height() {
        return height;
    }
}

final class Triangle extends Shape {
    private final double base;
    private final double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double area() {
        return 0.5 * base * height;
    }
    
    public double base() {
        return base;
    }
    
    public double height() {
        return height;
    }
}

// Sealed interface
sealed interface PaymentMethod
    permits CreditCard, DebitCard, Cash {
}

record CreditCard(String cardNumber, String cvv) implements PaymentMethod {}
record DebitCard(String cardNumber, String pin) implements PaymentMethod {}
record Cash(double amount) implements PaymentMethod {}

// Result type pattern
sealed interface Result<T>
    permits Success, Failure {
}

record Success<T>(T value) implements Result<T> {}
record Failure<T>(Exception error) implements Result<T> {}

public class SealedBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Sealed Classes Basics ===\n");
        
        demonstrateBasicSealed();
        demonstrateExhaustiveness();
        demonstrateSealedInterface();
        demonstrateResultType();
        demonstrateNestedHierarchy();
    }
    
    /**
     * Basic sealed class usage
     */
    private static void demonstrateBasicSealed() {
        System.out.println("1. Basic Sealed Classes:");
        
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0, 4.0);
        
        System.out.println("   Circle area: " + String.format("%.2f", circle.area()));
        System.out.println("   Rectangle area: " + String.format("%.2f", rectangle.area()));
        System.out.println("   Triangle area: " + String.format("%.2f", triangle.area()));
        
        // Cannot create other subclasses of Shape
        // class Square extends Shape {} // Compilation error!
        
        System.out.println();
    }
    
    /**
     * Exhaustiveness checking with pattern matching
     */
    private static void demonstrateExhaustiveness() {
        System.out.println("2. Exhaustive Pattern Matching:");
        
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0)
        };
        
        for (Shape shape : shapes) {
            // Compiler ensures all cases are covered
            String description = switch (shape) {
                case Circle c -> 
                    String.format("Circle with radius %.1f", c.radius());
                case Rectangle r -> 
                    String.format("Rectangle %.1f x %.1f", r.width(), r.height());
                case Triangle t -> 
                    String.format("Triangle base %.1f, height %.1f", t.base(), t.height());
                // No default needed - compiler knows all possible types!
            };
            
            System.out.println("   " + description + 
                             " -> Area: " + String.format("%.2f", shape.area()));
        }
        
        System.out.println();
    }
    
    /**
     * Sealed interfaces with records
     */
    private static void demonstrateSealedInterface() {
        System.out.println("3. Sealed Interface with Records:");
        
        PaymentMethod[] payments = {
            new CreditCard("1234-5678-9012-3456", "123"),
            new DebitCard("9876-5432-1098-7654", "1234"),
            new Cash(50.00)
        };
        
        for (PaymentMethod payment : payments) {
            String info = switch (payment) {
                case CreditCard cc -> 
                    "Credit Card ending in " + cc.cardNumber().substring(15);
                case DebitCard dc -> 
                    "Debit Card ending in " + dc.cardNumber().substring(15);
                case Cash cash -> 
                    String.format("Cash: $%.2f", cash.amount());
            };
            
            System.out.println("   " + info);
        }
        
        System.out.println();
    }
    
    /**
     * Result type with sealed classes
     */
    private static void demonstrateResultType() {
        System.out.println("4. Result Type Pattern:");
        
        Result<Integer> success = new Success<>(42);
        Result<Integer> failure = new Failure<>(new Exception("Error occurred"));
        
        handleResult(success);
        handleResult(failure);
        
        System.out.println();
    }
    
    private static <T> void handleResult(Result<T> result) {
        switch (result) {
            case Success<T> s -> 
                System.out.println("   Success: " + s.value());
            case Failure<T> f -> 
                System.out.println("   Failure: " + f.error().getMessage());
        }
    }
    
    /**
     * Nested sealed hierarchy
     */
    private static void demonstrateNestedHierarchy() {
        System.out.println("5. Nested Sealed Hierarchy:");
        
        Vehicle car = new Sedan("Toyota", "Camry");
        Vehicle boat = new Boat("Speedboat");
        
        System.out.println("   " + describeVehicle(car));
        System.out.println("   " + describeVehicle(boat));
    }
    
    private static String describeVehicle(Vehicle vehicle) {
        return switch (vehicle) {
            case Sedan s -> "Sedan: " + s.make() + " " + s.model();
            case SUV suv -> "SUV: " + suv.make() + " " + suv.model();
            case Boat b -> "Boat: " + b.name();
        };
    }
}

// Nested sealed hierarchy
sealed interface Vehicle
    permits Car, Boat {
}

sealed interface Car extends Vehicle
    permits Sedan, SUV {
}

record Sedan(String make, String model) implements Car {}
record SUV(String make, String model) implements Car {}
record Boat(String name) implements Vehicle {}

/**
 * Sealed Classes Summary:
 * 
 * Syntax:
 *   sealed class/interface Name
 *       permits Subclass1, Subclass2 {}
 * 
 * Permitted Classes Must Be:
 * - final: Cannot be extended further
 * - sealed: Can have its own permitted subclasses
 * - non-sealed: Open for any extension
 * 
 * Benefits:
 * 1. Controlled inheritance
 * 2. Exhaustive pattern matching
 * 3. Clear API design
 * 4. Better maintainability
 * 5. Type safety
 * 
 * Use Cases:
 * - Domain modeling with finite types
 * - State machines
 * - Result/Option types
 * - Expression trees
 * - Event hierarchies
 * - Payment methods
 * - Shape hierarchies
 * 
 * With Pattern Matching:
 * - No default case needed
 * - Compiler ensures exhaustiveness
 * - Compile error if new type added but not handled
 * 
 * Best Practices:
 * 1. Use for finite, well-defined type sets
 * 2. Combine with records for immutable data
 * 3. Leverage pattern matching
 * 4. Keep hierarchies shallow
 * 5. Document the sealed contract
 * 
 * Comparison:
 * 
 * Before (with enum - limited):
 *   enum Shape { CIRCLE, RECTANGLE, TRIANGLE }
 *   // Cannot have per-type data
 * 
 * With sealed classes:
 *   sealed interface Shape permits Circle, Rectangle, Triangle
 *   record Circle(double radius) implements Shape
 *   // Each type can have its own data!
 * 
 * Practice:
 * - Model a payment system
 * - Create a result type
 * - Design an expression evaluator
 * - Build a state machine
 * - Implement event hierarchies
 */
