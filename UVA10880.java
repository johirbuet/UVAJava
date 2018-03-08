import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA10880 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("out.txt")));
		int c  = 1;
		int T = sc.nextInt();
		while(T-- > 0) {
			int C = sc.nextInt();
			int R = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for( int i = 1; i <= (int) Math.sqrt(C - R);i++) {
				if((C-R)%i == 0) {
					if(i > R && !list.contains(i)) {
						list.add(i);
					}
					
					if((C- R)/i > R && !list.contains((C-R)/i)) {
						list.add((C-R)/i);
					}
				}
			}
			Collections.sort(list);
			if( R == C) {
				System.out.printf("Case #%d: %d\n",c++,0);
			}else {
				System.out.printf("Case #%d:",c++);
				for(int i = 0; i< list.size();i++) {
					System.out.print(" ");
					System.out.printf("%d",list.get(i));
				}
				System.out.println();
			}
			
		}
		sc.close();
	}
}
