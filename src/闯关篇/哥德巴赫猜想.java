package 闯关篇;

import java.util.Scanner;

public class 哥德巴赫猜想 {
	public static boolean isPrime(int input) {
		for (int i = 2; i <= Math.sqrt(input); i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		boolean result = false;
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (isPrime(i) && isPrime(num - i)) {
				result = true;
				break;
			}
		}
		
		if (result) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
