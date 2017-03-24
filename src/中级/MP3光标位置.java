package 中级;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MP3光标位置 {
	public static int move(int num, int pos, List<Integer> list, char action) {
		int npos = pos;
		if (action == 'U') {
			npos = npos > 1 ? npos - 1 : num;
			if (num <= 4) {
				return npos;
			}

			if (pos == 1) {
				list.clear();
				for (int i = num - 3; i <= num; i++) {
					list.add(i);
				}
			} else if (npos < list.get(0)) {
				list.add(0, npos);
				while (list.size() > 4) {
					list.remove(list.size() - 1);
				}
			}
		} else if (action == 'D') {
			npos = npos < num ? npos + 1 : 1;
			if (num <= 4) {
				return npos;
			}

			if (pos == num) {
				list.clear();
				for (int i = 1; i <= 4; i++) {
					list.add(i);
				}
			} else if (npos > list.get(list.size() - 1)) {
				list.add(list.size(), npos);
				while (list.size() > 4) {
					list.remove(0);
				}
			}
		}

		return npos;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		String actions = scanner.next();

		int pos = 1;
		List<Integer> list = new LinkedList<Integer>();
		int length = num > 4 ? 4 : num;
		for (int i = 1; i <= length; i++) {
			list.add(i);
		}

		for (char action : actions.toCharArray()) {
			pos = move(num, pos, list, action);
		}

		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(list.get(i));
		}

		System.out.println();
		System.out.println(pos);
	}
}
