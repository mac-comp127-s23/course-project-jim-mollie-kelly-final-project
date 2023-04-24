import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;
import edu.macalester.graphics.Image;


public class MainGame {
    
    // Instance variables
    private CanvasWindow canvas;
    private Button start, quit;
    private GraphicsText title;
    private static final int CANVAS_WIDTH = 1000, CANVAS_HEIGHT = 750;
    private PinPoint pin;

    public MainGame() {
        // canvas = new CanvasWindow("Duck, Duck, Gray Duck", CANVAS_WIDTH, CANVAS_HEIGHT);

        // canvas.setBackground(Color.BLACK);

        // menu(canvas);
        
    }

    public void menu(CanvasWindow canvas){
        title = new GraphicsText();
        start = new Button("Start");
        quit = new Button("Exit");

        title.setFont(FontStyle.BOLD, (CANVAS_HEIGHT * CANVAS_WIDTH) * 0.5);
        title.setText("Duck, Duck, Gray Duck");

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

    public void addCanvas(){
        canvas.add(start);
        canvas.add(title);
        canvas.add(quit);
    }

    public void buttonWin(Button start){
        start.onClick(null);
    }

    public static void main(String[] args) {
        new MainGame();
        String title = "Duck Duck Grey Duck!!";
        CanvasWindow canvas = new CanvasWindow(title, 1000, 750);
        Image backdrop = new Image(0, 0, "ducks/Mill District.png");
        canvas.add(backdrop);
        new PinPoint(200, 300, "pins/point-objects.png", canvas);
        new GrayDuck(canvas.getCenter().getX(), canvas.getCenter().getY(), "ducks/grayDuck_1R.png", canvas);
        canvas.draw();
    }