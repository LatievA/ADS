package assignment1;

public class Problem3 {
    /**
     * Recursively checks if a number is prime.
     * Time Complexity: O(sqrt(n)) - We only check divisors up to sqrt(n).
     */
    public static boolean isPrime(int n, int divisor) {
        if (n < 2) return false; // 0 and 1 are not prime
        if (divisor * divisor > n) return true; // If no divisor found, it's prime
        if (n % divisor == 0) return false; // If divisible, it's not prime
        return isPrime(n, divisor + 1); // Check next divisor
    }

    public static String message(boolean isp){
        if (isp) {
            return "Prime";
        }
        return  "Composite";
    }

    public static void main(String[] args) {
        System.out.println(message(isPrime(7, 2)));
        System.out.println(message(isPrime(10, 2)));
    }
}

