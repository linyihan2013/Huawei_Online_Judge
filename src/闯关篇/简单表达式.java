package 闯关篇;

import java.util.Scanner;

public class 简单表达式 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		
		if (x < 1) {
			System.out.println(x);
		} else if (1 <= x && x < 10) {
			System.out.println(2 * x - 1);
		} else {
			System.out.println(3 * x - 11);
		}
	}
}
