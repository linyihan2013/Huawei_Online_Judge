package 中级;

import java.util.Scanner;

public class 简单密码破解 {
	public static String convert(String input) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] cs = input.toCharArray();
		
		for (char c : cs) {
			char result;
			if (Character.isLetter(c) && Character.isUpperCase(c)) {
				if ('A' <= c && c <= 'Y') {
					result = (char) (Character.toLowerCase(c) + 1);
				} else {
					result = 'a';
				}
			} else if (Character.isLetter(c) && Character.isLowerCase(c)) {
				if ('a' <= c && c <= 'o') {
					result = (char) ((c - 'a') / 3 + '2');
				} else if ('p' <= c && c <= 's') {
					result = '7';
				} else if ('t' <= c && c <= 'v') {
					result = '8';
				} else {
					result = '9';
				}
			} else {
				result = c;
			}
			stringBuilder.append(result);
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String input = scanner.next();
			System.out.println(convert(input));
		}
	}
}
