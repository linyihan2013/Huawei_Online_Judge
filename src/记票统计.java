import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 记票统计 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		String invalid = "Invalid";
		
		int candidateNum = scanner.nextInt();
		while (candidateNum-- > 0) {
			String candidate = scanner.next();
			map.put(candidate, 0);
		}
		map.put(invalid, 0);
		
		int voteNum = scanner.nextInt();
		while (voteNum-- > 0) {
			String vote = scanner.next();
			if (map.containsKey(vote)) {
				map.put(vote, map.get(vote) + 1);
			} else {
				map.put(invalid, map.get(invalid) + 1);
			}
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
