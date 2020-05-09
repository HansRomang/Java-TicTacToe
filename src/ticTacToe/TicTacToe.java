package ticTacToe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This creates the TicTacToe frame
 * which adds the two panels
 * used to the frame, while also adding
 * a title of whos turn it is.
 * 
 * @author Hans Romang + Joshua Stoddard
 *
 */
@SuppressWarnings("serial")
public class TicTacToe extends JFrame {

	public static String winFile = "src/ticTacToe/winFile.txt";
	private JPanel contentPane;
	private ControlPanel controlPanel;
	private TicTacToeBoardPanel ticTacToeBoardPanel;
	public static JLabel playerTurnLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Writes the file to update 
	 * who has won the current game and
	 * how many times each player has won.
	 */
	public static void fileWriter() {
		try(PrintWriter writer = new PrintWriter(winFile)) {
			if(ControlPanel.isXWinner) {
				writer.println("X Wins! Total score:");
				writer.println("X Wins: " + ControlPanel.xWins);
				writer.println("O Wins: " + ControlPanel.oWins);
				ControlPanel.isXWinner = false;
			}
			else if(ControlPanel.isOWinner) {
				writer.println("O Wins! Total score:");
				writer.println("X Wins: " + ControlPanel.xWins);
				writer.println("O Wins: " + ControlPanel.oWins);
				ControlPanel.isOWinner = false;
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ticTacToeBoardPanel = createTicTacToeBoard();
		contentPane.add(ticTacToeBoardPanel, BorderLayout.CENTER);

		controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.EAST);
		
		JLabel playerTurnLbl = createPlayerTurnLbl();
		contentPane.add(playerTurnLbl, BorderLayout.NORTH);
	}

	/**
	 * Creates the player turn title
	 * at the top of the page.
	 * 
	 * @return the playerTurnLbl
	 */
	private JLabel createPlayerTurnLbl() {
		playerTurnLbl = new JLabel("X's Turn");
		playerTurnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return playerTurnLbl;
	}
	
	/**
	 * Changes the player title depending
	 * on whos turn it is.
	 */
	public static void changePlayerTitle() {
		if(Decider.getPlayer() == 0) {
			playerTurnLbl.setText("X's Turn");
		} else if(Decider.getPlayer() == 1){
			playerTurnLbl.setText("O's Turn");
		}
	}
	
	/**
	 * Resets the player turn title.
	 */
	public static void resetPlayerTurnLbl() {
		playerTurnLbl.setText("X's Turn");
		Decider.setPlayer();
	}

	/**
	 * Creates the ticTacToeBoardPanel,
	 * which contains all the buttons 
	 * on the Tic-Tac-Toe board.
	 * 
	 * @return the ticTacToeBoardPanel
	 */
	private TicTacToeBoardPanel createTicTacToeBoard() {
		ticTacToeBoardPanel = new TicTacToeBoardPanel();
		return ticTacToeBoardPanel;
	}

	/**
	 * Creates the controlPanel, which
	 * contains the control buttons and
	 * win count label.
	 * 
	 * @return the controlPanel
	 */
	private ControlPanel createControlPanel() {
		controlPanel = new ControlPanel();
		return controlPanel;
	}

}
