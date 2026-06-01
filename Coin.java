import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    public void act()
    {
        Player jugador = (Player)getOneIntersectingObject(Player.class);

        if(jugador != null)
        {
            ((GameWorld)getWorld()).sumarMoneda();

            getWorld().removeObject(this);
        }
    }
}
