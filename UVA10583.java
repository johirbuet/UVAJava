import java.util.Scanner;

public class UVA10583 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if( n ==0 && m==0) break;
			int [] parent = new int[n+1];
			for(int i =0; i<=n;i++) parent[i] = i;
			for(int i =0; i<m;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int ru = find(u, parent);
				int rv = find(v, parent);
				if( ru != rv) {
					parent[ru] = rv;
				}
			}
			int cn = 0;
			for(int i =1; i<=n;i++) {
				if(parent[i] == i) cn++;
			}
			System.out.printf("Case %d: %d\n",c++,cn);
		}
		sc.close();
	}
	public static int find(int u,int [] parent) {
		if(parent[u] != u) {
			parent[u] = find(parent[u],parent);
		}
		return parent[u];
	}
}
