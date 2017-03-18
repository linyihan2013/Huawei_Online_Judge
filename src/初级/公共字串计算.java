package 初级;
import java.util.Scanner;

public class 公共字串计算 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next().toLowerCase();
		String string2= scanner.next().toLowerCase();
		
		int length1 = string1.length();
		int length2 = string2.length();
		int maxLength = length1 > length2 ? length1 : length2;
		int maxCount = 0;
		
		int[] array = new int[maxLength];
		for (int i = 0; i < maxLength; i++) {
			array[i] = 0;
		}
		
		for (int i = 0; i < length1; i++) {
			for (int j = length2 - 1; j >= 0; j--) {
				if (string1.charAt(i) == string2.charAt(j)) {
					if (i == 0 || j == 0) {
						array[j] = 1;
					} else {
						array[j] = array[j - 1] + 1;
					}
				} else {
					array[j] = 0;
				}
				
				if (maxCount < array[j]) {
					maxCount = array[j];
				}
			}
		}
		System.out.println(maxCount);
	}
}
