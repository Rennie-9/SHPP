package com.shpp.p2p.cs.isynenko.assignment1;
/*
 *   Task
 *   Precondition: Karel located  in the east side corner of the world.
 *   Result: Karel moves the field and puts the beepers across the cage
 */

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {
    public void run() throws Exception {
        // For size 1 x 1
        if (frontIsBlocked() && leftIsBlocked()) {
            putBeeper();
        } else if (frontIsClear() && leftIsBlocked()) {
            // For size 1 cell in West side
            putBeeper();
            singleRow();
        } else if (frontIsBlocked() && leftIsClear()) {
            // For size 1 cell in South side
            turnLeft();
            putBeeper();
            singleRow();
        } else {
            // For size 2 x 2 and big size
            putBeeper();
            generalCase();
        }
    }

    /* declaring your own methods */

    // Method for basic move and put the beeper
    /*
     *   Precondition:
     *   Result: Karel moves the row and puts the beepers across the cage
     */
    private void singleRow() throws Exception {

        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }

    }

    // Method for move and put the beeper for a large field
    private void generalCase() throws Exception {
        while (frontIsClear()) {
            singleRow();

            //method for turn left and move if beeper is in last cell
            turnLeftMoveBeeper();

            //method for turn left and move if beeper is not in last cell
            turnLeftMoveNotBeeper();

            //method for turn Right and move
            turnRightMove();
        }
    }

    //method for turn Left and move if beeper is in cell
    private void turnLeftMoveBeeper() throws Exception {
        if (beepersPresent() && facingEast() && frontIsBlocked()) {
            turnLeft();
            if (frontIsClear()) {
                move();
                turnLeft();
                move();
                putBeeper();
            }
        }
    }

    //method for turn Left and move if beeper is not in cell
    private void turnLeftMoveNotBeeper() throws Exception {
        if (noBeepersPresent() && facingEast() && frontIsBlocked()) {
            turnLeft();
            if (frontIsClear()) {
                move();
                turnLeft();
                putBeeper();
            }
        }
    }

    //method for turn Right and move next line
    private void turnRightMove() throws Exception {
        if (frontIsBlocked() && facingWest()) {
            turnRight();
            if (frontIsClear()) {
                move();
                putBeeper();
                turnRight();
            }
        }
    }

    //method for simple right turn
    private void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }
}