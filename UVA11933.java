import java.util.Scanner;

public class UVA11933 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) break;
			String bin = Integer.toBinaryString(N);
			char [] barr = bin.toCharArray();
			int [] a = new int[barr.length];
			int [] b = new int[barr.length];
			int av = 0;
			int bv = 0;
			int index = 1;
			for(int i = 0; i< a.length;i++) {
				if(barr[i] == '1') {
					index++;
					if(index%2 == 1) {
						a[i] = 1;
						av += Math.pow(2, barr.length - i);						
					}

				}
			}
			index =  0;
			for(int i = 0; i<barr.length; i++) {
				if(barr[i] == '1') {
					index++;
					if(index%2 == 0) {
						b[i] = 1;
						bv += Math.pow(2, barr.length - i);
					}
				}
			}
			System.out.printf("%d %d\n",av,bv);
			
		}
		sc.close();
	}
}
