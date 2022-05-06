package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Render {
    private final Random random;
    private BufferedImage img;
    private final ArrayList<BufferedImage> sprites = new ArrayList<>();
    public Render() {
        random = new Random();
        importImage();
        loadSprites();
    }

    public void render(Graphics g) {
        switch (GameStates.gameState) {
            case MENU:
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
                break;
            case PLAYING:
            case SETTINGS:
                break;
        }
    }

    private void loadSprites() {
        // todo: Add other sprites
        sprites.add(img.getSubimage(0,80, 15,15)); // floor1
        sprites.add(img.getSubimage(16,80, 15,15));
        sprites.add(img.getSubimage(31,80, 15,15));
        sprites.add(img.getSubimage(46,80, 15,15));
        sprites.add(img.getSubimage(0,336, 50,50));
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("../resources/TilesetFloor.png");
        try {
            assert is != null; // not necessary
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getRandomInt() {
        return random.nextInt(4);
    }

    // Not used
    private Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }
}
