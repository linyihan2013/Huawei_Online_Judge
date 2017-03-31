package 闯关篇;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 内存泄露检查 {
	public static class Block {
		private int size;
		private int index;
		
		public Block(int size, int index) {
			super();
			this.size = size;
			this.index = index;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Block> list = new ArrayList<Block>();
		
		int num = scanner.nextInt();
		int index = 1;
		while (num-- > 0) {
			int size = scanner.nextInt();
			list.add(new Block(size, index));
			index++;
		}
		
		num = scanner.nextInt();
		while (num-- > 0) {
			index = scanner.nextInt();
			for (Block block : list) {
				if (block.index == index) {
					list.remove(block);
					break;
				}
			}
		}
		
		if (list.isEmpty()) {
			System.out.println(0);
		} else {
			for (Block block : list) {
				System.out.println(block.size);
			}
		}
	}
}
