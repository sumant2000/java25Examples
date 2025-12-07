/**
 * Operators.java
 *
 * This program demonstrates all types of operators in Java.
 * Operators are special symbols that perform operations on operands.
 *
 * Key Concepts:
 * - Arithmetic operators
 * - Relational (Comparison) operators
 * - Logical operators
 * - Assignment operators
 * - Unary operators
 * - Bitwise operators
 * - Ternary operator
 */

public class Operators {

    public static void main(String[] args) {

        System.out.println("========== JAVA OPERATORS DEMONSTRATION ==========\n");

        // ========== ARITHMETIC OPERATORS ==========

        System.out.println("--- 1. ARITHMETIC OPERATORS ---\n");

        int a = 20;
        int b = 10;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition (a + b): " + (a + b));           // 30
        System.out.println("Subtraction (a - b): " + (a - b));        // 10
        System.out.println("Multiplication (a * b): " + (a * b));     // 200
        System.out.println("Division (a / b): " + (a / b));           // 2
        System.out.println("Modulus (a % b): " + (a % b));            // 0 (remainder)

        // Integer division
        System.out.println("\nInteger Division:");
        System.out.println("7 / 2 = " + (7 / 2));                     // 3 (not 3.5!)
        System.out.println("7.0 / 2 = " + (7.0 / 2));                 // 3.5

        // Modulus examples
        System.out.println("\nModulus Examples:");
        System.out.println("10 % 3 = " + (10 % 3));                   // 1
        System.out.println("15 % 4 = " + (15 % 4));                   // 3
        System.out.println("20 % 5 = " + (20 % 5));                   // 0


        // ========== RELATIONAL (COMPARISON) OPERATORS ==========

        System.out.println("\n\n--- 2. RELATIONAL OPERATORS ---\n");

        int x = 10;
        int y = 20;

        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x == y (Equal to): " + (x == y));                    // false
        System.out.println("x != y (Not equal to): " + (x != y));                // true
        System.out.println("x > y (Greater than): " + (x > y));                  // false
        System.out.println("x < y (Less than): " + (x < y));                     // true
        System.out.println("x >= y (Greater than or equal to): " + (x >= y));    // false
        System.out.println("x <= y (Less than or equal to): " + (x <= y));       // true


        // ========== LOGICAL OPERATORS ==========

        System.out.println("\n\n--- 3. LOGICAL OPERATORS ---\n");

        boolean isAdult = true;
        boolean hasLicense = false;

        System.out.println("isAdult = " + isAdult + ", hasLicense = " + hasLicense);

        // AND operator (&&) - both must be true
        System.out.println("isAdult && hasLicense: " + (isAdult && hasLicense));           // false

        // OR operator (||) - at least one must be true
        System.out.println("isAdult || hasLicense: " + (isAdult || hasLicense));           // true

        // NOT operator (!) - inverts the boolean value
        System.out.println("!isAdult: " + (!isAdult));                                     // false
        System.out.println("!hasLicense: " + (!hasLicense));                               // true

        // Complex logical expressions
        System.out.println("\nComplex Expressions:");
        int age = 25;
        boolean hasID = true;
        System.out.println("age = " + age + ", hasID = " + hasID);
        System.out.println("(age >= 18) && hasID: " + ((age >= 18) && hasID));           // true
        System.out.println("(age < 18) || hasID: " + ((age < 18) || hasID));             // true


        // ========== ASSIGNMENT OPERATORS ==========

        System.out.println("\n\n--- 4. ASSIGNMENT OPERATORS ---\n");

        int num = 10;
        System.out.println("Initial value: num = " + num);

        // Simple assignment
        num = 20;
        System.out.println("After num = 20: " + num);

        // Add and assign
        num += 5;  // num = num + 5
        System.out.println("After num += 5: " + num);                // 25

        // Subtract and assign
        num -= 3;  // num = num - 3
        System.out.println("After num -= 3: " + num);                // 22

        // Multiply and assign
        num *= 2;  // num = num * 2
        System.out.println("After num *= 2: " + num);                // 44

        // Divide and assign
        num /= 4;  // num = num / 4
        System.out.println("After num /= 4: " + num);                // 11

        // Modulus and assign
        num %= 3;  // num = num % 3
        System.out.println("After num %= 3: " + num);                // 2


        // ========== UNARY OPERATORS ==========

        System.out.println("\n\n--- 5. UNARY OPERATORS ---\n");

        int count = 10;
        System.out.println("Initial count: " + count);

        // Increment operators
        System.out.println("\nIncrement:");
        System.out.println("count++: " + count++);        // Post-increment: prints 10, then becomes 11
        System.out.println("After post-increment: " + count);
        System.out.println("++count: " + ++count);        // Pre-increment: becomes 12, then prints 12
        System.out.println("After pre-increment: " + count);

        // Decrement operators
        System.out.println("\nDecrement:");
        System.out.println("count--: " + count--);        // Post-decrement: prints 12, then becomes 11
        System.out.println("After post-decrement: " + count);
        System.out.println("--count: " + --count);        // Pre-decrement: becomes 10, then prints 10
        System.out.println("After pre-decrement: " + count);

        // Unary plus and minus
        int positive = 5;
        int negative = -positive;  // Unary minus
        System.out.println("\nUnary +/-:");
        System.out.println("positive: " + positive);
        System.out.println("-positive: " + negative);


        // ========== TERNARY OPERATOR ==========

        System.out.println("\n\n--- 6. TERNARY OPERATOR (? :) ---\n");

        // Syntax: condition ? valueIfTrue : valueIfFalse
        int score = 75;
        String result = (score >= 60) ? "Pass" : "Fail";
        System.out.println("Score: " + score);
        System.out.println("Result: " + result);

        // Another example
        int number = 15;
        String evenOrOdd = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("Number " + number + " is: " + evenOrOdd);

        // Nested ternary
        int marks = 85;
        String grade = (marks >= 90) ? "A" : (marks >= 80) ? "B" : (marks >= 70) ? "C" : "D";
        System.out.println("Marks: " + marks + ", Grade: " + grade);


        // ========== BITWISE OPERATORS (Advanced) ==========

        System.out.println("\n\n--- 7. BITWISE OPERATORS ---\n");

        int p = 5;   // Binary: 0101
        int q = 3;   // Binary: 0011

        System.out.println("p = " + p + " (binary: 0101)");
        System.out.println("q = " + q + " (binary: 0011)");
        System.out.println("p & q (AND): " + (p & q));       // 1 (0001)
        System.out.println("p | q (OR): " + (p | q));        // 7 (0111)
        System.out.println("p ^ q (XOR): " + (p ^ q));       // 6 (0110)
        System.out.println("~p (NOT): " + (~p));             // -6 (inverts all bits)
        System.out.println("p << 1 (Left shift): " + (p << 1));    // 10 (1010)
        System.out.println("p >> 1 (Right shift): " + (p >> 1));   // 2 (0010)


        // ========== OPERATOR PRECEDENCE ==========

        System.out.println("\n\n--- 8. OPERATOR PRECEDENCE ---\n");

        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1);              // 20 (multiplication first)

        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);            // 30 (parentheses first)

        boolean result3 = 5 > 3 && 10 < 20;
        System.out.println("5 > 3 && 10 < 20 = " + result3);        // true

        int result4 = 10 > 5 ? 100 : 200;
        System.out.println("10 > 5 ? 100 : 200 = " + result4);      // 100


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 9. PRACTICAL EXAMPLES ---\n");

        // Example 1: Calculate area of rectangle
        int length = 10;
        int width = 5;
        int area = length * width;
        System.out.println("Rectangle area (length=" + length + ", width=" + width + "): " + area);

        // Example 2: Check if number is even
        int testNum = 42;
        boolean isEven = (testNum % 2 == 0);
        System.out.println("Is " + testNum + " even? " + isEven);

        // Example 3: Calculate percentage
        double obtained = 450;
        double total = 500;
        double percentage = (obtained / total) * 100;
        System.out.println("Percentage: " + percentage + "%");

        // Example 4: Check voting eligibility
        int personAge = 17;
        boolean canVote = personAge >= 18;
        System.out.println("Age " + personAge + " - Can vote? " + canVote);

        // Example 5: Find maximum of two numbers
        int num1 = 45;
        int num2 = 78;
        int max = (num1 > num2) ? num1 : num2;
        System.out.println("Maximum of " + num1 + " and " + num2 + " is: " + max);

        // Example 6: Swap two numbers without third variable
        System.out.println("\nSwapping numbers:");
        int val1 = 5;
        int val2 = 10;
        System.out.println("Before swap: val1 = " + val1 + ", val2 = " + val2);
        val1 = val1 + val2;  // val1 = 15
        val2 = val1 - val2;  // val2 = 5
        val1 = val1 - val2;  // val1 = 10
        System.out.println("After swap: val1 = " + val1 + ", val2 = " + val2);


        System.out.println("\n\n========== END OF OPERATORS DEMONSTRATION ==========");
    }
}

/*
 * OPERATOR PRECEDENCE (High to Low):
 *
 * 1. Postfix: expr++, expr--
 * 2. Unary: ++expr, --expr, +expr, -expr, !, ~
 * 3. Multiplicative: *, /, %
 * 4. Additive: +, -
 * 5. Shift: <<, >>, >>>
 * 6. Relational: <, >, <=, >=
 * 7. Equality: ==, !=
 * 8. Bitwise AND: &
 * 9. Bitwise XOR: ^
 * 10. Bitwise OR: |
 * 11. Logical AND: &&
 * 12. Logical OR: ||
 * 13. Ternary: ? :
 * 14. Assignment: =, +=, -=, *=, /=, %=, etc.
 *
 * TIP: When in doubt, use parentheses () to make precedence explicit!
 *
 * COMMON MISTAKES:
 * 1. Using = instead of == for comparison
 * 2. Integer division: 5/2 = 2 (not 2.5)
 * 3. Confusing && (logical AND) with & (bitwise AND)
 * 4. Post vs Pre increment: i++ vs ++i
 * 5. Not using parentheses in complex expressions
 *
 * HOW TO RUN:
 * javac Operators.java
 * java Operators
 */
