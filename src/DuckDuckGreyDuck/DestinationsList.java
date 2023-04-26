package DuckDuckGreyDuck;

import java.util.ArrayList;

public class DestinationsList {

    private ArrayList<Destinations> destinationList;
    public DestinationsList(){
        destinationList = new ArrayList<Destinations>();
    }
    
    public void addDestination (Destinations destination){
        destinationList.add(destination);
    }

    public Destinations getDestination(int index){
        return destinationList.get(index);
    }
}
