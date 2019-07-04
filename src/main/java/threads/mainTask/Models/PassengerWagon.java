package threads.mainTask.Models;

import threads.mainTask.Abstract.AbstractWagon;
import threads.mainTask.Enum.PassengerClass;

public class PassengerWagon extends AbstractWagon implements Comparable<PassengerWagon> {
    public PassengerWagon(PassengerClass passengerClass) {
        super(passengerClass);
    }

    @Override
    public String getComfortClass() {
        return super.getComfortClass();
    }

    @Override
    public int getLuggage() {
        return super.getLuggage();
    }

    @Override
    public int getPassengers() {
        return super.getPassengers();
    }

    @Override
    public int compareTo(PassengerWagon o) {
        return this.getComfortClassOrder() - o.getComfortClassOrder();
    }
}
