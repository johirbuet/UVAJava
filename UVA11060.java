import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class UVA11060 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextLine()) {
			int N = Integer.parseInt(sc.nextLine());
			Map<String,Integer> map = new HashMap<>();
			Map<Integer, String> look = new HashMap<>();
			int count = 1;
			for(int i =0; i< N;i++) {
				String d = sc.nextLine();
				map.put(d, count);
				look.put(count, d);
				count++;
			}
			int E = Integer.parseInt(sc.nextLine());
			int [][] graph = new int[N+1][N+1];
			int [] in = new int[N+1];
			for(int i =0; i< E;i++) {
				String [] uv = sc.nextLine().split(" ");
				graph[map.get(uv[0])][map.get(uv[1])] = 1;
				in[map.get(uv[1])]++;
			}
			boolean [] visited = new boolean[N+1];
			
			System.out.printf("Case #%d: Dilbert should drink beverages in this order:",c++);
			for(int i = 1; i<= N;i++) {
				if(!visited[i] && in[i] == 0) {
					visited[i] = true;
					System.out.print(" "+look.get(i));
					for(int j = 1; j<= N; j++) {
						if(graph[i][j] == 1) {
							in[j]--;
						}
					}
					i = 0;
				}
			}
			System.out.println(".\n");
			sc.nextLine();
			
		}
		sc.close();
	}
	public static void visit(int u,boolean [] visited,int [][] graph, Stack<Integer> stack) {
		visited[u] =true;
		for(int i = 1; i< graph.length;i++) {
			if(graph[u][i] == 1 && !visited[i]) {
				visit(i, visited, graph, stack);
			}
		}
		stack.push(u);
	}
}
