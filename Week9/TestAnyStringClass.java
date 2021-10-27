import java.util.Scanner;
import java.util.scanner;
public class TestAnyStringClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());
        System.out.print("Input a sentence:");
        String userString = input.next();
        AnyString stringConverter = new AnyString(userString);
        System.out.println(stringConverter.getString());
        System.out.println(stringConverter.lowercase());
        System.out.println(stringConverter.uppercase());
        System.out.println(stringConverter.getLength());    }
    
}
