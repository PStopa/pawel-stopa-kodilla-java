package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTasksTestSuite {
    @Test
    public void testUpdate() {
        //Given
        StudentTasks student1 = new StudentTasks("student1");
        StudentTasks student2 = new StudentTasks("student2");
        Mentor mentor = new Mentor("mentor");
        student1.registerObserver(mentor);
        student2.registerObserver(mentor);
        mentor.getStudents().put(student1.getStudent(),0);
        mentor.getStudents().put(student2.getStudent(),0);

        //When
        student1.addTask("task1");
        student1.addTask("task2");
        student1.addTask("task3");
        student2.addTask("task1");
        student2.addTask("task2");

        //Then
        assertEquals(3, mentor.getStudents().get(student1.getStudent()).intValue());
        assertEquals(2, mentor.getStudents().get(student2.getStudent()).intValue());

    }

}