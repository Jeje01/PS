/**
 * 행성 터널 - G2
 * 최소 신장 트리, Kruskal
 * 75,540 kb
 * 1,664 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, rep[], answer;
	static Planet arr[][];
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int w;
		
		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static class Planet implements Comparable<Planet>{
		int pos;
		int num;
		
		public Planet(int pos, int num) {
			super();
			this.pos = pos;
			this.num = num;
		}

		@Override
		public int compareTo(Planet o) {
			return Integer.compare(this.num, o.num);
		}

		@Override
		public String toString() {
			return "Planet [pos=" + pos + ", num=" + num + "]";
		}
		
	
	}
	
	static int findSet(int x) {
		if(rep[x]!=x) {
			rep[x] = findSet(rep[x]);
		}
		return rep[x];
	}
	
	static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a!=b) {
			rep[a] = b;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		arr = new Planet[3][N];
		rep = new int[N];
		for(int i=1; i<N; i++) {
			rep[i] = i;
		}
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<3; j++) {
				int tmp = Integer.parseInt(tokens.nextToken());
				arr[j][i] = new Planet(i, tmp);
			}
		}
		for(int i=0; i<3; i++) {
			Arrays.sort(arr[i]);
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<N-1; j++) {
				queue.offer(new Edge(arr[i][j+1].pos, arr[i][j].pos, arr[i][j+1].num-arr[i][j].num));
			}
		}
		int selected=0;
		while(!queue.isEmpty()) {
			Edge tmp = queue.poll();
			if(findSet(tmp.from)!=findSet(tmp.to)) {
				union(tmp.from, tmp.to);
				answer +=tmp.w;
				selected++;
				if(selected==N-1) break;
			}
		}
		output.append(answer);
		System.out.println(output.toString());
		
	}
	
}
