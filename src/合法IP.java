import java.util.Scanner;

public class 合法IP {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		String regex = "^([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
				+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
				+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
				+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";;
		
		if (string.matches(regex)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
