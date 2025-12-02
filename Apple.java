import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for out elephant.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    int speed = 1;
    
    public Apple()
    {
        GreenfootImage ap = getImage();
        ap.scale(ap.getWidth()/5, ap.getHeight()/5);
        setImage(ap);
    }
    
    public void act()
    {
        //Apple falls downwards.
        int x = getX();
        int y = getY();
        setLocation(x, y + 1);
        
        //Remove apple and draw the game over when apple gets to the bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
