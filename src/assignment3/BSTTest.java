package assignment3;

public class BSTTest {
    public static void main(String[] args) {
        // Create a BST with String keys and Integer values
        BST<String, Integer> tree = new BST<>();

        // Insert some key-value pairs
        tree.put("E", 5);
        tree.put("B", 2);
        tree.put("G", 7);
        tree.put("A", 1);
        tree.put("D", 4);
        tree.put("F", 6);
        tree.put("H", 8);
        tree.put("C", 3);

        // Display tree size
        System.out.println("Tree size: " + tree.size());

        // Iterate and display key-value pairs (in-order traversal)
        System.out.println("\nIn-order traversal of tree:");
        for (var entry : tree) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Test get method
        System.out.println("\nValue for key 'D': " + tree.get("D"));

        // Test delete method
        System.out.println("\nDeleting key 'B'...");
        tree.delete("B");
        System.out.println("Tree size after deletion: " + tree.size());

        // Show the tree after deletion
        System.out.println("\nTree after deletion:");
        for (var entry : tree) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}