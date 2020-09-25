/**
 * 이동하기 - S1
 * DP
 * 77,956 kb
 * 436 ms
 * 
 * 처음에 엄청 어렵게 생각하고 BFS를 쓰는 거라고 생각했는데 아니었다.
 * 배열의 모든 위치마다 세 방향으로 탐색하면 된다.
 * 탐색은 이전에 많이 했던 탐색과 달리 왼쪽, 위 방향으로 한다.
 * 
 * 처음 방식
 * 모든 위치에서 전 방향으로 탐색해서 최댓값을 구한 후 오른쪽 아래로도 탐색하는 방식으로 풀었다.
 * 하지만 그럴 필요 없었다.
 * 
 * 배열의 행, 열을 0으로 비워두면 첫째줄에도 다른 줄과 마찬가지로 같은 연산을 수행할 수 있다.
 * 첫째줄에도 연산을 진행해야 한다.
 * (2, 2)부터 탐색을 시작하면 (1,1)을 지나지 않는 경로가 탐색될 수 있다.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, map[][];
	static int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				int max = 0;
				for(int d=0; d<3; d++) {
					int nr = i+dirs[d][0];
					int nc = j+dirs[d][1];
					max = Math.max(max, map[i][j]+map[nr][nc]);
				}
				map[i][j] = max;
			}
		}
		
		output.append(map[N][M]);
		System.out.println(output.toString());
	}

}
