/**
 * NIOPathsFiles.java
 *
 * This program demonstrates the modern NIO.2 API (java.nio.file) introduced in Java 7
 * and enhanced in later versions. NIO.2 provides a more powerful and flexible API
 * for file operations compared to the legacy java.io.File class.
 *
 * Key Concepts:
 * - Path interface and Path.of() (Java 11+)
 * - Files utility class methods
 * - StandardCopyOption and StandardOpenOption
 * - File attributes and permissions
 * - Symbolic links
 * - File system operations
 * - Advanced file operations
 *
 * Java Features Used: Java 11+ (Path.of, var, text blocks, enhanced switch)
 */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class NIOPathsFiles {

    public static void main(String[] args) {

        System.out.println("========== NIO.2 (PATH & FILES) DEMONSTRATION ==========\n");

        // ========== PATH CREATION ==========

        System.out.println("--- 1. Creating Paths ---\n");

        // Modern way (Java 11+)
        Path path1 = Path.of("documents", "file.txt");
        Path path2 = Path.of("data", "users", "profile.json");
        Path path3 = Path.of("C:", "Program Files", "Java"); // Windows style

        System.out.println("Path 1: " + path1);
        System.out.println("Path 2: " + path2);
        System.out.println("Path 3: " + path3);

        // Alternative way (older, still valid)
        Path path4 = Paths.get("documents", "report.pdf");
        System.out.println("Path 4 (using Paths.get): " + path4);

        // From URI
        Path path5 = Path.of(System.getProperty("user.home"), "Desktop");
        System.out.println("Home Desktop path: " + path5);


        // ========== PATH OPERATIONS ==========

        System.out.println("\n\n--- 2. Path Operations ---\n");

        Path complexPath = Path.of("users", "john", "documents", "reports", "2024", "report.pdf");

        System.out.println("Complex path: " + complexPath);
        System.out.println("  File name: " + complexPath.getFileName());
        System.out.println("  Parent: " + complexPath.getParent());
        System.out.println("  Root: " + complexPath.getRoot());
        System.out.println("  Name count: " + complexPath.getNameCount());
        System.out.println("  First element: " + complexPath.getName(0));
        System.out.println("  Last element: " + complexPath.getName(complexPath.getNameCount() - 1));

        // Path manipulation
        Path base = Path.of("projects");
        Path relative = Path.of("java", "src", "Main.java");
        Path resolved = base.resolve(relative);
        System.out.println("\nResolved path: " + resolved);

        // Normalize path
        Path messyPath = Path.of("users", "..", "users", "john", ".", "documents");
        Path cleanPath = messyPath.normalize();
        System.out.println("\nMessy path: " + messyPath);
        System.out.println("Normalized: " + cleanPath);

        // Relativize
        Path p1 = Path.of("users", "john", "documents");
        Path p2 = Path.of("users", "john", "downloads");
        Path relative2 = p1.relativize(p2);
        System.out.println("\nRelative path from " + p1 + " to " + p2 + ": " + relative2);


        // ========== FILES CLASS OPERATIONS ==========

        System.out.println("\n\n--- 3. Files Class Operations ---\n");

        try {
            // Create directory
            Path dir = Path.of("nio_demo");
            Files.createDirectories(dir);
            System.out.println("✓ Created directory: " + dir);

            // Create file
            Path file1 = dir.resolve("test1.txt");
            Files.createFile(file1);
            System.out.println("✓ Created file: " + file1.getFileName());

            // Write content
            String content = "Hello from NIO.2!\nModern file I/O API\nJava 7+";
            Files.writeString(file1, content);
            System.out.println("✓ Written content to file");

            // Read content
            String readContent = Files.readString(file1);
            System.out.println("\nFile content:");
            System.out.println(readContent);

            // Check existence
            System.out.println("\nFile exists: " + Files.exists(file1));
            System.out.println("Is regular file: " + Files.isRegularFile(file1));
            System.out.println("Is directory: " + Files.isDirectory(file1));
            System.out.println("Is readable: " + Files.isReadable(file1));
            System.out.println("Is writable: " + Files.isWritable(file1));
            System.out.println("Is executable: " + Files.isExecutable(file1));

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


        // ========== COPY, MOVE, DELETE ==========

        System.out.println("\n\n--- 4. Copy, Move, Delete Operations ---\n");

        try {
            Path source = Path.of("nio_demo", "test1.txt");
            Path copyTarget = Path.of("nio_demo", "test1_copy.txt");
            Path moveTarget = Path.of("nio_demo", "test1_moved.txt");

            // Copy file
            Files.copy(source, copyTarget, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("✓ Copied " + source.getFileName() + " to " + copyTarget.getFileName());

            // Move file (rename)
            Files.move(copyTarget, moveTarget, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("✓ Moved " + copyTarget.getFileName() + " to " + moveTarget.getFileName());

            // Delete file
            Files.delete(moveTarget);
            System.out.println("✓ Deleted " + moveTarget.getFileName());

            // Delete if exists (no exception if doesn't exist)
            boolean deleted = Files.deleteIfExists(Path.of("nonexistent.txt"));
            System.out.println("Delete if exists result: " + deleted);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


        // ========== FILE ATTRIBUTES ==========

        System.out.println("\n\n--- 5. File Attributes ---\n");

        try {
            Path file = Path.of("nio_demo", "test1.txt");

            if (Files.exists(file)) {
                // Basic attributes
                System.out.println("File: " + file.getFileName());
                System.out.println("Size: " + Files.size(file) + " bytes");
                System.out.println("Is hidden: " + Files.isHidden(file));
                System.out.println("Is symbolic link: " + Files.isSymbolicLink(file));

                // Time attributes
                FileTime creationTime = Files.getAttribute(file, "creationTime", FileTime.class);
                FileTime lastModified = Files.getLastModifiedTime(file);
                FileTime lastAccess = (FileTime) Files.getAttribute(file, "lastAccessTime");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.systemDefault());

                System.out.println("\nTime attributes:");
                System.out.println("Created: " + formatter.format(creationTime.toInstant()));
                System.out.println("Modified: " + formatter.format(lastModified.toInstant()));
                System.out.println("Accessed: " + formatter.format(lastAccess.toInstant()));

                // POSIX attributes (Unix/Linux/Mac)
                try {
                    Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(file);
                    System.out.println("\nPOSIX Permissions: " + PosixFilePermissions.toString(permissions));
                } catch (UnsupportedOperationException e) {
                    System.out.println("\nPOSIX permissions not supported on this system");
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading attributes: " + e.getMessage());
        }


        // ========== LISTING DIRECTORY CONTENTS ==========

        System.out.println("\n\n--- 6. Listing Directory Contents ---\n");

        try {
            Path dir = Path.of("nio_demo");

            System.out.println("Contents of " + dir + ":");

            // Method 1: DirectoryStream
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path entry : stream) {
                    String type = Files.isDirectory(entry) ? "[DIR]" : "[FILE]";
                    System.out.println("  " + type + " " + entry.getFileName());
                }
            }

            // Method 2: Files.list (Stream)
            System.out.println("\nUsing Files.list() with Stream:");
            try (Stream<Path> paths = Files.list(dir)) {
                paths.forEach(p -> {
                    try {
                        String type = Files.isDirectory(p) ? "[DIR]" : "[FILE]";
                        long size = Files.isDirectory(p) ? 0 : Files.size(p);
                        System.out.println("  " + type + " " + p.getFileName() + " (" + size + " bytes)");
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                });
            }

        } catch (IOException e) {
            System.err.println("Error listing directory: " + e.getMessage());
        }


        // ========== WALKING FILE TREE ==========

        System.out.println("\n\n--- 7. Walking File Tree ---\n");

        try {
            // Create nested directory structure
            Path root = Path.of("nio_demo", "nested");
            Files.createDirectories(root.resolve("level1").resolve("level2"));
            Files.createFile(root.resolve("file1.txt"));
            Files.createFile(root.resolve("level1").resolve("file2.txt"));
            Files.createFile(root.resolve("level1").resolve("level2").resolve("file3.txt"));

            System.out.println("Walking file tree from " + root + ":");

            // Walk with max depth
            try (Stream<Path> paths = Files.walk(root, 3)) {
                paths.forEach(p -> {
                    int depth = p.getNameCount() - root.getNameCount();
                    String indent = "  ".repeat(depth);
                    String name = p.getFileName().toString();
                    try {
                        String type = Files.isDirectory(p) ? "[DIR]" : "[FILE]";
                        System.out.println(indent + type + " " + name);
                    } catch (Exception e) {
                        System.out.println(indent + name);
                    }
                });
            }

        } catch (IOException e) {
            System.err.println("Error walking tree: " + e.getMessage());
        }


        // ========== FINDING FILES ==========

        System.out.println("\n\n--- 8. Finding Files ---\n");

        try {
            Path searchRoot = Path.of("nio_demo");

            System.out.println("Finding .txt files in " + searchRoot + ":");

            // Find files matching pattern
            try (Stream<Path> paths = Files.find(searchRoot, Integer.MAX_VALUE,
                    (path, attrs) -> path.toString().endsWith(".txt"))) {
                paths.forEach(p -> System.out.println("  Found: " + p));
            }

        } catch (IOException e) {
            System.err.println("Error finding files: " + e.getMessage());
        }


        // ========== TEMPORARY FILES ==========

        System.out.println("\n\n--- 9. Temporary Files and Directories ---\n");

        try {
            // Create temporary file
            Path tempFile = Files.createTempFile("myapp_", ".tmp");
            System.out.println("✓ Created temp file: " + tempFile);
            Files.writeString(tempFile, "Temporary data");
            System.out.println("  Content written to temp file");

            // Create temporary directory
            Path tempDir = Files.createTempDirectory("myapp_dir_");
            System.out.println("✓ Created temp directory: " + tempDir);

            // Cleanup temp files
            Files.deleteIfExists(tempFile);
            Files.deleteIfExists(tempDir);
            System.out.println("✓ Temp files cleaned up");

        } catch (IOException e) {
            System.err.println("Error with temp files: " + e.getMessage());
        }


        // ========== FILE STORE INFORMATION ==========

        System.out.println("\n\n--- 10. File Store Information ---\n");

        try {
            Path path = Path.of(".");
            FileStore store = Files.getFileStore(path);

            System.out.println("File store information:");
            System.out.println("  Name: " + store.name());
            System.out.println("  Type: " + store.type());
            System.out.println("  Total space: " + formatSize(store.getTotalSpace()));
            System.out.println("  Usable space: " + formatSize(store.getUsableSpace()));
            System.out.println("  Unallocated space: " + formatSize(store.getUnallocatedSpace()));
            System.out.println("  Read-only: " + store.isReadOnly());

        } catch (IOException e) {
            System.err.println("Error getting file store info: " + e.getMessage());
        }


        // ========== COMPARING FILES ==========

        System.out.println("\n\n--- 11. Comparing Files ---\n");

        try {
            Path file1 = Path.of("nio_demo", "test1.txt");
            Path file2 = Path.of("nio_demo", "test1.txt");
            Path file3 = Path.of("nio_demo", "nested", "file1.txt");

            System.out.println("Comparing files:");
            System.out.println("file1 == file2 (same path): " + file1.equals(file2));
            System.out.println("file1 == file3 (different path): " + file1.equals(file3));

            // Compare file content
            if (Files.exists(file1) && Files.exists(file3)) {
                long mismatch = Files.mismatch(file1, file3);
                if (mismatch == -1) {
                    System.out.println("Files have identical content");
                } else {
                    System.out.println("Files differ at byte position: " + mismatch);
                }
            }

        } catch (IOException e) {
            System.err.println("Error comparing files: " + e.getMessage());
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 12. Practical Examples ---\n");

        // Example 1: Count files in directory
        System.out.println("Example 1: Count Files");
        int fileCount = countFilesInDirectory(Path.of("nio_demo"));
        System.out.println("Total files in nio_demo: " + fileCount);

        // Example 2: Find files by extension
        System.out.println("\nExample 2: Find Files by Extension");
        List<Path> txtFiles = findFilesByExtension(Path.of("nio_demo"), ".txt");
        System.out.println("Found " + txtFiles.size() + " .txt files");

        // Example 3: Calculate directory size
        System.out.println("\nExample 3: Calculate Directory Size");
        long dirSize = calculateDirectorySize(Path.of("nio_demo"));
        System.out.println("Directory size: " + formatSize(dirSize));

        // Example 4: Copy directory
        System.out.println("\nExample 4: Copy Directory");
        copyDirectory(Path.of("nio_demo"), Path.of("nio_demo_backup"));


        // ========== NIO.2 ADVANTAGES ==========

        System.out.println("\n\n--- 13. NIO.2 Advantages ---\n");

        System.out.println("Advantages of NIO.2 over classic java.io.File:");
        System.out.println("✓ Better exception handling (specific exceptions)");
        System.out.println("✓ More features (copy, move, attributes, etc.)");
        System.out.println("✓ Symbolic link support");
        System.out.println("✓ Efficient directory tree traversal");
        System.out.println("✓ File system monitoring (WatchService)");
        System.out.println("✓ Atomic operations");
        System.out.println("✓ Better performance");
        System.out.println("✓ Platform-independent path handling");


        // ========== CLEANUP ==========

        System.out.println("\n\n--- Cleanup ---\n");
        cleanup();

        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHODS ==========

    private static String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp - 1) + "";
        return String.format("%.2f %sB", bytes / Math.pow(1024, exp), pre);
    }

    private static int countFilesInDirectory(Path directory) {
        try (Stream<Path> paths = Files.walk(directory)) {
            return (int) paths.filter(Files::isRegularFile).count();
        } catch (IOException e) {
            System.err.println("Error counting files: " + e.getMessage());
            return 0;
        }
    }

    private static List<Path> findFilesByExtension(Path directory, String extension) {
        try (Stream<Path> paths = Files.walk(directory)) {
            return paths
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(extension))
                .toList();
        } catch (IOException e) {
            System.err.println("Error finding files: " + e.getMessage());
            return List.of();
        }
    }

    private static long calculateDirectorySize(Path directory) {
        try (Stream<Path> paths = Files.walk(directory)) {
            return paths
                .filter(Files::isRegularFile)
                .mapToLong(p -> {
                    try {
                        return Files.size(p);
                    } catch (IOException e) {
                        return 0;
                    }
                })
                .sum();
        } catch (IOException e) {
            System.err.println("Error calculating size: " + e.getMessage());
            return 0;
        }
    }

    private static void copyDirectory(Path source, Path target) {
        try {
            if (Files.exists(target)) {
                deleteDirectory(target);
            }

            Files.walk(source).forEach(sourcePath -> {
                try {
                    Path targetPath = target.resolve(source.relativize(sourcePath));
                    if (Files.isDirectory(sourcePath)) {
                        Files.createDirectories(targetPath);
                    } else {
                        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    System.err.println("Error copying: " + e.getMessage());
                }
            });
            System.out.println("✓ Directory copied successfully");
        } catch (IOException e) {
            System.err.println("Error copying directory: " + e.getMessage());
        }
    }

    private static void deleteDirectory(Path directory) {
        try (Stream<Path> paths = Files.walk(directory)) {
            paths.sorted((p1, p2) -> -p1.compareTo(p2)) // Delete files before directories
                 .forEach(p -> {
                     try {
                         Files.delete(p);
                     } catch (IOException e) {
                         System.err.println("Error deleting: " + e.getMessage());
                     }
                 });
        } catch (IOException e) {
            System.err.println("Error deleting directory: " + e.getMessage());
        }
    }

    private static void cleanup() {
        try {
            deleteDirectory(Path.of("nio_demo_backup"));
            deleteDirectory(Path.of("nio_demo"));
            System.out.println("✓ Cleanup completed");
        } catch (Exception e) {
            System.err.println("Cleanup error: " + e.getMessage());
        }
    }
}

/*
 * NIO.2 (PATH & FILES) QUICK REFERENCE:
 *
 * PATH CREATION:
 * Path path = Path.of("folder", "file.txt");           // Java 11+
 * Path path = Paths.get("folder", "file.txt");         // Java 7+
 *
 * PATH OPERATIONS:
 * path.getFileName()        - Get file name
 * path.getParent()          - Get parent directory
 * path.resolve(other)       - Join paths
 * path.normalize()          - Remove redundant elements
 * path.toAbsolutePath()     - Convert to absolute
 * path.relativize(other)    - Get relative path
 *
 * FILES OPERATIONS:
 * Files.exists(path)                - Check existence
 * Files.createFile(path)            - Create file
 * Files.createDirectories(path)     - Create directories
 * Files.delete(path)                - Delete file/directory
 * Files.deleteIfExists(path)        - Delete if exists
 * Files.copy(source, target)        - Copy file
 * Files.move(source, target)        - Move/rename file
 * Files.size(path)                  - Get file size
 * Files.isDirectory(path)           - Check if directory
 * Files.isRegularFile(path)         - Check if regular file
 *
 * READING/WRITING:
 * Files.readString(path)            - Read entire file (Java 11+)
 * Files.writeString(path, content)  - Write string (Java 11+)
 * Files.readAllLines(path)          - Read all lines
 * Files.write(path, lines)          - Write lines
 * Files.lines(path)                 - Stream lines
 *
 * DIRECTORY OPERATIONS:
 * Files.list(path)                  - List direct children
 * Files.walk(path)                  - Walk file tree
 * Files.walk(path, depth)           - Walk with max depth
 * Files.find(path, depth, matcher)  - Find matching files
 *
 * FILE ATTRIBUTES:
 * Files.getLastModifiedTime(path)   - Last modified time
 * Files.size(path)                  - File size
 * Files.isReadable(path)            - Check readable
 * Files.isWritable(path)            - Check writable
 * Files.isExecutable(path)          - Check executable
 * Files.isHidden(path)              - Check hidden
 *
 * COPY OPTIONS:
 * StandardCopyOption.REPLACE_EXISTING    - Replace if exists
 * StandardCopyOption.COPY_ATTRIBUTES     - Copy attributes
 * StandardCopyOption.ATOMIC_MOVE         - Atomic move
 *
 * OPEN OPTIONS:
 * StandardOpenOption.CREATE         - Create if doesn't exist
 * StandardOpenOption.APPEND         - Append to file
 * StandardOpenOption.TRUNCATE_EXISTING - Truncate existing
 * StandardOpenOption.WRITE          - Open for writing
 * StandardOpenOption.READ           - Open for reading
 *
 * BEST PRACTICES:
 * ✓ Use Path.of() for path creation (Java 11+)
 * ✓ Always close streams (use try-with-resources)
 * ✓ Handle specific exceptions
 * ✓ Use Files methods instead of File class
 * ✓ Check existence before operations
 * ✓ Use Files.walk() for tree traversal
 * ✓ Specify charset when reading/writing text
 *
 * ADVANTAGES OVER java.io.File:
 * ✓ Better exception handling
 * ✓ More operations available
 * ✓ Symbolic link support
 * ✓ File attributes access
 * ✓ Directory watching
 * ✓ Better performance
 * ✓ More intuitive API
 *
 * HOW TO RUN:
 * javac NIOPathsFiles.java
 * java NIOPathsFiles
 */
