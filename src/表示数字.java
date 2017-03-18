import java.util.Scanner;

public class 表示数字 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		char[] chars = input.toCharArray();
		boolean flag = false;
		int i = 0;
		
		StringBuilder stringBuilder = new StringBuilder();
		for (i = 0; i < chars.length; i++) {
			if (Character.isDigit(chars[i]) && flag == false) {
				stringBuilder.append("*");
				stringBuilder.append(chars[i]);
				flag = true;
			} else if (!Character.isDigit(chars[i]) && flag == true) {
				stringBuilder.append("*");
				stringBuilder.append(chars[i]);
				flag = false;
			} else {
				stringBuilder.append(chars[i]);
			}
		}
		if (Character.isDigit(chars[chars.length - 1])) {
			stringBuilder.append("*");
		}
		
		System.out.println(stringBuilder.toString());
	}
}
