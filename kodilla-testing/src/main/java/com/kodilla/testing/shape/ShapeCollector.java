package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapeList = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(shapeList.contains(shape)){
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        if(n <= shapeList.size()-1){
            return shapeList.get(n);
        } else {
            return null;
        }
    }

    public void showFigures(){
        if(shapeList.size()>0){
            System.out.println("All Figures:");
            for(Shape shape: shapeList){
                System.out.println(shape);
            }
        } else {
            System.out.println("Shape List is empty");
        }
    }
}
