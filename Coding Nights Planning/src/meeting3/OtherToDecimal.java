package meeting3;

public class OtherToDecimal {
	public static void main(String[] args) {
		System.out.println("111001 to decimal = " + toDecimal("111001", 2));
		System.out.println("1F to decimal = " + toDecimal("1F", 16));
		System.out.println("174 to binary = " + toOther(174, 2));
		System.out.println("139 to hex = " + toOther(139, 16));
	}
	
	public static int toDecimal(String input, int power) {
		int thing = 0;
		int output = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			try {
			output += Integer.parseInt("" + input.charAt(i)) * (int)Math.pow(power, thing);
			} catch (Exception e) {
				output += ((int)(input.charAt(i) - 'A') + 10) * (int)Math.pow(power, thing);
			}
			thing++;
		}
		return output;
	}
	
	public static String toOther(int decimal, int power) {
		String output = "";
		int current = decimal;
		while (current != 0) {
			int remainder = current % power;
			if (remainder > 9) {
				output = (char)(remainder - 10 + 'A') + output;
			} else {
				output = remainder + output;
			}
			current /= power;
		}
		return output;
	}
}
