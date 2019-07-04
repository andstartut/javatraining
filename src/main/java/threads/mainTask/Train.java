package threads.mainTask;

import threads.mainTask.Models.Locomotive;
import threads.mainTask.Models.PassengerWagon;

import java.util.ArrayList;
import java.util.List;

public class Train {
    int trainNumber;
    Locomotive locomotive;
    List<PassengerWagon> wagons;

    public Train(Builder builder) {
        this.trainNumber = builder.trainNumber;
        this.locomotive = builder.locomotive;
        this.wagons = builder.wagons;
    }

    public static class Builder {
        int trainNumber;
        Locomotive locomotive;
        List<PassengerWagon> wagons = new ArrayList();

        public Builder setTrainNumber(int trainNumber) {
            this.trainNumber = trainNumber;
            return this;
        }

        public Builder setLocomotive(Locomotive locomotive) {
            this.locomotive = locomotive;
            return this;
        }

        public Builder addWagon(PassengerWagon wagon) {
            wagons.add(wagon);
            return this;
        }

        public Train builder() {
            return new Train(this);
        }
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", locomotive=" + locomotive +
                ", wagons=" + wagons +
                '}';
    }
}
