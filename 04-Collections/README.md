# Module 4: Collections Framework 📦

Welcome to Module 4! Here you'll master Java's Collections Framework - one of the most important topics for any Java developer.

## 📖 Topics Covered

1. **Arrays** - Fixed-size data structures
2. **ArrayList** - Dynamic resizable arrays
3. **LinkedList** - Doubly linked list implementation
4. **HashMap** - Key-value pair storage
5. **HashSet** - Unique element storage
6. **TreeMap & TreeSet** - Sorted collections
7. **Queue & Deque** - FIFO and LIFO structures
8. **Stack** - LIFO operations
9. **Collections Utility** - Helper methods
10. **Comparable & Comparator** - Custom sorting

## 🎯 Learning Objectives

By the end of this module, you will:
- Understand different collection types and when to use each
- Master ArrayList, HashMap, and HashSet operations
- Implement custom sorting with Comparable and Comparator
- Work with iterators and enhanced for loops
- Use Collections utility methods effectively
- Choose the right collection for specific problems
- Understand time complexity of operations
- Handle thread-safe collections

## 📝 Programs in This Module

### 1. ArraysBasics.java
Introduction to arrays in Java - the foundation of collections.

**Concepts**: Array declaration, initialization, multi-dimensional arrays, common operations

### 2. ArrayListDemo.java
Dynamic arrays that can grow and shrink.

**Concepts**: Adding, removing, searching, iterating, ArrayList methods

### 3. LinkedListDemo.java
Doubly linked list for efficient insertions/deletions.

**Concepts**: LinkedList operations, comparison with ArrayList, Queue operations

### 4. HashMapDemo.java
Hash table implementation for key-value storage.

**Concepts**: put, get, remove, iteration, keySet, values, entrySet

### 5. HashSetDemo.java
Set implementation that doesn't allow duplicates.

**Concepts**: add, remove, contains, set operations (union, intersection)

### 6. TreeMapTreeSet.java
Sorted collections using Red-Black tree.

**Concepts**: Natural ordering, sorted operations, navigable methods

### 7. QueueDeque.java
Queue (FIFO) and Deque (double-ended queue) implementations.

**Concepts**: offer, poll, peek, priority queues, ArrayDeque

### 8. StackDemo.java
Last-In-First-Out (LIFO) data structure.

**Concepts**: push, pop, peek, stack applications

### 9. IteratorsDemo.java
Different ways to iterate through collections.

**Concepts**: Iterator, ListIterator, Enumeration, forEach

### 10. ComparableComparator.java
Custom sorting of objects.

**Concepts**: Comparable interface, Comparator interface, multiple sort criteria

### 11. CollectionsUtility.java
Utility methods for collection manipulation.

**Concepts**: sort, shuffle, reverse, binarySearch, synchronizedList

### 12. CollectionsProject.java
Complete student management system using multiple collections.

**Concepts**: Integrating multiple collections, real-world application

## 💡 Key Concepts

### Collection Hierarchy

```
Collection (Interface)
├── List (Interface)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector (Legacy)
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (Interface)
    ├── PriorityQueue
    └── Deque (Interface)
        ├── ArrayDeque
        └── LinkedList

Map (Interface) - Separate hierarchy
├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable (Legacy)
```

### When to Use Which Collection?

| Collection | Use When | Time Complexity |
|------------|----------|-----------------|
| **ArrayList** | Random access, iteration | O(1) access, O(n) insert |
| **LinkedList** | Frequent insertions/deletions | O(1) insert, O(n) access |
| **HashMap** | Key-value pairs, fast lookup | O(1) average |
| **HashSet** | Unique elements, fast lookup | O(1) average |
| **TreeMap** | Sorted key-value pairs | O(log n) |
| **TreeSet** | Sorted unique elements | O(log n) |
| **PriorityQueue** | Priority-based processing | O(log n) |
| **ArrayDeque** | Stack/Queue operations | O(1) |

### List vs Set vs Map

**List**:
- Ordered collection
- Allows duplicates
- Access by index
- Examples: ArrayList, LinkedList

**Set**:
- Unordered collection (except TreeSet)
- No duplicates
- No index access
- Examples: HashSet, TreeSet

**Map**:
- Key-value pairs
- Keys must be unique
- Values can be duplicates
- Examples: HashMap, TreeMap

### ArrayList vs LinkedList

**ArrayList**:
- ✅ Fast random access O(1)
- ✅ Fast iteration
- ✅ Less memory overhead
- ❌ Slow insertion/deletion in middle O(n)

**LinkedList**:
- ✅ Fast insertion/deletion O(1)
- ✅ Implements Queue operations
- ❌ Slow random access O(n)
- ❌ More memory (stores pointers)

### HashMap vs TreeMap vs LinkedHashMap

**HashMap**:
- ✅ Fastest operations O(1)
- ❌ No ordering guarantee
- ✅ Allows one null key

**TreeMap**:
- ✅ Sorted by keys
- ✅ NavigableMap operations
- ❌ Slower O(log n)
- ❌ No null keys

**LinkedHashMap**:
- ✅ Maintains insertion order
- ✅ Similar performance to HashMap
- ✅ Predictable iteration order

## 🔍 Common Operations Cheat Sheet

### ArrayList
```java
List<String> list = new ArrayList<>();
list.add("item");              // Add
list.add(0, "first");          // Add at index
list.get(0);                   // Get
list.set(0, "updated");        // Update
list.remove(0);                // Remove by index
list.remove("item");           // Remove by value
list.contains("item");         // Check contains
list.size();                   // Size
list.clear();                  // Clear all
```

### HashMap
```java
Map<String, Integer> map = new HashMap<>();
map.put("key", 100);          // Put
map.get("key");               // Get
map.remove("key");            // Remove
map.containsKey("key");       // Check key
map.containsValue(100);       // Check value
map.keySet();                 // All keys
map.values();                 // All values
map.entrySet();               // All entries
```

### HashSet
```java
Set<String> set = new HashSet<>();
set.add("item");              // Add
set.remove("item");           // Remove
set.contains("item");         // Check
set.size();                   // Size
set.clear();                  // Clear
```

## 🎓 Practice Exercises

### Exercise 1: Student Grade Manager
Create a program that:
- Stores student names and grades in HashMap
- Calculates class average
- Finds highest and lowest scores
- Lists students by grade range

### Exercise 2: Unique Word Counter
Write a program that:
- Reads text input
- Counts unique words using HashSet
- Displays word frequency using HashMap
- Ignores case and punctuation

### Exercise 3: Phone Book Application
Build a phone book that:
- Uses HashMap to store contacts
- Supports add, search, update, delete
- Allows searching by partial name
- Displays all contacts sorted

### Exercise 4: Shopping Cart
Implement a shopping cart:
- Product class with name, price, quantity
- Use ArrayList to store cart items
- Calculate total price
- Apply discount codes
- Generate receipt

### Exercise 5: Playlist Manager
Create a music playlist:
- Use LinkedList for song order
- Add songs at beginning/end/position
- Remove songs
- Shuffle playlist
- Display current playlist

### Exercise 6: To-Do List with Priority
Build a to-do list:
- Use PriorityQueue for tasks
- Each task has priority (1-5)
- Automatically processes high priority first
- Mark tasks as complete
- View pending tasks

### Exercise 7: Duplicate Remover
Write a program that:
- Takes ArrayList with duplicates
- Returns ArrayList without duplicates
- Preserves original order
- Compare performance with HashSet

### Exercise 8: Sorted Leaderboard
Create a game leaderboard:
- Use TreeMap to store player scores
- Automatically sorts by score
- Display top 10 players
- Update player scores
- Handle ties

### Exercise 9: Inventory System
Build an inventory manager:
- Product ID as key, Product object as value
- Track stock levels
- Alert when stock is low
- Generate inventory reports
- Support searching and filtering

### Exercise 10: Collection Performance Comparison
Create a benchmark program:
- Compare ArrayList vs LinkedList operations
- Time add, remove, access operations
- Display results in table format
- Analyze when to use which

## 🐛 Common Mistakes to Avoid

1. **Using raw types** instead of generics
   ```java
   // ❌ Wrong
   ArrayList list = new ArrayList();
   
   // ✅ Correct
   ArrayList<String> list = new ArrayList<>();
   ```

2. **Modifying collection while iterating**
   ```java
   // ❌ Wrong - ConcurrentModificationException
   for (String item : list) {
       if (item.equals("remove")) {
           list.remove(item);
       }
   }
   
   // ✅ Correct
   Iterator<String> it = list.iterator();
   while (it.hasNext()) {
       if (it.next().equals("remove")) {
           it.remove();
       }
   }
   ```

3. **Using == instead of equals() for comparison**
4. **Not overriding hashCode() when overriding equals()**
5. **Using ArrayList when LinkedList would be better (or vice versa)**
6. **Not specifying initial capacity for large collections**
7. **Using Vector/Hashtable instead of ArrayList/HashMap**
8. **Forgetting that HashMap allows null keys/values**

## 💎 Best Practices

1. **Use interface types for declarations**
   ```java
   List<String> list = new ArrayList<>();  // ✅
   ArrayList<String> list = new ArrayList<>();  // ❌
   ```

2. **Specify initial capacity if size is known**
   ```java
   List<String> list = new ArrayList<>(1000);
   ```

3. **Use appropriate collection for the task**
   - Need fast random access? → ArrayList
   - Need unique elements? → HashSet
   - Need sorted data? → TreeSet/TreeMap
   - Need FIFO? → Queue

4. **Use Collections utility methods**
   ```java
   Collections.sort(list);
   Collections.reverse(list);
   Collections.shuffle(list);
   ```

5. **Consider thread safety**
   - Single thread: Regular collections
   - Multi-thread: ConcurrentHashMap, CopyOnWriteArrayList

6. **Override equals() and hashCode() properly**
7. **Use enhanced for loop when possible**
8. **Close resources properly (Java 7+ try-with-resources)**

## 📊 Time Complexity Reference

| Operation | ArrayList | LinkedList | HashMap | TreeMap | HashSet |
|-----------|-----------|------------|---------|---------|---------|
| Add | O(1)* | O(1) | O(1) | O(log n) | O(1) |
| Remove | O(n) | O(1)** | O(1) | O(log n) | O(1) |
| Get | O(1) | O(n) | O(1) | O(log n) | N/A |
| Contains | O(n) | O(n) | O(1) | O(log n) | O(1) |
| Iterate | O(n) | O(n) | O(n) | O(n) | O(n) |

\* Amortized, O(n) when resizing  
\** O(1) if you have reference to node

## 🔗 What's Next?

After mastering collections, you'll move on to:
- **Module 5: Exception Handling** - Robust error handling
- Advanced collection topics in Module 10

## 📖 Additional Resources

- [Collections Framework Overview (Oracle)](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Java Collections Tutorial](https://docs.oracle.com/javase/tutorial/collections/)
- [Collection Interface Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collection.html)
- [Effective Java - Chapter on Collections](https://www.oreilly.com/library/view/effective-java/9780134686097/)

## 💡 Pro Tips

1. **Use diamond operator** (`<>`) for cleaner code
2. **Prefer ArrayList** unless you have specific reason for LinkedList
3. **Use HashMap** as default Map implementation
4. **Use EnumSet and EnumMap** when working with enums
5. **Consider immutable collections** for thread safety
6. **Use streams** (Module 9) for complex collection operations

---

**Ready to master collections? Start with ArraysBasics.java!** 🚀

**Estimated Time**: 4-6 days | **Difficulty**: ⭐⭐⭐ Intermediate