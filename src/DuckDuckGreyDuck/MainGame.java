package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.io.IOException;

public class MainGame {
    
    /**
     * Instance variables
     */
    private static final String TITLE = "Duck Duck Grey Duck!";
    private CanvasWindow canvas;
    private Button start, quit;
    private GraphicsText title, menuTitle;
    private static final int CANVAS_WIDTH = 1000, CANVAS_HEIGHT = 750;
    private GrayDuck duck;
    private Image backdrop;
    private Manager manager;
    private MapInfo mapInfo;
    

    public MainGame() throws IOException {
        this.backdrop = new Image(0, 0, "ducks/Mill District.png");
        this.canvas = new CanvasWindow(TITLE, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.add(backdrop);
       
        this.mapInfo = createMapInfo();
        this.duck = createDuck();
        this.manager = new Manager(canvas, duck, mapInfo);
        manager.createMapPoints();
        menu(canvas, menuTitle);
        run();
        canvas.draw();
        
    }

    /**
     * creates the mapInfo variable
     */
    public MapInfo createMapInfo(){
        this.mapInfo = new MapInfo("Mill District");
        return mapInfo;
    }

    /**
     * initializes and creates the duck, while adding it to canvas and setting its position
     */
    public GrayDuck createDuck(){
        duck = new GrayDuck(canvas.getCenter().getX(), canvas.getCenter().getY(), "ducks/grayDuck_1R.png", canvas);
        duck.addToCanvas();
        duck.moveDuck();
        return duck;
    }

    /**
     * checks for collisions between the duck and the pin points
     */
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
    }
    
    /**
     * sets up the menu screen of the game
     */
    public void menu(CanvasWindow canvas, GraphicsText menuTitle){
      
        Image egg = new Image(300 , 270, "pixel-maxwell-cat.png");
        Image skyline = new Image(0, 0, "skyline.png");
        skyline.setScale(2.75);
        menuTitle = new GraphicsText(TITLE, 0, 0);

        menuTitle.setFont("Monospaced", FontStyle.BOLD, 75);
        menuTitle.setFillColor(Color.blue);

        start = new Button("Start");
        quit = new Button("Exit");
        title = new GraphicsText(TITLE);
    
        createQuitButton();
        quitOnClick();
        canvas.add(skyline);
        canvas.add(quit, CANVAS_HEIGHT-quit.getHeight(), CANVAS_WIDTH-quit.getWidth());
        
        canvas.add(egg);
        canvas.add(start);
        canvas.add(menuTitle);
        
        quit.onClick(() -> canvas.closeWindow());
        startGame(start);
        updateLayout(menuTitle);
    }

    /**
     * when the button is clicked, the main game runs
     */
    public void startGame(Button start){
        start.onClick(() -> {
            canvas.removeAll();
            try {
                mainStart(canvas);
                canvas.draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
    });
    }

    /**
     * runs the main game when the start button is clicked
     */
    public void mainStart(CanvasWindow canvas) throws IOException{

        canvas.add(backdrop);
   
        createDuck();
        run();
   
        manager = new Manager(canvas, duck, mapInfo);
        manager.createMapPoints();
        }
   

    /**
     * checks for collisions and creates the popup window when there is one
     */
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
     * Updates the position of the menu GUI
     */
    public void updateLayout(GraphicsText title){
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

    /**
     * creates the quit button
     */
    public void createQuitButton(){
        quit = new Button("Quit");
    }

    /**
     * when quit button is clicked, the window closes
     */
    public void quitOnClick(){
        quit.onClick(() -> canvas.closeWindow());
    }

    public static void main(String[] args) throws IOException {
        new MainGame();

    }
}

