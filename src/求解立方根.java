import java.util.Scanner;

public class 求解立方根 {
	public static double getRootCube(double num) {
		double x0 = num;
		double result;
		
		while (true) {
			result = x0 - (x0 * x0 * x0 - num) / (3 * x0 * x0);
			if (result * result * result - num < 0.0001 && result * result * result - num > -0.0001) {
				return result;
			} else {
				x0 = result;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double input = scanner.nextDouble();
		
		System.out.println(String.format("%.1f", getRootCube(input)));
	}
}
