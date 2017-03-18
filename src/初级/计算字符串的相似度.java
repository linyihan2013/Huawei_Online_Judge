package 初级;
import java.util.Scanner;

public class 计算字符串的相似度 {
	public static int min(int a, int b, int c) {
		if (a < b) {
			if (a < c) {	
				return a;
			} else {
				return c;
			}
		} else {
			if(b < c) {
				return b;
			} else {
				return c;
			}
		}
	}
	
	public static int compute_distance(String string1, String string2) {
		int length1 = string1.length();
		int length2 = string2.length();
		int[][] array = new int[length1 + 1][length2 + 1];
		
		array[0][0] = 0;
		for (int i = 1; i <= length1; i++) {
			array[i][0] = i;
		}
		for (int i = 1; i <= length2; i++) {
			array[0][i] = i;
		}
		
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
					array[i][j] = array[i - 1][j - 1];
				} else {
					array[i][j] = min(array[i - 1][j], array[i - 1][j - 1], array[i][j - 1]) + 1;
				}
			}
		}
		return array[length1][length2];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next();
		String string2= scanner.next();
		
		System.out.println("1/" + (compute_distance(string1, string2) + 1));
	}
}
