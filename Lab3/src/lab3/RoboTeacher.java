package lab3;

import java.util.concurrent.Semaphore;

public class RoboTeacher extends Thread
{
    private Queue queue;
    private Semaphore semaphore;
    private Generator generator;

    public RoboTeacher(Semaphore semaphore, Queue queue, Generator generator)
    {
        this.semaphore = semaphore;
        this.queue = queue;
        this.generator = generator;
    }

    @Override
    public void run()
    {
        while (!queue.isEmpty() || generator.isAlive())
        {
            try
            {
                semaphore.acquire();
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

            if (checkStudent())
            {
                Student student = queue.getStudent();
                System.out.println("RoboTeacher started to work with student who has " + student.getCountOfLabs() + " " +
                        student.getCourse() + "'s labs..");
                while (student.getCountOfLabs() != 0)
                {
                    student.doneFiveLabs();
                }
                System.out.println("Student passed course " + this.getName());
            }
            semaphore.release();
        }
    }

    private boolean checkStudent()
    {
        Student student = queue.peek();
        if (student != null)
        {
            return this.getName().equals(student.getCourse());
        }
        return false;
    }
}
