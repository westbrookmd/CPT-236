// Marshall Westbrook
// Assignment 5
// CPT-236-S44
// Fall 2021
// Handles uppercase and lowercase for caesar. If this looks very familiar, 
// I wrote this as extra credit at the bottom of my assignment last week! (without the upper/lower handling choice)


import java.util.Scanner;

public class EncryptText
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());

        // asking the user if they want to convert lower and upper or just lower
        System.out.print("Would you like to convert lower and uppercase characters(y) or just lower(n)?");
        // Get a true/false value based on whether a y is included in user's response
        Boolean caseChoice = input.hasNext("y");
        // telling the user what they chose
        System.out.println("You chose: " + caseChoice);

        // deleting any values from input before caesar begins
        input.next();

        // prompting user for input
        System.out.print("Enter a sentence to encrypt:");
        // gathering input (space is the separator as shown at top of program)
        String userInput = input.next();
        // storage for answer
        String caesarLine = "";
        
        // basic for loop for length of input 
        for (int i = 0; i < userInput.length(); ++i)
        {
            // get char for position in loop of input
            char letter = userInput.charAt(i);
            // set shifted letter to input char
            char caesarLetter = letter;
            // check if char is a letter
            if (Character.isLetter(letter))
            {
                //input is a capital letter and the user opted for upper and lower handling
                if (letter >= 'A' && letter <= 'Z' && caseChoice)
                {
                    // It's a Z (need to check a since we're adding)
                    if (letter == 'Z')
                    {
                        // manually shifting
                        caesarLetter = 'A';
                    }
                    // it's another letter
                    else
                    {
                        // add shift
                        caesarLetter++;
                    }
                }
                //input is a lowercase letter or the user opted for lowercase only handling
                else
                {
                    // edge case - manually shifting
                    if (letter == 'z' || letter == 'Z')
                    {
                        caesarLetter = 'a';
                    }
                    // if it's a remaining capital letter because the user opted out of upper case handling
                    else if (letter >= 'A' && letter <= 'Z')
                    {
                        // any upper case letter + 33 equals the lowercase equivalent + 1
                        caesarLetter += 33;

                    }
                    else
                    {
                        // add shift
                        caesarLetter++;
                    }
                }
                // append letter to line
                caesarLine += caesarLetter;
            }
            // not a letter
            else
            {
                // not a letter as input, just add to the answer without shifting
                caesarLine += letter;
            }
        }
        System.out.println("------------------------------------");
        System.out.println("You entered:      " + userInput);
        System.out.println("Encrypted message:" + caesarLine);
        System.out.println("------------------------------------");
        // close scanner for good practice
        input.close();
    }
}

