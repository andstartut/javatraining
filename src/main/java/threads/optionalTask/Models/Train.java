package threads.optionalTask.Models;

import threads.optionalTask.Enum.ComfortClass;
import threads.optionalTask.Enum.Destination;

import java.util.*;

public class Train {
    Destination destination;
    int trainNumber;
    Calendar departureTime;
    Map<ComfortClass, Integer> totalSeats;

    public Train(Destination destination, int trainNumber, int hour, int minutes, Map<ComfortClass, Integer> totalSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime.set(Calendar.HOUR_OF_DAY, hour);
        this.departureTime.set(Calendar.MINUTE, minutes);
        this.totalSeats = totalSeats;
    }

    public Train(Builder builder) {
        this.destination = builder.destination;
        this.trainNumber = builder.trainNumber;
        this.departureTime = builder.departureTime;
        this.totalSeats = builder.totalSeats;
    }

    public static class Builder {
        private Destination destination;
        private int trainNumber;
        private Calendar departureTime = new GregorianCalendar();
        private Map<ComfortClass, Integer> totalSeats = new HashMap<>();

        public Builder setDestination(Destination destination) {
            this.destination = destination;
            return this;
        }

        public Builder setTrainNumber(int trainNumber) {
            this.trainNumber = trainNumber;
            return this;
        }

        public Builder setDepartureTime(int hour, int minutes) {
            departureTime.set(Calendar.HOUR_OF_DAY, hour);
            departureTime.set(Calendar.MINUTE, minutes);
            return this;
        }

        public Builder setSeatsComfortClass(ComfortClass comfortClass, Integer seats) {
            totalSeats.put(comfortClass, seats);
            return this;
        }
        public Train builder() {
            return new Train(this);
        }
    }

    public Destination getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Map<ComfortClass, Integer> getTotalSeats() {
        return totalSeats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", trainNumber=" + trainNumber +
                ", departureTime=" + departureTime.get(Calendar.HOUR_OF_DAY) +
                ":" + departureTime.get(Calendar.MINUTE) +
                ", totalSeats=" + totalSeats +
                '}';
    }
}
