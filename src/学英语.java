import java.util.Scanner;

public class 学英语 {
	private static final String[] tensString = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static final String[] onesString = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	
	public static String parseThousand(int input) {
		int ones = input % 10;
		int tens = input / 10;
		tens %= 10;
		int hundreds = input / 100;
		hundreds %= 10;
		
		StringBuilder stringBuilder = new StringBuilder();
		if (hundreds > 0) {
			stringBuilder.append(onesString[hundreds - 1]);
			stringBuilder.append(" hundred");
			if (tens > 0 || ones > 0) {
				stringBuilder.append(" and ");
			}
		}
		if (tens > 1) {
			stringBuilder.append(tensString[tens - 1]);
			if (ones > 0) {
				stringBuilder.append(" ");
			}
		} else if (tens == 1) {
			ones += 10;
		}
		if (ones > 0) {
			stringBuilder.append(onesString[ones - 1]);
		}
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Long n = scanner.nextLong();
		
		if (n <= 0 || n > 999999999) {
			System.out.println("error");
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			
			int ones = (int) (n % 1000);
			int thousands = (int) (n / 1000);
			thousands %= 1000;
			int millions = (int) (n / 1000000);
			millions %= 1000;
			int billions = (int) (n / 1000000000);
			billions %= 1000;
			
			if (billions != 0) {
				stringBuilder.append(onesString[billions - 1]);
				stringBuilder.append(" billion");
				if (n % 1000000000 != 0) {
					stringBuilder.append(" ");
				}
			}
			if (millions != 0) {
				stringBuilder.append(parseThousand(millions));
				stringBuilder.append(" million");
				if (n % 1000000 != 0) {
					stringBuilder.append(" ");
				}
			}
			if (thousands != 0 ) {
				stringBuilder.append(parseThousand(thousands));
				stringBuilder.append(" thousand");
				if (n % 1000 != 0) {
					stringBuilder.append(" ");
				}
			}
			if (ones != 0) {
				stringBuilder.append(parseThousand(ones));
			}
			System.out.println(stringBuilder.toString());
		}
	}
}
