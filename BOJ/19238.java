/**
 * 스타트 택시 - G4
 * 시뮬레이션
 * 31,484 kb
 * 252 ms
 * 
 * (택시)->(승객) 경로가 없을수도
 * (출발지)->(도착지) 경로가 없을수도
 * 거리 저장하는 bfs는 -1로 초기화하면 -1이 최솟값이 될 수 있으므로 Integer.MAX_VALUE 사용
 * (출발지)->(도착지) 거리 구할 때 목적지 좌표에 도달하지 않을 경우 queue.isEmpty 조건으로 while문을 빠져나오기 때문에,
 * distance를 처음에 Integer.MAX_VALUE로 초기화해줘야됨
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
   static int N, M, map[][], cnt, fuel, arr[], dis[][];
   static Pos taxi, guests[][];
   static Queue<His> queue = new LinkedList<His>();
   static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
   
   static class Pos{
      int r;
      int c;
      
      public Pos(int r, int c) {
         super();
         this.r = r;
         this.c = c;
      }
      
   }
   
   static class His{
      int r;
      int c;
      int n;
      
      public His(int r, int c, int n) {
         super();
         this.r = r;
         this.c = c;
         this.n = n;
      }
      
   }
   
   public static void main(String[] args) throws IOException {
      tokens = new StringTokenizer(input.readLine(), " ");
      N = Integer.parseInt(tokens.nextToken());
      M = Integer.parseInt(tokens.nextToken());
      fuel = Integer.parseInt(tokens.nextToken());
      map = new int[N+1][N+1];
      dis = new int[N+1][N+1];
      guests = new Pos[M+1][2];
      for(int i=1; i<=N; i++) {
         tokens = new StringTokenizer(input.readLine(), " ");
         for(int j=1; j<=N; j++) {
            map[i][j] = Integer.parseInt(tokens.nextToken());
         }
      }
      tokens = new StringTokenizer(input.readLine(), " ");
      int r = Integer.parseInt(tokens.nextToken());
      int c = Integer.parseInt(tokens.nextToken());
      taxi = new Pos(r, c);
      arr = new int[4];
      for(int i=1; i<=M; i++) {
         tokens = new StringTokenizer(input.readLine(), " ");
         for(int j=0; j<4; j++) {
            arr[j] = Integer.parseInt(tokens.nextToken());
         }
         for(int j=0; j<2; j++) {
            guests[i][j] = new Pos(arr[2*j], arr[2*j+1]);            
         }
      }
      // -- 입력 끝
      while(cnt<M) {
         // dis 초기화
         for(int[] row: dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
         }
         // dis[][] dfs
         queue.clear();
         queue.offer(new His(taxi.r, taxi.c, 0));
         dis[taxi.r][taxi.c] = 0;
         while(!queue.isEmpty()) {
            His h = queue.poll();
            for(int d=0; d<4; d++) {
               int nr = h.r+dirs[d][0];
               int nc = h.c+dirs[d][1];
               if(nr<=0 || nr>N || nc<=0 || nc>N || map[nr][nc]==1 || dis[nr][nc]!=Integer.MAX_VALUE) continue;
               dis[nr][nc] = h.n+1;
               queue.offer(new His(nr, nc, h.n+1));
            }
         }

         int minValue=Integer.MAX_VALUE, minIdx=Integer.MAX_VALUE;
         for(int i=1; i<=M; i++) {
            Pos p = guests[i][0];
            if(p==null || dis[p.r][p.c]==Integer.MAX_VALUE) continue;
            if(dis[p.r][p.c]<minValue) {
               minValue = dis[p.r][p.c];
               minIdx = i;
            }else if(dis[p.r][p.c]==minValue) {
               Pos m = guests[minIdx][0];
               if(p.r<m.r) {
                  minValue = dis[p.r][p.c];
                  minIdx = i;
               }else if(p.r==m.r && p.c<m.c) {
                  minValue = dis[p.r][p.c];
                  minIdx = i;
               }
            }
         }
         if(minValue==Integer.MAX_VALUE) break;
         fuel-=minValue;
         if(fuel<=0) break;
         // 출발지 - 목적지
         for(int[] row: dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
         }
         int distance = Integer.MAX_VALUE;
         Pos p = guests[minIdx][0];
         Pos dest = guests[minIdx][1];
         queue.clear();
         queue.offer(new His(p.r, p.c, 0));
         dis[p.r][p.c] = 0;
         while(!queue.isEmpty()) {
            His h = queue.poll();
            if(h.r==dest.r && h.c==dest.c) {
               distance = dis[h.r][h.c];
               break;
            }
            for(int d=0; d<4; d++) {
               int nr = h.r+dirs[d][0];
               int nc = h.c+dirs[d][1];
               if(nr<=0 || nr>N || nc<=0 || nc>N || map[nr][nc]==1 || dis[nr][nc]!=Integer.MAX_VALUE) continue;
               dis[nr][nc] = h.n+1;
               
               queue.offer(new His(nr, nc, h.n+1));
            }
         }
         if(distance==Integer.MAX_VALUE) break;
         fuel-=distance;
         if(fuel<0) break;
         fuel+=distance*2;
                  
         guests[minIdx][0] = null;
         taxi.r = dest.r;
         taxi.c = dest.c;
         cnt++;
         
      }
      if(cnt==M) {
         output.append(fuel);
      }else {
         output.append(-1);
      }
      System.out.println(output.toString());
   }
}
