package breakout;

import java.awt.Color;

import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Brick {

    private Rectangle brick;
    private double centerX;
    private double centerY;

    public Brick(Color color, double xCoor, double yCoor) {

        brick = new Rectangle(xCoor, yCoor, 58, 20);
        brick.setFillColor(color);
        brick.setStrokeColor(color);

        Point center = brick.getCenter();
        this.centerX = center.getX();
        this.centerY = center.getY();
    }
    
    // public boolean intersects(Ball ball) {
    //     double distanceX = ball.getCenterX() - this.centerX;
    //     double distanceY = ball.getCenterY() - this.centerY;
    //     double distance = Math.hypot(distanceX, distanceY);

    //     if (distance - ball.BALL_RADIUS <= this.radius) {
    //         return true;
    //     }
    //     return false;
    // }
}
