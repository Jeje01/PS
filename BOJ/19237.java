/**
 * 어른 상어 - G3
 * 시뮬레이션
 * 23,200 kb
 * 148 ms
 * 
 * 너무 어려웠던 문제..
 * 2달 전에 풀다가 포기하고 이번에 풀었다
 * 하지만 코드 길이가 이전의 반 정도로 줄었다
 * 
 * 처음에 계획을 확실하게 세운 후에 코딩하기
 * 문제에서 언급되지 않거나 잘 모르는 부분 넘기지 않기
 * 
 * * 디버깅
 * 맨 처음 냄새는 처음에 뿌림
 * 그 후에 while문 안에서는 상어의 다음 이동 위치 저장 후에 냄새-1 해야 됨
 * 다음 위치 우선순위는 (빈 곳) -> (자기 냄새) 이후의 언급은 없어보이는데 그 후에 (다른 냄새)로 하니 통과했다.
 * sharks[i]!=null인 경우에 next[i]는 항상 존재함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static StringTokenizer tokens;
   static int N, M, k, sec;
   static int[][] dirs = {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
   static int[][][] priorities;
   static Smell[][] smellMap;
   static Shark[][] sharkMap;
   static Shark[] sharks;
   static Pos[] next;
   
   static class Smell{
      int t;
      int num;
      
      public Smell(int t, int num) {
         super();
         this.t = t;
         this.num = num;
      }

   }
   
   static class Shark{
      int num;
      int r;
      int c;
      int d;
      
      public Shark(int num, int r, int c, int d) {
         super();
         this.num = num;
         this.r = r;
         this.c = c;
         this.d = d;
      }
      
   }
   
   static class Pos{
      int r;
      int c;
      int d;
      
      public Pos(int r, int c, int d) {
         super();
         this.r = r;
         this.c = c;
         this.d = d;
      }
      
   }
   
   public static void main(String[] args) throws IOException {
      tokens = new StringTokenizer(input.readLine(), " ");
      N = Integer.parseInt(tokens.nextToken());
      M = Integer.parseInt(tokens.nextToken());
      k = Integer.parseInt(tokens.nextToken());
      smellMap = new Smell[N][N];
      
      sharkMap = new Shark[N][N];
      sharks = new Shark[M+1];
      next = new Pos[M+1];
      priorities = new int[M+1][5][4]; // 상어 개수/각 방향 당/1-4위(0-3)
      sec = 1;
      for(int i=0; i<N; i++) {
         tokens = new StringTokenizer(input.readLine(), " ");
         for(int j=0; j<N; j++) {
            int tmp = Integer.parseInt(tokens.nextToken());
            if(tmp==0) continue;
            smellMap[i][j] = new Smell(k, tmp);
            sharkMap[i][j] = new Shark(tmp, i, j, 0);
            sharks[tmp] = sharkMap[i][j];
         }
      }

      tokens = new StringTokenizer(input.readLine(), " ");
      for(int i=1; i<=M; i++) {
         sharks[i].d = Integer.parseInt(tokens.nextToken());
      }
      for(int i=1; i<=M; i++) {
         for(int j=1; j<=4; j++) {
            tokens = new StringTokenizer(input.readLine(), " ");
            for(int k=0; k<4; k++) {
               priorities[i][j][k] = Integer.parseInt(tokens.nextToken());
            }
         }
      }
      
      while(sec<=1000) {
         // 다음 이동할 위치
         for(int i=1; i<=M; i++) {
            Shark s = sharks[i];
            if(s==null) continue;
            smellMap[s.r][s.c] = new Smell(k, i);
            sharkMap[s.r][s.c] = null;
            Pos tmp = null;
            Pos own = null;
            Pos other = null;
            int[] pri = priorities[s.num][s.d];
            for(int dir=0; dir<4; dir++) {
               int nr = s.r + dirs[pri[dir]][0];
               int nc = s.c + dirs[pri[dir]][1];
               if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
               if(smellMap[nr][nc]==null) {
                  tmp = new Pos(nr, nc, pri[dir]);
                  break;
               }else if(smellMap[nr][nc].num==i){
                  if(own==null) {
                     own = new Pos(nr, nc, pri[dir]);
                  }
               }else {
            	   if(other==null) {
            		   other = new Pos(nr, nc, pri[dir]);
            	   }
               }
            }
            next[i] = tmp!=null? tmp:(own!=null? own: other); 
         }
         // 냄새 -1
         for(int i=0; i<N; i++) {
        	 for(int j=0; j<N; j++) {
        		 if(smellMap[i][j]!=null) {
        			 smellMap[i][j].t--;
        			 if(smellMap[i][j].t==0) {
        				 smellMap[i][j] = null;
        			 }
        		 }
        	 }
         }
         // 옮기기
         int cnt = 0;
         for(int i=1; i<=M; i++) {
        	if(sharks[i]==null) continue;
            Pos nextPos = next[i];
            if(sharkMap[nextPos.r][nextPos.c]==null) {
               cnt++;
               sharkMap[nextPos.r][nextPos.c] = new Shark(i, nextPos.r, nextPos.c, nextPos.d);
               sharks[i] = sharkMap[nextPos.r][nextPos.c]; 
            }else {
               sharks[i] = null;
            }
         }
         if(cnt==1) break;   
         sec++;
         
      }
      if(sec==1001) {
         output.append(-1);
      }else {
         output.append(sec);
      }
      System.out.println(output.toString());
   }
}
