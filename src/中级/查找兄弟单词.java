package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 查找兄弟单词 {
	public static void permutation(String input, String result, List<String> list) {
		if (result.length() == input.length()) {
			list.add(result);
		} else {
			for (int i = 0; i < input.length(); i++) {
				if (result.indexOf(input.charAt(i)) < 0) {
					permutation(input, result + input.charAt(i), list);
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		Set<String> dict = new TreeSet<String>();
		for (int i = 0; i < num; i++) {
			String word = scanner.next();
			dict.add(word);
		}
		
		String input = scanner.next();
		int index = scanner.nextInt();
		
		List<String> list = new ArrayList<String>();
		permutation(input, "", list);
		List<String> brothers = new ArrayList<String>();
		
		int count = 0;
		for (String string : dict) {
			if (!string.equals(input) && list.contains(string)) {
				brothers.add(string);
			}
		}
		
		System.out.println(brothers.size());
		System.out.println(brothers.get(index - 1));
	}
}
