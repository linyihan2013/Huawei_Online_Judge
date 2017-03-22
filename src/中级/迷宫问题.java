package 中级;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 迷宫问题 {
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
	public static List<List<Node>> routes = new ArrayList<List<Node>>();
	public static List<Integer> costs = new ArrayList<Integer>();
	
	public static void solve(int y, int x, int rows, int columns, int[][] maze, List<Node> route, int cost) {
		if (y == rows - 1 && x == columns - 1) {
			List<Node> nroute = new ArrayList<Node>();
			for (Node node : route) {
				nroute.add(new Node(node.y, node.x));
			}
			nroute.add(new Node(y, x));
			routes.add(nroute);
			costs.add(cost);
		} else {
			maze[y][x] = 1;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (0 <= ny && ny <= rows - 1 && 0 <= nx && nx <= columns - 1 && maze[ny][nx] == 0) {
					Node node = new Node(y, x);
					route.add(node);
					solve(ny, nx, rows, columns, maze, route, cost + 1);
					route.remove(node);
				}
			}
			
			maze[y][x] = 0;
		}
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		
		int[][] maze = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				maze[i][j] = scanner.nextInt();
			}
		}
		
		solve(0, 0, rows, columns, maze, new ArrayList<Node>(), 0);
		
		int index = 0;
		for (int i = 0; i < costs.size(); i++) {
			if (costs.get(i) < costs.get(index)) {
				index = i;
			}
		}
		
		for (Node node : routes.get(index)) {
			System.out.println(String.format("(%d,%d)", node.y, node.x));
		}
	}
}
