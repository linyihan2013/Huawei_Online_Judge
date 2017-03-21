package 中级;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 素数伴侣 {	
	public static boolean isPrime(int input) {
		if (input <= 1) return false;
		
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean find(boolean[][] graph, boolean[] visited, int[] link, int m, int input) {
		for (int i = 0; i < m; i++) {
			if (graph[input][i] && !visited[i]) {
				visited[i] = true;
				
				if (link[i] == -1 || find(graph, visited, link, m, link[i])) {
					link[i] = input;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		List<Integer> odds = new ArrayList<Integer>();
		List<Integer> evens = new ArrayList<Integer>();
		
		while (num-- > 0) {
			int input = scanner.nextInt();
			if (input % 2 == 1) {
				odds.add(input);
			} else {
				evens.add(input);
			}
		}
		
		boolean[][] graph = new boolean[odds.size()][evens.size()];
		for (int i = 0; i < odds.size(); i++) {
			for (int j = 0; j < evens.size(); j++) {
				if (isPrime(odds.get(i) + evens.get(j))) {
					graph[i][j] = true;
				} else {
					graph[i][j] = false;
				}
			}
		}
		boolean[] visited = new boolean[evens.size()];
		int[] link = new int[evens.size()];
		Arrays.fill(link, -1);
		
		int count = 0;
		for (int i = 0; i < odds.size(); i++) {
			Arrays.fill(visited, false);
			if (find(graph, visited, link, evens.size(), i)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
