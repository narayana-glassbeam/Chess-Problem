package uk.tests.trycatch.model;

import uk.tests.trycatch.util.ConstantsUtil;

/**
 * Representation of a Bishop piece.
 * 
 * A Bishop moves any number of vacant squares in any diagonal direction.
 * 
 * @author Jonathan
 *
 */
public class Bishop extends Piece {
	
	public Bishop(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString() {
		return ConstantsUtil.BISHOP;
	}

	public Boolean isTreatening(Piece p){
		
		// The piece is being threatened by the Bishop if the piece stays in any square in a diagonal direction.
		if (Math.abs(this.getRow() - p.getRow()) == Math.abs(this.getCol() - p.getCol()))				
			return new Boolean(true);
		
		return new Boolean(false);
	}

}
