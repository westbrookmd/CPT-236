// Marshall Westbrook
// Assignment 4
// CPT-236-S44
// Fall 2021
// Handles uppercase and lowercase. Added a caesar for entire sentences at the bottom

// importing scanner to capture input from user
import java.util.Scanner;

public class SingleLetterCaesarShift
{
    public static void main(String[] args) 
    {
        // scanner for user input
        Scanner input = new Scanner(System.in);
        // set separator as white space for sentences later
        input.useDelimiter(System.lineSeparator());
        // prompting user for input
        System.out.print("Enter a single letter to shift:");
        // gathering input as a string
        String userInput = input.next();
        // converting string to char so that I don't have to repeat .charAt(0) for every comparison. I have a working caesar at the bottom for sentences with a set shift of 1.
        // this will only get the first char that the user inputted
        char userChar = userInput.charAt(0);
        // placeholder for answer 1
        char caesarShift = userChar;
        

        // if we have a letter do this
        if (Character.isLetter(userChar))
        {
            //input is a capital letter
            if (userChar >= 'A' && userChar <= 'Z')
            {
                // It's a Z (need to check z since we're adding)
                if (userChar == 'Z')
                {
                    caesarShift = 'A';
                }
                else
                {
                    // shift up
                    caesarShift++;
                }
            }
            //input is a lowercase letter
            else
            {
                // It's a z (need to check z since we're adding)
                if (userChar == 'z')
                {
                    //manually shift
                    caesarShift = 'a';
                }
                // it's another letter
                else
                {
                    //shift up
                    caesarShift++;
                }
            }
            System.out.println("You entered:" + userChar);
            System.out.println("Encrypted version:" + caesarShift);
        }
        else
        {
            //not a letter as input
            System.out.println("Enter a letter next time! You entered:" + userChar);
            System.exit(0);
        }
        
        // Second Shift
        // Prompt user
        System.out.println("------------------------------------");
        System.out.print("Enter a single letter to decrypt:");
        // Gather input
        userInput = input.next();
        userChar = userInput.charAt(0);
        char caesarShiftTwo = userChar;

        // Check if it's a letter
        if (Character.isLetter(userChar))
        {
            //input is a capital letter
            if (userChar >= 'A' && userChar <= 'Z')
            {
                // It's an a (need to check a since we're subtracting)
                if (userChar == 'A')
                {
                    // manually shift down
                    caesarShiftTwo = 'Z';
                }
                // it's another letter
                else
                {
                    // shift down
                    caesarShiftTwo--;
                }
            }
            //input is a lowercase letter
            else
            {
                // It's an a
                if (userChar == 'a')
                {
                    // manually shift down
                    caesarShiftTwo = 'z';
                }
                else
                {
                    // shift down
                    caesarShiftTwo--;
                }
            }
            System.out.println("You entered:" + userChar);
            System.out.println("Decrypted version:" + caesarShiftTwo);
        }
        else
        {
            //not a letter as input
            System.out.println("Enter a letter next time! You entered:" + userChar);
            System.exit(0);
        }

        //Caesar for sentences
        System.out.println("------------------------------------");
        System.out.println("Sentence-based caesar using strings!");
        System.out.print("Enter a sentence to encrypt:");
        // gathering input (space is the separator as shown at top of program)
        userInput = input.next();
        // storage for answer
        String caesarLine = "";
        
        // basic for loop for length of input -- didn't add input validation here since I'm not sure how to do it yet!
        for (int i = 0; i < userInput.length(); ++i)
        {
            // get char for position in loop of input
            char letter = userInput.charAt(i);
            // set shifted letter to input char
            char caesarLetter = letter;
            // check if char is a letter
            if (Character.isLetter(letter))
            {
                //input is a capital letter
                if (letter >= 'A' && letter <= 'Z')
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
                //input is a lowercase letter
                else
                {
                    // It's an a
                    if (letter == 'z')
                    {
                        caesarLetter = 'a';
                    }
                    else
                    {
                        // add shift
                        caesarLetter++;
                    }
                }
                caesarLine += caesarLetter;
            }
            else
            {
                // not a letter as input, just add to the answer without shifting
                caesarLine += letter;
            }
        }
        System.out.println("You entered:" + userInput);
        System.out.println("Encrypted message:" + caesarLine);
        System.out.println("------------------------------------");
        // close scanner for good practice
        input.close();


    }

}