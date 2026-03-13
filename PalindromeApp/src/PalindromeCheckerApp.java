import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear characters
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
