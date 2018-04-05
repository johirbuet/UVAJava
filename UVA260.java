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
			
			char winner =' ';
			for(int i =0; i< n; i++) {
					if(!visited[i][0] && graph[i][0] == 'w') {
						boolean count = visit(graph, visited, false, i, 0, graph[i][0]);
						if(count) {
							winner = Character.toUpperCase(graph[i][0]);
						}
				}
			}
			if (winner == ' ') winner = 'B';
			System.out.printf("%d %c\n",c++,winner);
			
		}
		sc.close();
	}
	public static boolean visit(char [][] graph, boolean [][] visited, boolean count,int x,int y,char c) {
		visited[x][y] = true;
		if(graph[x][y] != c) {
			return false;
		}
		if( x < 0 || y < 0 || x >= graph.length || y >= graph.length) {
			return false;
		}
		if(y == graph.length - 1) {
			return true;
		}
		for(int [] d : dir) {
			int x1 = x + d[0];
			int y1 = y + d[1];
			if(x1 >= 0 && y1 >= 0 && x1 <= graph.length - 1 && y1 <= graph.length - 1 && 
					graph[x1][y1] == c && !visited[x1][y1]) {
				count = count || visit(graph, visited, count, x1, y1, c);
			}
		}
		return count;
	}
}
