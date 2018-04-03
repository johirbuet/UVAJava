import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA10763 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if( n == 0) break;
			Map<Integer,Integer> map = new HashMap<>();
			for(int i =0; i< n; i++) {
				int s = sc.nextInt();
				map.put(s, map.getOrDefault(s,0) + 1);
				int d = sc.nextInt();
				map.put(d, map.getOrDefault(d,0) - 1);
			}
			int sum =0;
			for(int x : map.keySet()) {
				sum += Math.abs(map.get(x));
			}
			System.out.println(sum == 0? "YES":"NO");
		}
		sc.close();
	}
}
