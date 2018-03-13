import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA484 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> count = new HashMap<>();
		int i = 0;
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			//if( N == 0) break;
			if(!map.containsKey(N)) {
				map.put(N, i++);
			}
			count.put(N, count.getOrDefault(N, 0) + 1);
		}
		int [] list = new int[map.size()];
		for(int key : map.keySet()) {
			list[map.get(key)] = key;
		}
		for(i =0; i< list.length ;i++) {
			System.out.println(list[i]+" "+count.get(list[i]));
		}
		sc.close();
	}
}
