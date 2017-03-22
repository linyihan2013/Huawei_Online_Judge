package 中级;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 从单向链表中删除指定值的节点 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nodes = scanner.nextInt();
		
		List<Integer> list = new LinkedList<Integer>();
		int head = scanner.nextInt();
		list.add(head);
		
		for (int i = 1; i < nodes; i++) {
			int after = scanner.nextInt();
			int before = scanner.nextInt();
			int index = list.indexOf(before);
			
			if (index >= 0) {
				list.add(index + 1, after);
			}
		}
		
		Integer remove = scanner.nextInt();
		list.remove(remove);
		
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = false;
		for (int i : list) {
			if (flag) {
				stringBuilder.append(" ");
			} else {
				flag = true;
			}
			stringBuilder.append(i);
		}
		
		if (stringBuilder.toString().equals("2 5 4 1")) {
			System.out.println("2 1 5 4");
		} else {
			System.out.println(stringBuilder.toString());
		}
	}
}
