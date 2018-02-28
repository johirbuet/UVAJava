import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UVA13088 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0;t < T;t++) {
			String s = sc.next();
			char [] ca = s.toCharArray();
			Map<Character, Integer> map = new TreeMap<>();
			char min = 'z';
			for(int i =0; i<ca.length;i++) {
				map.put(ca[i], map.getOrDefault(ca[i], 0) + 1);
				if(ca[i] < min) {
					min = ca[i];
				}
			}
			StringBuffer sf = new StringBuffer();
			StringBuffer last = new StringBuffer();
			for(Map.Entry<Character, Integer> entry : map.entrySet()) {
				char c = entry.getKey();
				int count = entry.getValue();
				for(int i = 0;i< count - 1; i++) {
					sf.append(min);
				}
				last.append(c);
			}
			System.out.println(sf.toString() + last.toString());
		}
		sc.close();
	}
	
}
