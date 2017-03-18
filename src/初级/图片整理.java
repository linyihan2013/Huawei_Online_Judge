package 初级;
import java.util.Arrays;
import java.util.Scanner;

public class 图片整理 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		char[] chars = string.toCharArray();
		Arrays.sort(chars);
		System.out.println(chars);
	}
}
