package uk.tests.trycatch.model;

import uk.tests.trycatch.util.ConstantsUtil;

/**
 * Factory pattern 
 * 
 * @author Jonathan
 *
 */
public class PieceFactory {
		
		/**
		 * Get an object of type piece in the default position [0,0]
		 * 
		 * @param pieceType
		 * @return
		 */
	   public Piece getPiece(String pieceType){
		   if(ConstantsUtil.KING.equals(pieceType)){
	 			return new King();
	 		} else if(ConstantsUtil.ROOK.equals(pieceType)){
	 			return new Rook();
	 		} if(ConstantsUtil.KNIGHT.equals(pieceType)){
	 			return new Knight();
	 		} else if(ConstantsUtil.QUEEN.equals(pieceType)){
	 			return new Queen();
	 		} else if(ConstantsUtil.BISHOP.equals(pieceType)){
	 			return new Bishop();
	 		} else return null;
	   }
	      
	    /**
	     * Get an objecto of type piece in the default position  
	     *   
	     * @param pieceType
	     * @param row
	     * @param col
	     * @return
	     */
	   public Piece getPiece(String pieceType, int row, int col){
	      	if(ConstantsUtil.KING.equals(pieceType)){
	 			return new King(row, col);
	 		} else if(ConstantsUtil.ROOK.equals(pieceType)){
	 			return new Rook(row, col);
	 		} if(ConstantsUtil.KNIGHT.equals(pieceType)){
	 			return new Knight(row, col);
	 		} else if(ConstantsUtil.QUEEN.equals(pieceType)){
	 			return new Queen(row, col);
	 		} else if(ConstantsUtil.BISHOP.equals(pieceType)){
	 			return new Bishop(row, col);
	 		} else return null;

	  }
		      
}
