package mastery;

/*
Program: ParenChecker.java
Last Date of this Revision: January 29, 2026

Purpose: display matching parenthesis positions
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

import java.util.Scanner;

public class ParenChecker
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("enter an expression: ");
        String expression = input.nextLine();

        Stack stack = new Stack(expression.length());

        for (int i = 0; i < expression.length(); i++)
        {
            char current = expression.charAt(i);

            if (current == '(')
            {
                stack.push((char)(i + 1));
            }
            else if (current == ')')
            {
                if (!stack.isEmpty())
                {
                    int openIndex = (int)stack.pop();
                    int closeIndex = i + 1;

                    System.out.println("pair: " + openIndex + " " + closeIndex);
                }
            }
        }

        input.close();
    }
}
