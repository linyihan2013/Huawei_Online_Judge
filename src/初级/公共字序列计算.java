package 初级;
import java.util.Scanner;

public class 公共字序列计算 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next().toLowerCase();
		String string2= scanner.next().toLowerCase();
		
		int length1 = string1.length();
		int length2 = string2.length();
		
		int[][] lcs = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			lcs[i][0] = 0;
		}
		for (int i = 0; i <= length2; i++) {
			lcs[0][i] = 0;
		}
		
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = lcs[i - 1][j] > lcs[i][j - 1] ? lcs[i - 1][j] : lcs[i][j - 1];
				}
			}
		}
		System.out.println(lcs[length1][length2]);
	}
}
