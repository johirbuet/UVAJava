import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UVA11991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Map<Integer, List<Integer>> map = new HashMap<>();
			for(int i = 1; i <= N; i++) {
				int x = sc.nextInt();
				if(map.containsKey(x)) {
					List<Integer> list = map.get(x);
					list.add(i);
					map.put(x, list);
				}else {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(x, list);
				}
			}
			for(int i =0;i< M; i++) {
				int index = sc.nextInt();
				int v = sc.nextInt();
				if(!map.containsKey(v)) {
					System.out.println(0);
				}else if(map.containsKey(v) && map.get(v).size() < index) {
					System.out.println(0);
				}else {
					System.out.println(map.get(v).get(index - 1));
				}
			}
		}
		sc.close();
	}
}
