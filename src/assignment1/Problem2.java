package assignment1;

public class Problem2 {
    /**
     * Recursively calculates the sum of the array and returns the average.
     * Time Complexity: O(n) - Each element is visited once.
     */
    public static double findAverage(int[] arr, int n) {
        // Base case: If only one element, return it as average
        if (n == 1) {
            return arr[0];
        }
        // Sum elements recursively and divide by the count
        return (arr[n - 1] + (n - 1) * findAverage(arr, n - 1)) / (double) n;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
        System.out.println(findAverage(arr, arr.length));
    }
}

