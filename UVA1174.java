import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA1174 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t<=T;t++) {
			sc.nextLine();
			int V = Integer.parseInt(sc.nextLine());
			int E = Integer.parseInt(sc.nextLine());
			Map<String, Integer> map = new HashMap<>();
			int [][] graph = new int[V][V];
			int count = 0;
			for(int i =0 ; i< E; i++) {
				String [] line = sc.nextLine().split(" ");
				int u =0;
				if(map.containsKey(line[0])) {
					u = map.get(line[0]);
				}else {
					map.put(line[0], count);
					u = count;
					count++;
				}
				int v = 0;
				if(map.containsKey(line[1])) {
					v = map.get(line[1]);
				}else {
					map.put(line[1], count);
					v = count;
					count++;
				}
				graph[u][v] = graph[v][u] = Integer.parseInt(line[2]);
			}
			int cost = mst(graph);
			System.out.println(cost);
			if(t < T) {
				System.out.println();
			}

		}
		sc.close();
	}
	
	public static int mst(int [][] graph) {
		int cost = 0;
		boolean [] mst = new boolean[graph.length];
		int [] key = new int[graph.length];
		int [] parent = new int[graph.length];
		for(int i = 0; i< graph.length;i++) {
			key[i] = Integer.MAX_VALUE;
		}
		key[0] = 0;
		parent[0] = -1;
		int V = graph.length;
		for(int i = 0; i< V - 1; i++) {
			int u = minindex(mst, key);
			mst[u] = true;
			for(int v =0; v < V; v++) {
				if(graph[u][v] != 0 && mst[v] == false && graph[u][v] < key[v]) {
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		for(int i = 1; i <V;i++) {
			cost+= graph[parent[i]][i];
		}
		
		return cost;
	}
	public static int minindex(boolean [] mst,int [] key) {
		int V = mst.length;
		int min = Integer.MAX_VALUE;
		int minindex = -1;
		for(int i =0; i<V;i++) {
			if(mst[i] == false && key[i] < min) {
				min = key[i];
				minindex = i;
			}
		}
		return minindex;
	}
}
