package uk.tests.trycatch.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import uk.tests.trycatch.model.Board;
import uk.tests.trycatch.util.ConstantsUtil;

public class Main {
	
	public static void main(String[] args) {
		
	    Board board = null;
	    ArrayList<String> pieces = new ArrayList<String>();
	    
	    // Default intput
	    int rows = 7;
	    int cols = 7;
	    int kings = 2;
	    int queens = 2;
	    int bishops = 2;
	    int knights = 1;
	    int rooks = 0;
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("**************************************************************************************" );
		System.out.println("******                      TryCatch.us - Chess Problem                         ******" );
		System.out.println("******                                                                          ******" );
		System.out.println("****** Default input: 7x7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight  ******" );
		System.out.println("**************************************************************************************" );
		System.out.println("");
		System.out.println("[1] Default input." );
		System.out.println("[2] Custom input." );
		System.out.print("Please select an option: " );
	    int  opt = readInt(in, "Please select an option: " );   
	    
	    while (opt < 1 || opt > 2){
			System.out.print("Incorrect value. Please select an option: " );
	    	opt = readInt(in, "Please select an option: " ); 
	    }
	   
	    // Custom board options
	    if(opt == 2){
	    	System.out.println("Please select board's size" );
			System.out.print("Rows: " );
			rows = readInt(in, "Rows: ");
			System.out.print("Columns: " );
			cols = readInt(in, "Columns: ");
			System.out.println();
			System.out.println("Please, for each piece, introduce the number of ocurrences." );
			System.out.print("[K] Kings: " );
			kings = readInt(in, "[K] Kings: ");
			System.out.print("[Q] Queens: " );
			queens = readInt(in, "[Q] Queens: ");
			System.out.print("[B] Bishops: " );
			bishops = readInt(in,"[B] Bishops: ");
			System.out.print("[N] Knights: " );
			knights = readInt(in, "[N] Knights: ");
			System.out.print("[R] Rooks: " );
			rooks = readInt(in, "[R] Rooks: ");
	    	
	    }

	    board = fillboard(rows, cols, kings, queens, bishops, knights, rooks, pieces);

		 HashMap<Integer, Board> boards = new HashMap<Integer, Board>(); 
		 long start = System.currentTimeMillis();
		 Resolve.resolve(board, pieces, boards);
		 
		 System.out.println();
		 System.out.println("***************************************************" );
		 System.out.println("****** Please wait. Calculations in progress ******" );
		 System.out.println("***************************************************" );
		 System.out.println();
		 
		 long step = System.currentTimeMillis();
		 printBoards(boards);
		 long end = System.currentTimeMillis();
		 

		 System.out.println("Timing : " );
		 if ((end - start) > 1000){
			 System.out.println("Searching solutions : " + TimeUnit.MILLISECONDS.toSeconds(step - start) + " seconds");
			 System.out.println("Printing solutions : " + TimeUnit.MILLISECONDS.toSeconds(end - step) + " seconds");
			 System.out.println("Total time : " + TimeUnit.MILLISECONDS.toSeconds(end - start) + " seconds");
		 } else {
			 System.out.println("Searching solutions : " + (step - start) + " ms");
			 System.out.println("Printing solutions : " + (end - step) + " ms");
			 System.out.println("Total time : " + (end - start) + " ms");
		 }
		 
	}


	/**
	 * Fill the board with input pieces
	 */
	private static Board fillboard(int rows, int cols, int kings, int queens,
			int bishops, int knights, int rooks, ArrayList<String> pieces) {

		 Board board = new Board(rows, cols);
			
		 for (int i = 0; i < queens; i++) {
			 pieces.add(ConstantsUtil.QUEEN);
		 }			
		 for (int i = 0; i < bishops; i++) {
			 pieces.add(ConstantsUtil.BISHOP);
		 }			
		 for (int i = 0; i < rooks; i++) {
			 pieces.add(ConstantsUtil.ROOK);
		 }			
		 for (int i = 0; i < knights; i++) {
			 pieces.add(ConstantsUtil.KNIGHT);
		 }			
		 for (int i = 0; i < kings; i++) {
			 pieces.add(ConstantsUtil.KING);
		 }
		 
		 return board;
		
	}


	/**
	 * Read an int from the input. 
	 */
	private static int readInt(Scanner in, String inputStr) {
		int input;
		try {
			input = in.nextInt();
		} catch (Exception e) {
			 System.out.print("Incorrect value. Please try again: " + inputStr );
			 in.next();
			return readInt(in,inputStr);
		}
		return input;
	}


	/**
	 * Print all possible boards 
	 * @param boards
	 */
	private static void printBoards(final HashMap<Integer, Board> boards){
		
		Iterator<Board> it = boards.values().iterator();
		while(it.hasNext()){
			Board board = it.next();
			board.printBoard();
		}
		
		System.out.println("Number of boards: " + boards.size());
		
	}
	
}
