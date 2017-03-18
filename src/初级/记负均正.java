package 初级;
import java.util.Scanner;

public class 记负均正 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int negativeCount = 0, positiveSum = 0, positiveCount = 0;
		
		while (num-- > 0) {
			int tmp = scanner.nextInt();
			if (tmp < 0) {
				negativeCount++;
			} else if (tmp > 0) {
				positiveCount++;
				positiveSum += tmp;
			}
		}
		
		System.out.print(negativeCount);
		System.out.print(" ");
		if (positiveSum % positiveCount == 0) {
			System.out.println(positiveSum / positiveCount);
		} else {
			double result = (double) positiveSum / positiveCount;
			System.out.println(String.format("%.1f", result));
		}
	}
}
