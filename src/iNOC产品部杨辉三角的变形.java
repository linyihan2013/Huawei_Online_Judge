import java.util.Scanner;

public class iNOC产品部杨辉三角的变形 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer n = scanner.nextInt();
		
		int result = 0;
		if (n < 3) {
			result = -1;
		}  else if (n % 2 == 0) {
			result = 3;
		} else {
			result = 2;
		}
		System.out.println(result);
	}
}
