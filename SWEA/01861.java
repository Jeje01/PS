/**
 * 정사각형 방
 * DFS
 * 109,544 kb
 * 948 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int start;
    static int maxMove;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
       
    public static int dfs(int r, int c, int cnt) {
        visited[r][c] = true;
        // 어디로도 갈 수 없을 때 break;
        for(int i=0; i<dirs.length; i++) {
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
            if(nr>=0 && nr<N && nc>=0 && nc<N) {
                if(visited[nr][nc]) continue;
                if(map[nr][nc]-map[r][c]==1)
                    cnt=dfs(nr, nc, cnt+1);
            }
        }
        return cnt;
    }
      
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            start =-1;
            maxMove=0;
            N = Integer.parseInt(input.readLine());
            map = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer tokens= new StringTokenizer(input.readLine(), " ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }   
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    visited = new boolean[N][N];
                    int result = dfs(i, j, 1);
                    if(result>maxMove) {
                        maxMove = result;
                        start = map[i][j];
                    }else if(result==maxMove) {
                        start = start<map[i][j]? start: map[i][j];
                    }
                }
            }
            output.append("#").append(t).append(" ").append(start).append(" ").append(maxMove).append("\n");
        }
        System.out.println(output.toString());
  
    }
}
