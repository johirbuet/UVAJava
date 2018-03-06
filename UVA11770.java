import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class UVA11770 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i =1; i <= T ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			HashMap<Integer, Boolean> map = new HashMap<>();
			for(int a =1; a<=N;a++) {
				map.put(a, false);
			}
			int [][] graph = new int[N+1][N+1];
			for(int j = 0; j< M; j++) {
				int s = sc.nextInt();
				int f = sc.nextInt();
				graph[s][f] = 1;
			}
			
			int cn = cn(graph);
			System.out.printf("Case %d: %d\n",i,cn);
		}
		sc.close();
	}
	
	public static int cn(int [][] graph) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(1);
		int N = graph.length - 1;
		int count = 0;
		Set<Integer> nodes = new HashSet<>();
		for(int i =1; i<= N; i++) {
			nodes.add(i);
		}
		while(!qu.isEmpty()) {
			int V = qu.poll();
			nodes.remove(V);
			for(int i = 1;i<= N; i++) {
				if(graph[V][i] == 1 && nodes.contains(i)) {
					qu.add(i);
				}
			}
			if(qu.isEmpty() && nodes.size() != 0) {
				count++;
				qu.add(nodes.iterator().next());
			}
			
		}
		count++;
		return count;
	}
}
