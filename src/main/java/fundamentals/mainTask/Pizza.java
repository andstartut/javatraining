package fundamentals.mainTask;

import fundamentals.mainTask.Enum.Ingredients;
import fundamentals.mainTask.Enum.PizzaBase;
import fundamentals.mainTask.Exceptions.CounterIngredientException;
import fundamentals.mainTask.Exceptions.IngredientException;
import fundamentals.mainTask.Exceptions.NumberPizzaException;
import fundamentals.mainTask.Interfaces.IPizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza implements IPizza {
    private Ingredients ingredients;
    private PizzaBase pizzaBase;
    private String namePizza;
    private int numberPizzas;
    List pizzaIngredient;

    public Pizza(Builder builder) {
        this.ingredients = builder.ingredients;
        this.pizzaBase = builder.pizzaBase;
        this.namePizza = builder.namePizza;
        this.numberPizzas = builder.numberPizzas;
        this.pizzaIngredient = builder.pizzaIngredient;
    }

    public static class Builder {
        private Ingredients ingredients;
        private PizzaBase pizzaBase;
        String namePizza;
        int counterIngredients = 1;
        int numberPizzas;
        List<Ingredients> pizzaIngredient = new ArrayList();

        public Builder setNamePizza(String namePizza) {
            this.namePizza = namePizza;
            return this;
        }

        public Builder setPizzaBase(PizzaBase pizzaBase) {
            this.pizzaBase = pizzaBase;
            return this;
        }

        public Builder addIngredient(Ingredients ingredients) {
            for (Ingredients element : pizzaIngredient) {
                try {
                    if (element.equals(ingredients)) {
                        throw new IngredientException();
                    }
                } catch (IngredientException e) {
                    System.out.println(ingredients + " уже добавлен ранее. Пересмотрите свой выбор.");
                }
            }
            try {
                if (counterIngredients > 7) {
                    throw new CounterIngredientException();
                }
            } catch (CounterIngredientException e) {
                System.out.println("Превышено количество ингридиентов. Пересмотрите свой выбор.");
            }
            pizzaIngredient.add(ingredients);
            this.ingredients = ingredients;
            counterIngredients++;
            return this;
        }

        public Builder setNumberPizza(int numberPizza) {
            try {
                if (numberPizza > 10) {
                    throw new NumberPizzaException();
                } else {
                    this.numberPizzas = numberPizza;
                }
            } catch (NumberPizzaException e) {
                System.out.println("Превышен лимит в 10 шт. Пересмотрите свой выбор.");
            }
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String getNamePizza() {
        return namePizza;
    }

    @Override
    public List<Ingredients> getIngredients() {
        return pizzaIngredient;
    }

    @Override
    public PizzaBase getPizzaBase() {
        return pizzaBase;
    }

    @Override
    public int getNumberPizza() {
        return numberPizzas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return numberPizzas == pizza.numberPizzas &&
                ingredients == pizza.ingredients &&
                pizzaBase == pizza.pizzaBase &&
                Objects.equals(namePizza, pizza.namePizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, pizzaBase, namePizza, numberPizzas);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredients=" + ingredients +
                ", pizzaBase=" + pizzaBase +
                ", namePizza='" + namePizza + '\'' +
                ", numberPizza=" + numberPizzas +
                '}';
    }
}
