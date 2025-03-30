package assignment1;

public class Problem5 {
    /**
     * Recursively calculates the n-th Fibonacci number.
     * Time Complexity: O(2^n) - Exponential due to repeated calculations.
     */
    public static int fibonacci(int n) {
        if (n == 0) return 0; // Base case: F(0) = 0
        if (n == 1) return 1; // Base case: F(1) = 1
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive relation
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(17));
    }
}
