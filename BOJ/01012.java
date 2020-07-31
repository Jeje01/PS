/**
 * 유기농 배추 
 * Silver 2
 * DFS
 * 14,808 kb
 * 104 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int[][] map;
    static boolean[][] visited;
    static int answer, M, N;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void dfs(int r, int c) {
        visited[r][c] = true;
        int i;
        for(i=0; i<dirs.length; i++) {
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
            if((nr>=0 && nr<M && nc>=0 && nc<N) && map[nr][nc]==1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
        return;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            // 입력 받기
            tokens = new StringTokenizer(input.readLine(), " ");
            answer = 0;
            M = Integer.parseInt(tokens.nextToken());
            N = Integer.parseInt(tokens.nextToken());
            int K = Integer.parseInt(tokens.nextToken());
            visited = new boolean[M][N]; 
            map = new int[M][N];
            for(int i=0; i<K; i++) {
                tokens = new StringTokenizer(input.readLine(), " ");
                int r = Integer.parseInt(tokens.nextToken());
                int c = Integer.parseInt(tokens.nextToken());
                map[r][c] = 1;
            }
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j] || map[i][j]==0) continue;
                    dfs(i, j);
                    answer++;
                }
            }
            output.append(answer).append("\n");
        }
        System.out.println(output.toString());
    }
}
