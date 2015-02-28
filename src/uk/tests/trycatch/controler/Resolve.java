package uk.tests.trycatch.controler;

import java.util.ArrayList;
import java.util.Iterator;

import uk.tests.trycatch.model.Board;
import uk.tests.trycatch.util.ConstantsUtil;

public class Resolve {

	public static void main(String[] args) {

		Board board = new Board(3, 3);
		
		 ArrayList<String> pieces = new ArrayList<String>();
		 pieces.add(ConstantsUtil.ROOK);	 
		 pieces.add(ConstantsUtil.ROOK);	 

		 ArrayList<Board> boards = new ArrayList<Board>(); 
		 resolve(board, pieces, boards);
		 printBoards(boards);
 
	}


	@SuppressWarnings("unchecked")
	public static void resolve(final Board board, final ArrayList<String> pieces, final ArrayList<Board> boards){
		
		String piece = pieces.remove(0);
		for(int row=0; row<board.getWidth(); row++){
			for(int col=0; col<board.getHeight(); col++){
				// If it isn't empty skip the iteration
				if(!board.getBoard()[row][col].equals(ConstantsUtil.STATE_FREE))
					continue;
				
				Board boardAux = board.copyBoard();
				boardAux.getBoard()[row][col]=piece;
				if(null != boardAux){
					if(pieces.isEmpty()){						
						boards.add(boardAux);
					}else{
						resolve(boardAux, (ArrayList<String>)pieces.clone(), boards); 
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
	
}
