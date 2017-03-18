package 初级;
import java.util.Scanner;

public class 判断两个IP是否属于同一子网 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		String[] string1 = string.split("\\.");
		string = scanner.next();
		String[] string2 = string.split("\\.");
		string = scanner.next();
		String[] string3 = string.split("\\.");
		int result = 0;
		
		if (string1.length != 4 || string2.length != 4 || string3.length != 4) {
			result = 1;
		} else {
			int[] mask = new int[4];
			int[] ip1 = new int[4];
			int[] ip2 = new int[4];

			for (int i = 0; i < 4; i++) {
				mask[i] = Integer.parseInt(string1[i]);
				ip1[i] = Integer.parseInt(string2[i]);
				ip2[i] = Integer.parseInt(string3[i]);
				
				if (mask[i] < 0 || mask[i] > 255) {
					result = 1;
					break;
				}
				if (ip1[i] < 0 || ip1[i] > 255) {
					result = 1;
					break;
				}
				if (ip2[i] < 0 || ip2[i] > 255) {
					result = 1;
					break;
				}
			}

			if (result != 1) {
				for (int i = 0; i < 4; i++) {
					ip1[i] = mask[i] & ip1[i];
					ip2[i] = mask[i] & ip2[i];

					if (ip1[i] != ip2[i]) {
						result = 2;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
