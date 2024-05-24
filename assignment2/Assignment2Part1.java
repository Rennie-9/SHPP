package com.shpp.p2p.cs.isynenko.assignment2;
/*
 *  Task - A quadratic equation.
 *  Write a console program
 *  that will accept 3 numbers of type double (a,b,c) as input.
 *  Output the roots of a quadratic equation.
 */
/*
 *   Note.
 *   If all three terms are zero, then infinity.
 *   If A is equal to zero and B is equal to zero, then there are no roots.
 *   If A is equal to zero, then it is a linear equation.
 *   The equation has only one root and is calculated using the formula x1 = -c / b
 */

import com.shpp.cs.a.console.TextProgram;

import java.util.Scanner;

public class Assignment2Part1 extends TextProgram {

    public void run() {
        quadraticEquation();
    }

    /*
     * The method takes three numbers (a, b, c)
     * */
    private static void quadraticEquation() {
        //Creates a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        // Message for data entry
        System.out.print("Please enter a: ");
        //Read the message and recording in a variable
        double a = scanner.nextDouble();
        System.out.print("Please enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Please enter c: ");
        double c = scanner.nextDouble();
        //Call the checkNumber method with arguments a, b and c.
        checkNumber(a, b, c);
    }

    private static void checkNumber(double a, double b, double c) {
        //The equation ax^2 + bx + c = 0 has an infinite number of solutions
        if (a == 0 && b == 0 && c == 0) {
            System.out.print("Infinity solutions. Бесконечность");
            //The equation has no solutions
        } else if (a == 0 && b == 0) {
            System.out.print("There are no real roots.");
            //The only root of the equation is calculated using the formula x = -c / b
        } else if (a == 0) {
            double x = -c / b;
            System.out.print("There is one root: " + x);
        } else {
            //Call the discriminant with arguments a, b and c.
            discriminant(a, b, c);
        }
    }

    //Method for calculating the discriminant of an equation
    private static void discriminant(double a, double b, double c) {
        double discriminant = b * b - 4 * c;
        calculateRadical(discriminant, a, b);
    }

    //Method for calculating the roots of an equation
    private static void calculateRadical(double discriminant, double a, double b) {
        double radical1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double radical2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        printResult(discriminant, radical1, radical2);
    }

    //Method for print result the roots of an equation
    private static void printResult(double discriminant, double root1, double root2) {
        if (discriminant >= 0) {
            if (discriminant == 0) {
                System.out.print("There is one root: " + root1);
            } else {
                System.out.print("There are two roots: " + root1 + " and " + root2);
            }
        } else {
            System.out.print("There are no real roots.");
        }
    }
}
