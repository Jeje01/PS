/**
 * 달팽이는 올라가고 싶다 - B2
 * 수학
 * 14,668 kb
 * 140 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] str = input.readLine().split(" ");
        int[] num = new int[3];
        int sum = 0, answer = 0;
        for (int i=0; i<3; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        answer += Math.round(num[2]/(double)(num[0] - num[1])) - num[0];
        sum += (num[0] - num[1]) * answer;
        while (true) {
            sum += num[0];
            answer ++;
            if (sum >= num[2]){
                break;
            } else {
                sum -= num[1];
            }
        }
        output.append(answer);
        System.out.println(output.toString());
    }
}
