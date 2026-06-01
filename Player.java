import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int velocidad = 5;
    private int velocidadVertical = 0;
    private int gravedad = 1;
    private boolean enSuelo = false;
 
    public void act()
    {
        mover();
        aplicarGravedad();
        saltar();
        revisarMeta();
        revisarMonedas();   
        revisarEnemigos();  
    }
 
    
    public void mover()
    {
        if (Greenfoot.isKeyDown("a"))
            setLocation(getX() - velocidad, getY());
 
        if (Greenfoot.isKeyDown("d"))
            setLocation(getX() + velocidad, getY());
    }
 
    
    public void aplicarGravedad()
    {
        velocidadVertical += gravedad;
        setLocation(getX(), getY() + velocidadVertical);
        enSuelo = false;
 
        Actor plataforma = getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
 
        if (plataforma != null && velocidadVertical >= 0)
        {
            setLocation(
                getX(),
                plataforma.getY() - plataforma.getImage().getHeight() / 2 - getImage().getHeight() / 2
            );
            velocidadVertical = 0;
            enSuelo = true;
        }
 
     
        if (getY() > getWorld().getHeight() - 56)
        {
            setLocation(getX(), getWorld().getHeight() - 56);
            velocidadVertical = 0;
            enSuelo = true;
        }
    }
 
   
    public void saltar()
    {
        if (Greenfoot.isKeyDown("space") && enSuelo)
        {
            velocidadVertical = -15;
            enSuelo = false;
        }
    }
 
    
    public void revisarMeta()
    {
        Actor goal = getOneIntersectingObject(Goal.class);
        if (goal != null)
        {
            World mundo = getWorld();
            if (mundo instanceof GameWorld)
                ((GameWorld) mundo).ganaste();
            else if (mundo instanceof GameWorld2)
                ((GameWorld2) mundo).ganaste();
        }
    }
 
    
    private void revisarMonedas()
    {
        Actor coin = getOneIntersectingObject(Coin.class);
        if (coin != null)
        {
            World mundo = getWorld();
            getWorld().removeObject(coin);
            if (mundo instanceof GameWorld)
                ((GameWorld) mundo).addScore(10);
            else if (mundo instanceof GameWorld2)
                ((GameWorld2) mundo).addScore(10);
        }
    }
 
    
    private void revisarEnemigos()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null)
        {
            World mundo = getWorld();
            if (mundo instanceof GameWorld)
            {
                GameWorld gw = (GameWorld) mundo;
                gw.perdervida();
                if (gw.vidas() > 0)
                    setLocation(32, 499); // posición inicial nivel 1
            }
            else if (mundo instanceof GameWorld2)
            {
                GameWorld2 gw2 = (GameWorld2) mundo;
                gw2.perdervida();
                if (gw2.vidas() > 0)
                    setLocation(32, 499); // posición inicial nivel 2
            }
        }
    }
}
