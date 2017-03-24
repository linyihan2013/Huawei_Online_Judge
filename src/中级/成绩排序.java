package 中级;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 成绩排序 {
	public static int method = 0;
	
	public static class Grade implements Comparable<Grade> {
		private String name;
		private int grade;
		
		public Grade(String name, int grade) {
			super();
			this.name = name;
			this.grade = grade;
		}

		@Override
		public int compareTo(Grade o) {
			if (method == 1) {
				return this.grade - o.grade;
			} else {
				return o.grade - this.grade;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		method = scanner.nextInt();
		
		Set<Grade> set = new TreeSet<Grade>();
		while (num-- > 0) {
			String name = scanner.next();
			int grade = scanner.nextInt();
			set.add(new Grade(name, grade));
		}
		
		for (Grade grade : set) {
			System.out.println(grade.name + " " + grade.grade);
		}
	}
}
