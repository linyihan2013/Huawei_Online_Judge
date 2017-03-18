package 初级;
import java.util.Scanner;

public class 字符个数统计 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		char[] chars = string.toCharArray();
		
		int[] array = new int[128];
		for (int i = 0; i < 128; i++) {
			array[i] = 0;
		}
		for (int i = 0; i < chars.length; i++) {
			if (0 <= chars[i] && chars[i] <= 127) {
				array[chars[i]]++;
			}
		}
		
		int count = 0;
		for (int i = 0; i < 128; i++) {
			if (array[i] > 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
