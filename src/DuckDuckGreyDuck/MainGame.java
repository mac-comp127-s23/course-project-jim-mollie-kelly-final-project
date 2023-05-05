package DuckDuckGreyDuck;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;



import java.io.IOException;

public class MainGame {
    
    /**
     * Instance variables
     */
    private CanvasWindow canvas;
    private Button start, quit, test;
    private GraphicsText title;
    private GraphicsText menuTitle;
    private static final int CANVAS_WIDTH = 1000, CANVAS_HEIGHT = 750;
    private PinPoint pin;
    private GrayDuck duck;
    private Image backdrop = new Image(0, 0, "ducks/Mill District.png");
    private List<PinPoint> pinList;
    private Button quitButton;
    private Manager manager;
    private MapInfo mapInfo;

    public MainGame() throws IOException {

        String title = "Duck Duck Grey Duck!!";
        this.canvas = new CanvasWindow(title, 1000, 750);
        
        this.mapInfo = createMapInfo();

        menu(canvas, menuTitle);
        canvas.onClick(e -> System.out.println(e.getPosition()));

        
    }

    public void mainStart(CanvasWindow canvas) throws IOException{
        
        canvas.add(backdrop);
        canvas.draw();

        createDuck();
        run();
        
        manager = new Manager(canvas, duck, mapInfo);
        manager.createMapPoints();
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
                    canvas.removeAll();
                    manager.createPopUp(this);
            }
        }
        // if(manager.getPopUp().getQuit() == true){
        //     try {
        //         mainStart(canvas);
        //     } catch (IOException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        // }
        });
    }

    /**
     * Creates the buttons for quitting and starting the game; the menu screen
     */
    public void menu(CanvasWindow canvas, GraphicsText menuTitle){
        Image egg = new Image(100 , 200, "sus/maxwell-cat.png");


        menuTitle = new GraphicsText();
        menuTitle.setText("Duck, Duck, Gray Duck");
        menuTitle.setFont("Monospaced", FontStyle.BOLD, 75);

        start = new Button("Start");
        quit = new Button("Exit");
        test = new Button("test");
        
        quitOnClick();

        canvas.add(quit, CANVAS_HEIGHT-quit.getHeight(), CANVAS_WIDTH-quit.getWidth());
        canvas.add(egg);
        canvas.add(start);
        canvas.add(menuTitle);
        canvas.add(test); // testing out PopUpWindow

        test.setPosition(200, 250);

        test.onClick(() -> {
            canvas.removeAll();
            new PopUpWindow("Mill District", 2, canvas, this);
        });

        quit.onClick(() -> canvas.closeWindow());
        start.onClick(() -> {
                canvas.removeAll();
                try {
                    mainStart(canvas);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        });
        updateLayout(menuTitle);
        canvas.draw();
    }

    /**
     * Updates the position of the menu GUI
     */
    public void updateLayout(GraphicsText title){
        title.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.25);
        start.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.7);
        quit.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.9);

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

    // // might take out
    // public void pinPt(double x, double y){
    //     PinPoint aPin = new PinPoint(x, y, "pins/point-objects.png");
    //     canvas.add(aPin);
    //     pinList.add(aPin);
    // }

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

