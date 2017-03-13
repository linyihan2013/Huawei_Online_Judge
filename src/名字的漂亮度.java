import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 名字的漂亮度 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		
		int n = Integer.parseInt(string);
		while (n-- > 0) {
			string = scanner.next();
			char[] chars = string.toCharArray();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			
			for (char c : chars) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			
			Object[] objects = map.values().toArray();
			Arrays.sort(objects);
			
			int grade = 0;
			for (int index = objects.length - 1; index >= 0; index--) {
				grade += (int) objects[index] * (26 - (objects.length - 1 - index));
			}
			
			System.out.println(grade);
		}
	}
}
