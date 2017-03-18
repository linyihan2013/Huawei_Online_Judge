package 初级;
import java.util.Scanner;

public class 自守数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int count = 0;
		
		for (int i = 0; i <= num; i++) {
			String result = String.valueOf(i * i);
			String origin = String.valueOf(i);
			
			if (result.endsWith(origin)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
