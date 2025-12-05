import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for out elephant.
 * 
 * @author Hanna & Adeline
 * @version December 2025
 */
public class Apple extends Actor
{
    int speed = 1;
    
    /*
     * This is the constructor for the Apple class.
     * Pre condition: New object in Apple class created.
     * Post condition: New apple (object) created.
     */
    public Apple()
    {
        GreenfootImage ap = getImage();
        ap.scale(ap.getWidth()/5, ap.getHeight()/5);
        setImage(ap);
    }
    
    /*
     * This method gets the apple to fall and disappear when it
     * touches the bottom.
     * Pre condition: Apple is in the world.
     * Post condition: Apple that touches the bottom is removed and a new apple begins to fall.
     */
    public void act()
    {
        //Apple falls downwards.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y + 1);
        
        //Remove apple and draw the game over when apple gets to the bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    /*
     * This method increases the apple's falling speed
     * as the number of apples eaten increases.
     * Pre condition: Number of apples eaten is a multiple of 5.
     * Post condition: Apple's falling speed increases by 1.
     */
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
