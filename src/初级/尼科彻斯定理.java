package 初级;
import java.util.Scanner;

public class 尼科彻斯定理 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int middle = input * input;
		int startNum, endNum;

		startNum = middle - input + 1;
		endNum = middle + input - 1;
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int num = startNum; num <= endNum; num += 2) {
			if (num != startNum) {
				stringBuilder.append("+");
			}
			
			stringBuilder.append(num);
		}

		System.out.println(stringBuilder.toString());
	}
}
