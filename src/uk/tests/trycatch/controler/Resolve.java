package uk.tests.trycatch.controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uk.tests.trycatch.model.Board;
import uk.tests.trycatch.model.King;
import uk.tests.trycatch.model.Piece;
import uk.tests.trycatch.model.Rook;
import uk.tests.trycatch.util.ConstantsUtil;

public class Resolve {

	public static void main(String[] args) {

		Board board = new Board(3, 3);
		
		 ArrayList<String> pieces = new ArrayList<String>();
		 pieces.add(ConstantsUtil.KING);
		 pieces.add(ConstantsUtil.KING);
		 pieces.add(ConstantsUtil.ROOK);

		 ArrayList<Board> boards = new ArrayList<Board>(); 
		 resolve(board, pieces, boards);
		 printBoards(boards);
 
	}


	@SuppressWarnings("unchecked")
	public static void resolve(final Board board, final ArrayList<String> piecesLeft, final ArrayList<Board> boards){
		
		String piece = piecesLeft.remove(0);
		for(int row=0; row<board.getWidth(); row++){
			for(int col=0; col<board.getHeight(); col++){
				// If it isn't empty skip the iteration
				if(!board.getBoard()[row][col].equals(ConstantsUtil.STATE_FREE))
					continue;
				
				Piece pieceToPut = newPiece(piece,row, col);
				// Check if is it possible put the piece into the board safely
				if(!isSafe(pieceToPut, board.getPieces()))
					continue;
				
				Board boardAux = board.copyBoard();
				boardAux.getBoard()[row][col]=piece;
				boardAux.getPieces().add(pieceToPut);
				if(null != boardAux){
					if(piecesLeft.isEmpty()){						
						boards.add(boardAux);
					}else{
						resolve(boardAux, (ArrayList<String>)piecesLeft.clone(), boards); 
					}
				}
			}
		}
	}
	

	private static void printBoards(final ArrayList<Board> boards){
		
		Iterator<Board> it = boards.iterator();
		while(it.hasNext()){
			Board board = it.next();
			board.printBoard();
		}
		
		System.out.println("Board's number: " + boards.size());
		
	}
	
	private static boolean isSafe(Piece piece, List<Piece> piecesInBoard){

		boolean isSafe = true;
		
		for (Iterator<Piece> iterator = piecesInBoard.iterator(); iterator.hasNext();) {
			Piece pieceAux = (Piece) iterator.next();
			isSafe &= !isThreatened(piece, pieceAux);
		}

		return isSafe;
		
	}

	private static boolean isThreatened(Piece piece1, Piece piece2){
		return (piece1.isTreatening(piece2) || piece2.isTreatening(piece1));
		
	}

	private static Piece newPiece(String pieceType, int row, int col){
		
		if(ConstantsUtil.KING.equals(pieceType)){
			return new King(row, col);
		} else if(ConstantsUtil.ROOK.equals(pieceType)){
			return new Rook(row, col);
		} else return null;
		
	}
	
	
}
