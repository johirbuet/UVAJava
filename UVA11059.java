import java.util.Scanner;

public class UVA11059 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int [] nums = new int[N];
			for(int i =0; i< N; i++) {
				nums[i] =sc.nextInt();
			}
			long max = maxprod(nums);
			System.out.printf("Case #%d: The maximum product is %d.\n\n",c++,max);
		}
		sc.close();
	}
	
	public static long maxprod(int [] nums) {
		long max = nums[0];
		long min = nums[0];
		long result = nums[0];
		for(int i = 1; i< nums.length; i++) {
			long temp = max;
			max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
			min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
			result = Math.max(result, max);
		}
		return result>0?result:0;
	}
}
