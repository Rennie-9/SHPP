package com.shpp.p2p.cs.isynenko.assignment3;

/* Part 1 — "Aerobics" */
/*
 *  Program for tracking physical activity.
 *  The user enters the number of minutes for the last 7 days.
 *  Program reports how many days are missing from the recommended schedule.
 *
 *  Cardiovascular health: (30 min x 5 time).
 *  Great job! You've done enough exercise for cardiovascular health.
 *
 *  Blood pressure: (40 x 3).
 *  You needed to train hard for at least 1 more day(s) a week!
 */

import com.shpp.cs.a.console.TextProgram;

/* Definition of the new class */
public class Assignment3Part1 extends TextProgram {

    /* Minimum number of minutes of cardio training */
    private static final int MIN_CARDIO = 30;

    /* Minimum number of minutes of blood pressure. */
    private static final int MIN_BLOOD_PRESSURE = 40;

    /*  The variable indicates
     *  the minimum number of days required for cardiovascular activity.
     *  days Remaining For Cardio
     */
    int cardioVascularHealth = 5;
    /*
     *  The variable indicates the minimum number of days
     *  required for arterial pressure.
     *
     * days Remaining For Blood Pressure
     */
    int bloodPressure = 3;

    /* signature of the "run()" method in the class */
    public void run() {
        /*
         *  Method for enter numbers for count days
         *  A cycle is designed to execute a block of code over seven days.
         */
        for (int i = 1; i <= 7; i++) {
            int exerciseMinutes = readInt("How many minutes did you do on day " + i + " ? ");
            /*  The number of minutes received from the user is passed to the countDays method.*/
            countDays(exerciseMinutes);
        }

        /* Method for answer - print result*/
        printResult();
    }

    /* declaring your own methods */

    /*  The method is designed to handle the number of minutes of exercise*/

    public void countDays(int exerciseMinutes) {
        /*  Reduce the cardiovascular health score by 1 if the number of minutes of exercise is greater
         * than or equal to the minimum value
         */
        if (exerciseMinutes >= MIN_BLOOD_PRESSURE) {
            if (bloodPressure > 0) {
                bloodPressure -= 1;
            }

        }
        /*  Reduce the cardiovascular health score by 1 if the number of minutes of exercise is greater
         *  than or equal to the minimum value
         */
        if (exerciseMinutes >= MIN_CARDIO) {
            if (cardioVascularHealth > 0) {
                cardioVascularHealth -= 1;
            }
        }
    }

    /*  Method for answer - print result*/
    public void printResult() {
        if (cardioVascularHealth == 0) { // good training = 5
            println("Great job! You've done enough exercise for cardiovascular health.");
        } else { // training not enough
            println("You needed to train hard for at least " + cardioVascularHealth + " more day(s) a week!");
        }

        if (bloodPressure == 0) { // good training = 3
            println("Great job! You've done enough exercise to keep a low blood pressure.");
        } else { // training not enough
            println("You needed to train hard for at least " + bloodPressure + " more day(s) a week!");
        }
    }

}
