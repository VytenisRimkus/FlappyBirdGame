import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        super("Flappy Bird");
        add(new Panel());
        setSize(400,640);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
}
