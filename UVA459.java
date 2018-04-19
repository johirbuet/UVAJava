import java.io.*;
import java.util.*;
public class UVA459 {
    static int [] pset;
    static int findSet(int i){
        return (pset[i] == i) ? i : (pset[i] = findSet(pset[i]));
    }
    static void unionSet(int i, int j){
        pset[findSet(i)] = pset[findSet(j)];
    }
    static boolean isSameSet(int i, int j){
        return findSet(i) == findSet(j); 
    }
    private static void initSet(int _size) { 
        pset = new int[_size]; for (int i = 0; i < _size; i++) pset[i] = i; 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String l;
        br.readLine();
        for (int i = 0; i < t; i++){
            initSet(br.readLine().charAt(0) - 'A' + 1);
            while((l = br.readLine()) != null && !l.equals("")){
                unionSet(l.charAt(0) - 'A', l.charAt(1) - 'A');
            }
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < pset.length; j++) {
                set.add(findSet(pset[j]));
            }
            out.append(set.size() + "\n");
            if(i != t-1)
            out.append("\n");
        }
        System.out.print(out);
    }
}