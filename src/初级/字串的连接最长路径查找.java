package 初级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字串的连接最长路径查找 {
	public static boolean CanConnect(String string1, String string2) {
		int length1 = string1.length();
		
		for (int i = length1; i > 0; i--) {
			if (string1.substring(length1 - i, length1).equals(string2.substring(0, i))) {
				return true;
			}
		}
		return false;
	}
	
	public static String Connect(String string1, String string2) {
		int length1 = string1.length();
		int length2 = string2.length();
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = length2; i > 0; i--) {
			if (string1.substring(length1 - i, length1).equals(string2.substring(0, i))) {
				stringBuilder.append(string1);
				stringBuilder.append(string2.substring(i, length2));
				break;
			}
		}
		return stringBuilder.toString();
	}
	
	public static String Find(String[] strings, boolean[][] connected, int index, String input) {
		if (index == strings.length - 1) {
			return input;
		}
		
		List<String> results = new ArrayList<String>();
		int maxLength = 0, maxIndex = 0;
		
		for (int i = index + 1; i < strings.length; i++) {
			if (connected[index][i]) {
				results.add(Find(strings, connected, i, Connect(input, strings[i])));
			}
		}
		for (int i = 0; i < results.size(); i++) {
			if (maxLength < results.get(i).length()) {
				maxLength = results.get(i).length();
				maxIndex = i;
			}
		}
		if (results.size() > 0) {
			return results.get(maxIndex);
		} else {
			return input;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] strings = input.split(" ");
		
		int n = strings.length;
		boolean[][] connected = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && CanConnect(strings[i], strings[j])) {
					connected[i][j] = true;
				} else {
					connected[i][j] = false;
				}
			}
		}
		
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < n - 1; i++) {
			results.add(Find(strings, connected, i, strings[i]));
		}
		int maxLength = 0, maxIndex = 0;
		for (int i = 0; i < results.size(); i++) {
			if (maxLength < results.get(i).length()) {
				maxLength = results.get(i).length();
				maxIndex = i;
			}
		}
		System.out.println(results.get(maxIndex));
	}
}
