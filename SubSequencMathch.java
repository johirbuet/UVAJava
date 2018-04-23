import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SubSequencMathch {
	public static void main(String[] args) {
		String [] w = {"able", "ale", "apple", "bale", "kangaroo"};
		List<String> d = new ArrayList<>();
		for(String s : w) {
			d.add(s);
		}
		String  s = "abppplee";
		System.out.println(longestWord(s, d));
	}
	static String longestWord(String s, List<String> d) {
		Map<Character, List<Word>> map= new HashMap<>();
		for(String w : d) {
			if(map.containsKey(w.charAt(0))) {
				List<Word> ls = map.get(w.charAt(0));
				ls.add(new Word(w,0));
				map.put(w.charAt(0), ls);
			}else {
				List<Word> ls = new ArrayList<>();
				ls.add(new Word(w,0));
				map.put(w.charAt(0), ls);
			}
		}
		List<String> res = new ArrayList<>();
		for(char c : s.toCharArray()) {
			if(!map.containsKey(c)) {
				continue;
			}
			List<Word> ls = map.get(c);
			map.remove(c);
			for(Word w : ls) {
				int t = w.t;
				if(t +  1 == w.w.length()) {
					res.add(w.w);
				}else {
					t++;
					if(map.containsKey(w.w.charAt(t))) {
						List<Word> lis = map.get(w.w.charAt(t));
						lis.add(new Word(w.w,t));
						map.put(w.w.charAt(t), lis);
					}else {
						List<Word> lis = new ArrayList<>();
						lis.add(new Word(w.w,t));
						map.put(w.w.charAt(t), lis);
					}
				}
			}
		}
		System.out.println(res);
		Collections.sort(res,new Comparator<String>() {
			@Override
			public int compare (String a, String b) {
				return b.length() - a.length();
			}
		});
		return res.get(0);
	}
	static class Word {
		String w;
		int t;
		public Word(String w,int t) {
			this.w = w;
			this.t = t;
		}
	}
}
