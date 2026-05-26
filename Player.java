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
    }

    // =====================================
    // MOVIMIENTO
    // =====================================
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

    // =====================================
    // GRAVEDAD SIMPLE
    // =====================================
    public void aplicarGravedad()
    {
        velocidadVertical += gravedad;

        setLocation(getX(), getY() + velocidadVertical);

        enSuelo = false;

        // Detectar plataforma debajo
        Actor plataforma = getOneObjectAtOffset(
            0,
            getImage().getHeight()/2,
            Platform.class
        );

        if(plataforma != null && velocidadVertical >= 0)
        {
            setLocation(
                getX(),
                plataforma.getY()
                - plataforma.getImage().getHeight()/2
                - getImage().getHeight()/2
            );

            velocidadVertical = 0;

            enSuelo = true;
        }

        // Suelo principal
        if(getY() > 520)
        {
            setLocation(getX(), 520);

            velocidadVertical = 0;

            enSuelo = true;
        }
    }

    // =====================================
    // SALTO SIMPLE
    // =====================================
    public void saltar()
    {
        if(Greenfoot.isKeyDown("space") && enSuelo)
        {
            velocidadVertical = -15;

            enSuelo = false;
        }
    }
}
