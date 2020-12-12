/**
 * 게임을 만든 동준이 - S4
 * 그리디
 * 14,532 kb
 * 132 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        int answer = 0;
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }
        for(int i=N-2; i>=0; i—){
            if(arr[i] >= arr[i+1]){
                answer += arr[i] - arr[i+1] + 1;
                arr[i] = arr[i+1] - 1;
            }
        }
        output.append(answer);
        System.out.println(output.toString());
    }
}
