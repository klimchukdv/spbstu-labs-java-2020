package lab1;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int first, second;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first border: ");
        try
        {
            first = input.nextInt();
        } catch (Exception ex)
        {
            System.out.println("Invalid value! Exit program...");
            return;
        }

        System.out.println("Enter the second border");
        try
        {
            second = input.nextInt();
        } catch (Exception ex)
        {
            System.out.println("Invalid value! Exit program...");
            return;
        }

        boolean prime = true;
        System.out.println("All prime numbers in range (" + first + ";" + second + "):");
        for (int i = first; i <= second; i++)
        {
            for (int j = 2; j < i; j++)
            {
                if (i % j == 0)
                {
                    prime = false;
                    break;
                }
            }
            if (prime) System.out.println(i);
            else prime = true;
        }
    }
}