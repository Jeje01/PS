/**
 * 종교
 * Union-Find
 * 32,016 kb
 * 431 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int n, m, a, b;
	static int[] reps, rank;
	static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		makeSet();
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			a = Integer.parseInt(tokens.nextToken());
			b = Integer.parseInt(tokens.nextToken());
			union(a, b);
		}
		for(int i=1; i<reps.length; i++) {
			set.add(findSet(i));
		}
		System.out.println(set.size());
	}
	
	static void makeSet() {
		reps = new int[n+1];
		rank = new int[n+1];
		for(int i=0; i<reps.length; i++) {
			reps[i] = i;
			rank[i] = 1;
		}
	}
  
	static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a!=b) {
			if(rank[a]==rank[b]) {
				rank[a]++;
			}
			if(rank[a]>rank[b]) {
				reps[b]=a;
			}else {
				reps[a]=b;
			}
		}
	}
  
	static int findSet(int v) {
		if(reps[v]==v) {
			return v;
		}else {
			return reps[v]=findSet(reps[v]);
		}
	}

}
