import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goal extends Actor
{
    public void act()
    {
        Player jugador =
            (Player)getOneIntersectingObject(Player.class);

        if(jugador != null)
        {
            // Debe estar arriba de la meta
            if(jugador.getY() < getY() - 20)
            {
                Greenfoot.playSound("win.mp3");
                Greenfoot.stop();

                getWorld().showText("¡GANASTE!", 512, 280);
            }
        }
    }
}
