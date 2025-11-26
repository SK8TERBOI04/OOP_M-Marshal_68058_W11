package practice;

public class ArithmeticExample {
    public static void main(String[] args) {
        try {
            int a = 5 / 0;   // ArithmeticException
            System.out.println("Result : " + a);
        } catch (ArithmeticException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
