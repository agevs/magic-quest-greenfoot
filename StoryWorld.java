import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoryWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryWorld extends World
{

    /**
     * Constructor for objects of class StoryWorld.
     * 
     */
    public StoryWorld()
    {    
      super(900, 600, 1);

        showText("KAI DEBE RECUPERAR LAS GEMAS MÁGICAS", 450, 180);

        showText("Usa A y D para moverte", 450, 260);

        showText("Presiona ESPACIO para saltar", 450, 320);

        showText("Evita enemigos y recolecta monedas", 450, 380);

        showText("Presiona ENTER para continuar", 450, 500);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new GameWorld());
        }
    }
} 