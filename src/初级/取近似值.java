package 初级;
import java.util.Scanner;

public class 取近似值 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double input = scanner.nextDouble();
		double tmp = input * 10 % 10;
		
		if (tmp >= 5) {
			System.out.println((int)Math.ceil(input));
		} else {
			System.out.println((int)Math.floor(input));
		}
	}
}
