package threads.optionalTask;

import threads.optionalTask.Enum.ComfortClass;
import threads.optionalTask.Enum.Destination;
import threads.optionalTask.Models.Information;
import threads.optionalTask.Models.Train;

import java.util.Arrays;
import java.util.List;

public class OptionalTaskRunner {
    public static void main(String[] args) {
        List<Train> trains = Arrays.asList(
                new Train.Builder()
                        .setTrainNumber(24)
                        .setDepartureTime(13, 11)
                        .setDestination(Destination.BREST)
                        .setSeatsComfortClass(ComfortClass.ECONOMY, 248)
                        .setSeatsComfortClass(ComfortClass.COMPARTMENT, 216)
                        .setSeatsComfortClass(ComfortClass.COUPE, 144)
                        .builder(),
                new Train.Builder()
                        .setTrainNumber(23)
                        .setDepartureTime(9, 28)
                        .setDestination(Destination.MINSK)
                        .setSeatsComfortClass(ComfortClass.ECONOMY, 248)
                        .setSeatsComfortClass(ComfortClass.COMPARTMENT, 216)
                        .setSeatsComfortClass(ComfortClass.COUPE, 144)
                        .builder(),
                new Train.Builder()
                        .setTrainNumber(2)
                        .setDepartureTime(18, 42)
                        .setDestination(Destination.BERLIN)
                        .setSeatsComfortClass(ComfortClass.COMPARTMENT, 108)
                        .setSeatsComfortClass(ComfortClass.COUPE, 144)
                        .setSeatsComfortClass(ComfortClass.LUX, 72)
                        .builder(),
                new Train.Builder()
                        .setTrainNumber(3)
                        .setDepartureTime(2, 30)
                        .setDestination(Destination.MOSCOW)
                        .setSeatsComfortClass(ComfortClass.COMPARTMENT, 108)
                        .setSeatsComfortClass(ComfortClass.COUPE, 144)
                        .setSeatsComfortClass(ComfortClass.LUX, 72)
                        .builder(),
                new Train.Builder()
                        .setTrainNumber(67)
                        .setDepartureTime(15, 5)
                        .setDestination(Destination.MINSK)
                        .setSeatsComfortClass(ComfortClass.ECONOMY, 372)
                        .setSeatsComfortClass(ComfortClass.COMPARTMENT, 216)
                        .builder()
        );

        Information info = new Information(trains);
        System.out.println(info.sortByDestination(Destination.MINSK));
        System.out.println(info.sortByDestinationAndTime(Destination.MINSK, 15, 5));
        System.out.println(info.sortByDestinationAndEconomy(Destination.BREST, ComfortClass.ECONOMY));
    }
}
