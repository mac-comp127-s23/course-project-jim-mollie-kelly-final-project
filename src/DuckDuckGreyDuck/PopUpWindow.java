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