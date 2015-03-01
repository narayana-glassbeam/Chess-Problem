Problem
=======

The problem is to find all unique configurations of a set of normal chess pieces on a chess board with dimensions M×N where none of the pieces is in a position to take any of the others. Assume the colour of the piece does not matter, and that there are no pawns among the pieces.

Write a program which takes as input:
	- The dimensions of the board: M, N.
	- The number of pieces of each type (King, Queen, Bishop, Rook and Knight) to try and place on the board.

As output, the program should list all the unique configurations to the console for which all of the pieces can be placed on the board without threatening each other.

When returning your solution, please provide with your answer the total number of unique configurations for a **7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight.**

Example
-------

Input: 3×3 board containing 2 Kings and 1 Rook.

**K** | **-** | **K** |  
**-** | **-** | **-** | 
**-** | **R** | **-** | 

**K** | **-** | **-** | 
**-** | **-** | **R** | 
**K** | **-** | **-** | 

**-** | **-** | **K** |  
**R** | **-** | **-** | 
**-** | **-** | **K** |  

**-** | **R** | **-** | 
**-** | **-** | **-** | 
**K** | **-** | **K** |  


Solution
--------
This problem is solved recursively by solving increasingly smaller problems.

The procedure is as follows.
- The first available piece is taken. We then try to put it in every spare board position. (N candidate boards could be generated. N = free squares in the board)

- There are 3 possibilities:
1. The piece attacks other piece, or the piece is threatened (attacked) by one of the other pieces in the board. This board is not a solution. Find the next free square.
2. The piece is placed safely and it is not the last one. A partial solution has been reached. Repeat the process with the following pieces.
3. The piece is placed safely and it is the last one of the pieces. A solution has been reached.



