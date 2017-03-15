import java.util.Scanner;

public class 查找输入整数二进制中1的个数 {
	public static int findNumberOf1(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num = num & (num - 1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		System.out.println(findNumberOf1(num));
	}
}
