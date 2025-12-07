/**
 * TypeCasting.java
 *
 * This program demonstrates type casting in Java.
 * Type casting is converting one data type to another.
 *
 * Key Concepts:
 * - Implicit casting (Widening/Automatic)
 * - Explicit casting (Narrowing/Manual)
 * - Casting between numeric types
 * - Casting with objects (will be covered in OOP)
 * - Type promotion in expressions
 */

public class TypeCasting {

    public static void main(String[] args) {

        System.out.println("========== TYPE CASTING IN JAVA ==========\n");

        // ========== IMPLICIT CASTING (WIDENING) ==========

        System.out.println("--- 1. IMPLICIT CASTING (Widening/Automatic) ---\n");
        System.out.println("Smaller type → Larger type (No data loss)\n");

        // byte → short → int → long → float → double
        // char → int

        // byte to short
        byte byteValue = 100;
        short shortValue = byteValue;
        System.out.println("byte to short:");
        System.out.println("  byte: " + byteValue + " → short: " + shortValue);

        // short to int
        short shortNum = 5000;
        int intNum = shortNum;
        System.out.println("\nshort to int:");
        System.out.println("  short: " + shortNum + " → int: " + intNum);

        // int to long
        int intValue = 100000;
        long longValue = intValue;
        System.out.println("\nint to long:");
        System.out.println("  int: " + intValue + " → long: " + longValue);

        // long to float
        long longNum = 1234567890L;
        float floatNum = longNum;
        System.out.println("\nlong to float:");
        System.out.println("  long: " + longNum + " → float: " + floatNum);

        // float to double
        float floatValue = 3.14f;
        double doubleValue = floatValue;
        System.out.println("\nfloat to double:");
        System.out.println("  float: " + floatValue + " → double: " + doubleValue);

        // int to double (direct)
        int number = 42;
        double doubleNum = number;
        System.out.println("\nint to double:");
        System.out.println("  int: " + number + " → double: " + doubleNum);

        // char to int
        char letter = 'A';
        int asciiValue = letter;
        System.out.println("\nchar to int:");
        System.out.println("  char: '" + letter + "' → int: " + asciiValue + " (ASCII value)");


        // ========== EXPLICIT CASTING (NARROWING) ==========

        System.out.println("\n\n--- 2. EXPLICIT CASTING (Narrowing/Manual) ---\n");
        System.out.println("Larger type → Smaller type (Possible data loss)\n");

        // double to int (loses decimal part)
        double doubleValue2 = 9.78;
        int intValue2 = (int) doubleValue2;
        System.out.println("double to int:");
        System.out.println("  double: " + doubleValue2 + " → int: " + intValue2);
        System.out.println("  Data lost: 0.78\n");

        // float to int
        float floatValue2 = 123.456f;
        int intValue3 = (int) floatValue2;
        System.out.println("float to int:");
        System.out.println("  float: " + floatValue2 + " → int: " + intValue3);
        System.out.println("  Data lost: 0.456\n");

        // long to int
        long longValue2 = 50000L;
        int intValue4 = (int) longValue2;
        System.out.println("long to int:");
        System.out.println("  long: " + longValue2 + " → int: " + intValue4);

        // int to short
        int intValue5 = 200;
        short shortValue2 = (short) intValue5;
        System.out.println("\nint to short:");
        System.out.println("  int: " + intValue5 + " → short: " + shortValue2);

        // int to byte
        int intValue6 = 100;
        byte byteValue2 = (byte) intValue6;
        System.out.println("\nint to byte:");
        System.out.println("  int: " + intValue6 + " → byte: " + byteValue2);

        // int to char
        int asciiCode = 65;
        char character = (char) asciiCode;
        System.out.println("\nint to char:");
        System.out.println("  int: " + asciiCode + " → char: '" + character + "'");


        // ========== DATA LOSS EXAMPLES ==========

        System.out.println("\n\n--- 3. DATA LOSS DURING CASTING ---\n");

        // Decimal to integer - loses decimal part
        double price = 99.99;
        int truncatedPrice = (int) price;
        System.out.println("Decimal to Integer:");
        System.out.println("  Original: $" + price);
        System.out.println("  After casting: $" + truncatedPrice);
        System.out.println("  Lost: $" + (price - truncatedPrice) + "\n");

        // Large int to byte - overflow
        int largeNumber = 300;
        byte smallByte = (byte) largeNumber;
        System.out.println("Overflow Example:");
        System.out.println("  int: " + largeNumber);
        System.out.println("  byte: " + smallByte + " (overflow occurred!)");
        System.out.println("  byte range: -128 to 127\n");

        // Another overflow example
        int bigInt = 130;
        byte overflowByte = (byte) bigInt;
        System.out.println("Another Overflow:");
        System.out.println("  int: " + bigInt + " → byte: " + overflowByte);


        // ========== TYPE PROMOTION IN EXPRESSIONS ==========

        System.out.println("\n\n--- 4. TYPE PROMOTION IN EXPRESSIONS ---\n");

        // byte and short are promoted to int in expressions
        byte b1 = 10;
        byte b2 = 20;
        // byte b3 = b1 + b2; // ERROR: result is int, not byte
        int b3 = b1 + b2;
        System.out.println("byte + byte = int");
        System.out.println("  " + b1 + " + " + b2 + " = " + b3 + " (int)");

        // Mixing int and double
        int intNum2 = 10;
        double doubleNum2 = 5.5;
        double result = intNum2 + doubleNum2;
        System.out.println("\nint + double = double");
        System.out.println("  " + intNum2 + " + " + doubleNum2 + " = " + result + " (double)");

        // Mixing types in division
        int a = 7;
        int b = 2;
        System.out.println("\nInteger division:");
        System.out.println("  " + a + " / " + b + " = " + (a / b) + " (int)");
        System.out.println("  " + a + " / " + (double)b + " = " + (a / (double)b) + " (double)");


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 5. PRACTICAL EXAMPLES ---\n");

        // Example 1: Calculate average with proper casting
        int total = 100;
        int count = 3;
        double average = (double) total / count;
        System.out.println("Example 1: Calculate Average");
        System.out.println("  Total: " + total);
        System.out.println("  Count: " + count);
        System.out.println("  Average (with casting): " + average);
        System.out.println("  Average (without casting): " + (total / count) + "\n");

        // Example 2: Convert temperature with precision
        int celsiusInt = 25;
        double fahrenheit = (celsiusInt * 9.0 / 5.0) + 32;
        System.out.println("Example 2: Temperature Conversion");
        System.out.println("  Celsius: " + celsiusInt + "°C");
        System.out.println("  Fahrenheit: " + fahrenheit + "°F\n");

        // Example 3: Extract integer part of decimal
        double salary = 5432.75;
        int salaryWholePart = (int) salary;
        double salaryDecimalPart = salary - salaryWholePart;
        System.out.println("Example 3: Separate Whole and Decimal");
        System.out.println("  Original: $" + salary);
        System.out.println("  Whole part: $" + salaryWholePart);
        System.out.println("  Decimal part: $" + String.format("%.2f", salaryDecimalPart) + "\n");

        // Example 4: Rounding a double
        double value = 7.8;
        int rounded = (int) (value + 0.5);
        System.out.println("Example 4: Simple Rounding");
        System.out.println("  Original: " + value);
        System.out.println("  Rounded: " + rounded + "\n");

        // Example 5: Working with ASCII codes
        char ch1 = 'A';
        char ch2 = 'Z';
        int diff = ch2 - ch1;
        System.out.println("Example 5: Character Arithmetic");
        System.out.println("  '" + ch1 + "' to '" + ch2 + "' = " + diff + " letters apart\n");

        // Example 6: Convert string to number (using wrapper classes)
        String numberStr = "123";
        int parsedInt = Integer.parseInt(numberStr);
        double parsedDouble = Double.parseDouble("45.67");
        System.out.println("Example 6: String to Number");
        System.out.println("  String \"" + numberStr + "\" → int " + parsedInt);
        System.out.println("  String \"45.67\" → double " + parsedDouble + "\n");

        // Example 7: Number to string
        int num = 100;
        String numString = String.valueOf(num);
        String numString2 = "" + num;
        System.out.println("Example 7: Number to String");
        System.out.println("  int " + num + " → String \"" + numString + "\"");
        System.out.println("  Alternative: \"" + numString2 + "\"");


        // ========== CASTING RULES SUMMARY ==========

        System.out.println("\n\n--- 6. CASTING RULES SUMMARY ---\n");

        System.out.println("WIDENING (Automatic - No cast needed):");
        System.out.println("  byte → short → int → long → float → double");
        System.out.println("  char → int\n");

        System.out.println("NARROWING (Manual - Cast required):");
        System.out.println("  double → float → long → int → short → byte");
        System.out.println("  Syntax: (targetType) value\n");

        System.out.println("REMEMBER:");
        System.out.println("  ✓ Widening is safe (no data loss)");
        System.out.println("  ✗ Narrowing may lose data or overflow");
        System.out.println("  ✓ Use casting for integer division: (double)a / b");
        System.out.println("  ✓ Be careful with overflow in narrowing");
        System.out.println("  ✓ Expressions promote to larger type automatically");


        System.out.println("\n\n========== END OF TYPE CASTING DEMONSTRATION ==========");
    }
}

/*
 * TYPE CASTING HIERARCHY:
 *
 * AUTOMATIC WIDENING (No cast needed):
 * byte(1) → short(2) → int(4) → long(8) → float(4) → double(8)
 *           char(2)  →
 *
 * Numbers in parentheses are size in bytes
 *
 * MANUAL NARROWING (Cast required):
 * Reverse of widening
 *
 * IMPORTANT POINTS:
 *
 * 1. Widening Conversion:
 *    - Smaller to larger type
 *    - Automatic/implicit
 *    - No data loss
 *    - Example: int to double
 *
 * 2. Narrowing Conversion:
 *    - Larger to smaller type
 *    - Manual/explicit (requires cast)
 *    - Possible data loss or overflow
 *    - Syntax: (targetType) value
 *    - Example: double to int
 *
 * 3. Type Promotion:
 *    - byte, short, char → int (in expressions)
 *    - If any operand is double → result is double
 *    - If any operand is float → result is float
 *    - If any operand is long → result is long
 *    - Otherwise → result is int
 *
 * 4. Common Use Cases:
 *    - Division: (double)a / b for decimal result
 *    - Rounding: (int)(value + 0.5)
 *    - ASCII: (int)char or (char)int
 *    - Truncation: (int)doubleValue
 *
 * 5. String Conversions:
 *    - String to int: Integer.parseInt(str)
 *    - String to double: Double.parseDouble(str)
 *    - Number to String: String.valueOf(num) or "" + num
 *
 * COMMON MISTAKES:
 *
 * 1. Integer division: 5/2 = 2 (use 5.0/2 or (double)5/2)
 * 2. Overflow: int 300 → byte -56
 * 3. Truncation: double 9.9 → int 9 (not rounded!)
 * 4. Forgetting cast: long x = 999999999999; (add L suffix)
 * 5. Forgetting cast: float f = 3.14; (add f suffix or cast)
 *
 * HOW TO RUN:
 * javac TypeCasting.java
 * java TypeCasting
 */
