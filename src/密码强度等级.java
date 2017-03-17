import java.util.Scanner;

public class 密码强度等级 {
	public static int passwordLength(String string) {
		if (string.length() <= 4) {
			return 5;
		} else if (string.length() <= 7) {
			return 10;
		} else {
			return 25;
		}
	}
	
	public static int countLetter(String string) {
		int lowerCase = 0, upperCase = 0;
		
		for (char c : string.toCharArray()) {
			if (Character.isLowerCase(c)) {
				lowerCase++;
			} else if (Character.isUpperCase(c)) {
				upperCase++;
			}
		}
		
		if (lowerCase == 0 && upperCase == 0) {
			return 0;
		} else if (lowerCase == 0 || upperCase == 0) {
			return 10;
		} else {
			return 20;
		}
	}
	
	public static int countDigit(String string) {
		int digits = 0;
		
		for (char c : string.toCharArray()) {
			if (Character.isDigit(c)) {
				digits++;
			}
		}
		
		if (digits == 0) {
			return 0;
		} else if (digits == 1) {
			return 10;
		} else {
			return 20;
		}
	}
	
	public static int countSymbol(String string) {
		int symbols = 0;
		
		for (char c : string.toCharArray()) {
			if (!Character.isLetter(c) && !Character.isDigit(c)) {
				symbols++;
			}
		}
		
		if (symbols == 0) {
			return 0;
		} else if (symbols == 1) {
			return 10;
		} else {
			return 25;
		}
	}
	
	public static int bonus(int letter, int digit, int symbol) {
		if (letter != 0 && digit != 0 && symbol == 0) {
			return 2;
		} else if (letter == 10 && digit != 0 && symbol != 0) {
			return 3;
		} else if (letter == 20 && digit != 0 && symbol != 0) {
			return 5;
		} else {
			return 0;
		}
	}
	
	public static void output(int grade) {
		if (grade >= 90) {
			System.out.println("VERY_SECURE");
		} else if (grade >= 80) {
			System.out.println("SECURE");
		} else if (grade >= 70) {
			System.out.println("VERY_STRONG");
		} else if (grade >= 60) {
			System.out.println("STRONG");
		} else if (grade >= 50) {
			System.out.println("AVERAGE");
		} else if (grade >= 25) {
			System.out.println("WEAK");
		} else {
			System.out.println("VERY_WEAK");
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int grade = 0;
		
		int length = passwordLength(input);
		int letter = countLetter(input);
		int digit = countDigit(input);
		int symbol = countSymbol(input);
		int bonus = bonus(letter, digit, symbol);
		grade = length + letter + digit + symbol + bonus;
		
		output(grade);
	}
}
