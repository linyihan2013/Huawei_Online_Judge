import java.util.Scanner;

public class 字符串加解密 {
	public static char[] encrypt(char[] input) {
		char[] output = new char[input.length];
		
		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			
			if (Character.isLetter(input[i])) {
				if ((input[i] == 'z') || (input[i] == 'Z')) {
					c = 'a';
				} else {
					c = (char) (c + 1);
				}
				
				if (Character.isUpperCase(input[i])) {
					c = Character.toLowerCase(c);
				} else {
					c = Character.toUpperCase(c);
				}
			} else if (Character.isDigit(input[i])) {
				if (input[i] == '9') {
					c = '0';
				} else {
					c = (char) (c + 1);
				}
			}
			
			output[i] = c;
		}
		return output;
	}
	
	public static char[] decrypt(char[] input) {
		char[] output = new char[input.length];
		
		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			
			if (Character.isLetter(input[i])) {
				if ((input[i] == 'a') || (input[i] == 'A')) {
					c = 'z';
				} else {
					c = (char) (c - 1);
				}
				
				if (Character.isUpperCase(input[i])) {
					c = Character.toLowerCase(c);
				} else {
					c = Character.toUpperCase(c);
				}
			} else if (Character.isDigit(input[i])) {
				if (input[i] == '0') {
					c = '9';
				} else {
					c = (char) (c - 1);
				}
			}
			
			output[i] = c;
		}
		return output;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next();
		String string2 = scanner.next();
		
		char[] result1 = encrypt(string1.toCharArray());
		char[] result2 = decrypt(string2.toCharArray());
		
		System.out.println(result1);
		System.out.println(result2);
	}
}
