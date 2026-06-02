import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Adworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdWorld extends World
{
    private int timer = 0;

    public AdWorld()
    {
        super(1024, 576, 1);

        showText("ANUNCIO CARGANDO...", 512, 250);

        showText("Recuperando 1 vida", 512, 320);
    }

    public void act()
    {
        timer++;

        if(timer > 180)
        {
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
