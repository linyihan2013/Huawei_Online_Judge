import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DNA序列 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		int n = scanner.nextInt();
		int length = string.length();
		int max = 0, index = 0;
		
		for (int i = 0; i <= length - n; i++) {
			int count = 0;
			
			for (int j = i; j < i + n; j++) {
				if (string.charAt(j) == 'C' || string.charAt(j) == 'G') {
					count++;
				}
			}
			if (count > max) {
				max = count;
				index = i;
			}
		}
		System.out.println(string.substring(index, index + n));
	}
}
