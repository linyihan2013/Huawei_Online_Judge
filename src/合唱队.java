import java.util.Scanner;

public class 合唱队 {
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
