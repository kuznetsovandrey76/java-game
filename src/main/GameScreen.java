package main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {
    private final Random random;
    private final BufferedImage img;
    private final ArrayList<BufferedImage> sprites = new ArrayList<>();

    public GameScreen(BufferedImage img) {
        this.img = img;
        loadSprites();
        random = new Random();
    }

    private void loadSprites() {
        // todo: Add other sprites
        sprites.add(img.getSubimage(0,80, 15,15)); // floor1
        sprites.add(img.getSubimage(16,80, 15,15));
        sprites.add(img.getSubimage(31,80, 15,15));
        sprites.add(img.getSubimage(46,80, 15,15));
        sprites.add(img.getSubimage(0,336, 50,50));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 35; j++) {
                // todo: Should changed
                if (i%2 == 0 || j%2 == 0) {
                    g.drawImage(sprites.get(0),i *15,j*15,null);
                } else {
                    g.drawImage(sprites.get(getRandomInt()),i *15,j*15,null);
                }
            }
        }
    }


    private int getRandomInt() {
        return random.nextInt(4);
    }

    private Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }
}
