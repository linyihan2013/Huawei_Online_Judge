import java.util.List;
import java.util.Scanner;

public class 等差数列 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int start= 2, diff = 3;
		int end = start + diff * (count - 1);
		System.out.println((start + end) * count / 2);
	}
}
