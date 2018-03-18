import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA10608 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int [] parent = new int[N+1];
			for(int i = 0; i<=N;i++) parent[i] = i;
			for(int i = 0; i< M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int ru = find(u, parent);
				int rv = find(v, parent);
				if( ru != rv) {
					parent[ru] = rv;
				}
			}
			Map<Integer,Integer> map = new HashMap<>();
			for(int i =1;i<=N;i++) {
				int r = find(i,parent);
				map.put(r, map.getOrDefault(r, 0) + 1);
			}
			int max = 0;
			for(int x : map.keySet()) {
				max = Math.max(max, map.get(x));
			}
			System.out.println(max);
			
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
