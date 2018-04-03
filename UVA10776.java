import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UVA10776 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line  = sc.nextLine();
			if(line.isEmpty()) break;
			String [] sr = line.split(" ");
			String s = sr[0];
			int r = Integer.parseInt(sr[1]);
			char [] R = s.toCharArray();
			Arrays.sort(R);
			boolean [] take = new boolean[R.length];
			backtrack(0, R, take, "", r);
		}
		sc.close();
	}
	
	public static  void backtrack(int i, char [] A,boolean [] take,String res,int r) {
		if(res.length()  == r) {
			System.out.println(res);
			return;
		}
		for(int j = i; j < A.length; j++) {
			
			if(!take[j]) {
				take[j] = true;
				backtrack(j + 1, A, take, res + A[j], r);
				take[j] = false;
				while(j < A.length -1 && A[j] == A[j+1]) j++;
			}
		}
	}
}
