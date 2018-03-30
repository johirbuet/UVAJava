import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UVA231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		String res = "";
		while(sc.hasNextInt()) {
			List<Integer> list = new ArrayList<>();
			while(true) {
				int n = sc.nextInt();
				if( n == -1) break;
				list.add(n);
			}
			if(list.size() == 0) {
				break;
			}
			int [] dp = new int[list.size()];
			Arrays.fill(dp, 1);
			int max = 1;
			
			for(int i =0; i < list.size();i++) {
				for(int j = 0; j < i; j++) {
					if( list.get(i)  <= list.get(j)) {
						dp[i] = Math.max(dp[j] + 1, dp[i]);
					}
					max = Math.max(dp[i], max);
				}
			}
			res += String.format("Test #%d:\n",c++);
			res += String.format("  maximum possible interceptions: %d\n\n",max);
		}
		System.out.println(res.substring(0,res.length()-2));
		sc.close();
	}
}
