import java.util.HashMap;
import java.util.Scanner;

public class UVA10260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('B', 1);
		map.put('F', 1);
		map.put('P', 1);
		map.put('V', 1);
		map.put('C', 2);
		map.put('G', 2);
		map.put('J', 2);
		map.put('K', 2);
		map.put('Q', 2);
		map.put('S', 2);
		map.put('X', 2);
		map.put('Z', 2);
		map.put('D', 3);
		map.put('T', 3);
		map.put('L', 4);
		map.put('M', 5);
		map.put('N', 5);
		map.put('R', 6);
		while(sc.hasNext()) {
			String w = sc.next();
			String res = "";
			int last = 0;
			for(char c : w.toCharArray()) {
				if(map.containsKey(c)) {
					if(map.get(c) != last) {
						res += map.get(c);
						last = map.get(c);
					}
				}else {
					last = 0;
				}
			}
			System.out.println(res);
		}
		sc.close();
	}
}
