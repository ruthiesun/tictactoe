import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gameboard implements ActionListener{
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JPanel panel;
	
	public Gameboard() {
		panel = new JPanel();
		
		JFrame frame = new JFrame();
		frame.setSize(230,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("Tic-Tac-Toe");
		label.setBounds(10,10,230,25);
		panel.add(label);
		
		b1 = new JButton("");
		b1.setBounds(5,30,70,70);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(1);
			}
		});
		panel.add(b1);
		
		b2 = new JButton("");
		b2.setBounds(80,30,70,70);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(2);
			}
		});
		panel.add(b2);
		
		b3 = new JButton("");
		b3.setBounds(155,30,70,70);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(3);
			}
		});
		panel.add(b3);
		
		b4 = new JButton("");
		b4.setBounds(5,105,70,70);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(4);
			}
		});
		panel.add(b4);
		
		b5 = new JButton("");
		b5.setBounds(80,105,70,70);
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(5);
			}
		});
		panel.add(b5);
		
		b6 = new JButton("");
		b6.setBounds(155,105,70,70);
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(6);
			}
		});
		panel.add(b6);
		
		b7 = new JButton("");
		b7.setBounds(5,180,70,70);
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(7);
			}
		});
		panel.add(b7);
		
		b8 = new JButton("");
		b8.setBounds(80,180,70,70);
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(8);
			}
		});
		panel.add(b8);
		
		b9 = new JButton("");
		b9.setBounds(155,180,70,70);
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				TicTacToe.updateMoves(9);
			}
		});
		panel.add(b9);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent b) {
		//nothing
	}
	
	public void updateButton(int bNum, String mark) { //replaces button with player mark
		int[] bLocation = new int[4];
		switch (bNum) {
		case 1:
			b1.setVisible(false);
			bLocation = new int[]{5,30,70,70};
			break;
	
		case 2:
			b2.setVisible(false);
			bLocation = new int[]{80,30,70,70};
			break;
		
		case 3:
			b3.setVisible(false);
			bLocation = new int[]{155,30,70,70};
			break;
		
		case 4:
			b4.setVisible(false);
			bLocation = new int[]{5,105,70,70};
			break;
		
		case 5:
			b5.setVisible(false);
			bLocation = new int[]{80,105,70,70};
			break;
		
		case 6:
			b6.setVisible(false);
			bLocation = new int[]{155,105,70,70};
			break;
		
		case 7:
			b7.setVisible(false);
			bLocation = new int[]{5,180,70,70};
			break;
		
		case 8:
			b8.setVisible(false);
			bLocation = new int[]{80,180,70,70};
			break;
		
		case 9:
			b9.setVisible(false);
			bLocation = new int[]{155,180,70,70};
			break;
		}
		
		JLabel label = new JLabel(mark);
		label.setBounds(bLocation[0]+35,bLocation[1],bLocation[2],bLocation[3]);
		panel.add(label);
	}
	
	public void clearButtons() {
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		b7.setVisible(false);
		b8.setVisible(false);
		b9.setVisible(false);
	}
}
