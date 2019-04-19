package fundamentals.optionalTasks;

import java.util.Random;

public class OptionalTaskOne {
    private Random generator = new Random();
    private int[] random = new int[10];
    private int[] tenNumbers = {1538, 42, 1, 345, 99999, 2468, -357, 0, 87, 54321};

    public OptionalTaskOne() {
        findShortAndLongNumbers(tenRandomNumbers());
        ascendingOrder(tenRandomNumbers());
        numbersSmallerMiddleValue(tenNumbers);
        numbersWithDigitsAscendingOrder(tenNumbers);
    }


    private int[] tenRandomNumbers() {
        for (int i = 0; i < random.length; i++) {
            random[i] = generator.nextInt(1000000);
        }
        return random;
    }

    private void findShortAndLongNumbers(int numbers[]) {
        int shortNumber = numbers[0];
        int longNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (shortNumber > numbers[i]) {
                shortNumber = numbers[i];
            } else if (longNumber < numbers[i]) {
                longNumber = numbers[i];
            }
        }
        if (String.valueOf(shortNumber).length() == String.valueOf(longNumber).length()) {
            System.out.println("\nВсе числа равны по длине\n");
        } else {
            System.out.println(
                    "\nКороткое число: " + shortNumber +
                            " и его длина: " + String.valueOf(shortNumber).length() + "\n" +
                            "Длинное число: " + longNumber +
                            " и его длина: " + String.valueOf(longNumber).length()
            );
        }
    }

    private void ascendingOrder(int[] numbers) {
        System.out.print("\nДо:    ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                int nextNumber = numbers[j + 1];
                int currentNumber = numbers[j];
                if (String.valueOf(currentNumber).length() > String.valueOf(nextNumber).length()) {
                    numbers[j + 1] = currentNumber;
                    numbers[j] = nextNumber;
                }
            }
        }
        System.out.print("\nПосле: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    private void numbersSmallerMiddleValue(int[] numbers) {
        System.out.print("\nДо:    ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        int shortNumber = String.valueOf(numbers[0]).length();
        int longNumber = String.valueOf(numbers[0]).length();
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = String.valueOf(numbers[i]).length();
            if (shortNumber > currentNumber) {
                shortNumber = currentNumber;
            } else if (longNumber < currentNumber) {
                longNumber = currentNumber;
            }
        }
        int middleValue = (longNumber + shortNumber) / 2;
        System.out.print("\nМеньше среднего значения (" + middleValue + "): ");
        for (int i = 0; i < numbers.length; i++) {
            if (String.valueOf(numbers[i]).length() < middleValue) {
                System.out.print(numbers[i] + " (" + String.valueOf(numbers[i]).length() + "); ");
            }
        }
    }

    private void numbersWithDigitsAscendingOrder(int[] numbers) {
        int digit = 10;
        for (int i = 0; i < numbers.length; i++) {
            if (String.valueOf(numbers[i]).length() > 1) {
                int number = numbers[i];
                while (number != 0) {
                    int previousDigit = digit;
                    digit = number % 10;
                    if (digit < previousDigit) {
                        number = number / 10;
                    } else {
                        digit = 10;
                        break;
                    }
                }
                if (number == 0) {
                    System.out.println("\nПервое число с возростанием: " + numbers[i]);
                    break;
                }
            }
        }
    }
}
