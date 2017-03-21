package 中级;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 删除字符串中出现次数最少的字符 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		char[] cs = input.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : cs) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (min > entry.getValue()) {
				min = entry.getValue();
			}
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : cs) {
			if (map.get(c) != min) {
				stringBuilder.append(c);
			}
		}
		System.out.println(stringBuilder.toString());
	}
}
