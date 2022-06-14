import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/*
 *  A class representing a Tic Tac Toe game
 */
public class TicTacToe implements Observer {
	private static Player p1;
	private static Player p2;
	private static Gameboard board;
    private static NameWindow nameWindow;
    private boolean p1Turn;

    /*
     *  EFFECTS: constructor. Sets players to null and asks user to input first player's name
     */
	public TicTacToe() {
		p1 = null;
        p2 = null;
        nameWindow = new NameWindow("1");
        nameWindow.addObserver(this);
	}

    /*
     *  EFFECTS: randomly chooses one of the players to play the first move
     */
    private void randChooseFirstPlayer() {
        if (Math.random()<0.5) {
            p1Turn = true;
        } else {
            p1Turn = false;
        }
    }

    /*
     *  REQUIRES: players are initialized
     *  EFFECTS: starts game
     */
	private void start() {
        randChooseFirstPlayer();
        String turn;
        if (p1Turn) {
            turn = p1.getName();
        } else {
            turn = p2.getName();
        }
		board = new Gameboard(turn);
        board.addObserver(this);
        p1.addObserver(this);
        p2.addObserver(this);
	}

    /*
     *  REQUIRES: one of the player has won
     *  EFFECTS: opens a window that congratulates the player and prompts for a rematch
     */
    private void congratWinner(Player winner) {
        board.hide();
        JFrame window = new JFrame("Wow, a winner!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setMinimumSize(new Dimension(300, window.getHeight()));
        window.setLocationRelativeTo(null);
        JLabel name = new JLabel("Congrats, " + winner.getName() + " !");
        JButton rematch = new JButton("Rematch");
        rematch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new TicTacToe();
            }
        });
        window.getContentPane().setLayout(new GridLayout(2,1));
        window.getContentPane().add(name);
        window.getContentPane().add(rematch);
        window.pack();
        window.setVisible(true);
    }

    /*
     *  EFFECTS: starts a new game
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }

    /*
     *  EFFECTS:    if notified by NameWindow, initializes player and either prompts for next name or starts game
     *              if notified by Gameboard, updates player move count and board state
     *              if notified by Player, player has won - congratulates the player
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o.getClass() == NameWindow.class) {
            if (p1 == null) {
                p1 = new Player(nameWindow.getName());
                nameWindow = new NameWindow("2");
                nameWindow.addObserver(this);
            } else if (p2 == null) {
                p2 = new Player(nameWindow.getName());
                start();
            }
        } else if (o.getClass() == Gameboard.class) {
            Player toUpdate;
            String mark;
            if (p1Turn) {
                toUpdate = p1;
                mark = "x";
                p1Turn = false;
                board.displayTurn(p2.getName());
            } else {
                toUpdate = p2;
                mark = "o";
                p1Turn = true;
                board.displayTurn(p1.getName());
            }
            toUpdate.addMove((int) arg);
            board.updateButton((int) arg, mark);
        } else if (o.getClass() == Player.class) {
            Player winner = (Player) o;
            congratWinner(winner);
        }
    }
}
