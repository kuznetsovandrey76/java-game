package main;

import javax.swing.JPanel;
import java.awt.*;

public class GameScreen extends JPanel {
    private final Render render;

    public GameScreen(Game game) {
        render = new Render();
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
        render.render(g);
    }
}
