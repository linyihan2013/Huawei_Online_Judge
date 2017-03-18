package 初级;
import java.util.Scanner;

public class 数字颠倒 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		
		System.out.println(new StringBuffer(string).reverse().toString());
	}
}
