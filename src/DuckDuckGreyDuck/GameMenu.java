// package DuckDuckGreyDuck;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// import edu.macalester.graphics.CanvasWindow;
// import edu.macalester.graphics.ui.Button;
// public class GameMenu {

//     private static final double MAPS = 3;
//     private Button menuButton;
//     private ArrayList<Button> mapButtons = new ArrayList<>();
//     private ArrayList<String> mapList;
//     private Map<Button, String> buttonsDic = new HashMap<>();
    
//     public GameMenu(CanvasWindow canvas){
        
//         this.mapList = createMapList();
//         this.mapButtons = createButtonList();
//         placeButtons(canvas);
//         this.buttonsDic = createButtonDic();
//         handleClick(canvas);
        

//     }

//     public Button createGameMenuButton(CanvasWindow canvas){
//         menuButton = new Button("Maps Menu");
//         menuButton.setPosition(0, 0);
//         return menuButton;
//     }

//     // public CanvasWindow openMapMenu(){
//     //     return 
//     // }
//     public Map<Button, String> createButtonDic(){
//         for(int i = 0; i < MAPS; i++){
//             buttonsDic.put(createButtonList().get(i), createMapList().get(i));
//         }
//         return buttonsDic;
//     }

//     public ArrayList<String> createMapList(){
//         return this.mapList = new ArrayList<>(Arrays.asList("The Mill District", "Loring Park", "The Warehouse District"));
//     }

//     public ArrayList<Button> createButtonList(){
//         for (String title : mapList) {
//             Button button = new Button(title);
//             mapButtons.add(button);
//         }
//         return mapButtons;
//     }

//     public void placeButtons(CanvasWindow canvas){
//         double b = 0;
//         for (Button button : mapButtons) {
//             button.setCenter(canvas.getCenter().getX(), canvas.getCenter().getY()+b);
//             canvas.add(button);
//             b = b + button.getHeight();
//         }
//         canvas.draw();
//     }

//     public void handleClick(CanvasWindow canvas){
//         for (Button button : mapButtons) {
//             button.onClick(() -> changeMap(mapList.get(mapButtons.indexOf(button))));
//         }
            
//         }



//     public void changeMap(String string){
//         System.out.println("heading to " + string + "!");
//         if(string == mapList.get(0)){
            
//         }
//     }
// }
