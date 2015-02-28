package uk.tests.trycatch.model;

import uk.tests.trycatch.util.ConstantsUtil;

/**
 * Representation of a Rook piece.
 *
 * @author Jonathan
 *
 */
public class Rook extends Piece {
	
	public Rook(int row, int col) {
		super(row, col);
	}
	
	
	public String print(){
		return ConstantsUtil.ROOK;
	}

}
