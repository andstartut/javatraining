package fundamentals;

import java.util.Scanner;

public class GettingStarted {

    public GettingStarted() {
    }

    public GettingStarted helloUser() {
        System.out.println("Enter your name: ");
        Scanner console = new Scanner(System.in);
        System.out.println("Hello, " + console.nextLine() + "!");
        return null;
    }

    public void reversOrderConsoleArguments(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }

}