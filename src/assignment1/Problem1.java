package assignment1;

public class Problem1 {
    /**
     * Recursively finds the minimum element in an array.
     * Time Complexity: O(n) - Each element is visited once.
     */
    public static int findMin(int[] arr, int n) {
        // Base case: If there's only one element, return it
        if (n == 1) {
            return arr[0];
        }
        // Recursively find the minimum of remaining elements
        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 32, 3, 45};
        System.out.println(findMin(arr, arr.length));  // Output: 1
    }
}

