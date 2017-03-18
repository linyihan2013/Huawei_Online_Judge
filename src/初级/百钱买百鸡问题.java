package 初级;

import java.util.Scanner;

public class 百钱买百鸡问题 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		for (int i = 0; i <= 100 / 5; i++) {
			for (int j = 0; j <= (100 - 5 * i) / 3; j++) {
				int k = (100 - 5 * i - 3 * j) * 3;
				if (i + j + k == 100) {
					System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}
}
