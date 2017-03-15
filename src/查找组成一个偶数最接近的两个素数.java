import java.util.Scanner;

public class 查找组成一个偶数最接近的两个素数 {
	public static boolean isPrime(int input) {
		for (int i = 2; i < input / 2; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = 0, min = 0;
		
		for (int j = 2; j < n / 2; j++) {
			if (isPrime(j) && isPrime(n - j)) {
				if ((min == 0) || (n - j - j < min)) {
					min = n - j - j;
					k = j;
				}
			}
		}
		System.out.println(k);
		System.out.println(n - k);
	}
}
