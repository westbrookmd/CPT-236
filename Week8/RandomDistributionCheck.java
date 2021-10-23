// Marshall Westbrook
// Assignment 7
// CPT-236-S44
// Fall 2021
// Generates random numbers between two values and gets a random distribution.
// User-guided format that utilize the methods without constants below assignment-required code


import java.security.Timestamp;
import java.util.Random;
import java.util.Scanner;

public class RandomDistributionCheck
{
    public static void main(String[] args) {

        //constants for lower and upper boundaries and times to iterate
        final int LOWER = 0;
        final int UPPER = 19;
        final int ITERATE = 10000000;
        // automatic calculation for assignment
        int[] autoNumbers = generateNumbers(LOWER, UPPER, ITERATE);
        generateOutput(ITERATE, autoNumbers, LOWER);
        // END OF OFFICIAL ASSIGNMENT

        //get user input for each value and store the values (without validation)
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());
        //lower
        System.out.print("Enter a lower boundary:");
        int userInput = input.nextInt();
        int lowerBoundary = userInput;
        //upper
        System.out.print("Enter a upper boundary:");
        userInput = input.nextInt();
        int upperBoundary = userInput;
        //iterations
        System.out.print("Enter amount of times to iterate:");
        userInput = input.nextInt();
        int timesToIterate = userInput;
        //calculate the random numbers for each value and return the array of times each number is generated
        int[] numbers = generateNumbers(lowerBoundary, upperBoundary, timesToIterate);
        // Calculate percentage of all occurences and output to user
        generateOutput(timesToIterate, numbers, lowerBoundary);
        // close scanner for good practice
        input.close();
    }
    public static int[] generateNumbers(int lowerBoundary, int upperBoundary, int timesToIterate){
        Random random = new Random();
        int[] listToReturn = new int[upperBoundary-lowerBoundary]; // create an array that is the size of the difference of the boundaries
        for(int i = 0; i < timesToIterate; i++)
        {
            int result = random.nextInt(upperBoundary-lowerBoundary) + lowerBoundary; //generate a number between the lower boundary and the upper boundary
            //System.out.println(result);
            listToReturn[result-lowerBoundary] += 1; //For the given number's position in the array(minus the lower boundary), add this instance that this value was generated
        }
        return listToReturn;

    }
    private static void generateOutput(int timesToIterate, int[] numbers, int lower) {
        System.out.printf("%s %d %s","For", timesToIterate, "iterations, here are the results.\n");
        System.out.println("------------------------------------");
        int r = lower;
        for(int i : numbers)
        {
            double valueAsPercentage = ((double)i/(double)timesToIterate)*(double)100.0; // get our value as a percentage
            //ignore the array values below the lower boundary (failsafe if other values are added erroneously)
            if(i >= lower)
                //experimenting with formatting. This definitely hurts readability like this - not sure exactly how to fix this without sacrificing formatting
                System.out.printf("%s%02d%s%s %6d %.2f%s\n", "[", r, "]", ":", i, valueAsPercentage, "%");
            r++; //counting so that we can keep track of what position we're outputting
        }
        System.out.println("------------------------------------");
    }

    
}

