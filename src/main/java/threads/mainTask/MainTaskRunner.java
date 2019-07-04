package threads.mainTask;

import threads.mainTask.Enum.LocomotiveName;
import threads.mainTask.Enum.PassengerClass;
import threads.mainTask.Models.Locomotive;
import threads.mainTask.Models.PassengerWagon;

public class MainTaskRunner {
    public static void main(String[] args) {
        Train train = new Train.Builder()
                .setTrainNumber(24)
                .setLocomotive(new Locomotive(LocomotiveName.CHS4T))
                .addWagon(new PassengerWagon(PassengerClass.COMPARTMENT))
                .addWagon(new PassengerWagon(PassengerClass.COMPARTMENT))
                .addWagon(new PassengerWagon(PassengerClass.FIRST))
                .addWagon(new PassengerWagon(PassengerClass.FIRST))
                .addWagon(new PassengerWagon(PassengerClass.COMPARTMENT))
                .addWagon(new PassengerWagon(PassengerClass.COMPARTMENT))
                .addWagon(new PassengerWagon(PassengerClass.ECONOMY))
                .builder();

        Station station = new Station(train);
        System.out.println("Общее число пассажиров: " + station.getAllPassengers());
        System.out.println("Общий вес багажа: " + station.getAllLuggage());
        station.sortByComfort();
        System.out.println("Сортировка по классу вагонов: " + station);
        System.out.println("Вагоны, соответствующие числу пассажиров: " + station.enterNumberPassengers(42));
    }
}
