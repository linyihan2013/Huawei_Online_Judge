package 中级;

import java.util.Scanner;

public class JAVA题目23级 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] a = new int[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					a[i][j] = 1;
				} else {
					a[i][j] = a[i - 1][j] + a[i][j - 1];
				}
			}
		}
		
		System.out.println(a[n][m]);
	}
}
