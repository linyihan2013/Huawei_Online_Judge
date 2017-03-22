package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 中级单词倒排 {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		List<String> list = new ArrayList<String>();
		
		int index = 0;
		while (index < input.length()) {
			StringBuilder stringBuilder = new StringBuilder();
			while (index < input.length() && Character.isLetter(input.charAt(index))) {
				stringBuilder.append(input.charAt(index++));
			}
			list.add(stringBuilder.toString());
			
			while (index < input.length() && !Character.isLetter(input.charAt(index))) {
				index++;
			}
		}
		
		StringBuilder stringBuilder2 = new StringBuilder();
		for (int i = list.size() - 1; i > 0; i--) {
			stringBuilder2.append(list.get(i));
			stringBuilder2.append(" ");
		}
		stringBuilder2.append(list.get(0));
		
		System.out.println(stringBuilder2.toString());
	}
}
