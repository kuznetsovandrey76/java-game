package main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable {

    private final GameScreen gameScreen;
    private BufferedImage img;
    private Thread gameThread;

    private final int GAME_SIZE = 500;
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    public Game() {
        importImage();

        setSize(GAME_SIZE, GAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gameScreen = new GameScreen(img);
        add(gameScreen);

        setVisible(true);

    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("../resources/TilesetFloor.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();

        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;


        while(true) {
            // Render
            if(System.nanoTime() - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = System.nanoTime();
                frames++;
            }

            // Update
            if(System.nanoTime() - lastUpdate >= timePerUpdate) {
                lastUpdate = System.nanoTime();
                updates++;
            }

            if(System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}
