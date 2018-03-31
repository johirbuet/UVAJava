import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class UVA247 {
	public static int numScc = 0;
	static Map<Integer, String> names;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		boolean flag = false;
		int c = 1;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String [] nm = line.split(" ");
			Map<String, Integer> nameMap = new HashMap<>();
			Map<Integer,List<Integer>> graph = new HashMap<>();
			names = new HashMap<>();
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			if( n == 0 && m == 0) {
				break;
			}
			int count = 0;
			for(int i =0; i< n;i++) {
				graph.put(i, new ArrayList<>());
			}
			for(int i =0; i< m;i++) {
				String [] uv = sc.nextLine().split(" ");
				if(!nameMap.containsKey(uv[0])) {
					nameMap.put(uv[0], nameMap.getOrDefault(uv[0], count));
					names.put(count, uv[0]);
					count++;
				}
				if(!nameMap.containsKey(uv[1])) {
					nameMap.put(uv[1], nameMap.getOrDefault(uv[1], count));
					names.put(count, uv[1]);
					count++;
				}
				if(graph.containsKey(nameMap.get(uv[0]))) {
					List<Integer> list = graph.get(nameMap.get(uv[0]));
					list.add(nameMap.get(uv[1]));
					graph.put(nameMap.get(uv[0]), list);
				}else {
					List<Integer> list = new ArrayList<>();
					list.add(nameMap.get(uv[1]));
					graph.put(nameMap.get(uv[0]), list);
				}
			}
			boolean [] visited = new boolean[n];
			int [] low = new int[n];
			int [] disc = new int[n];
			Arrays.fill(disc, -1);
			if(!flag) {
				flag = true;
			}else {
				System.out.println();
			}
	        System.out.printf("Calling circles for data set %d:\n", c++);
			for(int i =0; i<graph.size();i++) {
				if(disc[i] == -1) {
					tarjanSCC(graph, visited, 0, i, low, disc, new Stack<Integer>());
				}
			}
		}
		sc.close();
	}
	public static void tarjanSCC(Map<Integer,List<Integer>> graph, boolean [] visited,int time,int u,
			int [] low,int [] disc,Stack<Integer> stack) {
		low[u] = disc[u] = time++;
		visited[u] = true;
		stack.push(u);
		for(int v : graph.get(u)) {
			if(disc[v] == -1) {
				tarjanSCC(graph, visited, time, v, low, disc,stack);
			}
			if(visited[v]) {
				low[u] = Math.min(low[u], low[v]);
			}
		}
		if(low[u] == disc[u]) {
			numScc++;
			while(true) {
				int v = stack.pop();
				if(u == v) {
					System.out.printf("%s\n",names.get(v));
					break;
				}else {
					System.out.printf("%s, ",names.get(v));
				}
			}
		}
		
	}
}
