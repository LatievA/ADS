package assignment1;

public class Problem7 {
    /**
     * Recursively prints the array in reverse order.
     * Time Complexity: O(n) - Each element is processed once.
     */
    public static void printReverse(int[] arr, int n) {
        if (n == 0) return; // Base case: Stop when reaching the beginning
        System.out.print(arr[n - 1] + " ");
        printReverse(arr, n - 1); // Print next element in reverse order
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 1};
        printReverse(arr, arr.length);
    }
}
