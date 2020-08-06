/**
 * 콩 많이 심기
 * 완전 탐색
 * 32,620 kb
 * 179 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int answer = 0, N, M;
    static int[][] dirs = {{0, -1}, {-1, 0}};
    static int[][] map;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            //answer 초기화
            tokens = new StringTokenizer(input.readLine(), " ");
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            map = new int[N][M];
            answer = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    boolean check = false;
                    for(int d=0; d<dirs.length; d++) {
                        int nr = i+dirs[d][0]*2;
                        int nc = j+dirs[d][1]*2;
                        if((nr>=0 && nr<N && nc>=0 && nc<M) && map[nr][nc]==1) {
                            check = true;
                        }                       
                    }
                    if(!check) {
                        map[i][j]=1;
                        answer++;
                    }
                }
            }
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
             
    }
 
}
