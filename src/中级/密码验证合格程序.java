package 中级;

import java.util.Scanner;

public class 密码验证合格程序 {
	public static boolean validLength(String input) {
		return input.length() > 8;
	}
	
	public static boolean validCompose(String input) {
		boolean[] flag = new boolean[4];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = false;
		}
		
		for (char c : input.toCharArray()) {
			if (Character.isLetter(c) && Character.isLowerCase(c)) {
				flag[0] = true;
			} else if (Character.isLetter(c) && Character.isUpperCase(c)) {
				flag[1] = true;
			} else if (Character.isDigit(c)) {
				flag[2] = true;
			} else {
				flag[3] = true;
			}
		}
		
		int count = 0;
		for (int i = 0; i < flag.length; i++) {
			if (flag[i]) {
				count++;
			}
		}
		return count >= 3;
	}
	
	public static boolean validRepeat(String input) {
		int maxCount = 0;
		char[] chars = input.toCharArray();
		
		for (int i = 0; i < chars.length - 1; i++) {
			for (int j = (chars.length - i) / 2; j >= 1; j--) {
				boolean found = false;
				
				for (int k = i + j; k <= chars.length - j; k++) {	
					boolean flag = true;
					for (int l = 0; l < j; l++) {
						if (chars[i + l] != chars[k + l]) {
							flag = false;
							break;
						}
					}
					if (flag && maxCount < j) {
						maxCount = j;
						found = true;
					}
				}
				if (found) {
					break;
				}
			}
		}
		
		return maxCount <= 2;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String input = scanner.next();
			
			if (validLength(input) && validCompose(input) && validRepeat(input)) {
				System.out.println("OK");
			} else {
				System.out.println("NG");
			}
		}
	}
}
