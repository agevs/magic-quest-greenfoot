import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int timer = 0;
    private boolean mostrarTexto = true;
    private GreenfootSound musicaMenu;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
     public MyWorld()
    {    
        super(1000, 600, 1);
        
        musicaMenu = new GreenfootSound("menu_theme_1.mp3");
        musicaMenu.setVolume(30);
        musicaMenu.play();
        
        actualizarPantalla();
    }

    public void act()
    {
        timer++;

        // Texto titilando
        if(timer % 40 == 0)
        {
            mostrarTexto = !mostrarTexto;
            actualizarPantalla();
        }

        // Cambiar a StoryWorld
        if(Greenfoot.isKeyDown("enter"))
        {
            musicaMenu.stop();
            Greenfoot.setWorld(new StoryWorld());
        }
    }
    public void actualizarPantalla()
    {
        GreenfootImage fondo = getBackground();

        // Fondo del menú
        GreenfootImage bg = new GreenfootImage("menuBackground.png");
        int x = (getWidth() - bg.getWidth()) / 2;

        fondo.drawImage(bg, x, 0);

        // Texto titilando
        if(mostrarTexto)
        {
            GreenfootImage start = new GreenfootImage(
                "Presiona ENTER para comenzar",
                35,
                greenfoot.Color.YELLOW,
                new greenfoot.Color(0,0,0,0)
            );

          int textoX = (getWidth() - start.getWidth()) / 2;

          fondo.drawImage(start, textoX, 500);
        }
    }
}

