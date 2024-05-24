package com.shpp.p2p.cs.isynenko.assignment1;

/*   Task.
 *   Precondition: Karel starts in the southwest corner of the world.
 *   Result: Karel puts the beeper of the middle of the south side.
 */

/* Definition of the new class */
public class Assignment1Part3 extends KarelBook {

    public void run() throws Exception {
        if (frontIsClear()) {
            /* 1 Method Karel moves for find middle of the east side*/
            findMeddle();
            turnRight();
            /* 2 Method Karel moves to the middle of south side */
            goSouthSide();
            /* Karel put beeper to the middle of south side */
            putBeeper();
        } else {
            putBeeper(); // For size 1
        }
    }

    /* declaring your own methods */

    /* 1 Method for find Middle of the east side*/
    /*
     *   Precondition: Karel starts in the southwest corner of the world.
     *   Result: Karel move to the middle of the east side.
     */
    private void findMeddle() throws Exception {
        if (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
            }
            turnLeft();
            move();
            turnRight();
            findMeddle(); // It is recursion
        }
    }

    /* 2 Method for moving to middle of south side */
    /*
     *   Precondition: Karel located  in the east side corner of the world.
     *   Result: Karel move to the middle of the south side.
     */
    private void goSouthSide() throws Exception {
        if (frontIsClear()) {
            move();
            turnRight();
            if (frontIsClear()) {
                move();
            }
            turnLeft();
            goSouthSide(); // It is recursion
        }
    }
}