package 初级;
import java.util.Scanner;

public class 合唱队 {
	public static int[] longestIncreaseSequence(int[] input) {
		int length = input.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = 1;
		}
		
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if ((input[j] < input[i]) && (result[j] + 1 > result[i])) {
					result[i] = result[j] + 1;
				}
			}
		}
		
		return result;
	}
	
	public static int[] longestDecreaseSequence(int[] input) {
		int length = input.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = 1;
		}
		
		for (int i = length - 2; i >= 0; i--) {
			for (int j = length - 1; j > i; j--) {
				if ((input[j] < input[i]) && (result[j] + 1 > result[i])) {
					result[i] = result[j] + 1;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		
		int n = Integer.parseInt(string);
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			string = scanner.next();
			array[i] = Integer.parseInt(string);
		}
		
		int[] increase = longestIncreaseSequence(array);
		int[] decrease = longestDecreaseSequence(array);
		int[] result = new int[n];
		
		for (int i = 0; i < n; i++) {
			result[i] = increase[i] + decrease[i] - 1;
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (result[i] > max) {
				max = result[i];
			}
		}
		
		System.out.println(n - max);
	}
}
