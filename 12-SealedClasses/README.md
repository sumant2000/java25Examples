# Module 12: Sealed Classes (Java 17+) 🔒

## What are Sealed Classes?

Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them. This provides more control over inheritance hierarchies.

**Introduced**: Preview in Java 15, standard in Java 17

## Syntax

```java
public sealed class Shape
    permits Circle, Rectangle, Triangle {
}

final class Circle extends Shape { }
final class Rectangle extends Shape { }
final class Triangle extends Shape { }
```

## Key Keywords

### `sealed`
Marks a class/interface as sealed - only specified types can extend/implement it.

### `permits`
Lists which classes are allowed to extend the sealed class.

### Subclass Modifiers
Permitted subclasses must use one of:
- `final` - Cannot be extended further
- `sealed` - Can be extended by another sealed hierarchy
- `non-sealed` - Open for extension

## Why Sealed Classes?

### 1. Domain Modeling
Model finite sets of types precisely.

```java
sealed interface PaymentMethod
    permits CreditCard, DebitCard, Cash {}
```

### 2. Exhaustiveness Checking
Compiler ensures all cases are handled.

```java
double calculateArea(Shape shape) {
    return switch (shape) {
        case Circle c -> Math.PI * c.radius() * c.radius();
        case Rectangle r -> r.width() * r.height();
        case Triangle t -> 0.5 * t.base() * t.height();
        // No default needed - compiler knows all cases!
    };
}
```

### 3. Controlled Inheritance
Prevent unwanted extensions of your API.

## Sealed Class Patterns

### Pattern 1: Final Subclasses
```java
sealed class Result<T>
    permits Success, Failure {
}

final class Success<T> extends Result<T> {
    private final T value;
    public Success(T value) { this.value = value; }
    public T value() { return value; }
}

final class Failure<T> extends Result<T> {
    private final Exception error;
    public Failure(Exception error) { this.error = error; }
    public Exception error() { return error; }
}
```

### Pattern 2: Nested Sealed Hierarchy
```java
sealed class Vehicle
    permits Car, Boat, Aircraft {
}

sealed class Car extends Vehicle
    permits Sedan, SUV {
}

final class Sedan extends Car {}
final class SUV extends Car {}
final class Boat extends Vehicle {}
final class Aircraft extends Vehicle {}
```

### Pattern 3: Non-Sealed Escape Hatch
```java
sealed class LibraryClass
    permits PublicExtension, InternalUse {
}

non-sealed class PublicExtension extends LibraryClass {
    // Users can extend this
}

final class InternalUse extends LibraryClass {
    // Users cannot extend this
}
```

## Sealed Interfaces

```java
sealed interface Expression
    permits Constant, Addition, Multiplication {
}

record Constant(int value) implements Expression {}
record Addition(Expression left, Expression right) implements Expression {}
record Multiplication(Expression left, Expression right) implements Expression {}
```

## Benefits

### 1. Type Safety
Compiler ensures all possible types are handled.

### 2. Clear Intent
API clearly shows all possible implementations.

### 3. Better Pattern Matching
Works seamlessly with switch expressions.

### 4. Maintainability
Changing the hierarchy requires updating all switches.

### 5. Security
Prevents malicious extensions.

## Sealed Classes + Records

Perfect combination for algebraic data types:

```java
sealed interface Json permits JsonObject, JsonArray, JsonString, JsonNumber, JsonBoolean, JsonNull {}

record JsonObject(Map<String, Json> values) implements Json {}
record JsonArray(List<Json> elements) implements Json {}
record JsonString(String value) implements Json {}
record JsonNumber(double value) implements Json {}
record JsonBoolean(boolean value) implements Json {}
record JsonNull() implements Json {}

String toJsonString(Json json) {
    return switch (json) {
        case JsonObject obj -> "{...}";
        case JsonArray arr -> "[...]";
        case JsonString str -> "\"" + str.value() + "\"";
        case JsonNumber num -> String.valueOf(num.value());
        case JsonBoolean bool -> String.valueOf(bool.value());
        case JsonNull n -> "null";
    };
}
```

## Rules and Restrictions

### 1. Permits Clause
```java
// Same package - permits can be omitted
sealed class Shape {}
final class Circle extends Shape {}

// Different package - permits required
sealed class Shape permits com.example.Circle {}
```

### 2. Permitted Classes Must:
- Be accessible to the sealed class
- Directly extend the sealed class
- Choose: final, sealed, or non-sealed

### 3. Cannot Use
- With enums (already sealed)
- With records (already final)
- With local classes

## Java 25 Integration

Sealed classes in Java 25 work perfectly with:
- Pattern matching for switch
- Record patterns
- Virtual threads (for concurrent hierarchies)
- Modern APIs

## Use Cases

### 1. Result Types
```java
sealed interface Result<T, E>
    permits Success, Failure {
}

record Success<T, E>(T value) implements Result<T, E> {}
record Failure<T, E>(E error) implements Result<T, E> {}
```

### 2. State Machines
```java
sealed interface ConnectionState
    permits Disconnected, Connecting, Connected, Error {
}

record Disconnected() implements ConnectionState {}
record Connecting(long startTime) implements ConnectionState {}
record Connected(String sessionId) implements ConnectionState {}
record Error(Exception cause) implements ConnectionState {}
```

### 3. AST (Abstract Syntax Trees)
```java
sealed interface Expr permits BinOp, UnOp, Literal {}

record BinOp(Expr left, String op, Expr right) implements Expr {}
record UnOp(String op, Expr operand) implements Expr {}
record Literal(Object value) implements Expr {}
```

### 4. Event Hierarchies
```java
sealed interface DomainEvent
    permits UserEvent, OrderEvent, PaymentEvent {
}

sealed interface UserEvent extends DomainEvent
    permits UserCreated, UserDeleted {
}

record UserCreated(String userId, String email) implements UserEvent {}
record UserDeleted(String userId) implements UserEvent {}
```

## Examples in This Module

1. `SealedBasics.java` - Introduction to sealed classes
2. `SealedInterfaces.java` - Sealed interfaces
3. `SealedWithRecords.java` - Combining sealed classes and records
4. `PatternMatchingSealed.java` - Exhaustive pattern matching
5. `SealedHierarchies.java` - Complex hierarchies
6. `RealWorldExamples.java` - Practical use cases

## Best Practices

1. **Use with pattern matching** - Leverage exhaustiveness checking
2. **Combine with records** - For immutable data types
3. **Keep hierarchies shallow** - Easier to understand
4. **Document intent** - Explain why sealed
5. **Use for domain modeling** - Finite sets of types
6. **Consider alternatives** - Sometimes enums are simpler

## Practice Exercises

1. Model a payment system with sealed classes
2. Create an expression evaluator with sealed interfaces
3. Implement a state machine using sealed classes
4. Build a result type with error handling
5. Design a JSON parser with sealed types
6. Create an event system with sealed hierarchies

---

**Next Module**: [13-PatternMatching](../13-PatternMatching/README.md) - Modern type checking
