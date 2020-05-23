package lab3;

import java.util.concurrent.LinkedBlockingQueue;

public class Queue
{
    private LinkedBlockingQueue<Student> queue;

    public Queue()
    {
        this.queue = new LinkedBlockingQueue<>(10);
    }

    public void addStudent(Student student)
    {
        try
        {
            queue.put(student);
        } catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

    public Student getStudent()
    {
        try
        {
            return queue.take();
        } catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    public Student peek()
    {
        return queue.peek();
    }
}
