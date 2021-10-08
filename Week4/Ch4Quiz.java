import java.util.Scanner;
public class Ch4Quiz {
    
    public static void main(String[] args) {
    
        // scanner for user input
        Scanner input = new Scanner(System.in);
        // set separator as white space for sentences later
        input.useDelimiter(System.lineSeparator());
        // prompting user for input
        //System.out.print("Enter a single letter to add:");
        // gathering input as a string
        //String userInput = input.next();
        // converting string to char so that I don't have to repeat .charAt(0) for every comparison. I have a working caesar at the bottom for sentences with a set shift of 1.
        // this will only get the first char that the user inputted
        //char userChar = userInput.charAt(0);
        System.out.println("A" + 1);
        System.out.println("Java".toUpperCase());
        String s = "4";
        System.out.println(Double.parseDouble(s));
        char x = 'b';
        System.out.println(++x);


    }
        
    }

