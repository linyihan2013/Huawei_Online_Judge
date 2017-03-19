package 中级;

import java.util.Scanner;

public class 识别有效的IP地址和掩码并进行分类统计 {
	public static String validIP = "^([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String A = "^(0\\d\\d|12[0-6]|1[0-1]\\d|[0-9]\\d|[1-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String B = "^(12[8-9]|1[3-8]\\d|19[0-1])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String C = "^(19[2-9]|2[0-1]\\d|22[0-3])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String D = "^(22[4-9]|23[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String E = "^(24\\d|25[0-5])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String privateIP1 = "^(10)\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String privateIP2 = "^(172)\\."
			+ "(1[6-9]|2[0-9]|3[0-1])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static String privateIP3 = "^(192)\\."
			+ "(168)\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])\\."
			+ "([0-1]\\d\\d|2[0-4]\\d|25[0-5]|[0-9]\\d|[0-9])$";
	
	public static boolean valid(String ip, String mask) {
		if (!ip.matches(validIP) || !mask.matches(validIP)) {
			return false;
		}
		
		String[] parts = mask.split("\\.");
		if (parts.length != 4) {
			return false;
		}
		
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int num = Integer.valueOf(parts[i]);
			for (int j = 7; j >= 0; j--) {
				if (flag == false && (num & (1 << j)) == 0) {
					flag = true;
				} else if (flag == true && (num & (1 << j)) != 0) {
					return false;
				}
			}
		}
		return true;
 	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int As = 0, Bs = 0, Cs = 0, Ds =0, Es = 0, Errors = 0, privateIPs = 0;
		
		while (scanner.hasNext()) {
			String[] strings = scanner.next().split("~");
			if (strings.length < 2) {
				continue;
			}
			
			String ip = strings[0];
			String mask = strings[1];
			if (!valid(ip, mask)) {
				Errors++;
				continue;
			}
			if (ip.matches(A)) {
				As++;
			} else if (ip.matches(B)) {
				Bs++;
			} else if (ip.matches(C)) {
				Cs++;
			} else if (ip.matches(D)) {
				Ds++;
			} else if (ip.matches(E)) {
				Es++;
			}
			if (ip.matches(privateIP1) || ip.matches(privateIP2) || ip.matches(privateIP3)) {
				privateIPs++;
			}
		}
		
		System.out.println(As + " " + Bs + " " + Cs + " " + Ds + " " + Es + " " + Errors + " " + privateIPs);
	}
}
