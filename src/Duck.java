import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
public class Duck {

    public Image image;
    public Rectangle box;
    public CanvasWindow canvas;
    public double size = 100;
  
    public String imagePath;
    
    public Duck(double x, double y, String imagePath, CanvasWindow canvas) {
        this.imagePath = imagePath;
        this.canvas = canvas;
        image = new Image(x, y);
        image.setImagePath(imagePath);
        image.setMaxWidth(size);
        image.setMaxHeight(size);
        addToCanvas();
        moveDuck();
    }


     public String getImagePath(){
        return imagePath;
    }
    public void setImageString(String newImagePath){
        this.imagePath = newImagePath;
    }

    public void flapHorizontal(String a, String b){
        if(getImagePath().equalsIgnoreCase(a)){
            image.setImagePath(b);
            setImageString(b);
        } else{
            image.setImagePath(a);
            setImageString(a);
            
        } 
    }

    public void flapVertical(){
        if(getImagePath().equalsIgnoreCase("ducks/grayDuck_1R.png")){
            image.setImagePath("ducks/grayDuck_2R.png");
            setImageString("ducks/grayDuck_2R.png");
        }
        if(getImagePath().equalsIgnoreCase("ducks/grayDuck_2R.png")){
            image.setImagePath("ducks/grayDuck_1R.png");
            setImageString("ducks/grayDuck_1R.png");
        }
        if(getImagePath().equalsIgnoreCase("ducks/grayDuck_1L.png")){
            image.setImagePath("ducks/grayDuck_2L.png");
            setImageString("ducks/grayDuck_2L.png");
        } else {
            image.setImagePath("ducks/grayDuck_1L.png");
            setImageString("ducks/grayDuck_1L.png");
        } canvas.draw();
        
    }

    public void addToCanvas(){
        canvas.add(image);
        canvas.draw();
    }

    public void moveDuck(){
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();
        canvas.onKeyDown(key -> {
            if(key.getKey() == Key.RIGHT_ARROW){
                double paddleRightX = image.getCenter().getX() + (image.getWidth()/2);
                if(paddleRightX < canvasWidth){
                    flapHorizontal("ducks/grayDuck_1R.png", "ducks/grayDuck_2R.png");
                    image.moveBy(10, 0);
                }
            }
            if(key.getKey() == Key.LEFT_ARROW){
                double paddleLeftX = image.getCenter().getX() - (image.getWidth()/2);
                if(paddleLeftX > 0){
                    flapHorizontal("ducks/grayDuck_1L.png", "ducks/grayDuck_2L.png");
                    image.moveBy(-10, 0);
                }
            }
            if(key.getKey() == Key.UP_ARROW){
                double paddleTop = image.getCenter().getY() + (image.getHeight()/2);
                if(paddleTop < canvasHeight){
                    flapVertical();
                    image.moveBy(0, -10);
                }
            }
            if(key.getKey() == Key.DOWN_ARROW){
                double paddleBottom = image.getCenter().getY() - (image.getHeight()/2);
                if(paddleBottom < canvasHeight){
                    flapVertical();
                    image.moveBy(0, 10); 
                }
            }
        canvas.draw();
        });
    }
    public static void main(String[] args) {
        String title = "Duck Duck Grey Duck!!";
        CanvasWindow canvas = new CanvasWindow(title, 1000, 750);
        new Duck(canvas.getCenter().getX(), canvas.getCenter().getY(), "ducks/grayDuck_1R.png", canvas);
        

    }
}


   

