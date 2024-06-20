package com.shpp.p2p.cs.isynenko.assignment3;
/* Part 4 — Pyramid */
/*
 *   This program draws a pyramid of bricks.
 *   Brick color is chosen randomly.
 *   Pause will make the animation.
 */

import com.shpp.cs.a.graphics.WindowProgram;

import acm.graphics.GRect;
import acm.graphics.GLine;

import java.awt.Color;


/* Definition of the new class */
public class Assignment3Part4 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 480;
    public static final int APPLICATION_HEIGHT = 720;

    /*
     *   Variable — BRICK_HEIGHT, BRICK_WIDTH,
     *   BRICKS_IN_BASE (how many bricks are in the base).
     */
    private static final int BRICK_HEIGHT = 20;
    private static final int BRICK_WIDTH = 40;
    private static final int BRICKS_IN_BASE = 10;

    /*  Pause for animation*/
    private static final int PAUSE_TIME = 10;

    public void run() {
        drawPyramid();
        /* Vertical line for checking */
        //add(new GLine((double) getWidth() /2, 0, (double) getWidth() /2, getHeight()));
    }

    /*Method for drawing a pyramid of bricks*/
    public void drawPyramid() {
        /*Creating an array of colors for bricks*/
        Color[] colors = createColorArray();
        /*Randomly select the color of the pyramid*/
        //int randomIndex =  (int)(Math.random() * colors.length);

        /*Coordinates for the first brick*/
        double x = getWidth() / 2.0 - BRICKS_IN_BASE * BRICK_WIDTH / 2.0;
        double y = getHeight() - BRICK_HEIGHT;

        /*Cycle for drawing a pyramid*/
        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            for (int j = 0; j < BRICKS_IN_BASE - i; j++) {

                /*Randomly select a color for each brick*/
                int randomIndex = (int) (Math.random() * colors.length);

                drawBrick(x + j * BRICK_WIDTH + i * BRICK_WIDTH / 2.0,
                        y - i * BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT, colors[randomIndex]);
                /*  Pause for animation*/
                //pause(PAUSE_TIME);
            }
        }
    }

    /* Method for drawing a brick*/
    public void drawBrick(double x, double y, double BRICK_WIDTH, double BRICK_HEIGHT, Color getColor) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFilled(true);
        //brick.setFillColor(Color.blue);
        brick.setFillColor(getColor);
        add(brick, x, y); // Adding a brick at the specified coordinates
    }

    /*The method creates and returns an array of colors.
     * Used to select the color of bricks*/
    public static Color[] createColorArray() {
        /*  Array with initialized colors*/
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
        return colors;
    }
}
