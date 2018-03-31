import java.util.Scanner;

public class UVA10344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int [] A = new int[5];
			for(int i=0; i<5;i++) {
				A[i] = sc.nextInt();
			}
			if(A[0] == 0 && A[1] == 0 && A[2] == 0 && A[3] == 0 && A[4] == 0) {
				break;
			}
			boolean [] visited = new boolean[5];
			boolean ok = false;
			for(int i =0; i< 5;i++) {
				visited[i] = true;
				ok = ok || visit(A, 1, A[i], visited);
				visited[i] = false;
			}
			System.out.println(ok?"Possible":"Impossible");
		}
		sc.close();
	}
	
	static boolean visit(int [] A,int i,int sum,boolean [] visited) {
		boolean ok = false;
		if(i == 5) {
			return sum == 23;
		}
		else {
			for(int j =0; j<5;j++) {
				if(!visited[j]) {
					visited[j] = true;
					ok = ok || visit(A, i + 1, sum + A[j], visited) ||
							visit(A, i + 1, sum - A[j], visited) ||
							visit(A, i + 1, sum * A[j], visited);
					visited[j] = false;
				}
			}
		}
		return ok;
	}
}
