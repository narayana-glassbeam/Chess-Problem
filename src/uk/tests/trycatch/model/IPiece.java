package uk.tests.trycatch.model;

/**
 * Abstract class for all board's pieces
 * 
 * @author Jonathan
 *
 */
public interface  IPiece {


	/**
	 * Checks if the piece p is being threatened by this piece.
	 * 	
	 * @param p
	 *
	 * @return True if the piece is treatened
	 */
	abstract Boolean isTreatening(Piece p);


}
