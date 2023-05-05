package DuckDuckGreyDuck;



import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.ui.Button;




public class PopUpWindow {
    public static final int POPUP_WIDTH = 500;
    public static final int POPUP_HEIGHT = 500;
    
    public Button quitButton;
    public CanvasWindow popUp;
    public String location;
    public int locationIndex;
    public boolean quitClicked;
<<<<<<< Updated upstream
    public Image bird;
    public Image background;
=======

>>>>>>> Stashed changes
    
    

    public PopUpWindow(String location, int locationIndex){
        this.location = location;
        this.locationIndex = locationIndex;
        createPopUp();
        quitOnClick();
        popUp.draw();
        
        
    }
   
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
    public void createBackground(){
       
        popUp.add(background, 0, 0);
    }

    public void createBird(){
        bird.setMaxHeight(200);
        popUp.add(bird, 0, background.getHeight()-bird.getHeight());
    }

    public void createGraphicsText(String info){
        GraphicsText text = new GraphicsText(info);
<<<<<<< Updated upstream
        popUp.add(text, 0, background.getHeight()+20);
        text.setWrappingWidth(background.getWidth());
        text.setFont(FontStyle.ITALIC, 20);
=======
        text.setWrappingWidth(locationIndex);
        popUp.add(text, 0, 0);
>>>>>>> Stashed changes
    }


    public void createQuitButton(){
        this.quitButton = new Button("Return to Map");
        popUp.add(quitButton, 0, 0);
    }

    public void setQuit(boolean quit){
        this.quitClicked = quit;
    }

    public boolean getQuit(){
        return quitClicked;
    }


    public void quitOnClick(){
        quitButton.onClick(() -> {
            popUp.closeWindow();
            setQuit(true);
            popUp.removeAll();
            });
    }
}
