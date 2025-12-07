/**
 * DirectoryOperations.java
 *
 * This program demonstrates comprehensive directory operations in Java using
 * both classic File class and modern NIO.2 API. Covers creating, listing,
 * traversing, searching, and manipulating directories.
 *
 * Key Concepts:
 * - Creating single and nested directories
 * - Listing directory contents
 * - Walking directory trees
 * - Searching files and directories
 * - Copying and moving directories
 * - Deleting directories recursively
 * - Directory filtering and patterns
 * - File tree visitor pattern
 *
 * Java Features Used: Java 11+ (Path.of, var, Stream API, pattern matching)
 */

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Stream;

public class DirectoryOperations {

    public static void main(String[] args) {

        System.out.println("========== DIRECTORY OPERATIONS DEMONSTRATION ==========\n");

        // ========== CREATING DIRECTORIES ==========

        System.out.println("--- 1. Creating Directories ---\n");

        try {
            // Create single directory (classic)
            File dir1 = new File("test_dir");
            if (dir1.mkdir()) {
                System.out.println("✓ Created directory (classic): " + dir1.getName());
            }

            // Create single directory (modern)
            Path dir2 = Path.of("modern_dir");
            if (!Files.exists(dir2)) {
                Files.createDirectory(dir2);
                System.out.println("✓ Created directory (modern): " + dir2.getFileName());
            }

            // Create nested directories (classic)
            File nestedDir1 = new File("parent1/child1/grandchild1");
            if (nestedDir1.mkdirs()) {
                System.out.println("✓ Created nested directories (classic): " + nestedDir1.getPath());
            }

            // Create nested directories (modern)
            Path nestedDir2 = Path.of("parent2", "child2", "grandchild2");
            Files.createDirectories(nestedDir2);
            System.out.println("✓ Created nested directories (modern): " + nestedDir2);

            // Create directory with files
            createDirectoryStructure();

        } catch (IOException e) {
            System.err.println("Error creating directories: " + e.getMessage());
        }


        // ========== CHECKING DIRECTORY EXISTENCE ==========

        System.out.println("\n\n--- 2. Checking Directory Existence ---\n");

        Path checkDir = Path.of("test_dir");
        System.out.println("Directory exists: " + Files.exists(checkDir));
        System.out.println("Is directory: " + Files.isDirectory(checkDir));
        System.out.println("Is regular file: " + Files.isRegularFile(checkDir));
        System.out.println("Is readable: " + Files.isReadable(checkDir));
        System.out.println("Is writable: " + Files.isWritable(checkDir));

        // Classic way
        File classicCheck = new File("test_dir");
        System.out.println("\nClassic check:");
        System.out.println("Exists: " + classicCheck.exists());
        System.out.println("Is directory: " + classicCheck.isDirectory());
        System.out.println("Can read: " + classicCheck.canRead());
        System.out.println("Can write: " + classicCheck.canWrite());


        // ========== LISTING DIRECTORY CONTENTS ==========

        System.out.println("\n\n--- 3. Listing Directory Contents ---\n");

        try {
            Path sampleDir = Path.of("sample_structure");

            System.out.println("Contents of " + sampleDir + ":\n");

            // Method 1: Files.list() - non-recursive
            System.out.println("Method 1: Files.list() - Direct children only");
            try (Stream<Path> paths = Files.list(sampleDir)) {
                paths.forEach(p -> {
                    try {
                        String type = Files.isDirectory(p) ? "[DIR] " : "[FILE]";
                        long size = Files.isDirectory(p) ? 0 : Files.size(p);
                        System.out.println("  " + type + " " + p.getFileName() +
                                         " (" + size + " bytes)");
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                });
            }

            // Method 2: DirectoryStream
            System.out.println("\nMethod 2: DirectoryStream");
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(sampleDir)) {
                for (Path entry : stream) {
                    String type = Files.isDirectory(entry) ? "[DIR] " : "[FILE]";
                    System.out.println("  " + type + " " + entry.getFileName());
                }
            }

            // Method 3: Classic File.listFiles()
            System.out.println("\nMethod 3: Classic File.listFiles()");
            File classicDir = new File("sample_structure");
            File[] files = classicDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    String type = file.isDirectory() ? "[DIR] " : "[FILE]";
                    System.out.println("  " + type + " " + file.getName());
                }
            }

        } catch (IOException e) {
            System.err.println("Error listing directory: " + e.getMessage());
        }


        // ========== WALKING DIRECTORY TREE ==========

        System.out.println("\n\n--- 4. Walking Directory Tree ---\n");

        try {
            Path root = Path.of("sample_structure");

            System.out.println("Walking entire tree from " + root + ":\n");

            // Walk with Files.walk()
            try (Stream<Path> paths = Files.walk(root)) {
                paths.forEach(p -> {
                    try {
                        int depth = p.getNameCount() - root.getNameCount();
                        String indent = "  ".repeat(depth);
                        String type = Files.isDirectory(p) ? "[DIR] " : "[FILE]";
                        String name = p.getFileName().toString();
                        long size = Files.isDirectory(p) ? 0 : Files.size(p);
                        System.out.println(indent + type + name +
                                         (size > 0 ? " (" + size + " bytes)" : ""));
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                });
            }

            // Walk with maximum depth
            System.out.println("\nWalking with max depth 2:");
            try (Stream<Path> paths = Files.walk(root, 2)) {
                paths.filter(Files::isRegularFile)
                     .forEach(p -> System.out.println("  " + p));
            }

        } catch (IOException e) {
            System.err.println("Error walking tree: " + e.getMessage());
        }


        // ========== FILTERING DIRECTORY CONTENTS ==========

        System.out.println("\n\n--- 5. Filtering Directory Contents ---\n");

        try {
            Path dir = Path.of("sample_structure");

            // Filter by extension
            System.out.println("Text files (.txt):");
            try (Stream<Path> paths = Files.walk(dir)) {
                paths.filter(p -> p.toString().endsWith(".txt"))
                     .forEach(p -> System.out.println("  " + p));
            }

            // Filter by size
            System.out.println("\nFiles larger than 0 bytes:");
            try (Stream<Path> paths = Files.walk(dir)) {
                paths.filter(Files::isRegularFile)
                     .filter(p -> {
                         try {
                             return Files.size(p) > 0;
                         } catch (IOException e) {
                             return false;
                         }
                     })
                     .forEach(p -> System.out.println("  " + p.getFileName()));
            }

            // DirectoryStream with filter
            System.out.println("\nUsing DirectoryStream with glob pattern:");
            try (DirectoryStream<Path> stream =
                    Files.newDirectoryStream(dir, "*.{txt,log}")) {
                for (Path entry : stream) {
                    System.out.println("  " + entry.getFileName());
                }
            }

        } catch (IOException e) {
            System.err.println("Error filtering: " + e.getMessage());
        }


        // ========== SEARCHING IN DIRECTORIES ==========

        System.out.println("\n\n--- 6. Searching in Directories ---\n");

        try {
            Path searchRoot = Path.of("sample_structure");

            // Find files by name
            System.out.println("Finding files containing 'data':");
            try (Stream<Path> paths = Files.walk(searchRoot)) {
                paths.filter(Files::isRegularFile)
                     .filter(p -> p.getFileName().toString().contains("data"))
                     .forEach(p -> System.out.println("  Found: " + p));
            }

            // Find directories
            System.out.println("\nFinding all directories:");
            try (Stream<Path> paths = Files.walk(searchRoot)) {
                paths.filter(Files::isDirectory)
                     .filter(p -> !p.equals(searchRoot))
                     .forEach(p -> System.out.println("  " + p));
            }

            // Find with Files.find()
            System.out.println("\nUsing Files.find() for .txt files:");
            try (Stream<Path> paths = Files.find(searchRoot, Integer.MAX_VALUE,
                    (path, attrs) -> path.toString().endsWith(".txt"))) {
                paths.forEach(p -> System.out.println("  " + p));
            }

        } catch (IOException e) {
            System.err.println("Error searching: " + e.getMessage());
        }


        // ========== COPYING DIRECTORIES ==========

        System.out.println("\n\n--- 7. Copying Directories ---\n");

        try {
            Path source = Path.of("sample_structure");
            Path target = Path.of("sample_structure_copy");

            System.out.println("Copying directory from " + source + " to " + target);
            copyDirectory(source, target);
            System.out.println("✓ Directory copied successfully");

            // Verify copy
            long originalCount = countFiles(source);
            long copiedCount = countFiles(target);
            System.out.println("Original files: " + originalCount);
            System.out.println("Copied files: " + copiedCount);

        } catch (Exception e) {
            System.err.println("Error copying directory: " + e.getMessage());
        }


        // ========== MOVING DIRECTORIES ==========

        System.out.println("\n\n--- 8. Moving/Renaming Directories ---\n");

        try {
            Path oldPath = Path.of("sample_structure_copy");
            Path newPath = Path.of("sample_structure_renamed");

            if (Files.exists(oldPath)) {
                Files.move(oldPath, newPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("✓ Directory moved/renamed successfully");
                System.out.println("  From: " + oldPath);
                System.out.println("  To: " + newPath);
            }

        } catch (IOException e) {
            System.err.println("Error moving directory: " + e.getMessage());
        }


        // ========== DIRECTORY STATISTICS ==========

        System.out.println("\n\n--- 9. Directory Statistics ---\n");

        try {
            Path dir = Path.of("sample_structure");

            DirectoryStats stats = getDirectoryStats(dir);
            System.out.println("Statistics for " + dir + ":");
            System.out.println("  Total files: " + stats.fileCount);
            System.out.println("  Total directories: " + stats.dirCount);
            System.out.println("  Total size: " + formatSize(stats.totalSize));
            System.out.println("  Largest file: " + stats.largestFile +
                             " (" + formatSize(stats.largestSize) + ")");

        } catch (Exception e) {
            System.err.println("Error calculating statistics: " + e.getMessage());
        }


        // ========== FILE TREE VISITOR ==========

        System.out.println("\n\n--- 10. Using FileVisitor ---\n");

        try {
            Path root = Path.of("sample_structure");

            System.out.println("Using custom FileVisitor:");

            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                private int fileCount = 0;
                private int dirCount = 0;

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    dirCount++;
                    System.out.println("[DIR] " + dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    fileCount++;
                    System.out.println("  [FILE] " + file.getFileName() +
                                     " (" + attrs.size() + " bytes)");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                    if (dir.equals(root)) {
                        System.out.println("\nSummary:");
                        System.out.println("  Directories: " + dirCount);
                        System.out.println("  Files: " + fileCount);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.println("Failed to access: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            System.err.println("Error with FileVisitor: " + e.getMessage());
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 11. Practical Examples ---\n");

        try {
            Path workDir = Path.of("sample_structure");

            // Example 1: Find empty directories
            System.out.println("Example 1: Finding Empty Directories");
            List<Path> emptyDirs = findEmptyDirectories(workDir);
            if (emptyDirs.isEmpty()) {
                System.out.println("  No empty directories found");
            } else {
                emptyDirs.forEach(p -> System.out.println("  " + p));
            }

            // Example 2: Calculate directory tree depth
            System.out.println("\nExample 2: Directory Tree Depth");
            int depth = calculateMaxDepth(workDir);
            System.out.println("  Maximum depth: " + depth);

            // Example 3: Group files by extension
            System.out.println("\nExample 3: Files Grouped by Extension");
            Map<String, List<Path>> grouped = groupFilesByExtension(workDir);
            grouped.forEach((ext, files) -> {
                System.out.println("  " + ext + ": " + files.size() + " files");
            });

            // Example 4: Find duplicate file names
            System.out.println("\nExample 4: Duplicate File Names");
            Map<String, List<Path>> duplicates = findDuplicateNames(workDir);
            if (duplicates.isEmpty()) {
                System.out.println("  No duplicate file names found");
            } else {
                duplicates.forEach((name, paths) -> {
                    System.out.println("  '" + name + "' appears " + paths.size() + " times");
                });
            }

        } catch (Exception e) {
            System.err.println("Error in examples: " + e.getMessage());
        }


        // ========== DELETING DIRECTORIES ==========

        System.out.println("\n\n--- 12. Deleting Directories ---\n");

        try {
            // Delete empty directory
            Path emptyDir = Path.of("test_dir");
            if (Files.exists(emptyDir)) {
                Files.delete(emptyDir);
                System.out.println("✓ Deleted empty directory: " + emptyDir);
            }

            // Delete non-empty directory recursively
            Path nonEmptyDir = Path.of("sample_structure_renamed");
            if (Files.exists(nonEmptyDir)) {
                deleteDirectory(nonEmptyDir);
                System.out.println("✓ Deleted non-empty directory recursively: " + nonEmptyDir);
            }

        } catch (IOException e) {
            System.err.println("Error deleting directories: " + e.getMessage());
        }


        // ========== CLEANUP ==========

        System.out.println("\n\n--- Cleanup ---\n");
        cleanup();

        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHODS ==========

    /**
     * Create a sample directory structure for demonstration
     */
    private static void createDirectoryStructure() throws IOException {
        Path root = Path.of("sample_structure");
        Files.createDirectories(root);

        // Create subdirectories
        Files.createDirectories(root.resolve("documents"));
        Files.createDirectories(root.resolve("images"));
        Files.createDirectories(root.resolve("data").resolve("reports"));

        // Create sample files
        Files.writeString(root.resolve("readme.txt"), "Sample readme file");
        Files.writeString(root.resolve("documents").resolve("file1.txt"), "Document 1");
        Files.writeString(root.resolve("documents").resolve("file2.txt"), "Document 2");
        Files.writeString(root.resolve("images").resolve("photo.jpg"), "Image data");
        Files.writeString(root.resolve("data").resolve("data.txt"), "Data file");
        Files.writeString(root.resolve("data").resolve("reports").resolve("report.txt"), "Report");

        System.out.println("✓ Created sample directory structure");
    }

    /**
     * Copy directory recursively
     */
    private static void copyDirectory(Path source, Path target) throws IOException {
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
    }

    /**
     * Delete directory recursively
     */
    private static void deleteDirectory(Path directory) throws IOException {
        try (Stream<Path> paths = Files.walk(directory)) {
            paths.sorted((p1, p2) -> -p1.compareTo(p2)) // Delete children before parents
                 .forEach(p -> {
                     try {
                         Files.delete(p);
                     } catch (IOException e) {
                         System.err.println("Error deleting: " + e.getMessage());
                     }
                 });
        }
    }

    /**
     * Count files in directory
     */
    private static long countFiles(Path directory) throws IOException {
        try (Stream<Path> paths = Files.walk(directory)) {
            return paths.filter(Files::isRegularFile).count();
        }
    }

    /**
     * Get directory statistics
     */
    private static DirectoryStats getDirectoryStats(Path directory) throws IOException {
        DirectoryStats stats = new DirectoryStats();

        try (Stream<Path> paths = Files.walk(directory)) {
            paths.forEach(p -> {
                try {
                    if (Files.isDirectory(p)) {
                        stats.dirCount++;
                    } else {
                        stats.fileCount++;
                        long size = Files.size(p);
                        stats.totalSize += size;
                        if (size > stats.largestSize) {
                            stats.largestSize = size;
                            stats.largestFile = p.getFileName().toString();
                        }
                    }
                } catch (IOException e) {
                    // Skip files that can't be read
                }
            });
        }

        return stats;
    }

    /**
     * Find empty directories
     */
    private static List<Path> findEmptyDirectories(Path root) throws IOException {
        List<Path> emptyDirs = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(root)) {
            paths.filter(Files::isDirectory)
                 .forEach(dir -> {
                     try (Stream<Path> entries = Files.list(dir)) {
                         if (entries.count() == 0) {
                             emptyDirs.add(dir);
                         }
                     } catch (IOException e) {
                         // Skip
                     }
                 });
        }

        return emptyDirs;
    }

    /**
     * Calculate maximum depth of directory tree
     */
    private static int calculateMaxDepth(Path root) throws IOException {
        final int[] maxDepth = {0};
        int rootDepth = root.getNameCount();

        try (Stream<Path> paths = Files.walk(root)) {
            paths.forEach(p -> {
                int depth = p.getNameCount() - rootDepth;
                if (depth > maxDepth[0]) {
                    maxDepth[0] = depth;
                }
            });
        }

        return maxDepth[0];
    }

    /**
     * Group files by extension
     */
    private static Map<String, List<Path>> groupFilesByExtension(Path root) throws IOException {
        Map<String, List<Path>> grouped = new HashMap<>();

        try (Stream<Path> paths = Files.walk(root)) {
            paths.filter(Files::isRegularFile)
                 .forEach(p -> {
                     String name = p.getFileName().toString();
                     int lastDot = name.lastIndexOf('.');
                     String ext = lastDot > 0 ? name.substring(lastDot) : "no extension";
                     grouped.computeIfAbsent(ext, k -> new ArrayList<>()).add(p);
                 });
        }

        return grouped;
    }

    /**
     * Find duplicate file names
     */
    private static Map<String, List<Path>> findDuplicateNames(Path root) throws IOException {
        Map<String, List<Path>> nameMap = new HashMap<>();

        try (Stream<Path> paths = Files.walk(root)) {
            paths.filter(Files::isRegularFile)
                 .forEach(p -> {
                     String name = p.getFileName().toString();
                     nameMap.computeIfAbsent(name, k -> new ArrayList<>()).add(p);
                 });
        }

        // Keep only duplicates
        nameMap.entrySet().removeIf(entry -> entry.getValue().size() < 2);
        return nameMap;
    }

    /**
     * Format file size to human-readable format
     */
    private static String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp - 1) + "";
        return String.format("%.2f %sB", bytes / Math.pow(1024, exp), pre);
    }

    /**
     * Cleanup demonstration files
     */
    private static void cleanup() {
        try {
            deleteDirectory(Path.of("sample_structure"));
            deleteDirectory(Path.of("modern_dir"));
            deleteDirectory(Path.of("parent1"));
            deleteDirectory(Path.of("parent2"));
            System.out.println("✓ Cleanup completed");
        } catch (Exception e) {
            System.err.println("Cleanup error: " + e.getMessage());
        }
    }

    /**
     * Inner class to hold directory statistics
     */
    static class DirectoryStats {
        int fileCount = 0;
        int dirCount = 0;
        long totalSize = 0;
        long largestSize = 0;
        String largestFile = "";
    }
}

/*
 * DIRECTORY OPERATIONS QUICK REFERENCE:
 *
 * CREATING DIRECTORIES:
 * Files.createDirectory(path)           - Create single directory
 * Files.createDirectories(path)         - Create nested directories
 * File.mkdir()                          - Classic single directory
 * File.mkdirs()                         - Classic nested directories
 *
 * LISTING CONTENTS:
 * Files.list(path)                      - Direct children (Stream)
 * Files.newDirectoryStream(path)        - Direct children (Iterable)
 * File.listFiles()                      - Classic listing
 *
 * WALKING TREE:
 * Files.walk(path)                      - Walk entire tree
 * Files.walk(path, depth)               - Walk with max depth
 * Files.walkFileTree(path, visitor)     - Custom visitor pattern
 *
 * SEARCHING:
 * Files.find(path, depth, matcher)      - Find matching files
 * Stream.filter()                       - Filter results
 * DirectoryStream with glob             - Pattern matching
 *
 * COPYING/MOVING:
 * Files.copy(source, target)            - Copy file/directory
 * Files.move(source, target)            - Move/rename
 * Custom recursive copy for trees       - Walk + copy each
 *
 * DELETING:
 * Files.delete(path)                    - Delete (must be empty)
 * Files.deleteIfExists(path)            - Delete if exists
 * Recursive delete                      - Walk in reverse + delete
 *
 * FILTERING:
 * DirectoryStream with glob pattern     - "*.{txt,log}"
 * Stream.filter()                       - Lambda predicates
 * PathMatcher                           - Complex patterns
 *
 * STATISTICS:
 * Files.size(path)                      - File size
 * Stream counting                       - Count files/dirs
 * Custom aggregation                    - Calculate totals
 *
 * BEST PRACTICES:
 * ✓ Use Files.walk() for tree traversal
 * ✓ Always close Streams (try-with-resources)
 * ✓ Check existence before operations
 * ✓ Handle IOException properly
 * ✓ Delete children before parents
 * ✓ Use Files.createDirectories() for nested paths
 * ✓ Consider FileVisitor for complex operations
 * ✓ Use Stream API for filtering and processing
 *
 * COMMON PATTERNS:
 * 1. List all files: Files.walk(root).filter(Files::isRegularFile)
 * 2. Find by extension: filter(p -> p.toString().endsWith(".txt"))
 * 3. Calculate size: mapToLong(Files::size).sum()
 * 4. Delete tree: walk().sorted(reverse).forEach(Files::delete)
 * 5. Copy tree: walk().forEach(copy with relativize)
 *
 * HOW TO RUN:
 * javac DirectoryOperations.java
 * java DirectoryOperations
 */
