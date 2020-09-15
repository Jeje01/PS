/**
 * 서강그라운드 - G4
 * 다익스트라
 * 13,744 kb
 * 112 ms
 * 
 * 모든 지점에서 dijkstra 후 최솟값 구하기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int n, m, r, t, arr[], answer;
	static List<Edge>[] list;
	static PriorityQueue<Vertex> pq = new PriorityQueue<>();
	
	static class Edge{
		int from;
		int to;
		int w;
		
		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int v;
		int weight;
		
		public Vertex(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static void dijkstra(int x) {
		int count=0;
		boolean[] visited = new boolean[n+1];
		pq.clear();
		int[] way = new int[n+1];
		Arrays.fill(way,Integer.MAX_VALUE);
		way[x] = 0;
		pq.offer(new Vertex(x, 0));
		while(!pq.isEmpty()) {
			x = pq.poll().v;
			if(visited[x]) continue;
			visited[x] = true;
			for(int i=0; i<list[x].size(); i++) {
				Edge e = list[x].get(i);
				way[e.to] = Math.min(way[e.to], way[e.from]+e.w);
				pq.offer(new Vertex(e.to, way[e.to]));
			}
		}
		for(int i=0; i<n+1; i++) {
			if(way[i]<=m) {
				count+=arr[i];
			}
		}
		answer = Math.max(count, answer);
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		r = Integer.parseInt(tokens.nextToken());
		arr = new int[n+1];
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<Edge>();
		}
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=0; i<r; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			list[from].add(new Edge(from, to, w));
			list[to].add(new Edge(to, from, w));
		}
		for(int i=1; i<n+1; i++) {
			dijkstra(i);
		}
		output.append(answer);
		System.out.println(output.toString());
	}

}
