package 闯关篇;

import java.util.Scanner;

public class iNOC产品部取石子游戏 {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextInt()) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			if (a < b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			int k = a - b;
			a = (int) (k * (1 + Math.sqrt(5)) / 2.0);
			
			if (a == b) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
	}
}
