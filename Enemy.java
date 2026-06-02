import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    public void act()
    {
        Player jugador =
            (Player)getOneIntersectingObject(Player.class);

        if(jugador != null)
        {
            Greenfoot.playSound("enemy.mp3");
            ((GameWorld)getWorld()).perderVida();

            jugador.setLocation(120, 430);
        }
    }
}
