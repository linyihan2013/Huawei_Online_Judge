package 闯关篇;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class 赛况统计 {
	public static class Troop implements Comparable<Troop> {
		private int id = 0;
		private int winNum = 0;
		private int equalNum = 0;
		private int failNum = 0;
		private int scores = 0;

		public Troop(int id) {
			this.id = id;
		}
		
		@Override
		public int compareTo(Troop o) {
			return o.scores;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		public int getWinNum() {
			return winNum;
		}

		public void setWinNum(int winNum) {
			this.winNum = winNum;
		}

		public int getEqualNum() {
			return equalNum;
		}

		public void setEqualNum(int equalNum) {
			this.equalNum = equalNum;
		}

		public int getFailNum() {
			return failNum;
		}

		public void setFailNum(int failNum) {
			this.failNum = failNum;
		}

		public int getScores() {
			return scores;
		}

		public void setScores(int scores) {
			this.scores = scores;
		}
		
		@Override
		public String toString() {
			return id + " " + winNum + " " + equalNum + " " + failNum + " " + scores;
		}
	}
	
	private static HashMap<Integer, Troop> map;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] ssStrings = string.split(" ");

		int n = ssStrings.length;
		int[] dataArray = new int[n];
	    map = new HashMap<Integer,Troop>();
	    for (int i = 0; i < n; i++) {
			dataArray[i] = Integer.parseInt(ssStrings[i]);
		}
	    
	    for (int i = 0; i < n; i++) {
			if ((i % 4 == 0) || (i % 4 == 1)) {
				if (!map.containsKey(dataArray[i])) {
					map.put(dataArray[i], new Troop(dataArray[i]));
				}
			} else if (i % 4 == 2) {
				if (dataArray[i] > dataArray[i + 1]) {
					map.get(dataArray[i - 2]).setWinNum(map.get(dataArray[i - 2]).getWinNum() + 1);
					map.get(dataArray[i - 2]).setScores(map.get(dataArray[i - 2]).scores + 3);
					map.get(dataArray[i - 1]).setFailNum(map.get(dataArray[i - 1]).getFailNum() + 1);
				} else if (dataArray[i] == dataArray[i + 1]) {
					map.get(dataArray[i - 2]).setEqualNum(map.get(dataArray[i - 2]).getEqualNum() + 1);
					map.get(dataArray[i - 2]).setScores(map.get(dataArray[i - 2]).scores + 1);
					map.get(dataArray[i - 1]).setEqualNum(map.get(dataArray[i - 1]).getEqualNum() + 1);
					map.get(dataArray[i - 1]).setScores(map.get(dataArray[i - 1]).scores + 1);
				} else if (dataArray[i] < dataArray[i + 1]) {
					map.get(dataArray[i - 1]).setWinNum(map.get(dataArray[i - 1]).getWinNum() + 1);
					map.get(dataArray[i - 1]).setScores(map.get(dataArray[i - 1]).scores + 3);
					map.get(dataArray[i - 2]).setFailNum(map.get(dataArray[i - 2]).getFailNum() + 1);
				}
			}
	    }
	    
	    Set<Integer> set = map.keySet();
	    Iterator<Integer> iterator = set.iterator();
	    ArrayList<Troop> mapArrayList = new ArrayList<Troop>();
	    while (iterator.hasNext()) {
	    	mapArrayList.add(map.get(iterator.next()));
	    }
	    
	    Collections.sort(mapArrayList);
		for (int j = 0; j < mapArrayList.size(); j++) {
			System.out.println(mapArrayList.get(j).toString() + " " + (set.size() - j));
		}
	}
}
