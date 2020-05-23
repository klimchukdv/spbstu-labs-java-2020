package ru.spbstu.main.shapes;

import java.security.InvalidParameterException;

public class Rectangle implements Polygon
{
    private float x,y;
    private float width, height;
    private int angle;

    public Rectangle(float x, float y, float width, float height, int angle)
    {
        if (width <= 0 || height <= 0)
            throw new InvalidParameterException("Incorrect width or height.");

        if (angle < 0 || angle > 360)
            throw new InvalidParameterException("Incorrect angle.");

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.angle = angle;
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
    public float getPerimeter()
    {
        return (width + height) * 2;
    }

    @Override
    public float getArea()
    {
        return width * height;
    }

    @Override
    public int getRotation()
    {
        return angle;
    }
}
