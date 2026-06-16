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
import java.io.InputStream;

public abstract class DisplayPanel extends JPanel implements MouseListener, KeyListener
{
    public String color;
    public int x;
    public int y;
    private int score;
    private boolean yellowColor;
    private int PeteX;
    private int PeteY;
    private BufferedImage background;
    private BufferedImage Pete;
    private BufferedImage Play;
    private BufferedImage Roulette;
    private BufferedImage Start;

    public DisplayPanel() {
        score = 0;
        yellowColor = true;
        PeteX = 665;
        PeteY = 650;

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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Roulette, 0, 0, null);
        g.drawImage(background, 0, 0, null);
        g.drawImage(Pete, PeteX, PeteY, null);
        g.drawImage(Play, 150, 300, null);
        g.drawImage(Start, 150, 500, null);
        // set font and color of text
        g.setFont(new Font("Arial", Font.BOLD, 16));
        if (yellowColor) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawString("Score: " + score, 50, 30);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    } // unimplemented
    // unimplemented because if you move your mouse while clicking, this method isn't
    // called, so mouseReleased is best

    @Override
    public void mousePressed(MouseEvent e) {
    } // unimplemented

    public void playRoulette()
    {
        try
        {
            Roulette = ImageIO.read(new File("src/Roulette.png"));
            Pete = ImageIO.read(InputStream.nullInputStream());
            background = ImageIO.read(InputStream.nullInputStream());
            Play = ImageIO.read(InputStream.nullInputStream());
            Start = ImageIO.read(new File("src/start.png"));
        }
        catch (IOException error)
        {

        }
        repaint();

    }
    public void popUp() {
        if (50 < PeteX && PeteX < 288 && 609 > PeteY && PeteY > 509)
        {
            try
            {
                Play = ImageIO.read(new File("src/Play.png"));
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public void Unpop() {
        if (!(50 < PeteX && PeteX < 288 && 609 > PeteY && PeteY > 509))
        {
            try
            {
                Play = ImageIO.read(InputStream.nullInputStream());
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

        if (e.getButton() == MouseEvent.BUTTON1)
        {
            x = e.getX();
            y = e.getY();
            System.out.println("X:" + x + " " + "Y:" + y);
        }
        if (873 < x && x < 985 && 425 > y && y > 380 )
        {
             color = "bet on red";
            System.out.println(color);
        }

        if (985 < x && x < 1093 && 425 > y && y > 380 )
        {
             color = "bet on black";
            System.out.println(color);
        }
        if (e.getButton() == MouseEvent.BUTTON1 && (162 < x && x < 332 && 633 > y && y > 535) && (color.equals("bet on black") || color.equals("bet on red")))
        {
            System.out.println("didhe");
        }


    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    } // unimplemented

    @Override
    public void mouseExited(MouseEvent e)
    {

    } // unimplemented

    @Override
    public void keyTyped(KeyEvent e)
    {

    } // unimplemented

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A)
        {  // A key; VK_A equals 65
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
            Unpop();
        }
        if (keyCode == KeyEvent.VK_D)
        {  // D key; VK_D equals 65
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
            Unpop();
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
            Unpop();
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
            Unpop();
        }
        if (50 < PeteX && PeteX < 288 && 609 > PeteY && PeteY > 509 && keyCode == KeyEvent.VK_E)
        {
            playRoulette();
        }

    }

}