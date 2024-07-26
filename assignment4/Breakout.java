package com.shpp.p2p.cs.isynenko.assignment4;
/**
 * The player controls a horizontal platform - a “racket”.
 * The racket moves left and right at the bottom of the screen.
 * The goal of the game is to break all the bricks with the ball.
 * The bricks are located at the top of the screen. The player has three lives.
 * The game ends if all bricks are broken or all lives are used up.
 */

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

import acm.util.RandomGenerator;

public class Breakout extends WindowProgram {
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;

    /**
     * Number of bricks per row
     */

    private static final int NBRICKS_PER_ROW = 10;// ширина NBRICKS_PER_ROW

    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;//Высота NBRICK_ROWS

    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 4;

    /** It's a bad idea to calculate brick width from APPLICATION_WIDTH */
    // private static final int BRICK_WIDTH =
    //        (APPLICATION_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 8;

    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 10;

    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;

    /**
     * Number of turns
     */
    private static final int NTURNS = 3;

    private static final int FPS = 60; // The number of frames per second
    private static final int PAUSE_TIME = 1000 / FPS; // Delay between frames in milliseconds

    /**
     * Variable for object movement along the X axis.
     */
    double vx = 1;
    /**
     * Variable for object movement along the Y axis.
     */
    double vy = 3;

    /**
     * Paddle - racket.
     */
    private GRect paddle;

    /**
     * Variable for counting the number of bricks.
     */
    private static int countBricks = NBRICKS_PER_ROW * NBRICK_ROWS;

    /**
     * Variable for counting the number of lives.
     */
    int lives = NTURNS;

    /**
     * Ball variable
     */
    GOval ball;

    /**
     * Brick width variable
     */
    double brickWidth;


    public void run() {
        brickWidth = (getWidth() - ((NBRICKS_PER_ROW - 1) * BRICK_SEP)) / NBRICKS_PER_ROW;
        addMouseListeners();
        setPaddle();
        drawBricks();
        drawBall();
        moveBall();
    }

    /**
     * Method for centering the racket
     */
    public void setPaddle() {
        double getX = (getWidth() - PADDLE_WIDTH) / 2.0;
        double getY = getHeight() - PADDLE_HEIGHT - PADDLE_Y_OFFSET;
        paddle = new GRect(getX, getY, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        paddle.setColor(Color.BLUE);
        add(paddle);
    }

    /**
     * Method for moving the racket using the mouse
     */
    public void mouseMoved(MouseEvent racket) {
        double newX = racket.getX() - PADDLE_WIDTH / 2.0;
        double newY = getHeight() - PADDLE_Y_OFFSET;

        /**If the new position of the racket is less than zero, set it zero*/
        if (newX < 0) {
            newX = 0;
            /**If the new racket position is greater than the screen width minus the racket width,
             * set it getWidth() - PADDLE_WIDTH.*/
        } else if (newX > getWidth() - PADDLE_WIDTH) {
            newX = getWidth() - PADDLE_WIDTH;
        }
        paddle.setLocation(newX, newY);
    }

    /**
     * Method for centering the ball
     */
    public void drawBall() {
        int BALL_DIAMETER = BALL_RADIUS * 2;
        double xBall = getWidth() / 2.0 - BALL_DIAMETER / 2.0;
        double yBall = getHeight() / 2.0 - BALL_DIAMETER / 2.0;
        ball = new GOval(xBall, yBall, BALL_DIAMETER, BALL_DIAMETER);
        ball.setFilled(true);
        ball.setFillColor(Color.RED);
        add(ball);
    }

    /**
     * Method for generating a random number
     */
    public void rGen() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) {
            vx = -vx;
        }
    }

    /**
     * The method moves the ball and checks for collisions.
     */
    public void moveBall() {
        waitForClick();
        rGen();
        while (countBricks > 0 && lives > 0) {
            checkCollisions();//check for collisions
            ball.move(vx, vy);

            if (countBricks == 0) {
                removeAll();
                displayMessage("You win");
                break;
            }
            pause(PAUSE_TIME);
        }
    }

    /**
     * The method is responsible for changing the direction of the ball and checking for collisions.
     */
    private void checkCollisions() {
        checkWallCollisions(); //wall
        checkPaddleCollision();//paddle
        checkBricksCollision();//brick
    }

    /**
     * This method determines whether the ball is in contact with any object on the screen.
     * And returns this object if present.
     * The method checks the four corners of the ball sequentially
     */
    private GObject getElementObject() {
        int BALL_DIAMETER = BALL_RADIUS * 2;
        if (getElementAt(ball.getX(), ball.getY()) != null) {
            return getElementAt(ball.getX(), ball.getY()); //top left corner
        } else if (getElementAt(ball.getX() + BALL_DIAMETER, ball.getY()) != null) {
            return getElementAt(ball.getX() + BALL_DIAMETER, ball.getY());// top right corner
        } else if (getElementAt(ball.getX(), ball.getY() + BALL_DIAMETER) != null) {
            return getElementAt(ball.getX(), ball.getY() + BALL_DIAMETER);//bottom left corner
        } else if (getElementAt(ball.getX() + BALL_DIAMETER, ball.getY() + BALL_DIAMETER) != null) {
            return getElementAt(ball.getX() + BALL_DIAMETER, ball.getY() + BALL_DIAMETER);//bottom right corner
        }
        return null;
    }

    /**
     * The method checks whether the ball is within the racket.
     * If yes, then changes its direction to make a rebound
     */
    private void checkPaddleCollision() {
        int BALL_DIAMETER = BALL_RADIUS * 2;
        //The bottom of the ball is below or level with the top of the racket &&
        //The top of the ball is higher than the bottom of the racket.
        if (ball.getY() + BALL_DIAMETER >= paddle.getY() && ball.getY() < paddle.getY() + PADDLE_HEIGHT) {
            //the right side of the ball is to the right or level with the left side of the racket &&
            //the left side of the ball is to the left or level with the right side of the racket
            if (ball.getX() + BALL_DIAMETER >= paddle.getX() && ball.getX() <= paddle.getX() + paddle.getWidth()) {
                vy = -vy;
                //This prevents the ball from getting stuck inside the racket
                ball.setLocation(ball.getX(), paddle.getY() - BALL_DIAMETER);
            }
        }
    }

    /**
     * The method checks for ball collisions with walls
     */
    private void checkWallCollisions() {
        if (ball.getX() < 0 || ball.getX() > getWidth() - ball.getWidth()) {
            vx = -vx;// Left or right
        }
        if (ball.getY() < 0) {
            vy = -vy; // Top
        }
        if (ball.getY() > getHeight() - ball.getHeight()) {
            handleBallLoss();//Bottom
        }
    }

    /**
     * The method checks for ball collisions with bricks
     */
    private void checkBricksCollision() {
        GObject collider = getElementObject();
        if (collider != null && collider != paddle) {
            remove(collider);
            countBricks--;
            if (ball.getX() >= collider.getX() + collider.getWidth() ||
                    ball.getX() + BALL_RADIUS <= collider.getX()) {
                vx = -vx; // Colliding with the left or right side of a brick
            } else {
                vy = -vy; // Colliding with the top or bottom side of a brick
            }
        }
    }

    /**
     * Method for handling lost ball
     */
    private void handleBallLoss() {
        lives--;
        if (lives > 0) {
            resetBall();
        } else {
            removeAll();
            displayMessage("Game over");
        }
    }

    /**
     * The method resets the ball. And starts the next round of the game
     */
    private void resetBall() {
        remove(ball);
        drawBall();
        waitForClick();
        rGen();
    }

    /**
     * Method for displaying messages
     */
    public void displayMessage(String message) {
        GLabel label = new GLabel(message);
        label.setFont("Verdana-48");
        label.setColor(Color.RED);
        add(label);
        label.setLocation(getWidth() / 2.0 - label.getWidth() / 2.0, getHeight() / 2.0 - label.getAscent() / 2.0);
    }

    /**
     * The method creates and adds a brick
     */
    private void drawBrick(double x, double y, Color color) {
        GRect brick = new GRect(x, y, brickWidth, BRICK_HEIGHT);
        brick.setFilled(true);
        brick.setColor(color);
        add(brick);
    }

    /**
     * Method for placing bricks
     */
    public void drawBricks() {

        double xBricks = getWidth() / 2.0 - ((brickWidth + BRICK_SEP) * NBRICKS_PER_ROW - BRICK_SEP) / 2.0;
        Color[] colors = createColorArray();
        int colorIndex = 0; // Index of the current color in the array

        for (int i = 0; i < NBRICK_ROWS; i++) {
            // Checking if the color needs to be changed (every two lines)
            if (i % 2 == 0 && i > 0) {
                colorIndex = (colorIndex + 2) % colors.length; // Move to the next color in the array
            }
            Color currentColor = colors[colorIndex]; // Current color for line
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                drawBrick(xBricks + j * (brickWidth + BRICK_SEP),
                        BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP), currentColor);
            }
        }
    }

    /**
     * The method creates an array of colors
     */
    public static Color[] createColorArray() {
        Color[] baseColors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
                Color.MAGENTA, Color.PINK, Color.BLUE, Color.GRAY};

        Color[] colors = new Color[NBRICK_ROWS];

        for (int i = 0; i < NBRICK_ROWS; i++) {
            //the index will not go beyond the array
            colors[i] = baseColors[i / 2 % baseColors.length];
        }
        return colors;
    }
}