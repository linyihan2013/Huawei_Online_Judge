package 初级;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 整形数组合并 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		
		int num1 = scanner.nextInt();
		while (num1-- > 0) {
			int tmp = scanner.nextInt();
			if (!list.contains(tmp)) {
				list.add(tmp);
			}
		}
		
		int num2= scanner.nextInt();
		while (num2-- > 0) {
			int tmp = scanner.nextInt();
			if (!list.contains(tmp)) {
				list.add(tmp);
			}
		}
		
		Collections.sort(list);
		for (int i : list) {
			System.out.print(i);
		}
	}
}
