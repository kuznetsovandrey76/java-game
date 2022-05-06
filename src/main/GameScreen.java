package main;

import javax.swing.JPanel;
import java.awt.*;

public class GameScreen extends JPanel {
    private final Game game;
    public GameScreen(Game game) {
        this.game = game;
        setPanelSize();
    }
    public void setPanelSize() {
        Dimension size = new Dimension(525, 525);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.getRender().render(g);
    }
}
