package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "ShoppingTask";
    public static final String PAINTING_TASK = "PaintingTask";
    public static final String DRIVING_TASK = "DrivingTask";

    public final Task makeTask(final String taskClass){
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping", "Bananas", 1.5);
            case PAINTING_TASK:
                return new PaintingTask("Painting", "black", "dog");
            case DRIVING_TASK:
                return new DrivingTask("Driving", "shop", "bike");
            default:
                return null;

        }
    }
}
