package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.toDolist.tasks.add("toDoList task");
        board.inProgressList.tasks.add("inProgressList task");
        board.doneList.tasks.add("doneList task");

        //Then
        Assert.assertEquals("toDoList task", board.toDolist.tasks.get(0));
        Assert.assertEquals("inProgressList task", board.inProgressList.tasks.get(0));
        Assert.assertEquals("doneList task", board.doneList.tasks.get(0));
    }
}
