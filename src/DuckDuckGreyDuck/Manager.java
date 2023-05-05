package DuckDuckGreyDuck;


import edu.macalester.graphics.CanvasWindow;
import java.io.IOException;


public class Manager {
    private GrayDuck duck;
    
    private CanvasWindow canvas;
    private boolean animating = true;
    private MapInfo mapInfo;
    public int locationIndex;

    
    public Manager(CanvasWindow canvas, GrayDuck duck, MapInfo mapInfo) throws IOException{
        this.canvas = canvas;
        this.duck = duck;
        this.mapInfo = mapInfo;
    }

    public void createMapPoints(){
        for(int i = 0; i < mapInfo.getNumLocations(); i++){
            canvas.add(mapInfo.getPin(i));
        }
        canvas.draw();
    }

    public void createPopUp(){
        PopUpWindow popup = new PopUpWindow(mapInfo.getMap(), getPopUpIndex());
    }

    public void setPopUpIndex(int locationIndex){
        this.locationIndex = locationIndex;
    }


  

    public int getPopUpIndex(){
        return locationIndex;
    }
    // public void clickPopUp(GraphicsObject o){
    //     o.onClick(() -> popUp.closeWindow());
    // }




    public boolean getAnimating(){
        return this.animating;
    }

    public void setAnimating(boolean run){
        this.animating = run;
    }

    public void addPins(){
        
    }

   
    
    }

