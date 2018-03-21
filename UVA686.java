import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UVA686 {
   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean [] prime = new boolean[40000];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i =2; i < prime.length; i++) {
        	if(prime[i]) {
        		for(int j = i*i; j<prime.length; j+= i) {
        			prime[j] = false;
        		}
        	}
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i =0; i< prime.length; i++) {
        	if(prime[i]) {
        		set.add(i);
        		list.add(i);
        	}
        }
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int ret = 0;
            for(int a : list) {
            	if(n - a < a) {
            		break;
            	}
            	if(set.contains(n - a)) {
            		ret++;
            	}
            }
            
            System.out.println(ret);
        }
        sc.close();
    }
}
