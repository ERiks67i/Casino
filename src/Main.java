import javax.swing.JFrame;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Super Mario Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);

        // create a DisplayPanel object
        DisplayPanel panel = new DisplayPanel() {
            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        // add it to the frame
        frame.add(panel);

        // call setVisible after everything else
        frame.setVisible(true);
    }
}
