package 初级;
import java.util.Scanner;

public class 将真分数分解为埃及分数 {
	public static String resolved(int numerator, int denominator) {
		int a = numerator;
		int b = denominator;
		
		int q = b / a;
		int r = b % a;
		
		StringBuilder stringBuilder = new StringBuilder();
		while (a != 1) {
			if (r == 0) {
				a = 1;
				b = q;
				continue;
			} else if ((a == 3) && (b % 2 == 0)) {
				stringBuilder.append(1);
				stringBuilder.append('/');
				stringBuilder.append(b / 2);
				stringBuilder.append('+');
				
				a = a - 2;
				q = b / a;
				r = b % a;
			} else {
				stringBuilder.append(1);
				stringBuilder.append('/');
				stringBuilder.append(q + 1);
				stringBuilder.append('+');
				
				a = a - r;
				b = b * (q + 1);
				q = b / a;
				r = b % a;
			}
		}
		
		stringBuilder.append(1);
		stringBuilder.append('/');
		stringBuilder.append(q);
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		String[] strings = input.split("/");
		int numerator = Integer.parseInt(strings[0]);
		int denominator = Integer.parseInt(strings[1]);
		
		System.out.println(resolved(numerator, denominator));
	}
}
