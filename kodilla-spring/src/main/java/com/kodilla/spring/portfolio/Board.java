package com.kodilla.spring.portfolio;

public class Board {
    TaskList toDolist, inProgressList, doneList;

    public Board(TaskList toDolist, TaskList inProgressList, TaskList doneList) {
        this.toDolist = toDolist;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }
}
