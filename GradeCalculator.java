package demo;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for grade boundaries
        final double A_GRADE = 90.0;
        final double B_GRADE = 80.0;
        final double C_GRADE = 70.0;
        final double D_GRADE = 60.0;

        int totalRounds = 0;
        int totalScore = 0;

        while (true) {
            // Input: Take marks obtained in each subject
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            int totalMarks = 0;

            for (int i = 1; i <= numSubjects; i++) {
                int marks;
                do {
                    System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                    marks = scanner.nextInt();
                } while (marks < 0 || marks > 100);

                totalMarks += marks;
            }

            // Calculate Total Marks
            // Calculate Average Percentage
            double averagePercentage = (double) totalMarks / numSubjects;

            // Grade Calculation: Assign grades based on the average percentage achieved
            char grade = (averagePercentage >= A_GRADE) ? 'A' :
                         (averagePercentage >= B_GRADE) ? 'B' :
                         (averagePercentage >= C_GRADE) ? 'C' :
                         (averagePercentage >= D_GRADE) ? 'D' : 'F';

            // Display Results
            System.out.println("\nResults:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage);
            System.out.println("Grade: " + grade);

            // Update score and rounds
            totalScore += (averagePercentage >= D_GRADE) ? numSubjects : 0;
            totalRounds++;

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
        }

        // Display user's score and statistics
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Score: " + totalScore);

        scanner.close();
    }
}

