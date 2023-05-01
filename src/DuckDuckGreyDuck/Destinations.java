package DuckDuckGreyDuck;

import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;


public class Destinations {


    private Image background;
    private Image bird;
    private String info; 
    private PinPoint pin;
    private Point pinPoint;
    

    
    
    public Destinations(Image background, Image bird, String info, Point pinPoint){
       
        this.background = background;
        this.bird = bird;
        this.info = info;
        this.pinPoint = pinPoint;
        this.pin = getPin();
    }

    

    public void setBackground(Image Background){
        this.background = background;
        
    }
    public Image getBackground(){
        return background;
    }

    public void setBird(Image bird){
        this.bird = bird;
    }
    public Image getBird(){
        return bird;
    }

    public void setInfo(String info){
        this.info = info;
    }
    public String getInfo(){
        return info;
    }

    public void setPin(Point pinPoint){
        
    }
    public PinPoint getPin(){
       return pin = new PinPoint(pinPoint.getX(), pinPoint.getY());
    }

}
