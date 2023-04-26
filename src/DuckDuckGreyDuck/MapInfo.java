package DuckDuckGreyDuck;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import edu.macalester.graphics.Image;

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


   
    public int locationIndex;
    public DestinationsList millList = new DestinationsList();
    public DestinationsList loringList = new DestinationsList();
    public DestinationsList warehouseList = new DestinationsList();
    public DestinationsList list;


    public MapInfo(String map, int locationIndex){
        this.locationIndex = locationIndex;
        setDestinations();
        setList(map);
    }

    public void setDestinations(){
        for(int i = 0; i < NUM_LOCATIONS; i++){
            millList.addDestination(new Destinations(MILL_BACKGROUNDS[i], MILL_BIRDS[i], MILL_INFO[i]));
            System.out.println(MILL_BACKGROUNDS[i]);
            System.out.println(MILL_BIRDS[i]);
            System.out.println(MILL_INFO[i]);
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
    
    public Image getBackground(){
        System.out.println(locationIndex);
        return getDestinationsList().getDestination(locationIndex).getBackground();
        
    }

    public Image getBird(){
        return getDestinationsList().getDestination(locationIndex).getBird();
    }

    public String getInfo(){
        return getDestinationsList().getDestination(locationIndex).getInfo();
    }
}