import java.util.Scanner;

public class LA4215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			if(n == 0) break;
			long sum = 0;
			for(int i =0; i<=n;i++) {
				sum+= i*i;
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
