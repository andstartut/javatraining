package fundamentals.optionalTasks;

import java.util.*;

public class OptionalTask4 {
    private int[][] matrix;
    Random random = new Random();

    public OptionalTask4() {
        System.out.print("Введите n-размерность матрицы a[n][n]: ");
        Scanner scanner = new Scanner(System.in);
        createMatrix(validateScanner(scanner));
        sumOfElementsBetweenFirstAndSecondPositiveElements();
        delRowAndColumnContainsMaxElement();
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

    private void createMatrix(int console) {
        matrix = new int[console][console];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextInt((29)) * (random.nextBoolean() ? -1 : 1);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void sumOfElementsBetweenFirstAndSecondPositiveElements() {
        int firstPositiveElement = 0;
        int sumElements = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (firstPositiveElement > 0 && matrix[i][j] > 0 && matrix[i][j - 1] < 0) {
                    j = matrix.length;
                } else if (matrix[i][j] <= 0 && firstPositiveElement != 0) {
                    sumElements += matrix[i][j];
                } else if (matrix[i][j] > 0 && j < matrix.length) {
                    firstPositiveElement = matrix[i][j];
                }
            }
            System.out.println("Сумма элементов " + i + " строки: " + sumElements);
            firstPositiveElement = 0;
            sumElements = 0;
        }
    }

    private int[][] delRowAndColumnContainsMaxElement() {
        int maxElement = 0;
        TreeSet<Integer> coordinateX = new TreeSet();
        TreeSet<Integer> coordinateY = new TreeSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (Math.abs(matrix[i][j]) > maxElement) {
                    maxElement = Math.abs(matrix[i][j]);
                }
            }
        }
        System.out.println("Максимальный элемент: " + maxElement);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (Math.abs(matrix[i][j]) == maxElement) {
                    System.out.println("Координаты элемента x:" + i + " y:" + j);
                    coordinateX.add(i);
                    coordinateY.add(j);
                }
            }
        }
        int[][] filteredMatrix = new int[matrix.length - coordinateX.size()][matrix.length - coordinateY.size()];
        int xForOldMatrix = 0;
        int yForOldMatrix = 0;
        for (int i = 0; i < matrix.length - coordinateX.size(); i++) {

            for (int x: coordinateX) {
                if (xForOldMatrix == x) {
                    xForOldMatrix++;
                }else {
                    continue;
                }
            }
            for (int j = 0; j < matrix.length - coordinateY.size(); j++) {
                for (int y: coordinateY) {
                    if (yForOldMatrix == y) {
                        yForOldMatrix++;
                    }
                    filteredMatrix[i][j] = matrix[xForOldMatrix][yForOldMatrix];
                }
                yForOldMatrix++;
            }
            yForOldMatrix = 0;
            xForOldMatrix++;
        }
        for (int i = 0; i < matrix.length - coordinateX.size(); i++) {
            System.out.println();
            for (int j = 0; j < matrix.length - coordinateY.size(); j++) {
                System.out.print(filteredMatrix[i][j] + " ");
            }
        }
        return filteredMatrix;
    }
}
