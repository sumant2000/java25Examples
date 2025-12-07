# Java 25 Quick Reference Card 🚀

## Core Syntax

### Variables
```java
int age = 30;
String name = "Alice";
var list = List.of(1, 2, 3);  // Type inference
final int MAX = 100;
```

### Control Flow
```java
// If-else
if (condition) { } else { }

// Switch expression
String result = switch (value) {
    case 1 -> "One";
    case 2 -> "Two";
    default -> "Other";
};

// For loop
for (int i = 0; i < 10; i++) { }

// Enhanced for
for (String item : list) { }

// While
while (condition) { }
```

### Methods
```java
public static int add(int a, int b) {
    return a + b;
}
```

---

## Object-Oriented Programming

### Classes
```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
}
```

### Records (Java 16+)
```java
record Person(String name, int age) {}

// Auto-generates: constructor, getters, equals, hashCode, toString
```

### Interfaces
```java
public interface Drawable {
    void draw();
    
    default void print() {
        System.out.println("Drawing");
    }
}
```

### Sealed Classes (Java 17+)
```java
sealed interface Shape permits Circle, Rectangle {}
final class Circle implements Shape {}
final class Rectangle implements Shape {}
```

---

## Lambda & Streams

### Lambda Expressions
```java
// No parameters
() -> System.out.println("Hello")

// Single parameter
x -> x * 2

// Multiple parameters
(x, y) -> x + y

// Block
(x, y) -> {
    int sum = x + y;
    return sum;
}
```

### Functional Interfaces
```java
Predicate<Integer> isEven = n -> n % 2 == 0;
Function<String, Integer> length = s -> s.length();
Consumer<String> print = s -> System.out.println(s);
Supplier<Double> random = () -> Math.random();
```

### Streams
```java
list.stream()
    .filter(x -> x > 5)
    .map(x -> x * 2)
    .sorted()
    .distinct()
    .limit(10)
    .forEach(System.out::println);

// Collect to list
List<Integer> result = stream.collect(Collectors.toList());

// Reduce
int sum = stream.reduce(0, (a, b) -> a + b);

// Group by
Map<Type, List<Item>> grouped = 
    stream.collect(Collectors.groupingBy(Item::getType));
```

---

## Pattern Matching

### instanceof (Java 16+)
```java
if (obj instanceof String s) {
    System.out.println(s.length());
}
```

### switch (Java 21+)
```java
String result = switch (obj) {
    case String s -> "String: " + s;
    case Integer i -> "Integer: " + i;
    case null -> "null";
    default -> "Unknown";
};
```

### Record Patterns (Java 21+)
```java
record Point(int x, int y) {}

if (obj instanceof Point(int x, int y)) {
    System.out.println(x + ", " + y);
}
```

---

## Collections

### Creation
```java
// Mutable
List<String> list = new ArrayList<>();
Set<Integer> set = new HashSet<>();
Map<String, Integer> map = new HashMap<>();

// Immutable (Java 9+)
List<String> list = List.of("a", "b", "c");
Set<Integer> set = Set.of(1, 2, 3);
Map<String, Integer> map = Map.of("key", 1);
```

### Common Operations
```java
// List
list.add("item");
list.get(0);
list.remove(0);
list.size();

// Set
set.add(item);
set.contains(item);
set.remove(item);

// Map
map.put("key", value);
map.get("key");
map.containsKey("key");
map.forEach((k, v) -> ...);

// Sequenced Collections (Java 21+)
list.addFirst(item);
list.addLast(item);
list.getFirst();
list.getLast();
list.reversed();
```

---

## String Operations

### Basic
```java
String s = "Hello";
s.length();
s.charAt(0);
s.substring(1, 4);
s.toUpperCase();
s.toLowerCase();
s.trim();
s.split(",");
s.contains("ell");
s.startsWith("He");
s.endsWith("lo");
```

### Java 11+
```java
" ".isBlank();
"text".lines();
" text ".strip();
"Hi".repeat(3);
```

### Text Blocks (Java 15+)
```java
String json = """
    {
        "name": "John",
        "age": 30
    }
    """;
```

---

## Virtual Threads (Java 21+)

### Creation
```java
// Method 1
Thread.startVirtualThread(() -> { /* task */ });

// Method 2
Thread.ofVirtual().start(() -> { /* task */ });

// Method 3
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> { /* task */ });
}
```

### Structured Concurrency
```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    var task1 = scope.fork(() -> compute1());
    var task2 = scope.fork(() -> compute2());
    
    scope.join();
    scope.throwIfFailed();
    
    result1 = task1.resultNow();
    result2 = task2.resultNow();
}
```

---

## Exception Handling

### Try-Catch
```java
try {
    // risky code
} catch (IOException e) {
    // handle
} catch (Exception e) {
    // handle
} finally {
    // cleanup
}
```

### Try-with-Resources
```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    // use br
} // auto-closed
```

### Throwing
```java
throw new IllegalArgumentException("Invalid input");

public void method() throws IOException {
    // might throw
}
```

---

## File I/O

### Reading
```java
// Java 11+
String content = Files.readString(Path.of("file.txt"));

// Lines
Files.lines(Path.of("file.txt"))
     .forEach(System.out::println);

// All lines
List<String> lines = Files.readAllLines(Path.of("file.txt"));
```

### Writing
```java
// Java 11+
Files.writeString(Path.of("file.txt"), "content");

// Multiple lines
List<String> lines = List.of("line1", "line2");
Files.write(Path.of("file.txt"), lines);
```

---

## Date & Time (java.time)

```java
// Current
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();

// Specific
LocalDate date = LocalDate.of(2025, 12, 7);
LocalTime time = LocalTime.of(10, 30);

// Operations
date.plusDays(7);
date.minusMonths(1);
date.isAfter(otherDate);

// Formatting
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String formatted = date.format(formatter);
```

---

## Optional

```java
// Creation
Optional<String> opt = Optional.of("value");
Optional<String> empty = Optional.empty();
Optional<String> nullable = Optional.ofNullable(maybeNull);

// Checking
opt.isPresent();
opt.isEmpty();

// Getting
opt.get();  // throws if empty
opt.orElse("default");
opt.orElseGet(() -> compute());
opt.orElseThrow();

// Transforming
opt.map(String::toUpperCase);
opt.filter(s -> s.length() > 5);
opt.flatMap(s -> Optional.of(s + "!"));

// Consuming
opt.ifPresent(System.out::println);
opt.ifPresentOrElse(
    value -> use(value),
    () -> handleEmpty()
);
```

---

## Common Patterns

### Singleton
```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() { return INSTANCE; }
}
```

### Builder
```java
Person person = Person.builder()
    .name("Alice")
    .age(30)
    .build();
```

### Factory
```java
public static Shape createShape(String type) {
    return switch (type) {
        case "circle" -> new Circle();
        case "square" -> new Square();
        default -> throw new IllegalArgumentException();
    };
}
```

---

## Compilation & Execution

```bash
# Compile
javac MyClass.java

# Run
java MyClass

# Run directly (Java 11+)
java MyClass.java

# With classpath
java -cp "lib/*:." MyClass

# JAR
jar cf myapp.jar *.class
java -jar myapp.jar
```

---

## JDK Tools

```bash
# Interactive shell
jshell

# Web server
jwebserver

# Documentation
javadoc -d docs *.java

# Decompiler
javap MyClass.class
```

---

**Keep this reference handy while coding! 📖**
