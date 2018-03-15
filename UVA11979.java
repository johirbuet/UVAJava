import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UVA11979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  T = sc.nextInt();
		for(int t =1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			List<List<Integer>> list = new ArrayList<>();
			for(int i = 0; i< M; i++) {
				list.add(new ArrayList<>());
			}
			for(int i =0; i< N ; i++) {
				for(int j = 0; j< M; j++) {
					list.get(j).add(sc.nextInt());
				}
			}
			int d = 0;
			
			
			
			for(int i = 0; i< M ; i++) {
				Collections.sort(list.get(i));
				for(int j = 0; j< N; j++) {
					d += Math.abs(list.get(i).get(j) - j);
				}
			}
			System.out.printf("Case %d: %d\n",t,d);
		}
		sc.close();
	}
}
