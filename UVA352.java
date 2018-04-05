import java.util.Scanner;

public class UVA352 {
	static int [][] dir = {
			{0,1},{0,-1},{-1,0},{1,0},{-1,1},{1,1},{-1,-1},{1,-1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(sc.hasNextLine()) {
			int n = Integer.parseInt(sc.nextLine());
			char [][] graph = new char[n][n];
			boolean [][] visited = new boolean[n][n];
			for(int i =0; i< n;i++) {
				graph[i] = sc.nextLine().toCharArray();
			}
			int c = 0;
			for(int i =0; i<n;i++) {
				for(int j=0; j < n;j++) {
					if(graph[i][j] == '1' && visited[i][j] == false) {
						visit(graph, visited, i, j);
						c++;
					}
					
				}
			}
			System.out.printf("Image number %d contains %d war eagles.\n",t++,c);
		}
		sc.close();
	}
	public static void visit(char [][] graph, boolean [][] visited,int x,int y) {
		if( x < 0 || y < 0 || x >= graph.length || y >= graph.length) {
			return;
		}
		visited[x][y] = true;
		for(int [] d : dir) {
			int x1 = x + d[0];
			int y1 = y + d[1];
			if(x1 >= 0 && x1 <= graph.length - 1 && y1 >=0 && y1 <= graph.length - 1 
					&& graph[x1][y1] == '1' && !visited[x1][y1]) {
				visit(graph, visited, x1, y1);
			}
		}
	}
	
}
