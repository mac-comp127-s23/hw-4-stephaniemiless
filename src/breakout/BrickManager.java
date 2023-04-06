package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

public class BrickManager {

    public final Color PASTEL_RED = new Color(255, 154, 162);
    public final Color PASTEL_PINK = new Color(255, 183, 178);
    public final Color PASTEL_ORANGE = new Color(255, 218, 193);
    public final Color PASTEL_GREEN = new Color(226, 240, 203);
    public final Color PASTEL_AQUA = new Color(181, 234, 215);
    public final Color PASTEL_BLUE = new Color(175, 213, 240);
    
    private int brickCount = 120;
    private CanvasWindow canvas;
    private Brick brick;

    public BrickManager(CanvasWindow canvas) {
        this.canvas = canvas;
    }

    public void makeBrickRow(double xCoor, double yCoor, Color color) {
        double xCoor1 = xCoor;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(color, xCoor1, yCoor, canvas);
            brick.addToCanvas();
            xCoor1 += 60;
        }

    }

    public void generateBricks() {
        
        makeBrickRow(1, 25, PASTEL_RED);

        makeBrickRow(1, 49, PASTEL_RED);

        makeBrickRow(1, 73, PASTEL_PINK);

        makeBrickRow(1, 97, PASTEL_PINK);

        makeBrickRow(1, 121, PASTEL_ORANGE);

        makeBrickRow(1, 145, PASTEL_ORANGE);

        makeBrickRow(1, 169, PASTEL_GREEN);

        makeBrickRow(1, 193, PASTEL_GREEN);

        makeBrickRow(1, 217, PASTEL_AQUA);

        makeBrickRow(1, 241, PASTEL_AQUA);

        makeBrickRow(1, 265, PASTEL_BLUE);

        makeBrickRow(1, 289, PASTEL_BLUE);

    }

    public boolean bricksStillExist() {
        return brickCount > 0;
    }

    public int getNumOfBricks() {
        return brickCount;
    }

    public void removeBrickFromCount() {
        brickCount -= 1;
    }
}
