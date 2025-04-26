package assignment3;

// Hash Table Test with 10,000 elements and distribution analysis
public class HashTableTest {
    public static void main(String[] args) {
        // Create hash table with size 997 (a prime number for better distribution)
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(997);

        // Add 10,000 random elements
        for (int i = 0; i < 10000; i++) {
            int id = i;
            String name = "Name" + i;
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student(id, name);
            table.put(key, value);
        }

        // Analyze and print distribution
        table.printBucketDistribution();
    }
}

// Custom class for testing with custom hashCode implementation
class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Custom hashCode implementation (tuned for uniform distribution)
    @Override
    public int hashCode() {
        // Prime number multiplication with bitwise operations for better distribution
        int hash = 17;
        hash = hash * 31 + id;

        // String hashing component
        if (name != null) {
            int nameHash = 0;
            for (int i = 0; i < name.length(); i++) {
                // Multiply by prime and add character value
                nameHash = nameHash * 23 + name.charAt(i);
            }
            hash = hash * 31 + nameHash;
        }

        // Additional operations to improve distribution
        hash = hash ^ (hash >>> 16); // XOR with higher bits

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id &&
                (name == null ? other.name == null : name.equals(other.name));
    }

    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}

// Sample student class for values
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}