/**
 * 해킹 - G4
 * Dijkstra
 * 159,076 kb
 * 952 ms
 * 
 * 다익스트라에 visited 필요없음
 * queue에서 뺀 값이 이미 있는 해당 지점의 값보다 크다면 더 이상 탐색할 필요 없음
 * 테케 여러 개인 경우 매번 초기화 -> 전역 변수 쓰지 말기
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
	static List<Dep>[] list;
	static int[] count;
	static PriorityQueue<Dep> queue = new PriorityQueue<>();
	static int a, b, s;
	
	static class Dep implements Comparable<Dep>{
		int to;
		int time;
		
		public Dep(int to, int time) {
			super();
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Dep o) {
			return Integer.compare(this.time, o.time);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int n = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			int[] count = new int[n+1];
			Arrays.fill(count, Integer.MAX_VALUE);
			int cnt=0;
			int total=0;
			list = new ArrayList[n+1];
			for(int i=1; i<n+1; i++) {
				list[i] = new ArrayList<Dep>();
			}
			for(int i=0; i<d; i++) {
				tokens = new StringTokenizer(input.readLine(), " ");
				 a = Integer.parseInt(tokens.nextToken());
				b = Integer.parseInt(tokens.nextToken());
				s = Integer.parseInt(tokens.nextToken());
				list[b].add(new Dep(a, s));
			}
			count[c] = 0;
			cnt++;
			queue.clear();
			queue.offer(new Dep(c, 0));
			while(!queue.isEmpty()) {
				Dep dep = queue.poll();
				if(dep.time>count[dep.to]) continue;
				for(Dep tmp: list[dep.to]) {
					int next = count[dep.to]+tmp.time;
					if(count[tmp.to]>next) {
						if(count[tmp.to]==Integer.MAX_VALUE) cnt++;
						count[tmp.to] = next;
						queue.offer(new Dep(tmp.to, count[tmp.to]));
					}
				}
			}
			
			for(int num: count) {
				if(num==Integer.MAX_VALUE) continue;
				total = Math.max(num, total);
			}
			
	
			output.append(cnt).append(" ").append(total).append("\n");
		}
		System.out.println(output.toString());
		
		
		
	}
}
