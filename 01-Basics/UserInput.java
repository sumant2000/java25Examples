/**
 * UserInput.java
 *
 * This program demonstrates how to get input from users in Java.
 * We use the Scanner class to read different types of input from the console.
 *
 * Key Concepts:
 * - Scanner class
 * - Reading different data types
 * - Input validation
 * - BufferedReader (alternative method)
 */

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {

        System.out.println("========== USER INPUT DEMONSTRATION ==========\n");

        // Create a Scanner object to read input from keyboard
        Scanner scanner = new Scanner(System.in);

        // ========== READING DIFFERENT DATA TYPES ==========

        System.out.println("--- Reading Different Data Types ---\n");

        // Reading a String (single word)
        System.out.print("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Hello, " + firstName + "!\n");

        // Reading an integer
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old.\n");

        // Reading a double
        System.out.print("Enter your height in meters (e.g., 1.75): ");
        double height = scanner.nextDouble();
        System.out.println("Your height is " + height + " meters.\n");

        // Reading a boolean
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        System.out.println("Student status: " + isStudent + "\n");

        // Clear the buffer before reading full line
        scanner.nextLine();

        // Reading a full line (with spaces)
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Your full name is: " + fullName + "\n");

        // Reading a character
        System.out.print("Enter your grade (A/B/C/D/F): ");
        char grade = scanner.next().charAt(0);
        System.out.println("Your grade is: " + grade + "\n");


        // ========== PRACTICAL EXAMPLE: SIMPLE CALCULATOR ==========

        System.out.println("\n--- Simple Calculator ---\n");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nResults:");
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));


        // ========== PRACTICAL EXAMPLE: PERSONAL INFO ==========

        System.out.println("\n\n--- Personal Information Form ---\n");

        scanner.nextLine(); // Clear buffer

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.print("Enter your age: ");
        int personAge = scanner.nextInt();

        System.out.print("Enter your phone number: ");
        long phone = scanner.nextLong();

        scanner.nextLine(); // Clear buffer

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("\n--- Summary ---");
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Age: " + personAge);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);


        // ========== PRACTICAL EXAMPLE: AREA CALCULATOR ==========

        System.out.println("\n\n--- Rectangle Area Calculator ---\n");

        System.out.print("Enter length: ");
        double length = scanner.nextDouble();

        System.out.print("Enter width: ");
        double width = scanner.nextDouble();

        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("\nResults:");
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);


        // ========== PRACTICAL EXAMPLE: TEMPERATURE CONVERTER ==========

        System.out.println("\n\n--- Temperature Converter ---\n");

        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;

        System.out.println("\nConversions:");
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        System.out.println(celsius + "°C = " + kelvin + "K");


        // ========== PRACTICAL EXAMPLE: SHOPPING BILL ==========

        System.out.println("\n\n--- Shopping Bill Calculator ---\n");

        scanner.nextLine(); // Clear buffer

        System.out.print("Enter product name: ");
        String product = scanner.nextLine();

        System.out.print("Enter price per item: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        double total = price * quantity;
        double tax = total * 0.1; // 10% tax
        double grandTotal = total + tax;

        System.out.println("\n--- Bill ---");
        System.out.println("Product: " + product);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: $" + total);
        System.out.println("Tax (10%): $" + tax);
        System.out.println("Grand Total: $" + grandTotal);


        // Always close the scanner when done
        scanner.close();

        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }
}

/*
 * SCANNER METHODS:
 *
 * - next()          : Reads a single word (String)
 * - nextLine()      : Reads a full line (String)
 * - nextInt()       : Reads an integer
 * - nextDouble()    : Reads a double
 * - nextFloat()     : Reads a float
 * - nextLong()      : Reads a long
 * - nextBoolean()   : Reads a boolean
 * - nextByte()      : Reads a byte
 * - nextShort()     : Reads a short
 *
 * IMPORTANT NOTES:
 *
 * 1. Always import Scanner: import java.util.Scanner;
 * 2. Create Scanner object: Scanner scanner = new Scanner(System.in);
 * 3. Close scanner when done: scanner.close();
 * 4. Buffer issue: After nextInt(), nextDouble(), etc., call nextLine()
 *    to clear the newline character before reading a String.
 * 5. Input validation: Scanner will throw exception if wrong type is entered
 *
 * COMMON MISTAKES:
 *
 * 1. Forgetting to import Scanner
 * 2. Not closing the Scanner
 * 3. Buffer issues when mixing nextInt() with nextLine()
 * 4. Not handling invalid input (will be covered in Exception Handling)
 * 5. Using next() instead of nextLine() for multi-word input
 *
 * ALTERNATIVE INPUT METHOD (BufferedReader):
 *
 * import java.io.BufferedReader;
 * import java.io.InputStreamReader;
 *
 * BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 * String input = reader.readLine();
 *
 * HOW TO RUN:
 * javac UserInput.java
 * java UserInput
 *
 * Note: This program requires interactive input, so you need to run it
 * in a terminal/console that supports user input.
 */
