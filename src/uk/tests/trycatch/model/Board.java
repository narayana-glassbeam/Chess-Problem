package uk.tests.trycatch.model;


/**
 * Representation of a chess board.
 * 
 * width == Number of columns
 * height == Number of rows
 * board == Board's positions 
 * 
 * @author Jonathan
 *
 */
public class Board {
	
	public Board(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.board = new String[this.width][this.height];
	}
		
	/** Number of rows */
	private int width;
	
	/** Number of columns */
	private int height;

	/** Board's positions */
	private String[][] board;
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	
	/**
	 * @return the board
	 */
	public String[][] getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(String[][] board) {
		this.board = board;
	}


	public void printBoard(){
		
		for(int i=0; i< this.width; i++){
			for(int j=0; j< this.height; j++){
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}

	public Board copyBoard(){
		Board copy = new Board(this.width, this.height);
		
		for(int i=0; i< this.width; i++){
			for(int j=0; j< this.height; j++){
				copy.getBoard()[i][j] = this.board[i][j];
			}
		}
		return copy;
	}
}
