/**
 * ArrayListDemo.java
 *
 * This program demonstrates ArrayList - a dynamic resizable array implementation.
 * ArrayList is one of the most commonly used collections in Java.
 *
 * Key Concepts:
 * - ArrayList creation and initialization
 * - Adding, removing, and modifying elements
 * - Searching and sorting
 * - Iterating through ArrayList
 * - ArrayList methods and best practices
 * - ArrayList vs Array comparison
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

public class ArrayListDemo {

    public static void main(String[] args) {

        System.out.println("========== ARRAYLIST DEMONSTRATION ==========\n");

        // ========== CREATING ARRAYLIST ==========

        System.out.println("--- 1. Creating ArrayList ---\n");

        // Empty ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        System.out.println("Empty ArrayList created: " + fruits);

        // ArrayList with initial capacity
        ArrayList<Integer> numbers = new ArrayList<>(100);
        System.out.println("ArrayList with initial capacity 100 created");

        // ArrayList from another collection
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println("ArrayList from another collection: " + list2);

        // Using List interface (preferred)
        List<String> cities = new ArrayList<>();
        System.out.println("Using List interface: " + cities);


        // ========== ADDING ELEMENTS ==========

        System.out.println("\n\n--- 2. Adding Elements ---\n");

        List<String> colors = new ArrayList<>();

        // Add elements
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        System.out.println("After adding elements: " + colors);

        // Add at specific index
        colors.add(1, "Yellow");
        System.out.println("After adding Yellow at index 1: " + colors);

        // Add multiple elements
        colors.add("Orange");
        colors.add("Purple");
        colors.add("Pink");
        System.out.println("After adding more colors: " + colors);

        // Add all from another collection
        List<String> moreColors = new ArrayList<>();
        moreColors.add("Black");
        moreColors.add("White");
        colors.addAll(moreColors);
        System.out.println("After addAll: " + colors);

        // Add all at specific index
        List<String> newColors = new ArrayList<>();
        newColors.add("Gray");
        newColors.add("Brown");
        colors.addAll(2, newColors);
        System.out.println("After addAll at index 2: " + colors);


        // ========== ACCESSING ELEMENTS ==========

        System.out.println("\n\n--- 3. Accessing Elements ---\n");

        List<String> fruits2 = new ArrayList<>();
        fruits2.add("Apple");
        fruits2.add("Banana");
        fruits2.add("Cherry");
        fruits2.add("Date");
        fruits2.add("Elderberry");

        System.out.println("ArrayList: " + fruits2);

        // Get element by index
        System.out.println("First element: " + fruits2.get(0));
        System.out.println("Third element: " + fruits2.get(2));
        System.out.println("Last element: " + fruits2.get(fruits2.size() - 1));

        // Get first and last (Java 21+)
        // System.out.println("First: " + fruits2.getFirst());
        // System.out.println("Last: " + fruits2.getLast());

        // Check if contains
        System.out.println("\nContains 'Banana': " + fruits2.contains("Banana"));
        System.out.println("Contains 'Mango': " + fruits2.contains("Mango"));

        // Get index of element
        System.out.println("\nIndex of 'Cherry': " + fruits2.indexOf("Cherry"));
        System.out.println("Index of 'Mango': " + fruits2.indexOf("Mango")); // -1 if not found

        // Last index (useful for duplicates)
        fruits2.add("Apple"); // Add duplicate
        System.out.println("\nWith duplicate Apple: " + fruits2);
        System.out.println("First index of 'Apple': " + fruits2.indexOf("Apple"));
        System.out.println("Last index of 'Apple': " + fruits2.lastIndexOf("Apple"));


        // ========== MODIFYING ELEMENTS ==========

        System.out.println("\n\n--- 4. Modifying Elements ---\n");

        List<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(92);
        scores.add(78);
        scores.add(95);
        scores.add(88);

        System.out.println("Original scores: " + scores);

        // Update element
        scores.set(2, 90); // Change 78 to 90
        System.out.println("After updating index 2: " + scores);

        // Replace all (Java 8+)
        scores.replaceAll(score -> score + 5); // Add 5 to all scores
        System.out.println("After adding 5 to all: " + scores);


        // ========== REMOVING ELEMENTS ==========

        System.out.println("\n\n--- 5. Removing Elements ---\n");

        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");
        languages.add("Ruby");
        languages.add("Go");

        System.out.println("Original: " + languages);

        // Remove by index
        String removed = languages.remove(2);
        System.out.println("Removed element at index 2: " + removed);
        System.out.println("After removal: " + languages);

        // Remove by object
        languages.remove("Ruby");
        System.out.println("After removing 'Ruby': " + languages);

        // Remove all from collection
        List<String> toRemove = new ArrayList<>();
        toRemove.add("Python");
        toRemove.add("Go");
        languages.removeAll(toRemove);
        System.out.println("After removeAll: " + languages);

        // Remove if (Java 8+)
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }
        System.out.println("\nNumbers: " + nums);
        nums.removeIf(n -> n % 2 == 0); // Remove even numbers
        System.out.println("After removing even numbers: " + nums);

        // Clear all elements
        List<String> temp = new ArrayList<>();
        temp.add("A");
        temp.add("B");
        temp.add("C");
        System.out.println("\nBefore clear: " + temp);
        temp.clear();
        System.out.println("After clear: " + temp);


        // ========== ITERATING THROUGH ARRAYLIST ==========

        System.out.println("\n\n--- 6. Iterating Through ArrayList ---\n");

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");

        // Using traditional for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(i + ": " + names.get(i));
        }

        // Using enhanced for loop (for-each)
        System.out.println("\nUsing enhanced for loop:");
        for (String name : names) {
            System.out.println("- " + name);
        }

        // Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println("* " + iterator.next());
        }

        // Using forEach with lambda (Java 8+)
        System.out.println("\nUsing forEach with lambda:");
        names.forEach(name -> System.out.println("> " + name));

        // Using forEach with method reference
        System.out.println("\nUsing method reference:");
        names.forEach(System.out::println);


        // ========== SEARCHING AND SORTING ==========

        System.out.println("\n\n--- 7. Searching and Sorting ---\n");

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(45);
        numbers2.add(23);
        numbers2.add(78);
        numbers2.add(12);
        numbers2.add(67);

        System.out.println("Original: " + numbers2);

        // Sort in natural order
        Collections.sort(numbers2);
        System.out.println("Sorted ascending: " + numbers2);

        // Sort in reverse order
        Collections.sort(numbers2, Collections.reverseOrder());
        System.out.println("Sorted descending: " + numbers2);

        // Sort using Comparator
        List<String> words = new ArrayList<>();
        words.add("Apple");
        words.add("banana");
        words.add("Cherry");
        words.add("date");

        System.out.println("\nOriginal words: " + words);
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + words);

        // Binary search (list must be sorted)
        Collections.sort(numbers2);
        int index = Collections.binarySearch(numbers2, 67);
        System.out.println("\nIndex of 67 in sorted list: " + index);


        // ========== ARRAYLIST UTILITY OPERATIONS ==========

        System.out.println("\n\n--- 8. Utility Operations ---\n");

        List<String> items = new ArrayList<>();
        items.add("Item1");
        items.add("Item2");
        items.add("Item3");
        items.add("Item4");
        items.add("Item5");

        System.out.println("Original: " + items);

        // Reverse
        Collections.reverse(items);
        System.out.println("Reversed: " + items);

        // Shuffle
        Collections.shuffle(items);
        System.out.println("Shuffled: " + items);

        // Fill
        Collections.fill(items, "X");
        System.out.println("Filled with 'X': " + items);

        // Frequency
        List<Integer> nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(2);
        nums2.add(2);
        nums2.add(3);
        nums2.add(2);
        int frequency = Collections.frequency(nums2, 2);
        System.out.println("\nFrequency of 2 in " + nums2 + ": " + frequency);

        // Max and Min
        List<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(50);
        values.add(30);
        values.add(70);
        values.add(20);
        System.out.println("\nValues: " + values);
        System.out.println("Max: " + Collections.max(values));
        System.out.println("Min: " + Collections.min(values));


        // ========== SUBLIST AND CONVERSION ==========

        System.out.println("\n\n--- 9. SubList and Conversion ---\n");

        List<Integer> original = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            original.add(i);
        }
        System.out.println("Original: " + original);

        // Get sublist
        List<Integer> subList = original.subList(3, 7);
        System.out.println("SubList [3-7): " + subList);

        // Convert to array
        String[] fruitsArray = {"Apple", "Banana", "Cherry"};
        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Cherry");

        Object[] objArray = fruitsList.toArray();
        String[] strArray = fruitsList.toArray(new String[0]);
        System.out.println("\nConverted to array: " + java.util.Arrays.toString(strArray));


        // ========== SIZE AND CAPACITY ==========

        System.out.println("\n\n--- 10. Size and Capacity ---\n");

        List<String> list = new ArrayList<>();
        System.out.println("Size of empty list: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());

        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("\nAfter adding 3 elements:");
        System.out.println("Size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());

        // Trim to size (reduce capacity to current size)
        if (list instanceof ArrayList) {
            ((ArrayList<String>) list).trimToSize();
            System.out.println("Trimmed to size");
        }


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 11. Practical Examples ---\n");

        // Example 1: Remove duplicates
        List<Integer> withDuplicates = new ArrayList<>();
        withDuplicates.add(1);
        withDuplicates.add(2);
        withDuplicates.add(2);
        withDuplicates.add(3);
        withDuplicates.add(1);
        withDuplicates.add(4);

        System.out.println("With duplicates: " + withDuplicates);
        List<Integer> unique = removeDuplicates(withDuplicates);
        System.out.println("Without duplicates: " + unique);

        // Example 2: Find common elements
        List<String> list1Ex = new ArrayList<>();
        list1Ex.add("A");
        list1Ex.add("B");
        list1Ex.add("C");
        list1Ex.add("D");

        List<String> list2Ex = new ArrayList<>();
        list2Ex.add("C");
        list2Ex.add("D");
        list2Ex.add("E");
        list2Ex.add("F");

        List<String> common = findCommon(list1Ex, list2Ex);
        System.out.println("\nList 1: " + list1Ex);
        System.out.println("List 2: " + list2Ex);
        System.out.println("Common elements: " + common);

        // Example 3: Merge and sort
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        l1.add(5);

        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(4);
        l2.add(6);

        List<Integer> merged = mergeAndSort(l1, l2);
        System.out.println("\nMerged and sorted: " + merged);

        // Example 4: Student management
        System.out.println("\n--- Student Management Example ---");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        students.add(new Student("Diana", 95));

        System.out.println("\nAll students:");
        students.forEach(System.out::println);

        // Sort by score
        students.sort(Comparator.comparingInt(s -> s.score));
        System.out.println("\nSorted by score:");
        students.forEach(System.out::println);

        // Sort by name
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nSorted by name:");
        students.forEach(System.out::println);


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // Helper method to remove duplicates
    static <T> List<T> removeDuplicates(List<T> list) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Helper method to find common elements
    static <T> List<T> findCommon(List<T> list1, List<T> list2) {
        List<T> common = new ArrayList<>(list1);
        common.retainAll(list2);
        return common;
    }

    // Helper method to merge and sort
    static <T extends Comparable<T>> List<T> mergeAndSort(List<T> list1, List<T> list2) {
        List<T> merged = new ArrayList<>(list1);
        merged.addAll(list2);
        Collections.sort(merged);
        return merged;
    }
}

// Student class for example
class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}

/*
 * ARRAYLIST QUICK REFERENCE:
 *
 * CREATION:
 * List<Type> list = new ArrayList<>();
 * List<Type> list = new ArrayList<>(initialCapacity);
 * List<Type> list = new ArrayList<>(collection);
 *
 * COMMON METHODS:
 * add(element)              - Add to end
 * add(index, element)       - Add at index
 * get(index)                - Get element
 * set(index, element)       - Update element
 * remove(index)             - Remove by index
 * remove(object)            - Remove by value
 * contains(object)          - Check if exists
 * indexOf(object)           - Get index
 * size()                    - Get size
 * isEmpty()                 - Check if empty
 * clear()                   - Remove all
 * toArray()                 - Convert to array
 *
 * JAVA 8+ METHODS:
 * forEach(action)           - Iterate with lambda
 * removeIf(predicate)       - Remove matching
 * replaceAll(operator)      - Transform all
 * sort(comparator)          - Sort with comparator
 *
 * COLLECTIONS UTILITY:
 * Collections.sort(list)           - Sort
 * Collections.reverse(list)        - Reverse
 * Collections.shuffle(list)        - Shuffle
 * Collections.binarySearch(list, key) - Binary search
 * Collections.max(list)            - Maximum
 * Collections.min(list)            - Minimum
 *
 * ADVANTAGES:
 * ✅ Dynamic size
 * ✅ Fast random access O(1)
 * ✅ Rich API with many methods
 * ✅ Type-safe with generics
 * ✅ Supports null values
 *
 * DISADVANTAGES:
 * ❌ Slow insertion/deletion in middle O(n)
 * ❌ Higher memory overhead than arrays
 * ❌ Not synchronized (use Collections.synchronizedList())
 *
 * WHEN TO USE:
 * - Need dynamic sizing
 * - Frequent random access
 * - Iteration and searching
 * - Sorting and filtering
 *
 * HOW TO RUN:
 * javac ArrayListDemo.java
 * java ArrayListDemo
 */
