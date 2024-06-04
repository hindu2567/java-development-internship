import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("yes");

        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

        String allChars = "";
        if (includeLowercase) allChars += lowercaseChars;
        if (includeUppercase) allChars += uppercaseChars;
        if (includeNumbers) allChars += numberChars;
        if (includeSpecialChars) allChars += specialChars;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}