package meeting8;

import java.util.Random;

public class KnightsTourHeuristic {
	
	 public final static int ROW = 8;
     public final static int COL = 8;
     public static boolean exit = false;
     
     public static int[][] chessboard = new int[][]{
             { 0,0,0,0,0,0,0,0},
             { 0,0,0,0,0,0,0,0},
             { 0,0,0,0,0,0,0,0},
             { 0,0,0,0,0,0,0,0},
             { 0,0,0,0,0,0,0,0},
             { 0,0,0,0,0,0,0,0},
             { 0,0,0,0,0,0,0,0},
             { 0,0,0,0,0,0,0,0}
         };

     public static int[][] accessibility = new int[][] {
             {2,3,4,4,4,4,3,2},
             {3,4,6,6,6,6,4,3},
             {4,6,8,8,8,8,6,4},
             {4,6,8,8,8,8,6,4},
             {4,6,8,8,8,8,6,4},
             {4,6,8,8,8,8,6,4},
             {3,4,6,6,6,6,4,3},
             {2,3,4,4,4,4,3,2}
         };

     // 8 possible moves:
     // Move 0: horizontal[ 0 ] = 2 vertical[ 0 ] = -1
     // Move 1: horizontal[ 1 ] = 1 vertical[ 1 ] = -2
     // Move 2: horizontal[ 2 ] = -1 vertical[ 2 ] = -2
     // Move 3: horizontal[ 3 ] = -2 vertical[ 3 ] = -1
     // Move 4: horizontal[ 4 ] = -2 vertical[ 4 ] = 1
     // Move 5: horizontal[ 5 ] = -1 vertical[ 5 ] = 2
     // Move 6: horizontal[ 6 ] = 1 vertical[ 6 ] = 2
     // Move 7: horizontal[ 7 ] = 2 vertical[ 7 ] = 1

     public static int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
     public static int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };

     public static int currentRow, currentColumn;


     public static void main(String[] args)
     {
         int counter = 1;
         int move = 0;

         // generate initial starting point
         Random rand = new Random();
         int rand1 = rand.nextInt(ROW - 1) + 1;
         int rand2 = rand.nextInt(COL - 1) + 1;
         currentRow = rand1;
         currentColumn = rand2;
         chessboard[currentRow][currentColumn] = counter;
     
         while ((counter <= 64) && !exit)
         {
             counter++;
             if (counter == 65)
             {
                 counter--;
             }
             // get the next valid move
             move = getmove();

             if (0 <= move)
             {
                 // update current position based on next move
                 currentRow += vertical[move];
                 currentColumn += horizontal[move];
             }

             // no more valid moves
             else
             {
                 exit = true;
             }

             chessboard[currentRow][currentColumn] = counter;
           

         }

         // print Chessboard
         int j, k;

         for (j = 0; j < 8; j++)
         {
             for (k = 0; k < 8; k++)
             {
            	 System.out.format("%4d", chessboard[j][k]);
                 if (k == 7)
                 {
                	 System.out.println();
                 }
             }
         }

         System.out.println();
         System.out.println("The tour ended with " + counter + " moves.");

         if (counter == 64)
         {
        	 System.out.println("This was a full tour.");
         }

         else
         {
             System.out.println("This was not a full tour.");
         }

     }

     public static int getmove()
     {
         // return least accessible valid move as the next move
         // max accessibility is 8 based on clean board
         int least = 8;
         int move = -1;

         // temporary variables
         int Row, Column;

         // find valid move
         for (int i=0; i < 8; i++)
         {
             Row = currentRow + vertical[i];
             Column = currentColumn + horizontal[i];

             // is this a valid move? (within the array and spot empty)
             if ((0 <= Row && Row < ROW) 
                 && (0 <= Column && Column < COL) 
                 && chessboard[Row][Column] == 0)

             {
                 // now check if this valid move is the least accessible
                 if (accessibility[Row][Column] <= least)
                 {
                     // if something valid that is lower or equal found, update least accessible move
                     least = accessibility[Row][Column];
                     move = i;
                 }
             }
         }

         // if no more valid moves, move variable will not be updated and will be negative
         return move;
     }
        	      
	}
	
