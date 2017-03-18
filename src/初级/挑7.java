package 初级;
import java.util.Scanner;

public class 挑7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		
		int n = Integer.parseInt(string);
		int count = 0;
		for (int i = 1; i <= n; i++) {
			string = String.valueOf(i);
			if (string.contains("7") || (i % 7 == 0)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
