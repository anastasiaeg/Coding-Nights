package meeting9;

public class ValidDiagonal {
	public static void main(String[] args) {
		int[][] thing = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		
		System.out.println("Is " + (validDiag(thing)?"valid":"invalid"));
	}
	
	public static boolean validDiag(int[][] matrix) {
		for (int i = 0; i < matrix.length - 1; i++) {//3*4
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
	}
}
