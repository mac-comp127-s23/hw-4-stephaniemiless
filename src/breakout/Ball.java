package breakout;

import java.awt.Color;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

public class Ball extends GraphicsGroup{

    public static final double BALL_RADIUS = 10;

    private Ellipse ball;
    private double centerX, centerY;
    private double topLeftX, topLeftY;
    private double topRightX, topRightY;
    private double bottomLeftX, bottomLeftY;
    private double bottomRightX, bottomRightY;
    private double dx, dy;

    public Ball(double centerX, double centerY, double initialSpeed) {

        this.centerX = centerX;
        this.centerY = centerY;

        ball = new Ellipse(centerX, centerY, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);

        ball.setFillColor(Color.BLACK);
        this.topLeftX = ball.getX();
        this.topLeftY = ball.getY();

        this.topRightX = this.topLeftX + (2 * BALL_RADIUS);
        this.topRightY = this.topLeftY;

        this.bottomLeftX = this.topLeftX;
        this.bottomLeftY = this.topLeftY + (2 * BALL_RADIUS);

        this.bottomRightX = this.topLeftX + (2 * BALL_RADIUS);
        this.bottomRightY = this.topLeftY + (2 * BALL_RADIUS);

        Random random = new Random();
        this.dx = random.nextDouble(1.0, 3.0);
        if (random.nextBoolean()) {
            this.dx = -this.dx;
        }
        this.dy = 4.0;

        // double initialAngle = random.nextDouble(180);
        

        // double initialAngleRadians = Math.toRadians(initialAngle);
        // this.currentSpeedX = initialSpeed * Math.cos(initialAngleRadians); 
        // this.currentSpeedY = initialSpeed * -Math.sin(initialAngleRadians);
    }

    public void moveBall(double dt, CanvasWindow canvas) {
        topLeftX = ball.getX();
        topLeftY = ball.getY();

        topRightX = topLeftX + (2 * BALL_RADIUS);
        topRightY = topLeftY;

        bottomLeftX = topLeftX;
        bottomLeftY = topLeftY + (2 * BALL_RADIUS);

        bottomRightX = topLeftX + (2 * BALL_RADIUS);
        bottomRightY = topLeftY + (2 * BALL_RADIUS);

        ball.moveBy(dx, dy);
        if (topLeftX - dx <= 0 && dx < 0  || topRightX  + dx >= canvas.getWidth() && dx > 0) {
            dx = -dx;
        }
        if (topLeftY -dy <= 0 && dy < 0|| bottomLeftY + dy >= canvas.getHeight() && dy > 0) {
            dy = -dy;
        }
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

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ball);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ball);
    }




}
