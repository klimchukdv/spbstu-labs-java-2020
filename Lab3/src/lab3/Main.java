package lab3;

import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args)
    {
        Queue queue = new Queue();
        int amountOfStudents = 40;

        Generator generator = new Generator(amountOfStudents, queue);
        generator.setDaemon(true);
        generator.start();

        Semaphore semMath = new Semaphore(1);
        Semaphore semOOP = new Semaphore(1);
        Semaphore semPhysics = new Semaphore(1);

        RoboTeacher mathTeacher = new RoboTeacher(semMath, queue, generator);
        mathTeacher.setName("Math");
        mathTeacher.start();

        RoboTeacher OOPTeacher = new RoboTeacher(semOOP, queue, generator);
        OOPTeacher.setName("OOP");
        OOPTeacher.start();

        RoboTeacher physicsTeacher = new RoboTeacher(semPhysics, queue, generator);
        physicsTeacher.setName("Physics");
        physicsTeacher.start();
    }
}
