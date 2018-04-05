import java.util.Scanner;

public class UVA10701 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t= 1; t<=T;t++) {
			String line = sc.nextLine();
			String [] strs = line.split(" ");
			String pre = strs[1];
			String in = strs[2];
			printPostOrder(in, pre);
			System.out.println();
		}
		sc.close();
	}
	
	public static void printPostOrder(String in, String pre) {
		//if(in.length() == 0 || pre.length() == 0) return;
		if(pre.length() == 0) return;
		char root = pre.length()!=0?pre.charAt(0):' ';
		
		if(in.indexOf(root)>0) {
			printPostOrder(in, pre.substring(1));
		}
		if(in.indexOf(root) < in.length() - 1 && in.indexOf(root) != -1) {
			printPostOrder(in.substring(in.indexOf(root) + 1), 
					pre.substring(in.indexOf(root)));
		}
		System.out.print(root);
	}
}
