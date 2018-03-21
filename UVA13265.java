import java.util.Scanner;

public class UVA13265 {
	static int [][] dir = {{1,1,1},{0,1,1},{1,0,1},{1,1,0},{1,0,0},{0,1,0},{0,0,1}};
	public static long mod = 1000000007;
	static long count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 4;
		boolean [][][] visited = new boolean[T][T][T];
		long [][][] paths  = new long[T][T][T];
		for(int i = 0; i< T;i++) {
			paths[i][0][0] = i;
			paths[0][i][0] = i;
			paths[0][0][i] = i;
		}
		paths[0][0][0] = 1;
		int x = 0;
		int y = 0;
		int z = 0;
			for(int i =0; i< dir.length;i++) {
				x = dir[i][0];
				y = dir[i][1];
				z = dir[i][2];
				while(x < T && y < T && z <  T) {
					paths[x][y][z] = (paths[x][y][z]  + paths[x - dir[i][0]][y-dir[i][1]][z-dir[i][2]])%mod;
					x += dir[i][0];
					y += dir[i][1];
					z += dir[i][2];
				}
			}

		
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			count = 0;
			//count = count(n,m,k,n,m,k);
			System.out.println(paths[n][m][k]);
		}
		sc.close();
	}
	
	public static long count(int x,int y,int z,int n,int m,int k) {
		if( x < 0 || y < 0 || z <0) return 0;
		if( x == 0 || y == 0 || z == 0) {
			return 1;
		}
		long sum = 0;
		for(int i =0; i< dir.length;i++) {
			sum  = sum + count(n - dir[i][0],m - dir[i][1], k - dir[i][2],n,m,k)%mod;
		}
		return sum%mod;
	}
	
}
