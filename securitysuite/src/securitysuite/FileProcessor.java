package securitysuite;

import java.io.*;

public class FileProcessor {

    private CaesarCipher cipher = new CaesarCipher();

    // Encrypt file from securitysuite package folder
    public void encryptFile(String inputFile, String outputFile, int shift) {

        // Force path to src/securitysuite folder
        String basePath = "src/securitysuite/";
        String inputPath = basePath + inputFile;
        String outputPath = basePath + outputFile;

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(cipher.encrypt(line, shift));
                writer.newLine();
            }

            System.out.println("File encrypted successfully → saved in securitysuite package");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            System.out.println("Make sure file is inside src/securitysuite/");
        }
    }

    // Brute force Caesar crack
    public void bruteForceCrack(String encryptedText) {
        long start = System.currentTimeMillis();

        System.out.println("\nBrute force results:\n");

        for (int shift = 0; shift < 26; shift++) {
            String attempt = cipher.decrypt(encryptedText, shift);
            System.out.println("Shift " + shift + ": " + attempt);
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("\nCompleted in: " + duration + " ms");
    }
}
