/**
 * ReadingFiles.java
 *
 * This program demonstrates various methods to read files in Java using both
 * classic I/O and modern NIO.2 APIs. Covers all major reading techniques with
 * the latest Java features.
 *
 * Key Concepts:
 * - FileReader and BufferedReader
 * - Scanner for file reading
 * - Files.readAllLines() and Files.readString()
 * - Files.lines() with Streams (Java 8+)
 * - Reading with different character encodings
 * - Performance considerations
 * - Error handling
 *
 * Java Features Used: Java 11+ (Files.readString, Path.of, var, try-with-resources)
 */

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class ReadingFiles {

    public static void main(String[] args) {

        System.out.println("========== READING FILES DEMONSTRATION ==========\n");

        // Create sample files for demonstration
        createSampleFiles();

        // ========== METHOD 1: BUFFEREDREADER (CLASSIC) ==========

        System.out.println("--- 1. BufferedReader (Classic Way) ---\n");

        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            int lineNumber = 1;
            System.out.println("Reading line by line:");
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber++ + ": " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        // ========== METHOD 2: FILES.READALLLINES() ==========

        System.out.println("\n\n--- 2. Files.readAllLines() (Java 7+) ---\n");

        try {
            Path path = Path.of("sample.txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            System.out.println("Read " + lines.size() + " lines:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        // ========== METHOD 3: FILES.READSTRING() ==========

        System.out.println("\n\n--- 3. Files.readString() (Java 11+) ---\n");

        try {
            Path path = Path.of("sample.txt");
            String content = Files.readString(path, StandardCharsets.UTF_8);

            System.out.println("Entire file content:");
            System.out.println(content);
            System.out.println("\nContent length: " + content.length() + " characters");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        // ========== METHOD 4: FILES.LINES() WITH STREAM ==========

        System.out.println("\n\n--- 4. Files.lines() with Stream (Java 8+) ---\n");

        try (Stream<String> lines = Files.lines(Path.of("sample.txt"))) {
            System.out.println("Processing lines with Stream:");
            lines.filter(line -> !line.isEmpty())
                 .map(String::toUpperCase)
                 .forEach(line -> System.out.println("  " + line));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        // ========== METHOD 5: SCANNER ==========

        System.out.println("\n\n--- 5. Scanner (Good for Parsing) ---\n");

        try (Scanner scanner = new Scanner(new File("numbers.txt"))) {
            System.out.println("Reading numbers from file:");
            int sum = 0;
            int count = 0;

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.print(number + " ");
                sum += number;
                count++;
            }

            System.out.println("\n\nTotal numbers: " + count);
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + (count > 0 ? (double)sum / count : 0));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }


        // ========== METHOD 6: FILEREADER ==========

        System.out.println("\n\n--- 6. FileReader (Character by Character) ---\n");

        try (FileReader reader = new FileReader("sample.txt")) {
            System.out.println("Reading first 50 characters:");
            int charCount = 0;
            int ch;

            while ((ch = reader.read()) != -1 && charCount < 50) {
                System.out.print((char) ch);
                charCount++;
            }
            System.out.println("\n... (truncated)");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        // ========== METHOD 7: FILES.READALLBYTES() ==========

        System.out.println("\n\n--- 7. Files.readAllBytes() (Binary Reading) ---\n");

        try {
            Path path = Path.of("sample.txt");
            byte[] bytes = Files.readAllBytes(path);

            System.out.println("File size: " + bytes.length + " bytes");
            System.out.println("Converting to String:");
            String content = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(content.substring(0, Math.min(100, content.length())) + "...");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        // ========== READING WITH DIFFERENT ENCODINGS ==========

        System.out.println("\n\n--- 8. Reading with Different Encodings ---\n");

        try {
            Path path = Path.of("sample.txt");

            // UTF-8 (default)
            String utf8Content = Files.readString(path, StandardCharsets.UTF_8);
            System.out.println("UTF-8 length: " + utf8Content.length());

            // ASCII
            String asciiContent = Files.readString(path, StandardCharsets.US_ASCII);
            System.out.println("ASCII length: " + asciiContent.length());

            // ISO-8859-1
            String isoContent = Files.readString(path, StandardCharsets.ISO_8859_1);
            System.out.println("ISO-8859-1 length: " + isoContent.length());

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        // ========== READING LARGE FILES EFFICIENTLY ==========

        System.out.println("\n\n--- 9. Reading Large Files Efficiently ---\n");

        System.out.println("Creating large file for demonstration...");
        createLargeFile("large_file.txt", 1000);

        // Bad approach - loads entire file in memory
        System.out.println("\nApproach 1: Read all lines (not recommended for large files)");
        try {
            long startTime = System.currentTimeMillis();
            List<String> allLines = Files.readAllLines(Path.of("large_file.txt"));
            long endTime = System.currentTimeMillis();
            System.out.println("Read " + allLines.size() + " lines in " + (endTime - startTime) + "ms");
            System.out.println("Memory usage: All lines in memory");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Good approach - streams lines
        System.out.println("\nApproach 2: Stream lines (recommended for large files)");
        try (Stream<String> lines = Files.lines(Path.of("large_file.txt"))) {
            long startTime = System.currentTimeMillis();
            long count = lines.count();
            long endTime = System.currentTimeMillis();
            System.out.println("Counted " + count + " lines in " + (endTime - startTime) + "ms");
            System.out.println("Memory usage: Lines processed one at a time");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 10. Practical Examples ---\n");

        // Example 1: Count words in file
        System.out.println("Example 1: Count Words");
        int wordCount = countWords(Path.of("sample.txt"));
        System.out.println("Total words: " + wordCount);

        // Example 2: Find lines containing keyword
        System.out.println("\nExample 2: Find Lines with Keyword");
        List<String> matchingLines = findLinesContaining(Path.of("sample.txt"), "Java");
        System.out.println("Lines containing 'Java': " + matchingLines.size());
        matchingLines.forEach(line -> System.out.println("  - " + line));

        // Example 3: Count character frequency
        System.out.println("\nExample 3: Character Frequency");
        Map<Character, Integer> charFreq = countCharacterFrequency(Path.of("sample.txt"));
        System.out.println("Top 5 most frequent characters:");
        charFreq.entrySet().stream()
            .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
            .limit(5)
            .forEach(entry -> System.out.println("  '" + entry.getKey() + "': " + entry.getValue()));

        // Example 4: Read CSV file
        System.out.println("\nExample 4: Read CSV File");
        createCSVFile();
        List<String[]> csvData = readCSV(Path.of("data.csv"));
        System.out.println("CSV rows read: " + csvData.size());
        csvData.forEach(row -> System.out.println("  " + String.join(", ", row)));

        // Example 5: Read file in reverse
        System.out.println("\nExample 5: Read File in Reverse Order");
        readFileReverse(Path.of("sample.txt"));


        // ========== READING PROPERTIES FILE ==========

        System.out.println("\n\n--- 11. Reading Properties File ---\n");

        createPropertiesFile();

        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            System.out.println("Properties loaded:");
            System.out.println("  app.name = " + prop.getProperty("app.name"));
            System.out.println("  app.version = " + prop.getProperty("app.version"));
            System.out.println("  app.port = " + prop.getProperty("app.port"));
            System.out.println("  app.debug = " + prop.getProperty("app.debug"));
        } catch (IOException e) {
            System.err.println("Error reading properties: " + e.getMessage());
        }


        // ========== ERROR HANDLING ==========

        System.out.println("\n\n--- 12. Error Handling ---\n");

        // Handle non-existent file
        System.out.println("Attempting to read non-existent file:");
        try {
            Files.readString(Path.of("nonexistent.txt"));
        } catch (NoSuchFileException e) {
            System.out.println("✓ Caught NoSuchFileException: File does not exist");
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // Handle access denied
        System.out.println("\nProper exception handling structure:");
        readFileWithErrorHandling(Path.of("sample.txt"));


        // ========== PERFORMANCE COMPARISON ==========

        System.out.println("\n\n--- 13. Performance Comparison ---\n");

        Path testFile = Path.of("large_file.txt");

        System.out.println("Reading " + testFile.getFileName() + " using different methods:\n");

        // Method 1: BufferedReader
        long start = System.nanoTime();
        readWithBufferedReader(testFile);
        long time1 = System.nanoTime() - start;
        System.out.println("BufferedReader: " + time1 / 1_000_000 + "ms");

        // Method 2: Files.readAllLines
        start = System.nanoTime();
        readWithReadAllLines(testFile);
        long time2 = System.nanoTime() - start;
        System.out.println("Files.readAllLines: " + time2 / 1_000_000 + "ms");

        // Method 3: Files.lines (Stream)
        start = System.nanoTime();
        readWithStream(testFile);
        long time3 = System.nanoTime() - start;
        System.out.println("Files.lines (Stream): " + time3 / 1_000_000 + "ms");


        // ========== CLEANUP ==========

        System.out.println("\n\n--- Cleanup ---\n");
        cleanup();

        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHODS ==========

    private static void createSampleFiles() {
        try {
            // Create sample text file
            String content = """
                Java is a high-level, class-based, object-oriented programming language.
                It is designed to have as few implementation dependencies as possible.
                Java applications are typically compiled to bytecode that can run on any JVM.
                Write once, run anywhere (WORA) is Java's philosophy.
                Java is fast, secure, and reliable.
                """;
            Files.writeString(Path.of("sample.txt"), content);

            // Create numbers file
            Files.writeString(Path.of("numbers.txt"), "10 20 30 40 50 60 70 80 90 100");

        } catch (IOException e) {
            System.err.println("Error creating sample files: " + e.getMessage());
        }
    }

    private static void createLargeFile(String filename, int lines) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filename))) {
            for (int i = 1; i <= lines; i++) {
                writer.write("This is line number " + i + " of the large file.\n");
            }
        } catch (IOException e) {
            System.err.println("Error creating large file: " + e.getMessage());
        }
    }

    private static void createCSVFile() {
        try {
            String csv = """
                Name,Age,City,Occupation
                Alice,25,New York,Engineer
                Bob,30,San Francisco,Designer
                Charlie,28,Seattle,Developer
                Diana,35,Boston,Manager
                """;
            Files.writeString(Path.of("data.csv"), csv);
        } catch (IOException e) {
            System.err.println("Error creating CSV file: " + e.getMessage());
        }
    }

    private static void createPropertiesFile() {
        try {
            String props = """
                app.name=MyJavaApp
                app.version=1.0.0
                app.port=8080
                app.debug=true
                """;
            Files.writeString(Path.of("config.properties"), props);
        } catch (IOException e) {
            System.err.println("Error creating properties file: " + e.getMessage());
        }
    }

    private static int countWords(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return (int) lines
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(word -> !word.isEmpty())
                .count();
        } catch (IOException e) {
            System.err.println("Error counting words: " + e.getMessage());
            return 0;
        }
    }

    private static List<String> findLinesContaining(Path path, String keyword) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                .filter(line -> line.contains(keyword))
                .toList();
        } catch (IOException e) {
            System.err.println("Error finding lines: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static Map<Character, Integer> countCharacterFrequency(Path path) {
        Map<Character, Integer> frequency = new HashMap<>();
        try {
            String content = Files.readString(path);
            for (char c : content.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    frequency.merge(c, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            System.err.println("Error counting characters: " + e.getMessage());
        }
        return frequency;
    }

    private static List<String[]> readCSV(Path path) {
        List<String[]> data = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            lines.skip(1) // Skip header
                 .map(line -> line.split(","))
                 .forEach(data::add);
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
        return data;
    }

    private static void readFileReverse(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println("First 3 lines in reverse:");
            for (int i = Math.min(2, lines.size() - 1); i >= 0; i--) {
                System.out.println("  " + lines.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error reading in reverse: " + e.getMessage());
        }
    }

    private static void readFileWithErrorHandling(Path path) {
        try {
            String content = Files.readString(path);
            System.out.println("✓ Successfully read file (" + content.length() + " characters)");
        } catch (NoSuchFileException e) {
            System.err.println("✗ File not found: " + path);
        } catch (AccessDeniedException e) {
            System.err.println("✗ Access denied: " + path);
        } catch (IOException e) {
            System.err.println("✗ I/O error: " + e.getMessage());
        }
    }

    private static void readWithBufferedReader(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.readLine() != null) {
                // Just read, don't process
            }
        } catch (IOException e) {
            // Ignore for benchmark
        }
    }

    private static void readWithReadAllLines(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            // Just read, don't process
        } catch (IOException e) {
            // Ignore for benchmark
        }
    }

    private static void readWithStream(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            lines.count(); // Process all lines
        } catch (IOException e) {
            // Ignore for benchmark
        }
    }

    private static void cleanup() {
        try {
            Files.deleteIfExists(Path.of("sample.txt"));
            Files.deleteIfExists(Path.of("numbers.txt"));
            Files.deleteIfExists(Path.of("large_file.txt"));
            Files.deleteIfExists(Path.of("data.csv"));
            Files.deleteIfExists(Path.of("config.properties"));
            System.out.println("✓ Cleanup completed");
        } catch (IOException e) {
            System.err.println("Cleanup error: " + e.getMessage());
        }
    }
}

/*
 * READING FILES QUICK REFERENCE:
 *
 * METHOD COMPARISON:
 *
 * 1. BufferedReader (Classic, Line-by-Line):
 *    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
 *        String line;
 *        while ((line = reader.readLine()) != null) {
 *            // Process line
 *        }
 *    }
 *
 * 2. Files.readAllLines() (Java 7+, Small to Medium Files):
 *    List<String> lines = Files.readAllLines(Path.of("file.txt"));
 *
 * 3. Files.readString() (Java 11+, Small Files):
 *    String content = Files.readString(Path.of("file.txt"));
 *
 * 4. Files.lines() (Java 8+, Large Files with Streams):
 *    try (Stream<String> lines = Files.lines(Path.of("file.txt"))) {
 *        lines.forEach(line -> processLine(line));
 *    }
 *
 * 5. Scanner (Parsing):
 *    try (Scanner scanner = new Scanner(new File("file.txt"))) {
 *        while (scanner.hasNextLine()) {
 *            String line = scanner.nextLine();
 *        }
 *    }
 *
 * WHEN TO USE:
 * - Small files (< 10MB): Files.readString() or Files.readAllLines()
 * - Large files: BufferedReader or Files.lines() with Stream
 * - Binary files: Files.readAllBytes()
 * - Parsing: Scanner
 * - CSV/structured data: BufferedReader + split() or CSV library
 *
 * BEST PRACTICES:
 * ✓ Always use try-with-resources
 * ✓ Specify charset explicitly (UTF-8)
 * ✓ Handle specific exceptions (NoSuchFileException, etc.)
 * ✓ Use Files.lines() for large files
 * ✓ Close streams properly
 * ✓ Consider memory usage
 *
 * PERFORMANCE:
 * Fastest to Slowest for large files:
 * 1. BufferedReader
 * 2. Files.lines() with Stream
 * 3. Files.readAllLines()
 * 4. Scanner
 *
 * HOW TO RUN:
 * javac ReadingFiles.java
 * java ReadingFiles
 */
