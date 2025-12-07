/**
 * Variables.java
 *
 * This program demonstrates how to declare and use variables in Java.
 * Variables are containers that store data values.
 *
 * Key Concepts:
 * - Variable declaration
 * - Variable initialization
 * - Different data types
 * - Variable naming rules
 */

public class Variables {

    public static void main(String[] args) {

        // ========== INTEGER TYPES ==========

        // byte: 8-bit integer, range: -128 to 127
        byte smallNumber = 100;
        System.out.println("Byte value: " + smallNumber);

        // short: 16-bit integer, range: -32,768 to 32,767
        short mediumNumber = 30000;
        System.out.println("Short value: " + mediumNumber);

        // int: 32-bit integer, range: -2^31 to 2^31-1 (most commonly used)
        int regularNumber = 1000000;
        System.out.println("Int value: " + regularNumber);

        // long: 64-bit integer, range: -2^63 to 2^63-1
        // Note: Add 'L' suffix for long literals
        long bigNumber = 9876543210L;
        System.out.println("Long value: " + bigNumber);


        // ========== FLOATING-POINT TYPES ==========

        // float: 32-bit floating point
        // Note: Add 'f' suffix for float literals
        float decimalNumber = 3.14f;
        System.out.println("Float value: " + decimalNumber);

        // double: 64-bit floating point (most commonly used for decimals)
        double preciseDecimal = 3.141592653589793;
        System.out.println("Double value: " + preciseDecimal);


        // ========== CHARACTER TYPE ==========

        // char: 16-bit Unicode character
        // Use single quotes for char literals
        char letter = 'A';
        char symbol = '@';
        char digit = '7';
        System.out.println("Char values: " + letter + ", " + symbol + ", " + digit);


        // ========== BOOLEAN TYPE ==========

        // boolean: true or false
        boolean isJavaFun = true;
        boolean isFishMammal = false;
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Is fish a mammal? " + isFishMammal);


        // ========== STRING TYPE ==========

        // String: sequence of characters (Reference type, not primitive)
        // Use double quotes for String literals
        String name = "John Doe";
        String greeting = "Hello, World!";
        System.out.println("Name: " + name);
        System.out.println("Greeting: " + greeting);


        // ========== VARIABLE DECLARATION STYLES ==========

        // Declaration without initialization
        int uninitialized;
        // uninitialized = 50; // Must initialize before use

        // Declaration with initialization
        int initialized = 25;

        // Multiple variables of same type
        int a = 10, b = 20, c = 30;
        System.out.println("Multiple variables: a=" + a + ", b=" + b + ", c=" + c);

        // Variable can be reassigned
        int number = 5;
        System.out.println("Original value: " + number);
        number = 10;
        System.out.println("New value: " + number);


        // ========== VARIABLE NAMING RULES ==========

        // Valid variable names (camelCase convention)
        int age = 25;
        int studentAge = 20;
        int numberOfStudents = 100;
        int _privateVar = 5;
        int $price = 99;

        // Invalid variable names (commented out to prevent errors):
        // int 123number = 5;        // Cannot start with digit
        // int my-variable = 10;     // Cannot use hyphen
        // int class = 15;           // Cannot use reserved keywords
        // int my variable = 20;     // Cannot have spaces


        // ========== DEMONSTRATING VARIABLE OPERATIONS ==========

        int x = 10;
        int y = 20;
        int sum = x + y;
        System.out.println("\nVariable Operations:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("x + y = " + sum);


        // ========== STRING CONCATENATION ==========

        String firstName = "Jane";
        String lastName = "Smith";
        String fullName = firstName + " " + lastName;
        System.out.println("\nFull Name: " + fullName);

        // Mixing strings and numbers
        int age2 = 25;
        String message = "My age is " + age2 + " years";
        System.out.println(message);


        // ========== VARIABLE SCOPE DEMO ==========

        int outerVariable = 100;
        System.out.println("\nOuter variable: " + outerVariable);

        if (true) {
            int innerVariable = 200;
            System.out.println("Inner variable: " + innerVariable);
            System.out.println("Can access outer: " + outerVariable);
        }
        // System.out.println(innerVariable); // ERROR: out of scope


        // ========== DEFAULT VALUES (for class fields only, not local variables) ==========

        System.out.println("\nNote: Local variables must be initialized before use.");
        System.out.println("Class fields have default values (0, false, null, etc.)");
    }
}

/*
 * IMPORTANT NOTES:
 *
 * 1. Variables must be declared before use
 * 2. Variable names are case-sensitive (age vs Age)
 * 3. Use meaningful variable names (age, not x)
 * 4. Follow camelCase convention for variables
 * 5. Local variables must be initialized before use
 * 6. Choose appropriate data type for your needs
 *
 * MEMORY SIZE:
 * byte:    1 byte  (8 bits)
 * short:   2 bytes (16 bits)
 * int:     4 bytes (32 bits)
 * long:    8 bytes (64 bits)
 * float:   4 bytes (32 bits)
 * double:  8 bytes (64 bits)
 * char:    2 bytes (16 bits)
 * boolean: 1 bit (size not precisely defined)
 *
 * HOW TO RUN:
 * javac Variables.java
 * java Variables
 */
