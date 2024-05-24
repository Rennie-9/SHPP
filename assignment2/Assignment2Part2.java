package com.shpp.p2p.cs.isynenko.assignment2;
/*
 *  Task - Optical illusion.
 *  Write a console program that will paint a matrix of black boxes separated by “streets”.
 */
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/* Definition of the new class */
public class Assignment2Part2 extends WindowProgram {

    // For APPLICATION_WIDTH and APPLICATION_HEIGHT

    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 600;

    //public static final double CIRCLE_RADIUS =55;

    // Get radius of circle
    public final double CIRCLE_RADIUS = readDouble("Enter number for radius <= 100: ");

    // Find diameter of circle
    double circleDiameter = CIRCLE_RADIUS * 2;

    public void run() {
        drawIllusion();
    }

    private  void drawIllusion(){
        // The coordinate to place of circle in corner
        addCircle(0, 0); // Top left
        addCircle(getWidth() - circleDiameter, 0); // Top right
        addCircle(0, getHeight() - circleDiameter); // Bottom left
        addCircle( getWidth() - circleDiameter, getHeight() - circleDiameter); // Bottom right

        // The coordinate to place of square in center
        addRectangle( CIRCLE_RADIUS,  CIRCLE_RADIUS, getWidth() - circleDiameter, getHeight() - circleDiameter);
    }
    //The method to place of circles in the corner
    private void addCircle(double x, double y) {
        GOval circle = new GOval(x, y, circleDiameter, circleDiameter);
        circle.setFilled(true);
        circle.setColor(Color.BLACK);
        add(circle);
    }

    //The method to place of square in the center
    private void addRectangle(double x, double y, double width, double height) {
        GRect rectangle = new GRect(x, y, width, height);
        rectangle.setFilled(true);
        rectangle.setColor(Color.WHITE);
        add(rectangle);
    }

}
