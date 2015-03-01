package uk.tests.trycatch.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import uk.tests.trycatch.model.Bishop;
import uk.tests.trycatch.model.Board;
import uk.tests.trycatch.model.King;
import uk.tests.trycatch.model.Knight;
import uk.tests.trycatch.model.Piece;
import uk.tests.trycatch.model.Queen;
import uk.tests.trycatch.model.Rook;
import uk.tests.trycatch.util.ConstantsUtil;

public class Resolve {

	@SuppressWarnings("unchecked")
	public static void resolve(final Board board, final ArrayList<String> piecesLeft, final HashMap<Integer, Board> boards){
		
		String piece = piecesLeft.remove(0);
		for(int row=0; row<board.getRows(); row++){
			for(int col=0; col<board.getColumns(); col++){
				// If it isn't empty skip the iteration
				if(!board.getBoard()[row][col].equals(ConstantsUtil.EMPTY))
					continue;
				
				Piece pieceToPut = newPiece(piece,row, col);
				// Check if it is possible to put the piece into the board safely
				if(!isSafe(pieceToPut, board.getPieces()))
					continue;
				
				Board boardAux = board.copyBoard();
				boardAux.getBoard()[row][col]=piece;
				boardAux.getPieces().add(pieceToPut);
				if(null != boardAux){
					if(piecesLeft.isEmpty()){
						boards.put(boardAux.hashCode(), boardAux);
					}else{
						resolve(boardAux, (ArrayList<String>)piecesLeft.clone(), boards); 
					}
				}
			}
		}
	}
	
	/**
	 * One piece is safe in the board, if the new piece is not threatened by any piece in the board,
	 * and the new piece doesn't attack the other pieces in the board.
	 * @param piece
	 * @param piecesInBoard
	 * @return
	 */
	private static boolean isSafe(Piece piece, List<Piece> piecesInBoard){

		boolean isSafe = true;
		
		for (Iterator<Piece> iterator = piecesInBoard.iterator(); iterator.hasNext();) {
			Piece pieceAux = (Piece) iterator.next();
			isSafe &= !isThreatened(piece, pieceAux);
		}

		return isSafe;
		
	}

	/**
	 * Two pieces are threatened if one attacks the other or vice-versa
	 * 
	 * @param piece1
	 * @param piece2
	 * @return True if one of the pieces is threatened.
	 */
	private static boolean isThreatened(Piece piece1, Piece piece2){
		return (piece1.isTreatening(piece2) || piece2.isTreatening(piece1));
		
	}

	private static Piece newPiece(String pieceType, int row, int col){
		
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
