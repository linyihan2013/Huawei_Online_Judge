package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 寻找等差数列 {
	public static List<Integer> getPrimes(int lower, int upper) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = lower; i <= upper; i++) {
			if (i <= 1) continue;
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lower = scanner.nextInt();
		int upper = scanner.nextInt();
		List<Integer> primes = getPrimes(lower, upper);
		int curLength = 0, curDiff = 0;
		int maxLength = 0, maxStart = 0, maxDiff = 0;
		
		for (int i = lower; i <= upper; i++) {
			if (primes.contains(i)) {
				curDiff = 1;
				while (i + curDiff <= upper) {
					curLength = 0;
					while (i + curDiff * curLength <= upper && primes.contains(i + curDiff * curLength)) {
						curLength++;
					}
					if (curLength > maxLength || curLength == maxLength && curDiff > maxDiff) {
						maxLength = curLength;
						maxDiff = curDiff;
						maxStart = i;
					}
					
					curDiff++;
				}
			}
		}
		for (int i = 0; i < maxLength; i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(maxStart + i * maxDiff);
		}
		System.out.println();
	}
}
