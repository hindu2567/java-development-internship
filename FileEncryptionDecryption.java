import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'encrypt' to encrypt a file or 'decrypt' to decrypt a file: ");
        String operation = scanner.nextLine().trim().toLowerCase();

        if (operation.equals("encrypt")) {
            System.out.println("Enter the name or path of the file to encrypt: ");
            String inputFile = scanner.nextLine().trim();
            System.out.println("Enter the name of the output file (encrypted): ");
            String outputFile = scanner.nextLine().trim();
            encryptFile(inputFile, outputFile);
            System.out.println("File encrypted successfully!");
        } else if (operation.equals("decrypt")) {
            System.out.println("Enter the name or path of the file to decrypt: ");
            String inputFile = scanner.nextLine().trim();
            System.out.println("Enter the name of the output file (decrypted): ");
            String outputFile = scanner.nextLine().trim();
            decryptFile(inputFile, outputFile);
            System.out.println("File decrypted successfully!");
        } else {
            System.out.println("Invalid operation. Please enter 'encrypt' or 'decrypt'.");
        }

        scanner.close();
    }

    private static void encryptFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line);
                writer.write(encryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }

    private static void decryptFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }

    private static String encrypt(String text) {
        // Example simple encryption: shift each character by 1
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                encrypted.append((char) (c + 1));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private static String decrypt(String text) {
        // Example simple decryption: shift each character back by 1
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                decrypted.append((char) (c - 1));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}