/**
 * 
 * @author Kush
 *
 */

/*
 * This program runs a game of TicTacToe
 */

public class TicTacToe {
	
	//Initializing variables
	private int nRows;
	private int nColumns;
	private int numToWin;
	private char[][] grid;
	private char turn;
	private TicTacToeEnum gameState;
	private int nMarks;

	public TicTacToe(char initialTurn) {		//Sets default grid size to 3x3 and 3 in a row to win
		this(3, 3, 3, initialTurn);

	}

	public TicTacToe(int nRows, int nColumns, int numToWin, char initialTurn) {		//Sets grid size and number to win to preferred user values
		if (nRows < 1 || nColumns < 1 || numToWin < 1 || initialTurn < 1)		// Checks negative values
			throw new IllegalArgumentException("Invalid input");
		if (nRows < numToWin || nColumns < numToWin)		// Checks other invalid values
			throw new IllegalArgumentException("Invalid input");
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.numToWin = numToWin;
		this.turn = initialTurn;
		this.gameState = TicTacToeEnum.IN_PROGRESS;		//Initializes game state to "IN_PROGRESS"
		grid = new char[this.nRows][this.nColumns];		//Makes grid with 2D array
		reset(this.turn);
	}

	public void reset(char initialTurn) {		//Clears up grid
		this.turn = initialTurn;
		this.nMarks = 0;
		for (int i = 0; i < this.nRows; i++) {		
			for (int j = 0; j < this.nColumns; j++) {
				this.grid[i][j] = ' ';
			}
		}
	}

	public int getTurn() {		//Switches turns between players, except for initial turn
		if (this.nMarks == 0) {
			return this.turn;
		}
		if (turn == 'X') {
			this.turn = 'O';
		} else {
			this.turn = 'X';
		}
		return this.turn;
	}

	public TicTacToeEnum getGameState() {		//Returns the game state
		return this.gameState;
	}

	private TicTacToeEnum charToEnum(char player) {		//Changes game state to either a winner or a draw
		if (player == 'X') {
			this.gameState = TicTacToeEnum.X_WON;
		} else if (player == 'O') {
			this.gameState = TicTacToeEnum.O_WON;
		} else {
			this.gameState = TicTacToeEnum.DRAW;
		}
		return getGameState();
	}

	public TicTacToeEnum takeTurn(int row, int column) {		//Puts player mark in grid then updates game state using the findWinner method
		getTurn();
		this.grid[row][column] = this.turn;
		this.nMarks++;
		this.gameState = findWinner();

		return this.gameState;
	}

	private TicTacToeEnum findWinner() {		//Finds a winner
		char[] row = new char[this.numToWin];
		char[] column = new char[this.numToWin];
		char[] xWin = new char[this.numToWin];
		char[] oWin = new char[this.numToWin];
		for (int i = 0; i < this.numToWin; i++) {		//Sets array sizes to the number to win
			xWin[i] = 'X';
			oWin[i] = 'O';
		}
		for (int i = 0; i < this.nRows; i++) {		//Scans rows and columns
			for (int j = 0; j < this.nColumns; j++) {
				row[i] = this.grid[i][j];
				column[j] = this.grid[j][i];
			}
			if (row == xWin || row == oWin || column == xWin || column == oWin) {		//Compares multiple arrays to find a winner
				return charToEnum(this.turn);
			}
		}
		if (this.nMarks == (this.nRows * this.nColumns)) {		//If the number of marks is equal to the area of the grid, the game state returns "DRAW"
			return charToEnum('D');
		}
		return TicTacToeEnum.IN_PROGRESS;		//If nothing is found then the game continues
	}

	public String toString() {		//Converts array to string 
		String outGrid = "";
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				outGrid += (this.grid[i][j] + " | ");
			}
			outGrid += "\n";
		}
		return outGrid;
	}
}
