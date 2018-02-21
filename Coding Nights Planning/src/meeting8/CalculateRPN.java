package meeting8;

import java.util.HashSet;
import java.util.Stack;

/**
 * 
 * @author anast_000
 *
 */
public class CalculateRPN {

	static HashSet<String> hs;
	public static void main(String[] args) {
		hs = new HashSet<String>();
		hs.add("+"); hs.add("-"); hs.add("*"); hs.add("/");
		String[] rpn = {"15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-"};
		System.out.println(fromRPN(rpn));
	}
	
	
	public static String fromRPN(String[] rpn) {
		Stack<String> s = new Stack<String>();
		for (int i = 0; i < rpn.length; i++) {
			if (hs.contains(rpn[i])) {
				if (rpn[i] == "*") {
					s.push("" + (Integer.parseInt(s.pop()) * Integer.parseInt(s.pop())));
				} else  if (rpn[i] == "/") {
					int first = Integer.parseInt(s.pop());
					int second = Integer.parseInt(s.pop());
					s.push("" + (second / first));
				} else  if (rpn[i] == "+") {
					s.push("" + (Integer.parseInt(s.pop()) + Integer.parseInt(s.pop())));
				} else {
					int first = Integer.parseInt(s.pop());
					int second = Integer.parseInt(s.pop());
					s.push("" + (second - first));
				}
			} else {
				s.push(rpn[i]);
			}
		}
		return "" + s.pop();
	}
}
