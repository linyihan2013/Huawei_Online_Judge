package 初级;
import java.util.Scanner;

public class iNOC产品部完全数计算 {
	public static int countPerfectNumber(int input) {
		if ((input > 0) && (input < 6)) {
			return 0;
		} else if ((input >= 6 && input < 28)) {
			return 1;
		} else if ((input >= 28) && (input < 496)) {
			return 2;
		} else if ((input >= 496) && (input < 8128)) {
			return 3;
		} else if ((input >= 8128) && (input < 500000)) {
			return 4;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer integer = scanner.nextInt();
		
		System.out.println(countPerfectNumber(integer));
	}
}
