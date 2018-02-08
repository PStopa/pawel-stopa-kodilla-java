package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private String shapeName;
    private int base;
    private int height;

    public Triangle(String shapeName, int base, int height) {
        this.shapeName = shapeName;
        this.base = base;
        this.height = height;
    }

    public String getShapeName(){
        return shapeName;
    }

    public double getField(){
        return 0.5*base*height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "shapeName='" + shapeName + '\'' +
                ", base=" + base +
                ", height=" + height +
                '}';
    }
}
