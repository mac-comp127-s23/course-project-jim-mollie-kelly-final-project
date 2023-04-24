package DuckDuckGreyDuck;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.Point;

public class PinPoint extends Image{

    private static CanvasWindow canvas;
    private double size = 100;
    private String imagePath;
    private Image image;
    private double x, y;
    
    public PinPoint(double x, double y, String imagePath, CanvasWindow canvas){
        super(x, y, imagePath);
        this.imagePath = imagePath;
        this.canvas = canvas;
        image = new Image(x,y);
        image.setImagePath(imagePath);
        image.setMaxHeight(size);
        image.setMaxWidth(size);
        addToCanvas();
    }

    public void getImagePath(String newImagePath){
        this.imagePath = imagePath;
    }

    public void addToCanvas(){
        canvas.add(image);
        canvas.draw();
    }

    // When the mouse pointer is hovered over the pin point, the pin point lights up 
    // Reminder: make sure the conditions only check for the pin points.
    public void onHoverCollision(CanvasWindow canvas, GrayDuck duck){
        //GraphicsObject obj = canvas.getElementAt(duck.getX(), duck.getY()); 
        //if(obj != null && obj == duck){
            
        }

    }

    // public static void main(String[] args){
    //     canvas = new CanvasWindow("Duck, Duck, Gray Duck", 1000, 1000);
    //     PinPoint pin = new PinPoint(200, 300, "pins/point-objects.png", canvas);
    //     canvas.draw();
    // }
}