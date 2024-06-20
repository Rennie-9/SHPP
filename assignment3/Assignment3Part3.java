package com.shpp.p2p.cs.isynenko.assignment3;
/* Part 3 — Raising to a degree */
/*
 * This program raises a number to a degree.
 *  Accepts 2 parameters: base and exponent.
 */

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {
    /* Method run */
    public void run() {
        raisingDegree();
    }

    /* Method for entering the base and exponent */
    private void raisingDegree() {
        double base = readDouble("Input number of base: ");
        int exponent = readInt("Input number of exponent: ");
        System.out.println("The result is: " + raiseToDegree(base, exponent));
    }

    /* Method to raise a number to a Degree */
    private double raiseToDegree(double base, int exponent) {
        /*This is necessary for the multiplication loop to work.*/
        double result = 1;
        if (exponent == 0) {
            return 1; // If the exponent is 0, the result is always 1
        }

        /*  If the exponent > 0, the result * base*/
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        }

        /*   If the exponent > 0, the result / base*/
        if (exponent < 0) {
            for (int i = 0; i > exponent; i--) {
                result /= base; // 2 in Degree -3 == 1 / base * base * base
            }
        }
        return result;
    }
}