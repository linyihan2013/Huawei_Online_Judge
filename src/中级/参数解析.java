package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 参数解析 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		List<String> list = new ArrayList<String>();
		
		StringBuilder stringBuilder = new StringBuilder();
		boolean stop = false;
		boolean special = false;
		
		for (int i = 0; i < input.length(); i++) {
			if (special == false) {
				if (input.charAt(i) == ' ') {
					list.add(stringBuilder.toString());
					stringBuilder.setLength(0);
				} else if (input.charAt(i) == '“' || input.charAt(i) == '"') {
					special = true;
					stringBuilder.setLength(0);
				} else {
					stringBuilder.append(input.charAt(i));
				}
			} else {
				if (input.charAt(i) == '”' || input.charAt(i) == '"') {
					special = false;
					list.add(stringBuilder.toString());
					stringBuilder.setLength(0);
				} else {
					stringBuilder.append(input.charAt(i));
				}
			}
		}
		
		if (stringBuilder.length() > 0) {
			list.add(stringBuilder.toString());
		}
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
