package securitysuite;

public class CaesarCipher {

    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';

                int newChar = (c - base + shift) % 26;
                if (newChar < 0) {
                    newChar += 26;
                }

                c = (char) (newChar + base);
            }
            result.append(c);
        }
        return result.toString();
    }

    public String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }
}
