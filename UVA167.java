import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		while(K-->0) {
			int [][] B = new int[8][8];
			for(int i =0; i<8;i++) {
				for(int j=0;j<8;j++) {
					B[i][j] = sc.nextInt();
				}
			}
			List<Queen> queens = new ArrayList<>();
			int q = 0;
			int max = 0;
			max = backtrack(q, B, queens, max);
			System.out.printf("%5d\n",max);
		}
		
		sc.close();
	}
	public static class Queen {
		int x;
		int y;
		public Queen(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "("+this.x+", "+this.y+")";
		}
	}
	public static boolean conflict(int r,int c,List<Queen> queens) {
		for(int i = 0; i<c; i++) {
			if(queens.get(i).x == r  || queens.get(i).y == c) return true;
			if(Math.abs(queens.get(i).x - r) == Math.abs(queens.get(i).y - c) ) return true;
		}
		return false;
	}
	public static int backtrack(int q,int [][] B,List<Queen> queens,int max) {
		if(q == 8) {
			int tot = 0;
			for(int i =0; i<8;i++) {
				tot += B[queens.get(i).x][queens.get(i).y]; 
			}
			max = Math.max(tot, max);
			return max;
		}
		for(int r = 0; r<8;r++) {
			if(!conflict(r, q, queens)) {
				Queen qu = new Queen(r, q);
				if(queens.size() > q) {
					queens.remove(q);
				}
				queens.add(q,qu);
				max = Math.max(max,backtrack(q + 1, B, queens, max));
			}
		}
		return max;
	}
}
