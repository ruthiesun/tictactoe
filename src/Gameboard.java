import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gameboard extends Observable implements ActionListener {
    private JFrame window;
	private JButton[] buttons;
	private JPanel panel;
    private final Color P1_COLOUR = new Color(255,212,212);
    private final Color P2_COLOUR = new Color(216,255,212);
    private final int WIDTH = 300;
	
	public Gameboard() {
        window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(WIDTH, WIDTH));

		panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));

        buttons = new JButton[9];
		for (int i=0; i<9; i++) {
            buttons[i] = new JButton("");
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
		window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.revalidate();
        window.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent b) {
		JButton pressed = (JButton) b.getSource();
        setChanged();
        if (pressed == buttons[0]) {
            notifyObservers(0);
        } else if (pressed == buttons[1]) {
            notifyObservers(1);
        } else if (pressed == buttons[2]) {
            notifyObservers(2);
        } else if (pressed == buttons[3]) {
            notifyObservers(3);
        } else if (pressed == buttons[4]) {
            notifyObservers(4);
        } else if (pressed == buttons[5]) {
            notifyObservers(5);
        } else if (pressed == buttons[6]) {
            notifyObservers(6);
        } else if (pressed == buttons[7]) {
            notifyObservers(7);
        } else if (pressed == buttons[8]) {
            notifyObservers(8);
        }
	}
	
	public void updateButton(int i, String mark) {
        buttons[i].setEnabled(false);
        buttons[i].setText(mark);
        if (mark.equals("x")) {
            buttons[i].setBackground(P1_COLOUR);
        } else {
            buttons[i].setBackground(P2_COLOUR);
        }
        window.revalidate();
        window.repaint();
	}

    public void hide() {
        window.setVisible(false);
    }
}
