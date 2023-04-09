package breakout;

/* Stephanie Miles
 / COMP127 Spring 2023 
 / HOMEWORK #4
 / Due: 9 Apr 2023 11:59
*/

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

/** A single brick used in Breakout. */
public class Brick {

    private Rectangle brick;
    private CanvasWindow canvas;

    /** Creates a brick object using the rectangle graphics object of size 58x20 */
    public Brick(Color color, double xCoor, double yCoor, CanvasWindow canvas) {
        brick = new Rectangle(xCoor, yCoor, 58, 20);
        brick.setFillColor(color);
        brick.setStrokeColor(color);
        this.canvas = canvas;
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

    @Override
    public String toString() {
        return "Brick [brick=" + brick + ", canvas=" + canvas + "]";
    }

    
}
