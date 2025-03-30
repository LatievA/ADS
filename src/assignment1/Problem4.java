package assignment1;

public class Problem4 {
    /**
     * Recursively calculates factorial.
     * Time Complexity: O(n) - Recursive depth is n.
     */
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1; // Base case: factorial of 0 and 1 is 1
        return n * factorial(n - 1); // Recursive call
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
