package com.kodilla.testing.shape;

import static java.lang.Math.PI;

public class Circle implements Shape{

    private String shapeName;
    private int radius;

    public Circle(String shapeName, int radius) {
        this.shapeName = shapeName;
        this.radius = radius;
    }

    public String getShapeName(){
        return shapeName;
    }

    public double getField(){
        return PI*(radius*radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "shapeName='" + shapeName + '\'' +
                ", radius=" + radius +
                '}';
    }
}
