package 初级;
import java.util.Scanner;

public class 统计大写字母个数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
	
		char[] chars = string.toCharArray();
		int count = 0;
		for (char c : chars) {
			if (Character.isUpperCase(c)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
