/**
 * Constants.java
 *
 * This program demonstrates how to work with constants in Java.
 * Constants are variables whose values cannot be changed once assigned.
 * They are declared using the 'final' keyword.
 *
 * Key Concepts:
 * - final keyword
 * - Naming conventions for constants
 * - Benefits of using constants
 * - Difference between variables and constants
 */

public class Constants {

    // Class-level constants (static final)
    // These can be accessed without creating an object
    public static final double PI = 3.14159265359;
    public static final double EULER_NUMBER = 2.71828;
    public static final int MAX_STUDENTS = 100;
    public static final String SCHOOL_NAME = "Java High School";
    public static final double GRAVITY = 9.8; // m/s^2

    public static void main(String[] args) {

        System.out.println("========== CONSTANTS DEMONSTRATION ==========\n");

        // ========== BASIC CONSTANTS ==========

        System.out.println("--- Basic Constants ---\n");

        // Declaring and initializing a constant
        final int MAX_AGE = 100;
        final String GREETING = "Hello, World!";
        final double SPEED_OF_LIGHT = 299792458.0; // m/s

        System.out.println("MAX_AGE: " + MAX_AGE);
        System.out.println("GREETING: " + GREETING);
        System.out.println("SPEED_OF_LIGHT: " + SPEED_OF_LIGHT + " m/s");

        // Constants cannot be reassigned
        // MAX_AGE = 200; // ERROR: Cannot assign a value to final variable

        System.out.println("\nNote: Constants cannot be changed once assigned!");


        // ========== NAMING CONVENTIONS ==========

        System.out.println("\n\n--- Naming Conventions ---\n");

        // Constants use UPPER_CASE with underscores
        final int MIN_PASSWORD_LENGTH = 8;
        final int MAX_LOGIN_ATTEMPTS = 3;
        final double TAX_RATE = 0.08;
        final String DEFAULT_LANGUAGE = "English";
        final boolean DEBUG_MODE = false;

        System.out.println("MIN_PASSWORD_LENGTH: " + MIN_PASSWORD_LENGTH);
        System.out.println("MAX_LOGIN_ATTEMPTS: " + MAX_LOGIN_ATTEMPTS);
        System.out.println("TAX_RATE: " + TAX_RATE);
        System.out.println("DEFAULT_LANGUAGE: " + DEFAULT_LANGUAGE);
        System.out.println("DEBUG_MODE: " + DEBUG_MODE);

        System.out.println("\nConvention: Constants are named in UPPER_CASE_WITH_UNDERSCORES");


        // ========== MATHEMATICAL CONSTANTS ==========

        System.out.println("\n\n--- Mathematical Constants ---\n");

        // Using class-level constants
        System.out.println("PI: " + PI);
        System.out.println("EULER_NUMBER: " + EULER_NUMBER);
        System.out.println("GRAVITY: " + GRAVITY + " m/s²");

        // Java's built-in Math constants
        System.out.println("\nJava Math Constants:");
        System.out.println("Math.PI: " + Math.PI);
        System.out.println("Math.E: " + Math.E);


        // ========== PRACTICAL EXAMPLE: CIRCLE CALCULATIONS ==========

        System.out.println("\n\n--- Circle Calculations ---\n");

        final double RADIUS = 5.0;
        System.out.println("Radius: " + RADIUS);

        double circumference = 2 * PI * RADIUS;
        double area = PI * RADIUS * RADIUS;

        System.out.println("Circumference: " + circumference);
        System.out.println("Area: " + area);


        // ========== PRACTICAL EXAMPLE: PRICE CALCULATION ==========

        System.out.println("\n\n--- Price Calculation ---\n");

        final double BASE_PRICE = 100.0;
        final double DISCOUNT_RATE = 0.15; // 15% discount
        final double SALES_TAX = 0.08;     // 8% tax

        System.out.println("Base Price: $" + BASE_PRICE);
        System.out.println("Discount Rate: " + (DISCOUNT_RATE * 100) + "%");
        System.out.println("Sales Tax: " + (SALES_TAX * 100) + "%");

        double discountAmount = BASE_PRICE * DISCOUNT_RATE;
        double priceAfterDiscount = BASE_PRICE - discountAmount;
        double taxAmount = priceAfterDiscount * SALES_TAX;
        double finalPrice = priceAfterDiscount + taxAmount;

        System.out.println("\nDiscount Amount: $" + discountAmount);
        System.out.println("Price After Discount: $" + priceAfterDiscount);
        System.out.println("Tax Amount: $" + taxAmount);
        System.out.println("Final Price: $" + finalPrice);


        // ========== PRACTICAL EXAMPLE: CONVERSION FACTORS ==========

        System.out.println("\n\n--- Unit Conversions ---\n");

        final double MILES_TO_KM = 1.60934;
        final double KG_TO_LBS = 2.20462;
        final double CELSIUS_TO_FAHRENHEIT_FACTOR = 9.0 / 5.0;
        final double CELSIUS_TO_FAHRENHEIT_OFFSET = 32.0;

        double miles = 10.0;
        double kilometers = miles * MILES_TO_KM;
        System.out.println(miles + " miles = " + kilometers + " km");

        double kg = 75.0;
        double lbs = kg * KG_TO_LBS;
        System.out.println(kg + " kg = " + lbs + " lbs");

        double celsius = 25.0;
        double fahrenheit = (celsius * CELSIUS_TO_FAHRENHEIT_FACTOR) + CELSIUS_TO_FAHRENHEIT_OFFSET;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");


        // ========== PRACTICAL EXAMPLE: BUSINESS RULES ==========

        System.out.println("\n\n--- Business Rules Example ---\n");

        final int MINIMUM_AGE_TO_VOTE = 18;
        final int RETIREMENT_AGE = 65;
        final int WORKING_HOURS_PER_WEEK = 40;
        final double OVERTIME_MULTIPLIER = 1.5;

        int employeeAge = 30;
        int hoursWorked = 45;
        double hourlyRate = 20.0;

        System.out.println("Employee Age: " + employeeAge);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: $" + hourlyRate);

        boolean canVote = employeeAge >= MINIMUM_AGE_TO_VOTE;
        int yearsToRetirement = RETIREMENT_AGE - employeeAge;

        System.out.println("\nCan Vote: " + canVote);
        System.out.println("Years to Retirement: " + yearsToRetirement);

        // Calculate pay
        int regularHours = Math.min(hoursWorked, WORKING_HOURS_PER_WEEK);
        int overtimeHours = Math.max(0, hoursWorked - WORKING_HOURS_PER_WEEK);

        double regularPay = regularHours * hourlyRate;
        double overtimePay = overtimeHours * hourlyRate * OVERTIME_MULTIPLIER;
        double totalPay = regularPay + overtimePay;

        System.out.println("\nRegular Hours: " + regularHours);
        System.out.println("Overtime Hours: " + overtimeHours);
        System.out.println("Regular Pay: $" + regularPay);
        System.out.println("Overtime Pay: $" + overtimePay);
        System.out.println("Total Pay: $" + totalPay);


        // ========== CONSTANTS VS VARIABLES ==========

        System.out.println("\n\n--- Constants vs Variables ---\n");

        // Variable - can be changed
        int counter = 0;
        System.out.println("Initial counter (variable): " + counter);
        counter = 10;
        System.out.println("Updated counter: " + counter);
        counter = 20;
        System.out.println("Updated counter again: " + counter);

        // Constant - cannot be changed
        final int LIMIT = 100;
        System.out.println("\nLIMIT (constant): " + LIMIT);
        System.out.println("LIMIT cannot be changed!");
        // LIMIT = 200; // ERROR: Cannot assign a value to final variable


        // ========== BENEFITS OF USING CONSTANTS ==========

        System.out.println("\n\n--- Benefits of Constants ---\n");
        System.out.println("1. Code Readability: Names make purpose clear");
        System.out.println("2. Maintainability: Change in one place updates everywhere");
        System.out.println("3. Prevent Errors: Cannot accidentally change values");
        System.out.println("4. Type Safety: Compiler checks type consistency");
        System.out.println("5. Documentation: Self-documenting code");


        // ========== BEST PRACTICES ==========

        System.out.println("\n\n--- Best Practices ---\n");
        System.out.println("1. Use UPPER_CASE_WITH_UNDERSCORES for constant names");
        System.out.println("2. Declare constants at the top of class or method");
        System.out.println("3. Use 'static final' for class-level constants");
        System.out.println("4. Group related constants together");
        System.out.println("5. Use constants instead of 'magic numbers' in code");
        System.out.println("6. Make constants public if they need to be accessed from other classes");


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }
}

/*
 * CONSTANT DECLARATION SYNTAX:
 *
 * final DataType CONSTANT_NAME = value;
 *
 * For class-level constants:
 * public static final DataType CONSTANT_NAME = value;
 *
 * NAMING CONVENTIONS:
 * - Use UPPER_CASE with underscores (_)
 * - Make names descriptive
 * - Example: MAX_VALUE, PI, TAX_RATE, DEFAULT_COLOR
 *
 * WHEN TO USE CONSTANTS:
 * 1. Mathematical constants (PI, E, etc.)
 * 2. Configuration values (MAX_SIZE, DEFAULT_TIMEOUT)
 * 3. Physical constants (SPEED_OF_LIGHT, GRAVITY)
 * 4. Business rules (TAX_RATE, MINIMUM_AGE)
 * 5. Fixed strings (ERROR_MESSAGES, STATUS_CODES)
 * 6. Any value that shouldn't change during program execution
 *
 * MAGIC NUMBERS:
 * Avoid using literal numbers directly in code.
 * Instead of: if (age > 18)
 * Use: if (age > MINIMUM_VOTING_AGE)
 *
 * DIFFERENCE: final vs static final
 * - final: Instance constant (each object has its own copy)
 * - static final: Class constant (shared across all instances)
 *
 * IMPORTANT NOTES:
 * 1. Constants must be initialized when declared
 * 2. Cannot be reassigned after initialization
 * 3. By convention, named in UPPER_CASE
 * 4. Can be local (inside method) or class-level
 * 5. Class-level constants should be 'static final'
 *
 * HOW TO RUN:
 * javac Constants.java
 * java Constants
 */
