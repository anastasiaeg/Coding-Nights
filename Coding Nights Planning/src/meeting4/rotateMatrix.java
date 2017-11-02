package meeting4;

import java.util.Arrays;

public class rotateMatrix {
	public static void main(String[] args) {
		int[][] input = {{11, 12, 13, 14}, {15, 16, 17, 18}, {19, 20, 21, 22}, {23, 24, 25, 26}};
		int[][] input2 = {{11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}, {26, 27, 28, 29, 30}, {31, 32, 33, 34, 35}};
		for (int i = 0; i < input.length; i++) {
			System.out.println(Arrays.toString(input[i]));
		}
		System.out.println();
		int[][] output = rotateCounter(input);
		for (int i = 0; i < output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
		System.out.println();
		for (int i = 0; i < input2.length; i++) {
			System.out.println(Arrays.toString(input2[i]));
		}
		System.out.println();
		int[][] output2 = rotateCounter(input2);
		for (int i = 0; i < output2.length; i++) {
			System.out.println(Arrays.toString(output2[i]));
		}
	}
	
	/**
	 * Rotate a matrix counterclockwise
	 * @param matrix
	 * @return
	 */
	public static int[][] rotateCounter(int[][] matrix) {
		for (int i = 0; i <= matrix.length / 2; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				if (i == matrix.length / 2 && matrix.length % 2 != 0) {
					int half = matrix.length / 2;
					int safe = matrix[j][half];
					matrix[j][half] = matrix[half][matrix.length - 1 - j];
					matrix[half][matrix.length - 1 - j] = matrix[matrix.length - 1 - j][half];
					matrix[matrix.length - 1 - j][half] = matrix[half][j];
					matrix[half][j] = safe;
				} else if (i != matrix.length / 2) {
					int safe = matrix[i][j]; //0 2 --> 1 0
					matrix[i][j] = matrix[j][matrix.length - 1 - i]; //2 3
					matrix[j][matrix.length - 1 - i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j]; //3 1
					matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[matrix.length - 1 - j][i];
					matrix[matrix.length - 1 - j][i] = safe;
				}
			}
		}
		return matrix;
	}
}
