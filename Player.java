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

    public void act()
    {
        mover();

        aplicarGravedad();

        saltar();
    }

    // MOVIMIENTO IZQUIERDA Y DERECHA
    public void mover()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - velocidad, getY());
        }

        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + velocidad, getY());
        }
    }

    // GRAVEDAD
    public void aplicarGravedad()
    {
        velocidadVertical += gravedad;

        setLocation(getX(), getY() + velocidadVertical);

        // Piso simple temporal
        if(getY() > 500)
        {
            setLocation(getX(), 500);

            velocidadVertical = 0;
        }
    }

    // SALTO
    public void saltar()
    {
        if(Greenfoot.isKeyDown("space") && getY() >= 500)
        {
            velocidadVertical = -15;
        }
    }
}
