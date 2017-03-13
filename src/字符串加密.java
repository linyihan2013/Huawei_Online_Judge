import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 字符串加密 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		String string = scanner.next();
		
		char firstLetter = 'A';
		char[] chars = key.toUpperCase().toCharArray();
		List<Character> list = new LinkedList<Character>();
		for (char c : chars) {
			if (list.contains(c) == false) {
				list.add(c);
			}
		}
		for (char i = firstLetter; i < firstLetter + 26; i++) {
			if (list.contains(i) == false) {
				list.add(i);
			}
		}
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < list.size(); i++) {
			map.put((char) (firstLetter + i), list.get(i));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : string.toCharArray()) {
			char tmp = map.get(Character.toUpperCase(c));
			
			if (Character.isUpperCase(c)) {
				stringBuilder.append(Character.toUpperCase(tmp));
			} else {
				stringBuilder.append(Character.toLowerCase(tmp));
			}
		}
		
		System.out.println(stringBuilder.toString());
	}
}
