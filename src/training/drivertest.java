package training;

import java.util.Scanner;


public class drivertest  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the two numbers");
try{
    int num1 = input.nextInt();
    int num2 = input.nextInt();
        System.out.println("The result is: " + (num1 / num2));

}catch(ArithmeticException e){
    System.out.println("Error: " + e.getMessage());
}
}

}
