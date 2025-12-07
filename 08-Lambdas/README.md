# Module 8: Lambda Expressions 🎯

## What are Lambda Expressions?

Lambda expressions were introduced in Java 8 and represent a concise way to implement functional interfaces. They enable you to treat functionality as a method argument, or treat code as data.

## Key Concepts

### 1. Functional Interface
An interface with exactly one abstract method (SAM - Single Abstract Method).

### 2. Lambda Syntax
```java
(parameters) -> expression
// or
(parameters) -> { statements; }
```

### 3. Benefits
- More concise code
- Easier parallel processing
- Better functional programming support
- More readable code for simple operations

## Lambda Expression Syntax

### Basic Syntax
```java
// No parameters
() -> System.out.println("Hello")

// Single parameter (parentheses optional)
x -> x * x
(x) -> x * x

// Multiple parameters
(x, y) -> x + y

// Multiple statements (requires braces)
(x, y) -> {
    int sum = x + y;
    return sum;
}
```

## Common Functional Interfaces

### Predicate<T>
- Takes one argument, returns boolean
- Method: `boolean test(T t)`

### Function<T, R>
- Takes one argument, returns a result
- Method: `R apply(T t)`

### Consumer<T>
- Takes one argument, returns nothing
- Method: `void accept(T t)`

### Supplier<T>
- Takes no arguments, returns a result
- Method: `T get()`

### BiFunction<T, U, R>
- Takes two arguments, returns a result
- Method: `R apply(T t, U u)`

## Method References

Method references are shorthand for lambdas calling a specific method.

### Types of Method References:
1. **Static method**: `ClassName::staticMethod`
2. **Instance method of particular object**: `object::instanceMethod`
3. **Instance method of arbitrary object**: `ClassName::instanceMethod`
4. **Constructor**: `ClassName::new`

## Variable Capture

Lambda expressions can access variables from the enclosing scope if they are:
- Final
- Effectively final (not modified after initialization)

## Best Practices

1. **Keep lambdas short** - If it's more than a few lines, consider a method reference or separate method
2. **Use method references** when possible for clarity
3. **Avoid side effects** - Lambdas should be pure functions when possible
4. **Use appropriate functional interfaces** - Don't reinvent the wheel
5. **Be careful with variable capture** - Understand the effectively final requirement

## Common Use Cases

1. **Collection processing** - Sorting, filtering, mapping
2. **Event handling** - GUI applications
3. **Thread execution** - Runnable tasks
4. **Callbacks** - Asynchronous operations
5. **Strategy pattern** - Pluggable behaviors

## Examples in This Module

1. `LambdaBasics.java` - Fundamental lambda syntax and usage
2. `FunctionalInterfaces.java` - Working with built-in functional interfaces
3. `MethodReferences.java` - All types of method references
4. `LambdaWithCollections.java` - Using lambdas with collections
5. `CustomFunctionalInterface.java` - Creating and using custom functional interfaces
6. `VariableCapture.java` - Understanding variable capture and scope

## Practice Exercises

1. Convert anonymous inner classes to lambda expressions
2. Create a calculator using functional interfaces
3. Implement a custom sort using lambdas
4. Filter and transform a list using lambdas
5. Create a simple event handler system using lambdas

---

**Next Module**: [09-Streams](../09-Streams/README.md) - Learn about the Stream API for functional-style operations
