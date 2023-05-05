package DuckDuckGreyDuck;



import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;
import java.io.IOException;




public class PopUpWindow {
    private CanvasWindow canvas;
    private String location;
    private int locationIndex;
    private boolean quitClicked;
    private Button quitButton;
    private GraphicsGroup group;
    private Rectangle outline;
    private MainGame mainGame;
    
    

    public PopUpWindow(String location, int locationIndex, CanvasWindow canvas, MainGame mainGame){
        this.location = location;
        this.locationIndex = locationIndex;
        this.mainGame = mainGame;

        outline = new Rectangle(0, 0, canvas.getWidth() * 0.2, canvas.getHeight() * 0.975);
        outline.setCenter(canvas.getWidth() * 0.8935, canvas.getHeight() * 0.5);
        outline.setFillColor(Color.WHITE);

        group = new GraphicsGroup();

        canvas.setBackground(Color.BLACK);
        MapInfo mapInfo = new MapInfo(location);

        GraphicsText birdTalk = new GraphicsText();

        group.add(outline);
        
        birdTalk.setFont(FontStyle.BOLD, 10);
        birdTalk.setCenter(canvas.getWidth() * 0.8935, canvas.getHeight() * 0.5);
        birdTalk.setText("maxwell the cat");
        
        group.add(birdTalk);
        canvas.add(group);


        createBackground(mapInfo.getBackground(locationIndex), canvas);
        createBird(mapInfo.getBird(locationIndex), canvas);
        createGraphicsText(mapInfo.getInfo(locationIndex), canvas);
        createQuitButton(canvas);
        quitOnClick(canvas);
        canvas.draw();
        
        
    }

    /**
     * Creates the background and sets it up
     */
    public void createBackground(Image background, CanvasWindow canvas){
        background.setMaxHeight(canvas.getHeight());
        background.setMaxWidth(canvas.getWidth());
        background.setScale(canvas.getWidth() * 0.0015, canvas.getHeight() * 0.00175); // Image are not the same size so it will not always fit the canvas perfectly
        canvas.add(background, 0, 0);
    }

    /**
     * Creates the bird and readjusts the scale of the bird
     */
    public void createBird(Image bird, CanvasWindow canvas){
        bird.setMaxHeight(200);
        bird.setScale(3.5, 5);
        canvas.add(bird, canvas.getWidth() - canvas.getWidth() - 50, canvas.getHeight() * 0.6);
    }

    /**
     * Creates the text on the side of the popup
     */
    public void createGraphicsText(String info, CanvasWindow canvas){
        GraphicsText text = new GraphicsText(info);
        canvas.add(text, 0, 0);
    }

    /**
     * Creates the quit button and allows for the user to go back to the main map if this is pressed
     */
    public void createQuitButton(CanvasWindow canvas){
        quitClicked = false;
        this.quitButton = new Button("Return to Map");
        canvas.add(quitButton, 0, 0);

        quitButton.onClick(() -> {
            quitClicked = true;
            try {
                mainGame.mainStart(canvas);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
       
    }

    /**
     * Removes everything on the canvas
     */
    public void quitOnClick(CanvasWindow canvas){
        quitButton.onClick(() -> {
            canvas.removeAll();
            });
    }
}
