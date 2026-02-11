package securitysuite;

public class VigenereCipher {

    public String encrypt(String text, String keyword) {
        StringBuilder result = new StringBuilder();
        keyword = keyword.toLowerCase();

        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = keyword.charAt(keyIndex % keyword.length()) - 'a';
                char base = Character.isUpperCase(c) ? 'A' : 'a';

                int newChar = (c - base + shift) % 26;
                c = (char) (newChar + base);

                keyIndex++;
            }
            result.append(c);
        }
        return result.toString();
    }

    public String decrypt(String text, String keyword) {
        StringBuilder result = new StringBuilder();
        keyword = keyword.toLowerCase();

        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = keyword.charAt(keyIndex % keyword.length()) - 'a';
                char base = Character.isUpperCase(c) ? 'A' : 'a';

                int newChar = (c - base - shift) % 26;
                if (newChar < 0) {
                    newChar += 26;
                }

                c = (char) (newChar + base);
                keyIndex++;
            }
            result.append(c);
        }
        return result.toString();
    }
}
