/**
 * 파티 - G3
 * Dijkstra
 * 18,576 kb
 * 180 ms
 * 
 * * 풀이
 * (1) X에서 각 지점의 최소 거리 + (2) 각 지점에서 X까지의 최소 거리
 * 1 - (2)를 구할 때 모든 지점에서 다익스트라를 돌림 - 시간 제한 안에 들어오김  : 91,732 kb / 732 ms
 * 2 - 다익스트라 계산 시 각 지점의 min 값이 변경될 때만 큐에 삽입 : 58,316 kb / 528 ms
 * 3 - (2)를 구할 때 간선의 시작과 끝점을 바꿔서 다른 리스트에 저장 
 *     -> 다익스트라를 X에서 한 번만 돌림  : 18,576 kb / 180 ms
 * 
 * * key
 * 모든 지점에서 한 지점으로의 비용 구하기 : 간선의 u, v 바꿔서 다익스트라 계산
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
	static int N, M, X, round[], go[], u, v, w, answer;
	static List<Edge>[] list;
	static List<Edge>[] list2;	
	static boolean[] visited;
	static PriorityQueue<Vertex> queue = new PriorityQueue<>();
	
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
	
	static void dijkstra(int[] arr, List<Edge>[] li) {
		Arrays.fill(arr, Integer.MAX_VALUE);
		queue.offer(new Vertex(X, 0));
		arr[X] = 0;
		while(!queue.isEmpty()) {
			Vertex tmp = queue.poll();
			if(visited[tmp.x]) continue;
			visited[tmp.x] = true;
			for(Edge e: li[tmp.x]) {
				arr[e.v] = Math.min(arr[e.v], tmp.cost+e.w);
				if(!visited[e.v]) {
					queue.offer(new Vertex(e.v, arr[e.v]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		visited = new boolean[N+1];
		go = new int[N+1];
		round = new int[N+1];
		list = new ArrayList[N+1];
		list2 = new ArrayList[N+1];
		for(int i=1; i<list.length; i++) {
			list[i] = new ArrayList<Edge>();
			list2[i] = new ArrayList<Edge>();
			
		}
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			u = Integer.parseInt(tokens.nextToken());
			v = Integer.parseInt(tokens.nextToken());
			w = Integer.parseInt(tokens.nextToken());
			list[u].add(new Edge(v, w));
			list2[v].add(new Edge(u, w));
		}
		// X에서 집 가는 길
		dijkstra(round, list);
    
		// 각 지점에서 X에 가는 길
		for(int b=0; b<visited.length; b++) {
			visited[b] = false;
		}
		dijkstra(go, list2);
		
		for(int i=1; i<round.length; i++) {
			if(i==X) continue;
			answer = Math.max(answer, round[i]+go[i]);
		}
		output.append(answer);
		System.out.println(output.toString());
	}
	
}
