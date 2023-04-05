package breakout;

import java.awt.Color;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Ball extends GraphicsGroup{

    public static final double BALL_RADIUS = 10;

    private Ellipse ball;
    private double centerX, centerY;
    private double topLeftX, topLeftY;
    private double topRightX, topRightY;
    private double bottomLeftX, bottomLeftY;
    private double bottomRightX, bottomRightY;
    private double centerTopX, centerBottomX;
    private double centerTopY, centerBottomY;
    private double leftCenterX, rightCenterX;
    private double leftCenterY, rightCenterY;
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

        // this.centerTopX = (this.topLeftX + this.topRightX) / 2;
        // this.centerTopY =  (this.topLeftY + this.topRightY) / 2;

        // this.centerBottomX = (this.bottomLeftX + this.bottomRightX) / 2;
        // this.centerBottomY = (this.bottomLeftY + this.bottomRightY) / 2;

        // this.leftCenterX = (this.topLeftX + this.bottomLeftX) / 2;
        // this.leftCenterY = (this.topLeftY + this.bottomLeftY) / 2;

        // this.rightCenterX = (this.topRightX + this.bottomRightX) / 2;
        // this.rightCenterY = (this.topRightY + this.bottomRightY) / 2;

        Random random = new Random();
        this.dx = random.nextDouble(1.0, 5.0);
        if (random.nextBoolean()) {
            this.dx = -this.dx;
        }
        this.dy = 5.0;
    }

    public void moveBall(double dt, CanvasWindow canvas, Rectangle paddle, BrickManager manager) {
        topLeftX = ball.getX();
        topLeftY = ball.getY();

        topRightX = topLeftX + (2 * BALL_RADIUS);

        bottomLeftY = topLeftY + (2 * BALL_RADIUS);

        ball.moveBy(dx, dy);
        if (this.topLeftX - dx <= 0 && dx < 0  || this.topRightX  + dx >= canvas.getWidth() && dx > 0) {
            dx = -dx;
        }
        if (this.topLeftY -dy <= 0 && dy < 0|| this.bottomLeftY + dy >= canvas.getHeight() && dy > 0) {
            dy = -dy;
        }

        if (getObjectHit(canvas) == paddle) {
            if (dy > 0) {
                dy = -dy;
            }
        }
        
    } 

    public GraphicsObject getObjectHit(CanvasWindow canvas) {
        if (canvas.getElementAt(this.bottomLeftX, this.bottomLeftY + 1) != null) {
            return canvas.getElementAt(this.bottomLeftX, this.bottomLeftY + 1);
        } else if (canvas.getElementAt(this.bottomRightX, this.bottomRightY + 1) != null) {
            return canvas.getElementAt(this.bottomRightX, this.bottomRightY + 1);
        } else if (canvas.getElementAt(this.topLeftX, this.topLeftY - 1) != null) {
            return canvas.getElementAt(this.topLeftX, this.topLeftY - 1);
        } else if (canvas.getElementAt(this.topRightX, this.topRightY - 1) != null) {
            return canvas.getElementAt(this.topRightX, this.topRightY - 1);
        } 
        //else if (canvas.getElementAt(this.centerTopX, this.centerTopY - 1) != null) {
        //     System.out.println("ct");
        //     return canvas.getElementAt(this.centerTopX, this.centerTopY - 1);
        // } else if (canvas.getElementAt(this.centerBottomX, this.centerBottomY - 1) != null) {
        //     System.out.println("cb");
        //     return canvas.getElementAt(this.centerBottomX, this.centerBottomY - 1);
        // } else if (canvas.getElementAt(this.leftCenterX, this.leftCenterY + 1) != null) {
        //     System.out.println("lc");
        //     return canvas.getElementAt(this.leftCenterX, this.leftCenterY + 1);
        // } else if (canvas.getElementAt(this.rightCenterX, this.rightCenterY + 1) != null) {
        //     System.out.println("rc");
        //     return canvas.getElementAt(this.rightCenterX, this.rightCenterY + 1);
        // }
        return null;
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
