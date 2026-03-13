import java.util.Scanner;

// PalindromeChecker class (Encapsulates palindrome logic)
class PalindromeChecker {

    // Method to check if a string is a palindrome
    public boolean checkPalindrome(String input) {

        // Convert to lowercase and remove spaces
        input = input.replaceAll("\\s+", "").toLowerCase();

        int n = input.length();

        // Stack using array
        char[] stack = new char[n];
        int top = -1;

        // Push characters to stack
        for (int i = 0; i < n; i++) {
            stack[++top] = input.charAt(i);
        }

        // Compare characters while popping
        for (int i = 0; i < n; i++) {
            char ch = stack[top--]; // pop
            if (input.charAt(i) != ch) {
                return false;
            }
        }

        return true;
    }
}

// Main application class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
