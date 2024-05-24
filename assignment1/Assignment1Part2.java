package com.shpp.p2p.cs.isynenko.assignment1;

/*
 *   Task
 *  Karel is in the southwest corner of the world.
 *  Facing east. Karel has an infinite number of beepers.
 *  He must build neat rows of beepers in columns.
 *  The columns located on the 1st, 5th, 9th, etc. rows.
 *  Each column should be filled with beepers.
 *  The top of each column is marked by a wall.
 *  Karel should not put beepers on spaces that have beepers.
 */
/* Definition of the new class */
public class Assignment1Part2 extends KarelBook {
    /* signature of the "run()" method in the class */
    public void run() throws Exception {

        /*  The method for build pillar
         *  Precondition: Karel starts in the southwest corner of the square.
         *  Result: Karel fills the first column with beepers.
         */
        buildPillar();

        /* Checking is Clear - moving to the next pillars */
        while (frontIsClear()) {
            /*Cycle for move 4 step to the next pillar*/
            for (int i = 0; i < 4; i++) {
                move();
            }

            // Method for build next pillar
            buildPillar();
        }
    }

    /* declaring your own methods */

    // Method for moving and build pillar (put beeper)
    private void buildPillar() throws Exception {
        turnLeft();

        while (frontIsClear()) {
            // Checking a beeper in the cage
            puttingBipper();
            move();

            /* Checking a beeper Blocked */
            if (frontIsBlocked() && facingNorth()) {
                /* Checking a beeper look at North */
                turnAround();
            }
        }

        if (facingSouth()) {
            turnLeft();
        } else {
            // if wall is first move
            turnRight();
            puttingBipper();
        }
    }

    private void puttingBipper() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }
}


