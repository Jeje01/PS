/**
 * 현빈이와 Spot Mart
 * DFS
 * 25,196 kb
 * 190 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int[] snack;
    static boolean[] visited;
    static int answer, N, M, gap;
     
	public static void dfs(int r, int sum) {
        if(r==0) {
            if(M>=sum && M-sum<gap) {
                gap = M-sum;
                answer = sum;
            }
            return;
        }
        for(int i=0; i<snack.length; i++) {
        	if(M==answer) return;
            if(!visited[i]) {
                visited[i] = true;
                dfs(r-1, sum+snack[i]);
                visited[i] = false;
            }
        }
        return;
    }
	     
    public static void main(String[] args) throws NumberFormatException, IOException {
        int TC = Integer.parseInt(input.readLine());
        for(int t=1; t<=TC; t++) {
            answer = -1;
            gap = Integer.MAX_VALUE;
            tokens = new StringTokenizer(input.readLine(), " ");
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            visited = new boolean[N];
            tokens = new StringTokenizer(input.readLine(), " ");
            snack = new int[N];
            for(int i=0; i<N; i++) {
                snack[i] = Integer.parseInt(tokens.nextToken());
            }
            dfs(2, 0);
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
    }
 
}
