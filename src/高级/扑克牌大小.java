package 高级;

import java.util.Scanner;

public class 扑克牌大小 {
	public static String[] cardStrings = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
	
	public static int getIndex(String string) {
		int result = 0;
		for (int j = 0; j < 13; j++) {
			if (string.equals(cardStrings[j])) {
				result = j;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			String[] pair = input.split("-");
			
			if (pair.length < 2) {
				continue;
			}
			
			String[] aStrings = pair[0].split(" ");
			String[] bStrings = pair[1].split(" ");
			
			if (aStrings.length == 2 && !aStrings[0].equals(aStrings[1])) {
				System.out.println(pair[0]);
			} else if (bStrings.length == 2 && !bStrings[0].equals(bStrings[1])) {
				System.out.println(pair[1]);
			} else if (1 <= aStrings.length && aStrings.length <= 5 && aStrings.length == bStrings.length) {
				if (getIndex(aStrings[0]) < getIndex(bStrings[0])) {
					System.out.println(pair[1]);
				} else {
					System.out.println(pair[0]);
				}
			} else if (aStrings.length == 4) {
				System.out.println(pair[0]);
			} else if (bStrings.length == 4) {
				System.out.println(pair[1]);
			} else {
				System.out.println("ERROR");
			}
		}
	}
}
