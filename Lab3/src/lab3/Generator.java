package lab3;

import java.security.InvalidParameterException;
import java.util.Random;

public class Generator extends Thread
{
    private int amountOfStudents;
    private Queue queue;
    private static Random random = new Random();

    public Generator(int amountOfStudents, Queue queue)
    {
        if (amountOfStudents < 0)
            throw new InvalidParameterException("Incorrect amount of students.");
        this.queue = queue;
        this.amountOfStudents = amountOfStudents;
    }

    private String generateCourse()
    {
        String course;
        int i = random.nextInt(3);
        switch (i)
        {
            case 0:
                course = "Math";
                break;
            case 1:
                course = "OOP";
                break;
            default:
                course = "Physics";
                break;
        }
        return course;
    }

    private int generateAmountOfLabs()
    {
        int amount;
        int i = random.nextInt(3);
        switch (i)
        {
            case 0:
                amount = 10;
                break;
            case 1:
                amount = 20;
                break;
            default:
                amount = 100;
                break;
        }
        return amount;
    }

    @Override
    public void run()
    {
        while (amountOfStudents > 0)
        {
            Student student = new Student(generateCourse(), generateAmountOfLabs());
            queue.addStudent(student);
            amountOfStudents -= 1;
        }
    }
}
