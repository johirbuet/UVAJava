import java.util.Scanner;
import java.util.Stack;

public class UVA10305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if( n == 0 && m == 0) {
				break;
			}
			int [][] graph = new int[n+1][n+1];
			for(int i =0; i< m;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph[u][v] = 1;
			}
			boolean [] visited = new boolean[n+1];
			Stack<Integer> stack = new Stack<>();
			for(int i =1; i<= n; i++) {
				if(!visited[i]) {
					visit(i, graph, visited, stack);
				}
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop());
				if(stack.size() >= 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
	public static void visit(int u,int [][] graph,boolean [] visited,Stack<Integer> stack) {
		visited[u] = true;
		for(int i = 1; i< graph.length;i++) {
			if(graph[u][i] == 1 && !visited[i]) {
				visit(i, graph, visited,stack);;
			}
		}
		stack.push(u);
	}
}
