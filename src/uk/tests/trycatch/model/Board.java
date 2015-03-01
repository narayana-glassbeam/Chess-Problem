package uk.tests.trycatch.model;

import java.util.ArrayList;

import uk.tests.trycatch.util.ConstantsUtil;

/**
 * Representation of a chess board.
 * 
 * columns == Number of columns
 * rows == Number of rows
 * board == Board's positions 
 * 
 * @author Jonathan
 *
 */
public class Board {
	
	public Board(int columns, int rows) {
		super();
		this.columns = columns;
		this.rows = rows;
		this.board = new String[this.rows][this.columns];
		this.pieces= new ArrayList<Piece>();
		this.inizializeBoard();
	}
		
	/** Number of columns */
	private int columns;
	
	/** Number of rows */
	private int rows;

	/** Board's positions */
	private String[][] board;
	
	/** Board's pieces */
	private ArrayList<Piece> pieces;
	
	
	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
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
		
		for(int row=0; row< this.rows; row++){
			for(int col=0; col< this.columns; col++){
				this.board[row][col] = ConstantsUtil.EMPTY;
			}
		}
		
	}
	
	
	/**
	 * Print the board
	 */
	public void printBoard(){
		
		for(int row=0; row< this.rows; row++){
			for(int col=0; col< this.columns; col++){
				System.out.print(this.board[row][col] + " ");
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
	@Override
	public String toString(){
		String result = "";
		
		for(int row=0; row< this.rows; row++){
			for(int col=0; col< this.columns; col++){
				result += this.board[row][col] + " ";
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
		Board copy = new Board(this.columns, this.rows);
		
		for(int row=0; row< this.rows; row++){
			for(int col=0; col< this.columns; col++){
				copy.getBoard()[row][col] = this.board[row][col];
			}
		}
		
		copy.setPieces((ArrayList<Piece>) this.pieces.clone());
		return copy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
