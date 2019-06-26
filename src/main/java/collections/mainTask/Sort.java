package collections.mainTask;

import java.util.Arrays;

public class Sort {
    int[] array;
    int numberY;
    long spentTime;

    public Sort(int[] array, int numberY) {
        this.array = array;
        this.numberY = numberY;
        myQuickSort();
    }

    private void myQuickSort() {
        int leftMarker = 0;
        int rightMarket = array.length - 1;
        long startTimer = System.currentTimeMillis();
        while (leftMarker < rightMarket) {
            while (array[leftMarker] < numberY) {
                leftMarker++;
            }
            while (array[rightMarket] > numberY) {
                rightMarket--;
            }

            if (leftMarker <= rightMarket) {
                int temp = array[leftMarker];
                array[leftMarker] = array[rightMarket];
                array[rightMarket] = temp;
                leftMarker++;
                rightMarket--;
            }
        }
        long stopTimer = System.currentTimeMillis();
        spentTime = stopTimer - startTimer;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "array=" + Arrays.toString(array) +
                ", spentTime=" + spentTime +
                "ms}";
    }
}
