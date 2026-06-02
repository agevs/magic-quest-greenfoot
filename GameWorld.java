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
    private GreenfootSound musicaGameplay;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        super(1024, 576, 1);
        
        musicaGameplay = new GreenfootSound("gameplay_theme.mp3");
        musicaGameplay.setVolume(20);
        musicaGameplay.playLoop();

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
        addObject(new Platform(100, 40), 120, 500);

       
        // PLATAFORMAS
        addObject(new Platform(180, 40), 320, 500);
        addObject(new Platform(180, 40), 500, 450);
        addObject(new Platform(180, 40), 692, 410);
        addObject(new Platform(180, 40), 500, 290);
        addObject(new Goal(), 950, 50);
        addObject(new Platform(300, 40), 900, 100);
        addObject(new Platform(180, 40), 300, 200);
        addObject(new Platform(180, 40), 600, 150);
        
        addObject(new Coin(), 320, 430);
        addObject(new Coin(), 500, 380);
        addObject(new Coin(), 650, 340);
        
        // Enemigo
        addObject(new Enemy(), 300, 150);
    }
     //Vidas
    public void perderVida()
    {
        vidas--;

        showText("x " + vidas, 80, 20);

        if(vidas <= 0)
        {
            Greenfoot.playSound("gameover.mp3");
            
            Greenfoot.setWorld(new GameOverWorld());

            
        }
    }

    // Monedas
    public void sumarMoneda()
    {
        monedas++;

        showText("x " + monedas, 210, 20);
    }

}


