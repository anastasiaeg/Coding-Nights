package meeting6;
import java.util.*;
import java.util.regex.Pattern;

public class Bites {
	public static void main(String[] args) {
		System.out.println(solution("my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\n" + 
				"video.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b"));
	}
	
	public static String solution(String S) {
        // write your code in Java SE 8
        Scanner s = new Scanner(S);
        int music = 0, image = 0, movie = 0, other = 0;
        while (s.hasNextLine()) {
        	StringTokenizer file = new StringTokenizer(s.nextLine(), " ");
        	String name = file.nextToken();
        	StringTokenizer bytes = new StringTokenizer(file.nextToken(), "b");
        	int bites = Integer.parseInt(bytes.nextToken());
        	
        	if (Pattern.matches("\\S+(.mp3|.aac|.flac)$", name)) {
        		music += bites;
        	} else if (Pattern.matches("\\S+(.jpg|.bmp|.gif)$", name)) {
        		image += bites;
        	} else if (Pattern.matches("\\S+(.mp4|.avi|.mkv)$", name)) {
        		movie += bites;
        	} else {
        		other += bites;
        	}
        }
        return "music " + music + "b\nimages " + image + "b\nmovies " + movie + "b\nother " + other + "b";
    }
}
