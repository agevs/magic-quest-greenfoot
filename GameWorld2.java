import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld2 extends World
{   private int score = 0;
    private int lives = 3;
    private Scoreboard scoreBoard;

    public GameWorld2() {
         super(1024, 576, 1);
        
        
        GreenfootImage bg = new GreenfootImage("gameBackground.png");
        getBackground().drawImage(bg, 0, 0);
 
       addObject(new Platform(1024, 20), 512, 566);
 
      
        addObject(new Platform(320, 40), 320, 460);
 
        addObject(new Platform(320, 40), 480, 360);
 
        addObject(new Platform(320, 40), 680, 260);
 
        addObject(new Platform(320, 40), 230, 280);
 
        addObject(new Player(), 60, 540);
 
        addObject(new Coin(), 160, 400);
        addObject(new Coin(), 360, 300);
        addObject(new Coin(), 560, 200);
        addObject(new Coin(), 110, 220);
 
        addObject(new Enemy(2), 480, 320);
        addObject(new Enemy(3), 680, 220);
        addObject(new Enemy(2), 230, 240);
 
        addObject(new Goal(), 760, 200);
 
        scoreBoard = new Scoreboard(score, lives);
        addObject(scoreBoard, 100, 20);
    }

    public void addScore(int points) {
        score += points;
        scoreBoard.update(score, lives);
    }

    public void perdervida() {
        lives--;
        scoreBoard.update(score, lives);
        if (lives <= 0) {
            gameover();
        }
    }

    public int vidas() {
        return lives;
    }

    public void morir() {
        java.util.List<Player> players = getObjects(Player.class);
        if (!players.isEmpty()) {
            players.get(0).setLocation(80, 300);
        }
    }

    private void gameover() {
        showText("Perdiste, Puntos: " + score, 400, 300);
        Greenfoot.stop();
    }

    public void ganaste() {
        showText("Nivel completado, Puntos: " + score, 400, 300);
        Greenfoot.stop();
    }
}
