package fundamentals.mainTask;

import java.io.*;
import java.util.Scanner;

public class OrderCounter {
    private int orderNumber;

    public void addPizzaToOrder() {
        File file = new File("order.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (getPizzaCounterNumber() >= 99999) {
            orderNumber = 10000;
        }
        try (FileWriter writer = new FileWriter("order.txt", false)) {
            writer.write(String.valueOf(orderNumber += 1));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public int getPizzaCounterNumber() {
        String numberOrder = null;
        try (FileReader reader = new FileReader("order.txt")) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                numberOrder = scan.nextLine();
            }
            if (numberOrder == null) {
                orderNumber = 10000;
            } else {
                orderNumber = Integer.valueOf(numberOrder);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ещё небыло ни одного заказа.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderNumber;
    }
}
