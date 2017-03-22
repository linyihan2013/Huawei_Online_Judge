package 中级;

import java.util.Scanner;

public class 字符串合并处理 {
	public static void bubble(char[] cs, int m, int n) {
		if (m < cs.length && n < cs.length && cs[m] > cs[n]) {
			char c = cs[m];
			cs[m] = cs[n];
			cs[n] = c;
		}
	}
	
	public static String convert(char[] cs) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (char c : cs) {
			if (('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A') <= c && c <= 'F') {
				int digit = Character.digit(c, 16);
				int result = 0;
				
				for (int i = 0; i < 4; i++) {
					result *= 2;
					result += digit % 2;
					digit /= 2;
				}
				
				stringBuilder.append(Character.toUpperCase(Character.forDigit(result, 16)));
			} else {
				stringBuilder.append(c);
			}			
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next();
		String string2 = scanner.next();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(string1);
		stringBuilder.append(string2);
		char[] cs = stringBuilder.toString().toCharArray();
		
		for (int i = 0; i < cs.length / 2; i++) {
			for (int j = cs.length / 2; j > i; j--) {
				bubble(cs, 2 * j - 2, 2 * j);
				bubble(cs, 2 * j - 1, 2 * j + 1);
			}
		}

		System.out.println(convert(cs));
	}
}
