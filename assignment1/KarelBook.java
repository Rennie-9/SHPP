package com.shpp.p2p.cs.isynenko.assignment1;
import com.shpp.karel.KarelTheRobot;

/* Definition of the new class */
public class KarelBook extends KarelTheRobot {

    /* declaring your own methods */

    /* Method for turn right  */
    void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /* Method for turn around */
    void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /* Method for forward movement */
    void moveRecursion() throws Exception {
        if (frontIsClear()) {
            move();
        }
        moveRecursion(); //This is a recursive method call
    }

    /* Method for go ahead */
    void moving() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

}
