package collections.mainTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class RemoveFromCircle {
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private int sizeList;
    private int countIndex = 0;
    private float arrayListTime;
    private float linkedListTime;

    public RemoveFromCircle(int sizeList) {
        this.sizeList = sizeList;
        fillingLists();
        removeEvenNumbersArrayList();
        clearCounter();
        removeEvenNumbersLinkedList();
    }

    private void fillingLists() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 1; i <= sizeList; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    private void removeEvenNumbersArrayList() {
        sizeList = arrayList.size();
        if (sizeList > 1) {
            Iterator<Integer> iterator = arrayList.iterator();
            long startArrayListTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                countIndex++;
                iterator.next();
                if (countIndex % 2 == 0) {
                    iterator.remove();
                }
            }
            long stopArrayListTime = System.currentTimeMillis();
            arrayListTime += stopArrayListTime - startArrayListTime;
            removeEvenNumbersArrayList();
        }
    }

    private void removeEvenNumbersLinkedList() {
        sizeList = linkedList.size();
        if (sizeList > 1) {
            Iterator<Integer> iterator = linkedList.iterator();
            long startLinkedListTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                countIndex++;
                iterator.next();
                if (countIndex % 2 == 0) {
                    iterator.remove();
                }
            }
            long stopLinkedListTime = System.currentTimeMillis();
            linkedListTime += stopLinkedListTime - startLinkedListTime;
            removeEvenNumbersLinkedList();
        }
    }

    private int clearCounter() {
        return countIndex = 0;
    }

    @Override
    public String toString() {
        return "RemoveFromCircle{" +
                "arrayList=" + arrayList +
                ", linkedList=" + linkedList +
                ", arrayListTime=" + arrayListTime + "ms" +
                ", linkedListTime=" + linkedListTime + "ms" +
                '}';
    }
}

