import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA624 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int S = sc.nextInt();
			int N = sc.nextInt();
			int [] A = new int[N];
			for(int i =0; i< N; i++) {
				A[i] = sc.nextInt();
			}
			List<List<Integer>> res = new ArrayList<>();
			backtrack(res, new ArrayList<>(), A, S, 0);
			int mindiff = Integer.MAX_VALUE;
			int minindex = -1;
			int closesum = 0;
			for(int i =0;i< res.size();i++) {
				List<Integer> cur = res.get(i);
				int sum = 0;
				for (Integer integer : cur) {
					sum += integer;
				}
				 if (S >= sum && Math.abs(sum - S) < mindiff) {
					mindiff = Math.abs(sum - S);
					minindex = i;
					closesum = sum;
				}
			}
			for(int i =0; i< res.get(minindex).size();i++) {
				System.out.print(res.get(minindex).get(i) +" ");
			}
			System.out.println("sum:"+closesum);
		}
		sc.close();
	}
	public static void backtrack(List<List<Integer>> res, List<Integer> list,int [] A, int target,int start) {
		res.add(new ArrayList<>(list));
		for(int i =start;i<A.length;i++) {
			list.add(A[i]);
			backtrack(res, list, A, target, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
