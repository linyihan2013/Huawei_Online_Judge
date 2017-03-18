package 初级;

import java.util.Scanner;

public class 求int型数据在内存中存储时1的个数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		System.out.println(Integer.bitCount(input));
	}
}
