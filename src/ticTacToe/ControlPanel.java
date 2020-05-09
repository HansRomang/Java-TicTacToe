package ticTacToe;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This creates the control panel
 * which includes the clear and reset 
 * buttons, and the win count labels.
 * 
 * @author Hans Romang + Joshua Stoddard
 * 
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	
	public static boolean isXWinner = false;
	public static boolean isOWinner = false;
	public static int xWins = 0;
	public static int oWins = 0;
	private static JLabel xWinsLbl;
	private static JLabel oWinsLbl;

	/**
	 * Creates the control panel and
	 * adds the exit and reset buttons 
	 * and win count labels to said panel.
	 */
	public ControlPanel() {
		setLayout(new GridLayout(4, 0, 0, 0));
		
		JButton clearBtn = createClearBtn();
		add(clearBtn);
		
		JButton resetBtn = createResetBtn();
		add(resetBtn);
		
		JLabel xWinsLbl = createXWinsLbl();
		add(xWinsLbl);
		
		JLabel oWinsLbl = createOWinsLbl();
		add(oWinsLbl);
	}
	
	/**
	 * Creates the clear button, which
	 * clears the current game.
	 * 
	 * @return the clearBtn
	 */
	private JButton createClearBtn() {
		JButton clearBtn = new JButton("Clear\n");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 9; i++) {
					TicTacToeBoardPanel.xOrOBtnArray[i].setIcon(null);
					TicTacToeBoardPanel.xOrOBtnArray[i].setEnabled(true);
					TicTacToeBoardPanel.setBtn_playerValueArray(i, 2);
					TicTacToe.resetPlayerTurnLbl();
				}
				TicTacToeBoardPanel.btnTracker.clear();
			}
		});
		return clearBtn;
	}
	
	/**
	 * Creates the reset button, which
	 * resets the win counters.
	 * 
	 * @return the resetBtn
	 */
	private JButton createResetBtn() {
		JButton resetBtn = new JButton("<html>Reset Win<br /><center>Count</center></html>");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xWins = 0;
				oWins = 0;
				xWinsLbl.setText("X Wins: " + xWins);
				oWinsLbl.setText("O Wins: " + oWins);
				for(int i = 0; i < 9; i++) {
					TicTacToeBoardPanel.xOrOBtnArray[i].setIcon(null);
					TicTacToeBoardPanel.xOrOBtnArray[i].setEnabled(true);
					TicTacToeBoardPanel.setBtn_playerValueArray(i, 2);
					TicTacToe.resetPlayerTurnLbl();
				}
				TicTacToeBoardPanel.btnTracker.clear();
			}
		});
		return resetBtn;
	}
	
	/**
	 * Creates the X Wins Label, which
	 * keeps track of the number of X wins.
	 * 
	 * @return the xWinsLbl
	 */
	private JLabel createXWinsLbl() {
		xWinsLbl = new JLabel("X Wins: " + xWins);
		xWinsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return xWinsLbl;
	}

	/**
	 * Creates the O Wins Label, which
	 * keeps track of the number of O wins.
	 * 
	 * @return the oWinsLbl
	 */
	private JLabel createOWinsLbl() {
		oWinsLbl = new JLabel("O Wins: " + oWins);
		oWinsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return oWinsLbl;
	}
	
	/**
	 * Updates number of times X has
	 * won and disables the board until the
	 * clear button is clicked.
	 */
	public static void updateXWins() {
		xWinsLbl.setText("X Wins: " + xWins);
		isXWinner = true;
		TicTacToe.fileWriter();
		for(int i = 0; i < 9; i++) {
			TicTacToeBoardPanel.xOrOBtnArray[i].setEnabled(false);
		}
	}
	
	/**
	 * Updates the number of times O has
	 * won and disables the board until the
	 * clear button is clicked.
	 */
	public static void updateOWins() {
		oWinsLbl.setText("O Wins: " + oWins);
		isOWinner = true;
		TicTacToe.fileWriter();
		for(int i = 0; i < 9; i++) {
			TicTacToeBoardPanel.xOrOBtnArray[i].setEnabled(false);
		}
	}

}
