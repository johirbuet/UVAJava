import java.util.Scanner;
/**
 * 
 * @author johir
 * {@link https://gist.github.com/Tafhim/b5705901e33017205a3b}
 *
 */
public class UVA12024 {
	public static void main(String[] args) {
		int [] num = new int[14];
		num[1] = 1;
		for(int i =2;i<=13;i++) {
			num[i] = num[i-1]*i;
		}
		int [] der = new int[14];
		der[0] = 0;
		der[1] = 0;
		der[2] = 1;
		for(int i = 3; i<=13;i++) {
			der[i] = der[i-1]*i+ (i%2==0?1:-1);
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int N = sc.nextInt();
			System.out.printf("%d/%d\n",der[N],num[N]);
		}
		sc.close();
	}
}
