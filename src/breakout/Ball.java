package breakout;

/* Stephanie Miles
 / COMP127 Spring 2023 
 / HOMEWORK #4
 / Due: 9 Apr 2023 11:59
*/

import java.awt.Color;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

/** The ball used for the Breakout game.*/
public class Ball extends GraphicsGroup{

    public static final double BALL_RADIUS = 10;
    public final Color PASTEL_PURPLE = new Color(199, 206, 234);

    private Ellipse ball;
    private double centerX, centerY;
    private double topLeftX, topLeftY;
    private double topRightX, topRightY;
    private double bottomLeftX, bottomLeftY;
    private double bottomRightX, bottomRightY;
    private double dx, dy;

    /** Creates a ball object with center (centerX, centerY) and
     * pastel purple color
     */
    public Ball(double centerX, double centerY) {

        this.centerX = centerX;
        this.centerY = centerY;

        ball = new Ellipse(centerX, centerY, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);

        ball.setFillColor(PASTEL_PURPLE);
        ball.setStrokeColor(PASTEL_PURPLE);

        this.topLeftX = ball.getX();
        this.topLeftY = ball.getY();

        this.topRightX = this.topLeftX + (2 * BALL_RADIUS);
        this.topRightY = this.topLeftY;

        this.bottomLeftX = this.topLeftX;
        this.bottomLeftY = this.topLeftY + (2 * BALL_RADIUS);

        this.bottomRightX = this.topLeftX + (2 * BALL_RADIUS);
        this.bottomRightY = this.topLeftY + (2 * BALL_RADIUS);

        this.dx = setDx();

        this.dy = 10.0;

    }

    /** Sets the x value of speed to a random double between 1.0 and 4.0 */
    public double setDx() {
        Random random = new Random();
        this.dx = random.nextDouble(1.0, 5.0);
        if (random.nextBoolean()) {
            this.dx = -this.dx;
        }
        return this.dx;
    }

    /** Uses the corners of the bounding box of the ball to move around the canvas.
     * 
     * @param dt how much you want the ball to move each time animation is called.
     * @param canvas CanvasWindow object
     * @param paddle Rectangle object
     * @param manager BrickManager
     */
    public void moveBall(double dt, CanvasWindow canvas, Rectangle paddle, BrickManager manager) {

        ball.moveBy(dx, dy);
        if (this.topLeftX - dx <= 0 && dx < 0  || this.topRightX  + dx >= canvas.getWidth() && dx > 0) {
            dx = -dx;
        }
        if (this.topLeftY - dy <= 0 && dy < 0) {
            dy = -dy;
        }

        topLeftX = ball.getX();
        topLeftY = ball.getY();

        topRightX = topLeftX + (2 * BALL_RADIUS);
        topRightY = topLeftY;

        bottomLeftX = topLeftX;
        bottomLeftY = topLeftY + (2 * BALL_RADIUS);

        bottomRightX = topLeftX + (2 * BALL_RADIUS);
        bottomRightY = topLeftY + (2 * BALL_RADIUS);
        

        if (getObjectHit(canvas) == paddle) {
            if (dy > 0) {
                dy = -dy;
            }
        } 
        else {
            if (getObjectHit(canvas) != null) {
                canvas.remove(getObjectHit(canvas));
                manager.removeBrickFromCount();
                dy = -dy;
            }
        }
    }

    /** Uses the four corners of the ball to detect and return 
     * which object it has collided with
     */
    public GraphicsObject getObjectHit(CanvasWindow canvas) {
        if (canvas.getElementAt(this.bottomLeftX, this.bottomLeftY) != null) {
            return canvas.getElementAt(this.bottomLeftX, this.bottomLeftY);
        } else if (canvas.getElementAt(this.bottomRightX, this.bottomRightY) != null) {
            return canvas.getElementAt(this.bottomRightX, this.bottomRightY);
        } else if (canvas.getElementAt(this.topLeftX, this.topLeftY) != null) {
            return canvas.getElementAt(this.topLeftX, this.topLeftY);
        } else if (canvas.getElementAt(this.topRightX, this.topRightY) != null) {
            return canvas.getElementAt(this.topRightX, this.topRightY);
        } 
        return null;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ball);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ball);
    }

    /** Puts ball back at its starting position after user loses a life
     */
    public void resetBall(double x, double y, double dx1, double dy1) {
        ball.setCenter(x, y);
        dx = dx1;
        dy = dy1;
    }

    @Override
    public String toString() {
        return "Ball [PASTEL_PURPLE=" + PASTEL_PURPLE + ", ball=" + ball + ", centerX=" + centerX + ", centerY="
            + centerY + ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + ", topRightX=" + topRightX
            + ", topRightY=" + topRightY + ", bottomLeftX=" + bottomLeftX + ", bottomLeftY=" + bottomLeftY
            + ", bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY + ", dx=" + dx + ", dy=" + dy + "]";
    }

    public double getBottomLeftY() {
        return this.bottomLeftY;
    }

    public double getBottomLeftX() {
        return this.bottomLeftX;
    }

    public double getBottomRightY() {
        return this.bottomRightY;
    }

    public double getBottomRightX() {
        return this.bottomRightX;
    }

    public double getTopLeftY() {
        return this.topLeftY;
    }

    public double getTopLeftX() {
        return this.topLeftX;
    }

    public double getTopRightY() {
        return this.topRightY;
    }

    public double getTopRightX() {
        return this.topRightX;
    }

    public double getCenterX() {
        return this.centerX;
    }

    public double getCenterY() {
        return this.centerY;
    }

}
