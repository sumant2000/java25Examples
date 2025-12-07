/**
 * FileBasics.java
 *
 * This program demonstrates basic file operations using both classic File class
 * and modern NIO.2 (Path/Files) API. It covers file creation, checking existence,
 * properties, and deletion using the latest Java features.
 *
 * Key Concepts:
 * - File class (classic java.io)
 * - Path and Files (modern java.nio.file)
 * - File properties and metadata
 * - File existence and validation
 * - Creating and deleting files
 * - Working with file paths
 *
 * Java Features Used: Java 11+ (Path.of, Files API)
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileBasics {

    public static void main(String[] args) {

        System.out.println("========== FILE BASICS DEMONSTRATION ==========\n");

        // ========== CLASSIC FILE CLASS ==========

        System.out.println("--- 1. Classic File Class (java.io) ---\n");

        // Creating File objects (doesn't create actual file)
        File file1 = new File("example.txt");
        File file2 = new File("data", "records.txt");
        File file3 = new File("C:\\temp\\file.txt"); // Absolute path (Windows)

        System.out.println("File objects created:");
        System.out.println("file1: " + file1.getPath());
        System.out.println("file2: " + file2.getPath());
        System.out.println("file3: " + file3.getPath());

        // File properties
        System.out.println("\nFile1 properties:");
        System.out.println("Exists: " + file1.exists());
        System.out.println("Is file: " + file1.isFile());
        System.out.println("Is directory: " + file1.isDirectory());
        System.out.println("Name: " + file1.getName());
        System.out.println("Parent: " + file1.getParent());
        System.out.println("Absolute path: " + file1.getAbsolutePath());


        // ========== MODERN PATH AND FILES (NIO.2) ==========

        System.out.println("\n\n--- 2. Modern Path and Files (java.nio.file) ---\n");

        // Creating Path objects (Java 11+)
        Path path1 = Path.of("example.txt");
        Path path2 = Path.of("data", "records.txt");
        Path path3 = Path.of("users", "documents", "report.pdf");

        System.out.println("Path objects created:");
        System.out.println("path1: " + path1);
        System.out.println("path2: " + path2);
        System.out.println("path3: " + path3);

        System.out.println("\nPath components:");
        System.out.println("File name: " + path3.getFileName());
        System.out.println("Parent: " + path3.getParent());
        System.out.println("Root: " + path3.getRoot());
        System.out.println("Name count: " + path3.getNameCount());


        // ========== CREATING FILES ==========

        System.out.println("\n\n--- 3. Creating Files ---\n");

        try {
            // Create a file using classic File
            File classicFile = new File("classic_file.txt");
            if (classicFile.createNewFile()) {
                System.out.println("✓ Created file (classic): " + classicFile.getName());
            } else {
                System.out.println("File already exists (classic)");
            }

            // Create a file using modern Files API
            Path modernPath = Path.of("modern_file.txt");
            if (!Files.exists(modernPath)) {
                Files.createFile(modernPath);
                System.out.println("✓ Created file (modern): " + modernPath.getFileName());
            } else {
                System.out.println("File already exists (modern)");
            }

            // Create file with content
            Path contentFile = Path.of("file_with_content.txt");
            Files.writeString(contentFile, "Hello, Java File I/O!\nThis is a test file.");
            System.out.println("✓ Created file with content: " + contentFile.getFileName());

        } catch (IOException e) {
            System.err.println("Error creating files: " + e.getMessage());
        }


        // ========== CHECKING FILE EXISTENCE ==========

        System.out.println("\n\n--- 4. Checking File Existence ---\n");

        // Classic way
        File checkFile = new File("modern_file.txt");
        System.out.println("File exists (File class): " + checkFile.exists());

        // Modern way
        Path checkPath = Path.of("modern_file.txt");
        System.out.println("File exists (Files class): " + Files.exists(checkPath));
        System.out.println("File not exists: " + Files.notExists(Path.of("nonexistent.txt")));
        System.out.println("Is regular file: " + Files.isRegularFile(checkPath));
        System.out.println("Is directory: " + Files.isDirectory(checkPath));
        System.out.println("Is readable: " + Files.isReadable(checkPath));
        System.out.println("Is writable: " + Files.isWritable(checkPath));
        System.out.println("Is executable: " + Files.isExecutable(checkPath));


        // ========== FILE PROPERTIES AND METADATA ==========

        System.out.println("\n\n--- 5. File Properties and Metadata ---\n");

        try {
            Path propFile = Path.of("file_with_content.txt");

            if (Files.exists(propFile)) {
                // File size
                long size = Files.size(propFile);
                System.out.println("File size: " + size + " bytes");

                // Last modified time
                FileTime lastModified = Files.getLastModifiedTime(propFile);
                Instant instant = lastModified.toInstant();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.systemDefault());
                System.out.println("Last modified: " + formatter.format(instant));

                // Content type
                String contentType = Files.probeContentType(propFile);
                System.out.println("Content type: " + contentType);

                // Is hidden
                System.out.println("Is hidden: " + Files.isHidden(propFile));

                // Is symbolic link
                System.out.println("Is symbolic link: " + Files.isSymbolicLink(propFile));
            }

        } catch (IOException e) {
            System.err.println("Error reading properties: " + e.getMessage());
        }


        // ========== WORKING WITH PATHS ==========

        System.out.println("\n\n--- 6. Working with Paths ---\n");

        Path basePath = Path.of("documents");
        Path fileName = Path.of("report.txt");

        // Resolve (join paths)
        Path fullPath = basePath.resolve(fileName);
        System.out.println("Resolved path: " + fullPath);

        // Resolve sibling
        Path siblingPath = fullPath.resolveSibling("summary.txt");
        System.out.println("Sibling path: " + siblingPath);

        // Normalize path
        Path messyPath = Path.of("documents/../documents/./report.txt");
        Path cleanPath = messyPath.normalize();
        System.out.println("Original path: " + messyPath);
        System.out.println("Normalized path: " + cleanPath);

        // Get absolute path
        Path relativePath = Path.of("example.txt");
        Path absolutePath = relativePath.toAbsolutePath();
        System.out.println("\nRelative path: " + relativePath);
        System.out.println("Absolute path: " + absolutePath);

        // Path comparison
        Path path4 = Path.of("documents", "file.txt");
        Path path5 = Path.of("documents", "file.txt");
        System.out.println("\nPaths equal: " + path4.equals(path5));
        System.out.println("Starts with 'documents': " + path4.startsWith("documents"));
        System.out.println("Ends with 'file.txt': " + path4.endsWith("file.txt"));


        // ========== FILE NAME OPERATIONS ==========

        System.out.println("\n\n--- 7. File Name Operations ---\n");

        Path filePath = Path.of("documents", "report.pdf");

        System.out.println("Full path: " + filePath);
        System.out.println("File name: " + filePath.getFileName());
        System.out.println("Extension: " + getFileExtension(filePath));
        System.out.println("Name without extension: " + getFileNameWithoutExtension(filePath));

        // Change extension
        Path newPath = changeExtension(filePath, ".docx");
        System.out.println("Changed extension: " + newPath);


        // ========== FILE OPERATIONS ==========

        System.out.println("\n\n--- 8. File Operations ---\n");

        try {
            // Copy file
            Path source = Path.of("modern_file.txt");
            Path destination = Path.of("copied_file.txt");

            if (Files.exists(source)) {
                Files.copy(source, destination,
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                System.out.println("✓ File copied from " + source + " to " + destination);
            }

            // Move/Rename file
            Path oldName = Path.of("copied_file.txt");
            Path newName = Path.of("renamed_file.txt");

            if (Files.exists(oldName)) {
                Files.move(oldName, newName,
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                System.out.println("✓ File renamed from " + oldName + " to " + newName);
            }

        } catch (IOException e) {
            System.err.println("Error in file operations: " + e.getMessage());
        }


        // ========== DELETING FILES ==========

        System.out.println("\n\n--- 9. Deleting Files ---\n");

        try {
            // Delete file (throws exception if doesn't exist)
            Path fileToDelete1 = Path.of("renamed_file.txt");
            if (Files.exists(fileToDelete1)) {
                Files.delete(fileToDelete1);
                System.out.println("✓ Deleted: " + fileToDelete1);
            }

            // Delete if exists (no exception if doesn't exist)
            Path fileToDelete2 = Path.of("classic_file.txt");
            boolean deleted = Files.deleteIfExists(fileToDelete2);
            System.out.println("✓ Delete if exists result: " + deleted);

            // Classic way
            File classicDelete = new File("modern_file.txt");
            if (classicDelete.delete()) {
                System.out.println("✓ Deleted (classic): " + classicDelete.getName());
            }

        } catch (IOException e) {
            System.err.println("Error deleting files: " + e.getMessage());
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 10. Practical Examples ---\n");

        // Example 1: Check if file is accessible
        Path testFile = Path.of("file_with_content.txt");
        System.out.println("Example 1: File Accessibility Check");
        if (isFileAccessible(testFile)) {
            System.out.println("✓ File is accessible: " + testFile);
        } else {
            System.out.println("✗ File is not accessible: " + testFile);
        }

        // Example 2: Get file info summary
        System.out.println("\nExample 2: File Info Summary");
        printFileInfo(testFile);

        // Example 3: Safe file deletion
        System.out.println("\nExample 3: Safe File Deletion");
        Path tempFile = Path.of("temp_test.txt");
        try {
            Files.writeString(tempFile, "Temporary content");
            System.out.println("Created temporary file");
            safeDeleteFile(tempFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


        // ========== CLEANUP ==========

        System.out.println("\n\n--- Cleanup ---\n");

        try {
            // Clean up created files
            Files.deleteIfExists(Path.of("file_with_content.txt"));
            System.out.println("✓ Cleanup completed");
        } catch (IOException e) {
            System.err.println("Cleanup error: " + e.getMessage());
        }


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHODS ==========

    /**
     * Get file extension from path
     */
    private static String getFileExtension(Path path) {
        String fileName = path.getFileName().toString();
        int lastDot = fileName.lastIndexOf('.');
        return (lastDot > 0) ? fileName.substring(lastDot) : "";
    }

    /**
     * Get file name without extension
     */
    private static String getFileNameWithoutExtension(Path path) {
        String fileName = path.getFileName().toString();
        int lastDot = fileName.lastIndexOf('.');
        return (lastDot > 0) ? fileName.substring(0, lastDot) : fileName;
    }

    /**
     * Change file extension
     */
    private static Path changeExtension(Path path, String newExtension) {
        String nameWithoutExt = getFileNameWithoutExtension(path);
        String newFileName = nameWithoutExt + newExtension;
        return path.resolveSibling(newFileName);
    }

    /**
     * Check if file is accessible (exists and readable)
     */
    private static boolean isFileAccessible(Path path) {
        return Files.exists(path) && Files.isReadable(path);
    }

    /**
     * Print comprehensive file information
     */
    private static void printFileInfo(Path path) {
        try {
            if (Files.exists(path)) {
                System.out.println("File: " + path.getFileName());
                System.out.println("  Absolute path: " + path.toAbsolutePath());
                System.out.println("  Size: " + Files.size(path) + " bytes");
                System.out.println("  Is directory: " + Files.isDirectory(path));
                System.out.println("  Is regular file: " + Files.isRegularFile(path));
                System.out.println("  Readable: " + Files.isReadable(path));
                System.out.println("  Writable: " + Files.isWritable(path));
                System.out.println("  Executable: " + Files.isExecutable(path));

                FileTime lastModified = Files.getLastModifiedTime(path);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.systemDefault());
                System.out.println("  Last modified: " + formatter.format(lastModified.toInstant()));
            } else {
                System.out.println("File does not exist: " + path);
            }
        } catch (IOException e) {
            System.err.println("Error reading file info: " + e.getMessage());
        }
    }

    /**
     * Safely delete a file with error handling
     */
    private static void safeDeleteFile(Path path) {
        try {
            if (Files.exists(path)) {
                Files.delete(path);
                System.out.println("✓ Successfully deleted: " + path.getFileName());
            } else {
                System.out.println("File does not exist: " + path.getFileName());
            }
        } catch (IOException e) {
            System.err.println("✗ Failed to delete " + path.getFileName() + ": " + e.getMessage());
        }
    }
}

/*
 * FILE BASICS QUICK REFERENCE:
 *
 * CLASSIC FILE CLASS (java.io.File):
 * File file = new File("path/to/file.txt");
 * file.exists()           - Check existence
 * file.isFile()           - Is regular file
 * file.isDirectory()      - Is directory
 * file.getName()          - Get file name
 * file.getAbsolutePath()  - Get absolute path
 * file.createNewFile()    - Create new file
 * file.delete()           - Delete file
 *
 * MODERN PATH/FILES (java.nio.file):
 * Path path = Path.of("path", "to", "file.txt");
 * Files.exists(path)           - Check existence
 * Files.isRegularFile(path)    - Is regular file
 * Files.isDirectory(path)      - Is directory
 * Files.createFile(path)       - Create file
 * Files.delete(path)           - Delete file
 * Files.deleteIfExists(path)   - Delete if exists
 * Files.copy(source, dest)     - Copy file
 * Files.move(source, dest)     - Move/rename file
 * Files.size(path)             - Get file size
 * Files.getLastModifiedTime()  - Get last modified time
 *
 * PATH OPERATIONS:
 * path.getFileName()      - Get file name
 * path.getParent()        - Get parent directory
 * path.resolve(other)     - Join paths
 * path.normalize()        - Remove redundant elements
 * path.toAbsolutePath()   - Convert to absolute path
 * path.startsWith(prefix) - Check prefix
 * path.endsWith(suffix)   - Check suffix
 *
 * BEST PRACTICES:
 * ✓ Use Path and Files (NIO.2) instead of File class
 * ✓ Use Path.of() for creating paths (Java 11+)
 * ✓ Always check file existence before operations
 * ✓ Handle IOException appropriately
 * ✓ Use relative paths for portability
 * ✓ Use Files.deleteIfExists() to avoid exceptions
 * ✓ Use try-with-resources for file operations
 *
 * ADVANTAGES OF NIO.2 OVER CLASSIC I/O:
 * ✓ Better exception handling (specific exceptions)
 * ✓ More features (copy, move, walk tree, etc.)
 * ✓ Better performance
 * ✓ Support for symbolic links
 * ✓ File attributes and metadata
 * ✓ Watch service for file system events
 *
 * HOW TO RUN:
 * javac FileBasics.java
 * java FileBasics
 *
 * NOTE: This program creates and deletes files in the current directory.
 * Make sure you have write permissions.
 */
