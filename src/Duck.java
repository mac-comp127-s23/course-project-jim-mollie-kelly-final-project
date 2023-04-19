import edu.macalester.graphics.Rectangle;



public class Duck extends Rectangle{

    // Instance variables
    private static int Xcord, Ycord;
    private static double width, height;

    // Constructor - Object duck that will be seeked by the user (gray duck)
    public Duck() {
        super(Xcord, Ycord, width, height);
    }

    //Getters for X and Y of the duck
    public double getX2(){
        return this.getX() + width;
    }

    public double getY2(){
        return this.getY() + height;
    }



    
}
