package uk.tests.trycatch.model;

import uk.tests.trycatch.util.ConstantsUtil;

/**
 * Representation of a Rook piece.
 * 
 * A rook moves any number of vacant squares in an horizontal or vertical direction.
 *
 * @author Jonathan
 *
 */
public class Rook extends Piece {
	
	public Rook(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString() {
		return ConstantsUtil.ROOK + super.toString();
	}
	
	public Boolean isTreatening(Piece p){
		
		// The piece is being threatened by the rook if the piece stays in the same row or the same column
		if(this.getRow() == p.getRow() // Horizontal
				|| this.getCol() == p.getCol() // Vertical 
				)
			return new Boolean(true);
		
		return new Boolean(false);
	}

}
