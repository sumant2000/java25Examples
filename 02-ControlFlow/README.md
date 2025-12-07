# Module 2: Control Flow 🔀

Welcome to Module 2! Here you'll learn how to control the flow of execution in your Java programs.

## 📖 Topics Covered

1. **If-Else Statements** - Making decisions in code
2. **Switch Statements** - Multi-way branching
3. **For Loops** - Repeating actions with a counter
4. **While Loops** - Repeating actions based on conditions
5. **Do-While Loops** - Execute at least once, then repeat
6. **Break Statement** - Exit loops early
7. **Continue Statement** - Skip to next iteration
8. **Nested Loops** - Loops within loops

## 🎯 Learning Objectives

By the end of this module, you will:
- Make decisions using conditional statements
- Choose between if-else and switch statements
- Use different types of loops effectively
- Control loop execution with break and continue
- Work with nested control structures
- Solve problems using loops and conditionals

## 📝 Programs in This Module

### 1. IfElseStatements.java
Learn how to make decisions in your code using if, else if, and else.

**Concepts**: Boolean conditions, comparison operators, nested if-else

### 2. SwitchStatement.java
Use switch for multi-way branching with cleaner syntax.

**Concepts**: switch-case, break, default case, Java 14+ enhanced switch

### 3. ForLoop.java
Repeat actions a specific number of times using for loops.

**Concepts**: Initialization, condition, increment/decrement, loop body

### 4. WhileLoop.java
Execute code repeatedly while a condition is true.

**Concepts**: Pre-condition loops, infinite loops, sentinel values

### 5. DoWhileLoop.java
Similar to while loop but executes at least once.

**Concepts**: Post-condition loops, menu-driven programs

### 6. BreakContinue.java
Control loop execution with break and continue statements.

**Concepts**: Early exit, skipping iterations, labeled break/continue

### 7. NestedLoops.java
Use loops inside other loops for complex patterns and 2D structures.

**Concepts**: Nested for loops, matrix operations, pattern printing

### 8. LoopExamples.java
Practical examples combining loops and conditionals.

**Concepts**: Searching, counting, validation, pattern generation

## 💡 Key Concepts

### If-Else Statement Structure
```
if (condition) {
    // Code if condition is true
} else if (anotherCondition) {
    // Code if anotherCondition is true
} else {
    // Code if all conditions are false
}
```

### Switch Statement Structure
```
switch (variable) {
    case value1:
        // Code
        break;
    case value2:
        // Code
        break;
    default:
        // Default code
}
```

### For Loop Structure
```
for (initialization; condition; update) {
    // Loop body
}
```

### While Loop Structure
```
while (condition) {
    // Loop body
}
```

### Do-While Loop Structure
```
do {
    // Loop body
} while (condition);
```

## 🔨 When to Use What?

### If-Else vs Switch
- **Use if-else** when:
  - Conditions involve ranges (age >= 18)
  - Complex boolean expressions
  - Different types of conditions
  
- **Use switch** when:
  - Checking equality against multiple values
  - Working with enums
  - Multiple distinct cases

### For vs While vs Do-While
- **Use for loop** when:
  - You know the number of iterations
  - Iterating over a range
  - Counting up or down
  
- **Use while loop** when:
  - Number of iterations is unknown
  - Loop depends on user input
  - Reading until end of file
  
- **Use do-while loop** when:
  - Loop must execute at least once
  - Menu-driven programs
  - Input validation

## 🎓 Practice Exercises

After going through all programs, try these exercises:

### Exercise 1: Grade Calculator
Create a program that:
- Takes a numerical score (0-100) as input
- Converts to letter grade (A, B, C, D, F)
- A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: 0-59

### Exercise 2: Multiplication Table
Write a program that:
- Takes a number as input
- Prints the multiplication table for that number (1 to 10)
- Example: 5 x 1 = 5, 5 x 2 = 10, etc.

### Exercise 3: Prime Number Checker
Create a program that:
- Takes a number as input
- Checks if it's prime
- A prime number is divisible only by 1 and itself

### Exercise 4: Factorial Calculator
Write a program that:
- Takes a number n as input
- Calculates factorial (n!)
- Example: 5! = 5 × 4 × 3 × 2 × 1 = 120

### Exercise 5: Fibonacci Series
Create a program that:
- Takes n as input
- Prints first n Fibonacci numbers
- Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21...

### Exercise 6: Number Pyramid
Write a program that prints:
```
    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
```

### Exercise 7: ATM Machine Simulator
Create a simple ATM program with:
- Menu: Check Balance, Deposit, Withdraw, Exit
- Use do-while for menu loop
- Validate inputs (no negative amounts)

### Exercise 8: Number Guessing Game
Write a program that:
- Generates a random number (1-100)
- User guesses the number
- Gives hints: "Too high" or "Too low"
- Counts number of attempts

### Exercise 9: Reverse a Number
Create a program that:
- Takes a number as input (e.g., 1234)
- Prints it in reverse (4321)
- Use loop and modulus operator

### Exercise 10: Pattern Printer
Write a program that prints various patterns:
- Right triangle
- Inverted triangle
- Diamond shape
- Hollow square

## 🐛 Common Mistakes to Avoid

1. **Missing braces** - Always use {} even for single statements
2. **Infinite loops** - Ensure loop condition eventually becomes false
3. **Off-by-one errors** - Remember: i < 10 runs 10 times (0-9)
4. **Forgetting break in switch** - Without break, execution falls through
5. **Using = instead of ==** - Assignment vs comparison
6. **Wrong loop type** - Choose appropriate loop for the task
7. **Modifying loop variable inside loop** - Can cause unexpected behavior

## 📊 Loop Comparison

| Feature | For Loop | While Loop | Do-While Loop |
|---------|----------|------------|---------------|
| Use case | Known iterations | Unknown iterations | At least once |
| Check condition | Before execution | Before execution | After execution |
| Best for | Counting | Conditional repeat | Menu systems |
| Syntax complexity | More complex | Simple | Simple |

## 🔗 What's Next?

After mastering control flow, you'll move on to:
- **Module 3: Object-Oriented Programming** - Classes, objects, and OOP principles

## 📖 Additional Resources

- [Control Flow Statements (Oracle)](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
- [The if-then and if-then-else Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html)
- [The switch Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
- [The for Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [The while and do-while Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html)

## 💡 Pro Tips

1. **Readability**: Use meaningful condition names
2. **DRY Principle**: Don't repeat yourself - use loops
3. **Early Exit**: Use break to exit loops early when condition is met
4. **Loop Invariants**: Understand what's true before, during, and after loop
5. **Testing**: Test edge cases (0, 1, negative numbers, etc.)

---

**Ready to control the flow? Start with IfElseStatements.java!** 🚀