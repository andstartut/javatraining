package fundamentals.optionalTasks;

import java.util.Random;
import java.util.Scanner;

public class OptionalTaskThree {
    private int[][] matrix;
    Random random = new Random();

    public OptionalTaskThree() {
        System.out.print("Введите n-размерность матрицы a[n][n]: ");
        Scanner scanner = new Scanner(System.in);
        int console = validateScanner(scanner);
        matrix = new int[console][console];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextInt((99)) * (random .nextBoolean() ? -1 : 1);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }

    }

    private int validateScanner(Scanner scanner) {
        int console = 0;
        if (scanner.hasNextInt()) {
            console = scanner.nextInt();
            if (console < 2 || console > 10) {
                System.out.println("Вы ввели не допустимое значение.\nПопробуйте диапазон от 2 до 10.");
                System.exit(-1);
            }
        } else {
            System.out.println("Вы ввели не допустимое значение.\nПопробуйте ввесьт целое число от 2 до 10.");
            System.exit(-1);
        }
        return console;
    }
}
