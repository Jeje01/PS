/**
 * 최소비용 구하기 - G5
 * Dijkstra
 * 47,944 kb
 * 416 ms
 * 
 * 기본 다익스트라 문제
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
	static int N, M, start, end, arr[];
	static List<Bus>[] list;
	static boolean[] visited;
	static PriorityQueue<Pos> queue = new PriorityQueue<>();
			
	static class Bus{
		int v;
		int w;
		
		public Bus(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}
	
	static class Pos implements Comparable<Pos>{
		int x;
		int cost;
		
		public Pos(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		list = new ArrayList[N+1];
		arr = new int[N+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		for(int i=1; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			list[u].add(new Bus(v, w));
		}
		tokens = new StringTokenizer(input.readLine(), " ");
		start = Integer.parseInt(tokens.nextToken());
		end = Integer.parseInt(tokens.nextToken());
		queue.offer(new Pos(start, 0));
		arr[start] = 0;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			if(visited[p.x]) continue;
			visited[p.x] = true;
			for(Bus b: list[p.x]) {
				arr[b.v] = Math.min(arr[b.v], p.cost+b.w);
				if(!visited[b.v]) {
					queue.offer(new Pos(b.v, arr[b.v]));
				}
			}
		}
		output.append(arr[end]);
		System.out.println(output.toString());
		
	}
	
	
}
