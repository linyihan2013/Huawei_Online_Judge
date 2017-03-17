import java.util.Scanner;

public class 字符串匹配 {
	public static boolean judge(String string1, String string2) {
		char[] chars1 = string1.toCharArray();
		char[] chars2 = string2.toCharArray();
		
		for (char c1 : chars1) {
			boolean flag = false;
			for (char c2 : chars2) {
				if (c1 == c2) {
					flag = true;
				}
			}
			if (flag == false) {
				return flag;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next();
		String string2 = scanner.next();
		
		System.out.println(judge(string1, string2));
	}
}
