# Module 15: Modern Java APIs (Java 8-25) 🚀

## Overview

This module covers modern Java APIs and features introduced from Java 8 through Java 25. These features represent the evolution of Java into a more expressive, efficient, and developer-friendly language.

## Java Version Timeline

### Java 8 (2014) - The Game Changer
- Lambda Expressions
- Stream API
- Optional
- Date/Time API (java.time)
- Default methods in interfaces
- Method references

### Java 9 (2017) - Modularity
- Module System (Project Jigsaw)
- JShell (REPL)
- Factory methods for collections
- Private methods in interfaces
- Process API improvements

### Java 10 (2018) - Local Type Inference
- `var` keyword for local variables
- Application Class-Data Sharing

### Java 11 (2018) - LTS Release
- HTTP Client (standard)
- String methods (isBlank, lines, strip, repeat)
- Files methods (readString, writeString)
- Running Java files directly

### Java 12-13 (2019)
- Switch Expressions (preview)
- Text Blocks (preview)

### Java 14 (2020)
- Switch Expressions (standard)
- Pattern Matching for instanceof (preview)
- Records (preview)
- Helpful NullPointerExceptions

### Java 15 (2020)
- Text Blocks (standard)
- Sealed Classes (preview)

### Java 16 (2021)
- Pattern Matching for instanceof (standard)
- Records (standard)
- Unix-Domain Socket Channels

### Java 17 (2021) - LTS Release
- Sealed Classes (standard)
- Pattern Matching enhancements
- Strong encapsulation by default

### Java 18-20 (2022-2023)
- Simple Web Server
- Code Snippets in JavaDoc
- Vector API improvements
- Pattern Matching refinements

### Java 21 (2023) - LTS Release
- Virtual Threads (Project Loom)
- Structured Concurrency (preview)
- Pattern Matching for switch (standard)
- Record Patterns
- String Templates (preview)
- Sequenced Collections

### Java 22-25 (2024-2025)
- Primitive patterns in switch
- Stream Gatherers
- Statements before super()
- Module Import Declarations
- Flexible Constructor Bodies
- Continued refinements and optimizations

## Key Java 25 Features

### 1. Primitive Type Patterns (JEP 455)
Enhanced pattern matching with primitive types.

```java
String formatted = switch (obj) {
    case Integer i -> "int " + i;
    case Long l -> "long " + l;
    case Double d -> "double " + d;
    case String s -> "String " + s;
    default -> "unknown";
};
```

### 2. Stream Gatherers (JEP 461)
Intermediate stream operations for custom transformations.

```java
// Custom gathering operations
stream.gather(Gatherers.windowFixed(3))
      .forEach(window -> process(window));
```

### 3. Flexible Constructor Bodies (JEP 482)
Statements before super() in constructors.

```java
public class Child extends Parent {
    public Child(String name) {
        // Can add validation before super()
        if (name == null) throw new IllegalArgumentException();
        super(name);
    }
}
```

### 4. Module Import Declarations (JEP 476)
Import all public classes from a module.

```java
import module java.sql;
// All public classes from java.sql available
```

### 5. Structured Concurrency Refinements
Enhanced structured concurrency APIs.

```java
try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
    var future = scope.fork(() -> compute());
    scope.join();
    return scope.result();
}
```

## Modern String APIs

### Java 11+ String Methods
```java
" ".isBlank()                    // true
"Hello\nWorld".lines()           // Stream<String>
" hello ".strip()                // "hello"
"Java".repeat(3)                 // "JavaJavaJava"
```

### Java 15+ Text Blocks
```java
String html = """
    <html>
        <body>
            <h1>Hello</h1>
        </body>
    </html>
    """;
```

### Java 21+ String Templates (Preview)
```java
String name = "Alice";
int age = 30;
String message = STR."Hello \{name}, you are \{age} years old";
```

## Sequenced Collections (Java 21+)

### New Interfaces
```java
SequencedCollection<E>
SequencedSet<E>
SequencedMap<K,V>
```

### New Methods
```java
list.addFirst(element);
list.addLast(element);
list.getFirst();
list.getLast();
list.reversed();  // Returns reversed view
```

## HTTP Client API (Java 11+)

### Modern HTTP Requests
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .header("Content-Type", "application/json")
    .GET()
    .build();

HttpResponse<String> response = client.send(request, 
    HttpResponse.BodyHandlers.ofString());
```

### Async Requests
```java
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenAccept(System.out::println);
```

## Files API Enhancements

### Java 11+
```java
String content = Files.readString(Path.of("file.txt"));
Files.writeString(Path.of("file.txt"), "content");
```

### Java 8+
```java
Files.lines(Path.of("file.txt"))
     .filter(line -> !line.isEmpty())
     .forEach(System.out::println);
```

## Process API (Java 9+)

```java
ProcessHandle current = ProcessHandle.current();
System.out.println("PID: " + current.pid());

current.info().command().ifPresent(System.out::println);
```

## Collection Factory Methods (Java 9+)

```java
List<String> list = List.of("a", "b", "c");
Set<Integer> set = Set.of(1, 2, 3);
Map<String, Integer> map = Map.of("a", 1, "b", 2);
```

## Examples in This Module

1. `ModernStringAPIs.java` - String enhancements
2. `SequencedCollections.java` - New collection interfaces
3. `HTTPClientDemo.java` - Modern HTTP client
4. `FilesAPIDemo.java` - File operations
5. `ProcessAPIDemo.java` - Process handling
6. `VarUsage.java` - Type inference
7. `SwitchEnhancements.java` - Modern switch
8. `Java25Features.java` - Latest features

## Best Practices

1. **Use modern APIs** - Replace old APIs with new ones
2. **Leverage type inference** - Use `var` when appropriate
3. **Prefer immutable collections** - Use factory methods
4. **Use virtual threads** - For I/O-bound operations
5. **Pattern matching** - Simplify type checks
6. **Records** - For data classes
7. **Text blocks** - For multi-line strings
8. **Optional** - Handle nullability gracefully

## Migration Guide

### From Old to New
```java
// Old
List<String> list = new ArrayList<>();
list.add("a");
list.add("b");

// New
var list = List.of("a", "b");

// Old
if (obj instanceof String) {
    String s = (String) obj;
    use(s);
}

// New
if (obj instanceof String s) {
    use(s);
}
```

## Practice Exercises

1. Refactor legacy code to use modern APIs
2. Implement HTTP client with async requests
3. Use pattern matching throughout application
4. Convert classes to records where appropriate
5. Utilize virtual threads for concurrent operations
6. Create text blocks for JSON/XML/SQL
7. Use sequenced collections for ordered data

---

**Start Your Modern Java Journey!**
