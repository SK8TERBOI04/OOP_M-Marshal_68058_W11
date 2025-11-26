package practice;

import java.util.Scanner;

public class MultipleCatchExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Input number: ");
            int number = Integer.parseInt(scan.nextLine());

            int result = 10 / number;
            System.out.println("Result : " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Input must be a number!");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }

        System.out.println("Program continues...");
        scan.close();
    }
}
