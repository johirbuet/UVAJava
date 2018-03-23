import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UVA10062 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.isEmpty()) {
				break;
			}
			char [] arr = line.toCharArray();
			Map<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
			for(char c : arr) {
				if( c=='\\') {
					continue;
				}
				
				map.put(c, map.getOrDefault(c,0)+1);
			}
			for(char w : map.keySet()) {
				System.out.printf("%d %d\n",(int)w,map.get(w));
			}
			if(sc.hasNextLine()) {
				System.out.println();
			}
		}
		sc.close();
	}
}
