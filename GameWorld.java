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
        super(1024, 576, 1);

        // Fondo
        GreenfootImage bg = new GreenfootImage("gameBackground.png");

        getBackground().drawImage(bg, 0, 0);

        // JUGADOR
        addObject(new Player(), 70, 360);

        // =====================================
        // PLATAFORMAS
        // =====================================

        // Plataforma izquierda
        addObject(new Platform(180, 40), 180, 470);

        // Plataforma centro
        addObject(new Platform(180, 40), 380, 400);

        // Plataforma derecha
        addObject(new Platform(180, 40), 580, 340);

        // Plataforma final
        addObject(new Platform(180, 40), 780, 280);
    }
}


