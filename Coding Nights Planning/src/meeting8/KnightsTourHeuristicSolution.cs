using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KnightsTourC
{
    class KnightsTourC
    {

        private const int row = 8;
        private const int col = 8;
        static bool exit = false;

        static int[,] chessboard = new int[row, col]{
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0}
            };

        static int[,] accessibility = new int[row, col] {
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

        static int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
        static int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };

        static int currentRow, currentColumn;


        static void Main(string[] args)
        {
            int counter = 1;
            int move = 0;

            // generate initial starting point
            Random rand = new Random();
            int rand1 = rand.Next(0, row);
            int rand2 = rand.Next(0, col);
            currentRow = rand1;
            currentColumn = rand2;
            chessboard[currentRow, currentColumn] = counter;
        
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

                chessboard[currentRow, currentColumn] = counter;
              

            }

            // print Chessboard
            int j, k;

            for (j = 0; j < 8; j++)
            {
                for (k = 0; k < 8; k++)
                {
                    Console.Write(chessboard[j, k] + "  ");
                    if (k == 7)
                    {
                        Console.WriteLine();
                    }
                }
            }

            Console.WriteLine();
            Console.Write("The tour ended with " + counter + " moves.\n");

            if (counter == 64)
            {
                Console.Write("This was a full tour.\n");
            }

            else
            {
                Console.Write("This was not a full tour.\n");
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
                if ((0 <= Row && Row < row) 
                    && (0 <= Column && Column < col) 
                    && chessboard[Row,Column] == 0)

                {
                    // now check if this valid move is the least accessible
                    if (accessibility[Row, Column] <= least)
                    {
                        // if something valid that is lower or equal found, update least accessible move
                        least = accessibility[Row, Column];
                        move = i;
                    }
                }
            }

            // if no more valid moves, move variable will not be updated and will be negative
            return move;
        }

    }
}