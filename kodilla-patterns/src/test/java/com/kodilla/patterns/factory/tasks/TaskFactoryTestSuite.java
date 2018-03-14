package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING_TASK);
        //Then
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
        shopping.executeTask();
        Assert.assertTrue(shopping.isTaskExecuted());

    }
    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.PAINTING_TASK);
        //Then
        Assert.assertEquals("Painting", shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
        shopping.executeTask();
        Assert.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.DRIVING_TASK);
        //Then
        Assert.assertEquals("Driving", shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
        shopping.executeTask();
        Assert.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryNullTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task = factory.makeTask("Task");
        //Then
        Assert.assertNull(task);
    }
}
