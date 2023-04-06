package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    public final Color PASTEL_PURPLE = new Color(199, 206, 234);

    private CanvasWindow canvas;
    private BrickManager manager;
    private Ball ball;
    private GraphicsText winningText;
    private GraphicsText losingText;
    private int lifeCount = 3;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);

        winningText = new GraphicsText();
        winningText.setText("GAME WON!");
        winningText.setFont(FontStyle.BOLD_ITALIC, 50);
        winningText.setCenter(CANVAS_WIDTH * 0.47, CANVAS_HEIGHT * 0.65);
        winningText.setFillColor(Color.WHITE);

        losingText = new GraphicsText();
        losingText.setText("GAME OVER");
        losingText.setFont(FontStyle.BOLD_ITALIC, 50);
        losingText.setCenter(CANVAS_WIDTH * 0.47, CANVAS_HEIGHT * 0.65);
        losingText.setFillColor(Color.WHITE);

        canvas.setBackground(Color.BLACK);
        manager = new BrickManager(canvas);

    }

    public Rectangle createPaddle() {
        Rectangle paddle = new Rectangle(CANVAS_WIDTH * 0.41, CANVAS_HEIGHT * 0.85, 90, 10);
        paddle.setFillColor(PASTEL_PURPLE);
        paddle.setStrokeColor(PASTEL_PURPLE);
        return paddle;
    }

    public void run() {
        Rectangle paddle = createPaddle();
        canvas.add(paddle);
        canvas.onMouseMove(event -> {
            if (event.getPosition().getX() <= CANVAS_WIDTH) {
                paddle.setX(event.getPosition().getX());
            }});

        ball = new Ball(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.5);
        ball.addToCanvas(canvas);

        canvas.draw();
        canvas.pause(3000);
        canvas.animate(() -> {
            if (lifeCount > 0 && manager.bricksStillExist()) {
                if (ball.getBottomLeftY() < CANVAS_HEIGHT) {
                    ball.moveBall(0.1, canvas, paddle, manager);
                } else {
                    ball.resetBall(CANVAS_WIDTH * 0.47, CANVAS_HEIGHT * 0.5, ball.setDx(), 5);
                    canvas.draw();
                    canvas.pause(3000);
                    ball.moveBall(0.1, canvas, paddle, manager);
                    lifeCount -= 1;
                }
            } else if (lifeCount == 0) {
                canvas.add(losingText);
                canvas.draw();
            } else if (!manager.bricksStillExist()) {
                canvas.add(winningText);
                canvas.draw();
            }
            
            
        });
        
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
