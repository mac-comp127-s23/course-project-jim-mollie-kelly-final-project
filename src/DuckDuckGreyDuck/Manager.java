package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import java.io.IOException;

public class Manager {
    private GrayDuck duck;
    private CanvasWindow canvas;
    private boolean animating = true;
    private MapInfo mapInfo;
    private int locationIndex;

    
    public Manager(CanvasWindow canvas, GrayDuck duck, MapInfo mapInfo) throws IOException{
        this.canvas = canvas;
        this.duck = duck;
        this.mapInfo = mapInfo;
    }

    /**
     * creates and adds the pin points on the map
     */
    public void createMapPoints(){
        for(int i = 0; i < mapInfo.getNumLocations(); i++){
            canvas.add(mapInfo.getPin(i));
        }
        canvas.draw();
    }

    /**
     * creates the popup window
     */
    public void createPopUp(){
        PopUpWindow popup = new PopUpWindow(mapInfo.getMap(), getPopUpIndex());
    }

    /**
     * Setter - sets the popup index
     */
    public void setPopUpIndex(int locationIndex){
        this.locationIndex = locationIndex;
    }

    /**
     * Getter - gets the popup index
     */
    public int getPopUpIndex(){
        return locationIndex;
    }

    /**
     * Getter - gets the animating boolean value
     */
    public boolean getAnimating(){
        return this.animating;
    }
    
    }
