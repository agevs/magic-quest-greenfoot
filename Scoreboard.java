import greenfoot.*;

public class Scoreboard extends Actor {

    public Scoreboard(int score, int lives) {
        update(score, lives);
    }

    public void update(int score, int lives) {
        String texto = "Puntos: " + score + "     Vidas: " + lives;
        GreenfootImage puntaje = new GreenfootImage(texto, 22, Color.WHITE, Color.BLACK);
        setImage(puntaje);
    }

    public void act() {
    }
}