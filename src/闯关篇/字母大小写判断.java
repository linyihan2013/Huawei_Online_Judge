package 闯关篇;

import java.util.Scanner;

public class 字母大小写判断 {
	public static boolean judge(String input) {
		if (input.length() <= 0) {
			return false;
		}
		if (!Character.isLetter(input.charAt(0))) {
			return false;
		}
		if (Character.isLowerCase(input.charAt(0))) {
			return false;
		}
		
		boolean result = true;
		int count = 0;
		for (int i = 1; i < input.length(); i++) {
			if (Character.isLetter(input.charAt(i)) && Character.isUpperCase(input.charAt(i))) {
				result = false;
				break;
			} else if (Character.isLetter(input.charAt(i)) && Character.isLowerCase(input.charAt(i))) {
				count++;
			}
		}
		
		if (count == 0) {
			result = false;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		System.out.println(judge(string)); 
	}
}
