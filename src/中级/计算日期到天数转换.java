package 中级;

import java.util.Scanner;

public class 计算日期到天数转换 {
	private static void countDays(int[] arr, int month, int day) {
		int sum = 0;
		for (int i = 0; i < month - 1; i++) {
			sum += arr[i];
		}
		sum += day;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		
		int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] b = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			countDays(b, month, day);
		} else {
			countDays(a, month, day);
		}
	}
}
