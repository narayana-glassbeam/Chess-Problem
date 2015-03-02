package uk.tests.trycatch.model;

import uk.tests.trycatch.util.ConstantsUtil;

/**
 * Representation of a Knight piece.
 * 
 * A Knight moves to the nearest square not on the same rank, file, or diagonal. 
 * 
 * @author Jonathan
 *
 */
public class Knight extends Piece {
	
	public Knight(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString() {
		return ConstantsUtil.KNIGHT;
	}

	public Boolean isTreatening(Piece p){
		
		// The piece is being threatened by the Knight if the piece stays in any square in a horizontal, vertical, or diagonal direction.
		if( Math.abs(Math.abs(this.getRow() - p.getRow()) - Math.abs(this.getCol() - p.getCol())) == 1) 
			return new Boolean(true);
		
		return new Boolean(false);
	}

}
