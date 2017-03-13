import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 称砝码 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] weight = new int[n];
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
		}

		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		for (int i = 0; i < n; i++) {
			Set<Integer> set2 = new HashSet<Integer>();
			for (int j = 1; j <= num[i]; j++) {
				for (Integer integer : set) {
					set2.add(j * weight[i] + integer);
				}

			}
			set.addAll(set2);
		}
		System.out.println(set.size());
	}
}
