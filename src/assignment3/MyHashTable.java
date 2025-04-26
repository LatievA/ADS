package assignment3;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray; // or Object[]
    private int M = 11; // default number of chains
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % M;
    }

    public void put(K key, V value) {
        // Get the index based on key hash
        int index = hash(key);

        // Create a new node with the key and value
        HashNode<K, V> newNode = new HashNode<>(key, value);

        // If no node exists at index, insert the new node
        if (chainArray[index] == null) {
            chainArray[index] = newNode;
        } else {
            // Handle collision - check if key already exists
            HashNode<K, V> current = chainArray[index];
            HashNode<K, V> prev = null;

            while (current != null) {
                // If key exists, update the value
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }

            // Key not found, add to end of chain
            prev.next = newNode;
        }
        size++;
    }

    public V get(K key) {
        // Get the index based on key hash
        int index = hash(key);

        // Find the node in the chain
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        // Key not found
        return null;
    }

    public V remove(K key) {
        // Get the index based on key hash
        int index = hash(key);

        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        // Search for key in the chain
        while (current != null) {
            // If key is found
            if (current.key.equals(key)) {
                // If it's the first node in chain
                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        // Key not found
        return null;
    }

    public boolean contains(V value) {
        // Iterate through all chains
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];

            // Check each node in the chain
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }

        // Value not found
        return false;
    }

    public K getKey(V value) {
        // Iterate through all chains
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];

            // Check each node in the chain
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }

        // Value not found
        return null;
    }

    // Method to analyze and print the distribution of elements in the hash table
    public void printBucketDistribution() {
        int[] bucketCounts = new int[M];
        int emptyBuckets = 0;
        int maxChainLength = 0;
        int totalChainLength = 0;

        // Count elements in each bucket
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            bucketCounts[i] = count;

            // Update statistics
            if (count == 0) emptyBuckets++;
            if (count > maxChainLength) maxChainLength = count;
            totalChainLength += count;
        }

        double averageChainLength = (double) totalChainLength / M;

        // Print results
        System.out.println("Hash Table Distribution Analysis");
        System.out.println("==============================");
        System.out.println("Total elements: " + size);
        System.out.println("Total buckets: " + M);
        System.out.println("Empty buckets: " + emptyBuckets + " (" + (emptyBuckets * 100.0 / M) + "%)");
        System.out.println("Max chain length: " + maxChainLength);
        System.out.println("Average chain length: " + String.format("%.2f", averageChainLength));

        // Print individual bucket counts
        System.out.println("\nBucket distribution:");
        for (int i = 0; i < M; i++) {
            System.out.println("Bucket " + i + ": " + bucketCounts[i] + " elements");
        }
    }
}