package 中级;

import java.util.Scanner;

public class 字符串分割 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		while (num-- > 0) {
			String input = scanner.next();
			int length = input.length();
			
			if (length <= 0) {
				continue;
			}
			
			int parts = length / 8;
			int remain = length % 8;
			
			for (int i = 0; i < parts; i++) {
				System.out.println(input.substring(i * 8, i * 8 + 8));
			}
			
			if (remain > 0) {
				String string = input.substring(parts * 8, length);
				StringBuilder stringBuilder = new StringBuilder(string);
				
				for (int i = remain; i < 8; i++) {
					stringBuilder.append("0");
				}
				System.out.println(stringBuilder.toString());
			}
		}
	}
}
