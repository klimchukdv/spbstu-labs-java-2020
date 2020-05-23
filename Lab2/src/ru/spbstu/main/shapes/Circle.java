package ru.spbstu.main.shapes;

import java.security.InvalidParameterException;

public class Circle implements Ellipse
{
    private float x,y;
    private float radius;

    public Circle(float x, float y, float radius)
    {
        this.x = x;
        this.y = y;
        if (radius <= 0)
            throw new InvalidParameterException("Invalid radius.");
        this.radius = radius;
    }

    @Override
    public float getX()
    {
        return x;
    }

    @Override
    public float getY()
    {
        return y;
    }

    @Override
    public float getArea()
    {
        double area = Math.PI * radius * radius;
        return (float)area;
    }

    @Override
    public float getLength()
    {
        double length = 2 * Math.PI * radius;
        return (float)length;
    }
}
