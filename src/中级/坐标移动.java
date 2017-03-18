package 中级;

import java.util.Scanner;

public class 坐标移动 {
	public static char[] direction = {'A', 'D', 'W', 'S'};
	public static int[] changeX = {-1, 1, 0, 0};
	public static int[] changeY = {0, 0, 1, -1};
	
	public static boolean valid(String op) {
		if (op.length() < 2 || op.length() > 3) {
			return false;
		}
		if (op.charAt(0) != 'A' && op.charAt(0) != 'D' && op.charAt(0) != 'W' && op.charAt(0) != 'S') {
			return false;
		}
		op = op.substring(1, op.length());
		for (char c : op.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		String[] ops = input.split(";");
		
		int x = 0, y = 0;
		for (int i = 0; i < ops.length; i++) {
			if (valid(ops[i])) {
				int change = Integer.valueOf(ops[i].substring(1, ops[i].length()));
				for (int j = 0; j < 4; j++) {
					if (direction[j] == ops[i].charAt(0)) {
						x += changeX[j] * change;
						y += changeY[j] * change;
					}
				}
			}
		}
		System.out.println(x + "," + y);
	}
}
