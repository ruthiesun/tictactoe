import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class NameWindow extends Observable {
    private JFrame window;
    private JTextField nameField;

    /*
     *  EFFECTS: constructor
     */
    public NameWindow(String num) {
        window = new JFrame("Player " + num + " name?");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nameField = new JTextField();
        nameField.setColumns(30);
        setup();
    }

    private void setup() {
        nameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    window.setVisible(false);
                    setChanged();
                    notifyObservers();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        window.add(nameField);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public String getName() {
        return nameField.getText();
    }
}
