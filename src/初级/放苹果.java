package 初级;
import java.util.Scanner;

public class 放苹果 {
	public static int count(int m, int n) {
		if ((n == 0) || (n == 1)) {
			return 1;
		}
		if (n > m) {
			return count(m, m);
		}
		return count(m, n - 1) + count(m - n, n);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		System.out.println(count(m, n));
	}
}
