import java.util.Scanner;

public class 计算字符个数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine().toLowerCase();
		char match = scanner.next().toLowerCase().charAt(0);
		int count = 0;
		
		for (char c : string.toCharArray()) {
			if (c == match) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
