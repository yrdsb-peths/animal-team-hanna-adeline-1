import greenfoot.*;

/**
 * The World our hero lives.
 * 
 * @author Hanna & Adeline
 * @version November 2025
 */
public class MyWorld extends World {
    public MyWorld() {
        //Create a new world with 600x400 cells with a cell size of x1 pixels
        super(600, 400, 1, false);
        
        // Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        createApple();
    }
    
    /**
     * Create an apple at random locatin at the top of the screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
