package meeting6;
import java.util.*;
import java.util.regex.Pattern;

public class Bytes {
	public static void main(String[] args) {
		System.out.println(solution("my.song.mp3 11\ngreatSong.flac 1000\nnot3.txt 5\n" + 
				"video.mp4 200\ngame.exe 100\nmov!e.mkv 10000"));
	}
	
	public static String solution(String S) {
        // write your code in Java SE 8
        Scanner s = new Scanner(S);
        int music = 0, image = 0, movie = 0, other = 0;
        while (s.hasNextLine()) {
        	StringTokenizer file = new StringTokenizer(s.nextLine(), " ");
        	String name = file.nextToken();
        	int bytes = Integer.parseInt(file.nextToken());
        	
        	if (Pattern.matches("\\S+(.mp3|.aac|.flac)$", name)) {
        		music += bytes;
        	} else if (Pattern.matches("\\S+(.jpg|.bmp|.gif)$", name)) {
        		image += bytes;
        	} else if (Pattern.matches("\\S+(.mp4|.avi|.mkv)$", name)) {
        		movie += bytes;
        	} else {
        		other += bytes;
        	}
        }
        return "music " + music + "\nimages " + image + "\nmovies " + movie + "\nother " + other;
    }
}
