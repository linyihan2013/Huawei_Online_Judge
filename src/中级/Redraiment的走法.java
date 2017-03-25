package 中级;

import java.util.Scanner;

public class Redraiment的走法 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		int[] array = new int[num];
		int[] steps = new int[num];
		for (int i = 0; i < num; i++) {
			array[i] = scanner.nextInt();
			steps[i] = 1;
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && steps[i] < steps[j] + 1) {
					steps[i] = steps[j] + 1;
				}
			}
		}
		
		System.out.println(steps[num - 1]);
	}
}
