package com.shpp.p2p.cs.isynenko.assignment2;
import acm.graphics.GLine;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 480;
    public static final int APPLICATION_HEIGHT = 520;

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5; // HEIGHT
    private static final int NUM_COLS = 6; // WIDTH

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;
    private static final double BOXES = BOX_SIZE + BOX_SPACING;

    public void run() {

        opticalIllusion(Color.BLACK);
        /*
        add(new GLine(getWidth()/2, 0, getWidth()/2, getHeight()));  // Width line of centre
        add(new GLine(0, getHeight()/2,  getWidth(), getHeight()/2));  //Height line of centre
        */
    }

    /* declaring your own methods */

    // Loop for drawing an illusion
    private void opticalIllusion(Color fillColor) {

        for (int i = 0; i < NUM_ROWS; i++) { // HEIGHT
            for (int j = 0; j < NUM_COLS; j++) { // WIDTH
                GRect illusion = new GRect(
                        offsetX() + (i * BOXES),
                        offsetY() + (j * BOXES),
                        BOX_SIZE, BOX_SIZE);
                //illusion.setColor(Color.RED);
                illusion.setFilled(true);
                illusion.setFillColor(fillColor);
                add(illusion);
            }
        }
    }

    // Method for find half width
    public double getCenterX() {
        return getWidth() / 2.0;
    }

    // Method for find half height
    public double getCenterY() {
        return getHeight() / 2.0;
    }

    // Method for find half width of illusion
    public double getHalfWidth() {
        return (BOXES * NUM_ROWS - BOX_SPACING ) / 2.0;
    }

    // Method for find half height of illusion
    public double getHalfHeight() {
        return (BOXES * NUM_COLS - BOX_SPACING) / 2.0;
    }

    // Find position X for illusion
    public double offsetX() {
        return getCenterX() - getHalfWidth();
    }

    // Find position Y for illusion
    public double offsetY() {
        return getCenterY() - getHalfHeight();
    }
}