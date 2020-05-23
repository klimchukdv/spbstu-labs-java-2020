package ru.spbstu.main.shapes;

import java.security.InvalidParameterException;

public class Triangle implements Polygon
{
    private float Ax, Ay, Bx, By, Cx, Cy;
    private int angle;

    public Triangle(float Ax, float Ay, float Bx, float By, float Cx, float Cy, int angle)
    {
        this.Ax = Ax;
        this.Bx = Bx;
        this.Cx = Cx;
        this.Ay = Ay;
        this.By = By;
        this.Cy = Cy;
        if (angle < 0 || angle > 360)
            throw new InvalidParameterException("Incorrect angle.");
        this.angle = angle;
    }

    private float sideAB = (float)Math.sqrt(Math.pow(Bx - Ax, 2) + Math.pow(By - Ay, 2));
    private float sideBC = (float)Math.sqrt(Math.pow(Cx - Bx, 2) + Math.pow(Cy - By, 2));
    private float sideAC = (float)Math.sqrt(Math.pow(Cx - Ax, 2) + Math.pow(Cy - Ay, 2));

    @Override
    public float getX()
    {
        return (Ax + Bx + Cx) / 3;
    }

    @Override
    public float getY()
    {
        return (Ay + By + Cy) / 3;
    }

    @Override
    public float getPerimeter()
    {
        return (sideAB + sideBC + sideAC);
    }

    @Override
    public float getArea()
    {
        float halfPerimeter = getPerimeter() / 2;
        return (float)Math.sqrt(halfPerimeter * (halfPerimeter - sideAB) * (halfPerimeter - sideBC) * (halfPerimeter - sideAC));
    }

    @Override
    public int getRotation()
    {
        return angle;
    }
}
