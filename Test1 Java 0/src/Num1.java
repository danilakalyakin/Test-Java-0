import java.util.Random;
import java.util.Scanner;

public class Num1 {

    private static final String[] WORDS = {"джава", "компьютер"};
    private static final int MAX_LIVES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int lives = MAX_LIVES;
        boolean wordGuessed = false;

        System.out.println("Добро пожаловать в игру 'Виселица'!");
        System.out.println("Загаданные слова написаны на русском языке, вводите по одной букве!");

        while (lives > 0 && !wordGuessed) {
            System.out.println("\nСлово для отгадывания: " + new String(guessedWord));
            System.out.println("Осталось жизней: " + lives);
            System.out.print("Введите букву: ");
            char guessedLetter = scanner.nextLine().toLowerCase().charAt(0);

            boolean letterFound = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    letterFound = true;
                }
            }

            if (!letterFound) {
                lives--;
                System.out.println("Неверная буква! Жизней стало меньше.");
            } else {
                System.out.println("Правильно!");
            }

            if (new String(guessedWord).equals(wordToGuess)) {
                wordGuessed = true;
                System.out.println("\nПоздравляем! Вы угадали слово: " + wordToGuess);
            }
        }

        if (!wordGuessed) {
            System.out.println("\nВы проиграли! Загаданное слово было: " + wordToGuess);
        }

        scanner.close();
    }
}