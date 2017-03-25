package 中级;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 二十四点运算 {
	public static String[] cardStrings = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
	public static int[] cardInts = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2};
	
	public static int stringToInt(String string) {
		int result = 0;
		for (int j = 0; j < 13; j++) {
			if (string.equals(cardStrings[j])) {
				result = cardInts[j];
				break;
			}
		}
		return result;
	}
	
	public static String intToString(int input) {
		String result = null;
		for (int j = 0; j < 13; j++) {
			if (input == cardInts[j]) {
				result = cardStrings[j];
				break;
			}
		}
		return result;
	}
	
	public static boolean Calculate(int x, int y, int z, int w) {
		if (x+y+z+w==24) {
			System.out.println(intToString(x) + "+" + intToString(y) + "+" + intToString(z) + "+" + intToString(w));
			return true;
		} else if (x+y+z-w==24) {
			System.out.println(intToString(x) + "+" + intToString(y) + "+" + intToString(z) + "-" + intToString(w));
			return true;
		} else if (x*y*z/w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "*" + intToString(z) + "/" + intToString(w));
			return true;
		} else if (x*y*z-w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "*" + intToString(z) + "-" + intToString(w));
			return true;
		} else if (x*y*z+w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "*" + intToString(z) + "+" + intToString(w));
			return true;
		} else if (x*y*z*w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "*" + intToString(z) + "*" + intToString(w));
			return true;
		} else if (x+y+z/w==24) {
			System.out.println(intToString(x) + "+" + intToString(y) + "+" + intToString(z) + "/" + intToString(w));
			return true;
		} else if (x*y+z+w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "+" + intToString(z) + "+" + intToString(w));
			return true;
		} else if (x*y+z-w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "+" + intToString(z) + "-" + intToString(w));
			return true;
		} else if (x*y-z/w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "-" + intToString(z) + "/" + intToString(w));
			return true;
		} else if (x*y+z/w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "+" + intToString(z) + "/" + intToString(w));
			return true;
		} else if (x*y-z-w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "-" + intToString(z) + "-" + intToString(w));
			return true;
		} else if (x*y+z*w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "+" + intToString(z) + "*" + intToString(w));
			return true;
		} else if (x*y-z*w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "-" + intToString(z) + "*" + intToString(w));
			return true;
		} else if (x*y/z/w==24) {
			System.out.println(intToString(x) + "*" + intToString(y) + "/" + intToString(z) + "/" + intToString(w));
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean error = false;
		
		String[] strings = new String[4];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = scanner.next();
			if (strings[i] == "joker" || strings[i] == "JOKER") {
				error = true;
			}
		}
		
		if (error) {
			System.out.println("ERROR");
		} else {
			int[] ints = new int[4];
			for (int i = 0; i < 4; i++) {
				ints[i] = stringToInt(strings[i]);
			}
			
			int a = ints[0];
			int b = ints[1];
			int c = ints[2];
			int d = ints[3];
			
			boolean result = Calculate(a,b,c,d) || Calculate(a,b,d,c) || Calculate(a,c,d,b) ||
					Calculate(a,c,b,d) || Calculate(a,d,b,c) || Calculate(a,d,c,b) ||
					Calculate(b,a,c,d) || Calculate(b,a,d,c) || Calculate(b,c,a,d) ||
					Calculate(b,c,d,a) || Calculate(b,d,c,a) || Calculate(b,d,a,c) ||
					Calculate(c,a,b,d) || Calculate(c,a,d,b) || Calculate(c,b,d,a) ||
					Calculate(c,b,a,d) || Calculate(c,d,a,b) || Calculate(c,d,b,a) ||
					Calculate(d,a,b,c) || Calculate(d,a,c,b) || Calculate(d,b,c,a) ||
					Calculate(d,b,a,c) || Calculate(d,c,a,b) || Calculate(d,c,b,a);
			
			if (result == false) {
				System.out.println("NONE");
			}
		}
	}
}
