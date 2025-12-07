/**
 * ForLoop.java
 *
 * This program demonstrates the for loop in Java.
 * For loops are used when you know in advance how many times
 * you want to execute a statement or block of statements.
 *
 * Key Concepts:
 * - Basic for loop syntax
 * - Loop control variables
 * - Nested for loops
 * - For-each loop (enhanced for loop)
 * - Practical applications
 */

public class ForLoop {

    public static void main(String[] args) {

        System.out.println("========== FOR LOOP DEMONSTRATION ==========\n");

        // ========== BASIC FOR LOOP ==========

        System.out.println("--- 1. Basic For Loop ---\n");

        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }

        System.out.println("\nCounting from 10 to 1:");
        for (int i = 10; i >= 1; i--) {
            System.out.println("Count: " + i);
        }


        // ========== FOR LOOP COMPONENTS ==========

        System.out.println("\n\n--- 2. For Loop Components ---\n");

        System.out.println("for (initialization; condition; update) {");
        System.out.println("    // loop body");
        System.out.println("}\n");

        // initialization: int i = 0 (executed once at start)
        // condition: i < 5 (checked before each iteration)
        // update: i++ (executed after each iteration)
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }


        // ========== DIFFERENT INCREMENT/DECREMENT ==========

        System.out.println("\n\n--- 3. Different Increments ---\n");

        System.out.println("Increment by 2:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\nIncrement by 5:");
        for (int i = 0; i <= 50; i += 5) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\nDecrement by 3:");
        for (int i = 30; i >= 0; i -= 3) {
            System.out.print(i + " ");
        }
        System.out.println();


        // ========== LOOPING THROUGH ARRAYS ==========

        System.out.println("\n\n--- 4. Looping Through Arrays ---\n");

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array elements using index:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }


        // ========== FOR-EACH LOOP (ENHANCED FOR LOOP) ==========

        System.out.println("\n\n--- 5. For-Each Loop ---\n");

        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};

        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        System.out.println("\nNumbers using for-each:");
        for (int num : numbers) {
            System.out.println(num);
        }


        // ========== NESTED FOR LOOPS ==========

        System.out.println("\n\n--- 6. Nested For Loops ---\n");

        System.out.println("Multiplication Table (2x2):");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }


        // ========== PRACTICAL EXAMPLE 1: SUM OF NUMBERS ==========

        System.out.println("\n\n--- 7. Sum of Numbers 1 to 100 ---\n");

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers 1 to 100: " + sum);


        // ========== PRACTICAL EXAMPLE 2: FACTORIAL ==========

        System.out.println("\n\n--- 8. Factorial Calculation ---\n");

        int n = 5;
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println(n + "! = " + factorial);


        // ========== PRACTICAL EXAMPLE 3: POWER CALCULATION ==========

        System.out.println("\n\n--- 9. Power Calculation ---\n");

        int base = 2;
        int exponent = 10;
        long result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        System.out.println(base + "^" + exponent + " = " + result);


        // ========== PRACTICAL EXAMPLE 4: COUNT DIGITS ==========

        System.out.println("\n\n--- 10. Count Digits in a Number ---\n");

        int number = 12345;
        int temp = number;
        int digitCount = 0;

        for (; temp != 0; temp /= 10) {
            digitCount++;
        }

        System.out.println("Number: " + number);
        System.out.println("Number of digits: " + digitCount);


        // ========== PRACTICAL EXAMPLE 5: REVERSE A NUMBER ==========

        System.out.println("\n\n--- 11. Reverse a Number ---\n");

        int original = 12345;
        int reversed = 0;

        for (int temp2 = original; temp2 != 0; temp2 /= 10) {
            int digit = temp2 % 10;
            reversed = reversed * 10 + digit;
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);


        // ========== PRACTICAL EXAMPLE 6: FIBONACCI SERIES ==========

        System.out.println("\n\n--- 12. Fibonacci Series ---\n");

        int terms = 10;
        int first = 0, second = 1;

        System.out.println("First " + terms + " Fibonacci numbers:");
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();


        // ========== PRACTICAL EXAMPLE 7: PRIME NUMBER CHECK ==========

        System.out.println("\n\n--- 13. Prime Number Check ---\n");

        int testNumber = 17;
        boolean isPrime = true;

        if (testNumber <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(testNumber); i++) {
                if (testNumber % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println(testNumber + " is " + (isPrime ? "prime" : "not prime"));


        // ========== PRACTICAL EXAMPLE 8: MULTIPLICATION TABLE ==========

        System.out.println("\n\n--- 14. Multiplication Table ---\n");

        int tableNumber = 7;
        System.out.println("Multiplication table for " + tableNumber + ":");

        for (int i = 1; i <= 10; i++) {
            System.out.println(tableNumber + " x " + i + " = " + (tableNumber * i));
        }


        // ========== PRACTICAL EXAMPLE 9: PATTERN PRINTING ==========

        System.out.println("\n\n--- 15. Pattern Printing ---\n");

        System.out.println("Right Triangle Pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nInverted Triangle Pattern:");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nNumber Pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        // ========== PRACTICAL EXAMPLE 10: SQUARE PATTERN ==========

        System.out.println("\n\n--- 16. Square Pattern ---\n");

        int size = 5;
        System.out.println("Solid Square:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nHollow Square:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }


        // ========== PRACTICAL EXAMPLE 11: FIND MAX IN ARRAY ==========

        System.out.println("\n\n--- 17. Find Maximum in Array ---\n");

        int[] values = {45, 23, 89, 12, 67, 34, 91, 56};
        int max = values[0];

        System.out.print("Array: ");
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();

        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        System.out.println("Maximum value: " + max);


        // ========== PRACTICAL EXAMPLE 12: ARRAY SUM AND AVERAGE ==========

        System.out.println("\n\n--- 18. Array Sum and Average ---\n");

        int[] scores = {85, 92, 78, 95, 88};
        int totalScore = 0;

        System.out.print("Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
            totalScore += score;
        }
        System.out.println();

        double average = (double) totalScore / scores.length;
        System.out.println("Total: " + totalScore);
        System.out.println("Average: " + String.format("%.2f", average));


        // ========== LOOP VARIATIONS ==========

        System.out.println("\n\n--- 19. Loop Variations ---\n");

        // Multiple variables in for loop
        System.out.println("Multiple variables:");
        for (int i = 0, j = 10; i < 5; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }

        // Infinite loop (commented out to prevent hanging)
        // for (;;) {
        //     System.out.println("This runs forever!");
        // }

        // Empty loop body
        int count = 0;
        for (int i = 0; i < 100; i++, count++);
        System.out.println("\nEmpty body loop counted to: " + count);


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }
}

/*
 * FOR LOOP SYNTAX:
 *
 * Basic for loop:
 * for (initialization; condition; update) {
 *     // loop body
 * }
 *
 * For-each loop (enhanced for loop):
 * for (Type element : collection) {
 *     // use element
 * }
 *
 * LOOP COMPONENTS:
 * 1. Initialization: Executed once at the start
 * 2. Condition: Checked before each iteration
 * 3. Update: Executed after each iteration
 * 4. Body: Code to be repeated
 *
 * WHEN TO USE FOR LOOP:
 * - Known number of iterations
 * - Counting up or down
 * - Iterating over arrays/collections
 * - Pattern generation
 * - Mathematical calculations
 *
 * FOR vs FOR-EACH:
 * - Use for: When you need index or modify elements
 * - Use for-each: When you just need to read elements
 *
 * LOOP CONTROL:
 * - break: Exit the loop immediately
 * - continue: Skip to next iteration
 *
 * COMMON PATTERNS:
 * 1. Count from 0 to n-1: for (int i = 0; i < n; i++)
 * 2. Count from 1 to n: for (int i = 1; i <= n; i++)
 * 3. Reverse: for (int i = n; i > 0; i--)
 * 4. Skip values: for (int i = 0; i < n; i += 2)
 * 5. Array iteration: for (int i = 0; i < arr.length; i++)
 *
 * BEST PRACTICES:
 * 1. Use meaningful loop variable names
 * 2. Keep loop body simple
 * 3. Avoid modifying loop variable inside body
 * 4. Declare loop variable in for statement
 * 5. Use for-each when possible
 *
 * COMMON MISTAKES:
 * 1. Off-by-one errors (< vs <=)
 * 2. Infinite loops (wrong condition)
 * 3. Modifying loop variable incorrectly
 * 4. Accessing array out of bounds
 * 5. Comparing floating point numbers
 *
 * PERFORMANCE TIPS:
 * 1. Cache array length outside loop if needed
 * 2. Use prefix increment (++i) for complex objects
 * 3. Avoid expensive operations in condition
 * 4. Consider loop unrolling for critical code
 *
 * HOW TO RUN:
 * javac ForLoop.java
 * java ForLoop
 */
