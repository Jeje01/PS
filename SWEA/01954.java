// 달팽이 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(input.readLine());
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(input.readLine());
            int[][] snail = new int[n+1][n+1];
            int r = 1, c = 1, dir=0;
            for(int i=1; i<=n*n; i++) {
                snail[r][c] = i;
                int nr = r+dirs[dir][0];
                int nc = c+dirs[dir][1];
                if(nr==n+1 || nr==0 || nc==n+1 || nc==0 || snail[nr][nc]!=0) {
                    dir=(dir+1)%4;
                }
                r = r+dirs[dir][0];
                c = c+dirs[dir][1];       
            }
          System.out.println("#"+t);  
          for(int i=1; i<snail.length; i++) {
              for(int j=1; j<snail.length; j++) {
                  System.out.print(snail[i][j]+" ");
              }
              System.out.println();
          }
        }
    }
 
}
