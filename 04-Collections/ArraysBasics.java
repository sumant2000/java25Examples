/**
 * ArraysBasics.java
 *
 * This program demonstrates arrays in Java - the foundation of collections.
 * Arrays are fixed-size data structures that store elements of the same type.
 *
 * Key Concepts:
 * - Array declaration and initialization
 * - Accessing and modifying array elements
 * - Multi-dimensional arrays
 * - Array traversal
 * - Common array operations
 * - Arrays utility class
 */

import java.util.Arrays;

public class ArraysBasics {

    public static void main(String[] args) {

        System.out.println("========== ARRAYS IN JAVA ==========\n");

        // ========== ARRAY DECLARATION AND INITIALIZATION ==========

        System.out.println("--- 1. Array Declaration and Initialization ---\n");

        // Method 1: Declare and allocate memory
        int[] numbers = new int[5];
        System.out.println("Empty array created with size 5");
        System.out.println("Default values: " + Arrays.toString(numbers));

        // Method 2: Declare and initialize with values
        int[] scores = {85, 92, 78, 95, 88};
        System.out.println("\nArray with initial values: " + Arrays.toString(scores));

        // Method 3: Using new keyword with values
        String[] fruits = new String[]{"Apple", "Banana", "Cherry", "Date"};
        System.out.println("String array: " + Arrays.toString(fruits));

        // Different ways to declare arrays
        int[] arr1;           // Preferred way
        int arr2[];           // Also valid but not preferred


        // ========== ACCESSING AND MODIFYING ELEMENTS ==========

        System.out.println("\n\n--- 2. Accessing and Modifying Elements ---\n");

        // Accessing elements (0-based indexing)
        System.out.println("First score: " + scores[0]);
        System.out.println("Third score: " + scores[2]);
        System.out.println("Last score: " + scores[scores.length - 1]);

        // Modifying elements
        scores[0] = 90;
        System.out.println("\nAfter modifying first score: " + Arrays.toString(scores));

        // Array length
        System.out.println("Array length: " + scores.length);


        // ========== ITERATING THROUGH ARRAYS ==========

        System.out.println("\n\n--- 3. Iterating Through Arrays ---\n");

        // Using traditional for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("fruits[" + i + "] = " + fruits[i]);
        }

        // Using enhanced for loop (for-each)
        System.out.println("\nUsing enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        // Using Arrays.toString()
        System.out.println("\nUsing Arrays.toString(): " + Arrays.toString(fruits));


        // ========== ARRAY OPERATIONS ==========

        System.out.println("\n\n--- 4. Common Array Operations ---\n");

        int[] data = {45, 23, 78, 12, 67, 34, 89, 56};
        System.out.println("Original array: " + Arrays.toString(data));

        // Find maximum
        int max = data[0];
        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum value: " + max);

        // Find minimum
        int min = data[0];
        for (int num : data) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Minimum value: " + min);

        // Calculate sum
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        // Calculate average
        double average = (double) sum / data.length;
        System.out.println("Average: " + String.format("%.2f", average));


        // ========== ARRAYS UTILITY CLASS ==========

        System.out.println("\n\n--- 5. Arrays Utility Methods ---\n");

        int[] original = {5, 2, 8, 1, 9, 3, 7};
        System.out.println("Original: " + Arrays.toString(original));

        // Sort array
        int[] sortedArray = original.clone();
        Arrays.sort(sortedArray);
        System.out.println("Sorted: " + Arrays.toString(sortedArray));

        // Binary search (array must be sorted)
        int index = Arrays.binarySearch(sortedArray, 8);
        System.out.println("Index of 8 in sorted array: " + index);

        // Fill array with value
        int[] filled = new int[5];
        Arrays.fill(filled, 100);
        System.out.println("Filled array: " + Arrays.toString(filled));

        // Copy array
        int[] copied = Arrays.copyOf(original, original.length);
        System.out.println("Copied array: " + Arrays.toString(copied));

        // Copy array with different size
        int[] expanded = Arrays.copyOf(original, 10);
        System.out.println("Expanded array: " + Arrays.toString(expanded));

        // Copy range
        int[] rangeCopy = Arrays.copyOfRange(original, 2, 5);
        System.out.println("Range copy [2-5): " + Arrays.toString(rangeCopy));

        // Compare arrays
        int[] arr1Equal = {1, 2, 3};
        int[] arr2Equal = {1, 2, 3};
        int[] arr3Different = {1, 2, 4};
        System.out.println("\nArray equality:");
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1Equal, arr2Equal));
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1Equal, arr3Different));


        // ========== MULTI-DIMENSIONAL ARRAYS ==========

        System.out.println("\n\n--- 6. Multi-Dimensional Arrays ---\n");

        // 2D Array (Matrix)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Alternative declaration
        int[][] matrix2 = new int[3][3];
        int value = 1;
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = value++;
            }
        }

        // Print using Arrays.deepToString()
        System.out.println("\nUsing deepToString(): " + Arrays.deepToString(matrix2));

        // Jagged array (rows with different lengths)
        int[][] jagged = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9}
        };
        System.out.println("\nJagged array: " + Arrays.deepToString(jagged));

        // 3D Array
        int[][][] cube = new int[2][2][2];
        System.out.println("\n3D array created with dimensions 2x2x2");


        // ========== ARRAY OF OBJECTS ==========

        System.out.println("\n\n--- 7. Array of Objects ---\n");

        // Array of Strings
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        System.out.println("Names: " + Arrays.toString(names));

        // Array of custom objects
        Student[] students = new Student[3];
        students[0] = new Student("John", 20, 3.8);
        students[1] = new Student("Jane", 21, 3.9);
        students[2] = new Student("Jack", 19, 3.5);

        System.out.println("\nStudent details:");
        for (Student student : students) {
            System.out.println(student);
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 8. Practical Examples ---\n");

        // Example 1: Reverse an array
        int[] toReverse = {1, 2, 3, 4, 5};
        System.out.println("Original: " + Arrays.toString(toReverse));
        reverseArray(toReverse);
        System.out.println("Reversed: " + Arrays.toString(toReverse));

        // Example 2: Find element in array
        int[] searchArray = {10, 20, 30, 40, 50};
        int searchValue = 30;
        int searchIndex = findElement(searchArray, searchValue);
        if (searchIndex != -1) {
            System.out.println("\n" + searchValue + " found at index: " + searchIndex);
        } else {
            System.out.println("\n" + searchValue + " not found");
        }

        // Example 3: Count occurrences
        int[] countArray = {1, 2, 3, 2, 4, 2, 5};
        int countValue = 2;
        int count = countOccurrences(countArray, countValue);
        System.out.println("\n" + countValue + " appears " + count + " times in " +
                          Arrays.toString(countArray));

        // Example 4: Remove duplicates
        int[] withDuplicates = {1, 2, 3, 2, 4, 3, 5, 1};
        System.out.println("\nArray with duplicates: " + Arrays.toString(withDuplicates));
        int[] unique = removeDuplicates(withDuplicates);
        System.out.println("Without duplicates: " + Arrays.toString(unique));

        // Example 5: Merge two arrays
        int[] arr1Merge = {1, 3, 5};
        int[] arr2Merge = {2, 4, 6};
        int[] merged = mergeArrays(arr1Merge, arr2Merge);
        System.out.println("\nMerged array: " + Arrays.toString(merged));

        // Example 6: Find second largest
        int[] numbers2 = {45, 78, 23, 89, 12, 67};
        int secondLargest = findSecondLargest(numbers2);
        System.out.println("\nSecond largest in " + Arrays.toString(numbers2) + ": " +
                          secondLargest);

        // Example 7: Check if sorted
        int[] sortedCheck = {1, 2, 3, 4, 5};
        int[] unsortedCheck = {1, 3, 2, 4, 5};
        System.out.println("\nIs " + Arrays.toString(sortedCheck) + " sorted? " +
                          isSorted(sortedCheck));
        System.out.println("Is " + Arrays.toString(unsortedCheck) + " sorted? " +
                          isSorted(unsortedCheck));


        // ========== ARRAY LIMITATIONS ==========

        System.out.println("\n\n--- 9. Array Limitations ---\n");

        System.out.println("Array Limitations:");
        System.out.println("1. Fixed size - cannot grow or shrink");
        System.out.println("2. No built-in methods for add/remove");
        System.out.println("3. Can't mix different types (except Object[])");
        System.out.println("4. No bounds checking at compile time");
        System.out.println("\nSolution: Use ArrayList for dynamic arrays (next program)");


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // ========== HELPER METHODS ==========

    // Reverse array in place
    static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Find element in array (linear search)
    static int findElement(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Count occurrences of a value
    static int countOccurrences(int[] arr, int value) {
        int count = 0;
        for (int num : arr) {
            if (num == value) {
                count++;
            }
        }
        return count;
    }

    // Remove duplicates from array
    static int[] removeDuplicates(int[] arr) {
        if (arr.length == 0) return arr;

        // Sort first
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Count unique elements
        int uniqueCount = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i-1]) {
                uniqueCount++;
            }
        }

        // Create result array
        int[] result = new int[uniqueCount];
        result[0] = sorted[0];
        int index = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i-1]) {
                result[index++] = sorted[i];
            }
        }

        return result;
    }

    // Merge two arrays
    static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0;
        for (int num : arr1) {
            merged[i++] = num;
        }
        for (int num : arr2) {
            merged[i++] = num;
        }
        return merged;
    }

    // Find second largest element
    static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    // Check if array is sorted
    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }
}

// Student class for object array example
class Student {
    String name;
    int age;
    double gpa;

    Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
    }
}

/*
 * ARRAY QUICK REFERENCE:
 *
 * DECLARATION:
 * int[] arr = new int[5];              // Empty array
 * int[] arr = {1, 2, 3, 4, 5};        // With values
 * int[] arr = new int[]{1, 2, 3};     // Alternate syntax
 *
 * ACCESS:
 * arr[0]        // First element
 * arr[arr.length - 1]  // Last element
 * arr.length    // Array size
 *
 * COMMON OPERATIONS:
 * Arrays.toString(arr)      // Print array
 * Arrays.sort(arr)          // Sort array
 * Arrays.fill(arr, value)   // Fill with value
 * Arrays.equals(arr1, arr2) // Compare arrays
 * Arrays.copyOf(arr, len)   // Copy array
 * Arrays.binarySearch(arr, value)  // Binary search (must be sorted)
 *
 * ITERATION:
 * for (int i = 0; i < arr.length; i++) { }  // Traditional
 * for (int num : arr) { }                    // Enhanced
 *
 * MULTI-DIMENSIONAL:
 * int[][] matrix = new int[3][3];
 * int[][] matrix = {{1,2}, {3,4}};
 * Arrays.deepToString(matrix)   // Print 2D array
 *
 * IMPORTANT NOTES:
 * 1. Arrays are 0-indexed
 * 2. Fixed size - cannot grow or shrink
 * 3. ArrayIndexOutOfBoundsException if invalid index
 * 4. Default values: 0 (numeric), false (boolean), null (objects)
 * 5. Arrays are objects - passed by reference
 * 6. Use ArrayList for dynamic sizing
 *
 * TIME COMPLEXITY:
 * Access: O(1)
 * Search: O(n) linear, O(log n) binary (if sorted)
 * Insert/Delete: O(n)
 *
 * HOW TO RUN:
 * javac ArraysBasics.java
 * java ArraysBasics
 */
