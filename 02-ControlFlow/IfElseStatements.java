/**
 * IfElseStatements.java
 *
 * This program demonstrates conditional statements in Java.
 * Conditional statements allow your program to make decisions and
 * execute different code based on different conditions.
 *
 * Key Concepts:
 * - if statement
 * - if-else statement
 * - if-else-if ladder
 * - nested if statements
 * - ternary operator
 * - logical operators in conditions
 */

public class IfElseStatements {

    public static void main(String[] args) {

        System.out.println("========== IF-ELSE STATEMENTS DEMONSTRATION ==========\n");

        // ========== SIMPLE IF STATEMENT ==========

        System.out.println("--- 1. Simple IF Statement ---\n");

        int age = 20;
        System.out.println("Age: " + age);

        if (age >= 18) {
            System.out.println("You are an adult.");
        }

        if (age < 18) {
            System.out.println("You are a minor.");
        }

        System.out.println("Program continues...\n");


        // ========== IF-ELSE STATEMENT ==========

        System.out.println("\n--- 2. IF-ELSE Statement ---\n");

        int number = 15;
        System.out.println("Number: " + number);

        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }


        // ========== IF-ELSE-IF LADDER ==========

        System.out.println("\n\n--- 3. IF-ELSE-IF Ladder ---\n");

        int score = 85;
        System.out.println("Score: " + score);

        if (score >= 90) {
            System.out.println("Grade: A (Excellent!)");
        } else if (score >= 80) {
            System.out.println("Grade: B (Very Good!)");
        } else if (score >= 70) {
            System.out.println("Grade: C (Good)");
        } else if (score >= 60) {
            System.out.println("Grade: D (Pass)");
        } else {
            System.out.println("Grade: F (Fail)");
        }


        // ========== NESTED IF STATEMENTS ==========

        System.out.println("\n\n--- 4. Nested IF Statements ---\n");

        int userAge = 25;
        boolean hasLicense = true;

        System.out.println("Age: " + userAge);
        System.out.println("Has License: " + hasLicense);

        if (userAge >= 18) {
            System.out.println("Age requirement met.");
            if (hasLicense) {
                System.out.println("You can drive!");
            } else {
                System.out.println("You need a license to drive.");
            }
        } else {
            System.out.println("You are too young to drive.");
        }


        // ========== LOGICAL OPERATORS IN CONDITIONS ==========

        System.out.println("\n\n--- 5. Logical Operators ---\n");

        int temperature = 25;
        boolean isSunny = true;

        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Is Sunny: " + isSunny);

        // AND operator (&&)
        if (temperature > 20 && isSunny) {
            System.out.println("Perfect weather for a picnic!");
        }

        // OR operator (||)
        if (temperature < 0 || temperature > 35) {
            System.out.println("Extreme temperature!");
        } else {
            System.out.println("Temperature is comfortable.");
        }

        // NOT operator (!)
        if (!isSunny) {
            System.out.println("Take an umbrella!");
        } else {
            System.out.println("No need for an umbrella.");
        }


        // ========== COMPLEX CONDITIONS ==========

        System.out.println("\n\n--- 6. Complex Conditions ---\n");

        int accountBalance = 5000;
        int withdrawAmount = 2000;
        boolean hasOverdraftProtection = true;

        System.out.println("Account Balance: $" + accountBalance);
        System.out.println("Withdraw Amount: $" + withdrawAmount);
        System.out.println("Overdraft Protection: " + hasOverdraftProtection);

        if (withdrawAmount <= accountBalance) {
            System.out.println("Transaction approved.");
            accountBalance -= withdrawAmount;
            System.out.println("New balance: $" + accountBalance);
        } else if (hasOverdraftProtection && withdrawAmount <= accountBalance + 1000) {
            System.out.println("Overdraft used. Transaction approved with fee.");
            accountBalance -= withdrawAmount;
            System.out.println("New balance: $" + accountBalance);
        } else {
            System.out.println("Insufficient funds. Transaction denied.");
        }


        // ========== TERNARY OPERATOR ==========

        System.out.println("\n\n--- 7. Ternary Operator (? :) ---\n");

        int a = 10;
        int b = 20;

        // condition ? valueIfTrue : valueIfFalse
        int max = (a > b) ? a : b;
        System.out.println("Maximum of " + a + " and " + b + " is: " + max);

        String result = (a % 2 == 0) ? "Even" : "Odd";
        System.out.println(a + " is " + result);

        // Nested ternary (use with caution!)
        int testScore = 75;
        String grade = (testScore >= 90) ? "A" :
                      (testScore >= 80) ? "B" :
                      (testScore >= 70) ? "C" :
                      (testScore >= 60) ? "D" : "F";
        System.out.println("Score " + testScore + " gets grade: " + grade);


        // ========== PRACTICAL EXAMPLE 1: LOGIN SYSTEM ==========

        System.out.println("\n\n--- 8. Practical Example: Login System ---\n");

        String username = "admin";
        String password = "pass123";
        String inputUsername = "admin";
        String inputPassword = "pass123";

        System.out.println("Attempting login...");

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
        } else if (!inputUsername.equals(username)) {
            System.out.println("Error: Invalid username.");
        } else if (!inputPassword.equals(password)) {
            System.out.println("Error: Invalid password.");
        } else {
            System.out.println("Login failed.");
        }


        // ========== PRACTICAL EXAMPLE 2: TICKET PRICING ==========

        System.out.println("\n\n--- 9. Practical Example: Movie Ticket Pricing ---\n");

        int personAge = 12;
        boolean isStudent = false;
        boolean isSenior = false;
        double basePrice = 15.0;
        double finalPrice;

        System.out.println("Age: " + personAge);
        System.out.println("Base Price: $" + basePrice);

        if (personAge < 5) {
            finalPrice = 0.0; // Free for children under 5
            System.out.println("Category: Child (Under 5)");
        } else if (personAge < 13) {
            finalPrice = basePrice * 0.5; // 50% off for children
            System.out.println("Category: Child (5-12)");
        } else if (isStudent) {
            finalPrice = basePrice * 0.7; // 30% off for students
            System.out.println("Category: Student");
        } else if (personAge >= 65 || isSenior) {
            finalPrice = basePrice * 0.6; // 40% off for seniors
            System.out.println("Category: Senior");
        } else {
            finalPrice = basePrice; // Regular price
            System.out.println("Category: Adult");
        }

        System.out.println("Final Price: $" + finalPrice);


        // ========== PRACTICAL EXAMPLE 3: BMI CALCULATOR ==========

        System.out.println("\n\n--- 10. Practical Example: BMI Calculator ---\n");

        double weight = 70; // kg
        double height = 1.75; // meters
        double bmi = weight / (height * height);

        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.println("BMI: " + String.format("%.2f", bmi));

        System.out.print("Category: ");
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal weight");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }


        // ========== PRACTICAL EXAMPLE 4: LEAP YEAR CHECKER ==========

        System.out.println("\n\n--- 11. Practical Example: Leap Year Checker ---\n");

        int year = 2024;
        boolean isLeapYear;

        System.out.println("Year: " + year);

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }
        } else {
            isLeapYear = false;
        }

        System.out.println(year + " is " + (isLeapYear ? "a leap year" : "not a leap year"));

        // Simplified version using logical operators
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("Simplified result: " + isLeap);


        // ========== PRACTICAL EXAMPLE 5: TRIANGLE VALIDATOR ==========

        System.out.println("\n\n--- 12. Practical Example: Triangle Validator ---\n");

        int side1 = 3;
        int side2 = 4;
        int side3 = 5;

        System.out.println("Sides: " + side1 + ", " + side2 + ", " + side3);

        // Check if valid triangle
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
            System.out.println("Valid triangle!");

            // Determine type of triangle
            if (side1 == side2 && side2 == side3) {
                System.out.println("Type: Equilateral (all sides equal)");
            } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                System.out.println("Type: Isosceles (two sides equal)");
            } else {
                System.out.println("Type: Scalene (all sides different)");
            }

            // Check if right-angled
            if (side1*side1 + side2*side2 == side3*side3 ||
                side2*side2 + side3*side3 == side1*side1 ||
                side1*side1 + side3*side3 == side2*side2) {
                System.out.println("Also a right-angled triangle!");
            }
        } else {
            System.out.println("Invalid triangle!");
        }


        // ========== PRACTICAL EXAMPLE 6: DAY TYPE CHECKER ==========

        System.out.println("\n\n--- 13. Practical Example: Day Type Checker ---\n");

        String day = "Saturday";
        System.out.println("Day: " + day);

        if (day.equals("Saturday") || day.equals("Sunday")) {
            System.out.println("It's a weekend! Time to relax!");
        } else if (day.equals("Monday") || day.equals("Tuesday") ||
                   day.equals("Wednesday") || day.equals("Thursday") ||
                   day.equals("Friday")) {
            System.out.println("It's a weekday. Time to work!");
        } else {
            System.out.println("Invalid day name.");
        }


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }
}

/*
 * IF-ELSE STATEMENT SYNTAX:
 *
 * Simple if:
 *   if (condition) {
 *       // code
 *   }
 *
 * If-else:
 *   if (condition) {
 *       // code if true
 *   } else {
 *       // code if false
 *   }
 *
 * If-else-if ladder:
 *   if (condition1) {
 *       // code
 *   } else if (condition2) {
 *       // code
 *   } else {
 *       // code
 *   }
 *
 * Nested if:
 *   if (condition1) {
 *       if (condition2) {
 *           // code
 *       }
 *   }
 *
 * Ternary operator:
 *   variable = (condition) ? valueIfTrue : valueIfFalse;
 *
 * COMPARISON OPERATORS:
 * ==  : Equal to
 * !=  : Not equal to
 * >   : Greater than
 * <   : Less than
 * >=  : Greater than or equal to
 * <=  : Less than or equal to
 *
 * LOGICAL OPERATORS:
 * &&  : AND (both conditions must be true)
 * ||  : OR (at least one condition must be true)
 * !   : NOT (inverts the condition)
 *
 * IMPORTANT NOTES:
 *
 * 1. Conditions must evaluate to boolean (true/false)
 * 2. Use equals() for String comparison, not ==
 * 3. Braces {} are optional for single statements but recommended
 * 4. else-if is checked only if previous conditions are false
 * 5. Only one block executes in if-else-if ladder
 * 6. Use parentheses to clarify complex conditions
 *
 * BEST PRACTICES:
 *
 * 1. Always use braces {} even for single statements
 * 2. Keep conditions simple and readable
 * 3. Order conditions from most to least likely
 * 4. Avoid deep nesting (use early returns or logical operators)
 * 5. Use meaningful condition names
 * 6. Test edge cases
 *
 * COMMON MISTAKES:
 *
 * 1. Using = instead of == for comparison
 * 2. Using == for String comparison instead of .equals()
 * 3. Missing braces leading to logic errors
 * 4. Unreachable code after if-else blocks
 * 5. Complex nested conditions (hard to read)
 *
 * HOW TO RUN:
 * javac IfElseStatements.java
 * java IfElseStatements
 */
