import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA263 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			Map<Long,Boolean> seen = new HashMap<>();
			long n = sc.nextLong();
			if(n == 0) break;
			System.out.println("Original number was "+n);
			int count = 0;
			seen.put(n, true);
			while(true) {
				String or = n+"";
				char [] a = or.toCharArray();
				Arrays.sort(a);
				or = new String(a);
				String rev = new StringBuilder(or+"").reverse().toString();
				long rn = Integer.parseInt(rev);
				long in = Integer.parseInt(or);
				seen.put(n, true);
				System.out.printf("%d - %d = %d\n",rn,in,rn - in);
				count++;
				n = rn - in;
				if(seen.containsKey(n)) {
					break;
				}
				seen.put(n, true);
			}
			System.out.println("Chain length "+count);
			System.out.println();
			
		}
		sc.close();
	}
}
