package 初级;
import java.util.Scanner;

public class 输入n个整数输出其中最小的k个 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] array = new int[k];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			int input = scanner.nextInt();
			if (count < k) {
				array[count++] = input;
			} else if (input < array[count - 1]) {
				array[count - 1] = input;
			} else {
				continue;
			}
			
			int index = count - 1;
			while (index > 0) {
				if (array[index] < array[index - 1]) {
					int tmp = array[index];
					array[index] = array[index - 1];
					array[index - 1] = tmp;
				}
				index--;
			}
		}
		
		for (int i = 0; i < count; i++) {
			if (i > 0) System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
