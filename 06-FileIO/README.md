# Module 6: File I/O (Input/Output) 📁

Welcome to Module 6! Here you'll learn how to work with files and directories in Java, including reading, writing, and managing file systems using both classic and modern NIO.2 APIs.

## 📖 Topics Covered

1. **File Basics** - File class and basic operations
2. **Reading Files** - Different ways to read file content
3. **Writing Files** - Creating and writing to files
4. **Buffered I/O** - Efficient file operations
5. **Binary Files** - Working with binary data
6. **Serialization** - Object persistence
7. **NIO.2 (Files & Paths)** - Modern file API (Java 7+)
8. **Directory Operations** - Working with folders
9. **File Attributes** - Metadata and permissions
10. **Watching Directories** - Monitoring file system changes

## 🎯 Learning Objectives

By the end of this module, you will:
- Read and write text files using multiple approaches
- Work with binary files and serialization
- Use BufferedReader/Writer for efficient I/O
- Master the modern Files and Paths API (NIO.2)
- Perform directory operations (create, delete, traverse)
- Handle file attributes and permissions
- Work with temporary files
- Implement file watching mechanisms
- Handle I/O exceptions properly
- Choose the right I/O approach for different scenarios

## 📝 Programs in This Module

### 1. FileBasics.java
Introduction to File class and basic file operations.

**Concepts**: File creation, existence check, properties, deletion

### 2. ReadingFiles.java
Different methods to read file content.

**Concepts**: FileReader, BufferedReader, Scanner, Files.readAllLines()

### 3. WritingFiles.java
Various ways to write data to files.

**Concepts**: FileWriter, BufferedWriter, PrintWriter, Files.write()

### 4. BufferedIO.java
Efficient file I/O using buffered streams.

**Concepts**: BufferedReader, BufferedWriter, performance comparison

### 5. BinaryFiles.java
Working with binary file formats.

**Concepts**: FileInputStream, FileOutputStream, DataInputStream, DataOutputStream

### 6. Serialization.java
Object serialization and deserialization.

**Concepts**: Serializable interface, ObjectInputStream, ObjectOutputStream

### 7. NIOPathsFiles.java
Modern file operations using NIO.2 API (Java 7+).

**Concepts**: Path, Paths, Files class, modern file operations

### 8. DirectoryOperations.java
Working with directories and file trees.

**Concepts**: Creating directories, listing files, walking file trees, recursive operations

### 9. FileAttributes.java
Reading and modifying file metadata.

**Concepts**: File attributes, permissions, timestamps, file size

### 10. TryWithResources.java
Automatic resource management for file operations.

**Concepts**: AutoCloseable, try-with-resources, multiple resources

### 11. FileWatcher.java
Monitoring file system changes.

**Concepts**: WatchService, file system events, directory monitoring

### 12. FileUtilities.java
Practical file utility methods and operations.

**Concepts**: Copy, move, delete, search, file filters, CSV processing

## 💡 Key Concepts

### File I/O Approaches

**Classic I/O (java.io)**:
- File, FileReader, FileWriter
- BufferedReader, BufferedWriter
- InputStream, OutputStream
- Available since Java 1.0

**NIO.2 (java.nio.file)** - Recommended:
- Path, Paths, Files
- More features and better error handling
- Available since Java 7
- Modern and efficient

### File I/O Hierarchy

```
Classic I/O (java.io)
├── File
├── FileReader / FileWriter
├── BufferedReader / BufferedWriter
├── FileInputStream / FileOutputStream
├── DataInputStream / DataOutputStream
└── ObjectInputStream / ObjectOutputStream

Modern NIO.2 (java.nio.file)
├── Path (interface)
├── Paths (factory)
├── Files (utility class)
├── FileSystem
└── WatchService
```

### Reading Files - Methods Comparison

| Method | Best For | Java Version | Performance |
|--------|----------|--------------|-------------|
| **FileReader** | Small files | 1.0+ | Slow |
| **BufferedReader** | Large files line-by-line | 1.1+ | Fast |
| **Scanner** | Parsing input | 5.0+ | Medium |
| **Files.readAllLines()** | Small to medium files | 7.0+ | Fast |
| **Files.lines()** | Large files (stream) | 8.0+ | Very Fast |
| **Files.readString()** | Small files | 11.0+ | Fast |

### Writing Files - Methods Comparison

| Method | Best For | Java Version | Features |
|--------|----------|--------------|----------|
| **FileWriter** | Simple writing | 1.0+ | Basic |
| **BufferedWriter** | Efficient writing | 1.1+ | Buffered |
| **PrintWriter** | Formatted output | 1.1+ | print/println |
| **Files.write()** | Byte arrays | 7.0+ | Simple API |
| **Files.writeString()** | Strings | 11.0+ | Convenient |

## 🔍 Common File Operations

### Classic I/O Way
```java
// Reading
BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
String line = reader.readLine();
reader.close();

// Writing
BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
writer.write("Hello, World!");
writer.close();
```

### Modern NIO.2 Way (Recommended)
```java
// Reading
List<String> lines = Files.readAllLines(Path.of("file.txt"));

// Writing
Files.writeString(Path.of("file.txt"), "Hello, World!");

// Reading large files
try (Stream<String> lines = Files.lines(Path.of("file.txt"))) {
    lines.forEach(System.out::println);
}
```

### Try-With-Resources (Recommended)
```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} // Automatically closed
```

## 🎓 Practice Exercises

### Exercise 1: Text File Analyzer
Create a program that:
- Reads a text file
- Counts lines, words, and characters
- Finds most frequent word
- Displays statistics

### Exercise 2: File Copy Utility
Build a utility that:
- Copies files from source to destination
- Shows progress for large files
- Handles errors gracefully
- Preserves file attributes

### Exercise 3: CSV Reader/Writer
Create a CSV processor:
- Reads CSV file into data structure
- Allows adding/removing rows
- Writes back to CSV
- Handles quoted fields

### Exercise 4: Log File Analyzer
Build a log analyzer that:
- Reads log files
- Filters by date/level
- Counts error types
- Generates summary report

### Exercise 5: Directory Backup
Implement backup utility:
- Copies entire directory structure
- Skips certain file types
- Creates compressed archive
- Logs all operations

### Exercise 6: File Search Tool
Create a search utility:
- Searches files by name pattern
- Searches content by keyword
- Supports wildcards
- Outputs matching files

### Exercise 7: Text File Merger
Build a file merger:
- Combines multiple text files
- Removes duplicates
- Sorts content
- Writes to output file

### Exercise 8: Configuration File Manager
Create config manager:
- Reads properties from file
- Updates configuration
- Validates values
- Saves changes

### Exercise 9: File Encryptor
Build encryption tool:
- Encrypts file content
- Decrypts encrypted files
- Uses password protection
- Handles large files

### Exercise 10: File Synchronizer
Implement sync utility:
- Compares two directories
- Identifies differences
- Syncs files (copy/update/delete)
- Generates sync report

## 🐛 Common Mistakes to Avoid

1. **Not Closing Resources**
   ```java
   // ❌ Wrong - resource leak
   FileReader reader = new FileReader("file.txt");
   // ... use reader ...
   // Forget to close
   
   // ✅ Correct - use try-with-resources
   try (FileReader reader = new FileReader("file.txt")) {
       // ... use reader ...
   } // Automatically closed
   ```

2. **Not Handling Exceptions**
   ```java
   // ❌ Wrong - no error handling
   Files.readAllLines(Path.of("file.txt"));
   
   // ✅ Correct - handle exceptions
   try {
       List<String> lines = Files.readAllLines(Path.of("file.txt"));
   } catch (IOException e) {
       System.err.println("Failed to read file: " + e.getMessage());
   }
   ```

3. **Using Wrong Path Separator**
   ```java
   // ❌ Wrong - hardcoded separator
   File file = new File("folder\\file.txt"); // Windows only
   
   // ✅ Correct - use File.separator or Path
   File file = new File("folder" + File.separator + "file.txt");
   Path path = Path.of("folder", "file.txt"); // Best
   ```

4. **Reading Large Files Inefficiently**
   ```java
   // ❌ Wrong - loads entire file in memory
   String content = new String(Files.readAllBytes(Path.of("large.txt")));
   
   // ✅ Correct - process line by line
   try (Stream<String> lines = Files.lines(Path.of("large.txt"))) {
       lines.forEach(this::processLine);
   }
   ```

5. **Not Checking File Existence**
   ```java
   // ❌ Wrong - no existence check
   Files.readAllLines(Path.of("file.txt")); // May throw exception
   
   // ✅ Correct - check first
   Path path = Path.of("file.txt");
   if (Files.exists(path)) {
       List<String> lines = Files.readAllLines(path);
   }
   ```

6. **Using Absolute Paths**
   ```java
   // ❌ Wrong - absolute path (not portable)
   Path path = Path.of("C:\\Users\\John\\file.txt");
   
   // ✅ Correct - relative path
   Path path = Path.of("data", "file.txt");
   ```

## 💎 Best Practices

### 1. Always Use Try-With-Resources
```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    // Use reader
} // Automatically closed
```

### 2. Prefer NIO.2 Over Classic I/O
```java
// Old way
File file = new File("file.txt");
if (file.exists()) {
    BufferedReader reader = new BufferedReader(new FileReader(file));
    // ...
}

// Modern way
Path path = Path.of("file.txt");
if (Files.exists(path)) {
    List<String> lines = Files.readAllLines(path);
}
```

### 3. Use Appropriate Charset
```java
// Specify charset explicitly
Files.readAllLines(path, StandardCharsets.UTF_8);
Files.writeString(path, content, StandardCharsets.UTF_8);
```

### 4. Handle Exceptions Properly
```java
try {
    Files.readAllLines(path);
} catch (NoSuchFileException e) {
    System.err.println("File not found: " + path);
} catch (AccessDeniedException e) {
    System.err.println("Access denied: " + path);
} catch (IOException e) {
    System.err.println("I/O error: " + e.getMessage());
}
```

### 5. Use Buffering for Large Files
```java
// For large files, use buffered I/O or streaming
try (BufferedReader reader = Files.newBufferedReader(path)) {
    String line;
    while ((line = reader.readLine()) != null) {
        processLine(line);
    }
}
```

### 6. Choose Right Method for File Size
```java
// Small files
String content = Files.readString(path);

// Medium files
List<String> lines = Files.readAllLines(path);

// Large files
try (Stream<String> lines = Files.lines(path)) {
    lines.forEach(this::processLine);
}
```

### 7. Use Path.of() for Path Creation (Java 11+)
```java
// Modern (Java 11+)
Path path = Path.of("folder", "subfolder", "file.txt");

// Older
Path path = Paths.get("folder", "subfolder", "file.txt");
```

### 8. Handle Temporary Files Properly
```java
Path tempFile = Files.createTempFile("prefix", ".tmp");
try {
    // Use temp file
} finally {
    Files.deleteIfExists(tempFile);
}
```

## 📊 Performance Considerations

### File Reading Performance

| Method | 1MB File | 10MB File | 100MB File |
|--------|----------|-----------|------------|
| Files.readAllLines() | Fast | Medium | Slow (Memory) |
| BufferedReader | Fast | Fast | Fast |
| Files.lines() (Stream) | Fast | Fast | Very Fast |
| Scanner | Slow | Very Slow | Very Slow |

### Recommendations:
- **Small files** (< 10MB): Use `Files.readAllLines()` or `Files.readString()`
- **Large files** (> 10MB): Use `BufferedReader` or `Files.lines()` with streams
- **Parsing**: Use `Scanner` only when you need parsing features

## 🔗 What's Next?

After mastering File I/O, you'll move on to:
- **Module 7: Multithreading** - Concurrent programming
- Advanced file operations in Module 10

## 📖 Additional Resources

- [File I/O (Oracle Tutorial)](https://docs.oracle.com/javase/tutorial/essential/io/)
- [NIO.2 Guide](https://docs.oracle.com/javase/tutorial/essential/io/fileio.html)
- [Path Class Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Path.html)
- [Files Class Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html)

## 💡 Pro Tips

1. **Always specify charset** when reading/writing text files
2. **Use NIO.2** (Path, Files) instead of old File class
3. **Try-with-resources** ensures resources are closed
4. **Stream large files** instead of loading into memory
5. **Check file existence** before operations
6. **Use relative paths** for portability
7. **Handle specific exceptions** for better error messages
8. **Test with different file sizes** and encodings
9. **Consider file locking** for concurrent access
10. **Use Files.walk()** for recursive directory traversal

## 🎭 Common File I/O Patterns

### 1. Read All Lines Pattern
```java
try {
    List<String> lines = Files.readAllLines(Path.of("file.txt"));
    lines.forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}
```

### 2. Process Large File Pattern
```java
try (Stream<String> lines = Files.lines(Path.of("large.txt"))) {
    lines.filter(line -> line.contains("ERROR"))
         .forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}
```

### 3. Write Lines Pattern
```java
List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
try {
    Files.write(Path.of("output.txt"), lines);
} catch (IOException e) {
    e.printStackTrace();
}
```

### 4. Copy File Pattern
```java
Path source = Path.of("source.txt");
Path target = Path.of("target.txt");
try {
    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e) {
    e.printStackTrace();
}
```

### 5. Walk Directory Tree Pattern
```java
try (Stream<Path> paths = Files.walk(Path.of("directory"))) {
    paths.filter(Files::isRegularFile)
         .filter(p -> p.toString().endsWith(".txt"))
         .forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}
```

## 📋 File I/O Checklist

Before working with files, ensure:
- [ ] File/directory exists (if reading)
- [ ] Parent directory exists (if writing)
- [ ] Appropriate permissions
- [ ] Correct charset specified
- [ ] Resources will be closed (try-with-resources)
- [ ] Exceptions are handled
- [ ] Path is correct (relative/absolute)
- [ ] File size is considered (memory usage)
- [ ] Concurrent access is handled (if needed)

## 🔒 Security Considerations

1. **Validate file paths** - prevent directory traversal attacks
2. **Check file size** before reading - prevent memory exhaustion
3. **Set appropriate permissions** on created files
4. **Don't expose full paths** in error messages
5. **Sanitize filenames** from user input
6. **Use secure temporary directories**
7. **Delete sensitive files securely**

---

**Ready to master File I/O? Start with FileBasics.java!** 🚀

**Estimated Time**: 3-4 days | **Difficulty**: ⭐⭐⭐ Intermediate