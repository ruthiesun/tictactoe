import java.util.Observable;

/*
 *  A class representing an individual player
 */
public class Player extends Observable {
	private String name;
	private boolean[] moves;

    /*
     *  EFFECTS: constructor
     */
	public Player(String s) {
		name = s;
		moves = new boolean[9];

        for (int i=0; i<9; i++) {
            moves[i] = false;
        }
	}
	
	public String getName() { //returns the name of the player
		return name;
	}

    /*
     *  REQUIRES: 0<=i<=8
     *  EFFECTS: updates moves and check if player has won
     */
	public void addMove(int i) {
		moves[i] = true;
        checkIfWon();
	}

    /*
     *  EFFECTS: if player has won, notifies observers
     */
	private void checkIfWon() {
		// check horizontal wins
		for (int i=0; i<9; i+=3) {
			if (moves[i] && moves[i+1] && moves[i+2]) {
                setChanged();
                notifyObservers();
                break;
            }
		}

        // check vertical wins
        for (int i=0; i<3; i++) {
            if (moves[i] && moves[i+3] && moves[i+6]) {
                setChanged();
                notifyObservers();
                break;
            }
        }

        // check diagonal wins
        if (moves[0] && moves[4] && moves[8]) {
            setChanged();
            notifyObservers();
        }
        if (moves[2] && moves[4] && moves[6]) {
            setChanged();
            notifyObservers();
        }
	}
	
}
