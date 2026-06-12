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

public abstract class DisplayPanel extends JPanel implements MouseListener, KeyListener {
    private int score;
    private boolean yellowColor;
    private int PeteX;
    private int PeteY;
    private BufferedImage background;
    private BufferedImage Pete;
    private BufferedImage Play;

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
        g.drawImage(background, 0, 0, null);
        g.drawImage(Pete, PeteX, PeteY, null);
        g.drawImage(Play, 1035, 0, null);
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

    public void popUp() {
        if (960 < PeteX && PeteX < 1120 && 210 < PeteY && PeteY < 250)
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


    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            yellowColor = !yellowColor;
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    } // unimplemented

    @Override
    public void mouseExited(MouseEvent e) {
    } // unimplemented

    @Override
    public void keyTyped(KeyEvent e) {
    } // unimplemented

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A) {  // A key; VK_A equals 65
            PeteX -= 5;
            try {
                Pete = ImageIO.read(new File("src/peteLeft.png"));
            } catch (IOException error) {
            }
            repaint();
            popUp();
        }
        if (keyCode == KeyEvent.VK_D) {  // D key; VK_D equals 65
            PeteX += 5;
            try {
                Pete = ImageIO.read(new File("src/peteRight.png"));
            } catch (IOException error) {
            }
            repaint();
            popUp();
        }
        if (keyCode == KeyEvent.VK_S) {  // A key; VK_A equals 65
            PeteY += 5;
            try {
                Pete = ImageIO.read(new File("src/peteFront.png"));
            } catch (IOException error) {
            }
            repaint();
            popUp();
        }
        if (keyCode == KeyEvent.VK_W) {  // D key; VK_D equals 65
            PeteY -= 5;
            try {
                Pete = ImageIO.read(new File("src/peteBack.png"));
            } catch (IOException error) {
            }
            repaint();
            popUp();
        }
    }
}