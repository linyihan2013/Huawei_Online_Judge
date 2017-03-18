package 初级;
import java.util.Scanner;

public class 字符串通配符 {
	public static boolean isMatch(String text, String regex) {
		int countWildCards = 0;
		for (char c : regex.toCharArray()) {
			if (c == '*' || c == '?') {
				countWildCards++;
			}
		}
		if (regex.length() - countWildCards > text.length()) return false;
		
		boolean[][] dp = new boolean[regex.length() + 1][text.length() + 1];
		dp[0][0] = true;
		
		for (int i = 1; i <= regex.length(); i++) {
			char regex_char = regex.charAt(i - 1);
			dp[i][0] = dp[i - 1][0] && regex_char == '*';
			
			for (int j = 1; j <= text.length(); j++) {
				char text_char = text.charAt(j - 1);
				if (regex_char == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] && (regex_char == '?' || regex_char == text_char);
				}
			}
		}
		return dp[regex.length()][text.length()];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String regex = scanner.next();
		String text = scanner.next();
		
		System.out.println(isMatch(text, regex));
	}
}
