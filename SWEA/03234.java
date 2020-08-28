/**
 * 준환이의 양팔저울 - D4
 * 가지치기, 순열, 재귀, 전처리
 * 20,216 kb
 * 614 ms
 * 
 * 순열 재귀 함수 호출 시 종료 조건 설정 중요 -> 안 하면 시간 초과
 * pow, factorial 전처리
 */
 
import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int answer, sum, N, T, left, right;
    static int[] arr;
    static int[] pow, fac;
     
    static void getAns(int left, int right, int i, int flag) {
        if(left>sum-left || i==N) {
            answer += pow[N-i]*fac[N-i];
            return;
        }
 
        for(int j=1; j<=N; j++) {
            if((flag & 1<<j)!=0) continue;
            if(left+arr[j]>=right) {
                getAns(left+arr[j], right, i+1, flag | 1<<j);
            }
            if(left>=right+arr[j]) {
                getAns(left, right+arr[j], i+1, flag | 1<<j);
 
            }
        }
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(input.readLine());
        pow = new int[10];
        fac = new int[10];
        pow[0] = 1;
        fac[0] = 1;
        for(int i=1; i<10; i++) {
            pow[i] = pow[i-1]*2;
            fac[i] = fac[i-1]*i;
        }
         
        for(int t=1; t<=T; t++) {
            answer=0;
            left = 0;
            right = 0;
            sum=0;
            N = Integer.parseInt(input.readLine());
            arr = new int[N+1];
            tokens = new StringTokenizer(input.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(tokens.nextToken());
                sum+=arr[i];
            }
            getAns(0, 0, 0, 0);
             
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
    }
     
}
