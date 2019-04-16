package fundamentals.mainTask;

import fundamentals.mainTask.Interfaces.IOrder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.*;

public class Order implements IOrder {
    OrderCounter counter = new OrderCounter();
    private List<Pizza> pizzas;
    private int client;
    private float totalPrice;
    private float priceOfPizza;

    public Order(int client, List<Pizza> pizzas) {
        this.client = client;
        this.pizzas = pizzas;
        counter.addPizzaToOrder();
        pizzaAttributs();
        System.out.println(LocalTime.now());
    }

    @Override
    public int getClient() {
        return client;
    }

    public float totalPrice(float priceOfPizza) {
        return totalPrice += priceOfPizza;
    }

    @Override
    public String validateNamePizza(Pizza pizza) {
        String namePizza;
        if (pizza.getNamePizza().length() < 4 || pizza.getNamePizza().length() > 20) {
            namePizza = "Клиент " + counter.getPizzaCounterNumber();
        } else {
            namePizza = pizza.getNamePizza();
        }
        return namePizza;
    }

    private void priceOfPizza(Pizza pizza) {
        switch (pizza.getPizzaBase()) {
            case NORMAL:
                priceOfPizza += 1f;
                break;
            case CALZONE:
                priceOfPizza += 1.5f;
                break;
        }
        for (int i = 0; i < pizza.getIngredients().size(); i++) {
            switch (pizza.getIngredients().get(i)) {
                case TOMATO_PASTE:
                    priceOfPizza += 1f;
                    break;
                case CORN:
                    priceOfPizza += 0.7f;
                    break;
                case BACON:
                    priceOfPizza += 1.2f;
                    break;
                case CHEESE:
                    priceOfPizza += 1f;
                    break;
                case GARLIC:
                    priceOfPizza += 0.3f;
                    break;
                case OLIVES:
                    priceOfPizza += 0.5f;
                    break;
                case SALAMI:
                    priceOfPizza += 1.5f;
                    break;
                case PEPPERONI:
                    priceOfPizza += 0.6f;
                    break;
            }
        }
        totalPrice(priceOfPizza * pizza.getNumberPizza());
    }

    @Override
    public void pizzaAttributs() {
        for (Pizza pizza : pizzas) {
            System.out.println(
                    counter.getPizzaCounterNumber() + ":" + getClient() + ":" + pizza.getNamePizza() + ":" + pizza.getNumberPizza()
            );
        }
    }

    @Override
    public String toString() {
        String bill = "\n********************************\n" +
                "Заказ: " + counter.getPizzaCounterNumber() + "\n" +
                "Клиент: " + getClient() + "\n";
        for (Pizza pizza : pizzas) {
            priceOfPizza(pizza);
            bill += "Название: " + validateNamePizza(pizza) + "\n" +
                    "--------------------------------\n";
            switch (pizza.getPizzaBase()) {
                case NORMAL:
                    bill += "Pizza Base (Normal)        1,00 €\n";
                    break;
                case CALZONE:
                    bill += "Pizza Base (Calzone)       1,50 €\n";
                    break;
            }
            for (int i = 0; i < pizza.getIngredients().size(); i++) {
                switch (pizza.getIngredients().get(i)) {
                    case TOMATO_PASTE:
                        bill += "Tomato paste               1,00 €\n";
                        break;
                    case CORN:
                        bill += "Corn                       0,70 €\n";
                        break;
                    case BACON:
                        bill += "Bacon                      1,20 €\n";
                        break;
                    case CHEESE:
                        bill += "Cheese                     1,00 €\n";
                        break;
                    case GARLIC:
                        bill += "Garlic                     0,30 €\n";
                        break;
                    case OLIVES:
                        bill += "Olives                     0,50 €\n";
                        break;
                    case SALAMI:
                        bill += "Salami                     1,50 €\n";
                        break;
                    case PEPPERONI:
                        bill += "Pepper                     0,60 €\n";
                        break;
                }
            }
            bill += "--------------------------------\n" +
                    "Всего:                     " +
                    new BigDecimal(priceOfPizza).setScale(2, RoundingMode.UP) + " €\n" +
                    "Кол-во:                         " +
                    pizza.getNumberPizza() + "\n" +
                    "--------------------------------\n";


        }
        bill += "Общая сумма:              " +
                new BigDecimal(totalPrice).setScale(2, RoundingMode.UP) + " €\n" +
                "********************************";
        return bill;
    }
}