// Marshall Westbrook
// Assignment 8
// CPT-236-S44
// Fall 2021
// Constructors, Objects Revisited, Instantiation of Objects, Methods, and Method calls
// Bonus caesar method call for fun

import java.util.Scanner;
public class TestAnyStringClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());
        System.out.print("Input a sentence:");
        String userString = input.next();
        AnyString stringConverter = new AnyString(userString);
        System.out.println("---------------------------------------------");
        System.out.println("The string is: " + stringConverter.getString());
        System.out.println("The string in lowercase is: " + stringConverter.lowercase());
        System.out.println("The string in uppercase is: " + stringConverter.uppercase());
        System.out.println("The string's length is: " + stringConverter.getLength());
        System.out.println("Bonus Caesar method output: " + stringConverter.getCaesar());
        System.out.println("---------------------------------------------");
        input.close();    
    }
    
}
