package 初级;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 找出字符串中第一个只出现一次的字符 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();

		char[] chars = string.toCharArray();
		List<Character> list = new LinkedList<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : chars) {
			if (list.contains(c) == false) {
				list.add(c);
			}

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		boolean flag = true;
		for (Character character : list) {
			if (map.get(character) == 1) {
				System.out.print(character);
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.print('.');
		}
	}
}
