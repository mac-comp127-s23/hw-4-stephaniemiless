package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Brick {

    private Rectangle brick;
    private double centerX;
    private double centerY;
    private CanvasWindow canvas;

    public Brick(Color color, double xCoor, double yCoor, CanvasWindow canvas) {

        brick = new Rectangle(xCoor, yCoor, 58, 20);
        brick.setFillColor(color);
        brick.setStrokeColor(color);

        this.canvas = canvas;

        Point center = brick.getCenter();
        this.centerX = center.getX();
        this.centerY = center.getY();
    }

    public Rectangle getBrick() {
        return brick;
    }

    public void addToCanvas() {
        canvas.add(brick);
    }

    public void removeFromCanvas() {
        canvas.remove(brick);
    }
}
