package 初级;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 提取不重复的整数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		int result = 0;
		
		while (num > 0 && num % 10 == 0) {
			set.add(0);
			num /= 10;
		}
		while (num > 0) {
			int tmp = num % 10;
			if (!set.contains(tmp)) {
				result *= 10;
				result += tmp;
				set.add(tmp);
			}
			num /= 10;
		}
		System.out.println(result);
	}
}
