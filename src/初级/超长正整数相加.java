package 初级;
import java.math.BigInteger;
import java.util.Scanner;

public class 超长正整数相加 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger augend = scanner.nextBigInteger();
		BigInteger addend = scanner.nextBigInteger();
		
		System.out.println(augend.add(addend));
	}
}
