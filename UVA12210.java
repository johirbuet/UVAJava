import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA12210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextInt()) {
			int B = sc.nextInt();
			int S = sc.nextInt();
			if( B == 0 && S == 0) break;
			int [] bs = new int[B];
			int [] ss = new int[S];
			List<Integer> blist = new ArrayList<>();
			List<Integer> sList = new ArrayList<>();
			for(int i =0; i< B;i++) {
				bs[i] = sc.nextInt();
				blist.add(bs[i]);
			}
			for(int i =0; i < S; i++) {
				ss[i] = sc.nextInt();
				sList.add(ss[i]);
			}
			Collections.sort(blist,Collections.reverseOrder());
			int total = 0;
			for(int k =  0 ; k < blist.size();k++) {
				int b = blist.get(k);
				int min = Integer.MAX_VALUE;
				int minin = -1;
				for(int i =0; i< sList.size();i++) {
					int diff = Math.abs(b - sList.get(i));
					if(diff < min) {
						min = diff;
						minin = i;
					}
				}
				if(minin >=0) {
					total++;
					sList.remove(minin);
				}
			}
			if(blist.size() == total) {
				System.out.printf("Case %d: %d\n",c++,0);
			}else {
				System.out.printf("Case %d: %d %d\n",c++,blist.size() - total,blist.get(blist.size() -1));
			}
			
		}
		sc.close();
	}
}
