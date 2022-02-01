package com.kingshuk.tests.Designpatterns;



class Rectangle implements Shape{

    @Override
    public void draw() {
      System.out.println("This is an object for rectangle");
    }
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("This is an object for circle");
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType)
    {
        if (shapeType == null)
            return null;

        if(shapeType=="circle")
            return new Circle();

        if(shapeType=="rectangle")
            return new Rectangle();
        return null;
    }

}
public class FactoryDemo {
    public static void main(String args[]) {
    ShapeFactory sf = new ShapeFactory();
    Shape s1 = sf.getShape("circle");
    s1.draw();
    Shape s2 = sf.getShape("rectangle");
    s2.draw();
}
}
