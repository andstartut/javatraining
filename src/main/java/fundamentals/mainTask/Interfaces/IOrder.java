package fundamentals.mainTask.Interfaces;

import fundamentals.mainTask.Pizza;

public interface IOrder {
    int getClient();
    String validateNamePizza(Pizza pizza);
    void pizzaAttributs();
}
