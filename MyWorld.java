import greenfoot.*;

/**
 * The World our hero lives.
 * 
 * @author Hanna & Adeline
 * @version December 2025
 */
public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    
    /**
     * This is the constructor for the MyWorld class.
     * Precondition: New MyWorld object created.
     * Postcondition: New MyWorld object with 600x400 cells of 1x1 pixels,
     * new Elephant (elephant) object created,
     * new Label object (scoreLabel) created, and createApple() method called.
     */
    
    public MyWorld() {
        //Create a new world with 600x400 cells with a cell size of 1x1 pixels
        super(600, 400, 1, false);
        
        // Set background
        GreenfootImage bg = new GreenfootImage("Background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        // Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Creat a Label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    /**
     * This increases score for every apple the elephant eats and
     * increases level for every five apples that the elephant eats.
     * Precondition: For increased score: Elephant eats an apple.
     * For increased level: Number of apples eaten by elephant is a factor of 5.
     * Postcondition: The score increases by 1 for each apple eaten and the
     * level increases by 1 for every 5 apples eaten.
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    
    /**
     * This ends the game and draws 'GameOver'.
     * Precondition: The apple touches the ground, calling this method.
     * Postcondition: The game ends and a Label object (gameOverLabel)
     * saying "Game Over" is created.
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * This creates an apple at random location at the top of the screen.
     * Precondition: Called by method in MyWorld constructor (requiring
     * MyWorld object to be created).
     * Postcondition: New Apple object created at random place at the top
     * of the screen.
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
