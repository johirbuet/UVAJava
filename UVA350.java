import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UVA350 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextLong()) {
			long Z = sc.nextLong();
			long I = sc.nextLong();
			long M = sc.nextLong();
			long L = sc.nextLong();
			if( Z == 0 && I == 0 && M == 0 && L ==0) {
				break;
			}
			Map<Long,Integer> seen = new HashMap<>();
			int count = 0;
			int index = 0;
			seen.put(L,0);
			while(true) {
				L = (Z*L + I)%M;
				index++;
				if(seen.containsKey(L)) {
					count = index - seen.get(L);
					break;
				}
				seen.put(L,index);
				
			}
			System.out.printf("Case %d: %d\n",c++,count);
		}
		sc.close();
	}
}
