import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();
        
        String strength = checkPasswordStrength(password);
        System.out.println("Password strength: " + strength);
    }

    private static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (isSpecialCharacter(c)) {
                hasSpecialChar = true;
            }
        }

        if (length >= 12 && hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
            return "Very Strong";
        } else if (length >= 8 && hasUpperCase && hasLowerCase && (hasDigit || hasSpecialChar)) {
            return "Strong";
        } else if (length >= 6 && (hasUpperCase || hasLowerCase) && (hasDigit || hasSpecialChar)) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }

    private static boolean isSpecialCharacter(char c) {
        // Define what constitutes a special character
        String specialChars = "!@#$%^&*()-_+=<>?/{}~|";
        return specialChars.indexOf(c) >= 0;
    }
}