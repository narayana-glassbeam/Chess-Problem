package uk.tests.trycatch.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import uk.tests.trycatch.model.Board;
import uk.tests.trycatch.model.Piece;
import uk.tests.trycatch.util.ConstantsUtil;

public class Main {
	
	public static void main(String[] args) {
		
	    Board board = null;
	    
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

		System.out.println();
		System.out.println();

	    board = fillboard(rows, cols, kings, queens, bishops, knights, rooks);

		 HashMap<Integer, Board> boards = new HashMap<Integer, Board>(); 
		 long start = System.currentTimeMillis();
		 
		 Resolve resolve = new Resolve();
		 
		 resolve.resolve(board, boards, new HashMap<String, Piece>());
		 		
		 long end = System.currentTimeMillis();
		 
		 long totalTime = end - start;

		System.out.println("Number of boards: " + boards.size());

		 if (totalTime > 60000){
			 System.out.println("Total time : " + TimeUnit.MILLISECONDS.toMinutes(totalTime) + " minutes " + (TimeUnit.MILLISECONDS.toSeconds(totalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))) + " seconds");
		 } else if (totalTime > 1000){
			 System.out.println("Total time : " + TimeUnit.MILLISECONDS.toSeconds(totalTime) + " seconds");
		 } else {
			 System.out.println("Total time : " + (totalTime) + " ms");
		 }
		 
	}


	/**
	 * Fill the board with input pieces
	 */
	private static Board fillboard(int rows, int cols, int kings, int queens,
			int bishops, int knights, int rooks) {

		 Board board = new Board(rows, cols);
		
		 ArrayList<String> remainingPieces = board.getRemainingPieces();
		 
		 for (int i = 0; i < queens; i++) {
			 remainingPieces.add(ConstantsUtil.QUEEN);
		 }			
		 for (int i = 0; i < bishops; i++) {
			 remainingPieces.add(ConstantsUtil.BISHOP);
		 }			
		 for (int i = 0; i < rooks; i++) {
			 remainingPieces.add(ConstantsUtil.ROOK);
		 }			
		 for (int i = 0; i < knights; i++) {
			 remainingPieces.add(ConstantsUtil.KNIGHT);
		 }			
		 for (int i = 0; i < kings; i++) {
			 remainingPieces.add(ConstantsUtil.KING);
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
	
}
