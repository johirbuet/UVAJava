import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA574 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int S = sc.nextInt();
			int N = sc.nextInt();
			if( S == 0 && N ==0 ) break;
			int [] A = new int[N];
			for(int i =0; i< N;i++) {
				A[i] = sc.nextInt();
			}
			List<List<Integer>> result = new ArrayList<>();
			backtrack(S, 0, A, new ArrayList<>(), result);
			if(result.size() == 0) {
				System.out.printf("Sums of %d:\n",S);
				System.out.println("NONE");
			}else {
				System.out.printf("Sums of %d:\n",S);
				for(List<Integer> list : result) {
					for(int i =0; i< list.size();i++) {
						System.out.print(list.get(i));
						if(i < list.size() - 1) {
							System.out.print("+");
						}
					}
					System.out.println();
				}
			}
			
		}
		sc.close();
	}
	public static void backtrack( int target,int start,int [] A, List<Integer> list, 
			List<List<Integer>> result) {
		if(target < 0) return;
		else if(target == 0) {
			  result.add(new ArrayList<>(list));
			  return;
		  }else {
			  for(int i = start; i< A.length;i++) {
				  if( i > start && A[i-1] == A[i]) continue;
				  list.add(A[i]);
				  backtrack(target - A[i], i +1 , A, list, result);
				  list.remove(list.size() - 1);
			  }
		  }
		  
	}
	
}
