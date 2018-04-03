import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UVA12542 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean [] prime = new boolean[100001];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i = 2; i * i <= 100000;i++) {
			if(prime[i]) {
				for(int j = i*i;j<= 100000;j+=i) {
					prime[j] = false;
				}
			}
		}
		List<String> list = new ArrayList<>();
		for(int i = 2;i<=100000;i++) {
			if(prime[i]) {
				list.add(i+"");
			}
		}
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("0")) {
				break;
			}
			for(int i = list.size() - 1; i >=0;i--) {
				if(line.contains(list.get(i))) {
					System.out.println(list.get(i));
					break;
				}
			}
		}
		sc.close();
	}
}
