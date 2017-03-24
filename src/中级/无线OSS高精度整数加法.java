package 中级;

import java.math.BigInteger;
import java.util.Scanner;

public class 无线OSS高精度整数加法 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BigInteger bigInteger1 = scanner.nextBigInteger();
		BigInteger bigInteger2 = scanner.nextBigInteger();
		
		System.out.println(bigInteger1.add(bigInteger2));
	}
}
