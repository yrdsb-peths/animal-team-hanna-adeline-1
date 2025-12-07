import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Hanna, Adeline 
 * @version December 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 65);
    /**
     * Constructor for objects of class TitleScreen.
     * Precondition: Object of class TitleScreen is created.
     * Postcondition: New object of TitleScreen with 600x400 cells that are 1x1
     * pixels is created.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Add the titleLabel to the screen
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        
        //Set the background of the TitleScreen
        GreenfootImage bg = new GreenfootImage("TitleScreen.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
    
    /**
     * This is the main world act loop that begins the game.
     * Precondition: User presses "space" key
     * Postcondition: Game begins
     */
    public void act()
    {
        //Start the game if the user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
