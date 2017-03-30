package 中级;

import java.util.Scanner;

public class 记负均正 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int negCount = 0, posCount = 0, posSum = 0;
		
		while (scanner.hasNext()) {
			int i = scanner.nextInt();
			
			if (i < 0) {
				negCount++;
			} else {
				posCount++;
				posSum += i;
			}
		}
		
		double posAvg = 0.0;
		if (posCount > 0) {
			posAvg = posSum / (double) posCount;
		}
		
		System.out.println(negCount);
		System.out.println(String.format("%.1f", posAvg));
	}
}
