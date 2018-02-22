package other;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Burger {
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int tests = s.nextInt();
		for (int i = 0; i < tests; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>((b, a)->b-a);
			int ingredients = s.nextInt();
			for (int j = 0; j < ingredients; j++) {
				pq.add(s.nextInt());
			}
			System.out.print("Case #" + (i + 1) + ": ");
			int sum = 0;
			for (int j = 0; j < ingredients / 2 + (ingredients % 2== 1?1:0); j++) {
				if (j != 0 || ingredients % 2 == 0) {
					sum += (int)Math.pow(pq.poll() - j, 2);
					System.out.println("<" + sum + ">");
				}
				sum += (int)Math.pow(pq.poll() - j, 2);
				System.out.println("<" + sum + ">");
			}
			System.out.println(sum);
		}
		s.close();
	}
}
