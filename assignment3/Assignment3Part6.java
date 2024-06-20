package com.shpp.p2p.cs.isynenko.assignment3;
/*  Part 5 - animation */
/*
 *   This program draws a pyramid of bricks.
 *   Brick color is chosen randomly.
 *   Pause will make the animation.
 */

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part6 extends WindowProgram {
    /*color of the background*/
    //private static final Color BACKGROUND_COLOR = new Color(0, 255, 233);

    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 700;

    /*  Variable — BRICK_HEIGHT, BRICK_WIDTH,
     *   BRICKS_IN_BASE (how many bricks are in the base).
     */
    private static final int BRICK_HEIGHT = 20;
    private static final int BRICK_WIDTH = 40;
    private static final int BRICKS_IN_BASE = 15;

    /*The amount of time to pause between frames ( 60 FPS)*/
    private static final int FPS = 60;
    private static final double PAUSE_TIME = 1000.0 / FPS; // FPS

    /*  Variable for current time in milliseconds */
    private long startTime;

    /*  method runs the program */
    public void run() {
        /* color of the Background*/
        //setBackground(BACKGROUND_COLOR);

        startTime = System.currentTimeMillis(); // Getting the current time in milliseconds

        /*stars show up and start disappearing for 5 seconds*/
        drawPyramid();

        /*  Getting the current time in milliseconds after the animation ends*/
        long endTime = System.currentTimeMillis();
        /*  Calculate animation duration*/
        long duration = endTime - startTime;
        /*  Convert milliseconds to seconds*/
        double timeSeconds = (double) duration / 1000;
        createTimer(duration);
        System.out.println("Animation duration: " + String.format("%.2f", timeSeconds) + " seconds");

        /*
        add(new GLine(getWidth()/2, 0, getWidth()/2, getHeight()));     // Вертикальная линия
        add(new GLine(0, getHeight()/2,  getWidth(), getHeight()/2));   //Горизонтальная линия
        */
    }

    /*  Method for drawing a pyramid*/
    private void drawPyramid() {
        /*  Total number of bricks*/
        int totalBricks = (BRICKS_IN_BASE * (BRICKS_IN_BASE + 1)) / 2; // Sum of an arithmetic progression
        double totalAnimationTime = 5000; // 5 seconds to milliseconds
        /*  Pause time per brick*/
        double pauseTimePerBrick = totalAnimationTime / totalBricks / PAUSE_TIME;

        double x = getWidth() / 2.0 - BRICK_WIDTH / 2.0;
        double y = getHeight() / 2.0 - BRICKS_IN_BASE * BRICK_HEIGHT / 2.0;
        Color[] colors = createColorArray();

        /*  Randomly select the color of pyramid*/
        //int randomIndex =  (int)(Math.random() * colors.length);

        while (System.currentTimeMillis() - startTime < totalAnimationTime) { // 5 cek

            /*  Drawing bricks and controlling their appearance time*/
            for (int i = 0; i < BRICKS_IN_BASE; i++) {
                for (int j = 0; j < i + 1; j++) {

                    /*  Randomly select the color of each brick*/
                    int randomIndex = (int) (Math.random() * colors.length);

                    drawBrick(x + j * BRICK_WIDTH - i * BRICK_WIDTH / 2.0,
                            y + i * BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT, colors[randomIndex]);

                    /*  Time Animation duration*/
                    if (System.currentTimeMillis() - startTime < totalAnimationTime) {
                        pause(pauseTimePerBrick);
                    } else {
                        break;
                    }
                }
            }
        }  //while
    }

    /*Method for array with color initialization*/
    public static Color[] createColorArray() {
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
        return colors;
    }

    /*  Method for draw brick*/
    public void drawBrick(double x, double y, double BRICK_WIDTH, int BRICK_HEIGHT, Color getColor) {

        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        //brick.setColor(Color.DARK_GRAY); // Установка цвета контура кирпича
        brick.setFilled(true);
        brick.setFillColor(getColor);
        /*  Adding a brick to the screen at the specified coordinates*/
        add(brick, x, y);
    }


    /*  Method for create text for label with animation duration*/
    private void createTimer(long duration) {
        // Convert duration to string
        String durationStr = String.format("%.2f секунд", duration / 1000.0);
        GLabel label = new GLabel("Time: " + durationStr);
        label.setFont("Verdana-18");
        label.setColor(Color.RED);
        add(label);

        /*  Set the label position to the bottom right corner*/
        label.setLocation(getWidth() - label.getWidth(), getHeight() - label.getDescent());
    }

}
