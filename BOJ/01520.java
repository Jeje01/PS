/**
 * 내리막 길 - G4
 * DP, 그래프 이론
 * 40,876 kb
 * 352 ms
 *
 * DFS + DP
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
    static int M, N, map[][], dp[][];
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static int dfs(int r, int c){
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        if(r==M-1 && c==N-1){
            return 1;
        }
        int tmp = 0;
        for(int i=0; i<dirs.length; i++){
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
            if(nr<0 || nr>=M || nc<0 || nc>=N || map[r][c]<=map[nr][nc]) continue;
            tmp+=dfs(nr, nc);
        }
        dp[r][c]=tmp;
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        output.append(dfs(0, 0));
        System.out.println(output.toString());

    }

}
