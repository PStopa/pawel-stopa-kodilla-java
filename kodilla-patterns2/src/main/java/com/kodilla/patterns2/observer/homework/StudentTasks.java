package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentTasks implements Observable {
    private final List<Observer> observers;
    private final ArrayDeque<String> tasks;
    private final String student;

    public StudentTasks(String student) {
        this.student = student;
        observers = new ArrayList<>();
        tasks = new ArrayDeque<>();
    }

    public void addTask(String taskName) {
        tasks.offer(taskName);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public ArrayDeque<String> getTasks() {
        return tasks;
    }

    public String getStudent() {
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTasks taskDeque = (StudentTasks) o;
        return Objects.equals(student, taskDeque.student);
    }

    @Override
    public int hashCode() {

        return Objects.hash(student);
    }
}
