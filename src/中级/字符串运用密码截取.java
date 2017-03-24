package 中级;

import java.util.Scanner;

public class 字符串运用密码截取 {
	public static int singleCount(char[] cs, int middle) {
		int count = 0;
		int length = cs.length - 1 - middle > middle ? middle : cs.length - 1 - middle;

		for (int i = 0; i <= length; i++) {
			if (cs[middle - i] == cs[middle + i]) {
				count = 2 * i + 1;
			} else {
				break;
			}
		}

		return count;
	}

	public static int doubleCount(char[] cs, int left, int right) {
		int count = 0;
		int length = cs.length - 1 - right > left ? left : cs.length - 1 - right;

		for (int i = 0; i <= length; i++) {
			if (cs[left - i] == cs[right + i]) {
				count = 2 * i + 2;
			} else {
				break;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String input = scanner.next();
			char[] cs = input.toCharArray();

			int maxCount = 0;
			for (int i = 0; i < cs.length; i++) {
				int count = singleCount(cs, i);
				maxCount = count > maxCount ? count : maxCount;

				if (i < cs.length - 1) {
					count = doubleCount(cs, i, i + 1);
					maxCount = count > maxCount ? count : maxCount;
				}
			}

			System.out.println(maxCount);
		}
	}
}
