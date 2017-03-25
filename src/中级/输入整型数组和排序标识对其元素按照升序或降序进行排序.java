package 中级;

import java.util.Arrays;
import java.util.Scanner;

public class 输入整型数组和排序标识对其元素按照升序或降序进行排序 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] array = new int[num];
		
		for (int i = 0; i < num; i++) {
			int data = scanner.nextInt();
			array[i] = data;
		}
		int method = scanner.nextInt();
		Arrays.sort(array);
		
		if (method == 0) {
			for (int i = 0; i < num; i++) {
				if (i != 0) {
					System.out.print(" ");
				}
				System.out.print(array[i]);
			}
		} else {
			for (int i = num - 1; i >= 0; i--) {
				if (i != num - 1) {
					System.out.print(" ");
				}
				System.out.print(array[i]);
			}
		}
	}
}
