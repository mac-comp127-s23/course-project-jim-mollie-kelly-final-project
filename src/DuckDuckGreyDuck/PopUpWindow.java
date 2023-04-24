package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

public class PopUpWindow {

    private static final String US_BANK = "";
    public Image locationDuck;
    public Image background;

    public CanvasWindow popUp;
    public String location;

    

    public PopUpWindow(String location){
        this.location = location;
        
        this.locationDuck = locationDuck;
        this.text = text;
        this.background = background;
        popUp = new CanvasWindow(location, 500, 500);
    }
    public void createBackground(){
        popUp.add(background, 0, 0);
        popUp.draw();
    }

    public void addText(){
        popUp.add(background, 0, 0);
    }

    public void setLocation(){
        if (location == "US Bank"){
            createGraphicsText(MILL_DISTRICT_INFO);
        }
    }
    public GraphicsText createGraphicsText(String string){
        GraphicsText text = new GraphicsText(string);
        return text;
    }
}
