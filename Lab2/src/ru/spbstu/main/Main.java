package ru.spbstu.main;

import ru.spbstu.main.shapes.Circle;
import ru.spbstu.main.shapes.Rectangle;
import ru.spbstu.main.shapes.Shape;
import ru.spbstu.main.shapes.Triangle;
import java.security.InvalidParameterException;

public class Main
{
    public static void main(String[] args)
    {
        Circle circle1 = new Circle(5, 12, 1);
        Circle circle2 = new Circle(6,4, 2.5f);
        Circle circle3 = new Circle(6,10,2);

        Triangle triangle1 = new Triangle(1,9,2,12,4,9, 180);
        Triangle triangle2 = new Triangle(5,8,8,11,7,5,0);
        Triangle triangle3 = new Triangle(8,1,11,10,12,1,60);

        Rectangle rectangle1 = new Rectangle(3,7,2,2,0);
        Rectangle rectangle2 = new Rectangle(12,5,6,5,240);
        Rectangle rectangle3 = new Rectangle(9.5f,11.5f,5,7,44);
        Rectangle rectangle4 = new Rectangle(16,9,6,6,30);
        Shape[] shapes = new Shape[] {circle1, circle2, circle3, triangle1, triangle2, triangle3, rectangle1,
            rectangle2, rectangle3, rectangle4};

        float maxArea = findMaxArea(shapes);
        System.out.println("Maximum shape area is " + maxArea);
    }

    private static float findMaxArea(Shape[] shapeArray)
    {
        if (shapeArray == null)
            throw new InvalidParameterException("Invalid shape array.");

        if (shapeArray.length == 0)
            throw new InvalidParameterException("Incorrect number of shapes.");

        float maxArea = shapeArray[0].getArea();
        for (Shape shape : shapeArray)
        {
            if (shape.getArea() > maxArea)
            {
                maxArea = shape.getArea();
            }
        }
        return maxArea;
    }
}
