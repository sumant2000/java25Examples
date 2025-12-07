/**
 * HelloWorld.java
 *
 * This is your first Java program!
 * It demonstrates the basic structure of a Java application.
 *
 * Key Concepts:
 * - public class: Makes the class accessible from anywhere
 * - main method: Entry point of the program
 * - System.out.println(): Prints text to the console
 */

public class HelloWorld {

    /**
     * The main method is where program execution begins.
     * Every Java application must have a main method.
     *
     * @param args - Command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Print "Hello, World!" to the console
        System.out.println("Hello, World!");

        // You can print multiple lines
        System.out.println("Welcome to Java Programming!");
        System.out.println("This is your first step towards becoming a Java developer.");

        // print() vs println()
        // println() adds a new line after printing
        System.out.println("This is on line 1");
        System.out.println("This is on line 2");

        // print() does NOT add a new line
        System.out.print("This is ");
        System.out.print("all on ");
        System.out.print("one line.");
        System.out.println(); // Adds a new line

        // You can also print numbers
        System.out.println(42);
        System.out.println(3.14159);

        // Printing with escape sequences
        System.out.println("Hello\tWorld"); // \t = tab
        System.out.println("Hello\nWorld"); // \n = new line
        System.out.println("He said, \"Java is awesome!\""); // \" = quote
        System.out.println("C:\\Users\\Desktop"); // \\ = backslash
    }
}

/*
 * HOW TO RUN THIS PROGRAM:
 *
 * 1. Open terminal/command prompt
 * 2. Navigate to the directory containing this file
 * 3. Compile: javac HelloWorld.java
 * 4. Run: java HelloWorld
 *
 * EXPECTED OUTPUT:
 * Hello, World!
 * Welcome to Java Programming!
 * This is your first step towards becoming a Java developer.
 * This is on line 1
 * This is on line 2
 * This is all on one line.
 * 42
 * 3.14159
 * Hello	World
 * Hello
 * World
 * He said, "Java is awesome!"
 * C:\Users\Desktop
 */
