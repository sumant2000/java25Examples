/**
 * WritingFiles.java
 *
 * This program demonstrates various methods to write files in Java using both
 * classic I/O and modern NIO.2 APIs. Covers all major writing techniques with
 * the latest Java features.
 *
 * Key Concepts:
 * - FileWriter and BufferedWriter
 * - PrintWriter for formatted output
 * - Files.writeString() and Files.write()
 * - Appending to files
 * - Writing with different character encodings
 * - Writing binary data
 * - Performance considerations
 *
 * Java Features Used: Java 11+ (Files.writeString, Path.of, var, try-with-resources)
 */

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WritingFiles {

    public static void main(String[] args) {

        System.out.println("========== WRITING FILES DEMONSTRATION ==========\n");

        // ========== METHOD 1: FILEWRITER (CLASSIC) ==========

        System.out.println("--- 1. FileWriter (Classic Way) ---\n");

        try (FileWriter writer = new FileWriter("classic_output.txt")) {
            writer.write("Hello from FileWriter!\n");
            writer.write("This is the second line.\n");
            writer.write("FileWriter writes character streams.\n");
            System.out.println("✓ File written using FileWriter");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }


        // ========== METHOD 2: BUFFEREDWRITER ==========

        System.out.println("\n--- 2. BufferedWriter (Efficient) ---\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("buffered_output.txt"))) {
            writer.write("Line 1: BufferedWriter is more efficient");
            writer.newLine(); // Platform-independent newline
            writer.write("Line 2: It uses internal buffer");
            writer.newLine();
            writer.write("Line 3: Best for writing multiple lines");
            writer.newLine();
            System.out.println("✓ File written using BufferedWriter");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }


        // ========== METHOD 3: PRINTWRITER ==========

        System.out.println("\n--- 3. PrintWriter (Formatted Output) ---\n");

        try (PrintWriter writer = new PrintWriter("formatted_output.txt")) {
            writer.println("PrintWriter Demo");
            writer.println("=================");
            writer.printf("Name: %s%n", "John Doe");
            writer.printf("Age: %d%n", 30);
            writer.printf("Salary: $%.2f%n", 50000.50);
            writer.printf("Date: %s%n", LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println("✓ File written using PrintWriter");
        } catch (FileNotFoundException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }


        // ========== METHOD 4: FILES.WRITESTRING() ==========

        System.out.println("\n--- 4. Files.writeString() (Java 11+) ---\n");

        try {
            Path path = Path.of("modern_output.txt");
            String content = """
                This is written using Files.writeString()
                Modern, simple, and efficient method
                Introduced in Java 11
                Perfect for small to medium text files
                Automatically handles encoding
                """;
            Files.writeString(path, content, StandardCharsets.UTF_8);
            System.out.println("✓ File written using Files.writeString()");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }


        // ========== METHOD 5: FILES.WRITE() WITH LINES ==========

        System.out.println("\n--- 5. Files.write() with Lines ---\n");

        try {
            Path path = Path.of("lines_output.txt");
            List<String> lines = Arrays.asList(
                "First line",
                "Second line",
                "Third line",
                "Fourth line",
                "Fifth line"
            );
            Files.write(path, lines, StandardCharsets.UTF_8);
            System.out.println("✓ File written using Files.write() with lines");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }


        // ========== METHOD 6: FILES.WRITE() WITH BYTES ==========

        System.out.println("\n--- 6. Files.write() with Bytes ---\n");

        try {
            Path path = Path.of("bytes_output.txt");
            String content = "Content written as byte array";
            byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
            Files.write(path, bytes);
            System.out.println("✓ File written using Files.write() with bytes");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }


        // ========== APPENDING TO FILES ==========

        System.out.println("\n\n--- 7. Appending to Files ---\n");

        try {
            Path path = Path.of("append_demo.txt");

            // Create initial file
            Files.writeString(path, "Initial content\n");
            System.out.println("✓ Created file with initial content");

            // Append using FileWriter (classic)
            try (FileWriter writer = new FileWriter(path.toFile(), true)) {
                writer.write("Appended using FileWriter\n");
            }
            System.out.println("✓ Appended using FileWriter");

            // Append using Files API
            String appendContent = "Appended using Files API\n";
            Files.writeString(path, appendContent,
                StandardOpenOption.APPEND);
            System.out.println("✓ Appended using Files.writeString()");

            // Read and display final content
            System.out.println("\nFinal file content:");
            Files.lines(path).forEach(line -> System.out.println("  " + line));

        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }


        // ========== WRITING WITH DIFFERENT ENCODINGS ==========

        System.out.println("\n\n--- 8. Writing with Different Encodings ---\n");

        String text = "Hello World! Encoding Test: àéïöü";

        try {
            // UTF-8
            Files.writeString(Path.of("utf8_file.txt"), text,
                StandardCharsets.UTF_8);
            System.out.println("✓ Written with UTF-8 encoding");

            // ASCII
            Files.writeString(Path.of("ascii_file.txt"), text,
                StandardCharsets.US_ASCII);
            System.out.println("✓ Written with ASCII encoding");

            // ISO-8859-1
            Files.writeString(Path.of("iso_file.txt"), text,
                StandardCharsets.ISO_8859_1);
            System.out.println("✓ Written with ISO-8859-1 encoding");

        } catch (IOException e) {
            System.err.println("Error writing with encodings: " + e.getMessage());
        }


        // ========== WRITING BINARY DATA ==========

        System.out.println("\n\n--- 9. Writing Binary Data ---\n");

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("binary_data.bin"))) {

            // Write different data types
            dos.writeInt(12345);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Binary String");
            dos.writeLong(9876543210L);

            System.out.println("✓ Binary data written to file");
            System.out.println("  int: 12345");
            System.out.println("  double: 3.14159");
            System.out.println("  boolean: true");
            System.out.println("  String: Binary String");
            System.out.println("  long: 9876543210");

        } catch (IOException e) {
            System.err.println("Error writing binary data: " + e.getMessage());
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 10. Practical Examples ---\n");

        // Example 1: Write CSV file
        System.out.println("Example 1: Writing CSV File");
        writeCSVFile();

        // Example 2: Write log file
        System.out.println("\nExample 2: Writing Log File");
        writeLogFile("Application started");
        writeLogFile("User login: john.doe");
        writeLogFile("Processing data...");
        writeLogFile("Application shutdown");
        System.out.println("✓ Log entries written");

        // Example 3: Write JSON-like data
        System.out.println("\nExample 3: Writing Structured Data");
        writeStructuredData();

        // Example 4: Write properties file
        System.out.println("\nExample 4: Writing Properties File");
        writePropertiesFile();

        // Example 5: Write multiple files
        System.out.println("\nExample 5: Writing Multiple Files");
        writeMultipleFiles();


        // ========== ATOMIC WRITES ==========

        System.out.println("\n\n--- 11. Atomic Writes (Safe Writing) ---\n");

        try {
            Path tempPath = Path.of("temp_file.txt");
            Path finalPath = Path.of("final_file.txt");

            // Write to temporary file first
            String content = "Important data that must be written completely";
            Files.writeString(tempPath, content);

            // Move atomically (replaces if exists)
            Files.move(tempPath, finalPath,
                StandardCopyOption.ATOMIC_MOVE,
                StandardCopyOption.REPLACE_EXISTING);

            System.out.println("✓ File written atomically (safe write)");

        } catch (IOException e) {
            System.err.println("Error in atomic write: " + e.getMessage());
        }


        // ========== WRITING WITH BUFFEREDWRITER (DETAILED) ==========

        System.out.println("\n\n--- 12. BufferedWriter Details ---\n");

        try (BufferedWriter writer = Files.newBufferedWriter(
                Path.of("buffered_detailed.txt"), StandardCharsets.UTF_8)) {

            writer.write("BufferedWriter Features:");
            writer.newLine();
            writer.write("- Efficient for large amounts of data");
            writer.newLine();
            writer.write("- Uses internal buffer");
            writer.newLine();
            writer.write("- Platform-independent newLine() method");
            writer.newLine();
            writer.write("- Can be flushed manually");
            writer.newLine();

            writer.flush(); // Explicitly flush buffer

            System.out.println("✓ Detailed BufferedWriter example completed");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


        // ========== PERFORMANCE COMPARISON ==========

        System.out.println("\n\n--- 13. Performance Comparison ---\n");

        int lineCount = 10000;
        System.out.println("Writing " + lineCount + " lines using different methods:\n");

        // Method 1: FileWriter
        long start = System.nanoTime();
        writeWithFileWriter("perf_filewriter.txt", lineCount);
        long time1 = System.nanoTime() - start;
        System.out.println("FileWriter: " + time1 / 1_000_000 + "ms");

        // Method 2: BufferedWriter
        start = System.nanoTime();
        writeWithBufferedWriter("perf_buffered.txt", lineCount);
        long time2 = System.nanoTime() - start;
        System.out.println("BufferedWriter: " + time2 / 1_000_000 + "ms");

        // Method 3: Files.write
        start = System.nanoTime();
        writeWithFilesAPI("perf_files.txt", lineCount);
        long time3 = System.nanoTime() - start;
        System.out.println("Files.write: " + time3 / 1_000_000 + "ms");

        System.out.println("\nBufferedWriter is typically fastest for large files");


        // ========== ERROR HANDLING ==========

        System.out.println("\n\n--- 14. Error Handling ---\n");

        // Handle write to read-only location
        System.out.println("Proper error handling example:");
        writeWithErrorHandling(Path.of("test_write.txt"), "Sample content");


        // ========== WRITING BEST PRACTICES ==========

        System.out.println("\n\n--- 15. Best Practices Demo ---\n");

        demonstrateBestPractices();


        // ========== CLEANUP ==========

        System.out.println("\n--- Cleanup ---\n");
        cleanup();

        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHODS ==========

    private static void writeCSVFile() {
        try {
            Path path = Path.of("employees.csv");
            String csv = """
                ID,Name,Age,Department,Salary
                101,Alice Johnson,28,Engineering,75000
                102,Bob Smith,35,Marketing,65000
                103,Charlie Brown,42,Sales,70000
                104,Diana Prince,31,HR,60000
                105,Eve Wilson,29,Engineering,80000
                """;
            Files.writeString(path, csv);
            System.out.println("✓ CSV file created: employees.csv");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static void writeLogFile(String message) {
        try {
            Path path = Path.of("application.log");
            String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String logEntry = String.format("[%s] %s%n", timestamp, message);

            Files.writeString(path, logEntry,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }

    private static void writeStructuredData() {
        try {
            Path path = Path.of("user_data.txt");
            String data = """
                {
                  "user": {
                    "id": 12345,
                    "name": "John Doe",
                    "email": "john@example.com",
                    "active": true,
                    "roles": ["admin", "user"]
                  }
                }
                """;
            Files.writeString(path, data);
            System.out.println("✓ Structured data written: user_data.txt");
        } catch (IOException e) {
            System.err.println("Error writing structured data: " + e.getMessage());
        }
    }

    private static void writePropertiesFile() {
        try {
            Properties props = new Properties();
            props.setProperty("database.url", "jdbc:mysql://localhost:3306/mydb");
            props.setProperty("database.user", "admin");
            props.setProperty("database.password", "secret");
            props.setProperty("app.version", "1.0.0");

            try (OutputStream output = new FileOutputStream("app.properties")) {
                props.store(output, "Application Configuration");
            }
            System.out.println("✓ Properties file created: app.properties");
        } catch (IOException e) {
            System.err.println("Error writing properties: " + e.getMessage());
        }
    }

    private static void writeMultipleFiles() {
        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt"};
        int count = 0;

        for (String fileName : fileNames) {
            try {
                String content = "This is " + fileName + "\nGenerated automatically\n";
                Files.writeString(Path.of(fileName), content);
                count++;
            } catch (IOException e) {
                System.err.println("Error writing " + fileName + ": " + e.getMessage());
            }
        }
        System.out.println("✓ Created " + count + " files");
    }

    private static void writeWithFileWriter(String filename, int lines) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < lines; i++) {
                writer.write("Line " + i + "\n");
            }
        } catch (IOException e) {
            // Ignore for benchmark
        }
    }

    private static void writeWithBufferedWriter(String filename, int lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < lines; i++) {
                writer.write("Line " + i);
                writer.newLine();
            }
        } catch (IOException e) {
            // Ignore for benchmark
        }
    }

    private static void writeWithFilesAPI(String filename, int lines) {
        try {
            List<String> linesList = new ArrayList<>();
            for (int i = 0; i < lines; i++) {
                linesList.add("Line " + i);
            }
            Files.write(Path.of(filename), linesList);
        } catch (IOException e) {
            // Ignore for benchmark
        }
    }

    private static void writeWithErrorHandling(Path path, String content) {
        try {
            Files.writeString(path, content);
            System.out.println("✓ Successfully wrote file: " + path.getFileName());
        } catch (AccessDeniedException e) {
            System.err.println("✗ Access denied: " + path);
        } catch (FileSystemException e) {
            System.err.println("✗ File system error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("✗ I/O error: " + e.getMessage());
        }
    }

    private static void demonstrateBestPractices() {
        System.out.println("Best Practices for Writing Files:\n");

        // 1. Use try-with-resources
        System.out.println("1. Always use try-with-resources:");
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("best_practice1.txt"))) {
            writer.write("Resources automatically closed");
            System.out.println("   ✓ File written with auto-close");
        } catch (IOException e) {
            System.err.println("   Error: " + e.getMessage());
        }

        // 2. Specify charset
        System.out.println("\n2. Always specify charset:");
        try {
            Files.writeString(Path.of("best_practice2.txt"),
                "Content with explicit encoding",
                StandardCharsets.UTF_8);
            System.out.println("   ✓ Charset specified explicitly");
        } catch (IOException e) {
            System.err.println("   Error: " + e.getMessage());
        }

        // 3. Handle exceptions properly
        System.out.println("\n3. Handle exceptions properly:");
        System.out.println("   ✓ Catch specific exceptions");
        System.out.println("   ✓ Provide meaningful error messages");
        System.out.println("   ✓ Log errors appropriately");

        // 4. Use appropriate method
        System.out.println("\n4. Choose right method for file size:");
        System.out.println("   - Small files: Files.writeString()");
        System.out.println("   - Large files: BufferedWriter");
        System.out.println("   - Binary: DataOutputStream");

        // 5. Flush when needed
        System.out.println("\n5. Flush buffers when necessary:");
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("best_practice5.txt"))) {
            writer.write("Critical data");
            writer.flush(); // Ensure data is written
            System.out.println("   ✓ Buffer flushed");
        } catch (IOException e) {
            System.err.println("   Error: " + e.getMessage());
        }
    }

    private static void cleanup() {
        String[] filesToDelete = {
            "classic_output.txt", "buffered_output.txt", "formatted_output.txt",
            "modern_output.txt", "lines_output.txt", "bytes_output.txt",
            "append_demo.txt", "utf8_file.txt", "ascii_file.txt", "iso_file.txt",
            "binary_data.bin", "employees.csv", "application.log", "user_data.txt",
            "app.properties", "file1.txt", "file2.txt", "file3.txt",
            "final_file.txt", "buffered_detailed.txt", "perf_filewriter.txt",
            "perf_buffered.txt", "perf_files.txt", "test_write.txt",
            "best_practice1.txt", "best_practice2.txt", "best_practice5.txt"
        };

        int deleted = 0;
        for (String file : filesToDelete) {
            try {
                if (Files.deleteIfExists(Path.of(file))) {
                    deleted++;
                }
            } catch (IOException e) {
                // Ignore
            }
        }
        System.out.println("✓ Cleanup completed (" + deleted + " files deleted)");
    }
}

/*
 * WRITING FILES QUICK REFERENCE:
 *
 * METHOD COMPARISON:
 *
 * 1. FileWriter (Classic):
 *    try (FileWriter writer = new FileWriter("file.txt")) {
 *        writer.write("content");
 *    }
 *
 * 2. BufferedWriter (Efficient for large files):
 *    try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))) {
 *        writer.write("line 1");
 *        writer.newLine();
 *    }
 *
 * 3. PrintWriter (Formatted output):
 *    try (PrintWriter writer = new PrintWriter("file.txt")) {
 *        writer.println("line");
 *        writer.printf("Name: %s%n", name);
 *    }
 *
 * 4. Files.writeString() (Java 11+, Simple):
 *    Files.writeString(Path.of("file.txt"), "content", StandardCharsets.UTF_8);
 *
 * 5. Files.write() (Lines or bytes):
 *    List<String> lines = Arrays.asList("line1", "line2");
 *    Files.write(Path.of("file.txt"), lines);
 *
 * APPENDING:
 * // Classic
 * try (FileWriter writer = new FileWriter("file.txt", true)) {
 *     writer.write("append");
 * }
 *
 * // Modern
 * Files.writeString(path, "append", StandardOpenOption.APPEND);
 *
 * WHEN TO USE:
 * - Small text: Files.writeString()
 * - Large text: BufferedWriter
 * - Formatted: PrintWriter
 * - Binary: DataOutputStream
 * - Multiple lines: Files.write(path, lines)
 *
 * BEST PRACTICES:
 * ✓ Always use try-with-resources
 * ✓ Specify charset explicitly (UTF-8)
 * ✓ Handle exceptions properly
 * ✓ Use BufferedWriter for large files
 * ✓ Flush when writing critical data
 * ✓ Use atomic writes for important data
 * ✓ Consider StandardOpenOption (APPEND, CREATE, etc.)
 *
 * PERFORMANCE:
 * Fastest to Slowest for large files:
 * 1. BufferedWriter
 * 2. Files.write() with lines
 * 3. FileWriter
 * 4. PrintWriter (due to formatting overhead)
 *
 * COMMON OPTIONS:
 * StandardOpenOption.CREATE        - Create if doesn't exist
 * StandardOpenOption.APPEND        - Append to file
 * StandardOpenOption.TRUNCATE_EXISTING - Overwrite existing
 * StandardOpenOption.WRITE         - Open for writing
 *
 * HOW TO RUN:
 * javac WritingFiles.java
 * java WritingFiles
 */
