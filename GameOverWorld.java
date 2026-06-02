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

    GreenfootImage bg =
        new GreenfootImage("gameoverBackground.png");

    getBackground().drawImage(bg, 0, 0);

    showText("GAME OVER", 512, 200);

    showText("Pyresiona M para volver al menú principal", 512, 280);

    showText("Presiona A para ver anuncio y continuar", 512, 340);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("m"))
        {
            Greenfoot.setWorld(new MyWorld());
        }

        if(Greenfoot.isKeyDown("a"))
        {
            Greenfoot.setWorld(new AdWorld());
        }
    }
}
