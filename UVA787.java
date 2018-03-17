import java.math.BigInteger;
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
			
			BigInteger minEndingHere = new BigInteger(list.get(0)+"");
			BigInteger maxEndingHere = new BigInteger(list.get(0)+"");
			BigInteger max = new BigInteger(list.get(0)+"");
			for(int i = 1; i< list.size();i++) {
				BigInteger temp = new BigInteger(minEndingHere.toString());
				BigInteger bi = new BigInteger(list.get(i)+"");
				if((bi.multiply(minEndingHere).compareTo(bi.multiply(maxEndingHere))) < 0 ) {
					if(bi.multiply(minEndingHere).compareTo(bi) > 0) {
						minEndingHere = bi;
					}else {
						minEndingHere = bi.multiply(minEndingHere);
					}
				}else {
					if(bi.multiply(maxEndingHere).compareTo(bi) > 0) {
						minEndingHere = bi;
					}else {
						minEndingHere = bi.multiply(maxEndingHere);
					}
				}
				
				if((bi.multiply(temp).compareTo(bi.multiply(maxEndingHere))) > 0 ) {
					if(bi.multiply(temp).compareTo(bi) < 0) {
						maxEndingHere = bi;
					}else {
						maxEndingHere = bi.multiply(temp);
					}
				}else {
					if(bi.multiply(maxEndingHere).compareTo(bi) < 0) {
						maxEndingHere = bi;
					}else {
						maxEndingHere = bi.multiply(maxEndingHere);
					}
				}
				
				if( maxEndingHere.compareTo(max) > 0) {
					max = maxEndingHere;
				}
			}
			System.out.println(max.toString());
		}
		sc.close();
	}
}
