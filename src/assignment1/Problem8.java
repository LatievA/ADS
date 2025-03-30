package assignment1;

public class Problem8 {
    /**
     * Recursively checks if a string contains only digits.
     * Time Complexity: O(n) - Each character is checked once.
     */
    public static boolean isDigitOnly(String s, int index) {
        if (index == s.length()) return true; // Base case: reached end of string
        if (!Character.isDigit(s.charAt(index))) return false; // If not digit, return false
        return isDigitOnly(s, index + 1); // Check next character
    }

    public static boolean isDigitOnly(String s) {
        return isDigitOnly(s, 0); // Overloading to not write 0 every time
    }

    public static String message(boolean n){
        if (n) {
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        System.out.println(message(isDigitOnly("123456")));   // Output: true
        System.out.println(message(isDigitOnly("123a12")));   // Output: false
        System.out.println(message(isDigitOnly("n")));
    }
}

