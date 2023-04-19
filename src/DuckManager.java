import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class DuckManager {
    private ArrayList<Duck> duckList = new ArrayList<Duck>();
    private Random random;
    private int numDucks;
    private double dX, dY;
    private Duck duck;
    private CanvasWindow canvas;
    private GrayDuck gDuck;

    
    public DuckManager(){
        this.canvas = canvas;   
    }

    public void generateDucks(){
        dX = canvas.getWidth() * 0.02;
        dY = canvas.getHeight() * 0.02;

        for (int i = 0; i < duckList.size(); i++){
            duck = new Duck();
            duck.setPosition(dX, dY);
        }
    }

    // Checks the collision based off of what the gray duck runs into and initiates a deletion method
    // Reminder: make another conditional that makes sure that the collision does not delete anything other than ducks - needs image
    public void checkCollision(CanvasWindow canvas, Duck duck, GrayDuck pDuck){
        if(canvas.getElementAt(duck.getX(), duck.getY()) != null){
            GraphicsObject object = canvas.getElementAt(duck.getX(), duck.getY());
            canvas.remove(object);
            duckList.remove(object);
        }
        if(canvas.getElementAt(duck.getX2(), duck.getY()) != null){
            GraphicsObject object = canvas.getElementAt(duck.getX2(), duck.getY());
            canvas.remove(object);
            duckList.remove(object);
        }
        if(canvas.getElementAt(duck.getX(), duck.getY2()) != null){
            GraphicsObject object = canvas.getElementAt(duck.getX(), duck.getY2());
            canvas.remove(object);
            duckList.remove(object);
        }
        if(canvas.getElementAt(duck.getX2(), duck.getY2()) != null){
            GraphicsObject object = canvas.getElementAt(duck.getX2(), duck.getY2());
            canvas.remove(object);
            duckList.remove(object);
        }



    }


    // Randomizes the values of X and Y coordinates
    public int randomize(){
        return 0;
    }

    public ArrayList<Duck> getDuckList(){
        return duckList;
    }
    

}
