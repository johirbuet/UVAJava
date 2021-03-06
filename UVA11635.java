import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

class IntegerPair implements Comparable<IntegerPair>{
	public IntegerPair(int o, int t){
		first = o; 
		second = t;
	}
	public int first,second;
	@Override
	public int compareTo(IntegerPair arg0) {
		if (((IntegerPair)arg0).first == this.first)
			return this.second - ((IntegerPair)arg0).second;
		else
			return this.first - ((IntegerPair)arg0).first;
	}
}

public class UVA11635 {
	static void run(){
		Scanner scans = new Scanner(System.in);
		int V,E,hotelcount;
	    while(true){
	        V = scans.nextInt();
	        if (V == 0)
	           break;
	        Vector<Vector<IntegerPair>> adjList = new Vector<Vector<IntegerPair>>();
	        for (int i = 0; i < V;i++)
	        	adjList.add(new Vector<IntegerPair>());
	        
	        hotelcount = scans.nextInt();
	        hotelcount += 2;
	        int[] hotels = new int[hotelcount+2];
	        
	        for (int i = 0; i < hotelcount-2; i++){    
	            int input = scans.nextInt();
	            hotels[i] = input-1;
	        }
	        hotels[hotelcount-2] = 0;
	        hotels[hotelcount-1] = V-1;

	        E = scans.nextInt();
	        for (int i = 0; i < E; i++){
	            int from = scans.nextInt();
	            int to = scans.nextInt();
	            int amt = scans.nextInt();
	            from--;
	            to--;
	            adjList.get(from).add(new IntegerPair(to,amt));
	            adjList.get(to).add(new IntegerPair(from,amt));
	        }
	        
	        Vector<Vector<Integer>> adjList2 = new Vector<Vector<Integer>>();
	        for (int i = 0; i < V;i++)
	        	adjList2.add(new Vector<Integer>());
	        
	        for (int h = 0; h < hotelcount; h++){
	            int[] weights = new int[V];
	            for (int i = 0; i < V; i++)
	                weights[i] = 100000000;
	            int source = hotels[h];
	            weights[source] = 0;
	            PriorityQueue<IntegerPair> Q = new PriorityQueue<IntegerPair>();
	            Q.add(new IntegerPair(0, source));
	            
	            while (!Q.isEmpty()){
	                IntegerPair cur = Q.poll();
	               	if (cur.first > weights[cur.second])
	               		continue;
	                if (cur.first > 600)
	                   break;         	
	                for (int i = 0; i < adjList.get(cur.second).size(); i++) {
	                    int next = adjList.get(cur.second).get(i).first;
	                    int later = cur.first + adjList.get(cur.second).get(i).second;
	                	if (later < weights[next]) {
	                		weights[next] = later ;
	                		Q.add(new IntegerPair(weights[next], next));
	                	}
	                }
	            }
	            for (int i = h+1; i < hotelcount; i++){
	                if (weights[hotels[i]] < 601 && hotels[i] != source){
	                   adjList2.get(source).add(hotels[i]);
	                   adjList2.get(hotels[i]).add(source); 
	                }
	            }
	        }

	        boolean[] visited = new boolean[V];
	        Arrays.fill(visited, false);
	        LinkedList<IntegerPair> Qbfs = new LinkedList<IntegerPair>();
	        int source = 0;
	        Qbfs.add(new IntegerPair(0,source));
	        
	        int ans = -1;
	        while (!Qbfs.isEmpty()){
	            IntegerPair cur = Qbfs.pollFirst();//System.out.println((cur.second+1)+ " "+cur.first);
	            if (visited[cur.second])
	               continue;
	            visited[cur.second] = true;
	            if (cur.second == V-1){
	               ans = cur.first-1;
	               break;
	            }

	            for (int i = 0; i < adjList2.get(cur.second).size(); i++) {
	                int next = adjList2.get(cur.second).get(i);
	                if (!visited[next])              
	                   Qbfs.add(new IntegerPair(cur.first+1,next));
	            }
	        }
	        
	        System.out.println(ans);
	    }
	    scans.close();
	}
	
	public static void main(String[] args){
		run();
	}
}

/*
//http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2682
//#tag Graph grafos
//#tag dijkstra 
//#tag bfs breadth first search busca em largura
//#tag Two Components 
//#sol primeiro adicionar os n�s 1 e n no conjunto de hot�is. Depois devemos rodar o dijkstra para 
//cada hotel. Por fim devemos fazer uma bfs entre os hot�is considerando que um hot�is com dist�ncia
// menor ou igual a 600 s�o vizinhos.

#include <cstdio>
#include <cstring>
#include <string>
#include <cmath>
#include <cstdlib>
#include <iostream>
#include <algorithm>
#include <vector>
#include <vector>
#include <queue>
#include <list>
#include <stack>
#include <map>
#include <sstream>
#include <climits>

// #include <unordered_map>

#define ll long long
#define ull unsigned long long
#define pii pair<int,int>
#define pdd pair<double,double>
#define F first
#define S second
#define fr(i,j,k) for(int (i)=(j);(i)<(k);++(i))
#define rep(i,n) for(int (i)=0;(i)<(n);++(i))
#define pb push_back
#define PI acos(-1)
#define db(x) cerr << #x << " = " << x << endl;
#define _ << ", " << 
// #define mp make_pair
#define cl(x) memset(x,0,sizeof(x))
#define MAXN 10010

// #define umap unordered_map

using namespace std;

int n, m, h;
int hot[MAXN], hp = 0;
vector<pii> g[MAXN];
vector<int> hg[MAXN], hots;
int mark[MAXN], mp = 0;

struct st{
	int F, S;
	st(int F =0, int S=0) : F(F), S(S) {}
	bool operator < ( const st & in ) const {
		return S > in.S;
	}
};

int main(){

	int a,b,c;
	
	while(scanf("%d", &n)>0 && n){
		fr(i,0,n+1) g[i].clear(), hg[i].clear();
		hp++; hots.clear();
		cin >> h;
		hots.pb(1); hots.pb(n);
		fr(i,0,h){
			scanf("%d", &a);
			hot[a] = hp;
			hots.pb(a);
		}
		hot[1] = hot[n] = hp;
		cin >> m;
		fr(i,0,m){
			scanf("%d%d%d", &a,&b,&c);
			// db( a _ b _ c);
			g[a].pb( pii(b,c));
			g[b].pb( pii(a,c));
		}
		
		fr(t,0,hots.size()){
			int i = hots[t];
			mp++;
			priority_queue<st> heap;
			heap.push(st(i,0));
			st aux;
			while(!heap.empty()){
				aux = heap.top(); heap.pop();
				// db( aux.F _ aux.S );
				if( aux.S > 600 || mark[aux.F] == mp) continue;
				if( aux.F != i && hot[aux.F] == hp) hg[i].pb(aux.F);// db( i _ aux.F);
				mark[aux.F] = mp;
				fr(j,0,g[aux.F].size()){
					// cout << aux.F << " -> " << g[aux.F][j].F << endl;
					if( aux.S + g[aux.F][j].S <= 600 && g[aux.F][j].F != mp) 
						heap.push( st( g[aux.F][j].F, aux.S + g[aux.F][j].S ) );
				}
			}
		}
		
		queue<pii> fila;
		fila.push(pii(1,0)); pii aux;
		mp++; int resp = 0;
		while(!fila.empty()){			
			aux = fila.front(); fila.pop();
			if( mark[aux.F] == mp) continue;
			// db( aux.F _ aux.S);
			if( aux.F == n ){ resp = aux.S; break; }			
			mark[aux.F] = mp;
			fr(i,0,hg[aux.F].size()){
				fila.push( pii( hg[aux.F][i], aux.S+1));
			}
		}
		printf("%d\n", resp -1 );		
	}
	return 0;
}

*/