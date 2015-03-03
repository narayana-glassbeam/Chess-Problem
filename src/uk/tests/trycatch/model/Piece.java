package uk.tests.trycatch.model;


/**
 * Abstract class for all board's pieces
 * 
 * @author Jonathan
 *
 */
public abstract class Piece implements IPiece {

	// Position inside the row
	private int row;
	
	// Position inside the column
	private int col;
	

	public Piece(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}
	
}
