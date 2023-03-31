package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private CanvasWindow canvas;
    private BrickManager manager;
    private Ball ball;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        manager = new BrickManager(canvas);
        //ball = new Ball(CANVAS_HEIGHT * 0.5, CANVAS_WIDTH * 0.5, 80, canvas);
        //run(); 

    }

    public Rectangle createPaddle() {
        Rectangle paddle = new Rectangle(CANVAS_WIDTH * 0.41, CANVAS_HEIGHT * 0.85, 90, 10);
        paddle.setFillColor(Color.BLACK);
        return paddle;
    }

    public void run() {
        Rectangle paddle = createPaddle();
        canvas.add(paddle);
        canvas.onDrag(event -> {
            if (event.getPosition().getX() <= CANVAS_WIDTH) {
                paddle.setX(event.getPosition().getX());
            }});
     
        ball = new Ball(CANVAS_WIDTH * 0.47, CANVAS_HEIGHT * 0.5, 80);
        ball.addToCanvas(canvas);
        canvas.animate(() -> ball.moveBall(0.1, canvas));

        
    }

    public void resetGame() {
        manager.generateBricks();
    }

    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.resetGame();
        game.run();

    }
}
