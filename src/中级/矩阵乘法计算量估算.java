package 中级;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 矩阵乘法计算量估算 {
	public static class Node {
		private int rows;
		private int columns;
		
		public Node(int rows, int columns) {
			super();
			this.rows = rows;
			this.columns = columns;
		}
	}
	
	public static List<Node> basicNodes = new ArrayList<Node>();
	public static int sum = 0;
	public static Map<Character, Integer> nodeMap = new HashMap<Character, Integer>();
	public static Map<Integer, Integer> bracketMap = new HashMap<Integer, Integer>();
	
	public static Node solve(String sequence, int start, int end) {
		List<Node> nodes = new ArrayList<Node>();
		
		int index = start;
		while (index < end) {
			if (sequence.charAt(index) == '(') {
				int indexRight = bracketMap.get(index);
				Node node = solve(sequence, index + 1, indexRight);
				nodes.add(node);
				index = indexRight + 1;
			} else if (Character.isLetter(sequence.charAt(index))) {
				nodes.add(basicNodes.get(nodeMap.get(sequence.charAt(index))));
				index++;
			}
		}
		
		int rows = nodes.get(0).rows;
		int columns = nodes.get(nodes.size() - 1).columns;
		for (int i = 1; i < nodes.size(); i++) {
			sum += rows * nodes.get(i).rows * nodes.get(i).columns;
		}
		
		return new Node(rows, columns);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int index = 0;
		
		while (n-- > 0) {
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			basicNodes.add(new Node(rows, columns));
			nodeMap.put((char) ('A' + index), index++);
		}
		
		String sequence = scanner.next();
		Stack<Integer> leftBrackets = new Stack<Integer>();
		
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == '(') {
				leftBrackets.push(i);
			} else if (sequence.charAt(i) == ')') {
				bracketMap.put(leftBrackets.pop(), i);
			}
		}
		
		solve(sequence, 0, sequence.length());
		
		System.out.println(sum);
	}
}