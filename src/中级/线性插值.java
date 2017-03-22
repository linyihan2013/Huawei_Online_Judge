package 中级;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 线性插值 {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		int lastKey = -1, lastValue = -1;
		while (m-- > 0) {
			int key = scanner.nextInt();
			int value = scanner.nextInt();
			
			if (map.containsKey(key)) {
				continue;
			}
			
			if (lastKey != -1) {
				for (int i = 1; i < key - lastKey; i++) {
					map.put(lastKey + i, lastValue + i * (value - lastValue) / (key - lastKey));
				}
			}
			
			map.put(key, value);
			lastKey = key;
			lastValue = value;
		}
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
