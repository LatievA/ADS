package assignment1;

public class Problem10 {
    /**
     * Recursively finds the Greatest Common Divisor using Euclidean Algorithm.
     * Time Complexity: O(log(min(a, b))) - Efficient logarithmic complexity.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a; // Base case: GCD(a, 0) is a
        return gcd(b, a % b); // Recursive step: GCD(b, a % b)
    }

    public static void main(String[] args) {
        System.out.println(gcd(32, 48));
        System.out.println(gcd(10, 7));
    }
}

