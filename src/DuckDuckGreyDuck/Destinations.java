package DuckDuckGreyDuck;

import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;


public class Destinations {

    /**
     * Instance variables
     */
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

    /**
     * Setter - sets image background
     */
    public void setBackground(Image Background){
        this.background = background;
        
    }

    /**
     * Getter - gets background
     */
    public Image getBackground(){
        return background;
    }

    /**
     * Setter - sets the bird
     */
    public void setBird(Image bird){
        this.bird = bird;
    }

    /**
     * Getter - gets bird
     */
    public Image getBird(){
        return bird;
    }

    /**
     * Setter - sets the info
     */
    public void setInfo(String info){
        this.info = info;
    }

    /**
     * Getter - gets the info
     */
    public String getInfo(){
        return info;
    }

    /**
     * Getter - gets the pin
     */
    public PinPoint getPin(){
       return pin = new PinPoint(pinPoint.getX(), pinPoint.getY());
    }

}
