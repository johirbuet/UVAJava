import java.util.Scanner;

public class UVA13059 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			long P = sc.nextLong();
			System.out.println( P - 1);
		}
		sc.close();
	}
}
