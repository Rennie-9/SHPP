package com.shpp.p2p.cs.isynenko.assignment3;

/*  Part 5 - "Casino Bernoulli" game */
/*
 *   Two people play: lucky (LuckyGamer) and sweaty (SweatyBank).
 *   LuckyGame leaves the casino when he earns $20 or more. (table >= 20).
 *   If the lucky person ends up with less than $20, then the game is repeated.
 */

import java.util.Random;

import com.shpp.cs.a.console.TextProgram;

/* Definition of the new class */
public class Assignment3Part5 extends TextProgram {


    /*  The winnings are total*/
    double luckyGame = 0;
    /*  The amount on the table*/
    double table = 1;
    /*  Game counter*/
    int countGame = 0;

    /* signature of the "run()" method in the class */

    public void run() {
        game();
        System.out.println("It took " + countGame + " games to earn $20");
    }

    /* declaring your own methods */

    /*the basic logic of the game*/
    private void game() {

        /*  The cycle continues until lucky wins $20 or more.*/
        do {
            Random rand = new Random();
            /* Generate a random number 0 or 1*/
            int random = rand.nextInt(2);

            if (random == 0) { /* eagle side == 0*/
                table += table;
            } else { /* tails side == 1 */
                luckyGame += table;
                printResult();
                table = 1;
                countGame++;
            }
        } while (luckyGame < 20);

    }

    /*  Display information about winnings*/
    private void printResult() {
        System.out.println("This game, you earned: " + table);
        System.out.println("Your total is: " + luckyGame);
    }

}

