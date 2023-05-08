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
    private Image duck;
    private CanvasWindow canvas;
    private String imagePath;
    private Double x, y;
    private ArrayList<Point> duckBoundList;
    private static final int DUCK_WIDTH = 70, DUCK_HEIGHT = 40;;
    
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
     * gets the bounds of the ducks and puts it in an array list
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
     * Getter - gets the image path
     */
     public String getImagePath(){
        return imagePath;
    }

    /**
     * Setter - sets the image path (takes in a string)
     */
    public void setImageString(String newImagePath){
        this.imagePath = newImagePath;
    }

    /**
     * Animation for when the duck moves horizontally
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
     * Sets the duck's initial position
     */
    public void resetDuck(){
        x = canvas.getCenter().getX();
        y = canvas.getCenter().getY();
        setPosition(x, y);
    }

    /**
     * Animation for when the duck moves vertically
     */
    public void flapVertical(){
        if(getImagePath().equalsIgnoreCase("grayDuck_1R.png")){
            duck.setImagePath("grayDuck_2R.png");
            setImageString("grayDuck_2R.png");
        }
        if(getImagePath().equalsIgnoreCase("grayDuck_2R.png")){
            duck.setImagePath("grayDuck_1R.png");
            setImageString("grayDuck_1R.png");
        }
        if(getImagePath().equalsIgnoreCase("grayDuck_1L.png")){
            duck.setImagePath("grayDuck_2L.png");
            setImageString("grayDuck_2L.png");
        } else {
            duck.setImagePath("grayDuck_1L.png");
            setImageString("grayDuck_1L.png");
        } canvas.draw();
        
    }

    /**
     * Adds things to the canvas
     */
    public void addToCanvas(){
        canvas.add(duck);
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
                    flapHorizontal("grayDuck_1R.png", "grayDuck_2R.png");
                    duck.moveBy(10, 0);
                    x = x + 10;
                }
            }
            if(key.getKey() == Key.LEFT_ARROW){
                double paddleLeftX = duck.getCenter().getX() - (duck.getWidth()/2);
                if(paddleLeftX > 0){
                    flapHorizontal("grayDuck_1L.png", "grayDuck_2L.png");
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