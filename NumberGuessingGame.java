import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        boolean playAgain;

        do {
            playGame();
            playAgain = askReplay();
        } while (playAgain);

        System.out.println("Thanks for playing!");
        sc.close();
    }

    public static void playGame() {
        int attempts = chooseDifficulty();
        int number = random.nextInt(100) + 1;

        System.out.println("\nI am thinking of a number between 1 and 100");

        while (attempts > 0) {
            int guess = getValidInput();

            if (guess == number) {
                System.out.println(" Correct! You guessed the number.");
                return;
            } else if (guess > number) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");
            }

            attempts--;
            System.out.println("Attempts left: " + attempts);
        }

        System.out.println("Game Over! The number was: " + number);
    }

    public static int chooseDifficulty() {
        System.out.println("\nChoose Difficulty:");
        System.out.println("1. Easy (10 attempts)");
        System.out.println("2. Medium (7 attempts)");
        System.out.println("3. Hard (5 attempts)");
        System.out.print("Enter choice: ");

        int choice = getValidInput();

        if (choice == 1) return 10;
        if (choice == 2) return 7;
        return 5;
    }

    public static int getValidInput() {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    public static boolean askReplay() {
        System.out.print("\nDo you want to play again? (yes/no): ");
        String response = sc.nextLine().toLowerCase();
        return response.equals("yes");
        }
}

