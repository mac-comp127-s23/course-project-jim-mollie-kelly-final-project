package DuckDuckGreyDuck;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class MapInfo {

    private static final int NUM_LOCATIONS = 5;
    private static final Image[] MILL_BACKGROUNDS = {
        new Image("ducks/Mill District/Armory.png"),        // LOCATION: The Armory        INDEX: 0
        new Image("ducks/Mill District/GoldMedalPark.png"), // LOCATION: Gold Medal Park   INDEX: 1
        new Image("ducks/Mill District/GrainBelt.png"),     // LOCATION: Grain Belt Sign   INDEX: 2
        new Image("ducks/Mill District/Guthrie.png"),       // LOCATION: The Guthrie       INDEX: 3
        new Image("ducks/Mill District/MillMuseum.png"),    // LOCATION: Mill City Museum  INDEX: 4
    };

    private static final Image[] MILL_BIRDS = {
        new Image("ducks/Mill District/ArmoryBird.png"),    
        new Image("ducks/Mill District/GoldMedalParkBird.png"),    
        new Image("ducks/Mill District/GrainBeltSignBird.png"),     
        new Image("ducks/Mill District/GuthrieBird.png"),     
        new Image("ducks/Mill District/MillCityMuseumBird.png"),     
    };

    private static final String[] MILL_INFO = {
        "armory string",
        "gold medal park string",
        "grain belt sign string",
        "guthrie string",
        "mill city museum string",
    };

    private static final Point[] MILL_PINPOINTS = {
        new Point(561, 12),  // Armory : (561, 12)
        new Point(197, 412),  // Gold Medal Park : (197, 412)
        new Point(922, 651),  // Grain Belt Sign : (922, 651)
        new Point(323, 406),  // Guthrie : (323, 406)
        new Point(426, 402),  // Mill City Museum : (426, 402)
    };
    public DestinationsList millList = new DestinationsList();
    public DestinationsList loringList = new DestinationsList();
    public DestinationsList warehouseList = new DestinationsList();
    public DestinationsList list;
    public String map;


    public MapInfo(String map){
        this.map = map;
        setDestinations();
        setList(map);
    }

    public String getMap(){
        return map;
    }

    public void setDestinations(){
        for(int i = 0; i < NUM_LOCATIONS; i++){
            millList.addDestination(new Destinations(MILL_BACKGROUNDS[i], MILL_BIRDS[i], MILL_INFO[i], MILL_PINPOINTS[i]));
        }
    }

    public void setList(String map){
        if(map.equalsIgnoreCase("Mill District")){
            this.list = millList;
        }
        if(map.equalsIgnoreCase("Loring Park")){
            this.list = loringList;
        }
        if(map.equalsIgnoreCase("Warehouse District")){
            this.list = warehouseList;
        }
    }

    public DestinationsList getDestinationsList(){
        return list;
    }
    
    public Image getBackground(int locationIndex){
        return getDestinationsList().getDestination(locationIndex).getBackground();
    }

    public Image getBird(int locationIndex){
        return getDestinationsList().getDestination(locationIndex).getBird();
    }

    public String getInfo(int locationIndex){
        return getDestinationsList().getDestination(locationIndex).getInfo();
    }

    public PinPoint getPin(int locationIndex){
        return getDestinationsList().getDestination(locationIndex).getPin();
    }

    public Point getPinPoint(int locationIndex){
        Point point = new Point(getDestinationsList().getDestination(locationIndex).getPin().getX(), getDestinationsList().getDestination(locationIndex).getPin().getY());
        return point ;
    }

    public double getPinX(int locationIndex){
        return getDestinationsList().getDestination(locationIndex).getPin().getX();
    }

    public double getPinY(int locationIndex){
        return getDestinationsList().getDestination(locationIndex).getPin().getY();
    }

    public int getNumLocations(){
        return NUM_LOCATIONS;
    }

   

}