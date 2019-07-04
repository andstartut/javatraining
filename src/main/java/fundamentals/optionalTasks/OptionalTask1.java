package fundamentals.optionalTasks;

import java.util.Random;

public class OptionalTask1 {

    private Random generator = new Random(20);
    private int[] random = new int[10];

    public OptionalTask1(String[] args) {
        commandLineArgumentsInReverseOrder(args);
        outputCommandLineArguments();
    }

    private void commandLineArgumentsInReverseOrder(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }

    private void outputCommandLineArguments() {
        for (int i = 0; i < random.length; i++) {
            random[i] = generator.nextInt(10);
        }
        System.out.println("\nВывод случайных чисел с переходом и без перехода на новую строку:");
        for (int i = 0; i < random.length; i++) {
            System.out.println(random[i]);
        }
        for (int i = 0; i < random.length; i++) {
            System.out.print(random[i] + " ");
        }
    }
}
