import java.util.Scanner;

public class PalindromeChecker {

    private static String cleanString(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private static boolean isPalindrome(String input) {
        String cleaned = cleanString(input);
        int length = cleaned.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or phrase:");
        String input = scanner.nextLine();
        if (isPalindrome(input)) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
        scanner.close();
    }
}