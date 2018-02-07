package meeting7;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Checks if the given 2 x 2 array is a valid sudoku
 * @author Anastasia Egorova
 *
 */
public class Sudoku {
	public static void main(String[] args) {
		int[][] matrix = {	{5, 3, 0, 0, 7, 0, 0, 0, 0},
							{6, 0, 0, 1, 9, 5, 0, 0, 0},
							{0, 9, 8, 0, 0, 0, 0, 6, 0},
							{8, 0, 0, 0, 6, 0, 0, 0, 3},
							{4, 0, 0, 8, 0, 3, 0, 0, 1},
							{7, 0, 0, 0, 2, 0, 0, 0, 6},
							{0, 6, 0, 0, 0, 0, 2, 8, 0},
							{0, 0, 0, 4, 1, 9, 0, 0, 5},
							{0, 0, 0, 0, 8, 0, 0, 7, 9}};
		
		int[][] anotherValidMatrix = {	{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0}};
		
		int[][] invalidMatrix = {	{5, 3, 0, 0, 7, 0, 0, 0, 0},
									{6, 0, 3, 1, 9, 5, 0, 0, 0},
									{0, 9, 8, 0, 0, 0, 0, 6, 0},
									{8, 0, 0, 0, 6, 0, 0, 0, 3},
									{4, 0, 0, 8, 0, 3, 0, 0, 1},
									{7, 0, 0, 0, 2, 0, 0, 0, 6},
									{0, 6, 0, 0, 0, 0, 2, 8, 0},
									{0, 0, 0, 4, 1, 9, 0, 0, 5},
									{0, 0, 0, 0, 8, 0, 0, 7, 9}};
		
		System.out.println("Matrix is " + (isValid(matrix)?"a valid ":"an invalid ") + "sudoku pattern");
		System.out.println("Matrix is " + (isValid(invalidMatrix)?"a valid ":"an invalid ") + "sudoku pattern");
		System.out.println("Matrix is " + (isValidOfficial(anotherValidMatrix)?"a valid ":"an invalid ") + "sudoku pattern");

		
	}
	
	/**
	 * This method returns true if the sudoku is valid,
	 * it prioritizes speed over memory!!!
	 * O(n^2)
	 * Anastasia's solution
	 * @param matrix
	 * @return
	 */
	public static Boolean isValid(int[][] matrix) {
		
		ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
		ArrayList<HashSet<Integer>> cubes = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < 9; i++) {
			cols.add(new HashSet<Integer>());
			cubes.add(new HashSet<Integer>());
		}
		    
		for (int i = 0; i < matrix.length; i++) {
			//Current row
			HashSet<Integer> row = new HashSet<Integer>();
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) continue;
				if (!row.add(matrix[i][j]) || !cols.get(i).add(matrix[i][j]) || !cubes.get(i / 3 + j / 3 * 3).add(matrix[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Official solution from the internets
	 * @param matrix
	 * @return
	 */
	public static Boolean isValidOfficial(int[][] matrix) {
		for(int i = 0; i<9; i++) {
	        HashSet<Integer> rows = new HashSet<>();
	        HashSet<Integer> cols = new HashSet<>();
	        HashSet<Integer> cube = new HashSet<>();
	        for (int j = 0; j < 9;j++) {
	            if(matrix[i][j]!=0 && !rows.add(matrix[i][j]))
	                return false;
	            if(matrix[j][i]!=0 && !cols.add(matrix[j][i]))
	                return false;
	            int cubeRow = 3*(i/3) + j/3;
	            int cubeCol = 3*(i%3) + j%3;
	            if(matrix[cubeRow][cubeCol]!=0 && !cube.add(matrix[cubeRow][cubeCol]))
	                return false;
	        }
	    }
	    return true;
	}
}
