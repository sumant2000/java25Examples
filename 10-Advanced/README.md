# Module 10: Advanced Topics 🎓

## Overview

This module covers advanced Java concepts that are essential for professional developers. These topics build upon the fundamentals and introduce powerful features for writing robust, maintainable, and efficient code.

## Topics Covered

### 1. Generics
Type parameters that enable type-safe code reuse.

```java
public class Box<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

### 2. Annotations
Metadata for code that can be processed at compile-time or runtime.

```java
@Override
@Deprecated
@FunctionalInterface
public interface MyInterface { }
```

### 3. Reflection
Runtime inspection and manipulation of classes, methods, and fields.

```java
Class<?> clazz = String.class;
Method[] methods = clazz.getDeclaredMethods();
```

### 4. Optional
Container for potentially null values, avoiding NullPointerException.

```java
Optional<String> optional = Optional.of("value");
String result = optional.orElse("default");
```

### 5. Date and Time API (java.time)
Modern date and time handling (Java 8+).

```java
LocalDate date = LocalDate.now();
LocalDateTime dateTime = LocalDateTime.now();
Duration duration = Duration.ofHours(2);
```

### 6. Module System (Java 9+)
Organizing code into modules with explicit dependencies.

```java
module com.example.app {
    requires java.sql;
    exports com.example.api;
}
```

### 7. Var Keyword (Java 10+)
Local variable type inference.

```java
var list = new ArrayList<String>();
var map = Map.of("key", "value");
```

### 8. Text Blocks (Java 15+)
Multi-line string literals.

```java
String json = """
    {
        "name": "John",
        "age": 30
    }
    """;
```

### 9. Switch Expressions (Java 14+)
Enhanced switch as an expression.

```java
String result = switch (day) {
    case MONDAY, FRIDAY -> "Work day";
    case SATURDAY, SUNDAY -> "Weekend";
    default -> "Other";
};
```

### 10. Helpful NullPointerExceptions (Java 14+)
Detailed NPE messages showing exactly what was null.

## Advanced Design Patterns

### Singleton Pattern
```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() { return INSTANCE; }
}
```

### Factory Pattern
```java
public interface Shape { void draw(); }
public class ShapeFactory {
    public static Shape createShape(String type) {
        return switch (type) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            default -> throw new IllegalArgumentException();
        };
    }
}
```

### Builder Pattern
```java
public class Person {
    private final String name;
    private final int age;
    
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }
    
    public static class Builder {
        private String name;
        private int age;
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        
        public Person build() {
            return new Person(this);
        }
    }
}
```

## Best Practices

### 1. Code Organization
- Package by feature, not by layer
- Use meaningful names
- Keep classes focused (Single Responsibility)
- Favor composition over inheritance

### 2. Error Handling
- Use specific exception types
- Don't swallow exceptions
- Use try-with-resources
- Fail fast

### 3. Performance
- Use appropriate data structures
- Avoid premature optimization
- Profile before optimizing
- Use primitive streams for numbers

### 4. Concurrency
- Prefer immutability
- Use concurrent collections
- Understand happens-before relationships
- Use virtual threads for I/O operations

### 5. Testing
- Write unit tests
- Use meaningful assertions
- Test edge cases
- Mock external dependencies

## Java 25 Features Integration

This module integrates all modern Java features:
- Records for data classes
- Pattern matching for type checks
- Sealed classes for restricted hierarchies
- Virtual threads for concurrency
- Modern APIs and syntax improvements

## Examples in This Module

1. `GenericsDemo.java` - Generic classes and methods
2. `AnnotationsDemo.java` - Creating and using annotations
3. `ReflectionDemo.java` - Runtime class inspection
4. `OptionalDemo.java` - Optional usage patterns
5. `DateTimeDemo.java` - Modern date/time API
6. `VarDemo.java` - Local variable type inference
7. `TextBlocksDemo.java` - Multi-line strings
8. `SwitchExpressionsDemo.java` - Enhanced switch
9. `DesignPatterns.java` - Common patterns
10. `BestPractices.java` - Code quality examples

## Practice Exercises

1. Create a generic cache implementation
2. Build a custom annotation processor
3. Implement a plugin system using reflection
4. Create a date range validator
5. Design a fluent API using builder pattern
6. Refactor legacy code to modern Java
7. Implement concurrent data processing
8. Write comprehensive unit tests

## Additional Resources

- Effective Java by Joshua Bloch
- Java Concurrency in Practice
- Clean Code by Robert C. Martin
- Design Patterns: Elements of Reusable Object-Oriented Software

---

**Related Modules**:
- [11-Records](../11-Records/README.md) - Immutable data carriers
- [12-SealedClasses](../12-SealedClasses/README.md) - Restricted inheritance
- [13-PatternMatching](../13-PatternMatching/README.md) - Modern type checking
- [14-VirtualThreads](../14-VirtualThreads/README.md) - Lightweight concurrency
