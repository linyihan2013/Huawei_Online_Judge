import java.util.Scanner;

public class 蛇形矩阵 {
	public static void GetResult(int num, int[] result) {
		int[][] array = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				array[i][j] = -1;
			}
		}
		
		int count = 1;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j <= i; j++) {
				array[i - j][j] = count++;
			}
		}
		
		count = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num - i; j++) {
				if (array[i][j] != -1) {
					result[count++] = array[i][j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		
		int n = Integer.parseInt(string);
		int length = (1 + n) * n / 2;
		int[] result = new int[length];
		
		GetResult(n, result);
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (j != 0) {
					System.out.print(" ");
				}
				System.out.print(result[count++]);
			}
			System.out.println();
		}
	}
}
