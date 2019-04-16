package fundamentals.mainTask.Interfaces;

import fundamentals.mainTask.Enum.Ingredients;
import fundamentals.mainTask.Enum.PizzaBase;

import java.util.List;

public interface IPizza {
    List<Ingredients> getIngredients();
    PizzaBase getPizzaBase();
    int getNumberPizza();
    String getNamePizza();
}
