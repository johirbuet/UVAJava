import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean firstcase = true;
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) break;
			int [] A = new int[N];
			for(int i =0; i< N; i++) {
				A[i] = sc.nextInt();
			}
			List<List<Integer>> result = new ArrayList<>();
			backtrack(A, 0, new ArrayList<>(), result);
			if(!firstcase) {
				System.out.println();
			}else {
				firstcase = false;
			}
			for(List<Integer> l : result) {
				boolean first = true;
				for(int i =0;i< l.size();i++) {
					if(!first) {
							System.out.print(" ");
					}else {
						first = false;
					}
					System.out.print(l.get(i));
					
				}
				System.out.println();
			}
			}
		sc.close();
	}
	
	public static void backtrack(int [] A, int start,List<Integer> list, List<List<Integer>> result) {
		if( start > A.length) return;
		if(list.size() == 6) {
			result.add(new ArrayList<>(list));
			return;
		}
		for(int i = start; i< A.length;i++ ) {
			if( i > start && A[i] == A[i-1]) continue;
			list.add(A[i]);
			backtrack(A, i+1, list, result);
			list.remove(list.size() - 1);
		}
	}
}
