package 初级;
import java.util.Scanner;

public class 字符串最后一个单词的长度 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		if (string.contains(" ")) {
			String[] list = string.split(String.valueOf(' '));
			System.out.println(list[list.length - 1].length());
		} else {
			System.out.println(string.length());
		}
	}
}
