import java.util.Scanner;

public class UVA12461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if(n==0) {
				break;
			}
			System.out.println("1/2");
		}
		sc.close();
	}

}
