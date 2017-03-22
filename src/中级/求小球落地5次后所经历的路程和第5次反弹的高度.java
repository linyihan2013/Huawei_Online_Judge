package 中级;

import java.util.Scanner;

public class 求小球落地5次后所经历的路程和第5次反弹的高度 {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		double height = scanner.nextDouble();
		
		double result1 = height, result2 = height;
		for (int i = 0; i < 5; i++) {
			if (i != 0) {
				result1 += result2 * 2;
			}
			result2 /= 2;
		}
		System.out.println(result1);
		System.out.println(result2);
	}
}
