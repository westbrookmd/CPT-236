// Marshall Westbrook
// Assignment 2
// CPT-236-S44
// Fall 2021

// importing scanner to capture input from user
import java.util.Scanner;

public class DecimalFloor {
    public static void main(String[] args) {
        //create scanner to capture input
        Scanner input = new Scanner(System.in);
        
        // User prompted for input and stored in double
        System.out.print("Enter a number that includes a decimal to truncate.");
        double inputValue = input.nextDouble();
        
        // Convert double to int with an explicit cast(truncating any decimals)
        int convertedValue = (int)inputValue;
        
        // Output initial input
        System.out.println("Initial Input: " + inputValue);
        // Output converted value
        System.out.println("Truncated Value: " + convertedValue);


    }
}