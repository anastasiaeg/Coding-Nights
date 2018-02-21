using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project
{

    class KnightsTourB
    {
        private const int row = 8;
        private const int col = 8;

        static void Main(string[] args)
        {

            int[,] chessboard = new int[row, col]{
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0}
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

            int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
            int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };

            int currentRow, currentColumn;

            // counter for each move; max moves is 64
            int counter = 1;

            // generate initial starting point
            Random rand = new Random();
            int rand1 = rand.Next(0, row);
            int rand2 = rand.Next(0, col);
            currentRow = rand1;
            currentColumn = rand2;
            chessboard[currentRow, currentColumn] = counter;
            // exit variable ; once no more valid moves, set exit to true
            bool exit = false;


            // continue taking moves until board is full or no valid moves
            while ( (counter < 64) && !exit)
            {
                // increment counter for each move
                counter++;

                int i;
                for ( i = 0; i < 8; i++)
                {
                    currentRow += vertical[i];
                    currentColumn += horizontal[i];

                    // is there a valid move?
                    if (0 <= currentRow && currentRow < row && 0 <= currentColumn && currentColumn < col && chessboard[currentRow, currentColumn] == 0)
                    {

                        chessboard[currentRow, currentColumn] = counter;
                        // stop trying moves once valid move is found
                        exit = false;
                        break;
                    }

                    // if not valid, reset
                    else
                    {
                        currentRow -= vertical[i];
                        currentColumn -= horizontal[i];
                        exit = true;
                    }

                    // if exit = true when leaving for loop, there are no more valid moves
                }
                      
            }
            counter--;

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
            Console.Write("The tour ended with " + counter + " moves.\n" );

            if (counter == 64)
            {
                Console.Write("This was a full tour.\n");
            }

            else
            {
                Console.Write("This was not a full tour.\n");
            }
        }


       
    }
}
