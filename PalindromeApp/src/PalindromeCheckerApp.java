import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    // Approach 1: Reverse string and compare
    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Approach 2: Two-pointer technique
    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 3: Recursive method
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        System.out.println("\n--- Palindrome Results ---");

        // Measure time for Reverse method
        long startTime = System.nanoTime();
        boolean resultReverse = isPalindromeReverse(input);
        long endTime = System.nanoTime();
        System.out.println("Reverse Method: " + resultReverse + " | Time: " + (endTime - startTime) + " ns");

        // Measure time for Two-pointer method
        startTime = System.nanoTime();
        boolean resultTwoPointer = isPalindromeTwoPointer(input);
        endTime = System.nanoTime();
        System.out.println("Two-pointer Method: " + resultTwoPointer + " | Time: " + (endTime - startTime) + " ns");

        // Measure time for Recursive method
        startTime = System.nanoTime();
        boolean resultRecursive = isPalindromeRecursive(input, 0, input.length() - 1);
        endTime = System.nanoTime();
        System.out.println("Recursive Method: " + resultRecursive + " | Time: " + (endTime - startTime) + " ns");

        sc.close();
    }
}
