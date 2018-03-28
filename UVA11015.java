import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA11015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextLine()) {
			String [] NM = sc.nextLine().split(" ");
			int n = Integer.parseInt(NM[0]);
			int m = Integer.parseInt(NM[1]);
			if(n == 0 && m ==0) {
				break;
			}
			Map<Integer,String> name = new HashMap<>();
			int id = 1;
			for(int i = 0; i< n;i++) {
				name.put(id, sc.nextLine());
				id++;
			}
			int [][] graph = new int[n+1][n+1];
			for(int i =0; i< n+1;i++) {
				for(int j=0;j<n+1;j++) {
					graph[i][j] = Integer.MAX_VALUE/2;
				}
			}
			for(int i = 0; i<m;i++) {
				String [] uvk = sc.nextLine().split(" ");
				int u = Integer.parseInt(uvk[0]);
				int v = Integer.parseInt(uvk[1]);
				int k = Integer.parseInt(uvk[2]);
				graph[u][v] = graph[v][u] = k;
			}
			for(int k = 1; k < n +1;k++) {
				for(int i =1; i< n+1; i++) {
					for(int j=1; j< n+1;j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+ graph[k][j]);
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			int index = -1;
			for(int i = 1; i< n+1;i++) {
				int cost = 0;
				for(int j =1;j< n + 1; j++) {
					if( i != j)
						cost += graph[i][j];
				}
				if(cost < ans) {
					ans = cost;
					index = i;
				}
			}
			System.out.printf("Case #%d : %s\n",c++,name.get(index));
		}
		sc.close();
	}
}
