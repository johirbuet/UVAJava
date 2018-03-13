import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVA439 {
	static int [][] move = { { 1, 2 }, { 1, -2 }, 
			{ -1, 2 }, { -1, -2 }, { 2, -1 }, 
			{ 2, 1 }, { -2, -1 }, { -2, 1 } };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.isEmpty()) {
				break;
			}
			int x = line.charAt(0) - 'a';
			int y = line.charAt(1) - '1';
			POS start = new POS(x, y);
			int xf = line.charAt(3) - 'a';
			int yf = line.charAt(4) - '1';
			POS end = new POS(xf, yf);
			Queue<POS> qu = new LinkedList<>();
			int [][] T = new int[8][8];
			
			T[x][y] = 0;
			boolean [][] visited = new boolean[8][8];
			visited[x][y] = true;
			qu.add(start);
			while(!qu.isEmpty() && visited[end.x][end.y] == false) {
				POS  p = qu.poll();
				for(int i = 0; i< 8;i++) {
					int xn = p.x + move[i][0];
					int yn = p.y + move[i][1];
					POS next = new POS(xn, yn);
					if(xn >= 0 && xn < 8 && yn >= 0 && yn < 8 && visited[xn][yn] == false) {
						qu.add(next);
						T[next.x][next.y] = T[p.x][p.y] + 1; 
						visited[xn][yn] =true;
					}
				}
			}
			System.out.printf("To get from %c%c to %c%c takes %d knight moves.\n",line.charAt(0),
					line.charAt(1),line.charAt(3),line.charAt(4),T[end.x][end.y]);
		}
		sc.close();
	}
	public static void bfs() {
		
	}
	static class POS {
		int x;
		int y;
		public POS(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
