/**
 * 파리퇴치
 * 완전탐색
 * 20,400 kb
 * 124 ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int[][] map;
    static int answer, N, M;
    public static void findMax(int i, int j) {
        int sum=0;
        for(int r=i; r<i+M; r++) {
            for(int c=j; c<j+M; c++) {
                sum+=map[r][c];
            }
        }
        answer = answer<sum? sum: answer;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            answer = 0;
            StringTokenizer tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            map = new int[N][N];
            for(int i=0; i<N; i++) {
                tokens = new StringTokenizer(input.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }
            for(int i=0; i<=N-M; i++) {
                for(int j=0; j<=N-M; j++) {
                    findMax(i, j);
                }
            }
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
    }
}