package 中级;

import java.util.Scanner;

public class 汽水瓶 {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			int input = scanner.nextInt();
			if (input == 0) {
				break;
			}
			
			System.out.println(input / 2);
		}
	}
}
