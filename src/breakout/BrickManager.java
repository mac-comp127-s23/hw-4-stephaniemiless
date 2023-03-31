package breakout;

import java.awt.Color;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;

public class BrickManager {
    
    private List<Brick> bricks;
    private CanvasWindow canvas;
    private Brick brick;

    public BrickManager(CanvasWindow canvas) {
        this.canvas = canvas;
    }

    public void generateBricks() {
        double xCoor1 = 1;
        double yCoor1 = 25;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.RED, xCoor1, yCoor1, canvas);
            brick.addToCanvas();
            canvas.add(brick);  
            xCoor1 += 60; 
        }

        double xCoor2 = 1;
        double yCoor2 = 49;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.RED, xCoor2, yCoor2, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor2 += 60; 
        }

        double xCoor3 = 1;
        double yCoor3 = 73;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.ORANGE, xCoor3, yCoor3, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor3 += 60; 
        }

        double xCoor4 = 1;
        double yCoor4 = 97;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.ORANGE, xCoor4, yCoor4, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor4 += 60; 
        }

        double xCoor5 = 1;
        double yCoor5 = 121;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.YELLOW, xCoor5, yCoor5, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor5 += 60; 
        }

        double xCoor6 = 1;
        double yCoor6 = 145;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.YELLOW, xCoor6, yCoor6, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor6 += 60; 
        }

        double xCoor7 = 1;
        double yCoor7 = 169;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.GREEN, xCoor7, yCoor7, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor7 += 60; 
        }

        double xCoor8 = 1;
        double yCoor8 = 193;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.GREEN, xCoor8, yCoor8, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor8 += 60; 
        }

        double xCoor9 = 1;
        double yCoor9 = 217;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.BLUE, xCoor9, yCoor9, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor9 += 60; 
        }

        double xCoor10 = 1;
        double yCoor10 = 241;
        for (int i = 0; i < 10; i++) {
            brick = new Brick(Color.BLUE, xCoor10, yCoor10, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor10 += 60; 
        }

        double xCoor11 = 1;
        double yCoor11 = 265;
        for (int i = 0; i < 10; i++) {
            Color purple = new Color(119, 0, 200);
            brick = new Brick(purple, xCoor11, yCoor11, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor11 += 60; 
        }

        double xCoor12 = 1;
        double yCoor12 = 289;
        for (int i = 0; i < 10; i++) {
            Color purple = new Color(119, 0, 200);
            brick = new Brick(purple, xCoor12, yCoor12, canvas);
            brick.addToCanvas();
            canvas.add(brick); 
            xCoor12 += 60; 
        }


    }

    public boolean bricksStillExist() {
        return bricks.size() > 0;
    }

    public int getNumOfBricks() {
        return bricks.size();
    }
}
