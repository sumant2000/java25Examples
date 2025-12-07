/**
 * StringOperations.java
 *
 * This program demonstrates various String operations and methods in Java.
 * Strings are immutable sequences of characters and one of the most
 * commonly used data types in Java.
 *
 * Key Concepts:
 * - String creation
 * - String methods
 * - String concatenation
 * - String comparison
 * - String manipulation
 */

public class StringOperations {

    public static void main(String[] args) {

        System.out.println("========== STRING OPERATIONS DEMONSTRATION ==========\n");

        // ========== STRING CREATION ==========

        System.out.println("--- 1. String Creation ---\n");

        // String literal
        String str1 = "Hello, World!";
        System.out.println("String literal: " + str1);

        // Using new keyword
        String str2 = new String("Java Programming");
        System.out.println("Using new keyword: " + str2);

        // Empty string
        String empty = "";
        System.out.println("Empty string: \"" + empty + "\"");

        // From character array
        char[] charArray = {'J', 'a', 'v', 'a'};
        String str3 = new String(charArray);
        System.out.println("From char array: " + str3);


        // ========== STRING LENGTH ==========

        System.out.println("\n\n--- 2. String Length ---\n");

        String text = "Java Programming";
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Length: " + text.length());

        String empty2 = "";
        System.out.println("Empty string length: " + empty2.length());


        // ========== STRING CONCATENATION ==========

        System.out.println("\n\n--- 3. String Concatenation ---\n");

        String firstName = "John";
        String lastName = "Doe";

        // Using + operator
        String fullName1 = firstName + " " + lastName;
        System.out.println("Using + operator: " + fullName1);

        // Using concat() method
        String fullName2 = firstName.concat(" ").concat(lastName);
        System.out.println("Using concat(): " + fullName2);

        // Concatenating with numbers
        String message = "I am " + 25 + " years old";
        System.out.println(message);

        // Multiple concatenations
        String address = "City: " + "New York" + ", ZIP: " + 10001;
        System.out.println(address);


        // ========== CHARACTER ACCESS ==========

        System.out.println("\n\n--- 4. Character Access ---\n");

        String word = "Programming";
        System.out.println("Word: " + word);

        // charAt() - get character at specific index (0-based)
        System.out.println("Character at index 0: " + word.charAt(0));
        System.out.println("Character at index 5: " + word.charAt(5));
        System.out.println("Last character: " + word.charAt(word.length() - 1));


        // ========== SUBSTRING ==========

        System.out.println("\n\n--- 5. Substring ---\n");

        String sentence = "Java is awesome!";
        System.out.println("Original: " + sentence);

        // substring(startIndex) - from start to end
        System.out.println("substring(5): " + sentence.substring(5));

        // substring(startIndex, endIndex) - from start to end-1
        System.out.println("substring(0, 4): " + sentence.substring(0, 4));
        System.out.println("substring(5, 7): " + sentence.substring(5, 7));


        // ========== STRING COMPARISON ==========

        System.out.println("\n\n--- 6. String Comparison ---\n");

        String s1 = "Java";
        String s2 = "Java";
        String s3 = "java";
        String s4 = new String("Java");

        // Using equals() - compares content
        System.out.println("s1.equals(s2): " + s1.equals(s2));           // true
        System.out.println("s1.equals(s3): " + s1.equals(s3));           // false (case-sensitive)
        System.out.println("s1.equals(s4): " + s1.equals(s4));           // true

        // Using equalsIgnoreCase() - ignores case
        System.out.println("s1.equalsIgnoreCase(s3): " + s1.equalsIgnoreCase(s3)); // true

        // Using == (compares references, NOT content!)
        System.out.println("s1 == s2: " + (s1 == s2));                   // true (string pool)
        System.out.println("s1 == s4: " + (s1 == s4));                   // false (different objects)

        // compareTo() - lexicographic comparison
        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));     // 0 (equal)
        System.out.println("\"Apple\".compareTo(\"Banana\"): " + "Apple".compareTo("Banana")); // negative


        // ========== CASE CONVERSION ==========

        System.out.println("\n\n--- 7. Case Conversion ---\n");

        String original = "Hello World";
        System.out.println("Original: " + original);
        System.out.println("toUpperCase(): " + original.toUpperCase());
        System.out.println("toLowerCase(): " + original.toLowerCase());
        System.out.println("Original unchanged: " + original); // Strings are immutable!


        // ========== TRIMMING AND STRIPPING ==========

        System.out.println("\n\n--- 8. Trimming Whitespace ---\n");

        String withSpaces = "   Java Programming   ";
        System.out.println("Original: \"" + withSpaces + "\"");
        System.out.println("trim(): \"" + withSpaces.trim() + "\"");
        System.out.println("strip(): \"" + withSpaces.strip() + "\"");


        // ========== SEARCHING ==========

        System.out.println("\n\n--- 9. Searching in Strings ---\n");

        String searchText = "Java is fun. Java is powerful.";
        System.out.println("Text: " + searchText);

        // indexOf() - first occurrence
        System.out.println("indexOf('a'): " + searchText.indexOf('a'));
        System.out.println("indexOf(\"Java\"): " + searchText.indexOf("Java"));
        System.out.println("indexOf(\"Java\", 5): " + searchText.indexOf("Java", 5)); // from index 5

        // lastIndexOf() - last occurrence
        System.out.println("lastIndexOf(\"Java\"): " + searchText.lastIndexOf("Java"));

        // contains()
        System.out.println("contains(\"fun\"): " + searchText.contains("fun"));
        System.out.println("contains(\"easy\"): " + searchText.contains("easy"));


        // ========== STARTS WITH / ENDS WITH ==========

        System.out.println("\n\n--- 10. Prefix and Suffix ---\n");

        String filename = "document.pdf";
        System.out.println("Filename: " + filename);
        System.out.println("startsWith(\"doc\"): " + filename.startsWith("doc"));
        System.out.println("endsWith(\".pdf\"): " + filename.endsWith(".pdf"));
        System.out.println("endsWith(\".txt\"): " + filename.endsWith(".txt"));


        // ========== REPLACE ==========

        System.out.println("\n\n--- 11. Replace ---\n");

        String replaceText = "I love Python. Python is great!";
        System.out.println("Original: " + replaceText);

        // replace() - replaces all occurrences
        String replaced = replaceText.replace("Python", "Java");
        System.out.println("After replace: " + replaced);

        // replaceFirst() - replaces first occurrence
        String replacedFirst = replaceText.replaceFirst("Python", "Java");
        System.out.println("After replaceFirst: " + replacedFirst);

        // replaceAll() - with regex
        String numbers = "123-456-7890";
        String noHyphens = numbers.replaceAll("-", "");
        System.out.println("Remove hyphens: " + noHyphens);


        // ========== SPLITTING ==========

        System.out.println("\n\n--- 12. Split ---\n");

        String csv = "Apple,Banana,Cherry,Date";
        System.out.println("CSV: " + csv);

        String[] fruits = csv.split(",");
        System.out.println("Split result:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  [" + i + "] = " + fruits[i]);
        }

        // Splitting by space
        String words = "Java is awesome";
        String[] wordArray = words.split(" ");
        System.out.println("\nSplit by space: " + java.util.Arrays.toString(wordArray));


        // ========== JOINING ==========

        System.out.println("\n\n--- 13. Join ---\n");

        String[] languages = {"Java", "Python", "C++", "JavaScript"};
        String joined = String.join(", ", languages);
        System.out.println("Joined: " + joined);

        String hyphenJoined = String.join("-", "2024", "01", "15");
        System.out.println("Date: " + hyphenJoined);


        // ========== CHECKING STRING PROPERTIES ==========

        System.out.println("\n\n--- 14. String Properties ---\n");

        String emptyStr = "";
        String blankStr = "   ";
        String normalStr = "Hello";

        System.out.println("isEmpty():");
        System.out.println("  \"\" is empty: " + emptyStr.isEmpty());
        System.out.println("  \"   \" is empty: " + blankStr.isEmpty());
        System.out.println("  \"Hello\" is empty: " + normalStr.isEmpty());

        System.out.println("\nisBlank() [Java 11+]:");
        System.out.println("  \"\" is blank: " + emptyStr.isBlank());
        System.out.println("  \"   \" is blank: " + blankStr.isBlank());
        System.out.println("  \"Hello\" is blank: " + normalStr.isBlank());


        // ========== STRING BUILDER (MUTABLE STRINGS) ==========

        System.out.println("\n\n--- 15. StringBuilder (Mutable) ---\n");

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Initial: " + sb);

        // append()
        sb.append(" World");
        System.out.println("After append: " + sb);

        // insert()
        sb.insert(5, ",");
        System.out.println("After insert: " + sb);

        // delete()
        sb.delete(5, 6);
        System.out.println("After delete: " + sb);

        // reverse()
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // Convert to String
        String result = sb.toString();
        System.out.println("Convert to String: " + result);


        // ========== FORMAT STRINGS ==========

        System.out.println("\n\n--- 16. String Formatting ---\n");

        String name = "Alice";
        int age = 25;
        double salary = 50000.50;

        // Using String.format()
        String formatted = String.format("Name: %s, Age: %d, Salary: $%.2f", name, age, salary);
        System.out.println(formatted);

        // Using printf()
        System.out.printf("Hello, %s! You are %d years old.%n", name, age);


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("\n\n--- 17. Practical Examples ---\n");

        // Example 1: Email validation
        String email = "user@example.com";
        boolean isValidEmail = email.contains("@") && email.contains(".");
        System.out.println("Email: " + email + " is valid? " + isValidEmail);

        // Example 2: Extract file extension
        String file = "report.pdf";
        int dotIndex = file.lastIndexOf(".");
        String extension = file.substring(dotIndex + 1);
        System.out.println("File extension: " + extension);

        // Example 3: Palindrome check
        String palindrome = "madam";
        String reversed = new StringBuilder(palindrome).reverse().toString();
        boolean isPalindrome = palindrome.equals(reversed);
        System.out.println(palindrome + " is palindrome? " + isPalindrome);

        // Example 4: Count vowels
        String testStr = "Hello World";
        int vowelCount = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < testStr.length(); i++) {
            if (vowels.indexOf(testStr.charAt(i)) != -1) {
                vowelCount++;
            }
        }
        System.out.println("Vowels in \"" + testStr + "\": " + vowelCount);

        // Example 5: Remove all spaces
        String withSpaces2 = "J a v a   P r o g r a m";
        String noSpaces = withSpaces2.replaceAll(" ", "");
        System.out.println("Remove spaces: " + noSpaces);


        System.out.println("\n\n========== END OF DEMONSTRATION ==========");
    }
}

/*
 * COMMONLY USED STRING METHODS:
 *
 * Length & Access:
 * - length()               : Returns length of string
 * - charAt(index)          : Returns character at index
 * - isEmpty()              : Checks if string is empty
 * - isBlank()              : Checks if string is empty or whitespace
 *
 * Searching:
 * - indexOf(str)           : Returns first index of substring
 * - lastIndexOf(str)       : Returns last index of substring
 * - contains(str)          : Checks if string contains substring
 * - startsWith(str)        : Checks if starts with substring
 * - endsWith(str)          : Checks if ends with substring
 *
 * Comparison:
 * - equals(str)            : Compares content (case-sensitive)
 * - equalsIgnoreCase(str)  : Compares content (case-insensitive)
 * - compareTo(str)         : Lexicographic comparison
 *
 * Modification (returns new String):
 * - toUpperCase()          : Converts to uppercase
 * - toLowerCase()          : Converts to lowercase
 * - trim()                 : Removes leading/trailing whitespace
 * - strip()                : Removes leading/trailing whitespace (Unicode-aware)
 * - substring(start)       : Returns substring from start to end
 * - substring(start, end)  : Returns substring from start to end-1
 * - replace(old, new)      : Replaces all occurrences
 * - replaceFirst(old, new) : Replaces first occurrence
 * - replaceAll(regex, new) : Replaces using regex
 *
 * Splitting & Joining:
 * - split(delimiter)       : Splits string into array
 * - String.join(delimiter, elements) : Joins elements with delimiter
 *
 * Conversion:
 * - toString()             : Returns string representation
 * - toCharArray()          : Converts to character array
 * - String.valueOf(x)      : Converts any type to String
 *
 * IMPORTANT NOTES:
 *
 * 1. Strings are IMMUTABLE - cannot be changed once created
 * 2. All string methods return NEW strings, don't modify original
 * 3. Use equals() for comparison, NOT ==
 * 4. String pool: Literals share same object if content is same
 * 5. For frequent modifications, use StringBuilder or StringBuffer
 * 6. String indices are 0-based
 *
 * STRING vs STRINGBUILDER:
 * - String: Immutable, thread-safe, slower for concatenation
 * - StringBuilder: Mutable, not thread-safe, faster for concatenation
 * - StringBuffer: Mutable, thread-safe, slower than StringBuilder
 *
 * HOW TO RUN:
 * javac StringOperations.java
 * java StringOperations
 */
