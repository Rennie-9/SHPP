package com.shpp.p2p.cs.isynenko.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

// The program draws the flag of Italy and the inscription "Flag of Italy" на графическом холсте.
public class Assignment2Part4 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 650;
    public static final int APPLICATION_HEIGHT = 450;
    double flagWidth = 350;
    double flagHeight = 200;
    double flagPieceWidth = flagWidth / 3;

    public void run() {
        // Add the flag of Italy, consisting of three colors: green, white and red.
        addFlags(Color.GREEN, Color.WHITE, Color.RED);
        // Add black text to the canvas in the lower right corner
        createTextFlag(Color.BLACK);

        /*
        add(new GLine(getWidth()/2, 0, getWidth()/2, getHeight()));  // Width line of centre
        add(new GLine(0, getHeight()/2,  getWidth(), getHeight()/2));  //Height line of centre
         */
    }

    // Add a flag of the 3 indicated colors.
    private void addFlags(Color color1, Color color2, Color color3) {
        createFlag(color1, getCenterX(), getCenterY(), flagPieceWidth, flagHeight);
        createFlag(color2, getCenterX() + flagPieceWidth, getCenterY(), flagPieceWidth, flagHeight);
        createFlag(color3, getCenterX() + flagPieceWidth * 2, getCenterY(), flagPieceWidth, flagHeight);
    }

    //Center the flag along Width
    public double getCenterX() {
        return getWidth() / 2.0 - flagWidth / 2.0;
    }
    //Center the flag along Height
    public double getCenterY() {
        return getHeight() / 2.0 - flagHeight / 2.0;
    }

    /* Create the flag. */
    private void createFlag(Color color, double x, double y, double FLAF_WIDTH, double FLAF_HEIGHT) {
        GRect res = new GRect(x, y, FLAF_WIDTH, FLAF_HEIGHT);
        res.setFillColor(color);
        res.setFilled(true);
        add(res);
    }

    /* Create text for flag. */

    private void createTextFlag(Color color) {

        GLabel label = new GLabel("Flag of Italy");
        label.setFont("Verdana-18");
        label.setColor(color);
        add(label);
        //Position of text
        label.setLocation(getWidth() - label.getWidth(), getHeight() - label.getDescent());
    }

}