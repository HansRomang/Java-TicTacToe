package ticTacToe;

/**
 * 
 * The Decider class creates functionality for
 * winning games, keeping track of which player's turn it is,
 * and updating data to the ControlPanel class. 
 * @author Hans Romang + Joshua Stoddard
 *
 */
public class Decider {
	
	private static int playerTrack = 0;

	/**
	 * Sets the player to 0 (For starting games as X)
	 */
	public static void setPlayer() {
		playerTrack = 0;
	}
	
	/**
	 * gets the current player (X or O)
	 * @return the current player (X or O, represented by 0 or 1)
	 */
	public static int getPlayer() {
		return playerTrack;
	}

	/**
	 * Alternates the player's names based on whose turn it is.
	 */
	public static void alternateNames() {
		if(playerTrack == 0) {
			playerTrack = 1;
		}else {
			playerTrack = 0;
		}
	}
	
	/**
	 * Runs calculate methods to figure out who's the winner of the game.
	 */
	public static void calculateWinner(){
		rowCalculate();
		columnCalculate();
		diagonalCalculate();
	}

	/**
	 * If there's a full 3 tiles of either X or O diagonally, award the respective player a win.
	 */
	private static void diagonalCalculate() {
		//First Diagonal X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(0) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(8) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//First Diagonal O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(0) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(8) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
		//Second Diagonal X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(2) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(6) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//Second Diagonal O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(2) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(6) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
	}
	
	/**
	 * If there's a full 3 tiles of either X or O vertically, award the respective player a win.
	 */
	private static void columnCalculate() {
		//First Column X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(0) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(3) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(6) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//First Column O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(0) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(3) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(6) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
		//Second Column X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(1) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(7) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//Second Column O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(1) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(7) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
		//Third Column X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(2) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(5) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(8) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//Third Column O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(2) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(5) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(8) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
	}
	
	/**
	 * If there's a full 3 tiles of either X or O horizontally, award the respective player a win.
	 */
	private static void rowCalculate() {
		//First Row X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(0) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(1) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(2) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//First Row O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(0) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(1) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(2) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
		//Second Row X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(3) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(5) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//Second Row O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(3) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(4) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(5) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
		//Third Row X Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(6) == 0 && TicTacToeBoardPanel.getBtn_playerValueArray(7) == 0 & TicTacToeBoardPanel.getBtn_playerValueArray(8) == 0) {
			ControlPanel.xWins++;
			ControlPanel.updateXWins();
		} 
		//Third Row O Win
		if(TicTacToeBoardPanel.getBtn_playerValueArray(6) == 1 && TicTacToeBoardPanel.getBtn_playerValueArray(7) == 1 & TicTacToeBoardPanel.getBtn_playerValueArray(8) == 1) {
			ControlPanel.oWins++;
			ControlPanel.updateOWins();
		}
	}
}
