/**
 * 샘터 - G5
 * 그래프, BFS
 * 242,228 kb
 * 460 ms
 * 
 * * 풀이
 * 처음에는 dp인가 하고 잘못 생각하고 있었는데,
 * 얼마 전에 푼 숨바꼭질 3(13549번)과 비슷한 문제였다.
 * 최솟값부터 탐색하므로, k개가 나오면 탐색을 중단하면 된다.
 * 
 * * 주의
 * 답이 int의 범위를 넘을 수도 있어 변수를 long으로 설정해야됨
 * 범위로 주어진 값의 최대값만큼 배열을 선언하니 메모리가 많이 필요하다.
 * 채점 기준의 메모리만큼 거의 다 써서 통과는 하지만, 더 줄일 수 있는 것 같다.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
	static StringBuilder output = new StringBuilder(); 
	static StringTokenizer tokens; 
	static boolean[] visited; 
	static long cnt, total; 
	static int MAX = 100000000; 
	static int N, K; 
	static Queue<Pos> queue = new LinkedList<>(); 
	
	static class Pos{ // 위치 정보 저장 클래스
		int n; // 좌표
		long dis; // 불행도
		
		public Pos(int n, long dis) { // contructor 
			super();
			this.n = n;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " "); // N과 K를 받음
		N = Integer.parseInt(tokens.nextToken()); // 샘터 개수
		K = Integer.parseInt(tokens.nextToken()); // 집 개수
		visited = new boolean[2*(MAX+K)+1]; 
		tokens = new StringTokenizer(input.readLine(), " "); 
		for(int i=0; i<N; i++) {
			int tmp= Integer.parseInt(tokens.nextToken()); // 입력 값
			int next = tmp+MAX+K; // 0이 음수이므로 더함
			visited[next] = true; 
			queue.offer(new Pos(next, 0)); 
		}
		while(!queue.isEmpty()) { // 큐가 없어질 때까지 실행
			Pos tmp = queue.poll(); // 다음 위치
			if(tmp.dis!=0) { 
				cnt++; // 배치한 집 개수 
				total+=tmp.dis; 
			}
			if(cnt==K) break; // 모두 배치한 경우 while문 중단
			if(tmp.n-1>=0 && !visited[tmp.n-1]) { 
				visited[tmp.n-1] = true; // 방문 표시
				queue.offer(new Pos(tmp.n-1, tmp.dis+1)); // 거리 1 더해서 큐에 넣음
			}
			if(tmp.n+1<visited.length && !visited[tmp.n+1]) { 
				visited[tmp.n+1] = true; // 방문 표시
				queue.offer(new Pos(tmp.n+1, tmp.dis+1)); // 거리 1 더해서 큐에 넣음
			}
		}
		System.out.println(total); // 최종 
		
	}
}
 
 
