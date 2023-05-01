package DuckDuckGreyDuck;



import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.ui.Button;




public class PopUpWindow {
    public Button quitButton;
    public CanvasWindow popUp;
    public String location;
    public int locationIndex;
    
    

    public PopUpWindow(String location, int locationIndex){
        this.location = location;
        this.locationIndex = locationIndex;
        popUp = new CanvasWindow(location, 500, 500);
        createPopUp();
        popUp.draw();
        quitOnClick();
        
        
    }
   
    public void createPopUp(){
        MapInfo mapInfo = new MapInfo(location);
        createBackground(mapInfo.getBackground(locationIndex));
        createBird(mapInfo.getBird(locationIndex));
        createGraphicsText(mapInfo.getInfo(locationIndex));
        createQuitButton();
    }
    public void createBackground(Image background){

        background.setMaxHeight(750);
        background.setMaxWidth(500);
        popUp.add(background, 0, 0);
    }

    public void createBird(Image bird){
        bird.setMaxHeight(200);
        popUp.add(bird, 0, 250);
    }

    public void createGraphicsText(String info){
        GraphicsText text = new GraphicsText(info);
        popUp.add(text, 0, 0);
    }

    public void createQuitButton(){
        this.quitButton = new Button("Return to Map");
        popUp.add(quitButton, 0, 0);
       
    }


    public void quitOnClick(){
        quitButton.onClick(() -> popUp.closeWindow());
    }
}
