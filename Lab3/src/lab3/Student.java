package lab3;

import java.security.InvalidParameterException;

public class Student
{
    private final String course;
    private int countOfLabs;

    public Student(String course, int countOfLabs)
    {
        if (countOfLabs < 0)
            throw new InvalidParameterException("Incorrect count of labs.");
        if (!(course.equals("Math")) && !(course.equals("OOP")) && !(course.equals("Physics")))
            throw new InvalidParameterException("Incorrect lab name.");
        this.course = course;
        this.countOfLabs = countOfLabs;
    }

    public String getCourse()
    {
        return course;
    }

    public int getCountOfLabs()
    {
        return countOfLabs;
    }

    public void doneFiveLabs()
    {
        countOfLabs -= 5;
    }
}
