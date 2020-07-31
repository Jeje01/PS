/**
 * 퍼펙트 셔플
 * 단순 배열
 * 24,792 kb
 * 128 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String[] answer;
    static int N;
    static StringTokenizer tokens;
    static String[] cards;
    static int answerIndex;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(input.readLine());
            cards = new String[N];
            answer = new String[N];
            tokens = new StringTokenizer(input.readLine());
            for(int i=0; i<N; i++) {
                cards[i] = tokens.nextToken();
            }
            // 처음 반
            answerIndex =0;
            int border = N%2==0? N/2 : N/2+1;
            for(int i=0; i<border; i++) {
                answer[answerIndex] = cards[i];
                answerIndex+=2;
            }
            answerIndex = 1;
            for(int i=border; i<N; i++) {
                if(answerIndex>=answer.length) break;
                answer[answerIndex] = cards[i];
                answerIndex+=2;
            }    
            output.append("#").append(t).append(" ");
            for(int i=0; i<answer.length; i++) {
                output.append(answer[i]);
                if(i!=answer.length-1)
                    output.append(" ");
                else
                    output.append("\n");
            }
        }
        System.out.println(output.toString());
    }
 
}
