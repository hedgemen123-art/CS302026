package securitysuite;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CaesarCipher caesar = new CaesarCipher();
        VigenereCipher vigenere = new VigenereCipher();
        FileProcessor fileProcessor = new FileProcessor();

        while (true) {
            System.out.println("\n=== CipherGuard ===");
            System.out.println("[1] Caesar Encrypt Message");
            System.out.println("[2] Caesar Decrypt Message");
            System.out.println("[3] Encrypt File (Caesar)");
            System.out.println("[4] Brute Force Crack (Caesar)");
            System.out.println("[5] Vigenere Encrypt");
            System.out.println("[6] Vigenere Decrypt");
            System.out.println("[7] Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1: // Caesar Encrypt
                    System.out.print("Enter message: ");
                    String msg = scanner.nextLine();

                    System.out.print("Enter shift value: ");
                    int shift = scanner.nextInt();
                    scanner.nextLine();

                    String encrypted = caesar.encrypt(msg, shift);
                    System.out.println("Encrypted: " + encrypted);
                    break;

                case 2: // Caesar Decrypt
                    System.out.print("Enter encrypted message: ");
                    String encMsg = scanner.nextLine();

                    System.out.print("Enter shift value used: ");
                    int dShift = scanner.nextInt();
                    scanner.nextLine();

                    String decrypted = caesar.decrypt(encMsg, dShift);
                    System.out.println("Decrypted: " + decrypted);
                    break;

                case 3: // File Encrypt
                    System.out.print("Enter input file (.txt): ");
                    String input = scanner.nextLine();

                    System.out.print("Enter output file name: ");
                    String output = scanner.nextLine();

                    System.out.print("Enter shift value: ");
                    int fileShift = scanner.nextInt();
                    scanner.nextLine();

                    fileProcessor.encryptFile(input, output, fileShift);
                    break;

                case 4: // Brute force
                    System.out.print("Enter encrypted message: ");
                    String brute = scanner.nextLine();
                    fileProcessor.bruteForceCrack(brute);
                    break;

                case 5: // Vigenere Encrypt
                    System.out.print("Enter message: ");
                    String vMsg = scanner.nextLine();

                    System.out.print("Enter keyword: ");
                    String key = scanner.nextLine();

                    String vEncrypted = vigenere.encrypt(vMsg, key);
                    System.out.println("Encrypted: " + vEncrypted);
                    break;

                case 6: // Vigenere Decrypt
                    System.out.print("Enter encrypted message: ");
                    String vEnc = scanner.nextLine();

                    System.out.print("Enter keyword: ");
                    String vKey = scanner.nextLine();

                    String vDecrypted = vigenere.decrypt(vEnc, vKey);
                    System.out.println("Decrypted: " + vDecrypted);
                    break;

                case 7:
                    System.out.println("Exiting CipherGuard.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
