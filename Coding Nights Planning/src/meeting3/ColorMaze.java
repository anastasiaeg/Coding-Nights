package meeting3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] maze = { {"B", "O", "R", "O", "Y"},
						    {"O", "R", "B", "G", "R"},
						  	{"B", "O", "G", "O", "Y"},
						    {"Y", "G", "B", "Y", "G"},
						    {"R", "O", "R", "B", "R"}};
		
		String[] mazeRule = {"O", "G"};
		
		for(int i = 0; i < 5; i ++) {
			for(int j = 4; j >= 0; j--) {
				if(maze[i][j].equals(mazeRule[0])) {
					if(maze[i][j + 1].equals(mazeRule[1])) {
						
					}
				}
			}
		}
	}

}
