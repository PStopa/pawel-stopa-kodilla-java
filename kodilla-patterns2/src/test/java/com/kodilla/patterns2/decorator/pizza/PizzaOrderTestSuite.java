package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        assertEquals("Basic pizza (pizza dough, tomato sauce and cheese)", ingredients);
    }

    @Test
    public void testAdditionalIngredientsGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalIngredientsDecorator(pizzaOrder, "mushrooms");
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(18), calculatedCost);
    }

    @Test
    public void testAdditionalIngredientsGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalIngredientsDecorator(pizzaOrder, "mushrooms");
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        assertEquals("Basic pizza (pizza dough, tomato sauce and cheese) + mushrooms", ingredients);
    }

    @Test
    public void testAdditionalCheeseGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(17), calculatedCost);
    }

    @Test
    public void testAdditionalCheeseGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        assertEquals("Basic pizza (pizza dough, tomato sauce and cheese) with additional cheese", ingredients);
    }

    @Test
    public void testAdditionalIngredientsAndCheeseGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new AdditionalIngredientsDecorator(pizzaOrder, "mushrooms");
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), calculatedCost);
    }

    @Test
    public void testAdditionalIngredientsAndCheeseGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new AdditionalIngredientsDecorator(pizzaOrder, "mushrooms");
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        assertEquals("Basic pizza (pizza dough, tomato sauce and cheese) with additional cheese + mushrooms", ingredients);
    }

}