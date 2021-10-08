// Marshall Westbrook
// Assignment 3
// CPT-236-S44
// Fall 2021
// Added a basic while loop within the application, no input validation yet

// importing scanner to capture input from user
import java.util.Scanner;

public class ValueSwap
{
    public static void main(String[] args) {
        // created a basic boolean to keep the while loop true
        boolean running =  true;
        // basic while loop so the user decides when to quit
        while (running)
        {
            // prompt user for input
            System.out.print("Enter a whole number from 0 - 99: ");
            // create scanner to gather user input
            Scanner input = new Scanner(System.in);
            

            // gather user input and place into integer
            int userValue = input.nextInt();
            // create a second integer using the math.random method
            int randomValue = (int)(Math.random() * 10); // 0 - 99

            // if the first value is greater than second, swap them
            if (userValue > randomValue)
            {
                // Store second value so that we don't lose it when we assign it the first value
                int tempValue = randomValue;
                // second = first
                randomValue = userValue;
                // first = second (currently stored in tempValue)
                userValue = tempValue;
            }
            else
            {
                // do nothing
            }
            // concatenating variables within the print statement
            System.out.println(userValue + " is less than or equal to " + randomValue + "!");
            // break up line items with hyphens (for a little formatting)
            System.out.println("----------------------------------");

            // Prompt the user if they would like the application to continue
            System.out.print("Would you like to continue selecting numbers(y or n): ");
            // Store the user input
            String userAnswer = input.next();
            // Check if the string contains "n". If so, stop the application
            if (userAnswer.contains("n"))
            {
                running = false;
            }
            // If not, break up the line items with more formatting
            else
            {
                System.out.println("----------------------------------");
            }
            
    }
}
}