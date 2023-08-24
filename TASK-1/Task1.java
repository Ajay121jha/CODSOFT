import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int attemptsLimit = 10;
        int rounds = 0;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(max - min + 1) + min;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + min + " and " + max + ". Try to guess it!");

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += attemptsLimit - attempts + 1;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            rounds++;
            System.out.println("Round " + rounds + " is over. Your current score: " + score);

            System.out.print("Do you want to play another round? (Yes/No): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + score);
    }
}