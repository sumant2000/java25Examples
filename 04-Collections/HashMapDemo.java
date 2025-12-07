/**
 * HashMapDemo.java
 *
 * This program demonstrates HashMap - a hash table implementation of the Map interface.
 * HashMap stores key-value pairs and provides constant-time performance for basic operations.
 *
 * Key Concepts:
 * - HashMap creation and initialization
 * - Adding, retrieving, and removing entries
 * - Iterating through HashMap
 * - Key, value, and entry sets
 * - HashMap methods and operations
 * - Handling null keys and values
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;

public class HashMapDemo {

    public static void main(String[] args) {

        System.out.println("========== HASHMAP DEMONSTRATION ==========\n");

        // ========== CREATING HASHMAP ==========

        System.out.println("--- 1. Creating HashMap ---\n");

        // Empty HashMap
        Map<String, Integer> map1 = new HashMap<>();
        System.out.println("Empty HashMap created: " + map1);

        // HashMap with initial capacity
        Map<String, Integer> map2 = new HashMap<>(16);
        System.out.println("HashMap with initial capacity created");

        // HashMap with initial capacity and load factor
        Map<String, Integer> map3 = new HashMap<>(16, 0.75f);
        System.out.println("HashMap with capacity and load factor created");

        // HashMap from another map
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        Map<String, Integer> copy = new HashMap<>(original);
        System.out.println("HashMap from another map: " + copy);


        // ========== ADDING ENTRIES ==========

        System.out.println("\n\n--- 2. Adding Entries (put) ---\n");

        Map<String, Integer> ages = new HashMap<>();

        // Add key-value pairs
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 28);
        System.out.println("After adding entries: " + ages);

        // Update value (key already exists)
        ages.put("Alice", 26);
        System.out.println("After updating Alice's age: " + ages);

        // putIfAbsent - only adds if key doesn't exist
        ages.putIfAbsent("Alice", 27); // Won't update
        ages.putIfAbsent("Diana", 24); // Will add
        System.out.println("After putIfAbsent: " + ages);

        // putAll - add all entries from another map
        Map<String, Integer> moreAges = new HashMap<>();
        moreAges.put("Eve", 29);
        moreAges.put("Frank", 31);
        ages.putAll(moreAges);
        System.out.println("After putAll: " + ages);


        // ========== RETRIEVING VALUES ==========

        System.out.println("\n\n--- 3. Retrieving Values (get) ---\n");

        Map<String, String> capitals = new HashMap<>();
        capitals.put("USA", "Washington DC");
        capitals.put("UK", "London");
        capitals.put("France", "Paris");
        capitals.put("Germany", "Berlin");
        capitals.put("Japan", "Tokyo");

        System.out.println("Capitals map: " + capitals);

        // Get value by key
        System.out.println("\nCapital of USA: " + capitals.get("USA"));
        System.out.println("Capital of France: " + capitals.get("France"));

        // Get returns null if key doesn't exist
        System.out.println("Capital of India: " + capitals.get("India"));

        // getOrDefault - returns default value if key not found
        System.out.println("Capital of India (with default): " +
                          capitals.getOrDefault("India", "Not Found"));


        // ========== CHECKING EXISTENCE ==========

        System.out.println("\n\n--- 4. Checking Existence ---\n");

        Map<String, Double> prices = new HashMap<>();
        prices.put("Apple", 1.99);
        prices.put("Banana", 0.99);
        prices.put("Cherry", 2.99);

        System.out.println("Prices: " + prices);

        // containsKey - check if key exists
        System.out.println("\nContains 'Apple': " + prices.containsKey("Apple"));
        System.out.println("Contains 'Mango': " + prices.containsKey("Mango"));

        // containsValue - check if value exists
        System.out.println("\nContains value 0.99: " + prices.containsValue(0.99));
        System.out.println("Contains value 5.99: " + prices.containsValue(5.99));

        // isEmpty and size
        System.out.println("\nIs empty: " + prices.isEmpty());
        System.out.println("Size: " + prices.size());


        // ========== REMOVING ENTRIES ==========

        System.out.println("\n\n--- 5. Removing Entries ---\n");

        Map<Integer, String> students = new HashMap<>();
        students.put(101, "Alice");
        students.put(102, "Bob");
        students.put(103, "Charlie");
        students.put(104, "Diana");
        students.put(105, "Eve");

        System.out.println("Original students: " + students);

        // Remove by key
        String removed = students.remove(103);
        System.out.println("Removed student: " + removed);
        System.out.println("After removal: " + students);

        // Remove with value check (Java 8+)
        boolean wasRemoved = students.remove(102, "Bob");
        System.out.println("Was Bob removed: " + wasRemoved);
        System.out.println("After conditional removal: " + students);

        // Clear all entries
        Map<String, Integer> temp = new HashMap<>();
        temp.put("A", 1);
        temp.put("B", 2);
        System.out.println("\nBefore clear: " + temp);
        temp.clear();
        System.out.println("After clear: " + temp);


        // ========== ITERATING THROUGH HASHMAP ==========

        System.out.println("\n\n--- 6. Iterating Through HashMap ---\n");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Math", 85);
        scores.put("Science", 92);
        scores.put("English", 78);
        scores.put("History", 88);

        // Iterate through keys
        System.out.println("Iterating through keys:");
        for (String subject : scores.keySet()) {
            System.out.println(subject + ": " + scores.get(subject));
        }

        // Iterate through values
        System.out.println("\nIterating through values:");
        for (Integer score : scores.values()) {
            System.out.println("Score: " + score);
        }

        // Iterate through entries (most efficient)
        System.out.println("\nIterating through entries:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Using forEach with lambda (Java 8+)
        System.out.println("\nUsing forEach with lambda:");
        scores.forEach((subject, score) ->
            System.out.println(subject + " = " + score));

        // Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        // ========== KEYSET, VALUES, ENTRYSET ==========

        System.out.println("\n\n--- 7. KeySet, Values, EntrySet ---\n");

        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("Alice", "555-1234");
        phonebook.put("Bob", "555-5678");
        phonebook.put("Charlie", "555-9012");

        System.out.println("Phonebook: " + phonebook);

        // Get all keys
        Set<String> names = phonebook.keySet();
        System.out.println("\nAll names (keys): " + names);

        // Get all values
        Collection<String> numbers = phonebook.values();
        System.out.println("All numbers (values): " + numbers);

        // Get all entries
        Set<Map.Entry<String, String>> entries = phonebook.entrySet();
        System.out.println("All entries: " + entries);


        // ========== ADVANCED OPERATIONS (JAVA 8+) ==========

        System.out.println("\n\n--- 8. Advanced Operations (Java 8+) ---\n");

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apples", 50);
        inventory.put("Bananas", 30);
        inventory.put("Oranges", 25);

        System.out.println("Initial inventory: " + inventory);

        // compute - compute new value for key
        inventory.compute("Apples", (key, value) -> value == null ? 10 : value + 10);
        System.out.println("After adding 10 apples: " + inventory);

        // computeIfAbsent - compute value only if key is absent
        inventory.computeIfAbsent("Grapes", key -> 15);
        System.out.println("After adding Grapes: " + inventory);

        // computeIfPresent - compute value only if key exists
        inventory.computeIfPresent("Bananas", (key, value) -> value - 5);
        System.out.println("After removing 5 Bananas: " + inventory);

        // merge - merge new value with existing value
        inventory.merge("Apples", 20, (oldVal, newVal) -> oldVal + newVal);
        inventory.merge("Mangoes", 40, (oldVal, newVal) -> oldVal + newVal);
        System.out.println("After merge operations: " + inventory);

        // replace - replace value for key
        inventory.replace("Oranges", 35);
        System.out.println("After replacing Oranges: " + inventory);

        // replace with value check
        inventory.replace("Apples", 80, 100); // only if current value is 80
        System.out.println("After conditional replace: " + inventory);

        // replaceAll - replace all values
        Map<String, Integer> numbers2 = new HashMap<>();
        numbers2.put("One", 1);
        numbers2.put("Two", 2);
        numbers2.put("Three", 3);
        System.out.println("\nOriginal numbers: " + numbers2);
        numbers2.replaceAll((key, value) -> value * 10);
        System.out.println("After multiplying by 10: " + numbers2);


        // ========== NULL HANDLING ==========

        System.out.println("\n\n--- 9. Null Handling ---\n");

        Map<String, String> nullMap = new HashMap<>();

        // HashMap allows one null key
        nullMap.put(null, "NullKeyValue");
        System.out.println("HashMap with null key: " + nullMap);

        // HashMap allows multiple null values
        nullMap.put("Key1", null);
        nullMap.put("Key2", null);
        nullMap.put("Key3", "Value3");
        System.out.println("HashMap with null values: " + nullMap);

        // Getting null key
        System.out.println("Value for null key: " + nullMap.get(null));


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 10. Practical Examples ---\n");

        // Example 1: Word frequency counter
        String text = "java is great java is powerful java is fun";
        Map<String, Integer> wordCount = countWords(text);
        System.out.println("Word frequency: " + wordCount);

        // Example 2: Character frequency
        String str = "hello world";
        Map<Character, Integer> charCount = countCharacters(str);
        System.out.println("\nCharacter frequency in '" + str + "': " + charCount);

        // Example 3: Grade book
        Map<String, Integer> gradeBook = new HashMap<>();
        gradeBook.put("Alice", 85);
        gradeBook.put("Bob", 92);
        gradeBook.put("Charlie", 78);
        gradeBook.put("Diana", 95);
        gradeBook.put("Eve", 88);

        System.out.println("\nGrade Book: " + gradeBook);
        System.out.println("Average grade: " + calculateAverage(gradeBook));
        System.out.println("Highest grade: " + findHighestGrade(gradeBook));
        System.out.println("Students above 85: " + findStudentsAboveThreshold(gradeBook, 85));

        // Example 4: Group by first letter
        String[] namesList = {"Alice", "Bob", "Charlie", "Anna", "David", "Alex"};
        Map<Character, Integer> groupedByLetter = groupByFirstLetter(namesList);
        System.out.println("\nGrouped by first letter: " + groupedByLetter);

        // Example 5: Merge two maps
        Map<String, Integer> map1Ex = new HashMap<>();
        map1Ex.put("A", 1);
        map1Ex.put("B", 2);
        map1Ex.put("C", 3);

        Map<String, Integer> map2Ex = new HashMap<>();
        map2Ex.put("B", 20);
        map2Ex.put("C", 30);
        map2Ex.put("D", 4);

        Map<String, Integer> merged = mergeMaps(map1Ex, map2Ex);
        System.out.println("\nMap 1: " + map1Ex);
        System.out.println("Map 2: " + map2Ex);
        System.out.println("Merged (sum values): " + merged);


        // ========== HASHMAP VS OTHER MAPS ==========

        System.out.println("\n\n--- 11. HashMap Characteristics ---\n");

        System.out.println("HashMap Characteristics:");
        System.out.println("✓ Fast operations O(1) average");
        System.out.println("✓ Allows one null key");
        System.out.println("✓ Allows multiple null values");
        System.out.println("✓ No ordering guarantee");
        System.out.println("✓ Not synchronized (use ConcurrentHashMap for thread safety)");
        System.out.println("✓ Best for: Fast lookups, no ordering needed");


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }

    // Helper method: Count word frequency
    static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    // Helper method: Count character frequency
    static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        return charCount;
    }

    // Helper method: Calculate average from grade book
    static double calculateAverage(Map<String, Integer> grades) {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Helper method: Find highest grade
    static String findHighestGrade(Map<String, Integer> grades) {
        String topStudent = null;
        int maxGrade = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            if (entry.getValue() > maxGrade) {
                maxGrade = entry.getValue();
                topStudent = entry.getKey();
            }
        }
        return topStudent + " with " + maxGrade;
    }

    // Helper method: Find students above threshold
    static int findStudentsAboveThreshold(Map<String, Integer> grades, int threshold) {
        int count = 0;
        for (int grade : grades.values()) {
            if (grade > threshold) {
                count++;
            }
        }
        return count;
    }

    // Helper method: Group names by first letter
    static Map<Character, Integer> groupByFirstLetter(String[] names) {
        Map<Character, Integer> grouped = new HashMap<>();
        for (String name : names) {
            char firstLetter = name.charAt(0);
            grouped.put(firstLetter, grouped.getOrDefault(firstLetter, 0) + 1);
        }
        return grouped;
    }

    // Helper method: Merge two maps (sum values for common keys)
    static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return result;
    }
}

/*
 * HASHMAP QUICK REFERENCE:
 *
 * CREATION:
 * Map<K, V> map = new HashMap<>();
 * Map<K, V> map = new HashMap<>(initialCapacity);
 * Map<K, V> map = new HashMap<>(map);
 *
 * COMMON METHODS:
 * put(key, value)           - Add/Update entry
 * get(key)                  - Get value
 * remove(key)               - Remove entry
 * containsKey(key)          - Check key exists
 * containsValue(value)      - Check value exists
 * size()                    - Get size
 * isEmpty()                 - Check if empty
 * clear()                   - Remove all
 * keySet()                  - Get all keys
 * values()                  - Get all values
 * entrySet()                - Get all entries
 *
 * JAVA 8+ METHODS:
 * putIfAbsent(key, value)          - Add if absent
 * getOrDefault(key, default)       - Get or default
 * compute(key, function)           - Compute new value
 * computeIfAbsent(key, function)   - Compute if absent
 * computeIfPresent(key, function)  - Compute if present
 * merge(key, value, function)      - Merge values
 * forEach(action)                  - Iterate with lambda
 * replace(key, value)              - Replace value
 * replaceAll(function)             - Replace all values
 *
 * ITERATION:
 * for (K key : map.keySet()) { }
 * for (V value : map.values()) { }
 * for (Map.Entry<K,V> entry : map.entrySet()) { }
 * map.forEach((k, v) -> { });
 *
 * TIME COMPLEXITY:
 * get()        - O(1) average, O(n) worst case
 * put()        - O(1) average, O(n) worst case
 * remove()     - O(1) average, O(n) worst case
 * containsKey()- O(1) average, O(n) worst case
 *
 * WHEN TO USE HASHMAP:
 * ✓ Need fast key-value lookups
 * ✓ Order doesn't matter
 * ✓ Keys are unique
 * ✓ Single-threaded environment
 *
 * IMPORTANT NOTES:
 * 1. Keys must be immutable or not modified after insertion
 * 2. Override equals() and hashCode() for custom key objects
 * 3. Allows one null key and multiple null values
 * 4. Not synchronized (use ConcurrentHashMap for thread safety)
 * 5. No ordering guarantee (use LinkedHashMap for insertion order)
 * 6. Initial capacity and load factor affect performance
 *
 * HOW TO RUN:
 * javac HashMapDemo.java
 * java HashMapDemo
 */
