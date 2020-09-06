/**
 * 최단경로 - G5
 * Dijkstra, Priority Queue
 * 127,968 kb
 * 744 ms
 * 
 * * 다익스트라 기본 문제
 * 처음에는 다음으로 탐색할 지점을 찾을 때 이전에 탐색한 지점에서만 찾는 걸로 풀었음
 * 하지만 INF가 아닌 전체 중 최소 비용을 가진 점에서 탐색하는 것 -> PQ 이용
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
	static int V, E, K, arr[], start;
	static List<Edge>[] list;
	static PriorityQueue<Vertex> queue = new PriorityQueue<>();
	static boolean[] visited;
	
	static class Edge{
		int v;
		int w;
		
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int x;
		int cost;
		
		public Vertex(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(input.readLine());
		arr = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		list = new ArrayList[V+1];
		for(int i=1; i<arr.length; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for(int i=0; i<E; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			list[u].add(new Edge(v, w));
		}
		queue.offer(new Vertex(K, 0));
		arr[K] = 0;
		while(!queue.isEmpty()) {
			Vertex tmp = queue.poll();
            if(visited[tmp.x]) continue;
			visited[tmp.x] = true;
			for(Edge e: list[tmp.x]) {
				arr[e.v] = Math.min(arr[e.v], e.w+tmp.cost);
				if(!visited[e.v]) {
					queue.offer(new Vertex(e.v, arr[e.v]));
				}
			}
		}

		for(int i=1; i<arr.length; i++) {
			if(arr[i]==Integer.MAX_VALUE) {
				output.append("INF").append("\n");
			}else {
				output.append(arr[i]).append("\n");
			}
		}		
		System.out.println(output.toString());

	}
}
