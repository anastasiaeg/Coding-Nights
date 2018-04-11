package meeting11;

public class BitNumberComplement {
	public static void main(String[] args) {
		System.out.println("Complement of 5 is " + findComplement(5));
		System.out.println("Complement of 2 is " + findComplement(2));
		System.out.println("Complement of 1 is " + findComplement(1));
	}
	
	public static int findComplement(int num) {
		int count = 0;
        int current = num;
        while (current != 0) {
            count++;
            current = current >> 1;
        }
        current = 0;
        for (int i = 0; i < count; i++) {
            current <<= 1;
            current |= 1;
        }
        return current ^ num;
	}
}
