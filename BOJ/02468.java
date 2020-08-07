/**
 * 안전 영역 - S1
 * DFS, Brute-force
 * 17,216 kb
 * 192 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int N, max, min, answer=1;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    static void dfs(int r, int c, int n) {
        visited[r][c] = true;
        for(int i=0; i<dirs.length; i++) {
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
            if((nr>=0 && nr<N && nc>=0 && nc<N) && map[nr][nc]>n && !visited[nr][nc]) {
                dfs(nr, nc, n);
            }
        }
        return;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(input.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
                max = map[i][j]>max? map[i][j]: max;
                min = map[i][j]<min? map[i][j]: min;
            }
        }
        for(int n=min; n<=max; n++) {
            visited = new boolean[N][N];
            int zones=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j]>n) { // 잠기지 않는 부분
                        if(!visited[i][j]) {
                            dfs(i, j, n);
                            zones++;
                        }
                    }
                }
            }
            answer = answer<zones? zones: answer;
            
        }
        output.append(answer);
        System.out.println(output.toString());
        
        
    }

}
