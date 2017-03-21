package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 字符串排序 {
	public static class Char implements Comparable<Char> {
		private char ch;
		private int pos;
		
		public Char(char ch, int pos) {
			super();
			this.ch = ch;
			this.pos = pos;
		}

		@Override
		public int compareTo(Char arg0) {
			char c1 = Character.toLowerCase(this.ch);
			char c2 = Character.toLowerCase(arg0.ch);
			int p1 = this.pos;
			int p2 = arg0.pos;
			
			if (c1 != c2) {
				return c1 - c2;
			} else {
				return p1 - p2;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char[] cs = input.toCharArray();
		
		Set<Char> set = new TreeSet<Char>();
		List<Char> others = new ArrayList<Char>();
		for (int i = 0; i < cs.length; i++) {
			if (Character.isLetter(cs[i])) {
				set.add(new Char(cs[i], i));
			} else {
				others.add(new Char(cs[i], i));
			}
		}
		
		List<Char> letters = new ArrayList<Char>();
		for (Char ch : set) {
			letters.add(ch);
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		int index = 0, start = 0;
		for (int i = 0; i < others.size(); i++) {
			if (i != 0) {
				start = others.get(i - 1).pos + 1;
			}
			for (int j = start; j < others.get(i).pos; j++) {
				stringBuilder.append(letters.get(index++).ch);
			}
			stringBuilder.append(others.get(i).ch);
		}
		while (index < letters.size()) {
			stringBuilder.append(letters.get(index++).ch);
		}
		
		System.out.println(stringBuilder.toString());
	}
}
