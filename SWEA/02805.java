/*
 * 농작물 수확하기
 * 배열
 * 21,252 kb
 * 131 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int[][] map;
    static int answer = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            answer = 0;
            int N = Integer.parseInt(input.readLine());
            map = new int[N][N];
            for(int i=0; i<N; i++) {
                String str = input.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = str.charAt(j)-'0';
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i<=N/2) {
                        if(j>=N/2-i && j<N/2+i+1) {
                            answer+=map[i][j];
                        }
                    }else {
                        if(j>=i-N/2 && j<N-i+N/2) {
                            answer+=map[i][j];
                        }
                    }
                }
            }
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
    }
}
