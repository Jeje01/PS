
/**
 * 최소 스패닝 트리 - G4
 * 최소 신장 트리, Kruskal
 * 48,328 kb
 * 448 ms
 * 
 * union, makeSet, "findSet"
 * findSet 과정에서 rep[x] = findSet[x] 해준 후 rep[x] 리턴
 * 경로 축소를 해주지 않으면 찾을 때마다 계속 올라가야됨
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static List<Edge>[] list;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	static int V, E, rep[];
	static long answer;
	
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

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", w=" + w + "]";
		}
		
		
	}
	
	// union, makeSet, findSet
	static void makeSet() {
		rep = new int[V+1];
		for(int i=1; i<rep.length; i++) {
			rep[i]=i;
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
			rep[y] = x;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		rep = new int[V+1];
		int cnt = 0, goal=V-1;
		makeSet();
		for(int i=0; i<E; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			int C = Integer.parseInt(tokens.nextToken());
			queue.offer(new Edge(A, B, C));
		}
    
		while(!queue.isEmpty()) {
			Edge e = queue.poll();
			if(findSet(e.from)!=findSet(e.to)) {
				union(e.from, e.to);
				answer+=e.w;
				cnt++;
				if(cnt==goal) break;
			}
			
		}
		output.append(answer);
		System.out.println(output.toString());
	
	}
	
}
