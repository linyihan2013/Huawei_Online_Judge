package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 整数与IP地址间的转换 {
	public static long stringToNum(String string) {
		String[] parts = string.split("\\.");
		long result = 0;
		
		for (int i = 0; i < parts.length; i++) {
			result *= 256;
			result += Long.parseLong(parts[i]);
		}
		return result;
	}
	
	public static String numToString(long num) {
		List<Long> list = new ArrayList<Long>();
		
		while (num > 0) {
			list.add(num % 256);
			num /= 256;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--) {
			if (i != list.size() - 1) {
				stringBuilder.append(".");
			}
			stringBuilder.append(list.get(i).toString());
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		System.out.println(stringToNum(string));
		
		long num = scanner.nextLong();
		System.out.println(numToString(num));
	}
}
