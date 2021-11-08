import java.awt.*;
import java.io.Serializable;

public class GameLogic implements Serializable {

    int accel = 8, velocity = 0, impulse = 1;
    int height = 325;

    int wallHeight = 700;
    int wallX[] = new int[2];
    int wallY[] = new int[2];
    int wallVelocity = 5;

    boolean gameOver = false;

    void Logic(){

        int currentHeight = getHeight() + getVelocity();
        for (int i=0; i<2; i++) {
            if (currentHeight < -10 || currentHeight >= 650) setGameOver(true);
            if ((640 - currentHeight) - ((Math.abs(wallY[0] - 640) + Math.abs(wallY[1] - 640)) / 4) < 0 && Math.abs(wallX[i] - 150) <= 20) {
                setGameOver(true);
            }
        }
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    public int[] getWallX() {
        return wallX;
    }

    public void setWallX(int[] wallX) {
        this.wallX = wallX;
    }

    public int[] getWallY() {
        return wallY;
    }

    public void setWallY(int[] wallY) {
        this.wallY = wallY;
    }

    public int getWallHeight() {
        return wallHeight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setAccel(int accel) {
        this.accel = accel;
    }
}