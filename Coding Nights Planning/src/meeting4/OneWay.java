package meeting4;

import java.util.LinkedList;
import java.util.Queue;

public class OneWay {

	public static void main(String[] args) {
		System.out.println(oneWay("palesaa", "paleaa"));
	}
	
	/**
	 * O(a + b)
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean oneWay(String a, String b) {
		Queue<Character> q = new LinkedList<Character>();
		for (char c : a.toCharArray()) {
			q.add(c);
		}
		boolean oneChange = false;
		for (char c : b.toCharArray()) {
			if (q.size() == 0) return false;
			//bale pale
			//bale ale
			if (q.peek() != c && oneChange) {
				return false;
			} else if (q.peek() != c && a.length() == b.length()) {
				oneChange = true;
			} else if (q.peek() != c) {
				q.poll();
				if (q.peek() != c) return false;
			} 
			q.poll();
		}
		return q.size() <= 1;
	}
}
