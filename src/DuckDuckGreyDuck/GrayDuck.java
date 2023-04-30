package DuckDuckGreyDuck;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.Point;

public class GrayDuck extends Image{
    private static final int DUCK_WIDTH = 20;
    private static final int DUCK_HEIGHT = 50;

    /**
     * Instance variables
     */
    private Image duck;
    
    private CanvasWindow canvas;
    private double size = 100;
    private String imagePath;
    private PinPoint pin;
    private Double centerX;
    private Double centerY;
    public ArrayList<Point> duckBoundList;
    

    
    public GrayDuck(double centerX, double centerY, String imagePath, CanvasWindow canvas) {
        super(centerX-DUCK_WIDTH/2, centerY-DUCK_HEIGHT/2, imagePath);
        this.imagePath = imagePath;
        this.canvas = canvas;
        this.centerX = centerX;
        this.centerY = centerY;
        duck = new Image(centerX-DUCK_WIDTH/2, centerY-DUCK_HEIGHT/2);
        duck.setImagePath(imagePath);
        duck.setMaxWidth(DUCK_WIDTH);
        duck.setMaxHeight(DUCK_HEIGHT);
        
    }

    public ArrayList<Point> duckBounds(double cX, double cY){

        ArrayList<Point> duckBoundList = new ArrayList<Point>();
        Point topLeft = new Point(cX-DUCK_WIDTH/2, cY-DUCK_HEIGHT/2);
        duckBoundList.add(topLeft);
        Point topRight = new Point(cX+DUCK_WIDTH/2, cY-DUCK_HEIGHT/2);
        duckBoundList.add(topRight);
        Point bottomLeft = new Point(cX-DUCK_WIDTH/2, cY+DUCK_HEIGHT/2);
        duckBoundList.add(bottomLeft);
        Point bottomRight = new Point(cX+DUCK_WIDTH/2, cY+DUCK_HEIGHT/2);
        duckBoundList.add(bottomRight);
        Point bottomCenter = new Point((bottomLeft.getX()+ bottomRight.getX())/2, (bottomLeft.getY()+ bottomRight.getY())/2);
        duckBoundList.add(bottomCenter);
        Point topCenter = new Point((topLeft.getX()+ topRight.getX())/2, (topLeft.getY()+ topRight.getY())/2);
        duckBoundList.add(topCenter);
        return duckBoundList;
        
    }
    /**
     * Getter - 
     */
     public String getImagePath(){
        return imagePath;
    }

    /**
     * Getter - 
     */
    public double getX2(){
        return this.getX() + this.getWidth();
    }

    /**
     * Getter - 
     */
    public double getY2(){
        return this.getY() + this.getHeight();
    }


    /**
     * Setter - 
     */
    public void setImageString(String newImagePath){
        this.imagePath = newImagePath;
    }

    /**
     * 
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
     * Creates animations to make a flapping aniamtion.
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
                    centerX = centerX + 10;
                }
            }
            if(key.getKey() == Key.LEFT_ARROW){
                double paddleLeftX = duck.getCenter().getX() - (duck.getWidth()/2);
                if(paddleLeftX > 0){
                    flapHorizontal("ducks/grayDuck_1L.png", "ducks/grayDuck_2L.png");
                    duck.moveBy(-10, 0);
                    centerX = centerX - 10;
                }
            }
            if(key.getKey() == Key.UP_ARROW){
                double paddleTop = duck.getCenter().getY() + (duck.getHeight()/2);
                if(paddleTop < canvasHeight){
                    flapVertical();
                    duck.moveBy(0, -10);
                    centerY = centerY - 10;
                }
            }
            if(key.getKey() == Key.DOWN_ARROW){
                double paddleBottom = duck.getCenter().getY() - (duck.getHeight()/2);
                if(paddleBottom < canvasHeight){
                    flapVertical();
                    duck.moveBy(0, 10); 
                    centerY = centerY + 10;
                }
            }
        duck.setCenter(centerX, centerY); 
        canvas.draw();
        });
    }

    public double getCenterX(){
        return centerX;
    }
    public double getCenterY(){
        return centerY;
    }
    public static void main(String[] args) {
        // String title = "Duck Duck Grey Duck!!";
        // CanvasWindow canvas = new CanvasWindow(title, 1000, 750);
        // Image backdrop = new Image(0, 0, "ducks/Mill District.png");
        // canvas.add(backdrop);
        // canvas.draw();
        // new GrayDuck(canvas.getCenter().getX(), canvas.getCenter().getY(), "ducks/grayDuck_1R.png", canvas);
        // CanvasWindow canvas2 = new CanvasWindow("canvas", 500, 425);
        // GameMenu run = new GameMenu(canvas2);

    // }
}


   
}
