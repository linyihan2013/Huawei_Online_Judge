package 中级;

import java.util.Scanner;

public class 统计每个月兔子的总数 {
	public static int fibonacci(int input) {
		if (input < 3) {
			return 1;
		}
		return fibonacci(input - 1) + fibonacci(input - 2);
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		System.out.println(fibonacci(num));
	}
}
