import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UVA195 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while(T-->0) {
			String s = sc.nextLine();
			
			char[] arr = s.toCharArray();
			Character [] c = new Character[arr.length];
			for(int i =0; i< arr.length;i++) {
				c[i] = arr[i];
			}
			Arrays.sort(c,new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					char a = Character.toLowerCase(o1);
					char b = Character.toLowerCase(o2);
					if(a == b) {
						return o1 - o2;
					}
					return Character.toLowerCase(o1) - Character.toLowerCase(o2);
				}
				
			});
			for(int i = 0 ; i< c.length;i++) {
				arr[i] = (char)c[i];
			}
			
			List<List<Character>> result = new ArrayList<>();
			backtrack(0, arr.length, arr, new ArrayList<>(), result,new boolean[arr.length]);
			for(int i = 0;i<result.size();i++) {
				String res = "";
				for(char x : result.get(i)) {
					res += x;
				}
				System.out.println(res);
			}
		}
		sc.close();
	}
	
	public static void backtrack(int start,int n, char [] arr,List<Character> list,
			List<List<Character>> result,boolean [] used) {
		if(list.size() == n) {
			result.add(new ArrayList<>(list));
			return;
		}
		for(int i = 0; i< arr.length; i++) {
			if( used[i] || i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
			list.add(arr[i]);
			used[i] = true;
			backtrack(i + 1, arr.length, arr, list, result,used);
			list.remove(list.size()-1);
			used[i] = false;
		}
	}
}
