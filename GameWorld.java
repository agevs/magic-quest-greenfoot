import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int vidas = 3;
    private int monedas = 0;
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

        
        // ICONOS HUD
        addObject(new HeartIcon(), 40, 20);
        showText("x " + vidas, 80, 20);
        addObject(new CoinIcon(), 170, 20);
        showText("x " + monedas, 210, 20);
        // KAI
        addObject(new Player(), 120, 430);
        addObject(new Platform(50, 40), 120, 500);

       
        // PLATAFORMAS
        addObject(new Platform(180, 40), 320, 500);
        addObject(new Platform(180, 40), 500, 450);
        addObject(new Platform(180, 40), 692, 410);
        addObject(new Platform(180, 40), 500, 290);
        addObject(new Platform(180, 40), 800, 100);
        addObject(new Platform(180, 40), 300, 200);
        addObject(new Platform(180, 40), 600, 150);
        
        addObject(new Coin(), 320, 430);

        addObject(new Coin(), 500, 380);

        addObject(new Coin(), 650, 340);
    }
     //Vidas
    public void perderVida()
    {
        vidas--;

        showText("x " + vidas, 80, 20);
    }

    // Monedas
    public void sumarMoneda()
    {
        monedas++;

        showText("x " + monedas, 210, 20);
    }

}


