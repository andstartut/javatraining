package threads.mainTask.Abstract;

import threads.mainTask.Enum.PassengerClass;

public abstract class AbstractWagon {
    private int passengers;
    private int luggage;
    private PassengerClass comfortClass;

    public AbstractWagon(PassengerClass comfortClass) {
        this.comfortClass = comfortClass;
        setPassengersAndLuggage();
    }

    public String getComfortClass() {
        return comfortClass.name();
    }

    public int getComfortClassOrder() {
        return comfortClass.ordinal();
    }

    private void setPassengersAndLuggage() {
        switch (comfortClass) {
            case COMPARTMENT:
                passengers = 36;
                luggage = 1296;
                break;
            case SITTING:
                passengers = 62;
                luggage = 2232;
                break;
            case ECONOMY:
                passengers = 54;
                luggage = 1944;
                break;
            case FIRST:
                passengers = 18;
                luggage = 648;
                break;
            default:
                passengers = 0;
                luggage = 0;
                break;
        }
    }

    public int getLuggage() {
        return luggage;
    }

        public int getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                "passengers=" + passengers +
                ", luggage=" + luggage +
                ", comfortClass=" + comfortClass +
                '}';
    }
}
