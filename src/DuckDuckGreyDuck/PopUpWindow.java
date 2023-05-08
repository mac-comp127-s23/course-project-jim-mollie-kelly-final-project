package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.ui.Button;

public class PopUpWindow {

    /**
     * Instance variables
     */
    private Button quitButton;
    private CanvasWindow popUp;
    private String location;
    private int locationIndex;
    private Image bird;
    private Image background;
    
    

    public PopUpWindow(String location, int locationIndex){
        this.location = location;
        this.locationIndex = locationIndex;
        createPopUp();
        quitOnClick();
        popUp.draw();
    }
   
    /**
     * creates the popup window
     */
    public void createPopUp(){
        MapInfo mapInfo = new MapInfo(location);
        this.background = mapInfo.getBackground(locationIndex);
        background.setMaxHeight(500);
        popUp = new CanvasWindow(location, (int)background.getWidth(), (int)background.getHeight()+200);
        createBackground();
        this.bird = mapInfo.getBird(locationIndex);
        createBird();
        createGraphicsText(mapInfo.getInfo(locationIndex));
        createQuitButton();
    }

    /**
     * Creates and adds the background image of popup window
     */
    public void createBackground(){
       
        popUp.add(background, 0, 0);
    }

    /**
     * Adds the bird image in the popup window
     */
    public void createBird(){
        bird.setMaxHeight(200);
        popUp.add(bird, 0, background.getHeight()-bird.getHeight());
    }

    /**
     * creates the graphics text that is underneath the popup
     */
    public void createGraphicsText(String info){
        GraphicsText text = new GraphicsText(info);
        popUp.add(text, 0, background.getHeight()+20);
        text.setWrappingWidth(background.getWidth());
        text.setFont(FontStyle.ITALIC, 20);
    }

    /**
     * creates the quit button and adds it to popup
     */
    public void createQuitButton(){
        this.quitButton = new Button("Return to Map");
        popUp.add(quitButton, 0, 0);
    }

    /**
     * closes and removes graphics from popup when quit button is clicked
     */
    public void quitOnClick(){
        quitButton.onClick(() -> {
            popUp.closeWindow();
            popUp.removeAll();
            });
    }
}
