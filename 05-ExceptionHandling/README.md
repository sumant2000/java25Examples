# Module 5: Exception Handling ⚠️

Welcome to Module 5! Here you'll learn how to handle errors and exceptions gracefully in Java, making your programs robust and reliable.

## 📖 Topics Covered

1. **Try-Catch Blocks** - Basic exception handling
2. **Multiple Catch Blocks** - Handling different exceptions
3. **Finally Block** - Code that always executes
4. **Throw and Throws** - Creating and propagating exceptions
5. **Custom Exceptions** - Creating your own exception classes
6. **Exception Hierarchy** - Understanding Java's exception types
7. **Checked vs Unchecked** - Two categories of exceptions
8. **Best Practices** - Professional exception handling

## 🎯 Learning Objectives

By the end of this module, you will:
- Understand what exceptions are and why they occur
- Handle exceptions using try-catch blocks
- Use multiple catch blocks for different exception types
- Implement finally blocks for cleanup code
- Throw and propagate exceptions
- Create custom exception classes
- Distinguish between checked and unchecked exceptions
- Follow exception handling best practices
- Write robust, error-resistant code

## 📝 Programs in This Module

### 1. ExceptionBasics.java
Introduction to exceptions and basic try-catch usage.

**Concepts**: Exception types, try-catch syntax, exception messages

### 2. MultipleCatch.java
Handling multiple exception types.

**Concepts**: Multiple catch blocks, exception hierarchy, catch order

### 3. FinallyBlock.java
Using finally for cleanup operations.

**Concepts**: finally block, resource cleanup, execution guarantee

### 4. ThrowThrows.java
Throwing exceptions and method declarations.

**Concepts**: throw keyword, throws clause, exception propagation

### 5. CustomExceptions.java
Creating your own exception classes.

**Concepts**: Extending Exception, custom exception messages, use cases

### 6. TryWithResources.java
Automatic resource management (Java 7+).

**Concepts**: AutoCloseable, automatic resource cleanup, multi-resource handling

### 7. ExceptionChaining.java
Linking exceptions together.

**Concepts**: initCause(), getCause(), exception wrapping

### 8. BestPractices.java
Professional exception handling patterns.

**Concepts**: When to catch, when to throw, logging, recovery strategies

## 💡 Key Concepts

### Exception Hierarchy

```
Throwable
├── Error (System errors - don't catch)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── VirtualMachineError
│
└── Exception
    ├── IOException (Checked)
    │   ├── FileNotFoundException
    │   └── EOFException
    ├── SQLException (Checked)
    ├── ClassNotFoundException (Checked)
    │
    └── RuntimeException (Unchecked)
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        ├── IllegalArgumentException
        ├── NumberFormatException
        └── ArithmeticException
```

### Exception Types

**Checked Exceptions** (Compile-time checked):
- Must be caught or declared in throws clause
- Examples: IOException, SQLException, ClassNotFoundException
- Represent recoverable conditions
- Checked by compiler

**Unchecked Exceptions** (Runtime):
- Don't need to be caught or declared
- Examples: NullPointerException, ArrayIndexOutOfBoundsException
- Usually indicate programming errors
- Not checked by compiler

**Errors**:
- Serious problems that applications shouldn't catch
- Examples: OutOfMemoryError, StackOverflowError
- Indicate system-level issues

### Try-Catch Syntax

```java
try {
    // Code that might throw exception
} catch (ExceptionType1 e) {
    // Handle ExceptionType1
} catch (ExceptionType2 e) {
    // Handle ExceptionType2
} finally {
    // Always executes (optional)
}
```

### Try-With-Resources (Java 7+)

```java
try (Resource resource = new Resource()) {
    // Use resource
} catch (Exception e) {
    // Handle exception
}
// Resource automatically closed
```

## 🔍 Common Exceptions

### RuntimeException (Unchecked)

| Exception | Cause | Prevention |
|-----------|-------|------------|
| **NullPointerException** | Accessing null reference | Check for null before use |
| **ArrayIndexOutOfBoundsException** | Invalid array index | Validate index bounds |
| **ArithmeticException** | Division by zero | Check denominator |
| **NumberFormatException** | Invalid number format | Validate before parsing |
| **IllegalArgumentException** | Invalid method argument | Validate parameters |
| **ClassCastException** | Invalid type casting | Use instanceof |

### IOException (Checked)

| Exception | Cause | Handling |
|-----------|-------|----------|
| **FileNotFoundException** | File doesn't exist | Check file exists, provide alternative |
| **IOException** | I/O operation failed | Retry, log error, inform user |
| **EOFException** | Unexpected end of file | Validate file format |

## 🎓 Practice Exercises

### Exercise 1: Safe Division
Create a method that:
- Takes two numbers as input
- Performs division safely
- Handles division by zero
- Returns result or error message

### Exercise 2: File Reader
Write a program that:
- Reads a file path from user
- Opens and reads the file
- Handles FileNotFoundException
- Handles IOException
- Closes file properly

### Exercise 3: Array Access
Create a program that:
- Takes array and index from user
- Safely accesses array element
- Handles ArrayIndexOutOfBoundsException
- Provides user-friendly error message

### Exercise 4: Number Parser
Build a program that:
- Takes string input from user
- Parses to integer
- Handles NumberFormatException
- Allows retry on invalid input

### Exercise 5: Custom Banking Exception
Create custom exceptions:
- InsufficientFundsException
- InvalidAccountException
- AccountClosedException
- Use in simple banking operations

### Exercise 6: Multi-Operation Handler
Write a program that:
- Performs multiple operations (file, network, database simulation)
- Handles different exception types
- Uses finally for cleanup
- Logs all exceptions

### Exercise 7: Exception Chain
Create a program that:
- Throws low-level exception
- Catches and wraps in high-level exception
- Preserves original exception
- Displays full exception chain

### Exercise 8: Resource Manager
Build a resource manager that:
- Opens multiple resources
- Uses try-with-resources
- Handles exceptions during resource operations
- Ensures all resources are closed

### Exercise 9: Retry Mechanism
Implement a retry system that:
- Attempts operation multiple times
- Handles transient failures
- Gives up after max retries
- Logs each attempt

### Exercise 10: Validation Framework
Create a validation framework that:
- Validates user input
- Throws custom exceptions for invalid data
- Provides detailed error messages
- Allows multiple validation rules

## 🐛 Common Mistakes to Avoid

1. **Catching Exception or Throwable**
   ```java
   // ❌ Too broad - catches everything
   try {
       // code
   } catch (Exception e) { }
   
   // ✅ Catch specific exceptions
   try {
       // code
   } catch (IOException e) { }
   catch (SQLException e) { }
   ```

2. **Empty Catch Blocks**
   ```java
   // ❌ Swallowing exceptions
   try {
       // code
   } catch (Exception e) {
       // Do nothing
   }
   
   // ✅ At least log the exception
   try {
       // code
   } catch (Exception e) {
       e.printStackTrace();
       // Or use logging framework
   }
   ```

3. **Using Exceptions for Control Flow**
   ```java
   // ❌ Don't use exceptions for normal logic
   try {
       int value = array[index];
   } catch (ArrayIndexOutOfBoundsException e) {
       value = defaultValue;
   }
   
   // ✅ Use conditional checks
   int value = (index >= 0 && index < array.length) 
               ? array[index] : defaultValue;
   ```

4. **Not Closing Resources**
   ```java
   // ❌ Resource might not close
   FileReader reader = new FileReader("file.txt");
   // code that might throw exception
   reader.close();
   
   // ✅ Use try-with-resources
   try (FileReader reader = new FileReader("file.txt")) {
       // code
   }
   ```

5. **Catching and Rethrowing Without Adding Value**
   ```java
   // ❌ Useless catch
   try {
       // code
   } catch (IOException e) {
       throw e;
   }
   
   // ✅ Add context or just don't catch
   try {
       // code
   } catch (IOException e) {
       throw new RuntimeException("Failed to process file: " + filename, e);
   }
   ```

6. **Wrong Catch Order**
   ```java
   // ❌ Specific exception after general one
   try {
       // code
   } catch (Exception e) {
       // Handles all
   } catch (IOException e) {  // Unreachable!
       // Never executes
   }
   
   // ✅ Specific before general
   try {
       // code
   } catch (IOException e) {
       // Handle IOException
   } catch (Exception e) {
       // Handle other exceptions
   }
   ```

## 💎 Best Practices

### 1. Be Specific
Catch the most specific exception type possible.
```java
try {
    // code
} catch (FileNotFoundException e) {
    // Specific handling
} catch (IOException e) {
    // General I/O handling
}
```

### 2. Don't Swallow Exceptions
Always handle exceptions meaningfully.
```java
catch (Exception e) {
    logger.error("Failed to process request", e);
    // Inform user or take corrective action
}
```

### 3. Use Finally for Cleanup
Ensure resources are always released.
```java
Connection conn = null;
try {
    conn = getConnection();
    // use connection
} catch (SQLException e) {
    // handle
} finally {
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            // log error
        }
    }
}
```

### 4. Prefer Try-With-Resources
Let Java handle resource cleanup automatically.
```java
try (Connection conn = getConnection();
     Statement stmt = conn.createStatement()) {
    // use resources
} catch (SQLException e) {
    // handle
}
// Resources automatically closed
```

### 5. Provide Context
Include helpful information in exception messages.
```java
throw new IllegalArgumentException(
    "Invalid age: " + age + ". Age must be between 0 and 150"
);
```

### 6. Don't Catch What You Can't Handle
Only catch exceptions you can meaningfully handle.
```java
// If you can't recover, let it propagate
public void processFile(String filename) throws IOException {
    // Don't catch IOException if you can't handle it
    Files.readAllLines(Paths.get(filename));
}
```

### 7. Use Custom Exceptions
Create domain-specific exceptions for better semantics.
```java
public class InsufficientFundsException extends Exception {
    private double amount;
    private double balance;
    
    public InsufficientFundsException(double amount, double balance) {
        super("Insufficient funds: needed " + amount + ", have " + balance);
        this.amount = amount;
        this.balance = balance;
    }
}
```

### 8. Log Exceptions
Use logging framework instead of printStackTrace().
```java
catch (IOException e) {
    logger.error("Failed to read configuration file", e);
}
```

### 9. Clean Up in Finally or Try-With-Resources
Ensure cleanup code always runs.

### 10. Document Exceptions
Use @throws in JavaDoc to document exceptions.
```java
/**
 * Processes the payment.
 * 
 * @param amount the payment amount
 * @throws InsufficientFundsException if balance is insufficient
 * @throws InvalidAccountException if account is invalid
 */
public void processPayment(double amount) 
        throws InsufficientFundsException, InvalidAccountException {
    // implementation
}
```

## 📊 Exception Handling Decision Tree

```
Exception Occurred
├── Can I recover from this?
│   ├── Yes
│   │   └── Catch and handle
│   │       ├── Retry operation
│   │       ├── Use default value
│   │       ├── Inform user
│   │       └── Log and continue
│   └── No
│       └── Let it propagate
│           ├── Catch, add context, rethrow
│           └── Declare in throws clause
│
└── Is this a programming error?
    ├── Yes (RuntimeException)
    │   └── Fix the bug
    └── No (Checked Exception)
        └── Handle appropriately
```

## 🔗 What's Next?

After mastering exception handling, you'll move on to:
- **Module 6: File I/O** - Reading and writing files
- Advanced exception patterns in Module 10

## 📖 Additional Resources

- [Exception Handling (Oracle)](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [The try Block](https://docs.oracle.com/javase/tutorial/essential/exceptions/try.html)
- [The catch Blocks](https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html)
- [Exception Class Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Exception.html)
- [Effective Java - Exception Handling](https://www.oreilly.com/library/view/effective-java/9780134686097/)

## 💡 Pro Tips

1. **Use unchecked exceptions for programming errors** - NullPointerException, IllegalArgumentException
2. **Use checked exceptions for recoverable conditions** - IOException, SQLException
3. **Don't use exceptions for control flow** - Use conditional statements instead
4. **Always close resources** - Use try-with-resources or finally
5. **Fail fast** - Validate inputs early and throw exceptions immediately
6. **Provide meaningful messages** - Help developers debug issues
7. **Don't catch Exception or Throwable** - Be specific
8. **Log before rethrowing** - Preserve information
9. **Consider recovery strategies** - Retry, fallback, default values
10. **Test exception paths** - Write unit tests for error scenarios

## 🎭 Exception Handling Patterns

### 1. Retry Pattern
```java
int maxRetries = 3;
int attempt = 0;
while (attempt < maxRetries) {
    try {
        performOperation();
        break; // Success
    } catch (TransientException e) {
        attempt++;
        if (attempt >= maxRetries) {
            throw e; // Give up
        }
        Thread.sleep(1000); // Wait before retry
    }
}
```

### 2. Fail-Safe Pattern
```java
try {
    return fetchDataFromNetwork();
} catch (NetworkException e) {
    logger.warn("Network failed, using cache", e);
    return fetchDataFromCache();
}
```

### 3. Resource Management Pattern
```java
try (Resource1 r1 = new Resource1();
     Resource2 r2 = new Resource2()) {
    r1.use();
    r2.use();
} // Both automatically closed
```

### 4. Exception Translation Pattern
```java
try {
    performLowLevelOperation();
} catch (LowLevelException e) {
    throw new HighLevelException("Operation failed", e);
}
```

---

**Ready to master exception handling? Start with ExceptionBasics.java!** 🚀

**Estimated Time**: 3-4 days | **Difficulty**: ⭐⭐⭐ Intermediate