package assignment1;

public class Problem6 {
    /**
     * Recursively calculates a^n.
     * Time Complexity: O(n) - Linear recursion depth.
     */
    public static int power(int a, int n) {
        if (n == 0) return 1; // Base case: a^0 = 1
        return a * power(a, n - 1); // Multiply a with result of a^(n-1)
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
