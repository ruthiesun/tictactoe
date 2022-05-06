import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	private static Player p1;
	private static Player p2;
	private static Gameboard board;
	private static int turn;
	
	public TicTacToe() {
		turn = 1;
	}

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		ttt.newGame();
	}
	
	private void newGame() { //set up blank game, name the players, determine the first player
		Scanner inputter = new Scanner(System.in);
		
		//set up p1 and p2
		String p1Name = null;
		String p2Name = null;
		System.out.println("Enter player 1's name");
		while (p1Name==null) {
			p1Name = inputter.nextLine();
		}
		System.out.println("Enter player 2's name");
		while (p2Name==null) {
			p2Name = inputter.nextLine();
		}
		
		board = new Gameboard();
		
		//randomly determine who starts
		Random rand = new Random();
		if (rand.nextBoolean()==true) {
			p1 = new Player (p1Name);
			p2 = new Player (p2Name);
			System.out.println(p1Name + " starts");
		}
		else {
			p1 = new Player (p2Name);
			p2 = new Player (p1Name);
			System.out.println(p2Name + " starts");
		}
	}
	
	//function that will be called by Gameboard to update moves and turn
	public static void updateMoves(int bNum) {
		if (turn%2 != 0) { //p1's turn
			p1.addMove(bNum);
			board.updateButton(bNum,"x");
		}
		else { //p2's turn
			p2.addMove(bNum);
			board.updateButton(bNum,"o");
		}
		
		if (getWinner()==null) { // no winner yet
			if (turn==9) { //was the last turn
				printWinner("Tie!");
			}
			else { //more turns are left
				turn++;
			}
		}
		else { // there's a winner
			printWinner(getWinner());
		}
	}
	
	private static String getWinner() { //returns the name of the winner. if there is no winner, return null
		if (p1.checkIfWon()==true) {
			return p1.getName();
		}
		else if (p2.checkIfWon()==true) {
			return p2.getName();
		}
		return null;
	}

	private static void printWinner(String winner) {
		board.clearButtons();
		if (winner.equals("Tie!")) {
			System.out.println(winner);
		}
		else {
			System.out.println(winner + " won!");
		}
	}
}
