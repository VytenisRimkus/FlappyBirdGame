import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.lang.Math;

public record GameDraw(GameLogic gameLogic) implements Serializable {

    static ImageBuffer image = new ImageBuffer();
    public void drawBird(Graphics g) throws IOException {

        BufferedImage img = image.getImg("flappybird.png");
        g.drawImage(ImageBuffer.resize(img, 30, 30), 150,gameLogic.getHeight() + gameLogic.getVelocity(),null);
        gameLogic.setHeight(gameLogic.getHeight());
        gameLogic.setVelocity(gameLogic.getVelocity());
    }
    public void drawBackground(Graphics g) throws IOException {

        BufferedImage img = image.getImg("background.png");
        g.drawImage(ImageBuffer.resize(img, 480, 640),0,0,null);
    }
    public void drawWall(Graphics g) {

        g.setColor(Color.GREEN);

        int wallX[] = gameLogic.getWallX();
        int wallY[] = gameLogic.getWallY();
        for(int i=0; i<2; i++){

            g.fillRect(gameLogic.getWallX()[i], gameLogic.getWallY()[i] - (gameLogic.getWallHeight()/2+80), 40, 700);
            g.fillRect(gameLogic.getWallX()[i], gameLogic.getWallY()[i] + (gameLogic.getWallHeight()/2+80), 40, 700);

            if(wallX[i] < 0){
                gameLogic.getWallY()[0] = (int)(Math.random() * (wallY[0]-150) + 10);
                gameLogic.getWallY()[1] = wallY[0] + 20;
                gameLogic.getWallX()[i] = 400;
                gameLogic.setWallY(wallY);
                gameLogic.setWallX(wallX);

            }
        }
    }
}