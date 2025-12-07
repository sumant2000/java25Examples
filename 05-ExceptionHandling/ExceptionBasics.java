/**
 * ExceptionBasics.java
 *
 * This program demonstrates the fundamentals of exception handling in Java.
 * Exceptions are events that disrupt the normal flow of program execution.
 *
 * Key Concepts:
 * - What are exceptions?
 * - Try-catch blocks
 * - Exception types (checked vs unchecked)
 * - Exception messages and stack traces
 * - Common exceptions
 * - Basic error recovery
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionBasics {

    public static void main(String[] args) {

        System.out.println("========== EXCEPTION HANDLING BASICS ==========\n");

        // ========== WHAT ARE EXCEPTIONS? ==========

        System.out.println("--- 1. What Are Exceptions? ---\n");

        System.out.println("An exception is an event that disrupts normal program flow.");
        System.out.println("Without exception handling, programs crash when errors occur.\n");

        // Example of crash without exception handling (commented out)
        // int result = 10 / 0;  // ArithmeticException - would crash program

        System.out.println("With exception handling, we can gracefully handle errors.\n");


        // ========== BASIC TRY-CATCH ==========

        System.out.println("\n--- 2. Basic Try-Catch ---\n");

        try {
            System.out.println("Attempting division by zero...");
            int result = 10 / 0;  // This will throw ArithmeticException
            System.out.println("Result: " + result);  // Never executes
        } catch (ArithmeticException e) {
            System.out.println("Error caught: Cannot divide by zero!");
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        }

        System.out.println("Program continues after exception...\n");


        // ========== EXCEPTION INFORMATION ==========

        System.out.println("\n--- 3. Exception Information ---\n");

        try {
            int[] numbers = {1, 2, 3};
            int value = numbers[5];  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Class: " + e.getClass().getName());
            System.out.println("Cause: " + e.getCause());
            System.out.println("\nStack trace:");
            e.printStackTrace();
        }


        // ========== MULTIPLE EXCEPTION SCENARIOS ==========

        System.out.println("\n\n--- 4. Common Exception Scenarios ---\n");

        // Scenario 1: NullPointerException
        System.out.println("Scenario 1: NullPointerException");
        try {
            String text = null;
            int length = text.length();  // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: Trying to access method on null object");
            System.out.println("Message: " + e.getMessage() + "\n");
        }

        // Scenario 2: NumberFormatException
        System.out.println("Scenario 2: NumberFormatException");
        try {
            String notANumber = "abc";
            int number = Integer.parseInt(notANumber);
        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot convert '" + "abc" + "' to number");
            System.out.println("Message: " + e.getMessage() + "\n");
        }

        // Scenario 3: ArrayIndexOutOfBoundsException
        System.out.println("Scenario 3: ArrayIndexOutOfBoundsException");
        try {
            int[] array = new int[5];
            array[10] = 100;  // Index out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds");
            System.out.println("Message: " + e.getMessage() + "\n");
        }

        // Scenario 4: ArithmeticException
        System.out.println("Scenario 4: ArithmeticException");
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: Arithmetic error occurred");
            System.out.println("Message: " + e.getMessage() + "\n");
        }

        // Scenario 5: StringIndexOutOfBoundsException
        System.out.println("Scenario 5: StringIndexOutOfBoundsException");
        try {
            String text = "Hello";
            char ch = text.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: String index out of bounds");
            System.out.println("Message: " + e.getMessage() + "\n");
        }


        // ========== HANDLING VS NOT HANDLING ==========

        System.out.println("\n--- 5. With vs Without Exception Handling ---\n");

        // Without exception handling (would crash entire program)
        System.out.println("Without exception handling:");
        System.out.println("If error occurs, program terminates immediately.");
        System.out.println("Subsequent code never executes.\n");

        // With exception handling
        System.out.println("With exception handling:");
        try {
            int[] arr = {1, 2, 3};
            System.out.println("Accessing valid index: " + arr[1]);
            System.out.println("Accessing invalid index: " + arr[10]);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println("Program continues executing...\n");


        // ========== CHECKED VS UNCHECKED EXCEPTIONS ==========

        System.out.println("\n--- 6. Checked vs Unchecked Exceptions ---\n");

        System.out.println("UNCHECKED EXCEPTIONS (RuntimeException):");
        System.out.println("- Not checked at compile time");
        System.out.println("- Usually indicate programming errors");
        System.out.println("- Examples: NullPointerException, ArrayIndexOutOfBoundsException");
        System.out.println("- Don't need to be caught or declared\n");

        // Unchecked exception example
        try {
            int result = divideNumbers(10, 0);  // May throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Unchecked exception caught: " + e.getMessage() + "\n");
        }

        System.out.println("CHECKED EXCEPTIONS:");
        System.out.println("- Checked at compile time");
        System.out.println("- Represent recoverable conditions");
        System.out.println("- Examples: IOException, SQLException, FileNotFoundException");
        System.out.println("- Must be caught or declared in throws clause\n");

        // Checked exception example
        try {
            readFile("nonexistent.txt");  // May throw FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("Checked exception caught: File not found");
        } catch (IOException e) {
            System.out.println("Checked exception caught: I/O error");
        }


        // ========== EXCEPTION PROPAGATION ==========

        System.out.println("\n\n--- 7. Exception Propagation ---\n");

        System.out.println("Exceptions propagate up the call stack until caught.\n");

        try {
            method1();
        } catch (Exception e) {
            System.out.println("\nException caught in main method");
            System.out.println("Call stack was: main -> method1 -> method2 -> method3");
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 8. Practical Examples ---\n");

        // Example 1: Safe division
        System.out.println("Example 1: Safe Division");
        int result1 = safeDivide(10, 2);
        System.out.println("10 / 2 = " + result1);
        int result2 = safeDivide(10, 0);
        System.out.println("10 / 0 = " + result2 + " (using default)\n");

        // Example 2: Safe array access
        System.out.println("Example 2: Safe Array Access");
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Value at index 2: " + safeArrayAccess(numbers, 2));
        System.out.println("Value at index 10: " + safeArrayAccess(numbers, 10) + "\n");

        // Example 3: Safe number parsing
        System.out.println("Example 3: Safe Number Parsing");
        System.out.println("Parse '123': " + safeParseInt("123", 0));
        System.out.println("Parse 'abc': " + safeParseInt("abc", 0) + " (using default)\n");

        // Example 4: Safe string access
        System.out.println("Example 4: Safe String Access");
        String text = "Hello";
        System.out.println("Character at index 1: " + safeCharAt(text, 1));
        System.out.println("Character at index 10: " + safeCharAt(text, 10) + " (using default)\n");


        // ========== BEST PRACTICES ==========

        System.out.println("\n--- 9. Exception Handling Best Practices ---\n");

        System.out.println("✓ Catch specific exceptions, not generic Exception");
        System.out.println("✓ Don't swallow exceptions (empty catch blocks)");
        System.out.println("✓ Log exceptions for debugging");
        System.out.println("✓ Provide meaningful error messages");
        System.out.println("✓ Clean up resources in finally block");
        System.out.println("✓ Don't use exceptions for control flow");
        System.out.println("✓ Catch only exceptions you can handle");
        System.out.println("✓ Preserve exception information when rethrowing");


        // ========== EXCEPTION HANDLING FLOW ==========

        System.out.println("\n\n--- 10. Exception Handling Flow ---\n");

        demonstrateFlow();


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHODS ==========

    // Method that may throw unchecked exception
    static int divideNumbers(int a, int b) {
        return a / b;  // May throw ArithmeticException
    }

    // Method that throws checked exception
    static void readFile(String filename) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(filename);
        // Would read file here
        reader.close();
    }

    // Exception propagation example
    static void method1() throws Exception {
        System.out.println("Entered method1");
        method2();
    }

    static void method2() throws Exception {
        System.out.println("Entered method2");
        method3();
    }

    static void method3() throws Exception {
        System.out.println("Entered method3");
        System.out.println("Throwing exception...");
        throw new Exception("Exception from method3");
    }

    // Safe division method
    static int safeDivide(int numerator, int denominator) {
        try {
            return numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("Warning: Division by zero, returning 0");
            return 0;
        }
    }

    // Safe array access method
    static int safeArrayAccess(int[] array, int index) {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Warning: Index out of bounds, returning -1");
            return -1;
        }
    }

    // Safe integer parsing method
    static int safeParseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Warning: Invalid number format, using default");
            return defaultValue;
        }
    }

    // Safe character at index method
    static char safeCharAt(String str, int index) {
        try {
            return str.charAt(index);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Warning: String index out of bounds, returning '?'");
            return '?';
        } catch (NullPointerException e) {
            System.out.println("Warning: String is null, returning '?'");
            return '?';
        }
    }

    // Demonstrate exception handling flow
    static void demonstrateFlow() {
        System.out.println("1. Code before try block");

        try {
            System.out.println("2. Inside try block - before exception");
            int result = 10 / 0;
            System.out.println("3. Inside try block - after exception (never executes)");
        } catch (ArithmeticException e) {
            System.out.println("4. Inside catch block - handling exception");
        }

        System.out.println("5. Code after try-catch block - program continues");
    }
}

/*
 * EXCEPTION HANDLING QUICK REFERENCE:
 *
 * BASIC SYNTAX:
 * try {
 *     // Code that might throw exception
 * } catch (ExceptionType e) {
 *     // Handle exception
 * }
 *
 * EXCEPTION INFORMATION:
 * e.getMessage()        - Exception message
 * e.toString()          - Exception description
 * e.printStackTrace()   - Full stack trace
 * e.getClass()          - Exception class
 *
 * COMMON UNCHECKED EXCEPTIONS:
 * - NullPointerException           - Accessing null reference
 * - ArrayIndexOutOfBoundsException - Invalid array index
 * - ArithmeticException            - Math error (division by zero)
 * - NumberFormatException          - Invalid number format
 * - IllegalArgumentException       - Invalid method argument
 * - ClassCastException             - Invalid type casting
 *
 * COMMON CHECKED EXCEPTIONS:
 * - IOException                    - I/O operation failed
 * - FileNotFoundException          - File doesn't exist
 * - SQLException                   - Database error
 * - ClassNotFoundException         - Class not found
 *
 * EXCEPTION HIERARCHY:
 * Object
 *   └── Throwable
 *         ├── Error (Don't catch)
 *         └── Exception
 *               ├── RuntimeException (Unchecked)
 *               └── Other Exceptions (Checked)
 *
 * WHEN TO USE TRY-CATCH:
 * ✓ When you can recover from the error
 * ✓ When you need to clean up resources
 * ✓ When you want to provide user-friendly error message
 * ✓ When you want to log the error
 * ✓ When you want to continue program execution
 *
 * WHEN NOT TO CATCH:
 * ✗ When you can't do anything meaningful
 * ✗ When you just want to rethrow
 * ✗ When exception indicates programming bug
 * ✗ When caller should handle it
 *
 * BEST PRACTICES:
 * 1. Catch specific exceptions, not Exception
 * 2. Don't swallow exceptions (empty catch)
 * 3. Log exceptions for debugging
 * 4. Provide context in error messages
 * 5. Clean up resources properly
 * 6. Don't use exceptions for control flow
 * 7. Fail fast - validate early
 * 8. Document exceptions in JavaDoc
 *
 * EXCEPTION FLOW:
 * 1. Exception is thrown
 * 2. Normal execution stops
 * 3. JVM searches for matching catch block
 * 4. If found: catch block executes, then code after try-catch
 * 5. If not found: exception propagates up call stack
 * 6. If never caught: program terminates
 *
 * HOW TO RUN:
 * javac ExceptionBasics.java
 * java ExceptionBasics
 */
