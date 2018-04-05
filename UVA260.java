import java.util.Scanner;

public class UVA260 {
	static int [][] dir = {
			{-1,-1},{-1,0},{0,-1},{0,1},{1,0},{1,1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextLine()) {
			int n = Integer.parseInt(sc.nextLine());
			if( n == 0) break;
			char [][] graph = new char[n][n];
			for(int i = 0; i< n; i++) {
				graph[i] = sc.nextLine().toCharArray();
			}
			boolean [][] visited = new boolean[n][n];
			
			int W = 0;
			int B = 0;
			for(int i =0; i< n; i++) {
				for(int j =0; j < n; j++) {
					if(!visited[i][j]) {
						int count = visit(graph, visited, 0, i, j, graph[i][j]);
						//System.out.println(count);
						if(graph[i][j] == 'w') {
							W = Math.max(W, count);
						}
						else {
							B = Math.max(B, count);
						}
					}
				}
			}
			if(W > B) {
				System.out.printf("%d W\n",c++);
			}else {
				System.out.printf("%d B\n",c++);
			}
			
		}
		sc.close();
	}
	public static int visit(char [][] graph, boolean [][] visited, int count,int x,int y,char c) {
		visited[x][y] = true;
		if(graph[x][y] != c) {
			return count;
		}
		if( x < 0 || y < 0 || x >= graph.length || y >= graph.length) {
			return count;
		}
		for(int [] d : dir) {
			int x1 = x + d[0];
			int y1 = y + d[1];
			if(x1 >= 0 && y1 >= 0 && x1 <= graph.length - 1 && y1 <= graph.length - 1 && 
					graph[x1][y1] == c && !visited[x1][y1]) {
				count += visit(graph, visited, count + 1, x1, y1, c);
			}
		}
		return count;
	}
}
