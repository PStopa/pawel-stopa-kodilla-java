package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AdditionalIngredientsDecorator extends AbstractPizzaOrderDecorator {
    private String ingredients;

    public AdditionalIngredientsDecorator(PizzaOrder pizzaOrder, String ingredients) {
        super(pizzaOrder);
        this.ingredients = ingredients;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + " + ingredients;
    }
}
