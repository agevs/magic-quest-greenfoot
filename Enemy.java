import greenfoot.*;

public class Enemy extends Actor {

    private int speed;
    private int direction = 1;
    private int moveCount = 0;
    private int patrolDistance = 100;

    public Enemy(int speed) {
        this.speed = 1;
        
    }

    public void act() {
        moverse();
    }

    private void moverse() {
        setLocation(getX() + speed * direction, getY());
        moveCount += speed;

        if (moveCount >= patrolDistance) {
            direction *= -1;
            moveCount = 0;
        }

        if (getX() <= 20 || getX() >= getWorld().getWidth() - 20) {
            direction *= -1;
        }
    }
}