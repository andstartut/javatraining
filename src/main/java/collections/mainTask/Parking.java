package collections.mainTask;

import java.util.Arrays;
import java.util.Random;

public class Parking {
    private String[] parking;
    private Random random;
    private String parkingSpace;
    private int parkingLength;


    public Parking(int parkingLength) {
        this.parkingLength = parkingLength;
        random = new Random();
        setParkingLength();
        filling();
    }

    private String[] setParkingLength() {
        parking = new String[parkingLength];
        return parking;
    }

    private void filling() {
        for (int i = 0; i < parking.length; i++) {
            if (random.nextInt() > 0) {
                parkingSpace = "Занято";
            } else {
                parkingSpace = "Свободно";
            }
            parking[i] = parkingSpace;
        }
    }

    public void searchPlace() {
        for (int i = 0; i < parking.length; i++) {
            if (parking[i] == "Свободно") {
                System.out.println("Свободное место №" + i);
            }
        }
    }

    public void takePlace(int place) {
        if (place > 0 && place <= parkingLength) {
            for (int i = (place - 1); i < parking.length; i++) {
                if (parking[i] == "Свободно") {
                    parking[i] = "Занято";
                    break;
                } else if (i == (parkingLength - 1)) {
                    System.out.println("Свободный мест нет.");
                }
            }
        } else {
            System.out.println("Такого места не существует.");
        }
    }

    public void clearPlace() {
        for (int i = 0; i < parking.length; i++) {
            int place = random.nextInt(parkingLength);
            if (parking[place] == "Занято") {
                parking[place] = "Свободно";
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "parking=" + Arrays.toString(parking);
    }
}
