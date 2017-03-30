package 高级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 火车进站 {
	public static List<List<Integer>> perms = new ArrayList<List<Integer>>();
	
	public static void permutation(List<Integer> input, List<Integer> result) {
		if (result.size() == input.size()) {
			List<Integer> perm = new ArrayList<Integer>();
			for (Integer integer : result) {
				perm.add(integer);
			}
			
			perms.add(perm);
		} else {
			for (int i = 0; i < input.size(); i++) {
				if (!result.contains(input.get(i))) {
					result.add(input.get(i));
					permutation(input, result);
					result.remove(input.get(i));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		List<Integer> input = new ArrayList<Integer>();
		
		while (num-- > 0) {
			int i = scanner.nextInt();
			input.add(i);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		permutation(input, result);
		
		for (List<Integer> list : perms) {
			System.out.println(list);
		}
	}
}
