/**
 * 벽 부수고 이동하기 - G4
 * BFS, 큐
 * 101,912 kb
 * 904 ms
 * 
 * 주의할 점
 * 벽을 깬 경로와 깨지 않은 경로 충돌 가능 -> 깬 경우
 * 깨지 않은 경우 visited를 따로 관리해줘야 함
 * 그럼 priority queue 필요 없음
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
	static int N, M, answer;
	static int[][] arr;
	static boolean[][][] visited; // 0 - 안 부쉈을 때, 1 - 부쉈을 때
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Queue<Walls> q = new LinkedList<>();
	
	static class Walls{
		int r;
		int c;
		boolean broke;
		int count;

		public Walls(int r, int c, boolean broke, int count) {
			super();
			this.r = r;
			this.c = c;
			this.broke = broke;
			this.count = count;
		}


	}
	
	public static void main(String[] args) throws IOException {
		 tokens = new StringTokenizer(input.readLine(), " ");
		 N = Integer.parseInt(tokens.nextToken());
		 M = Integer.parseInt(tokens.nextToken());
		 answer = Integer.MAX_VALUE;
		 arr = new int[N+1][M+1];
		 visited = new boolean[N+1][M+1][2];
		 for(int i=1; i<N+1; i++) {
			 String line = input.readLine();
			 for(int j=0; j<M; j++) {
				 arr[i][j+1] = line.charAt(j)-'0';
			 }
		 }
		 
		 q.offer(new Walls(1, 1, false, 1));
		 visited[1][1][0] = true;
		 visited[1][1][1] = true;
		 
		 while(!q.isEmpty()) {
			 Walls tmp = q.poll();
			 if(tmp.r==N && tmp.c==M) {
				 answer = Math.min(answer, tmp.count);
			 }
			 
			 for(int i=0; i<dirs.length; i++) {
				 int nr = tmp.r+dirs[i][0];
				 int nc = tmp.c+dirs[i][1];
				 if(nr<=0 || nr>=arr.length || nc<=0 || nc>=arr[0].length) {
					 continue;
				 }
				 if(tmp.broke && visited[nr][nc][1]) {
					 continue;
				 }else if(!tmp.broke && visited[nr][nc][0]) {
					 continue;						 
				 }
				 if(arr[nr][nc]==1) {
					 if(tmp.broke) {
						 continue;						 
					 }else if(!visited[nr][nc][0]){
						 q.offer(new Walls(nr, nc, true, tmp.count+1));
						 visited[nr][nc][0] = true;
					 }
				 }else {
					 q.offer(new Walls(nr, nc, tmp.broke, tmp.count+1));
					 if(tmp.broke) {
						 visited[nr][nc][1] = true;
					 }else {
						 visited[nr][nc][0] = true;
					 }
				 }
				
			 } 
		 }
		 
		 if(answer==Integer.MAX_VALUE) {
			 System.out.println(-1);
		 }else {
			 System.out.println(answer);
		 }
		 
	}

}
