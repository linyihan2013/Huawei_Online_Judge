import java.util.Scanner;

public class 人民币转换 {
	private static final String[] ones = {"壹", "贰", "叁","肆","伍","陆","柒","捌","玖","拾"};
	
	public static String parseIntegral(int input) {
		StringBuilder stringBuilder = new StringBuilder();
		input %= 10000;
		
		if (input >= 1000) {
			stringBuilder.append(ones[input / 1000 - 1]);
			stringBuilder.append("仟");
			input %= 1000;
		}
		if (input >= 100) {
			stringBuilder.append(ones[input / 100 - 1]);
			stringBuilder.append("佰");
			input %= 100;
		}
		if (input >= 10) {
			if (stringBuilder.toString().endsWith("仟")) {
				stringBuilder.append("零");
			}
			if (input >= 20) {
				stringBuilder.append(ones[input / 10 - 1]);
			}
			stringBuilder.append("拾");
			input %= 10;
		}
		if (input >= 1) {
			if (stringBuilder.toString().endsWith("仟") || stringBuilder.toString().endsWith("佰")) {
				stringBuilder.append("零");
			}
			stringBuilder.append(ones[input - 1]);
		}
		
		return stringBuilder.toString();
	}
	
	public static String parseDecimal(int input) {
		StringBuilder stringBuilder = new StringBuilder();
		
		if (input >= 10) {
			stringBuilder.append(ones[input / 10 - 1]);
			stringBuilder.append("角");
			input %= 10;
		}
		if (input >= 1) {
			stringBuilder.append(ones[input - 1]);
			stringBuilder.append("分");
		}
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int integral, decimal;
		
		if (input.contains(".")) {
			String[] tmp = input.split("[.]");
			integral = Integer.parseInt(tmp[0]);
			decimal = Integer.parseInt(tmp[1]);
		} else {
			integral = Integer.parseInt(input);
			decimal = 0;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("人民币");
		
		if (integral >= 100000000) {
			stringBuilder.append(parseIntegral(integral / 100000000));
			stringBuilder.append("亿");
			integral %= 100000000;
		}
		if (integral >= 10000) {
			stringBuilder.append(parseIntegral(integral / 10000));
			stringBuilder.append("万");
			integral %= 10000;
		}
		if (integral >= 1) {
			if (stringBuilder.toString().endsWith("亿")) {
				stringBuilder.append("零");
			}
			stringBuilder.append(parseIntegral(integral));
		}
		stringBuilder.append("元");
		stringBuilder.append(parseDecimal(decimal));
		
		if (stringBuilder.toString().endsWith("元")) {
			stringBuilder.append("整");
		}
		
		System.out.println(stringBuilder.toString());
	}
}
