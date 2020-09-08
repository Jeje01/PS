/**
 * 빙산 - G4
 * DFS
 * 24,952 kb
 * 452 ms
 * 
 * while문에서 계속 돌림 - 배열, 변수 초기화 주이
 * DFS에서 2개 이상일 경우 탐색 중단
 * 중단 조건 확인 : 모두 0일 때
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static StringTokenizer tokens;
   static int N, M, map[][], year, next[][];
   static boolean[][] visited;
   static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
   
   static void dfs(int i, int j) {
      visited[i][j] = true;
      for(int d=0; d<dirs.length; d++) {
         int nr = i+dirs[d][0];
         int nc = j+dirs[d][1];
         if(!visited[nr][nc] && next[nr][nc]!=0) dfs(nr, nc);
      }
      
   }
   
   static int countGlaciers() {
      int i, j, cnt=0;
      for(i=1; i<N-1; i++) {
         for(j=1; j<M-1; j++) {
            if(next[i][j]!=0) {
               if(!visited[i][j] ) {
                  dfs(i, j);
                  cnt++;
                  if(cnt>=2) return cnt;
               }
            }
         }
      }
      return cnt;
   }
   
   public static void main(String[] args) throws IOException {
      tokens = new StringTokenizer(input.readLine(), " ");
      N = Integer.parseInt(tokens.nextToken());
      M = Integer.parseInt(tokens.nextToken());
      map = new int[N][M];
      visited = new boolean[N][M];
      next = new int[N][M];
      for(int i=0; i<N; i++) {
         tokens = new StringTokenizer(input.readLine(), " ");
         for(int j=0; j<M; j++) {
            map[i][j] = Integer.parseInt(tokens.nextToken());
         }
      }
      while(true) {

         year++;
         for(int i=1; i<N-1; i++) {
            for(int j=1; j<M-1; j++) {
               int sea=0;
               visited[i][j] = false;
               if(map[i][j]==0) continue;
               for(int d=0; d<dirs.length; d++) {
                  int nr = i+dirs[d][0];
                  int nc = j+dirs[d][1];
                  if(map[nr][nc]==0) sea++;
               }
               next[i][j] = Math.max(map[i][j]-sea, 0);
            }
         }
         int cnt = countGlaciers();
         int zeros=0;
         for(int[] row: map) {
            for(int a: row) {
               if(a==0) zeros++;
            }
         }
         if(zeros==N*M) {
            year = 0;
            break;
         }
         if(cnt>=2) break;
         for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
               map[i][j] = next[i][j];
            }
         }
   
      }
      output.append(year);
      System.out.println(output.toString());
   }
}
