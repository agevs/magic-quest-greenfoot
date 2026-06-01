import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int score = 0;
    private int lives = 3;
    private Scoreboard scoreBoard;
 
    public GameWorld()
    {
        super(1024, 576, 1);
 
        GreenfootImage bg = new GreenfootImage("gameBackground.png");
        getBackground().drawImage(bg, 0, 0);
 
        addObject(new Player(), 180, 420);
 
        addObject(new Platform(180, 40), 180, 470);
 
        addObject(new Platform(180, 40), 380, 400);
 
        addObject(new Platform(180, 40), 580, 340);
 

        addObject(new Platform(180, 40), 780, 280);
 
        
        addObject(new Goal(), 780, 200);
 
        scoreBoard = new Scoreboard(score, lives);
        addObject(scoreBoard, 100, 20);
    }
 
    public void ganaste()
    {
        showText("Nivel completado, Puntos: " + score, 512, 288);
        Greenfoot.setWorld(new GameWorld2());
    }
 
    public void addScore(int points)
    {
        score += points;
        scoreBoard.update(score, lives);
    }
 
    public void perdervida()
    {
        lives--;
        scoreBoard.update(score, lives);
        if (lives <= 0) {
            gameover();
        }
    }
 
    public int vidas()
    {
        return lives;
    }
 
    public void morir()
    {
        java.util.List<Player> players = getObjects(Player.class);
        if (!players.isEmpty()) {
            players.get(0).setLocation(180, 420);
        }
    }
 
    private void gameover()
    {
        showText("Perdiste, Puntos: " + score, 512, 288);
        Greenfoot.stop();
    }
}
