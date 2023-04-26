package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

public class PopUpWindow extends CanvasWindow{

    /**
     * Instance variables
     */
    private static final String US_BANK = "", MILL_DISTRICT_INFO ="";
    private Image locationDuck, background;
    private static final int winWidth = 500, winHeight = 500;
    private CanvasWindow popUp;
    private String location;



    public PopUpWindow(String location){
        super(location, winWidth, winHeight);
        this.location = location;
        this.locationDuck = locationDuck;
        // this.text = text;
        this.background = background;
        
    }

    /**
     * Creates the background
     */
    public void createBackground(){
        popUp.add(background, 0, 0);
        popUp.draw();
    }

    /**
     * Adds text to the background
     */
    public void addText(){
        popUp.add(background, 0, 0);
    }

    /**
     * 
     */
    public void setLocation(){
        if (location == "US Bank"){
            createGraphicsText(MILL_DISTRICT_INFO);
        }
    }

    /**
     * Creates graphics text
     */
    public GraphicsText createGraphicsText(String string){
        GraphicsText text = new GraphicsText(string);
        return text;
    }
}
import java.io.FileReader;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.ui.Button;

public class PopUpWindow {
    public Button quitButton;
    public CanvasWindow popUp;
    

    

    public PopUpWindow(String location, int locationIndex){
        popUp = new CanvasWindow(location, 500, 500);
        MapInfo mapInfo = new MapInfo(location, locationIndex);
        createBackground(mapInfo.getBackground());
        createBird(mapInfo.getBird());
        createGraphicsText(mapInfo.getInfo());
        createQuitButton();
        quitOnClick();
    }

    public void createBackground(Image background){
        addToCanvas(background, 0, 0);
    }

    public void createBird(Image bird){
        bird.setMaxHeight(200);
        addToCanvas(bird, 0, 250);
    }

    public void createGraphicsText(String info){
        GraphicsText text = new GraphicsText(info);
        addToCanvas(text, 0, 0);
    }

    public void createQuitButton(){
        this.quitButton = new Button("Return to Map");
        addToCanvas(quitButton, 0, 0);
    }

    public void addToCanvas(GraphicsObject obj, double x, double y){
        popUp.add(obj, x, y);
        popUp.draw();
    }

    public void quitOnClick(){
        quitButton.onClick(() -> popUp.closeWindow());
    }
}
