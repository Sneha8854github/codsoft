package demo;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        System.out.println("Welcome to Guess the Number!");

        Scanner scanner = new Scanner(System.in);

        int totalAttempts = 0;
        int totalRounds = 0;
        int totalScore = 0;

        while (true) {
            // Generate a random number within the specified range
            int secretNumber = new Random().nextInt(100) + 1;

            // Set the maximum number of attempts
            int maxAttempts = 10;
            int attempts = 0;

            while (attempts < maxAttempts) {
                // Prompt the user to enter their guess
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();

                // Compare the user's guess with the generated number
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber +
                            " in " + (attempts + 1) + " attempts.");
                    totalScore += maxAttempts - attempts;
                    totalAttempts += (attempts + 1);
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
            }

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            } else {
                totalRounds++;
            }
        }

        // Display the user's score and statistics
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Attempts per Round: " + (totalAttempts / (double) totalRounds));
    }
}
