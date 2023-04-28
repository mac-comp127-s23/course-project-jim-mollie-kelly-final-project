package DuckDuckGreyDuck;



import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.GraphicsObject;
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

        background.setMaxHeight(750);
        background.setMaxWidth(500);
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
