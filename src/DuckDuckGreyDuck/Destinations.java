package DuckDuckGreyDuck;

import edu.macalester.graphics.Image;
import java.util.ArrayList;

public class Destinations {

    private ArrayList<Destinations> destinationList;
    private Image background;
    private Image bird;
    private String info; 

    
    
    public Destinations(Image background, Image bird, String info){
       
        this.background = background;
        this.bird = bird;
        this.info = info;
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

}
