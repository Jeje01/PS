/**
 * 네트워크 연결 - G4
 * 최소 신장 트리, Kruskal
 * 45,644 kb
 * 356 ms
 * 
 * findSet에서 rep[aRoot] = bRoot;
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, cnt, rep[], answer;
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
	
	static int findSet(int x) {
		if(rep[x]!=x) {
			rep[x] = findSet(rep[x]);
		}
		return rep[x];
	}
	
	static void union(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);
		if(x!=y) {
			rep[x] = y;
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			queue.offer(new Edge(a, b, c));
		}
		
		rep = new int[N+1];
		for(int i=1; i<N+1; i++) {
			rep[i] = i;
		}
		
	
		while(!queue.isEmpty()) {
			Edge next = queue.poll();
			if(findSet(next.from)!=findSet(next.to)) {
				union(next.from, next.to);
				cnt++;
				answer+=next.w;
				if(cnt==N-1) break;
			}
		}
		output.append(answer);
		System.out.println(output.toString());
	}

}
