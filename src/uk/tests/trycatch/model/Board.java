package uk.tests.trycatch.model;

import java.util.ArrayList;

import uk.tests.trycatch.util.ConstantsUtil;

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
		this.pieces= new ArrayList<Piece>();
		this.inizializeBoard();
	}
		
	/** Number of rows */
	private int width;
	
	/** Number of columns */
	private int height;

	/** Board's positions */
	private String[][] board;
	
	/** Board's pieces */
	private ArrayList<Piece> pieces;
	
	
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
	
	
	/**
	 * @return the pieces
	 */
	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	/**
	 * Initialize the board
	 */
	private void inizializeBoard(){		
		
		for(int i=0; i< this.width; i++){
			for(int j=0; j< this.height; j++){
				this.board[i][j] = ConstantsUtil.STATE_FREE;
			}
		}
		
	}
	
	
	/**
	 * Print the board
	 */
	public void printBoard(){
		
		for(int i=0; i< this.width; i++){
			for(int j=0; j< this.height; j++){
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}

		System.out.print("Pieces position for this board: " + this.pieces);
		System.out.println();
		System.out.println();
	}
	
	/**
	 * For debugging purpose
	 */
	public String toString(){
		String result = "";
		
		for(int i=0; i< this.width; i++){
			for(int j=0; j< this.height; j++){
				result += this.board[i][j] + " ";
			}
			result += "\n";
		}

		return result;
	}
	
	
	/**
	 * Copy the board
	 */
	@SuppressWarnings("unchecked")
	public Board copyBoard(){
		Board copy = new Board(this.width, this.height);
		
		for(int i=0; i< this.width; i++){
			for(int j=0; j< this.height; j++){
				copy.getBoard()[i][j] = this.board[i][j];
			}
		}
		
		copy.setPieces((ArrayList<Piece>) this.pieces.clone());
		return copy;
	}
}
