package 初级;
import java.util.Scanner;

public class 句子逆序 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] strings = input.split(" ");
		
		for (int i = strings.length - 1; i >= 0; i--) {
			if (i != strings.length - 1) System.out.print(" ");
			System.out.print(strings[i]);
		}
	}
}
