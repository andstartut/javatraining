package collections.mainTask;

import java.util.*;

public class MainTaskRunner {
    public static void main(String[] args) {
/**
 * Быстрее работает linkedlist т.к. после удаление элемента переопределяются
 * ссылки на предыдущий и следующий элемент, что быстрее, чем
 * удаление элемента и последующий сдвиг элементов правой части в arraylist.
 */
        RemoveFromCircle circle = new RemoveFromCircle(50000);
        System.out.println(circle);

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        Sort sort = new Sort(array, 50);
        System.out.println(sort);

        Parking parking = new Parking(10);
        System.out.println(parking);
        parking.takePlace(11);
        System.out.println(parking);
        parking.clearPlace();
        System.out.println(parking);
    }
}
