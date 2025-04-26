package assignment3;

// Hash Table Test with 10,000 elements and distribution analysis
public class HashTableTest {
    public static void main(String[] args) {
        // Test with default constructor
        System.out.println("=== Testing MyHashTable with default constructor ===");
        testHashTableBasics(new MyHashTable<String, Integer>());

        // Test with custom size constructor
        System.out.println("\n=== Testing MyHashTable with custom size constructor ===");
        testHashTableBasics(new MyHashTable<String, Integer>(20));

        // Test with MyTestingClass keys
        System.out.println("\n=== Testing MyHashTable with custom key class ===");
        testWithCustomKeyClass();

        // Test distribution with many elements
        System.out.println("\n=== Testing distribution with 10,000 elements ===");
        testDistribution();
    }

    // Test basic operations of the hash table
    private static void testHashTableBasics(MyHashTable<String, Integer> table) {
        // Test put and get methods
        System.out.println("Testing put and get methods:");
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);
        table.put("four", 4);
        table.put("five", 5);

        System.out.println("Get 'one': " + table.get("one"));  // Should return 1
        System.out.println("Get 'two': " + table.get("two"));  // Should return 2
        System.out.println("Get 'six': " + table.get("six"));  // Should return null (not found)

        // Test update value
        System.out.println("\nTesting update value:");
        table.put("one", 10);
        System.out.println("Updated 'one' to 10, get 'one': " + table.get("one"));  // Should return 10

        // Test contains method
        System.out.println("\nTesting contains method:");
        System.out.println("Contains value 3: " + table.contains(3));  // Should return true
        System.out.println("Contains value 7: " + table.contains(7));  // Should return false

        // Test getKey method
        System.out.println("\nTesting getKey method:");
        System.out.println("Key for value 3: " + table.getKey(3));  // Should return "three"
        System.out.println("Key for value 7: " + table.getKey(7));  // Should return null (not found)

        // Test remove method
        System.out.println("\nTesting remove method:");
        System.out.println("Remove 'three', returned value: " + table.remove("three"));  // Should return 3
        System.out.println("After removal, get 'three': " + table.get("three"));  // Should return null
        System.out.println("Contains value 3 after removal: " + table.contains(3));  // Should return false

        // Test remove non-existent key
        System.out.println("Remove non-existent 'six', returned value: " + table.remove("six"));  // Should return null
    }

    // Test with custom key class
    private static void testWithCustomKeyClass() {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        // Create some test objects
        MyTestingClass key1 = new MyTestingClass(1, "First");
        MyTestingClass key2 = new MyTestingClass(2, "Second");
        MyTestingClass key3 = new MyTestingClass(3, "Third");

        // Test put and get methods
        System.out.println("Testing put and get with custom key class:");
        table.put(key1, "Value 1");
        table.put(key2, "Value 2");
        table.put(key3, "Value 3");

        System.out.println("Get key1: " + table.get(key1));  // Should return "Value 1"
        System.out.println("Get key2: " + table.get(key2));  // Should return "Value 2"

        // Test with equal objects but different instances
        MyTestingClass key1Copy = new MyTestingClass(1, "First");
        System.out.println("Get key1Copy (equal to key1): " + table.get(key1Copy));  // Should return "Value 1"

        // Test remove
        System.out.println("\nTesting remove with custom key class:");
        System.out.println("Remove key2, returned value: " + table.remove(key2));  // Should return "Value 2"
        System.out.println("After removal, get key2: " + table.get(key2));  // Should return null

        // Test contains and getKey
        System.out.println("\nTesting contains and getKey with custom key class:");
        System.out.println("Contains 'Value 3': " + table.contains("Value 3"));  // Should return true
        System.out.println("Key for 'Value 3': " + table.getKey("Value 3"));  // Should return key3
    }

    private static void testDistribution() {
        // Create hash table with size 997 (a prime number for better distribution)
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(997);

        // Add 10,000 random elements
        for (int i = 0; i < 10000; i++) {
            int id = i;
            String name = "Name" + i;
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student(id, name);
            table.put(key, value);
            System.out.println(table.get(key));
        }

        // Analyze and print distribution
        table.printBucketDistribution();
    }
}
