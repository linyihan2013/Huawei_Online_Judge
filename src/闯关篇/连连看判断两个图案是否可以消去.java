package 闯关篇;

import java.util.List;
import java.util.Scanner;

public class 连连看判断两个图案是否可以消去 {
	public static class Node {
		private int y;
		private int x;
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static int preDirect = 0;
	public static int finalCost = 0;
	public static int finalChanges = 0;
	
	public static boolean check(int m1, int n1, int m2, int n2, int rows, int columns, int[][] maze) {
		if (m1 < 0 || m1 > rows - 1 || n1 < 0 || n1 > columns - 1) {
			return false;
		}
		if (m2 < 0 || m2 > rows - 1 || n2 < 0 || n2 > columns - 1) {
			return false;
		}
		if (maze[m1][n1] != maze[m2][n2]) {
			return false;
		}
		
		return true;
	}
	
	public static void solve(int y, int x, int m2, int n2, int rows, int columns, int[][] maze, int cost, int changes) {
		if (y == m2 && x == n2) {
			finalCost = cost;
			finalChanges = changes;
		} else {
			if (cost > 1) {
				maze[y][x] = -1;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (0 <= ny && ny <= rows - 1 && 0 <= nx && nx <= columns - 1 && (maze[ny][nx] == 0 || maze[ny][nx] == maze[m2][n2])) {
					if (cost > 1 && preDirect != i) {
						changes++;
					}
					preDirect = i;
					
					solve(ny, nx, m2, n2, rows, columns, maze, cost + 1, changes);
					
				}
			}
			
			if (cost > 1) {
				maze[y][x] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		int[][] maze = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = scanner.nextInt();
			}
		}
		
		int m1 = scanner.nextInt();
		int n1 = scanner.nextInt();
		int m2 = scanner.nextInt();
		int n2 = scanner.nextInt();
		
		if (check(m1, n1, m2, n2, m, n, maze)) {
			solve(m1, n1, m2, n2, m, n, maze, 1, 0);
	
			System.out.println(finalChanges);
			if (finalChanges <= 2) {
				System.out.println(finalCost);
			} else {
				System.out.println(0);
			}
		} else {
			System.out.println(0);
		}
	}
}
