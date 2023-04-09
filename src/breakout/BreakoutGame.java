package breakout;

/* Stephanie Miles
 / COMP127 Spring 2023 
 / HOMEWORK #4
 / Due: 9 Apr 2023 11:59
*/

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
    private GraphicsText losingText2;
    private int lifeCount = 3;
   
    /** Creates a window for the Breakout game of size 600x800.  */
    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);

        winningText = new GraphicsText();
        winningText.setText("GAME WON!");
        winningText.setFont(FontStyle.BOLD_ITALIC, 50);
        winningText.setCenter(CANVAS_WIDTH * 0.47, CANVAS_HEIGHT * 0.65);
        winningText.setFillColor(Color.WHITE);

        losingText = new GraphicsText();
        losingText.setText("GAME OVER!");
        losingText.setFont(FontStyle.BOLD_ITALIC, 50);
        losingText.setCenter(CANVAS_WIDTH * 0.47, CANVAS_HEIGHT * 0.65);
        losingText.setFillColor(Color.WHITE);

        losingText2 = new GraphicsText();
        losingText2.setText("YOU'VE LOST ALL 3 LIVES.");
        losingText2.setFont(FontStyle.PLAIN, 25);
        losingText2.setCenter(CANVAS_WIDTH * 0.47, CANVAS_HEIGHT * 0.71);
        losingText2.setFillColor(Color.WHITE);

        manager = new BrickManager(canvas);

    }

    /** Creates and returns a paddle using a 
     * rectangle graphics object.*/
    public Rectangle createPaddle() {
        Rectangle paddle = new Rectangle(CANVAS_WIDTH * 0.38, CANVAS_HEIGHT * 0.85, 120, 10);
        paddle.setFillColor(PASTEL_PURPLE);
        paddle.setStrokeColor(PASTEL_PURPLE);
        return paddle;
    }

    /** Generates brick layers and moveable paddle. Contains logic
     * to start, animate, and end the game.
     */
    public void run() {

        manager.generateBricks();

        //add paddle to canvas and allow it to move along with mouse move
        Rectangle paddle = createPaddle();
        canvas.add(paddle);
        canvas.onMouseMove(event -> {
            if (paddle.getPosition().getX() <= CANVAS_WIDTH) {
                paddle.setCenter(event.getPosition().getX(), CANVAS_HEIGHT * 0.85);
            }});

        ball = new Ball(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.5);
        ball.addToCanvas(canvas);

        //ball added to canvas and canvas pauses for 3 seconds. 
        canvas.draw();
        canvas.pause(3000);
        canvas.animate(() -> {
            if (lifeCount > 0 && manager.bricksStillExist()) {
                if (ball.getBottomLeftY() < CANVAS_HEIGHT) {
                    ball.moveBall(0.1, canvas, paddle, manager);
                } else {
                    ball.resetBall(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.5, ball.setDx(), 10);
                    canvas.draw();
                    canvas.pause(3000);
                    ball.moveBall(0.1, canvas, paddle, manager);
                    lifeCount -= 1;
                }
            } else if (lifeCount == 0) {
                canvas.add(losingText);
                canvas.add(losingText2);
                canvas.draw();
            } else if (!manager.bricksStillExist()) {
                canvas.add(winningText);
                canvas.draw();
            }
        });  
    }

    @Override
    public String toString() {
        return "BreakoutGame [PASTEL_PURPLE=" + PASTEL_PURPLE + ", canvas=" + canvas + ", manager=" + manager
            + ", ball=" + ball + ", winningText=" + winningText + ", losingText=" + losingText + ", losingText2="
            + losingText2 + ", lifeCount=" + lifeCount + "]";
    }

    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();   
    }
}
