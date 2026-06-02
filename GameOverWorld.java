import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{
    public GameOverWorld()
    {
        super(1024, 576, 1);

        showText("GAME OVER", 512, 200);

        showText("Presiona R para reintentar", 512, 280);

        showText("Presiona A para ver anuncio y recuperar una vida", 512, 340);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("r"))
        {
            Greenfoot.setWorld(new GameWorld());
        }

        if(Greenfoot.isKeyDown("a"))
        {
            Greenfoot.setWorld(new AdWorld());
        }
    }
}
