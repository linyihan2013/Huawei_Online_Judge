package 高级;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class 配置文件恢复 {
	public static Map<String, String> commands = new HashMap<String, String>();
	
	public static boolean match(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}
		
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static String matchCommand(String input) {
		String result = null;
		String[] parts = input.split(" ");
		
		if (parts.length == 1) {
			if (!parts[0].equals("") && match(parts[0], "reset")) {
				result = "reset what";
			} else {
				result = "unkown command";
			}
		} else if (parts.length < 1 || parts.length > 2) {
			result = "unkown command";
		} else {
			int counter = 0;
			for (Entry<String, String> entry : commands.entrySet()) {
				String[] strings = entry.getKey().split(" ");
				if (strings.length >= 2 && match(parts[0], strings[0]) && match(parts[1], strings[1])) {
					counter++;
					result = entry.getValue();
				}
			}
			if (counter != 1) {
				result = "unkown command";
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		commands.put("reset board", "board fault");
		commands.put("board add", "where to add");
		commands.put("board delet", "no board at all");
		commands.put("reboot backplane", "impossible");
		commands.put("backplane abort", "install first");
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine().trim();
			System.out.println(matchCommand(input));
		}
	}
}
