package fundamentals;

import java.util.Scanner;

public class GettingStarted {

    public void helloUser() {
        System.out.print("Enter your name: ");
        Scanner console = new Scanner(System.in);
        System.out.println("Hello, " + console.nextLine() + "!\n");
    }

    public void reversOrderConsoleArguments(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
        System.out.println("\n");
    }

    public void randomNumbers() {
        float[] numbers = {5f, 3f, 1.2f, 9.4f};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n");
    }

    public void sumNumbers(String[] args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum = sum + Integer.parseInt(args[i]);
        }
        System.out.println(sum);
    }
}