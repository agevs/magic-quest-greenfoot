import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoryWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryWorld extends World
{
    private GreenfootSound musicaHistoria;
    private String[] mensajes =
    {
        "Las gemas mágicas del bosque han sido robadas...",
        "Kai deberá recuperar la energía perdida."
    };

    private int mensajeActualIndex = 0;

    private String textoActual = "";

    private int letraIndex = 0;

    private int timer = 0;

    private boolean controles = false;
    private boolean mostrarEnter = true;

    public StoryWorld()
    {
        super(1000, 600, 1);
        
        musicaHistoria = new GreenfootSound("menu_theme_2.mp3");
        musicaHistoria.setVolume(30);
        musicaHistoria.play();

        actualizarPantalla();
    }

    public void act()
    {
        timer++;

        // EFECTO TYPEWRITER
        if(!controles && timer % 5 == 0)
        {
            String mensaje = mensajes[mensajeActualIndex];

            if(letraIndex < mensaje.length())
            {
                textoActual += mensaje.charAt(letraIndex);
                letraIndex++;

                actualizarPantalla();
            }
            else
            {
                // Espera antes del siguiente mensaje
                if(timer % 120 == 0)
                {
                    mensajeActualIndex++;

                    if(mensajeActualIndex < mensajes.length)
                    {
                        textoActual = "";
                        letraIndex = 0;
                    }
                    else
                    {
                        controles = true;
                    }

                    actualizarPantalla();
                }
            }
        }

        // ENTER TITILANDO
        if(controles)
        {
            if(timer % 40 == 0)
            {
                mostrarEnter = !mostrarEnter;
                actualizarPantalla();
            }

            if(Greenfoot.isKeyDown("enter"))
            {
                musicaHistoria.stop();
                Greenfoot.setWorld(new GameWorld());
            }
        }
    }

    public void actualizarPantalla()
    {
        GreenfootImage fondo = getBackground();

        GreenfootImage bg = new GreenfootImage("storyBackground.png");

        int x = (getWidth() - bg.getWidth()) / 2;

        fondo.drawImage(bg, x, 0);
        
        // TEXTO TYPEWRITER CON PANEL FANTASY
        if(!controles)
        {
            // PANEL
            GreenfootImage panelHistoria = new GreenfootImage(900, 80);

            // Fondo transparente
            panelHistoria.setColor(new greenfoot.Color(0, 0, 0, 160));
            panelHistoria.fillRect(0, 0, 900, 80);

            // Borde glow cyan
            panelHistoria.setColor(new greenfoot.Color(100, 255, 255, 180));
            panelHistoria.drawRect(0, 0, 899, 79);

            // Glow extra
            panelHistoria.setColor(new greenfoot.Color(180, 255, 255, 80));
            panelHistoria.drawRect(2, 2, 895, 75);

            fondo.drawImage(panelHistoria, 50, 260);

            // TEXTO
            GreenfootImage texto = new GreenfootImage(
                textoActual,
                45,
                new greenfoot.Color(100, 255, 255),
                new greenfoot.Color(0,0,0,0)
            );

            int textoX = (getWidth() - texto.getWidth()) / 2;

            fondo.drawImage(texto, textoX, 280);
        }

        // CONTROLES
        if(controles)
        {
            // PANEL FANTASY
            GreenfootImage panel = new GreenfootImage(500, 220);

            // Fondo transparente
            panel.setColor(new greenfoot.Color(0, 0, 0, 160));
            panel.fillRect(0, 0, 500, 220);

            // Borde brillante
            panel.setColor(new greenfoot.Color(100, 255, 255, 180));
            panel.drawRect(0, 0, 499, 219);

            // Glow extra
            panel.setColor(new greenfoot.Color(180, 255, 255, 80));
            panel.drawRect(2, 2, 495, 215);

            fondo.drawImage(panel, 250, 180);

            // TEXTO CONTROLES
            GreenfootImage controlesTexto = new GreenfootImage(
                "Utiliza A y D para moverte\n\nESPACIO para saltar",
                38,
                greenfoot.Color.CYAN,
                new greenfoot.Color(0,0,0,0)
            );

            int controlesX = (getWidth() - controlesTexto.getWidth()) / 2;

            fondo.drawImage(controlesTexto, controlesX, 255);

            // ENTER TITILANDO
            if(mostrarEnter)
            {
                GreenfootImage enter = new GreenfootImage(
                    "Presiona ENTER para comenzar",
                    30,
                    greenfoot.Color.YELLOW,
                    new greenfoot.Color(0,0,0,0)
                );

                int enterX = (getWidth() - enter.getWidth()) / 2;

                fondo.drawImage(enter, enterX, 520);
            }
        }
    }
}
