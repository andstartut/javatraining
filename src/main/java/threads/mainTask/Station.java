package threads.mainTask;

import threads.mainTask.Models.PassengerWagon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station {
    private Train train;

    public Station(Train train) {
        this.train = train;
    }

    public int getAllPassengers() {
        int summ = 0;
        for (PassengerWagon wagon : train.wagons) {
            summ += wagon.getPassengers();
        }
        return summ;
    }

    public int getAllLuggage() {
        int summ = 0;
        for (PassengerWagon wagon : train.wagons) {
            summ += wagon.getLuggage();
        }
        return summ;
    }

    public void sortByComfort() {
        Collections.sort(train.wagons);
    }

    public List<PassengerWagon> enterNumberPassengers(int numberPassengeres) {
        List<PassengerWagon> validateWagons = new ArrayList<PassengerWagon>();
        for (PassengerWagon wagon: train.wagons) {
            if (wagon.getPassengers() >= numberPassengeres) {
                validateWagons.add(wagon);
            }
        }
        return validateWagons;
    }

    @Override
    public String toString() {
        return "Station{" +
                "train=" + train +
                '}';
    }
}
