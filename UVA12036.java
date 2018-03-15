import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA12036 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t<= T; t++) {
			int N = sc.nextInt();
			boolean ok = true;
			int max = -1;
			Map<Integer, Integer> map = new HashMap<>();			
			for(int i =0; i< N;i++) {
				for(int j =0;j<N;j++) {
					int x = sc.nextInt();
					map.put(x, map.getOrDefault(x, 0) + 1);
					max = Math.max(max, map.get(x));
				}
			}
			if(max > N) {
				ok = false;
			}
			if(ok) {
				System.out.printf("Case %d: %s\n",t,"yes");
			}else {
				System.out.printf("Case %d: %s\n",t,"no");
			}	
		}
		sc.close();
	}
}
