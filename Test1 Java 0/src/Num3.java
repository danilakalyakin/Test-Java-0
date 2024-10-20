import java.security.SecureRandom;
import java.util.Scanner;

public class Num3 {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private static final String ALL_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в генератор паролей!");
        System.out.println("Выберите длину пароля (от 8 до 12 символов):");

        int length = scanner.nextInt();

        if (length < 8 || length > 12) {
            System.out.println("Ошибка: длина пароля должна быть от 8 до 12 символов.");
        } else {
            String password = generatePassword(length);
            System.out.println("Сгенерированный пароль: " + password);
        }

        scanner.close();
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);

        password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        StringBuilder shuffled = new StringBuilder(input.length());
        char[] chars = input.toCharArray();

        for (int i = input.length(); i > 0; i--) {
            int randIndex = random.nextInt(i);
            shuffled.append(chars[randIndex]);
            chars[randIndex] = chars[i - 1];
        }

        return shuffled.toString();
    }
}