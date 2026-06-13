import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class DisplayPanel extends JPanel implements MouseListener, KeyListener
{
    private int score;
    private boolean yellowColor;
    private int PeteX;
    private int PeteY;
    private BufferedImage background;
    private BufferedImage Pete;
    private boolean[] pressedKeys;

    public void popUp() {
        while (960 < PeteX && PeteX < 1120 && 210 < PeteY && PeteY < 250) System.out.println("It Popped!");
    }


    public DisplayPanel()
    {
        score = 0;
        yellowColor = true;
        PeteX = 663;
        PeteY = 655;
        try
        {
            background = ImageIO.read(new File("src/background.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            Pete = ImageIO.read(new File("src/peteBack.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true); // this line of code + one below makes this panel active for keylistener events
        requestFocusInWindow(); // see comment above
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(Pete, PeteX, PeteY, null);

        // set font and color of text
        g.setFont(new Font("Arial", Font.BOLD, 16));
        if (yellowColor)
        {
            g.setColor(Color.YELLOW);
        } else
        {
            g.setColor(Color.BLACK);
        }
        g.drawString("Score: " + score, 50, 30);
    }
        @Override
        public void keyPressed(KeyEvent e)
        {

            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_A) {  // A key; VK_A equals 65
            PeteX -= 7;
            try
            {
                Pete = ImageIO.read(new File("src/peteLeft.png"));
            }
            catch (IOException error)
            {

            }
            repaint();
                popUp();
        }

        if (keyCode == KeyEvent.VK_D) {  // D key; VK_D equals 65
            PeteX += 7;
            try
            {
                Pete = ImageIO.read(new File("src/peteRight.png"));
            }
            catch (IOException error)
            {

            }
            repaint();
            popUp();
        }

        if (keyCode == KeyEvent.VK_S)
        {  // A key; VK_A equals 65
            PeteY += 7;
            try
            {
                Pete = ImageIO.read(new File("src/peteFront.png"));
            }
            catch (IOException error)
            {

            }
            repaint();
            popUp();
        }
        if (keyCode == KeyEvent.VK_W) {  // D key; VK_D equals 65
            PeteY -= 7;
            try
            {
                Pete = ImageIO.read(new File("src/peteBack.png"));
            }
            catch (IOException error)
            {

            }
            repaint();
            popUp();
        }

    }



    @Override
    public void mouseClicked(MouseEvent e)
    {

    }



    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

}
