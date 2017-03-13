import java.util.Scanner;

public class 统计出包含英文字母空格数字和其它字符的个数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		int totalLength = string.length();
		int letterCount = 0, spaceCount = 0, digitCount = 0, otherCount = 0;
		
		for (int i = 0; i < totalLength; i++) {
			if (Character.isLetter(string.charAt(i))) {
				letterCount++;
			} else if (string.charAt(i) == ' ') {
				spaceCount++;
			} else if (Character.isDigit(string.charAt(i))) {
				digitCount++;
			} else {
				otherCount++;
			}
		}
		
		System.out.println(letterCount);
		System.out.println(spaceCount);
		System.out.println(digitCount);
		System.out.println(otherCount);
	}
}
