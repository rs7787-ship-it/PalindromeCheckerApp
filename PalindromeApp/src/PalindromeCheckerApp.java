import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        if (text == null) return false;

        Stack<Character> stack = new Stack<>();
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        if (text == null) return false;

        Deque<Character> deque = new ArrayDeque<>();
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Main app
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string to check:");
        String input = scanner.nextLine();

        System.out.println("Choose strategy (1 = Stack, 2 = Deque):");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                System.out.println("Invalid choice. Using default Stack strategy.");
                strategy = new StackStrategy();
        }

        boolean result = strategy.isPalindrome(input);
        System.out.println("Is palindrome? " + result);

        scanner.close();
    }
}
