package breakout;

import java.awt.Color;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

public class Ball extends GraphicsGroup{

    public static final double GRAVITY = -9.8;
    public static final double BALL_RADIUS = 10;

    private Ellipse ball;
    private double centerX;
    private double centerY;
    private double currentSpeedX;
    private double currentSpeedY;

    public Ball(double centerX, double centerY, double initialSpeed) {

        this.centerX = centerX;
        this.centerY = centerY;

        ball = new Ellipse(centerX, centerY, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFillColor(Color.BLACK);
        ball.setFilled(true);

        Random random = new Random();

        double initialAngle = random.nextDouble(180);

        double initialAngleRadians = Math.toRadians(initialAngle);
        this.currentSpeedX = initialSpeed * Math.cos(initialAngleRadians); 
        this.currentSpeedY = initialSpeed * -Math.sin(initialAngleRadians);
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
