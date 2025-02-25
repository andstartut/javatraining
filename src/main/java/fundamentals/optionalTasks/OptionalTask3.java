package fundamentals.optionalTasks;

public class OptionalTask3 {

    public OptionalTask3(int number) {
        validate(number);
        months(number);
    }

    private int validate(int number) {
        if (number < 1 || number > 12) {
            System.out.println("Введено неверное число месяца.");
            System.exit(-1);
        }
        return number;
    }

    private void months(int number) {
        String month = null;
        switch (number) {
            case 1:
                month = "Январь";
                break;
            case 2:
                month = "Февраль";
                break;
            case 3:
                month = "Март";
                break;
            case 4:
                month = "Апрель";
                break;
            case 5:
                month = "Май";
                break;
            case 6:
                month = "Июнь";
                break;
            case 7:
                month = "Июль";
                break;
            case 8:
                month = "Август";
                break;
            case 9:
                month = "Сентябрь";
                break;
            case 10:
                month = "Октябрь";
                break;
            case 11:
                month = "Ноябрь";
                break;
            case 12:
                month = "Декабрь";
                break;
        }
        System.out.println(month);
    }
}
