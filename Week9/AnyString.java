// Marshall Westbrook
// Assignment 8
// CPT-236-S44
// Fall 2021
// A basic constructor that has string manipulation methods
// Bonus caesar method for fun


public class AnyString {

    private String storedStringValue;

    public AnyString(String storedStringValue) {
        this.storedStringValue = storedStringValue; //no default value, no overloaded method
    }
    public String getString(){
        return this.storedStringValue;
    }
    public String lowercase(){
        return this.storedStringValue.toLowerCase();
    }
    public String uppercase(){
        return this.storedStringValue.toUpperCase();
    }
    public int getLength(){
        return this.storedStringValue.length();
    }
    //Bonus method (from previous assignments)
    public String getCaesar(){
        String caesarLine = "";
        String userInput = this.storedStringValue;
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
        return caesarLine;
    }
}
