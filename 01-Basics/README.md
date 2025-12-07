# Module 1: Java Basics 🌟

Welcome to Module 1! Here you'll learn the fundamental building blocks of Java programming.

## 📖 Topics Covered

1. **Hello World** - Your first Java program
2. **Variables and Data Types** - Storing and managing data
3. **Operators** - Performing operations on data
4. **Input/Output** - Interacting with users
5. **Type Casting** - Converting between data types

## 🎯 Learning Objectives

By the end of this module, you will:
- Understand Java program structure
- Know how to declare and use variables
- Work with different data types
- Perform arithmetic and logical operations
- Get input from users and display output
- Convert between different data types

## 📝 Programs in This Module

### 1. HelloWorld.java
Your first Java program that prints "Hello, World!" to the console.

**Concepts**: Basic program structure, main method, print statements

### 2. Variables.java
Learn about different variable types and how to declare them.

**Concepts**: Data types (int, double, String, boolean, char), variable declaration, initialization

### 3. DataTypes.java
Explore all primitive and reference data types in Java.

**Concepts**: byte, short, int, long, float, double, char, boolean, String

### 4. Operators.java
Understanding arithmetic, relational, logical, and assignment operators.

**Concepts**: +, -, *, /, %, ==, !=, >, <, &&, ||, !, ++, --

### 5. UserInput.java
Getting input from users using Scanner class.

**Concepts**: Scanner class, reading different data types from console

### 6. TypeCasting.java
Converting one data type to another.

**Concepts**: Implicit casting (widening), explicit casting (narrowing)

### 7. Constants.java
Working with final variables that cannot be changed.

**Concepts**: final keyword, naming conventions for constants

### 8. StringOperations.java
Basic string manipulation and operations.

**Concepts**: String methods, concatenation, length, charAt, substring

## 💡 Key Concepts

### Java Program Structure
```
public class ClassName {
    public static void main(String[] args) {
        // Your code here
    }
}
```

### Data Types Hierarchy

**Primitive Types** (8 types):
- **Integer Types**: byte (8-bit), short (16-bit), int (32-bit), long (64-bit)
- **Floating-Point**: float (32-bit), double (64-bit)
- **Character**: char (16-bit Unicode)
- **Boolean**: boolean (true/false)

**Reference Types**:
- String, Arrays, Classes, Interfaces

### Variable Declaration Syntax
```
dataType variableName = value;
```

### Naming Conventions
- **Variables/Methods**: camelCase (myVariable, calculateSum)
- **Classes**: PascalCase (MyClass, StudentRecord)
- **Constants**: UPPER_CASE (MAX_VALUE, PI)

## 🔨 Compilation and Execution

```bash
# Compile a Java file
javac HelloWorld.java

# Run the compiled program
java HelloWorld
```

## 📚 Important Points

1. **Case Sensitivity**: Java is case-sensitive. `myVariable` and `myvariable` are different.

2. **Semicolons**: Every statement must end with a semicolon (;)

3. **File Naming**: The file name must match the public class name.

4. **main Method**: Entry point of any Java application.

5. **Comments**:
   - Single-line: `// This is a comment`
   - Multi-line: `/* This is a multi-line comment */`
   - Documentation: `/** JavaDoc comment */`

## 🎓 Practice Exercises

After going through all programs, try these exercises:

### Exercise 1: Personal Info
Create a program that stores and displays:
- Your name (String)
- Your age (int)
- Your height in meters (double)
- Whether you're a student (boolean)

### Exercise 2: Simple Calculator
Write a program that:
- Takes two numbers as input
- Performs all arithmetic operations (+, -, *, /, %)
- Displays the results

### Exercise 3: Temperature Converter
Create a program that:
- Converts Celsius to Fahrenheit
- Formula: F = (C × 9/5) + 32
- Takes Celsius as input and displays Fahrenheit

### Exercise 4: Circle Calculator
Write a program that:
- Takes radius as input
- Calculates area (π × r²)
- Calculates circumference (2 × π × r)
- Use Math.PI for π value

### Exercise 5: Swap Two Numbers
Create a program that swaps two numbers:
- Without using a third variable
- With using a third variable

## 🐛 Common Mistakes to Avoid

1. **Missing semicolons** at the end of statements
2. **Case sensitivity errors** (using `String` instead of `string`)
3. **Not initializing variables** before use
4. **Integer division** giving unexpected results (5/2 = 2, not 2.5)
5. **Comparing strings with ==** instead of `.equals()`

## 🔗 What's Next?

After mastering the basics, you'll move on to:
- **Module 2: Control Flow** - Making decisions and repeating actions

## 📖 Additional Resources

- [Java Language Basics (Oracle)](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)
- [Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)

---

**Ready to code? Start with HelloWorld.java!** 🚀