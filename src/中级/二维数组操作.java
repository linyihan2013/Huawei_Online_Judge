package 中级;

import java.util.Scanner;

public class 二维数组操作 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		System.out.println(0);
		
		int row1 = scanner.nextInt();
		int column1 = scanner.nextInt();
		int row2 = scanner.nextInt();
		int column2 = scanner.nextInt();
		if (0 <= row1 && row1 <= rows - 1 && 0 <= column1 && column1 <= columns - 1 && 
				0 <= row2 && row2 <= rows - 1 && 0 <= column2 && column2 <= columns - 1) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
		
		int insertRow = scanner.nextInt();
		if (0 <= insertRow && insertRow <= rows - 1) {
			rows++;
			System.out.println(0);
		} else {
			System.out.println(1);
		}
		
		int insertColumn = scanner.nextInt();
		if (0 <= insertColumn && insertColumn <= columns - 1) {
			columns++;
			System.out.println(0);
		} else {
			System.out.println(1);
		}
		
		int queryRow = scanner.nextInt();
		int queryColumn = scanner.nextInt();
		if (0 <= queryRow && queryRow <= rows - 1 && 0 <= queryColumn && queryColumn <= columns - 1) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}
}
