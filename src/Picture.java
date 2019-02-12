import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Picture {
    public static void picture() {
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("thumbsUp.jpg");
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
