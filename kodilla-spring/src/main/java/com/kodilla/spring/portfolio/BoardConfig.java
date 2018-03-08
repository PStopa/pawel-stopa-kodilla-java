package com.kodilla.spring.portfolio;

import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    private TaskList toDoList, inProgressList, doneList;

    @Bean
    public TaskList toDoList(){
        return new TaskList();
    }

    @Bean
    public TaskList inProgressList(){
        return new TaskList();
    }

    @Bean
    public TaskList doneList(){
        return new TaskList();
    }

    @Bean
    public Board getTaskList(){
        return new Board(toDoList, inProgressList, doneList);
    }

}