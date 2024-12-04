import javax.swing.JFrame;

public class AppFrame extends JFrame {
    AppFrame() {
        setTitle("Flappy Bird");
        setSize(500, 500);
        setLocationRelativeTo(null);
        AppPanel aPanel = new AppPanel();
        add(aPanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
