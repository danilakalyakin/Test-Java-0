import java.util.Scanner;

public class Num2 {

    private static final double EUR_TO_USD = 1.1;
    private static final double GBP_TO_USD = 1.3;
    private static final double JPY_TO_USD = 0.0091;
    private static final double RUB_TO_USD = 0.013;
    private static final double CNY_TO_USD = 0.14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в конвертер валют!");
        System.out.println("Введите сумму для конвертации:");
        double amount = scanner.nextDouble();

        System.out.println("Выберите исходную валюту (введите код):");
        System.out.println("1: USD (Доллар США)");
        System.out.println("2: EUR (Евро)");
        System.out.println("3: GBP (Фунт стерлингов)");
        System.out.println("4: JPY (Йена)");
        System.out.println("5: RUB (Российский рубль)");
        System.out.println("6: CNY (Китайский юань)");

        int currencyChoice = scanner.nextInt();
        double amountInUsd = convertToUsd(amount, currencyChoice);

        if (amountInUsd == -1) {
            System.out.println("Неверный выбор валюты.");
        } else {
            convertFromUsd(amountInUsd);
        }

        scanner.close();
    }

    private static double convertToUsd(double amount, int currencyChoice) {
        switch (currencyChoice) {
            case 1:
                return amount;
            case 2:
                return amount * EUR_TO_USD;
            case 3:
                return amount * GBP_TO_USD;
            case 4:
                return amount * JPY_TO_USD;
            case 5:
                return amount * RUB_TO_USD;
            case 6:
                return amount * CNY_TO_USD;
            default:
                return -1;
        }
    }

    private static void convertFromUsd(double amountInUsd) {
        System.out.println("\nСумма в долларах США: " + amountInUsd);
        System.out.println("В EUR: " + amountInUsd / EUR_TO_USD);
        System.out.println("В GBP: " + amountInUsd / GBP_TO_USD);
        System.out.println("В JPY: " + amountInUsd / JPY_TO_USD);
        System.out.println("В RUB: " + amountInUsd / RUB_TO_USD);
        System.out.println("В CNY: " + amountInUsd / CNY_TO_USD);
    }
}
