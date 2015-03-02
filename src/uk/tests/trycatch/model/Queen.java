package uk.tests.trycatch.model;

import uk.tests.trycatch.util.ConstantsUtil;

/**
 * Representation of a Queen piece.
 * 
 * A Queen moves any number of vacant squares in a horizontal, vertical, or diagonal direction.
 * 
 * @author Jonathan
 *
 */
public class Queen extends Piece {
	
	public Queen(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString() {
		return ConstantsUtil.QUEEN;
	}

	public Boolean isTreatening(Piece p){
		
		// The piece is being threatened by the Queen if the piece stays in any square in a horizontal, vertical, or diagonal direction.
		if(  this.getRow() == p.getRow() // Horizontal
				|| this.getCol() == p.getCol() // Vertical      
				|| (Math.abs(this.getRow() - p.getRow()) == Math.abs(this.getCol() - p.getCol())) // Diagonal 
				)
			return new Boolean(true);
		
		return new Boolean(false);
	}

}
