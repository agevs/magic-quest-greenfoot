import greenfoot.*;

public class VictoryWorld extends World
{
    private boolean mostrarTexto = true;
    private int timer = 0;

    public VictoryWorld()
    {
        super(1024, 576, 1);

        actualizarPantalla();
    }

    public void act()
    {
        timer++;

        // TITILEO DEL TEXTO
        if(timer % 40 == 0)
        {
            mostrarTexto = !mostrarTexto;
            actualizarPantalla();
        }

        if(Greenfoot.isKeyDown("m"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }

    public void actualizarPantalla()
    {
        GreenfootImage fondo = getBackground();

        // FONDO
        GreenfootImage bg =
            new GreenfootImage("victoryBackground.png");

        fondo.drawImage(bg, 0, 0);

        // PANEL
        GreenfootImage panel = new GreenfootImage(700, 280);

        panel.setColor(new Color(0, 0, 0, 160));
        panel.fillRect(0, 0, 700, 220);

        panel.setColor(new Color(100, 255, 255, 180));
        panel.drawRect(0, 0, 699, 219);

        panel.setColor(new Color(180, 255, 255, 80));
        panel.drawRect(2, 2, 695, 215);

        fondo.drawImage(panel, 162, 150);

        // TITULO
        GreenfootImage titulo = new GreenfootImage(
            "NIVEL COMPLETADO",
            55,
            Color.YELLOW,
            new Color(0,0,0,0)
        );

        int tituloX =
            (getWidth() - titulo.getWidth()) / 2;

        fondo.drawImage(titulo, tituloX, 210);

        // MENSAJE
        GreenfootImage mensaje = new GreenfootImage(
            "Kai ha restaurado la energia del bosque",
            30,
            Color.WHITE,
            new Color(0,0,0,0)
        );

        int mensajeX =
            (getWidth() - mensaje.getWidth()) / 2;

        fondo.drawImage(mensaje, mensajeX, 300);

        // TEXTO TITILANDO
        if(mostrarTexto)
        {
            GreenfootImage menu = new GreenfootImage(
                "Presiona M para volver al menu principal",
                30,
                Color.WHITE,
                new Color(0,0,0,0)
            );

            int menuX =
                (getWidth() - menu.getWidth()) / 2;

            fondo.drawImage(menu, menuX, 340);
        }
    }
}
