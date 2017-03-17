import java.util.Scanner;

public class 求最大连续bit数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int max = 0, count = 0;
		
		while (input > 0) {
			if (input % 2 == 1) {
				count++;
			} else {
				count = 0;
			}
			if (count > max) {
				max = count;
			}
			input /= 2;
		}
		
		System.out.println(max);
	}
}
