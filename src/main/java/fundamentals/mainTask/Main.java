package fundamentals.mainTask;

import fundamentals.mainTask.Enum.Ingredients;
import fundamentals.mainTask.Enum.PizzaBase;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Pizza> wrongPizza = Arrays.asList(
                new Pizza.Builder()
                        .setNamePizza("Margarita")
                        .setNumberPizza(1)
                        .setPizzaBase(PizzaBase.NORMAL)
                        .addIngredient(Ingredients.BACON)
                        .addIngredient(Ingredients.PEPPERONI)
                        .addIngredient(Ingredients.GARLIC)
                        .addIngredient(Ingredients.TOMATO_PASTE)
                        .addIngredient(Ingredients.PEPPERONI)
                        .build(),
                new Pizza.Builder()
                        .setNamePizza("PepperoniOro")
                        .setNumberPizza(3)
                        .setPizzaBase(PizzaBase.CALZONE)
                        .addIngredient(Ingredients.TOMATO_PASTE)
                        .addIngredient(Ingredients.CHEESE)
                        .addIngredient(Ingredients.PEPPERONI)
                        .addIngredient(Ingredients.OLIVES)
                        .build()
        );
        List<Pizza> pizzasOne = Arrays.asList(
                new Pizza.Builder()
                        .setNamePizza("Margarita")
                        .setPizzaBase(PizzaBase.CALZONE)
                        .setNumberPizza(2)
                        .addIngredient(Ingredients.TOMATO_PASTE)
                        .addIngredient(Ingredients.GARLIC)
                        .addIngredient(Ingredients.PEPPERONI)
                        .addIngredient(Ingredients.BACON)
                        .build(),
                new Pizza.Builder()
                        .setNamePizza("PepperoniOro")
                        .setNumberPizza(3)
                        .setPizzaBase(PizzaBase.CALZONE)
                        .addIngredient(Ingredients.TOMATO_PASTE)
                        .addIngredient(Ingredients.CHEESE)
                        .addIngredient(Ingredients.PEPPERONI)
                        .addIngredient(Ingredients.OLIVES)
                        .build()
        );
        List<Pizza> pizzasTwo = Arrays.asList(
                new Pizza.Builder()
                        .setNumberPizza(12)
                        .setPizzaBase(PizzaBase.NORMAL)
                        .setNamePizza("BasePZZ")
                        .build()
        );

        new Order(4578, wrongPizza);
        new Order(4372, pizzasTwo);
        Order order = new Order(7717, pizzasOne);
        System.out.println(order);
        order.pizzaAttributs();
    }
}
