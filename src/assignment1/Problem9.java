package assignment1;

public class Problem9 {
    /**
     * Recursively calculates the binomial coefficient C(n, k).
     * Time Complexity: O(2^n) - Exponential due to repeated subproblems.
     */
    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) return 1; // Base case: C(n, 0) = C(n, n) = 1
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k); // Recursive formula
    }

    public static void main(String[] args) {
        System.out.println(binomialCoefficient(2, 1));
        System.out.println(binomialCoefficient(7, 3));
    }
}
