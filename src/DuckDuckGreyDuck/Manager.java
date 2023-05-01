package DuckDuckGreyDuck;

import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.MacSpi;
import javax.imageio.ImageIO;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

import java.io.IOException;
import java.security.Principal;
import java.awt.Rectangle;


public class Manager {
    private GrayDuck duck;
    private PinPoint pin;
    private CanvasWindow canvas;
    private boolean animating = true;
    private ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
    private ArrayList<PinPoint> pins = new ArrayList<PinPoint>();
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

