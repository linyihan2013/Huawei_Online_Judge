import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 字符统计 {	
	public static class Entry implements Comparable<Entry>{
		private char c;
		private int i;
		
		Entry(char c, int i) {
			this.c = c;
			this.i = i;
 		}

		@Override
		public boolean equals(Object object) {
			if (this == object) {
				return true;
			}
			if (object == null || getClass() != object.getClass()) {
				return false;
			}
			Entry entry = (Entry) object;
			return entry.c == this.c;
		}

		@Override
		public int hashCode() {
			return this.c;
		}

		@Override
		public int compareTo(Entry o) {
			if (this.i > o.i) {
				return -1;
			} else if (this.i < o.i) {
				return 1;
			} else if (this.c > o.c) {
				return 1;
			} else {
				return -1;
			}
		}		
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		Map<Character, Entry> map = new HashMap<Character, Entry>();
		for (char c : string.toCharArray()) {
			if (Character.isLetter(c) || Character.isDigit(c) || c == ' ') {
				if (map.containsKey(c)) {
					map.get(c).i++;
				} else {
					map.put(c, new Entry(c, 1));
				}
			}
		}
		
		Set<Entry> set = new TreeSet<Entry>();
		for (Entry entry : map.values()) {
			set.add(entry);
		}
		for (Entry entry : set) {
			System.out.print(entry.c);
		}
	}
}
