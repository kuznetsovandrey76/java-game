package inputs;

import main.GameStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static main.GameStates.MENU;
import static main.GameStates.PLAYING;
import static main.GameStates.SETTINGS;

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
                GameStates.gameState = MENU;
                break;
            case KeyEvent.VK_A:
                System.out.println("A is pressed");
                GameStates.gameState = PLAYING;
                break;
            case KeyEvent.VK_S:
                System.out.println("S is pressed");
                GameStates.gameState = SETTINGS;
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
