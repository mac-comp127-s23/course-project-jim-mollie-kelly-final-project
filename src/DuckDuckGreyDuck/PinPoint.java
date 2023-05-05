package DuckDuckGreyDuck;
import edu.macalester.graphics.Image;

public class PinPoint extends Image {

    private static final String IMAGE_PATH = "pins/pinpoint.png";
    
    public PinPoint(double x, double y){
        super(x, y, IMAGE_PATH);
    }
}