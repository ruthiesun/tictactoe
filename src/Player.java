//data for an individual player

public class Player {
	private String name;
	private int[] moves; //1 for clicked boxes, empty for boxed not clicked yet (L to R; T to B)
	
	public Player(String s) { //constructor
		name = s;
		moves = new int[9];
	}
	
	public String getName() { //returns the name of the player
		return name;
	}
	
	public int[] getMoves() { //return the moves made by the player
		return moves;
	}
	
	public void addMove(int boxNum) {
		moves[boxNum-1] = 1;
	}
	
	public boolean checkIfWon() { //check if the play has won yet
		//check for horizontal wins
		int numInRow = 3;
		for (int i=0; i<numInRow; i++) {
			if ((moves[0+i*numInRow] + moves [1+i*numInRow] + moves[2+i*numInRow]) == 3) { //check for horizontal wins
				return true;
			}
			if ((moves[0+i] + moves[3+i] + moves[6+i]) == 3) { //check for vertical wins
				return true;
			}
			if ((moves[0] + moves[4] + moves[8]) == 3) {
				return true;
			}
			if ((moves[2] + moves[4] + moves[6]) == 3) {
				return true;
			}
		}
		return false;
	}
	
}
