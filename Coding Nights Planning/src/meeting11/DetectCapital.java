package meeting11;

public class DetectCapital {
	
	public static void main(String[] args) {
		System.out.println("Is USA approppriate string? " + (detectCapitalUse("USA") ? "Yes": "No"));
	}
	
	public static boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) if (c < 'a') count++;
        if (count == 0 || count == word.length() || (count == 1 && word.charAt(0) <= 'Z')) return true;
        return false;
    }
}
