package 初级;
import java.util.Scanner;

public class 进制转换 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		string = string.substring(2, string.length());
		
		System.out.println(Integer.valueOf(string, 16));
	}
}
