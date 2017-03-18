package 初级;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 合并表记录 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		while (num-- > 0) {
			int key = scanner.nextInt();
			int value = scanner.nextInt();
			
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + value);
			} else {
				map.put(key, value);
			}
		}
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
