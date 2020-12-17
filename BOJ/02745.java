/**
 * 진법 변환 - B2
 * 수학, 구현
 * 14,688 kb
 * 132 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] str = input.readLine().split(" ");
        char[] ch = str[0].toCharArray();
        int N = Integer.parseInt(str[1]);
        int answer = 0;
        for (int i = ch.length - 1; i >= 0 ; i—) {
            int tmp = (ch[i] >= 'A' && ch[i] <= 'Z') ? ch[i]-'A'+10 : ch[i]-'0';
            answer += Math.pow(N, ch.length - i - 1) * tmp;
        }
        output.append(answer);
        System.out.println(output.toString());
    }
}
