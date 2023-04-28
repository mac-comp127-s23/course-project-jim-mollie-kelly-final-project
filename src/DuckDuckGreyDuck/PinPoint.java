package DuckDuckGreyDuck;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;

public class PinPoint extends Image{

    /**
     * Instance variables
     */
    private static CanvasWindow canvas;
    private double size = 50, x, y;
    private String imagePath;
    private Image image;
    private GrayDuck duck;
    
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

    /**
     * Getter - gets image path
     */
    public void getImagePath(String newImagePath){
        this.imagePath = imagePath;
    }

    /**
     * Adds things to the canvas
     */
    public void addToCanvas(){
        canvas.add(image);
        canvas.draw();
    }      
        };
    



    // public static void main(String[] args){
    //     canvas = new CanvasWindow("Duck, Duck, Gray Duck", 1000, 1000);
    //     PinPoint pin = new PinPoint(200, 300, "pins/point-objects.png", canvas);
    //     canvas.draw();
    // }
    

    // public static void main(String[] args){
    //     canvas = new CanvasWindow("Duck, Duck, Gray Duck", 1000, 1000);
    //     PinPoint pin = new PinPoint(200, 300, "ducks/point-objects.png", canvas);
    //     canvas.draw();
    // }

