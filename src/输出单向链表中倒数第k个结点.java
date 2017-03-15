import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 输出单向链表中倒数第k个结点 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer n = scanner.nextInt();
		
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		Integer k = scanner.nextInt();
		
		if (k < n) {
			System.out.println(list.get(n - k - 1));
		} else {
			System.out.println();
		}
	}
}
