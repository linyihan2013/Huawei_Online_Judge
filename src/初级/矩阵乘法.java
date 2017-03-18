package 初级;
import java.util.Scanner;

public class 矩阵乘法 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int z = scanner.nextInt();
		int[][] m1 = new int[x][y];
		int[][] m2 = new int[y][z];
		int[][] r1 = new int[x][z];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				m1[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < z; j++) {
				m2[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < z; j++) {
				int sum = 0;
				for (int k = 0; k < y; k++) {
					sum += m1[i][k] * m2[k][j];
				}
				r1[i][j] = sum;
			}
		}
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < z; j++) {
				if (j != 0) System.out.print(" ");
				System.out.print(r1[i][j]);
			}
			System.out.println();
		}
	}
}
