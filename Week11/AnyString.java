// Marshall Westbrook
// Assignment 9
// CPT-236-S44
// Fall 2021
// An object with two constructors
import java.util.Scanner;

public class AnyString {
    //private vehicle for string value
    private String storedStringValue;
    
    public AnyString(String storedStringValue) {
        //no default value
        this.storedStringValue = storedStringValue; 
    }
    public AnyString(char[] storedCharacterArray){ //overloaded with char array
        //Storing char array as string
        this.storedStringValue = new String(storedCharacterArray);
        //TODO: should we be validating this data?
    }
    public static void main(String[] args){
        //basic test of AnyString class
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());
        System.out.print("Enter a string to test:");
        String simpleInput = input.next();
        AnyString sampleAnyString = new AnyString(simpleInput);
        System.out.println("Our input: " + sampleAnyString.toString());
        AnyString secondAnyString = new AnyString("test");
        System.out.println("Is our input equal to \"" + secondAnyString + "\": " + sampleAnyString.equals(secondAnyString));
        System.out.println("Does our input only contain letters: " + sampleAnyString.isLetters());
        System.out.println("Dour our input only contain numbers: " + sampleAnyString.isNumeric());
        System.out.println("Lowercase: " + sampleAnyString.lowercase());
        System.out.println("Uppercase: " + sampleAnyString.uppercase());
        System.out.println("Length: " + sampleAnyString.getLength());

        
        //Character array test
        System.out.println("----------------------------");
        char[] simpleInputA = {'t','e','s','t'};
        AnyString sampleAnyStringA = new AnyString(simpleInputA);
        System.out.println("Our character array input is: " + sampleAnyStringA.toString());
        System.out.println("Checking if our character array input is equal to \"" + secondAnyString + "\": " + sampleAnyStringA.equals(secondAnyString));
        System.out.println("Does our input character array input only contain letters: " + sampleAnyStringA.isLetters());
        System.out.println("Dour our input character array input only contain numbers: " + sampleAnyStringA.isNumeric());
        System.out.println("Lowercase: " + sampleAnyStringA.lowercase());
        System.out.println("Uppercase: " + sampleAnyStringA.uppercase());
        System.out.println("Length: " + sampleAnyStringA.getLength());
    }
    //simply returns the only instance variable the object has
    public String toString(){
        return this.storedStringValue;
    }
    //checks if the the given string is equal to the object's string (via the String.equals class)
    //also checks if the objects themselves are equal(by ID in memory)
    public boolean equals(AnyString anyObject){
        //default return value is false
        boolean isEquals = false;
        //System.out.println(anyObject.getString() + " " + this.getString()); //test string
        if(anyObject.getString().equals(this.getString()) || anyObject == this){
            isEquals = true;
        }
        else{
            //do nothing
        }
        return isEquals;
    }
    public boolean isLetters(){
        //create a temporary character array to ensure we don't change the object's instance variable
        char[] tempCharArray = this.storedStringValue.toCharArray();
        for(char c : tempCharArray){
            if (Character.isLetter(c)){ //using the Character class to check if each character is a letter
            //do nothing here
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean isNumeric(){
         //storing to ensure we don't change the object's value on accident
        char[] tempCharArray = this.storedStringValue.toCharArray();
        for(char c : tempCharArray){
            if (Character.isDigit(c)){ //using Character class to check if it's a number
            //do nothing here
            }
            else{
                return false;
            }
        }
        return true;
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
}
