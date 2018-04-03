import java.math.BigInteger;
import java.util.Scanner;

public class UVA10220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] digits = new String[1001];
		BigInteger bi = BigInteger.ONE;
		for(int i = 1; i<= 1000; i++) {
			bi = bi.multiply(BigInteger.valueOf(i));
			digits[i] = bi.toString();
		}
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int sum = 0; 
			for(int i =0; i< digits[n].length();i++) {
				sum += (digits[n].charAt(i) -'0');
			}
			System.out.println(sum);
		}
		sc.close();
		
	}
}
