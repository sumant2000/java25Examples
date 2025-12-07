/**
 * ClassesAndObjects.java
 *
 * This program demonstrates the fundamental concepts of Classes and Objects in Java.
 * A class is a blueprint/template, and an object is an instance of that class.
 *
 * Key Concepts:
 * - Class definition
 * - Object creation
 * - Instance variables (fields)
 * - Instance methods
 * - Constructors
 * - this keyword
 * - Multiple objects from one class
 */

// ========== CLASS DEFINITION ==========

/**
 * Student class represents a student with basic information
 */
class Student {
    // Instance variables (fields) - each object has its own copy
    String name;
    int age;
    String studentId;
    double gpa;

    // Constructor - special method to initialize objects
    Student(String name, int age, String studentId, double gpa) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gpa = gpa;
    }

    // Instance method - defines behavior
    void displayInfo() {
        System.out.println("--- Student Information ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("GPA: " + gpa);
    }

    void study(String subject) {
        System.out.println(name + " is studying " + subject);
    }

    boolean isHonorStudent() {
        return gpa >= 3.5;
    }
}

/**
 * Car class demonstrates another example
 */
class Car {
    // Instance variables
    String brand;
    String model;
    int year;
    String color;
    double price;

    // Constructor with parameters
    Car(String brand, String model, int year, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    // Default constructor
    Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 2024;
        this.color = "White";
        this.price = 0.0;
    }

    // Methods
    void displayInfo() {
        System.out.println("--- Car Information ---");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Price: $" + price);
    }

    void start() {
        System.out.println(brand + " " + model + " is starting...");
    }

    void stop() {
        System.out.println(brand + " " + model + " has stopped.");
    }

    void accelerate() {
        System.out.println(brand + " " + model + " is accelerating!");
    }

    double calculateDepreciation(int years) {
        double depreciationRate = 0.15; // 15% per year
        double currentValue = price;
        for (int i = 0; i < years; i++) {
            currentValue -= currentValue * depreciationRate;
        }
        return currentValue;
    }
}

/**
 * BankAccount class demonstrates encapsulation basics
 */
class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            recipient.deposit(amount);
            System.out.println("Transferred $" + amount + " to " + recipient.accountHolder);
        } else {
            System.out.println("Transfer failed!");
        }
    }
}

/**
 * Rectangle class for geometric calculations
 */
class Rectangle {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    double calculatePerimeter() {
        return 2 * (length + width);
    }

    boolean isSquare() {
        return length == width;
    }

    void displayInfo() {
        System.out.println("--- Rectangle ---");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Is Square: " + isSquare());
    }
}

/**
 * Book class for library management
 */
class Book {
    String title;
    String author;
    String isbn;
    int pages;
    boolean isAvailable;

    Book(String title, String author, String isbn, int pages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.isAvailable = true;
    }

    void displayInfo() {
        System.out.println("--- Book Information ---");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is not available.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println("Thank you for returning: " + title);
    }
}

// ========== MAIN CLASS ==========

public class ClassesAndObjects {

    public static void main(String[] args) {

        System.out.println("========== CLASSES AND OBJECTS DEMONSTRATION ==========\n");

        // ========== CREATING AND USING STUDENT OBJECTS ==========

        System.out.println("--- 1. Student Class Example ---\n");

        // Creating first student object
        Student student1 = new Student("Alice Johnson", 20, "S12345", 3.8);
        student1.displayInfo();
        System.out.println("Honor Student: " + student1.isHonorStudent());
        student1.study("Computer Science");

        System.out.println();

        // Creating second student object
        Student student2 = new Student("Bob Smith", 22, "S12346", 3.2);
        student2.displayInfo();
        System.out.println("Honor Student: " + student2.isHonorStudent());
        student2.study("Mathematics");


        // ========== CREATING AND USING CAR OBJECTS ==========

        System.out.println("\n\n--- 2. Car Class Example ---\n");

        // Creating car object with parameterized constructor
        Car car1 = new Car("Toyota", "Camry", 2023, "Silver", 28000.0);
        car1.displayInfo();
        System.out.println();
        car1.start();
        car1.accelerate();
        car1.stop();

        System.out.println("\nDepreciation after 3 years: $" +
                          String.format("%.2f", car1.calculateDepreciation(3)));

        System.out.println("\n");

        // Creating car object with default constructor
        Car car2 = new Car();
        car2.displayInfo();

        System.out.println("\n");

        // Creating another car
        Car car3 = new Car("Tesla", "Model 3", 2024, "Red", 45000.0);
        car3.displayInfo();


        // ========== BANK ACCOUNT EXAMPLE ==========

        System.out.println("\n\n--- 3. BankAccount Class Example ---\n");

        BankAccount account1 = new BankAccount("ACC001", "John Doe", 1000.0);
        BankAccount account2 = new BankAccount("ACC002", "Jane Smith", 500.0);

        System.out.println("Initial Accounts:");
        account1.displayBalance();
        System.out.println();
        account2.displayBalance();

        System.out.println("\n--- Transactions ---\n");

        // Deposit
        account1.deposit(500.0);
        System.out.println();

        // Withdraw
        account1.withdraw(300.0);
        System.out.println();

        // Transfer
        account1.transfer(account2, 200.0);
        System.out.println();

        // Final balances
        System.out.println("Final Accounts:");
        account1.displayBalance();
        System.out.println();
        account2.displayBalance();


        // ========== RECTANGLE EXAMPLE ==========

        System.out.println("\n\n--- 4. Rectangle Class Example ---\n");

        Rectangle rect1 = new Rectangle(10.0, 5.0);
        rect1.displayInfo();

        System.out.println();

        Rectangle rect2 = new Rectangle(7.0, 7.0);
        rect2.displayInfo();


        // ========== BOOK EXAMPLE ==========

        System.out.println("\n\n--- 5. Book Class Example ---\n");

        Book book1 = new Book("Java Programming", "James Gosling", "978-0134685991", 500);
        Book book2 = new Book("Clean Code", "Robert Martin", "978-0132350884", 464);

        book1.displayInfo();
        System.out.println();

        book1.borrowBook();
        System.out.println();

        book1.displayInfo();
        System.out.println();

        book1.returnBook();
        System.out.println();

        book2.displayInfo();


        // ========== DEMONSTRATING MULTIPLE OBJECTS ==========

        System.out.println("\n\n--- 6. Multiple Objects ---\n");

        System.out.println("Creating multiple student objects:");
        Student[] students = new Student[3];
        students[0] = new Student("Charlie", 21, "S001", 3.9);
        students[1] = new Student("Diana", 20, "S002", 3.7);
        students[2] = new Student("Eve", 22, "S003", 3.4);

        System.out.println("\nAll Students:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].displayInfo();
        }

        // Calculate average GPA
        double totalGPA = 0;
        for (Student s : students) {
            totalGPA += s.gpa;
        }
        double averageGPA = totalGPA / students.length;
        System.out.println("\nAverage GPA: " + String.format("%.2f", averageGPA));


        // ========== COMPARING OBJECTS ==========

        System.out.println("\n\n--- 7. Object References ---\n");

        Car carA = new Car("Honda", "Civic", 2023, "Blue", 25000.0);
        Car carB = new Car("Honda", "Civic", 2023, "Blue", 25000.0);
        Car carC = carA; // carC refers to the same object as carA

        System.out.println("carA == carB: " + (carA == carB)); // false (different objects)
        System.out.println("carA == carC: " + (carA == carC)); // true (same object)

        System.out.println("\nModifying carA:");
        carA.color = "Green";
        System.out.println("carA color: " + carA.color);
        System.out.println("carC color: " + carC.color); // Also green (same object)
        System.out.println("carB color: " + carB.color); // Still blue (different object)


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }
}

/*
 * KEY CONCEPTS EXPLAINED:
 *
 * 1. CLASS:
 *    - Blueprint or template for creating objects
 *    - Defines properties (fields/variables) and behaviors (methods)
 *    - Syntax: class ClassName { }
 *
 * 2. OBJECT:
 *    - Instance of a class
 *    - Has its own copy of instance variables
 *    - Created using 'new' keyword
 *    - Syntax: ClassName objectName = new ClassName();
 *
 * 3. INSTANCE VARIABLES (FIELDS):
 *    - Variables declared inside class but outside methods
 *    - Each object has its own copy
 *    - Define the state/properties of an object
 *
 * 4. INSTANCE METHODS:
 *    - Functions defined inside a class
 *    - Operate on instance variables
 *    - Define the behavior of an object
 *    - Can access and modify instance variables
 *
 * 5. CONSTRUCTOR:
 *    - Special method to initialize objects
 *    - Same name as class
 *    - No return type
 *    - Called automatically when object is created
 *    - Can be overloaded (multiple constructors)
 *
 * 6. THIS KEYWORD:
 *    - Refers to current object
 *    - Used to distinguish between instance variables and parameters
 *    - Example: this.name = name;
 *
 * 7. OBJECT CREATION SYNTAX:
 *    ClassName objectName = new ClassName(arguments);
 *    - ClassName: Type of object
 *    - objectName: Reference variable
 *    - new: Allocates memory
 *    - ClassName(): Constructor call
 *
 * CLASS vs OBJECT:
 * - Class is a template, Object is an instance
 * - Class is logical, Object is physical
 * - Class has no memory, Object occupies memory
 * - Class defined once, many objects can be created
 *
 * BENEFITS OF OOP:
 * - Code reusability
 * - Modularity
 * - Data hiding
 * - Easy maintenance
 * - Real-world modeling
 *
 * BEST PRACTICES:
 * 1. Use meaningful class and variable names
 * 2. Keep classes focused (Single Responsibility)
 * 3. Initialize all variables in constructor
 * 4. Use appropriate access modifiers
 * 5. Document classes and methods
 * 6. Override toString() for meaningful output
 *
 * COMMON MISTAKES:
 * 1. Not initializing objects before use
 * 2. Confusing class and object
 * 3. Not using 'this' keyword when needed
 * 4. Creating too many responsibilities in one class
 * 5. Not providing constructors
 *
 * HOW TO RUN:
 * javac ClassesAndObjects.java
 * java ClassesAndObjects
 */
