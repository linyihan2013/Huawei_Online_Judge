import java.util.Scanner;

public class 字符串加解密 {
	public static char encryptLetter(char c) {
		if (c == 'z') {
			return 'a';
		} else if (c == 'Z') {
			return 'A';
		} else {
			return (char) (c + 1);
		}
	}
	
	public static char decryptLetter(char c) {
		if (c == 'a') {
			return 'z';
		} else if (c == 'A') {
			return 'Z';
		} else {
			return (char) (c - 1);
		}
	}
	
	public static char encryptDigit(char c) {
		if (c == '9') {
			return '0';
		} else {
			return (char) (c + 1);
		}
	}
	
	public static char decryptDigit(char c) {
		if (c == '0') {
			return '9';
		} else {
			return (char) (c - 1);
		}
	}
	
	public static char changeCaseForLetter(char c) {
		if (Character.isUpperCase(c)) {
			return Character.toLowerCase(c);
		} else {
			return Character.toUpperCase(c);
		}
	}
	
	public static char[] encrypt(char[] input) {
		char[] output = new char[input.length];
		
		for (int i = 0; i < input.length; i++) {
			if (Character.isLetter(input[i])) {
				output[i] = changeCaseForLetter(encryptDigit(input[i]));
			} else if (Character.isDigit(input[i])) {
				output[i] = encryptDigit(input[i]);
			}
		}
		return output;
	}
	
	public static char[] decrypt(char[] input) {
		char[] output = new char[input.length];
		
		for (int i = 0; i < input.length; i++) {
			if (Character.isLetter(input[i])) {
				output[i] = changeCaseForLetter(decryptDigit(input[i]));
			} else if (Character.isDigit(input[i])) {
				output[i] = decryptDigit(input[i]);
			}
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
