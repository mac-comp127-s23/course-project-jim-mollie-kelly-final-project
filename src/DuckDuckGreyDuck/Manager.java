package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import java.io.IOException;

public class Manager {
    private GrayDuck duck;
    private PinPoint pin;
    private CanvasWindow canvas;
    private boolean animating = true;
    private MapInfo mapInfo;
    private PopUpWindow popUp;
    private int locationIndex;

    
    public Manager(CanvasWindow canvas, GrayDuck duck, MapInfo mapInfo) throws IOException{
        this.canvas = canvas;
        this.duck = duck;
        this.mapInfo = mapInfo;
    }

    /**
     * Creates the pin points on the map
     */
    public void createMapPoints(){
        for(int i = 0; i < mapInfo.getNumLocations(); i++){
            canvas.add(mapInfo.getPin(i));
        }
        canvas.draw();
    }

    /**
     * Creates the popup window
     */
    public void createPopUp(MainGame mainGame){
        PopUpWindow popUp = new PopUpWindow(mapInfo.getMap(), getPopUpIndex(), canvas, mainGame);
    }

    /**
     * Getter - gets popup window
     */
    public PopUpWindow getPopUp(){
        return popUp;
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
     * Getter - gets the boolean from animating
     */
    public boolean getAnimating(){
        return this.animating;
    }

    /**
     * Setter - sets the boolean of animating
     */
    public void setAnimating(boolean run){
        this.animating = run;
    }

    /**
     * When the duck is close to the pin points, the pin point lights up 
     * 
     */
    // public void imageIntersect(PinPoint pin, Image image2, CanvasWindow canvas, GrayDuck duck){
    //     Rectangle duckBounds = new Rectangle((int) duck.getX(), (int) duck.getY(), (int) image2.getWidth(), (int) image2.getHeight());

    //     canvas.animate(event -> {
    //         System.out.println(duck.getX());
    //         duckBounds.setLocation((int) duck.getX(), (int) duck.getY()); //
    //     });

    //     for(int i = 0; i < pins.size(); i++){
    //         rects.add(new Rectangle((int) pins.get(i).getX(), (int) pins.get(i).getY(), (int) pins.get(i).getWidth(), (int) pins.get(i).getHeight()));
    //     }

    //     for(int i = 0; i < rects.size(); i++){
    //         if(duckBounds.intersects(rects.get(i))){
    //             System.out.println("hit");
                
    //         }
    //     }

    // }

    // public void spawnPoints(PinPoint pin){
    //     PinPoint armory = new PinPoint(561, 12, "pins/point-objects.png", window); // Armory : (561, 12)
    //     PinPoint goldMedal = new PinPoint(197, 412, "pins/point-objects.png", window); // Gold Medal Park : (197, 412)
    //     PinPoint grainBelt = new PinPoint(922, 651, "pins/point-objects.png", window); // Grain Belt Sign : (922, 651)
    //     PinPoint guth = new PinPoint(323, 406, "pins/point-objects.png", window); // Guthrie : (323, 406)
    //     PinPoint mill = new PinPoint(426, 402, "pins/point-objects.png", window); // Mill City Museum : (426, 402)
    //     pins.add(armory);
    //     pins.add(goldMedal);
    //     pins.add(grainBelt);
    //     pins.add(guth);
    //     pins.add(mill);
    // }
    
    }

