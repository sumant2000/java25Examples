/**
 * DataTypes.java
 *
 * This program provides a comprehensive overview of all data types in Java.
 * Java has two categories of data types: Primitive and Reference types.
 *
 * Key Concepts:
 * - 8 Primitive data types
 * - Reference types
 * - Size and range of each data type
 * - When to use each type
 */

public class DataTypes {

    public static void main(String[] args) {

        System.out.println("========== JAVA DATA TYPES OVERVIEW ==========\n");

        // ========== PRIMITIVE DATA TYPES (8 types) ==========

        System.out.println("--- PRIMITIVE DATA TYPES ---\n");

        // 1. BYTE
        System.out.println("1. BYTE:");
        byte byteMin = -128;
        byte byteMax = 127;
        byte byteExample = 50;
        System.out.println("   Size: 8 bits (1 byte)");
        System.out.println("   Range: " + byteMin + " to " + byteMax);
        System.out.println("   Example: " + byteExample);
        System.out.println("   Use case: Saving memory in large arrays\n");

        // 2. SHORT
        System.out.println("2. SHORT:");
        short shortMin = -32768;
        short shortMax = 32767;
        short shortExample = 10000;
        System.out.println("   Size: 16 bits (2 bytes)");
        System.out.println("   Range: " + shortMin + " to " + shortMax);
        System.out.println("   Example: " + shortExample);
        System.out.println("   Use case: Memory optimization in arrays\n");

        // 3. INT
        System.out.println("3. INT:");
        int intMin = -2147483648;
        int intMax = 2147483647;
        int intExample = 100000;
        System.out.println("   Size: 32 bits (4 bytes)");
        System.out.println("   Range: " + intMin + " to " + intMax);
        System.out.println("   Example: " + intExample);
        System.out.println("   Use case: Most common integer type (DEFAULT)\n");

        // 4. LONG
        System.out.println("4. LONG:");
        long longMin = -9223372036854775808L;
        long longMax = 9223372036854775807L;
        long longExample = 9876543210L;
        System.out.println("   Size: 64 bits (8 bytes)");
        System.out.println("   Range: " + longMin + " to " + longMax);
        System.out.println("   Example: " + longExample);
        System.out.println("   Use case: Large numbers (timestamps, IDs)\n");

        // 5. FLOAT
        System.out.println("5. FLOAT:");
        float floatExample = 3.14159f;
        float floatPrecision = 1.23456789f;
        System.out.println("   Size: 32 bits (4 bytes)");
        System.out.println("   Range: ~±3.4e−38 to ±3.4e+38");
        System.out.println("   Precision: ~6-7 decimal digits");
        System.out.println("   Example: " + floatExample);
        System.out.println("   Note: Must use 'f' suffix (e.g., 3.14f)");
        System.out.println("   Use case: Saving memory with floating-point\n");

        // 6. DOUBLE
        System.out.println("6. DOUBLE:");
        double doubleExample = 3.141592653589793;
        double scientificNotation = 1.23e10; // 1.23 * 10^10
        System.out.println("   Size: 64 bits (8 bytes)");
        System.out.println("   Range: ~±1.7e−308 to ±1.7e+308");
        System.out.println("   Precision: ~15-16 decimal digits");
        System.out.println("   Example: " + doubleExample);
        System.out.println("   Scientific notation: " + scientificNotation);
        System.out.println("   Use case: Default for floating-point (DEFAULT)\n");

        // 7. CHAR
        System.out.println("7. CHAR:");
        char charLetter = 'A';
        char charDigit = '9';
        char charSymbol = '@';
        char unicodeChar = '\u0041'; // Unicode for 'A'
        System.out.println("   Size: 16 bits (2 bytes)");
        System.out.println("   Range: 0 to 65,535 (Unicode characters)");
        System.out.println("   Examples: " + charLetter + ", " + charDigit + ", " + charSymbol);
        System.out.println("   Unicode: " + unicodeChar);
        System.out.println("   Note: Use single quotes (e.g., 'A')");
        System.out.println("   Use case: Storing single characters\n");

        // 8. BOOLEAN
        System.out.println("8. BOOLEAN:");
        boolean boolTrue = true;
        boolean boolFalse = false;
        System.out.println("   Size: Not precisely defined (typically 1 bit)");
        System.out.println("   Values: true or false");
        System.out.println("   Examples: " + boolTrue + ", " + boolFalse);
        System.out.println("   Use case: Logical conditions, flags\n");


        // ========== REFERENCE DATA TYPES ==========

        System.out.println("\n--- REFERENCE DATA TYPES ---\n");

        // STRING
        System.out.println("STRING (Reference Type):");
        String text = "Hello, Java!";
        String empty = "";
        String multiWord = "This is a multi-word string";
        System.out.println("   Not a primitive type (it's a class)");
        System.out.println("   Stores sequence of characters");
        System.out.println("   Example: \"" + text + "\"");
        System.out.println("   Note: Use double quotes (e.g., \"Hello\")");
        System.out.println("   Immutable: Cannot be changed once created\n");

        // ARRAYS (will be covered in detail later)
        System.out.println("ARRAYS (Reference Type):");
        int[] numbers = {1, 2, 3, 4, 5};
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("   Collection of elements of same type");
        System.out.println("   Example int array: " + java.util.Arrays.toString(numbers));
        System.out.println("   Example String array: " + java.util.Arrays.toString(names));
        System.out.println("   Fixed size once created\n");


        // ========== DATA TYPE CONVERSIONS ==========

        System.out.println("\n--- DATA TYPE CONVERSIONS ---\n");

        // Implicit conversion (widening) - automatic
        System.out.println("IMPLICIT CONVERSION (Widening):");
        int intValue = 100;
        long longValue = intValue; // int to long
        float floatValue = intValue; // int to float
        double doubleValue = intValue; // int to double
        System.out.println("   int " + intValue + " -> long " + longValue);
        System.out.println("   int " + intValue + " -> float " + floatValue);
        System.out.println("   int " + intValue + " -> double " + doubleValue);
        System.out.println("   Automatic when going from smaller to larger type\n");

        // Explicit conversion (narrowing) - requires casting
        System.out.println("EXPLICIT CONVERSION (Narrowing):");
        double doubleNum = 9.78;
        int intNum = (int) doubleNum; // double to int (loses decimal)
        System.out.println("   double " + doubleNum + " -> int " + intNum + " (loses .78)");
        System.out.println("   Required when going from larger to smaller type");
        System.out.println("   May lose information!\n");


        // ========== SPECIAL VALUES ==========

        System.out.println("\n--- SPECIAL VALUES ---\n");

        // Infinity
        double positiveInfinity = Double.POSITIVE_INFINITY;
        double negativeInfinity = Double.NEGATIVE_INFINITY;
        System.out.println("Positive Infinity: " + positiveInfinity);
        System.out.println("Negative Infinity: " + negativeInfinity);

        // NaN (Not a Number)
        double notANumber = Double.NaN;
        System.out.println("NaN (Not a Number): " + notANumber);

        // Max and Min values
        System.out.println("\nMax/Min Values:");
        System.out.println("Integer MAX: " + Integer.MAX_VALUE);
        System.out.println("Integer MIN: " + Integer.MIN_VALUE);
        System.out.println("Double MAX: " + Double.MAX_VALUE);
        System.out.println("Double MIN: " + Double.MIN_VALUE);


        // ========== CHOOSING THE RIGHT DATA TYPE ==========

        System.out.println("\n\n========== CHOOSING THE RIGHT DATA TYPE ==========\n");
        System.out.println("For whole numbers:");
        System.out.println("  - Use 'int' for most cases");
        System.out.println("  - Use 'long' for very large numbers");
        System.out.println("  - Use 'byte' or 'short' for memory optimization\n");

        System.out.println("For decimal numbers:");
        System.out.println("  - Use 'double' for most cases (default)");
        System.out.println("  - Use 'float' for memory savings with large arrays\n");

        System.out.println("For text:");
        System.out.println("  - Use 'char' for single characters");
        System.out.println("  - Use 'String' for text (one or more characters)\n");

        System.out.println("For true/false values:");
        System.out.println("  - Use 'boolean'\n");


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n========== PRACTICAL EXAMPLES ==========\n");

        // Example 1: Student Information
        String studentName = "Alice Johnson";
        int studentAge = 20;
        char studentGrade = 'A';
        double studentGPA = 3.85;
        boolean isEnrolled = true;

        System.out.println("Student Information:");
        System.out.println("Name: " + studentName);
        System.out.println("Age: " + studentAge);
        System.out.println("Grade: " + studentGrade);
        System.out.println("GPA: " + studentGPA);
        System.out.println("Enrolled: " + isEnrolled);

        System.out.println("\n--- END OF DATA TYPES DEMONSTRATION ---");
    }
}

/*
 * SUMMARY OF PRIMITIVE DATA TYPES:
 *
 * | Type    | Size    | Range                        | Default | Example      |
 * |---------|---------|------------------------------|---------|--------------|
 * | byte    | 1 byte  | -128 to 127                  | 0       | 100          |
 * | short   | 2 bytes | -32,768 to 32,767            | 0       | 10000        |
 * | int     | 4 bytes | -2^31 to 2^31-1              | 0       | 100000       |
 * | long    | 8 bytes | -2^63 to 2^63-1              | 0L      | 100000L      |
 * | float   | 4 bytes | ~±3.4e−38 to ±3.4e+38        | 0.0f    | 3.14f        |
 * | double  | 8 bytes | ~±1.7e−308 to ±1.7e+308      | 0.0d    | 3.14159      |
 * | char    | 2 bytes | 0 to 65,535                  | '\u0000'| 'A'          |
 * | boolean | 1 bit   | true or false                | false   | true         |
 *
 * WIDENING CONVERSION (Automatic):
 * byte → short → int → long → float → double
 *              char →
 *
 * NARROWING CONVERSION (Manual casting required):
 * Reverse of widening - may lose data!
 *
 * HOW TO RUN:
 * javac DataTypes.java
 * java DataTypes
 */
