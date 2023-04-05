package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

public class Paddle extends GraphicsGroup {
    private Rectangle paddle;
    
    public Paddle(double x, double y, double width, double height) {
            paddle = new Rectangle(x, y, width, height);
    }

    public void addPaddleToCanvas(CanvasWindow canvas) {
        canvas.add(paddle);
    }
}
