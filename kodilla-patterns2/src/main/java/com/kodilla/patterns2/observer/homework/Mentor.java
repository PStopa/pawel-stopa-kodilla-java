package com.kodilla.patterns2.observer.homework;

import java.util.HashMap;
import java.util.Map;

public class Mentor implements Observer {
    private final String name;
    private Map<String, Integer> students;

    public Mentor(String name) {
        this.name = name;
        students = new HashMap<>();
    }

    @Override
    public void update(StudentTasks studentTasks) {
        System.out.println(studentTasks.getStudent() + " add a new task");
        students.put(studentTasks.getStudent(), students.get(studentTasks.getStudent()) + 1);
    }

    public Map<String, Integer> getStudents() {
        return students;
    }
}
