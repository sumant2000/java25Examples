# Java Quick Reference Guide 📚

A concise reference for Java syntax and concepts. Perfect for quick lookups while coding!

---

## Table of Contents
- [Basic Syntax](#basic-syntax)
- [Data Types](#data-types)
- [Operators](#operators)
- [Control Flow](#control-flow)
- [Arrays](#arrays)
- [Strings](#strings)
- [OOP Concepts](#oop-concepts)
- [Common Methods](#common-methods)
- [Collections](#collections)
- [Exception Handling](#exception-handling)

---

## Basic Syntax

### Program Structure
```java
public class ClassName {
    public static void main(String[] args) {
        // Your code here
    }
}
```

### Comments
```java
// Single-line comment

/* Multi-line
   comment */

/** JavaDoc comment */
```

### Print Output
```java
System.out.println("With newline");
System.out.print("Without newline");
System.out.printf("Formatted: %d", number);
```

### Input
```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
String text = scanner.nextLine();
int number = scanner.nextInt();
double decimal = scanner.nextDouble();
scanner.close();
```

---

## Data Types

### Primitive Types
```java
byte    b = 100;           // 8-bit  (-128 to 127)
short   s = 10000;         // 16-bit (-32,768 to 32,767)
int     i = 100000;        // 32-bit (-2^31 to 2^31-1)
long    l = 10000000000L;  // 64-bit (-2^63 to 2^63-1)
float   f = 3.14f;         // 32-bit
double  d = 3.14159;       // 64-bit
char    c = 'A';           // 16-bit Unicode
boolean b = true;          // true or false
```

### Reference Types
```java
String str = "Hello";
int[] array = {1, 2, 3};
ClassName obj = new ClassName();
```

### Type Casting
```java
// Widening (automatic)
int i = 100;
double d = i;

// Narrowing (manual)
double d = 9.78;
int i = (int) d;  // i = 9
```

---

## Operators

### Arithmetic
```java
+   // Addition
-   // Subtraction
*   // Multiplication
/   // Division
%   // Modulus (remainder)
++  // Increment
--  // Decrement
```

### Comparison
```java
==  // Equal to
!=  // Not equal to
>   // Greater than
<   // Less than
>=  // Greater than or equal
<=  // Less than or equal
```

### Logical
```java
&&  // AND
||  // OR
!   // NOT
```

### Assignment
```java
=   // Assign
+=  // Add and assign
-=  // Subtract and assign
*=  // Multiply and assign
/=  // Divide and assign
%=  // Modulus and assign
```

### Ternary
```java
result = (condition) ? valueIfTrue : valueIfFalse;
```

---

## Control Flow

### If-Else
```java
if (condition) {
    // code
} else if (anotherCondition) {
    // code
} else {
    // code
}
```

### Switch
```java
switch (variable) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    default:
        // code
}
```

### For Loop
```java
for (int i = 0; i < 10; i++) {
    // code
}

// For-each
for (Type element : collection) {
    // code
}
```

### While Loop
```java
while (condition) {
    // code
}
```

### Do-While Loop
```java
do {
    // code
} while (condition);
```

### Break & Continue
```java
break;     // Exit loop
continue;  // Skip to next iteration
```

---

## Arrays

### Declaration & Initialization
```java
// Method 1
int[] arr = new int[5];

// Method 2
int[] arr = {1, 2, 3, 4, 5};

// Method 3
int[] arr = new int[]{1, 2, 3, 4, 5};
```

### Access & Modify
```java
int value = arr[0];  // Access
arr[0] = 10;         // Modify
int length = arr.length;  // Length
```

### Multi-dimensional
```java
int[][] matrix = new int[3][3];
int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
```

### Common Operations
```java
Arrays.toString(arr);           // Print array
Arrays.sort(arr);               // Sort array
Arrays.fill(arr, value);        // Fill with value
Arrays.equals(arr1, arr2);      // Compare arrays
```

---

## Strings

### Creation
```java
String s1 = "Hello";
String s2 = new String("Hello");
```

### Common Methods
```java
s.length()                  // Length
s.charAt(index)             // Character at index
s.substring(start, end)     // Substring
s.toLowerCase()             // To lowercase
s.toUpperCase()             // To uppercase
s.trim()                    // Remove whitespace
s.equals(other)             // Compare content
s.equalsIgnoreCase(other)   // Compare ignore case
s.contains(substring)       // Check contains
s.startsWith(prefix)        // Check starts with
s.endsWith(suffix)          // Check ends with
s.indexOf(substring)        // Find index
s.replace(old, new)         // Replace
s.split(delimiter)          // Split to array
String.join(delimiter, arr) // Join array
```

### Formatting
```java
String.format("Name: %s, Age: %d", name, age);
```

---

## OOP Concepts

### Class Definition
```java
public class ClassName {
    // Instance variables
    private int field;
    
    // Constructor
    public ClassName(int field) {
        this.field = field;
    }
    
    // Method
    public void method() {
        // code
    }
    
    // Getter
    public int getField() {
        return field;
    }
    
    // Setter
    public void setField(int field) {
        this.field = field;
    }
}
```

### Object Creation
```java
ClassName obj = new ClassName(value);
obj.method();
```

### Inheritance
```java
public class Child extends Parent {
    @Override
    public void method() {
        super.method();  // Call parent method
        // Additional code
    }
}
```

### Interface
```java
public interface InterfaceName {
    void method();  // Abstract method
}

public class ClassName implements InterfaceName {
    @Override
    public void method() {
        // Implementation
    }
}
```

### Abstract Class
```java
public abstract class AbstractClass {
    abstract void abstractMethod();
    
    void concreteMethod() {
        // Implementation
    }
}
```

### Access Modifiers
```java
public    // Accessible everywhere
protected // Accessible in package and subclasses
default   // Accessible in package only (no keyword)
private   // Accessible in class only
```

### Static Members
```java
static int staticVariable;
static void staticMethod() { }

ClassName.staticVariable;
ClassName.staticMethod();
```

---

## Common Methods

### Math Class
```java
Math.abs(x)         // Absolute value
Math.max(a, b)      // Maximum
Math.min(a, b)      // Minimum
Math.pow(base, exp) // Power
Math.sqrt(x)        // Square root
Math.random()       // Random [0.0, 1.0)
Math.round(x)       // Round
Math.ceil(x)        // Ceiling
Math.floor(x)       // Floor
Math.PI             // Pi constant
Math.E              // Euler's number
```

### Object Class
```java
obj.toString()      // String representation
obj.equals(other)   // Compare objects
obj.hashCode()      // Hash code
```

---

## Collections

### ArrayList
```java
import java.util.ArrayList;

ArrayList<Type> list = new ArrayList<>();
list.add(element);           // Add
list.get(index);             // Get
list.set(index, element);    // Set
list.remove(index);          // Remove
list.size();                 // Size
list.contains(element);      // Check contains
list.clear();                // Clear all
```

### HashMap
```java
import java.util.HashMap;

HashMap<KeyType, ValueType> map = new HashMap<>();
map.put(key, value);         // Put
map.get(key);                // Get
map.remove(key);             // Remove
map.containsKey(key);        // Check key
map.containsValue(value);    // Check value
map.size();                  // Size
map.keySet();                // All keys
map.values();                // All values
```

### HashSet
```java
import java.util.HashSet;

HashSet<Type> set = new HashSet<>();
set.add(element);            // Add
set.remove(element);         // Remove
set.contains(element);       // Check contains
set.size();                  // Size
set.clear();                 // Clear all
```

---

## Exception Handling

### Try-Catch
```java
try {
    // Code that may throw exception
} catch (ExceptionType e) {
    // Handle exception
} finally {
    // Always executes
}
```

### Multiple Catch
```java
try {
    // code
} catch (IOException e) {
    // handle IOException
} catch (Exception e) {
    // handle other exceptions
}
```

### Throw Exception
```java
throw new ExceptionType("Error message");
```

### Method Throws
```java
public void method() throws ExceptionType {
    // code
}
```

### Common Exceptions
```java
NullPointerException        // Null reference
ArrayIndexOutOfBoundsException
NumberFormatException
IllegalArgumentException
IOException
FileNotFoundException
```

---

## Common Patterns

### Reading File
```java
import java.io.*;

BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
String line;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}
reader.close();
```

### Writing File
```java
BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
writer.write("Hello, World!");
writer.newLine();
writer.close();
```

### Lambda Expression
```java
// Syntax
(parameters) -> expression
(parameters) -> { statements; }

// Example
list.forEach(item -> System.out.println(item));
```

### Stream API
```java
list.stream()
    .filter(x -> x > 0)
    .map(x -> x * 2)
    .collect(Collectors.toList());
```

---

## Naming Conventions

```java
ClassName           // PascalCase
methodName          // camelCase
variableName        // camelCase
CONSTANT_NAME       // UPPER_SNAKE_CASE
package_name        // lowercase
```

---

## Keyboard Shortcuts (IntelliJ IDEA)

```
Ctrl + Space        // Auto-complete
Ctrl + /            // Comment line
Ctrl + Shift + /    // Block comment
Ctrl + Alt + L      // Format code
Shift + F10         // Run
Shift + F9          // Debug
Alt + Enter         // Quick fix
Ctrl + Click        // Go to definition
```

---

## Tips & Best Practices

1. **Always close resources** (Scanner, files, connections)
2. **Use meaningful names** for variables and methods
3. **Follow naming conventions**
4. **Comment complex logic**
5. **Handle exceptions properly**
6. **Use appropriate access modifiers**
7. **Prefer composition over inheritance**
8. **Keep methods short and focused**
9. **Write tests** for your code
10. **Learn to read documentation**

---

## Common Mistakes to Avoid

```java
// ❌ Wrong
if (str == "hello")  // Don't use == for strings

// ✅ Correct
if (str.equals("hello"))

// ❌ Wrong
5 / 2  // Result: 2 (integer division)

// ✅ Correct
5.0 / 2  // Result: 2.5

// ❌ Wrong
Scanner not closed

// ✅ Correct
scanner.close();

// ❌ Wrong
Catching generic Exception first

// ✅ Correct
Catch specific exceptions first
```

---

**Keep this reference handy while coding! 📌**

For detailed explanations, refer to the module READMEs.