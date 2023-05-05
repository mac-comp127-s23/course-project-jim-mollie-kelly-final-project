package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

import java.util.ArrayList;



import java.io.IOException;

public class MainGame {
    
    /**
     * Instance variables
     */
    private CanvasWindow canvas;
    private Button start, quit;
    private GraphicsText title;
    private static final int CANVAS_WIDTH = 1000, CANVAS_HEIGHT = 750;

    private GrayDuck duck;
    private Image backdrop;
    private Manager manager;
    private MapInfo mapInfo;

    public MainGame() throws IOException {

        String title = "Duck Duck Grey Duck!!";
        this.backdrop = new Image(0, 0, "ducks/Mill District.png");
        this.canvas = new CanvasWindow(title, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.add(backdrop);
        
        this.mapInfo = createMapInfo();
        this.duck = createDuck();
        this.manager = new Manager(canvas, duck, mapInfo);
        manager.createMapPoints();
       
        run();
        canvas.onClick(e -> System.out.println(e.getPosition()));
        
    }

    public MapInfo createMapInfo(){
        this.mapInfo = new MapInfo("Mill District");
        return mapInfo;
    }

    public GrayDuck createDuck(){
        duck = new GrayDuck(canvas.getCenter().getX(), canvas.getCenter().getY(), "ducks/grayDuck_1R.png", canvas);
        duck.addToCanvas();
        canvas.draw();
        duck.moveDuck();
        return duck;
    }

    public boolean checkCollison(ArrayList<Point> duckBoundList){
        for(int i = 0; i < duckBoundList.size(); i++){
            for (int j = 0; j < mapInfo.getNumLocations(); j++){
                GraphicsObject hit = canvas.getElementAt(duckBoundList.get(i));
                    if(hit.equals(mapInfo.getPin(j))){
                        manager.setPopUpIndex(j);
                        return true;
                    }
                }
        }
        return false;  
        //return manager.getPopUpIndex(); 
    }
        
    



    public void run(){
        canvas.onKeyDown((dt) -> {
            if(manager.getAnimating()){
                if(checkCollison(duck.duckBounds())){
                    duck.resetDuck();
                    canvas.draw();
                    manager.createPopUp();
            }
        }
        });
    }

    /**
     * Creates the buttons for quitting and starting the game; the menu screen
     */
    public void menu(CanvasWindow canvas){
        title = new GraphicsText();
        start = new Button("Start");
        quit = new Button("Exit");

        title.setFont(FontStyle.BOLD, (CANVAS_HEIGHT * CANVAS_WIDTH) * 0.5);
        title.setText("Duck, Duck, Gray Duck");
        createQuitButton();
        quitOnClick();
        canvas.add(quit, CANVAS_HEIGHT-quit.getHeight(), CANVAS_WIDTH-quit.getWidth());
        updateLayout();

        canvas.draw();


    }

    /**
     * Updates the position of the menu GUI
     */
    public void updateLayout(){
        title.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.25);
        start.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.7);
        quit.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.9);

        addCanvas();
    }

    /**
     * Adding things into the canvas
     */
    public void addCanvas(){
        canvas.add(start);
        canvas.add(title);
        canvas.add(quit);
    }

    public void buttonWin(Button start){
        start.onClick(null);
    }

  

    public void createQuitButton(){
        quit = new Button("Return to Map");
       // canvas.add(quit, CANVAS_HEIGHT-quit.getHeight(), CANVAS_WIDTH-quit.getWidth());
        //return quit;
    }

    public void quitOnClick(){
        quit.onClick(() -> canvas.closeWindow());
    }



    public static void main(String[] args) throws IOException {
        new MainGame();

    }
}

