import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA291 {
	static int [][] dir = {
			{0,1,1,0,1},
		    {1,0,1,0,1},
		    {1,1,0,1,1},
		    {0,0,1,0,1},
		    {1,1,1,1,0}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> path = new ArrayList<>();
		path.add(0);
		boolean [][] visited = new boolean[5][5];
		dfs(0, 0, path,visited);
		sc.close();
	}
	public static void dfs(int start,int count, List<Integer> path,boolean [][] visited) {
		if(path.size() == 9) {
			for(int i =0; i< 9;i++) {
				System.out.print(path.get(i)+1);
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < 5;i++) {
			if(dir[start][i] == 1 &&  !visited[start][i]) {
				path.add(i);
				visited[start][i] = true;
				visited[i][start] =true;
				dfs(i, count + 1, path,visited);
				path.remove(path.size() - 1);
				visited[start][i] = false;
				visited[i][start] = false;
			}
		}
	}
}
