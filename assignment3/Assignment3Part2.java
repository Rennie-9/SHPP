package com.shpp.p2p.cs.isynenko.assignment3;
/* Part 2 — "Hailstone numbers" */
/*  The program prompts the user to enter a number.
    Hailstone's consistency rule is then applied.
    If the number is even - it is divided in half.
    If it is odd - it is multiplied by three and increased by one.
    This process is repeated until the number 1 is reached
*/

import com.shpp.cs.a.console.TextProgram;

/* Definition of the new class */
public class Assignment3Part2 extends TextProgram {

    /*  Variable for entering a number*/
    int number = readInt("Enter number: ");

    /* signature of the "run()" method in the class */
    public void run() {
        /* The method performs the Hailstone */
        gameHailstone();
    }

    /* declaring your own methods */

    /* The method performs the Hailstone and print result*/
    public void gameHailstone() {
        generateSequence();
        printResult();
    }

    /*  The method performs the Hailstone sequence (последовательность) steps for a given number*/
    public void generateSequence() {

        while (number > 0) {
            if (number % 2 == 0) { // If the number is even. It is divided in half.
                println(number + " is even so I take half : " + (number / 2));
                number = number / 2;
                if (number == 1) {
                    break;
                }
            } else { // If the number is odd. It is multiplied by three and increased by one.
                println(number + " is odd so I make 3 * number + 1: " + (number * 3 + 1));
                number = number * 3 + 1;
            }
        }
    }

    /*  Method for answer - print result*/
    public void printResult() {
        if (number < 1) {
            println("Take any positive integer");
        } else {
            println("Finish!");
        }
    }

}
