package com.shpp.p2p.cs.isynenko.assignment2;
/*
 *  Task 6 - Caterpillars.
 *  Draw a caterpillar from ovals. Ovals should overlap each other in the correct order.
 *  The color of the circle should differ from the color of the border of this circle.
 *  It should be easy to change the number of segments of the caterpillar.
 */
import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GOval;
import java.awt.*;

public class Assignment2Part6 extends WindowProgram {

    //Number section of caterpillar
    public final double SECTION = 5;

    //Diameter circle of caterpillar
    public final double DIAMETER = 100;
    // Offset for circle of caterpillar
    public final double SEGMENT = DIAMETER / 2.7;

    /*  Method for draw caterpillar
     */
    public void run() {
        drawCaterpillar();
    }

    /* declaring your own methods */

    /*  Method for position circle of the caterpillar
     */
    private void drawCaterpillar(){
        for (int i = 0; i < SECTION; i++) {

            if (i % 2 == 1) {
                ovalCaterpillar(i * (DIAMETER - SEGMENT), 0, Color.YELLOW); // Top oval
            } else {
                ovalCaterpillar(i * (DIAMETER - SEGMENT), DIAMETER / 2.0, Color.RED); // Bottom oval
            }
        }
    }

    /*  Method for add circle of the caterpillar
     */
    private void ovalCaterpillar(double x, double y, Color fillColor) {
        GOval caterpillar = new GOval(x, y, DIAMETER, DIAMETER);
        caterpillar.setFilled(true);
        caterpillar.setColor(Color.BLUE);
        caterpillar.setFillColor(fillColor);
        add(caterpillar);
    }

}