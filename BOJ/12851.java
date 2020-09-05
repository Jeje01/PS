/**
 * 숨바꼭질 2
 * BFS, Memoization
 * 38,584 kb
 * 160 ms
 * 
 * 다른 숨바꼭질 문제와 비슷하지만 최소 경로로 갈 수 있는 횟수도 구해야 함
 * 한 지점을 거치는 최소 시간보다 시간이 클 경우 탐색할 필요가 없음
 * memoization을 위해 visited를 정수 배열로 관리
 * 각 지점까지 걸리는 시간이 최소가 아닐 경우 더 이상 탐색하지 않음
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Queue<Pos> queue = new LinkedList<>();
	static int N, K, answer, cnt, visited[];
	
	static class Pos{
		int x;
		int dis;
		
		public Pos(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		answer = Integer.MAX_VALUE;
		if(K<=N) {
			answer = N-K;
			cnt=1;
		}else {
			visited = new int[2*K];
			Arrays.fill(visited, Integer.MAX_VALUE);
			queue.offer(new Pos(N, 0));
			while(!queue.isEmpty()) {
				Pos tmp = queue.poll();
				if(tmp.dis>visited[tmp.x]) continue;
				else{
					visited[tmp.x] = tmp.dis;
				}
				if(tmp.dis>answer) break;
				if(tmp.x==K) {
					if(answer == Integer.MAX_VALUE) {
						answer = tmp.dis;
						cnt++;
					}else {
						if(answer==tmp.dis) {
							cnt++;
						}
					}
				}
				if(2*tmp.x<2*K) {
					queue.offer(new Pos(2*tmp.x, tmp.dis+1));
				}
				if(tmp.x+1<2*K) {
					queue.offer(new Pos(tmp.x+1, tmp.dis+1));
				}
				if(tmp.x-1>=0) {
					queue.offer(new Pos(tmp.x-1, tmp.dis+1));
				}
			}			
		}
		output.append(answer).append("\n").append(cnt).append("\n");
		System.out.println(output.toString());
		
	}
	
}
