package assignment3;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size; // Track size of the tree

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // Entry class for iteration - provides access to both key and value
    public static class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // Constructor
    public BST() {
        root = null;
        size = 0;
    }

    // Return the number of key-value pairs
    public int size() {
        return size;
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V val) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (val == null) {
            // If value is null, we'll delete the key
            delete(key);
            return;
        }
        int oldSize = size;
        root = put(root, key, val);
        // If the size didn't change, it was an update operation
        if (size == oldSize) size++;
    }

    private Node put(Node node, K key, V val) {
        // If node is null, create a new node
        if (node == null) return new Node(key, val);

        // Compare keys
        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            // Update value if key already exists
            node.val = val;
        }

        return node;
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        Node node = get(root, key);
        return node == null ? null : node.val;
    }

    private Node get(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (!contains(key)) return; // Don't decrease size if key doesn't exist

        root = delete(root, key);
        size--; // Decrease size when a key is deleted
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // Node with only one child or no child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children
            Node successor = min(node.right);

            // Delete the min node from the right subtree
            Node newRight = deleteMin(node.right);

            // Replace node with its successor
            successor.right = newRight;
            successor.left = node.left;

            return successor;
        }

        return node;
    }

    // Helper method to find minimum node in a subtree
    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    // Helper method to delete minimum node in a subtree
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    // Check if a key exists in the tree
    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        return get(key) != null;
    }

    @Override
    public java.util.Iterator<Entry<K, V>> iterator() {
        return new BSTIterator();
    }

    // In-order traversal iterator
    private class BSTIterator implements java.util.Iterator<Entry<K, V>> {
        private java.util.Queue<Entry<K, V>> queue;

        public BSTIterator() {
            queue = new java.util.LinkedList<>();
            inorderTraversal(root);
        }

        private void inorderTraversal(Node node) {
            if (node == null) return;

            // Traverse left subtree
            inorderTraversal(node.left);

            // Add current node's key-value pair
            queue.add(new Entry<>(node.key, node.val));

            // Traverse right subtree
            inorderTraversal(node.right);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return queue.remove();
        }
    }
}
