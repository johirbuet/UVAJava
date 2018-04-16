import java.util.Scanner;
import java.util.TreeMap;
public class UVA11136 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if( n == 0) break;
			long cost = 0;
			TreeMap<Integer,Integer> set = new TreeMap<>();
			for(int i =0; i < n; i++) {
				int k = sc.nextInt();
				for(int j =0; j < k;j++) {
					int v = sc.nextInt();
					set.put(v, set.getOrDefault(v, 0) + 1);
				}
				int f = set.firstKey();
				int s = set.lastKey();
				cost += s - f;
				set.put(s, set.get(s) - 1);
				set.put(f, set.get(f) - 1);
				if(set.containsKey(s) && set.get(s) == 0) {
					set.remove(s);
				}
				if(set.containsKey(f) && set.get(f) == 0) {
					set.remove(f);
				}
			}
			System.out.println(cost);
		}
		sc.close();
	}
}
