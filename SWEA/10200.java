/*
 * 구독자 전쟁
 * 단순 계산
 * 21,252 kb
 * 127 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int max, min;
    public static void main(String[] args) throws NumberFormatException, IOException {
           int T = Integer.parseInt(input.readLine());
           for(int t=1; t<=T; t++) {
               StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
               int N = Integer.parseInt(tokens.nextToken());
               int A = Integer.parseInt(tokens.nextToken());
               int B = Integer.parseInt(tokens.nextToken());
               
               max = Math.min(A, B);
               min = A+B<N ? 0 : A+B-N;
               
               output.append("#").append(t).append(" ").append(max).append(" ").append(min).append("\n");
           }
           System.out.println(output.toString());
    }

}
