import greenfoot.*;

public class GameOverWorld extends World
{
    private boolean mostrarAnuncio = true;
    private int timer = 0;

    public GameOverWorld()
    {
        super(1024, 576, 1);

        dibujarPantalla();
    }

    public void act()
    {
        timer++;

        // TITILEO DEL ANUNCIO
        if(timer % 40 == 0)
        {
            mostrarAnuncio = !mostrarAnuncio;
            dibujarPantalla();
        }

        if(Greenfoot.isKeyDown("m"))
        {
            Greenfoot.setWorld(new MyWorld());
        }

        if(Greenfoot.isKeyDown("a"))
        {
            Greenfoot.setWorld(new AdWorld());
        }
    }

    private void dibujarPantalla()
    {
        GreenfootImage fondo = getBackground();

        // FONDO
        GreenfootImage bg =
            new GreenfootImage("gameoverBackground.png");

        fondo.drawImage(bg, 0, 0);

        // PANEL
        GreenfootImage panel = new GreenfootImage(700, 220);

        panel.setColor(new Color(0, 0, 0, 160));
        panel.fillRect(0, 0, 700, 220);

        panel.setColor(new Color(100, 255, 255, 180));
        panel.drawRect(0, 0, 699, 219);

        panel.setColor(new Color(180, 255, 255, 80));
        panel.drawRect(2, 2, 695, 215);

        // CENTRADO
        fondo.drawImage(panel, 162, 170);

        // GAME OVER
        GreenfootImage titulo = new GreenfootImage(
            "GAME OVER",
            55,
            new Color(100,255,255),
            new Color(0,0,0,0)
        );

        int tituloX =
            (getWidth() - titulo.getWidth()) / 2;

        fondo.drawImage(titulo, tituloX, 210);

        // MENU
        GreenfootImage menu = new GreenfootImage(
            "Presiona M para volver al menu principal",
            30,
            Color.WHITE,
            new Color(0,0,0,0)
        );

        int menuX =
            (getWidth() - menu.getWidth()) / 2;

        fondo.drawImage(menu, menuX, 300);

        // ANUNCIO TITILANDO
        if(mostrarAnuncio)
        {
            GreenfootImage anuncio = new GreenfootImage(
                "Presiona A para ver anuncio y continuar",
                30,
                Color.WHITE,
                new Color(0,0,0,0)
            );

            int anuncioX =
                (getWidth() - anuncio.getWidth()) / 2;

            fondo.drawImage(anuncio, anuncioX, 350);
        }
    }
}