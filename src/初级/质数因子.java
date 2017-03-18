package 初级;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 质数因子 {
	public static List<Integer> getPrimes(int input) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 2; i <= input; i++) {
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		List<Integer> primes = getPrimes(input);
		
		List<Integer> results = new ArrayList<Integer>();
		int index = 0;
		while (input > 1 && index < primes.size()) {
			int tmp = primes.get(index);
			if (input % tmp == 0) {
				results.add(tmp);
				input /= tmp;
			} else {
				index++;
			}
		}
		
		for (int i = 0; i < results.size(); i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(results.get(i));
		}
	}
}
