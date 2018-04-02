import java.util.Scanner;

public class UVA12086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean first = true;
		int c = 1;
		while(sc.hasNextLine()) {
			int n =Integer.parseInt(sc.nextLine());
			if( n == 0) break;
			if(first) {
				first = false;
			}
			else {
				System.out.println();
			}
			int [] BIT = new int[n + 1];
			int [] nums = new int[n];
			for(int i =0; i< n; i++) {
				int x  = Integer.parseInt(sc.nextLine());
				nums[i] = x;
				init(i, x, BIT);
			}
			System.out.printf("Case %d:\n",c++);
			while(true) {
				String line  = sc.nextLine();
				if(line.equals("END")) {
					break;
				}
				String [] strs = line.split(" ");
				String op = strs[0];
				if(op.equals("M")) {
					int x = Integer.parseInt(strs[1]);
					int y = Integer.parseInt(strs[2]);
					int sum = range(x-1, y -1, BIT);
					System.out.println(sum);
				}else {
					int x = Integer.parseInt(strs[1]);
					int r = Integer.parseInt(strs[2]);
					update(x-1, r, BIT,nums);
				}
				
			}
			
		}
		sc.close();
	}
	
	public static void init(int i,int val, int [] BIT) {
		i++;
		while( i < BIT.length) {
			BIT[i] += val;
			i += (i & -i);
		}
	}
	public static void update(int i,int v,int [] BIT,int [] nums) {
		int diff = v - nums[i];
		nums[i] = v;
		init(i, diff, BIT);
	}
	public static int range(int i,int j,int [] BIT) {
		return getsum(j, BIT) - getsum(i - 1, BIT);
	}
	public static int getsum(int i,int [] BIT) {
		int sum = 0;
		i++;
		while(i > 0) {
			sum += BIT[i];
			i -= (i&-i);
		}
		return sum;
	}
}
