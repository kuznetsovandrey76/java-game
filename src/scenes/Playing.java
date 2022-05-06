package scenes;

import main.Game;

import java.awt.*;

public class Playing  extends GameScene implements SceneMethods{
    public Playing(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(0,0,525,525);
    }
}
