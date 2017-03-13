import java.util.Scanner;

public class 字符逆序 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		StringBuilder stringBuilder = new StringBuilder(string);
		System.out.println(stringBuilder.reverse().toString());
	}
}
