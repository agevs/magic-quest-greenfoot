import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        super(1000, 600, 1);

        GreenfootImage bg = new GreenfootImage("gameBackground.png");

        int x = (getWidth() - bg.getWidth()) / 2;

        getBackground().drawImage(bg, x, 0);

        // Agregar jugador
        addObject(new Player(), 150, 520);
    }
}
