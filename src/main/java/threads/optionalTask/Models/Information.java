package threads.optionalTask.Models;

import threads.optionalTask.Enum.ComfortClass;
import threads.optionalTask.Enum.Destination;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Information {
    List<Train> trains;

    public Information(List<Train> trains) {
        this.trains = trains;
    }

    public List<Train> sortByDestination(Destination destination) {
        List<Train> sortByDestination = new ArrayList<>();
        for (Train train : trains) {
            if (destination == train.getDestination()) {
                sortByDestination.add(train);
            }
        }
        return sortByDestination;
    }

    public List<Train> sortByDestinationAndTime(Destination destination, int hour, int minutes) {
        List<Train> sortByDestinationAndTime = new ArrayList<>();
        for (Train train : trains) {
            if (destination == train.getDestination() &&
                    hour == train.getDepartureTime().get(Calendar.HOUR_OF_DAY) &&
                    minutes == train.getDepartureTime().get(Calendar.MINUTE)) {
                sortByDestinationAndTime.add(train);
            }
        }
        return sortByDestinationAndTime;
    }

    public List<Train> sortByDestinationAndEconomy(Destination destination, ComfortClass comfort) {
        List<Train> sortByDestinationAndEconomy = new ArrayList<>();
        for (Train train : trains) {
            if (destination == train.getDestination() &&
                    train.getTotalSeats().containsKey(comfort)) {
                sortByDestinationAndEconomy.add(train);
            }
        }
        return sortByDestinationAndEconomy;
    }

    @Override
    public String toString() {
        return "Information{" +
                "trains=" + trains +
                '}';
    }
}
