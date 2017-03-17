import java.util.Scanner;

public class JAVA题目01级 {
	private static boolean result = false;
	
	public static void find(int[] array, int[] flag, int num, int pos) {
		if (pos == num) {
			int sumLeft = 0, sumRight = 0;
			int i;
			
			for (i = 0; i < num; i++) {
				if ((array[i] % 5 == 0 && flag[i] == 0) || (array[i] % 5 != 0 && array[i] % 3 != 0 && flag[i] == 0)) {
					sumLeft += array[i];
				} else if ((array[i] % 3 == 0 && array[i] % 5 != 0 && flag[i] == 1) || (array[i] % 5 != 0 && array[i] % 3 != 0 && flag[i] == 1)) {
					sumRight += array[i];
				} else {
					break;
				}
			}
			if (i == num && sumLeft == sumRight) {
				result = true;
			}
			return;
		}
		flag[pos] = 0;
		find(array, flag, num, pos + 1);
		flag[pos] = 1;
		find(array, flag, num, pos + 1);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();

		int[] array = new int[num];
		int[] flag = new int[num];
		for (int i = 0; i < num; i++) {
			array[i] = scanner.nextInt();
			flag[i] = 0;
		}
		
		find(array, flag, num, 0);
		if (result) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
