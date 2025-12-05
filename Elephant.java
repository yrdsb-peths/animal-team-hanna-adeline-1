import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @Adeline & Hanna
 * @version December 2025
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("Elephant Sound.mp3");
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    GreenfootImage [] idleRight = new GreenfootImage[8];
    /**
     * Constructor - The code that gets run one time when object is created
     */
    // Direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /*
     * This is the constructor for the Elephant class.
     * Pre condition: A new Elephant object is created.
     * Post condition: A new elephant appears. 
     */
    public Elephant()
    {
        for(int i = 0; i<idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i<idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
        // Initial elephant image
        setImage(idleRight[0]);
    }
    
    /*
     * This methods animates the elephant's trunk.
     * Pre condition: Space key was pressed to start game 
     * and sprites for the animation exist.
     * Post condition: Elephant's trunk moves every 150 ms.
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    /*
     * This method changes the elephant's direction and gets it to move 4 steps.
     * Pre condition: User presses an arrow key.
     * Post condition: Elephant moves 4 steps in direction of arrow key pressed.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
        }
        
        //Remove apple if elephant eats it
        eat();
        
        // Animate the elephant
        animateElephant();
    }
    
    /**
     * This method removes the apple once the elephant touches ("eats") it
     * and spawns a new apple.
     * Pre condition: The elephant is touching the apple.
     * Post condition: The apple is removed and a new apple is randomly spawned.
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
