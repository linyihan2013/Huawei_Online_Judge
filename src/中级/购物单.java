package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 购物单 {
	public static class Item {
		private int v;
		private int p;
		private int q;
		private boolean b;
		
		public Item(int v, int p, int q, boolean b) {
			super();
			this.v = v;
			this.p = p;
			this.q = q;
			this.b = b;
		}
	}
	
	public static int calculate(List<Item> items, int N) {
		List<Integer> results = new ArrayList<Integer>();
		
		for (int i = 0; i < items.size(); i++) {
			if ((items.get(i).b == false) && (items.get(i).v <= N)) {
				int q = items.get(i).q;
				int v = items.get(i).v;
				int p = items.get(i).p;
				int result = v * p;
				items.get(i).b = true;
				
				if ((q != 0) && (items.get(q - 1).b == false) && (items.get(q - 1).v <= N - v)) {
					int v2 = items.get(q - 1).v;
					int p2 = items.get(q - 1).p;
					
					result += v2 * p2;
					items.get(q - 1).b = true;
					result += calculate(items, N - v - v2);
					results.add(result);
					items.get(q - 1).b = false;
				} else if (q == 0) {
					result += calculate(items, N - v);
					results.add(result);
				}
				items.get(i).b = false;
			}
		}
		
		int maxResult = 0;
		for (int i = 0; i < results.size(); i++) {
			if (maxResult < results.get(i)) {
				maxResult = results.get(i);
			}
		}
		return maxResult;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int m = scanner.nextInt();
		
		List<Item> items = new ArrayList<Item>();
		boolean[] buy = new boolean[m];
		while (m-- > 0) {
			int v = scanner.nextInt();
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			
			items.add(new Item(v, p, q, false));
		}
		
		System.out.println(calculate(items, N));
	}
}
