import java.util.Scanner;

public class UVA12917 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int P = sc.nextInt();
			int H = sc.nextInt();
			int O = sc.nextInt();
			int moreO = (O - P);
			if(moreO < H) {
				System.out.println("Hunters win!");
			}else {
				System.out.println("Props win!");
			}
		}
		sc.close();
	}
}
