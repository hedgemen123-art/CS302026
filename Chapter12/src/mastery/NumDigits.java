package mastery;

/*
Program: Numdigits.java
Last Date of this Revision: January 29, 2026

Purpose: provide search algorithms including ternary search
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/	

import java.util.Scanner;

public class NumDigits {

    /**
     * counts digits recursively
     * pre number >= 0
     * post digit count returned
     */
    public static int countDigits(int num) {

        if (num < 10) {
            return 1;
        }

        return 1 + countDigits(num / 10);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("enter a number ");
        int num = input.nextInt();

        System.out.println("digits " + countDigits(num));

        input.close();
    }
}
