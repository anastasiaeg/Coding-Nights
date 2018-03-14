package meeting9;

public class ValidTicTac {
	public static void main(String[] args) {
		String[] thing = {"XOO", "XXX", "OOO"};
		System.out.println("xoo\nxxx\nooo\nis " + (validTicTacToe(thing)?"valid":"invalid"));
	}
	
	public static boolean validTicTacToe(String[] board) {
        int[] valids = new int[8];
        int xs = 0, os = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                int add = 0;
                if (board[i].charAt(j) == 'X') {
                    add = 1;
                    xs++;
                } else if (board[i].charAt(j) == 'O') {
                    add = -1;
                    os++;
                }
                valids[i] += add;
                valids[3 + j] += add;
                if (i == j) {
                    valids[6] += add;
                }
                if (j == 2 - i) {
                    valids[7] += add;
                }
            }
        }
        if (os > xs || xs - 1 > os) {
            return false;
        }
        for (int i = 0; i < valids.length; i++) {
            if (valids[i] == 3 && os >= xs) return false;
            if (valids[i] == -3 && xs > os) return false;
        }
        return true;
    }
}
