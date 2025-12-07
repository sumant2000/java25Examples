# Module 11: Records (Java 14+) 📦

## What are Records?

Records are a special kind of class in Java designed to act as transparent carriers for immutable data. Introduced as a preview in Java 14 and finalized in Java 16, records eliminate boilerplate code for data-holding classes.

## Key Features

### 1. Immutable by Default
All fields are `final` and initialized through the constructor.

### 2. Automatic Generation
Records automatically provide:
- Constructor
- `toString()` method
- `equals()` and `hashCode()` methods
- Getter methods (no "get" prefix)

### 3. Compact Syntax
```java
// Traditional class (before records)
public final class Point {
    private final int x;
    private final int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    @Override
    public boolean equals(Object o) { /* ... */ }
    
    @Override
    public int hashCode() { /* ... */ }
    
    @Override
    public String toString() { /* ... */ }
}

// With records (Java 14+)
public record Point(int x, int y) {}
```

## Record Syntax

```java
// Basic record
record Person(String name, int age) {}

// With validation
record Person(String name, int age) {
    // Compact constructor
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
    }
}

// With additional methods
record Point(int x, int y) {
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}

// With static members
record MathConstants(double pi, double e) {
    static final MathConstants DEFAULTS = new MathConstants(3.14159, 2.71828);
}
```

## Components

### Record Components
The parameters in the record header are called **components**. They define:
- Private final fields
- Public accessor methods (without "get" prefix)
- Constructor parameters

### Constructors

**Canonical Constructor** (automatically generated):
```java
record Person(String name, int age) {}
// Generated: public Person(String name, int age) { ... }
```

**Compact Constructor** (for validation):
```java
record Person(String name, int age) {
    public Person {
        if (age < 0) throw new IllegalArgumentException();
    }
}
```

**Custom Constructor** (delegates to canonical):
```java
record Person(String name, int age) {
    public Person(String name) {
        this(name, 0);
    }
}
```

## What Records Can Have

✓ **Allowed:**
- Instance methods
- Static methods and fields
- Compact constructor
- Additional constructors
- Generic type parameters
- Implement interfaces
- Nested records
- Annotations

✗ **Not Allowed:**
- Additional instance fields (beyond components)
- Extend other classes (implicitly extend `Record`)
- Be abstract
- Native methods

## When to Use Records

✓ **Use records for:**
- Data Transfer Objects (DTOs)
- Configuration classes
- Query results
- Immutable data holders
- Value objects
- Return types for multiple values

✗ **Don't use records for:**
- Classes that need inheritance
- Mutable state
- Classes with complex business logic
- When you need setters
- JavaBeans that require zero-arg constructor

## Records vs Classes

| Feature | Record | Class |
|---------|--------|-------|
| Mutability | Immutable | Mutable/Immutable |
| Boilerplate | Minimal | Manual or generated |
| Inheritance | Cannot extend | Can extend |
| Fields | Only components | Any fields |
| Purpose | Data carrier | Any purpose |

## Java 25 Enhancements

Java 25 continues to refine records with:
- Better pattern matching integration
- Enhanced serialization support
- Improved IDE tooling
- Performance optimizations

## Benefits

1. **Less Code**: Dramatically reduces boilerplate
2. **Immutability**: Thread-safe by default
3. **Readability**: Clear intent as data carrier
4. **Type Safety**: Compile-time guarantees
5. **Performance**: Optimized by JVM
6. **Pattern Matching**: Works seamlessly with modern Java features

## Examples in This Module

1. `RecordBasics.java` - Introduction to records
2. `RecordConstructors.java` - Different constructor types
3. `RecordMethods.java` - Adding methods to records
4. `RecordValidation.java` - Input validation in records
5. `RecordPatterns.java` - Common record patterns
6. `RecordVsClass.java` - Comparison with traditional classes
7. `NestedRecords.java` - Working with nested records

## Practice Exercises

1. Create a `Book` record with validation
2. Convert existing DTOs to records
3. Implement a record that represents a coordinate system
4. Create records for a shopping cart system
5. Use records with collections and streams
6. Implement pattern matching with records

---

**Next Module**: [12-SealedClasses](../12-SealedClasses/README.md) - Restricted class hierarchies
