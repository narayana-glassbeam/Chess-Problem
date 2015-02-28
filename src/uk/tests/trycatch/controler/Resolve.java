package uk.tests.trycatch.controler;

import java.util.ArrayList;
import java.util.Iterator;

import uk.tests.trycatch.model.Board;

public class Resolve {

	public static void main(String[] args) {

		Board board = new Board(2, 2);
		
		 ArrayList<String> pieces = new ArrayList<String>();
		 pieces.add("R");		 

		 ArrayList<Board> boards = new ArrayList<Board>(); 
		 resolve(board, pieces, boards);
		 printBoards(boards);
 
	}


	@SuppressWarnings("unchecked")
	public static void resolve(final Board board, final ArrayList<String> pieces, final ArrayList<Board> boards){
		
		pieces.remove(0);
		for(int row=0; row<board.getWidth(); row++){
			for(int col=0; col<board.getHeight(); col++){	
				Board boardAux = board.copyBoard();
				boardAux.getBoard()[row][col]="R";
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
