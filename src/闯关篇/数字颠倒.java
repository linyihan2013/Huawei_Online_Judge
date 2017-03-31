package 闯关篇;

import java.util.Scanner;

public class 数字颠倒 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		
		System.out.println(new StringBuilder(string).reverse());
	}
}
