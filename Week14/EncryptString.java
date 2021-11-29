// Marshall Westbrook
// Assignment 10
// CPT-236-S44
// Fall 2021
// Inheritance from AnyString. Basic encryption and decryption based on shift
// Bonus methods to use random shift values between 1-26.
// Experimented with optional parameters (and null checking)

import java.util.Scanner;

public class EncryptString extends AnyString {
    //storedString value is inherited here
    private final int shiftValue = (int) (Math.random() * 26.0);
    //private final int LETTERS_IN_ALPHABET = 26; //not needed, but 26 does feel like a magic number.
    //excluding it for now, but if this gets any more complicated we should refactor 26 -> LETTERS_IN_ALPHABET


    public static void main(String[] args){
        //basic test of EncryptString class
        Scanner input = new Scanner(System.in);
        //QOL feature for making sure input is collecting correctly
        input.useDelimiter(System.lineSeparator());
        System.out.print("Enter a string to test:");
        String simpleInput = input.nextLine();
        // create object with string input
        EncryptString encryptedStringFromInput = new EncryptString(simpleInput);

        //calling all methods
        System.out.println("Our input: " + encryptedStringFromInput);
        EncryptString secondEncryptedString = new EncryptString("test"); //creating another object to have something to compare to
        System.out.println("Is our input equal to \"" + secondEncryptedString + "\": " + encryptedStringFromInput.equals(secondEncryptedString));
        System.out.println("Does our input only contain letters: " + encryptedStringFromInput.isLetters());
        System.out.println("Does our input only contain numbers: " + encryptedStringFromInput.isNumeric());
        System.out.println("Our input encrypted is: " + encryptedStringFromInput.encryptString());
        //can also call decryptString() to decrypt the currently stored string
        System.out.println("Encrypted input decrypted is: " + decryptString(encryptedStringFromInput.encryptString()));
        System.out.println("Lowercase: " + encryptedStringFromInput.lowercase());
        System.out.println("Uppercase: " + encryptedStringFromInput.uppercase());
        System.out.println("Length: " + encryptedStringFromInput.getLength());

        //Character array test
        System.out.println("----------------------------");
        char[] simpleInputA = {'t','e','s','t'};
        EncryptString encryptedStringFromCharArray = new EncryptString(simpleInputA);

        //calling all methods
        System.out.println("Our character array input is: " + encryptedStringFromCharArray);
        System.out.println("Checking if our character array input is equal to \"" + secondEncryptedString + "\": " + encryptedStringFromCharArray.equals(secondEncryptedString));
        System.out.println("Does our input character array input only contain letters: " + encryptedStringFromCharArray.isLetters());
        System.out.println("Does our input character array input only contain numbers: " + encryptedStringFromCharArray.isNumeric());
        System.out.println("Our input encrypted is: " + encryptedStringFromCharArray.encryptString());
        System.out.println("Encrypted input decrypted is: " + decryptString(encryptedStringFromCharArray.encryptString()));
        System.out.println("Lowercase: " + encryptedStringFromCharArray.lowercase());
        System.out.println("Uppercase: " + encryptedStringFromCharArray.uppercase());
        System.out.println("Length: " + encryptedStringFromCharArray.getLength());
        
        //Bonus  method calls
        System.out.println("-----------BONUS-----------------");
        System.out.println("Here is a way to encrypt a string by passing a string in the method call rather than using an instance variable: " + encryptString("see this?"));
        System.out.println("The following displays a way to generate random shifts or use any given shift number between 1-26");
        System.out.println("Our randomly generated shift is: " + encryptedStringFromCharArray.shiftValue); //reusing char array object
        String moreTestInput = "Testing rAnDoM values. Handles uppercase and lowercase. Doesn't mess with non-letters.";
        System.out.println("Our test input is: " + moreTestInput);
        String encryptedStringTextFromCharArrayObject = encryptedStringFromCharArray.encryptStringRandom(moreTestInput);
        System.out.println("Encrypting with our random variable: " + encryptedStringTextFromCharArrayObject);
        System.out.println("Decrypting with the same random variable: " + encryptedStringFromCharArray.decryptStringRandom(encryptedStringTextFromCharArrayObject));
    }

    public EncryptString(String s){
        this.storedStringValue = s; 
    }

    public EncryptString(char [] c){
        this.storedStringValue = new String(c);
    }

    public String encryptString(){
        String temp = this.storedStringValue;
        return encryptString(temp);
    }
    public static String encryptString(String stringToEncrypt){
        //TODO: userInput -> stringToEncrypt
        //TODO: caesarLine -> encryptedString
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < stringToEncrypt.length(); ++i)
        {
            // get char for position in loop of input
            char letter = stringToEncrypt.charAt(i);
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
                //input is a lowercase letter or the user opted for lowercase only handling
                else
                {
                    // edge case - manually shifting
                    if (letter == 'z')
                    {
                        caesarLetter = 'a';
                    }
                    // if it's a remaining capital letter because the user opted out of upper case handling
                    else {
                        // add shift
                        caesarLetter++;
                    }
                }
                // append letter to line
                encryptedString.append(caesarLetter);
            }
            // not a letter
            else
            {
                // not a letter as input, just add to the answer without shifting
                encryptedString.append(letter);
            }
        }
        return encryptedString.toString();
    }
    //way to decrypt a stored string rather than always requiring a value
    public String decryptString(){
        String stringToDecrypt = this.getString();
        stringToDecrypt = decryptString(stringToDecrypt);
        return stringToDecrypt;
    }
    public static String decryptString(String stringToDecrypt){
        //creating general way to decrypt any string
        StringBuilder decryptedString = new StringBuilder();
        for (int i = 0; i < stringToDecrypt.length(); ++i)
        {
            // get char for position in loop of input
            char letter = stringToDecrypt.charAt(i);
            // set shifted letter to input char
            char caesarLetter = letter;
            // check if char is a letter
            if (Character.isLetter(letter))
            {
                //input is a capital letter and the user opted for upper and lower handling
                if (letter >= 'A' && letter <= 'Z')
                {
                    // It's an A (need to check a since we're subtracting)
                    if (letter == 'A')
                    {
                        // manually shifting
                        caesarLetter = 'Z';
                    }
                    // it's another letter
                    else
                    {
                        // subtract shift
                        caesarLetter--;
                    }
                }
                //input is a lowercase letter or the user opted for lowercase only handling
                else
                {
                    // edge case - manually shifting
                    if (letter == 'a')
                    {
                        caesarLetter = 'z';
                    }
                    // if it's a remaining capital letter because the user opted out of upper case handling
                    else {
                        // subtract shift
                        caesarLetter--;
                    }
                }
                // append letter to line
                decryptedString.append(caesarLetter);
            }
            // not a letter
            else
            {
                // not a letter as input, just add to the answer without shifting
                decryptedString.append(letter);
            }
        }
        return decryptedString.toString();
    }
    //including an optional parameter here. Either based on user input OR the randomly generated instance variable - this makes it multi-purpose
    public String encryptStringRandom(String stringToEncrypt, int... shiftAmount){
        //optional parameters will be null if nothing is given. This is how to set a default value
        //this makes me miss using C# optional parameters, but i'm sure there is a way to achieve this
        //same result more elegantly here
        int shiftTempValue = shiftAmount.length > 0 ? shiftAmount[0] : 0;
        StringBuilder encryptedString = new StringBuilder();
        int shift = getShift(shiftTempValue);
        for (int i = 0; i < stringToEncrypt.length(); ++i)
        {
            // get char for position in loop of input
            char letter = stringToEncrypt.charAt(i);
            // set shifted letter to input char
            char caesarLetter = letter;
            // check if char is a letter
            if (Character.isLetter(letter))
            {
                //input is a capital letter
                if (letter >= 'A' && letter <= 'Z')
                {
                    //find edge cases based on shift
                    if ( (letter + shift) > 'Z')
                    //add the shift, remove 26 to return to alphabetical ASCII characters
                        caesarLetter = (char)((letter + shift) - 26);
                    // it's within the boundaries
                    else
                    {
                        // add shift
                        caesarLetter += shift;
                    }
                }
                //input is a lowercase letter
                else
                {
                    // edge case - manually shifting
                    if ( (letter + shift) > 'z')
                    {
                        //add the shift, remove 26 to return to alphabetical ASCII characters
                        caesarLetter = (char)((letter + shift) - 26);
                    }
                    // its within boundaries
                    else
                    {
                        // add shift
                        caesarLetter += shift;
                    }
                }
                // append letter to line
                encryptedString.append(caesarLetter);
            }
            // not a letter
            else
            {
                // not a letter as input, just add to the answer without shifting
                encryptedString.append(letter);
            }
        }
        //TODO: check to make sure we've saved our randomly generated value to a file since this value will be deleted when the program stops
        return encryptedString.toString();
    }
    private int getShift(int shiftAmount){
        int shiftToReturn;
        if(shiftAmount >= 1 && shiftAmount <= 26)
            shiftToReturn = shiftAmount;
        else{
            //System.out.println("Shift value must be within 1-26. Using randomly generated value instead.");
            shiftToReturn = this.shiftValue;
        }
        return shiftToReturn;
    }
    //including an optional parameter here. Either based on user input OR the randomly generated instance variable - this makes it multi-purpose
    public String decryptStringRandom(String stringToDecrypt, int... shiftAmount){
        //optional parameters will be null if nothing is given. This is how to set a default value
        //this makes me miss using C# optional parameters, but i'm sure there is a way to achieve this
        //same result more elegantly here
        int shiftTempValue = shiftAmount.length > 0 ? shiftAmount[0] : 0;
        //TODO: change variable to decryptedString
        StringBuilder decryptedString = new StringBuilder();
        int shift = getShift(shiftTempValue);
        for (int i = 0; i < stringToDecrypt.length(); ++i)
        {
            // get char for position in loop of input
            char letter = stringToDecrypt.charAt(i);
            // set shifted letter to input char
            char caesarLetter = letter;
            // check if char is a letter
            if (Character.isLetter(letter))
            {
                //input is a capital letter
                if (letter >= 'A' && letter <= 'Z')
                {
                    //find edge cases based on shift
                    if ( (letter - shift) < 'A')
                        //remove the shift, add 26 to return to alphabetical ASCII characters
                        caesarLetter = (char)((letter - shift) + 26);
                    // it's within the boundaries
                    else
                    {
                        // remove shift
                        caesarLetter -= shift;
                    }
                }
                //input is a lowercase letter
                else
                {
                    // edge case - manually shifting
                    if ( (letter - shift) < 'a')
                    {
                        //remove the shift, add 26 to return to alphabetical ASCII characters
                        caesarLetter = (char)((letter - shift) + 26);
                    }
                    // its within boundaries
                    else
                    {
                        // remove shift
                        caesarLetter -= shift;
                    }
                }
                // append letter to line
                decryptedString.append(caesarLetter);
            }
            // not a letter
            else
            {
                // not a letter as input, just add to the answer without shifting
                decryptedString.append(letter);
            }
        }
        //TODO: add option to read from file or allow this to be an option on object creation
        return decryptedString.toString();
    }
}