package 初级;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 明明的随机数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		Set<Integer> set = new TreeSet<Integer>();
		
		while (num-- > 0) {
			int tmp = scanner.nextInt();
			set.add(tmp);
		}
		
		for (int i : set) {
			System.out.println(i);
		}
	}
}
