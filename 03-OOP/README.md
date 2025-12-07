# Module 3: Object-Oriented Programming (OOP) 🎯

Welcome to Module 3! Here you'll learn the core principles of Object-Oriented Programming, which is fundamental to Java.

## 📖 Topics Covered

1. **Classes and Objects** - Building blocks of OOP
2. **Constructors** - Object initialization
3. **Methods** - Object behavior
4. **Encapsulation** - Data hiding and access control
5. **Inheritance** - Code reuse through parent-child relationships
6. **Polymorphism** - One interface, multiple implementations
7. **Abstraction** - Hiding complexity
8. **Interfaces** - Contracts for classes
9. **Static Members** - Class-level variables and methods
10. **Inner Classes** - Classes within classes

## 🎯 Learning Objectives

By the end of this module, you will:
- Understand what classes and objects are
- Create and use your own classes
- Implement constructors and methods
- Apply the four pillars of OOP (Encapsulation, Inheritance, Polymorphism, Abstraction)
- Work with interfaces and abstract classes
- Use static members effectively
- Design object-oriented solutions to problems

## 📝 Programs in This Module

### 1. ClassesAndObjects.java
Introduction to classes and objects - the foundation of OOP.

**Concepts**: Class definition, object creation, instance variables, methods

### 2. Constructors.java
Learn how to initialize objects using constructors.

**Concepts**: Default constructor, parameterized constructor, constructor overloading, this keyword

### 3. Encapsulation.java
Implement data hiding using private variables and public methods.

**Concepts**: Access modifiers (private, public, protected), getters and setters

### 4. Inheritance.java
Reuse code through parent-child class relationships.

**Concepts**: extends keyword, super keyword, method overriding, IS-A relationship

### 5. Polymorphism.java
One interface, multiple implementations.

**Concepts**: Method overloading, method overriding, dynamic method dispatch, upcasting/downcasting

### 6. Abstraction.java
Hide implementation details and show only essential features.

**Concepts**: Abstract classes, abstract methods, concrete methods

### 7. Interfaces.java
Define contracts that classes must follow.

**Concepts**: interface keyword, implements, multiple inheritance, default methods

### 8. StaticMembers.java
Class-level variables and methods shared by all instances.

**Concepts**: static variables, static methods, static blocks, static vs instance

### 9. InnerClasses.java
Classes defined within other classes.

**Concepts**: Inner classes, anonymous classes, local classes, static nested classes

### 10. BankingSystem.java
Complete project demonstrating all OOP concepts.

**Concepts**: Real-world application of OOP principles

## 💡 Key Concepts

### The Four Pillars of OOP

#### 1. Encapsulation 🔒
**Definition**: Wrapping data (variables) and code (methods) together as a single unit.

**Benefits**:
- Data hiding and security
- Control over data access
- Flexibility to change implementation
- Improved maintainability

**Implementation**:
```java
public class Student {
    private String name;  // Private variable
    
    public String getName() {  // Public getter
        return name;
    }
    
    public void setName(String name) {  // Public setter
        this.name = name;
    }
}
```

#### 2. Inheritance 👨‍👦
**Definition**: Mechanism where a new class acquires properties and behaviors of an existing class.

**Benefits**:
- Code reusability
- Method overriding
- Hierarchical classification
- Extensibility

**Implementation**:
```java
class Animal {  // Parent class
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {  // Child class
    void bark() {
        System.out.println("Barking...");
    }
}
```

#### 3. Polymorphism 🎭
**Definition**: Ability to take many forms - same method name, different implementations.

**Types**:
- **Compile-time**: Method overloading
- **Runtime**: Method overriding

**Benefits**:
- Flexibility
- Code reusability
- Dynamic behavior
- Loose coupling

**Implementation**:
```java
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing square");
    }
}
```

#### 4. Abstraction 🎨
**Definition**: Hiding implementation details and showing only essential features.

**Benefits**:
- Reduces complexity
- Improves code maintainability
- Focus on what object does, not how
- Security through hiding

**Implementation**:
```java
abstract class Vehicle {
    abstract void start();  // Abstract method
    
    void stop() {  // Concrete method
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }
}
```

## 🔑 Access Modifiers

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| public | ✅ | ✅ | ✅ | ✅ |
| protected | ✅ | ✅ | ✅ | ❌ |
| default | ✅ | ✅ | ❌ | ❌ |
| private | ✅ | ❌ | ❌ | ❌ |

**Guidelines**:
- **public**: Accessible everywhere
- **protected**: Accessible in same package and subclasses
- **default**: Accessible only in same package
- **private**: Accessible only within the class

## 🆚 Class vs Object

| Class | Object |
|-------|--------|
| Blueprint/Template | Instance of class |
| Logical entity | Physical entity |
| Declared once | Created many times |
| No memory allocated | Memory allocated |
| Example: Car | Example: myCar, yourCar |

```java
// Class definition
class Car {
    String color;
    void drive() { }
}

// Object creation
Car myCar = new Car();  // Object 1
Car yourCar = new Car();  // Object 2
```

## 🎓 Practice Exercises

### Exercise 1: Student Management System
Create a `Student` class with:
- Private fields: name, id, grade
- Constructor to initialize fields
- Getters and setters
- Method to display student info
- Create multiple student objects

### Exercise 2: Shape Hierarchy
Design a shape hierarchy:
- Abstract class `Shape` with abstract method `calculateArea()`
- Classes: `Circle`, `Rectangle`, `Triangle`
- Each implements `calculateArea()` differently
- Test polymorphism with Shape references

### Exercise 3: Bank Account System
Create classes:
- `BankAccount`: accountNumber, balance, deposit(), withdraw()
- `SavingsAccount` extends `BankAccount`: interest rate
- `CheckingAccount` extends `BankAccount`: overdraft limit
- Implement proper encapsulation

### Exercise 4: Vehicle Interface
Design:
- Interface `Vehicle`: start(), stop(), accelerate()
- Classes `Car`, `Bike`, `Truck` implement `Vehicle`
- Each has unique implementation
- Demonstrate interface polymorphism

### Exercise 5: Library Management
Create:
- Class `Book`: title, author, ISBN, available
- Class `Member`: name, memberId, borrowedBooks[]
- Class `Library`: books[], members[]
- Methods: borrowBook(), returnBook(), searchBook()

### Exercise 6: Employee Hierarchy
Design:
- Abstract class `Employee`: name, id, calculateSalary()
- `FullTimeEmployee`: fixed salary
- `PartTimeEmployee`: hourly rate
- `Contractor`: per-project payment
- Use abstraction and polymorphism

### Exercise 7: Game Characters
Create:
- Interface `Movable`: moveUp(), moveDown(), moveLeft(), moveRight()
- Interface `Attackable`: attack(), defend()
- Class `Player` implements both interfaces
- Class `Enemy` implements both interfaces
- Different implementations for each

### Exercise 8: Restaurant Order System
Design:
- Class `MenuItem`: name, price, category
- Class `Order`: items[], total, addItem(), removeItem()
- Class `Customer`: name, orders[]
- Use encapsulation and proper methods

### Exercise 9: School Management
Create comprehensive system:
- Class `Person`: name, age, address
- Class `Student` extends `Person`: studentId, courses[]
- Class `Teacher` extends `Person`: teacherId, subjects[]
- Class `Course`: courseName, teacher, students[]
- Demonstrate inheritance and relationships

### Exercise 10: E-Commerce System
Build:
- Abstract class `Product`: name, price, stock
- Classes: `Electronics`, `Clothing`, `Books`
- Class `ShoppingCart`: products[], total
- Class `Customer`: cart, purchase()
- Apply all OOP principles

## 🐛 Common Mistakes to Avoid

1. **Not using encapsulation** - Making all fields public
2. **Creating god classes** - Classes that do too much
3. **Tight coupling** - Classes depending too much on each other
4. **Not using inheritance properly** - Overusing or misusing inheritance
5. **Forgetting to override equals() and hashCode()** - Important for collections
6. **Using inheritance for code reuse only** - Should represent IS-A relationship
7. **Not following naming conventions** - Classes in PascalCase, methods in camelCase
8. **Exposing internal state** - Returning mutable objects from getters

## 💎 Best Practices

1. **Single Responsibility Principle**: A class should have only one reason to change
2. **Favor composition over inheritance**: Use HAS-A when IS-A doesn't make sense
3. **Program to interfaces**: Depend on abstractions, not concrete classes
4. **Keep classes small and focused**: Each class should do one thing well
5. **Use meaningful names**: Class and method names should be descriptive
6. **Minimize access**: Use most restrictive access modifier possible
7. **Document your code**: Use JavaDoc comments for public APIs
8. **Override toString()**: For meaningful object representation

## 🔍 Design Principles

### SOLID Principles

**S** - **Single Responsibility**: One class, one purpose
**O** - **Open/Closed**: Open for extension, closed for modification
**L** - **Liskov Substitution**: Subclasses should be substitutable for parent classes
**I** - **Interface Segregation**: Many specific interfaces better than one general
**D** - **Dependency Inversion**: Depend on abstractions, not concretions

## 🆚 Abstract Class vs Interface

| Abstract Class | Interface |
|----------------|-----------|
| Can have concrete methods | All methods abstract (before Java 8) |
| Can have instance variables | Only constants (public static final) |
| Single inheritance | Multiple inheritance |
| Can have constructors | Cannot have constructors |
| Use: IS-A relationship | Use: CAN-DO capability |

**When to use Abstract Class**:
- Share code among related classes
- Need non-static, non-final fields
- Need non-public members

**When to use Interface**:
- Unrelated classes implement same methods
- Multiple inheritance needed
- Define capability across types

## 🔗 What's Next?

After mastering OOP, you'll move on to:
- **Module 4: Collections** - Data structures and algorithms
- Working with ArrayList, HashMap, HashSet, etc.

## 📖 Additional Resources

- [OOP Concepts (Oracle)](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/)
- [Interfaces and Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/)
- [Object-Oriented Design Principles](https://www.oodesign.com/)

## 💡 Real-World Analogies

- **Class**: Blueprint of a house
- **Object**: Actual house built from blueprint
- **Encapsulation**: ATM machine (use it without knowing internal workings)
- **Inheritance**: Child inheriting traits from parents
- **Polymorphism**: Person as student, employee, or citizen (different roles)
- **Abstraction**: Driving a car (use steering/pedals without knowing engine details)

---

**Ready to dive into OOP? Start with ClassesAndObjects.java!** 🚀