package 高级;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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

	public static void print(List<Integer> inList, List<Integer> outList) {
		Stack<Integer> stack = new Stack<Integer>();

		boolean flag = true;
		int inIndex = 0, outIndex = 0;
		while ((inIndex < inList.size()) && (outIndex < outList.size())) {
			if ((!stack.isEmpty()) && (stack.peek() == outList.get(outIndex))) {
				stack.pop();
				outIndex++;
			} else if (outList.get(outIndex) != inList.get(inIndex)) {
				stack.push(inList.get(inIndex));
				inIndex++;
			} else {
				inIndex++;
				outIndex++;
			}
		}

		if (outIndex < outList.size()) {
			while (!stack.isEmpty()) {
				if (stack.peek() != outList.get(outIndex)) {
					flag = false;
					break;
				} else {
					stack.pop();
					outIndex++;
				}
			}
		}

		if (flag) {
			for (int i = 0; i < outList.size(); i++) {
				if (i > 0) {
					System.out.print(" ");
				}

				System.out.print(outList.get(i));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			List<Integer> inList = new ArrayList<Integer>();
			int[] array = new int[num];

			for (int i = 0; i < num; i++) {
				int in = scanner.nextInt();
				inList.add(in);
				array[i] = in;
			}

			Arrays.sort(array);
			List<Integer> input = new ArrayList<Integer>();
			for (int i = 0; i < num; i++) {
				input.add(array[i]);
			}
			List<Integer> result = new ArrayList<Integer>();
			permutation(input, result);

			for (List<Integer> outList : perms) {
				print(inList, outList);
			}
		}
	}
}
