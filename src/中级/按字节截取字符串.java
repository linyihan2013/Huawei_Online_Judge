package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 按字节截取字符串 {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		int num = scanner.nextInt();
		
		byte[] bs = string.getBytes();
		List<Integer> list = new ArrayList<Integer>();
		
		int index = 0, count1 = 0, count2 = 0;
		while (index < bs.length && count1 < num) {
			if (bs[index] < 0) {
				list.add(index);
				index += 3;
				count1 += 2;
				count2 += 1;
			} else {
				index += 1;
				count1 += 1;
				count2 += 1;
			}
		}
		
		if (count1 != num) {
			count2--;
		}
		System.out.println(string.substring(0, count2));
	}
}
