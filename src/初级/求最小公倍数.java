package 初级;
import java.util.Scanner;

public class 求最小公倍数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int tmp;
		
		if (m < n) {
			tmp = n;
		} else {
			tmp = m;
		}
		
		for (int i = tmp; i <= m * n; i++) {
			if (i % m == 0 && i % n == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
