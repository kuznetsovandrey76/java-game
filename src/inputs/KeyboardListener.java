package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W:
                System.out.println("W is pressed");
                break;
            case KeyEvent.VK_A:
                System.out.println("A is pressed");
                break;
            case KeyEvent.VK_S:
                System.out.println("S is pressed");
                break;
            case KeyEvent.VK_D:
                System.out.println("D is pressed");
                break;
            default:
                System.out.println("Other key is pressed");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
