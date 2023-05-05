package DuckDuckGreyDuck;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.Point;

public class GrayDuck extends Image{

    /**
     * Instance variables
     */
    private static final int DUCK_WIDTH = 40;
    private static final int DUCK_HEIGHT = 60;
    private Image duck;
    private CanvasWindow canvas;
    private String imagePath;
    private Double x, y;
    

    
    public GrayDuck(double x, double y, String imagePath, CanvasWindow canvas) {
        super(x, y, imagePath);
        this.imagePath = imagePath;
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        duck = new Image(x, y);
        duck.setImagePath(imagePath);
        duck.setMaxWidth(DUCK_WIDTH);
        duck.setMaxHeight(DUCK_HEIGHT);
        
    }

    /**
     * Adding things into the canvas
     */
    public ArrayList<Point> duckBounds(){

        ArrayList<Point> duckBoundList = new ArrayList<Point>();
        Point topLeft = new Point(x, y);
        duckBoundList.add(topLeft);
        Point topRight = new Point(x + DUCK_WIDTH, y);
        duckBoundList.add(topRight);
        Point bottomLeft = new Point(x, y + DUCK_HEIGHT);
        duckBoundList.add(bottomLeft);
        Point bottomRight = new Point(x + DUCK_WIDTH, y + DUCK_HEIGHT);
        duckBoundList.add(bottomRight);
        Point bottomCenter = new Point((bottomLeft.getX()+ bottomRight.getX())/2, (bottomLeft.getY()+ bottomRight.getY())/2);
        duckBoundList.add(bottomCenter);
        Point topCenter = new Point((topLeft.getX()+ topRight.getX())/2, (topLeft.getY()+ topRight.getY())/2);
        duckBoundList.add(topCenter);
        return duckBoundList;
        
    }

    /**
     * Getter - Gets image path
     */
     public String getImagePath(){
        return imagePath;
    }

    /**
     * Setter - Sets the image path
     */
    public void setImageString(String newImagePath){
        this.imagePath = newImagePath;
    }

    /**
     * Allows for horizontal image animation
     */
    public void flapHorizontal(String a, String b){
        if(getImagePath().equalsIgnoreCase(a)){
            duck.setImagePath(b);
            setImageString(b);
        } else{
            duck.setImagePath(a);
            setImageString(a);
            
        } 
    }

    /**
     * Fixes the duck's position to initially start at the middle of the canvas
     */
    public void resetDuck(){
        x = canvas.getCenter().getX();
        y = canvas.getCenter().getY();
        setPosition(x, y);
    }

    /**
     * Creates animations to make a flapping animation vertically
     */
    public void flapVertical(){
        if(getImagePath().equalsIgnoreCase("ducks/grayDuck_1R.png")){
            duck.setImagePath("ducks/grayDuck_2R.png");
            setImageString("ducks/grayDuck_2R.png");
        }
        if(getImagePath().equalsIgnoreCase("ducks/grayDuck_2R.png")){
            duck.setImagePath("ducks/grayDuck_1R.png");
            setImageString("ducks/grayDuck_1R.png");
        }
        if(getImagePath().equalsIgnoreCase("ducks/grayDuck_1L.png")){
            duck.setImagePath("ducks/grayDuck_2L.png");
            setImageString("ducks/grayDuck_2L.png");
        } else {
            duck.setImagePath("ducks/grayDuck_1L.png");
            setImageString("ducks/grayDuck_1L.png");
        } canvas.draw();
        
    }

    /**
     * Adds things into the canvas
     */
    public void addToCanvas(){
        canvas.add(duck);
        canvas.draw();
    }

    /**
     * Keeps track of what keyboard arrows are hit and moves the ducks based on what the arrow is hit.
     */
    public void moveDuck(){
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();
        canvas.onKeyDown(key -> {
            if(key.getKey() == Key.RIGHT_ARROW){
                double paddleRightX = duck.getCenter().getX() + (duck.getWidth()/2);
                if(paddleRightX < canvasWidth){
                    flapHorizontal("ducks/grayDuck_1R.png", "ducks/grayDuck_2R.png");
                    duck.moveBy(10, 0);
                    x = x + 10;
                }
            }
            if(key.getKey() == Key.LEFT_ARROW){
                double paddleLeftX = duck.getCenter().getX() - (duck.getWidth()/2);
                if(paddleLeftX > 0){
                    flapHorizontal("ducks/grayDuck_1L.png", "ducks/grayDuck_2L.png");
                    duck.moveBy(-10, 0);
                    x = x - 10;
                }
            }
            if(key.getKey() == Key.UP_ARROW){
                double paddleTop = duck.getCenter().getY() + (duck.getHeight()/2);
                if(paddleTop < canvasHeight){
                    flapVertical();
                    duck.moveBy(0, -10);
                    y = y - 10;
                }
            }
            if(key.getKey() == Key.DOWN_ARROW){
                double paddleBottom = duck.getCenter().getY() - (duck.getHeight()/2);
                if(paddleBottom < canvasHeight){
                    flapVertical();
                    duck.moveBy(0, 10); 
                    y = y + 10;
                }
            }
        duck.setPosition(x, y);
        canvas.draw();
        });
    }

   
}
