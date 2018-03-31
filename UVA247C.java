import java.util.*;

class Vertex {
	int id;
	String color;
	int pred;
	int d;
	int f;
}

class ByF_decr implements Comparator<Vertex> {

	public int compare(Vertex a, Vertex b) {
		if (a.f < b.f) {
			return 1;
		} else if (a.f > b.f) {
			return -1;
		}
		return 0;
	}
}

class Main {

	static int n;
	static int m;

	static int time;

	static List<String> mapping = new ArrayList<String>();

	static List<Vertex> vert = new ArrayList<Vertex>(); // storage for first iteration
	static List<Vertex> vert2 = new ArrayList<Vertex>(); // storage for second iteration

	static Set<Integer> scc = new HashSet<Integer>();

	static boolean G[][]; // graph
	static boolean T[][]; // graph transpose

	static int get_i(String name) {
		int pos = mapping.indexOf(name);
		if (pos == -1) {
			mapping.add(name);
		}
		pos = mapping.indexOf(name);

		return pos;
	}

	static void dfs_init() {
		vert.clear();

		for (int i = 0; i < n; i++) {
			Vertex v = new Vertex();
			v.color = "WHITE";
			v.pred = -1;
			v.id = i;
			vert.add(v);
		}

		time = 0;

		for (int u = 0; u < n; u++) {
			if (vert.get(u).color == "WHITE") {
				dfs_visit(u);
			}
		}
	}

	static void dfs_visit(int u) {

		vert.get(u).color = "GRAY";
		vert.get(u).d = ++time;

		for (int v = 0; v < n; v++) {
			if (G[u][v]) { // edge exists: current -> v
				if (vert.get(v).color.equals("WHITE")) {
					vert.get(v).pred = u;
					dfs_visit(v);
				}
			}
		}

		vert.get(u).color = "BLACK";
		vert.get(u).f = ++time;

	}

	static void dfs_visit_second(int u) {
		vert2.get(u).color = "GRAY";
		vert2.get(u).d = ++time;

		for (int v = 0; v < n; v++) {
			if (T[u][v]) { // edge exists: current -> v
				if (vert2.get(v).color.equals("WHITE")) {
					vert2.get(v).pred = u;
					scc.add(u);
					scc.add(v);
					dfs_visit_second(v);
				}
			}
		}

		vert2.get(u).color = "BLACK";
		vert2.get(u).f = ++time;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// int n;
		// int m;

		int case_num = 1;

		while (true) {
			n = sc.nextInt(); // number of nodes
			m = sc.nextInt(); // number of connections

			if (n == 0 && m == 0) {
				break;
			}

			if (case_num > 1) {
				System.out.println();
			}

			mapping.clear();
			G = new boolean[n][n];
			T = new boolean[n][n];

			for (int i = 0; i < m; i++) {
				String name1 = sc.next();
				String name2 = sc.next();

				int a = get_i(name1);
				int b = get_i(name2);

				// a -> b
				G[a][b] = true;
				T[b][a] = true;
			}

			// System.out.printf("---\n");

			dfs_init();
			Collections.sort(vert, new ByF_decr());

			// now the second dfs
			vert2.clear();
			time = 0;
			for (int i = 0; i < n; i++) {
				Vertex v = new Vertex();
				v.id = i;
				v.color = "WHITE";
				v.pred = -1;
				vert2.add(v);
			}

			System.out.printf("Calling circles for data set %d:\n", case_num);
			for (int i = 0; i < vert.size(); i++) {
				int u = vert.get(i).id;

				if (vert2.get(u).color.equals("WHITE")) {
					dfs_visit_second(u);
					scc.add(u);
				}

				if (scc.size() == 0) {
					continue;
				}

				List<Integer> results = new ArrayList(scc);

				for (int j = 0; j < results.size(); j++) {
					System.out.printf("%s", mapping.get(results.get(j)));
					if (j < results.size() - 1) {
						System.out.print(", ");
					}
				}
				scc.clear();

				System.out.println();
			}

			case_num++;

		}
	}
}
