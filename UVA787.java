import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA787 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			long n = sc.nextLong();
			List<Long> list = new ArrayList<>();
			while( n != -999999) {
				list.add(n);
				n = sc.nextLong();
			}
			
			int minEndingHere = Integer.MAX_VALUE;
			int maxEndingHere = Integer.MIN_VALUE;
			for(int i =0; i< list.size();i++) {
				
			}
		}
		sc.close();
	}
}
