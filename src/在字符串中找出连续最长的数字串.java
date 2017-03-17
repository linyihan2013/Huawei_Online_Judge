import java.util.Scanner;

public class 在字符串中找出连续最长的数字串 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int max = 0, count = 0, endIndex = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				count++;
			} else {
				count = 0;
			}
			if (count > max) {
				max = count;
				endIndex = i;
			}
		}
		
		if (max > 0) {
			for (int i = endIndex - max + 1; i <= endIndex; i++) {
				System.out.print(input.charAt(i));
			}
			System.out.print(",");
			System.out.print(max);
		} else {
			System.out.print(max);
		}
	}
}
