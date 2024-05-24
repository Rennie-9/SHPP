package com.shpp.p2p.cs.isynenko.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;

public class Assignment2Part3 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;
    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;

    /* The position of the heel relative to the upper-left
     * corner of the pawprint.
     */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;

    /* Each toe is an oval with this width and height. */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /* The heel is an oval with this width and height. */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    public void run() {
        // Update the coordinate to place the circles in corners
        drawPawprint(20, 20);
        drawPawprint(180, 70);
        //drawPawprint(280, 40);
    }

    /*
     *   The method adds 3 fingers and a heel.
     */
private void drawPawprint(double x, double y) {
    // Drawing three toes of the pawprint
    drawOval(x, y, FIRST_TOE_OFFSET_X, FIRST_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);
    drawOval(x, y, SECOND_TOE_OFFSET_X, SECOND_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);
    drawOval(x, y, THIRD_TOE_OFFSET_X, THIRD_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);

    // Drawing the heel of the pawprint
    drawOval(x, y, HEEL_OFFSET_X, HEEL_OFFSET_Y, HEEL_WIDTH, HEEL_HEIGHT);
}
    /*
     *   The method adds 3 fingers and a heel to the screen
     */
    private void drawOval(double x, double y, double offsetX, double offsetY, double width, double height) {
        GOval oval = new GOval(x + offsetX, y + offsetY, width, height);
        oval.setFilled(true);
        oval.setColor(Color.BLACK);
        add(oval);
    }

}