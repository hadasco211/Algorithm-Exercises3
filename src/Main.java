import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nבחר מספר שאלה:");
            System.out.println("1 - שאלה ראשונה (coinChange)");
            System.out.println("2 - שאלה שנייה (GreedyLineBreaker)");
            System.out.println("0 - יציאה");
            System.out.print("הבחירה שלך: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int[] coins = {1, 6, 10};
                    int amount = 12;
                    int result = coinChange.coinChanges(coins, amount);
                    System.out.println("🔸 Minimal number of coins: " + result);
                    break;

                case 2:
                    GreedyLineBreaker.run();
                    break;

                case 0:
                    System.out.println("👋 להתראות!");
                    break;

                default:
                    System.out.println("❌ מספר שאלה לא חוקי.");
            }

        } while (choice != 0);

        scanner.close();
    }
}