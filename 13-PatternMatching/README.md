# Module 13: Pattern Matching (Java 16-25) 🎯

## What is Pattern Matching?

Pattern matching is a powerful feature that allows you to test whether an object has a particular structure and extract components from it in a concise way. It eliminates verbose type-checking and casting code.

## Evolution in Java

- **Java 14-15**: Pattern Matching for `instanceof` (Preview)
- **Java 16**: Pattern Matching for `instanceof` (Standard)
- **Java 17-20**: Pattern Matching for `switch` (Preview/Refinements)
- **Java 21**: Pattern Matching for `switch` (Standard)
- **Java 21+**: Record Patterns
- **Java 25**: Enhanced patterns with primitive types and additional refinements

## Pattern Matching for instanceof

### Before Pattern Matching
```java
if (obj instanceof String) {
    String str = (String) obj;  // Explicit cast
    System.out.println(str.length());
}
```

### With Pattern Matching
```java
if (obj instanceof String str) {  // Test and bind
    System.out.println(str.length());  // str is in scope
}
```

## Pattern Matching for switch

### Traditional switch
```java
switch (day) {
    case MONDAY:
    case FRIDAY:
        System.out.println("Work day");
        break;
    case SATURDAY:
    case SUNDAY:
        System.out.println("Weekend");
        break;
}
```

### Pattern Matching switch (Java 21+)
```java
String result = switch (obj) {
    case String s -> "String of length " + s.length();
    case Integer i -> "Integer: " + i;
    case null -> "null value";
    default -> "Unknown type";
};
```

## Record Patterns (Java 21+)

### Deconstructing Records
```java
record Point(int x, int y) {}

// Pattern matching with records
if (obj instanceof Point(int x, int y)) {
    System.out.println("Point at " + x + ", " + y);
}

// In switch expressions
String desc = switch (shape) {
    case Point(int x, int y) -> "Point at " + x + ", " + y;
    case Circle(int radius) -> "Circle with radius " + radius;
    default -> "Unknown shape";
};
```

## Guarded Patterns

Add conditions to patterns:
```java
String desc = switch (obj) {
    case String s when s.length() > 5 -> "Long string";
    case String s -> "Short string";
    case Integer i when i > 0 -> "Positive number";
    case Integer i -> "Non-positive number";
    default -> "Other type";
};
```

## Nested Patterns

```java
record Point(int x, int y) {}
record Rectangle(Point topLeft, Point bottomRight) {}

if (shape instanceof Rectangle(Point(int x1, int y1), Point(int x2, int y2))) {
    int width = x2 - x1;
    int height = y2 - y1;
    System.out.println("Rectangle: " + width + "x" + height);
}
```

## Pattern Matching Types

### Type Patterns
```java
if (obj instanceof String s) { /* use s */ }
```

### Record Patterns
```java
if (obj instanceof Point(int x, int y)) { /* use x, y */ }
```

### Guarded Patterns
```java
case String s when s.length() > 10 -> /* ... */
```

### Null Patterns
```java
case null -> /* handle null */
```

### Default Pattern
```java
default -> /* fallback */
```

## Java 25 Enhancements

Java 25 continues to refine pattern matching with:
- **Primitive type patterns**: Better handling of primitives
- **Enhanced exhaustiveness checking**: Compiler improvements
- **Performance optimizations**: Faster pattern matching
- **Better IDE support**: Improved tooling

## Benefits

1. **Less Boilerplate**: No explicit casting needed
2. **Type Safety**: Compiler ensures correctness
3. **Readability**: Intent is clearer
4. **Maintainability**: Easier to understand and modify
5. **Exhaustiveness**: Compiler checks all cases (with sealed classes)
6. **Performance**: Potentially more efficient than traditional approaches

## Common Patterns

### Type Testing and Extraction
```java
if (obj instanceof String s && s.length() > 5) {
    System.out.println("Long string: " + s);
}
```

### Polymorphic Behavior
```java
String result = switch (shape) {
    case Circle c -> "Area: " + (Math.PI * c.radius() * c.radius());
    case Rectangle r -> "Area: " + (r.width() * r.height());
    case Triangle t -> "Area: " + (0.5 * t.base() * t.height());
};
```

### Null Safety
```java
String result = switch (obj) {
    case null -> "No value";
    case String s -> s.toUpperCase();
    default -> "Unknown";
};
```

## Best Practices

1. **Use pattern variables promptly** - Don't let them drift far from declaration
2. **Prefer exhaustive switches** - Cover all cases explicitly
3. **Keep patterns simple** - Nested patterns can be hard to read
4. **Combine with records** - Records and patterns work beautifully together
5. **Use guarded patterns sparingly** - They can make code harder to understand
6. **Leverage sealed classes** - For exhaustiveness checking

## Examples in This Module

1. `PatternMatchingInstanceof.java` - instanceof with patterns
2. `PatternMatchingSwitch.java` - Switch expressions with patterns
3. `RecordPatterns.java` - Deconstructing records
4. `GuardedPatterns.java` - Patterns with conditions
5. `NestedPatterns.java` - Complex nested patterns
6. `SealedClassPatterns.java` - Exhaustive pattern matching
7. `PracticalExamples.java` - Real-world use cases

## Practice Exercises

1. Refactor instanceof chains to pattern matching
2. Create a shape hierarchy with pattern-based area calculation
3. Implement a JSON parser using pattern matching
4. Build an expression evaluator with patterns
5. Create a type-safe visitor pattern using switch expressions

---

**Next Module**: [14-VirtualThreads](../14-VirtualThreads/README.md) - Lightweight concurrency
