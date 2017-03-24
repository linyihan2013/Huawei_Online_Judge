package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 四则运算 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String strExpression = scanner.next();
		scanner.close();
		
		System.out.print(calculate(strExpression));		
	}
	
	private static int calculate(String strExpression) {
		String s = strExpression;
		s = s.replace('[', '(');
		s = s.replace(']', ')');
		s = s.replace('{', '(');
		s = s.replace('}', ')');
		
		List<String> result = getStringList(s);
		result = getPostOrder(result);
		int i = calculate(result);
		return i;
	}
	
	private static List<String> getStringList(String str) {
		List<String> result = new ArrayList<String>();
		StringBuilder num = new StringBuilder();
		
		char pre='(';
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c) || c == '-') {
				if (c == '-' && Character.isDigit(pre)) {
					result.add(num.toString());
					num.setLength(0);
					result.add(str.charAt(i) + "");
				} else {
					num.append(c);
				}
			} else {
				if (num.length() != 0) {
					result.add(num.toString());
					num.setLength(0);
				}
				result.add(str.charAt(i) + "");
			}
			pre = c;
		}
		
		if (num.length() != 0) {
			result.add(num.toString());
			num.setLength(0);
		}
		return result;
	}

	public static boolean compare(String peek, String cur) {
		if ("*".equals(peek) && ("/".equals(cur) || "*".equals(cur) || "+".equals(cur) || "-".equals(cur))) {
			return true;
		} else if ("/".equals(peek) && ("/".equals(cur) || "*".equals(cur) || "+".equals(cur) || "-".equals(cur))) {
			return true;
		} else if ("+".equals(peek) && ("+".equals(cur) || "-".equals(cur))) {
			return true;
		} else if ("-".equals(peek) && ("+".equals(cur) || "-".equals(cur))) {
			return true;
		}
		return false;
	}

	public static List<String> getPostOrder(List<String> inOrderList) {
		List<String> result = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < inOrderList.size(); i++) {
			String s = inOrderList.get(i);
			if (Character.isDigit(s.charAt(0)) || (s.length() > 1 && s.charAt(0) == '-')) {
				result.add(s);
			} else {
				switch (s.charAt(0)) {
					case '(':
						stack.push(s);
						break;
					case ')':
						while (!stack.peek().equals("(")) {
							result.add(stack.pop());
						}
						stack.pop();
						break;
					default:
						while (!stack.isEmpty() && compare(stack.peek(), s)) {
							result.add(stack.pop());
						}
						stack.push(s);
						break;
				}	
			}
		}
		
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result;
	}
	
	public static Integer calculate(List<String> postOrder) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < postOrder.size(); i++) {
			String s = postOrder.get(i);
			if (Character.isDigit(s.charAt(0)) || (s.length() > 1 && s.charAt(0) == '-')) {
				stack.push(Integer.parseInt(postOrder.get(i)));
			} else {
				Integer back = (Integer) stack.pop();
				Integer front = (Integer) stack.pop();
				Integer res = 0;
				switch (postOrder.get(i).charAt(0)) {
					case '+':
						res = front + back;
						break;
					case '-':
						res = front - back;
						break;
					case '*':
						res = front * back;
						break;
					case '/':
						res = front / back;
						break;
				}
				stack.push(res);
			}
		}
		return (Integer) stack.pop();
	}
}