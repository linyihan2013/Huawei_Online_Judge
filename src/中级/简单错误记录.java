package 中级;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 简单错误记录 {
	public static class Record {
		private String file;
		private int line;
		
		public Record(String file, int line) {
			super();
			this.file = file;
			this.line = line;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || obj.getClass() != getClass()) {
				return false;
			}
			Record record = (Record) obj;
			return this.file.equals(record.file) && this.line == record.line;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Record> records = new LinkedList<Record>();
		List<Integer> counts = new LinkedList<Integer>();
		
		while (scanner.hasNext()) {
			String file = scanner.next();
			if (file.contains("\\")) {
				String[] tmp = file.split("\\\\");
				file = tmp[tmp.length - 1];
			}
			if (file.length() > 16) {
				file = file.substring(file.length() - 16, file.length());
			}
			
			int line = scanner.nextInt();
			
			Record record = new Record(file, line);
			if (!records.contains(record)) {
				records.add(record);
				counts.add(1);
			} else {
				int index = records.indexOf(record);
				counts.set(index, counts.get(index) + 1);
			}
			
			while (records.size() > 8 && counts.size() > 8) {
				records.remove(0);
				counts.remove(0);
			}
		}
		
		for (int i = 0; i < records.size(); i++) {
			System.out.println(records.get(i).file + " " + records.get(i).line + " " + counts.get(i));
		}
	}
}
