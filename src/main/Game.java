package main;
import inputs.KeyboardListener;
import inputs.MyMouseListener;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {
    public Game() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GameScreen gameScreen = new GameScreen(this);
        add(gameScreen);
        pack(); // Place it after add gameScreen
        setVisible(true);
    }

    private void initInputs() {
        MyMouseListener myMouseListener = new MyMouseListener();
        KeyboardListener keyboardListener = new KeyboardListener();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus();
    }

    private void start() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.initInputs();
        game.start();
    }

    @Override
    public void run() {
        double FPS_SET = 120.0;
        double timePerFrame = 1000000000.0 / FPS_SET;
        double UPS_SET = 60.0;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();

        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while(true) {
            now = System.nanoTime();

            // Render
            if(now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }

            // Update
            if(now - lastUpdate >= timePerUpdate) {
                lastUpdate = now;
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
