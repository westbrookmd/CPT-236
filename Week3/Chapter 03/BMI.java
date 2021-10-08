import java.util.Scanner; 

public class BMI 
{
    public static void main(String[] args) 
    {
        // 1. Generate two random single-digit integers

        Scanner input = new Scanner(System.in);
        double height = input.nextDouble();
        double weight = input.nextDouble();
        double bMI = weight / (Math.pow(height, 2));

        // 2. If number1 < number2, swap number1 with number2
        if (bMI < 18.5) 
        {
        System.out.println("You are underweight. Your BMI is: " + bMI);
        }
        else if (bMI < 25.0) 
        {
            System.out.println("You are normal weight. Your BMI is: " + bMI);
        }
        else if (bMI < 30.0) 
        {
            System.out.println("You are overweight. Your BMI is: " + bMI);
        }
        else 
        {
            System.out.println("You are obese. Your BMI is: " + bMI);
        }
    }
}