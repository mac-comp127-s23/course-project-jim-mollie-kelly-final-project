package DuckDuckGreyDuck;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;
public class GameMenu {

    private static final double MAPS = 3;
    public Button menuButton;
    public ArrayList<Button> mapButtons = new ArrayList<>();
    public ArrayList<String> mapList;
    public Map<Button, String> buttonsDic = new HashMap<>();
    public boolean animating = true;
    
    public GameMenu(CanvasWindow canvas){
        
        this.mapList = createMapList();
        this.mapButtons = createButtonList();
        placeButtons(canvas);
        this.buttonsDic = createButtonDic();
        handleClick(canvas);
        

    }

    public Button createGameMenuButton(CanvasWindow canvas){
        menuButton = new Button("Maps Menu");
        menuButton.setPosition(0, 0);
        return menuButton;
    }

    // public CanvasWindow openMapMenu(){
    //     return 
    // }
    public Map<Button, String> createButtonDic(){
        for(int i = 0; i < MAPS; i++){
            buttonsDic.put(createButtonList().get(i), createMapList().get(i));
        }
        return buttonsDic;
    }

    public ArrayList<String> createMapList(){
        return this.mapList = new ArrayList<>(Arrays.asList("The Mill District", "Loring Park", "The Warehouse District"));
    }

    public ArrayList<Button> createButtonList(){
        for (String title : mapList) {
            Button button = new Button(title);
            mapButtons.add(button);
        }
        return mapButtons;
    }

    public void placeButtons(CanvasWindow canvas){
        double b = 0;
        for (Button button : mapButtons) {
            button.setCenter(canvas.getCenter().getX(), canvas.getCenter().getY()+b);
            canvas.add(button);
            b = b + button.getHeight();
        }
        canvas.draw();
    }

    public void handleClick(CanvasWindow canvas){
        for (Button button : mapButtons) {
            button.onClick(() -> changeMap(mapList.get(mapButtons.indexOf(button))));
        }

        // canvas.onMouseDown(e -> {
        //         System.out.println(mapList.get(mapButtons.indexOf(canvas.getElementAt(e.getPosition()))));
            // for(int i = 0; i > MAPS; i++){
            //     int j = i;
            //     mapButtons.get(i).onClick(() -> changeMap(mapButtons.get(j), mapList.get(j)));
            // }
        // });
        
            // for (Button button : mapButtons) {
            //     for (String string : mapList) {
            //         button.onClick(() -> changeMap(button, string));
            //     }
            // }
            
        }



    public void changeMap(String string){
        System.out.println("heading to " + string + "!");
        if(string == mapList.get(0)){
            
        }
    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("canvas", 500, 425);
        GameMenu run = new GameMenu(canvas);
    }
}
