package com.kodilla.testing.shape;

public class Square implements Shape{

    private String shapeName;
    private int side;

    public Square(String shapeName, int side) {
        this.shapeName = shapeName;
        this.side = side;
    }

    public String getShapeName(){
        return shapeName;
    }

    public double getField(){
        return side*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "shapeName='" + shapeName + '\'' +
                ", side=" + side +
                '}';
    }
}
