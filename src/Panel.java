import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Panel extends JPanel implements KeyListener, ActionListener{
    GameLogic gameLogic = new GameLogic();
    GameDraw gameDraw = new GameDraw(gameLogic);
    Timer timer = new Timer(40, this);
    public Panel(){

        setSize(425, 640);
        setFocusable(true);
        setBackground(Color.BLACK);
        addKeyListener(this);

    }
    public void paint(Graphics g){

        super.paint(g);
        try {
            if (!gameLogic.gameOver){
                gameDraw.drawBackground(g);
                gameDraw.drawWall(g);
                gameDraw.drawBird(g);
                gameLogic.Logic();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        gameLogic.setAccel(gameLogic.accel + gameLogic.impulse);
        gameLogic.setVelocity(gameLogic.velocity + gameLogic.accel);

        gameLogic.wallX[0] -= gameLogic.wallVelocity;
        gameLogic.wallX[1] -= gameLogic.wallVelocity;

        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressedKey = e.getKeyCode();

        if (pressedKey == e.VK_SPACE){
            gameLogic.accel = -10;
        }
        if (pressedKey == e.VK_S){
            timer.start();
        }
        if (pressedKey == e.VK_R){
            timer.stop();
            gameLogic.height = 325;
            gameLogic.velocity = 0;
            gameLogic.accel = 8;
            gameLogic.wallX = new int[2];
            gameLogic.wallY = new int[2];
            gameLogic.gameOver = false;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

}
