# Getting Started with Java 25: Zero to Hero 🚀

Welcome! This guide will help you set up your Java development environment and start your learning journey.

## 📋 Table of Contents

1. [Prerequisites](#prerequisites)
2. [Installing Java](#installing-java)
3. [Setting Up Your IDE](#setting-up-your-ide)
4. [Running Your First Program](#running-your-first-program)
5. [Understanding the Project Structure](#understanding-the-project-structure)
6. [Learning Path](#learning-path)
7. [Tips for Success](#tips-for-success)
8. [Troubleshooting](#troubleshooting)
9. [Additional Resources](#additional-resources)

---

## Prerequisites

Before starting, you should have:
- A computer running Windows, macOS, or Linux
- Basic computer skills (creating folders, running commands)
- Internet connection (for downloading tools)
- Motivation to learn! 💪

**No prior programming experience required!** This course starts from absolute basics.

---

## Installing Java

### Step 1: Download Java Development Kit (JDK)

#### Option 1: Oracle JDK (Recommended for Beginners)
1. Visit: https://www.oracle.com/java/technologies/downloads/
2. Download JDK 21 or later for your operating system
3. Run the installer and follow the instructions

#### Option 2: OpenJDK (Free and Open Source)
1. Visit: https://adoptium.net/
2. Download Temurin JDK 21 or later
3. Install following the instructions

### Step 2: Verify Installation

Open your terminal/command prompt and type:

```bash
java -version
```

You should see output like:
```
java version "21.0.1" 2023-10-17 LTS
Java(TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
```

Also check the compiler:
```bash
javac -version
```

You should see:
```
javac 21.0.1
```

### Step 3: Set JAVA_HOME (If needed)

#### Windows:
1. Right-click "This PC" → Properties
2. Advanced system settings → Environment Variables
3. Add new system variable:
   - Variable name: `JAVA_HOME`
   - Variable value: Path to JDK (e.g., `C:\Program Files\Java\jdk-21`)
4. Edit PATH variable, add: `%JAVA_HOME%\bin`

#### macOS/Linux:
Add to `~/.bash_profile` or `~/.zshrc`:
```bash
export JAVA_HOME=/path/to/jdk
export PATH=$JAVA_HOME/bin:$PATH
```

---

## Setting Up Your IDE

You have three great options for coding Java:

### Option 1: IntelliJ IDEA (Recommended)

**Best for**: Beginners to advanced developers

1. Download from: https://www.jetbrains.com/idea/download/
2. Install Community Edition (free)
3. On first launch, install Java plugin if prompted
4. Create new Java project and start coding!

**Pros**: Excellent code completion, debugging, and refactoring tools

### Option 2: Visual Studio Code

**Best for**: Lightweight development

1. Download from: https://code.visualstudio.com/
2. Install the "Extension Pack for Java" from Microsoft
3. Restart VS Code and you're ready!

**Pros**: Fast, lightweight, highly customizable

### Option 3: Eclipse

**Best for**: Traditional Java development

1. Download from: https://www.eclipse.org/downloads/
2. Install "Eclipse IDE for Java Developers"
3. Launch and create a new Java project

**Pros**: Free, mature, lots of plugins

### Option 4: Text Editor + Terminal

**Best for**: Learning the fundamentals

- Use any text editor (Notepad++, Sublime Text, etc.)
- Compile and run from terminal
- Great for understanding Java basics

---

## Running Your First Program

### Using Terminal/Command Prompt

1. **Create a file**: `HelloWorld.java`

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

2. **Compile**:
```bash
javac HelloWorld.java
```

This creates `HelloWorld.class` file

3. **Run**:
```bash
java HelloWorld
```

You should see:
```
Hello, World!
```

🎉 **Congratulations! You've run your first Java program!**

### Using an IDE

1. Create new Java project
2. Create new Java class named `HelloWorld`
3. Type the code above
4. Click "Run" button or press the run shortcut
5. See output in the console

---

## Understanding the Project Structure

This course is organized into 10 modules:

```
Java25/
├── README.md                    # Main course overview
├── GETTING_STARTED.md          # This file
│
├── 01-Basics/                  # Module 1: Java Fundamentals
│   ├── README.md
│   ├── HelloWorld.java
│   ├── Variables.java
│   ├── DataTypes.java
│   └── ... (more programs)
│
├── 02-ControlFlow/             # Module 2: Decision Making & Loops
│   ├── README.md
│   ├── IfElseStatements.java
│   ├── ForLoop.java
│   └── ... (more programs)
│
├── 03-OOP/                     # Module 3: Object-Oriented Programming
│   ├── README.md
│   ├── ClassesAndObjects.java
│   └── ... (more programs)
│
├── 04-Collections/             # Module 4: Data Structures
├── 05-ExceptionHandling/       # Module 5: Error Handling
├── 06-FileIO/                  # Module 6: File Operations
├── 07-Multithreading/          # Module 7: Concurrent Programming
├── 08-Lambdas/                 # Module 8: Functional Programming
├── 09-Streams/                 # Module 9: Stream API
└── 10-Advanced/                # Module 10: Advanced Topics
```

### Each Module Contains:

- **README.md**: Detailed explanations and theory
- **Programs**: Well-commented example code
- **Exercises**: Practice problems to test your understanding

---

## Learning Path

### 🌱 Beginner Level (Weeks 1-3)

**Module 1: Basics**
- Time: 3-5 days
- Focus: Syntax, variables, data types, operators
- Goal: Understand basic Java syntax

**Module 2: Control Flow**
- Time: 3-5 days
- Focus: If-else, loops, switch statements
- Goal: Make decisions and repeat actions in code

**Module 3: OOP Fundamentals**
- Time: 5-7 days
- Focus: Classes, objects, methods, constructors
- Goal: Understand object-oriented basics

### 🌿 Intermediate Level (Weeks 4-6)

**Module 3: Advanced OOP**
- Time: 5-7 days
- Focus: Inheritance, polymorphism, abstraction
- Goal: Master OOP principles

**Module 4: Collections**
- Time: 4-6 days
- Focus: ArrayList, HashMap, data structures
- Goal: Work with collections of data

**Module 5: Exception Handling**
- Time: 3-4 days
- Focus: Try-catch, custom exceptions
- Goal: Handle errors gracefully

**Module 6: File I/O**
- Time: 3-4 days
- Focus: Reading/writing files
- Goal: Work with external data

### 🌳 Advanced Level (Weeks 7-10)

**Module 7: Multithreading**
- Time: 5-7 days
- Focus: Threads, synchronization, concurrency
- Goal: Write concurrent programs

**Module 8: Lambda Expressions**
- Time: 3-4 days
- Focus: Functional programming in Java
- Goal: Write cleaner, more concise code

**Module 9: Streams API**
- Time: 4-5 days
- Focus: Data processing with streams
- Goal: Process collections functionally

**Module 10: Advanced Topics**
- Time: 5-7 days
- Focus: Generics, annotations, reflection
- Goal: Master advanced Java features

---

## Tips for Success

### 1. Practice Daily 📅
- Code for at least 30 minutes every day
- Consistency beats intensity

### 2. Type, Don't Copy-Paste ⌨️
- Type out all examples yourself
- Builds muscle memory
- Helps you understand better

### 3. Experiment 🔬
- Modify the example programs
- Break things and fix them
- Try different approaches

### 4. Read Error Messages 🐛
- Errors are learning opportunities
- Read them carefully
- Google the error message

### 5. Build Projects 🏗️
- Apply what you learn in small projects
- Start simple, gradually increase complexity
- Examples:
  - Calculator
  - To-do list
  - Simple game
  - Bank account manager

### 6. Use Comments 💬
- Comment your code
- Explain your thinking
- Future you will thank present you

### 7. Take Notes 📝
- Keep a coding journal
- Write down key concepts
- Document your learning journey

### 8. Join Communities 👥
- Stack Overflow
- Reddit (r/learnjava)
- Discord Java communities
- Local coding meetups

### 9. Don't Rush ⏰
- Take time to understand concepts
- It's okay to spend extra time on difficult topics
- Quality over speed

### 10. Celebrate Progress 🎉
- Acknowledge your achievements
- Track what you've learned
- Be proud of each milestone

---

## Troubleshooting

### Problem: "javac is not recognized"

**Solution**: 
- Java is not in your PATH
- Follow "Set JAVA_HOME" instructions above
- Restart terminal after setting PATH

### Problem: "Could not find or load main class"

**Solution**:
- Ensure class name matches file name exactly
- Make sure you're in the correct directory
- Check if .class file was created

### Problem: "Exception in thread main..."

**Solution**:
- Read the error message carefully
- Check line number mentioned in error
- Common causes: null pointer, array index out of bounds

### Problem: Program compiles but doesn't run as expected

**Solution**:
- Add print statements to debug
- Check your logic step by step
- Use IDE debugger to step through code

### Problem: IDE shows red underlines

**Solution**:
- Read the error tooltip
- Check for syntax errors
- Ensure proper imports

---

## Additional Resources

### Official Documentation
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Java Tutorials (Oracle)](https://docs.oracle.com/javase/tutorial/)
- [Java API Specification](https://docs.oracle.com/en/java/javase/21/docs/api/)

### Interactive Learning
- [Codecademy Java Course](https://www.codecademy.com/learn/learn-java)
- [JetBrains Academy](https://www.jetbrains.com/academy/)
- [Exercism Java Track](https://exercism.org/tracks/java)

### Video Tutorials
- [Java Programming for Beginners (YouTube)](https://www.youtube.com/results?search_query=java+programming+for+beginners)
- [Programming with Mosh](https://www.youtube.com/c/programmingwithmosh)
- [Coding with John](https://www.youtube.com/c/CodingwithJohn)

### Books
- "Head First Java" by Kathy Sierra
- "Effective Java" by Joshua Bloch
- "Java: A Beginner's Guide" by Herbert Schildt

### Practice Platforms
- [LeetCode](https://leetcode.com/)
- [HackerRank](https://www.hackerrank.com/domains/java)
- [Codewars](https://www.codewars.com/)
- [Project Euler](https://projecteuler.net/)

### Communities
- [Stack Overflow](https://stackoverflow.com/questions/tagged/java)
- [r/learnjava](https://www.reddit.com/r/learnjava/)
- [Java Discord Servers](https://discord.gg/java)

---

## Your Learning Checklist

Use this checklist to track your progress:

### Setup
- [ ] Java JDK installed and verified
- [ ] IDE or text editor set up
- [ ] First program compiled and run successfully
- [ ] Understand project structure

### Module 1: Basics
- [ ] Completed all programs
- [ ] Attempted exercises
- [ ] Can explain: variables, data types, operators
- [ ] Built a simple calculator

### Module 2: Control Flow
- [ ] Completed all programs
- [ ] Attempted exercises
- [ ] Can explain: if-else, loops, switch
- [ ] Built a number guessing game

### Module 3: OOP
- [ ] Completed all programs
- [ ] Attempted exercises
- [ ] Can explain: classes, objects, inheritance
- [ ] Built a class hierarchy

### Continue for each module...

---

## Next Steps

1. ✅ **Complete Setup**: Install Java and IDE
2. ✅ **Run Hello World**: Get your first program working
3. ✅ **Read Module 1 README**: Understand the basics
4. ✅ **Start with HelloWorld.java**: Begin your journey
5. ✅ **Practice Daily**: Build the habit
6. ✅ **Join a Community**: Find support and motivation

---

## Need Help?

If you get stuck:
1. Read the error message carefully
2. Check the README for the module
3. Review the example programs
4. Search on Google or Stack Overflow
5. Ask in Java communities

Remember: **Every expert was once a beginner!** 

---

## Motivational Quote

> "The journey of a thousand miles begins with a single step."
> — Lao Tzu

You've already taken the first step by opening this guide. Keep going! 💪

---

**Happy Coding! 🎉**

Start your journey: [Module 1 - Basics](01-Basics/README.md)