package com.shpp.p2p.cs.isynenko.assignment1;

/*
 *   Task
 *   Karel must pick up a newspaper (beeper).
 *   The newspaper is outside the house.
 *   Karel starts in the southwest corner of the house.
 *   He finds a door and picks up the newspaper (beeper).
 *   Karel returns to the starting position.
 *   Need to use 3 methods in the run() method.
 */

/* Definition of the new class */
public class Assignment1Part1 extends KarelBook {
    /* signature of the "run()" method in the class */
    public void run() throws Exception {
        /* commands in the method body */

        /*  1 Method for move to door
         *  Precondition: Karel starts in the southwest corner of the house.
         *  Result: Karel moves along the walls and finds a door.
         */
        moveToNews();
        /*  2 Method for Find the news
         *  Precondition: Karel standing in the door.
         *  Result: Karel picks up the beeper (newspaper).
         */
        findNews();
        /*  3 Method for go to house in starting position
         *  Precondition: Karel has puck up the newspaper.
         *  Result: Karel returns to the starting position.
         */
        moveToHouse();

    }

    /* declaring your own methods */

    /* method 1 for go to door (find door) */
    private void moveToNews() throws Exception {
        moving();
        // Used the method for turn right from KarelBook
        turnRight();
        while (leftIsBlocked()) {
            move();
        }
        turnLeft();

    }

    /* Method 2 for Find news and pick up beeper*/
    private void findNews() throws Exception {
        while (noBeepersPresent()) {
            move();
        }
        // Used the method for around from KarelBook
        turnAround();
        pickBeeper();
    }

    /*  Method 3 for go to house to the starting position.
     *  Used the method for move from KarelBook
     */
    private void moveToHouse() throws Exception {

        moving();
        if (frontIsBlocked() && facingWest()) {
            turnRight();
        }
        moving();
    }
}
