/**
 * 숨바꼭질 3 - G5
 * BFS
 * 16,284 kb
 * 100 ms
 * 
 * * 풀이
 * 처음에는 dp로 풀었지만 복잡함 -> bfs로 바꿈
 * 해당 자리에 오는 값마다 최솟값인지 판별 -> queue에 순서대로 넣으면 관리할 필요 없음
 * 
 * * 효율성
 * 큐에 넣을 때 2*N를 먼저 넣으면 제일 빠른 시간이 먼저 나옴
 * 가장 먼저 나오는 값이 최솟값이 됨 -> 그 후에 추가적인 연산 필요 없음
 * 2배 한 곳 -> 앞뒤로 탐색 : 시간이 적은 값부터 탐색하게 됨
 * 
 * 큐 돌 때 원하는 값이 나오면 break 또는 return 해줘야 됨
 * 
 * 문제 내의 범위로 탐색 범위 한정시키기 
 * or 답이 될 수 없는 곳까지 불필요하게 탐색하게 됨
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, K, answer;
	static Queue<Pos> queue = new LinkedList<>(); 
	static boolean[] visited;
	static int MAX_POS = 100000;
	
	static class Pos{
		int p;
		int time;
		
		public Pos(int p, int time) {
			super();
			this.p = p;
			this.time = time;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		if(K<=N) {
			answer = N-K;
		}else {
			answer = Integer.MAX_VALUE;
			visited = new boolean[MAX_POS+1];
			queue.offer(new Pos(N, 0));
			visited[0] = true;

			
			while(!queue.isEmpty()) {
				Pos tmp = queue.poll();
					if(tmp.p==K) {
						answer = Math.min(answer, tmp.time);
						break;
					}
					if(tmp.p*2<visited.length && !visited[tmp.p*2]) {
						visited[tmp.p*2] = true;
						queue.offer(new Pos(tmp.p*2, tmp.time));						
					}
					if(tmp.p-1>=0 && !visited[tmp.p-1]) {
						visited[tmp.p-1] = true;
						queue.offer(new Pos(tmp.p-1, tmp.time+1));	
					}
					if(tmp.p+1<visited.length && !visited[tmp.p+1]) {
						visited[tmp.p+1] = true;
						queue.offer(new Pos(tmp.p+1, tmp.time+1));						
					}
			}
			
		}
		System.out.println(answer);
		
	}
	

}
 
