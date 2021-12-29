/**
 * [S5] 그룹 단어 체커
 * 구현, 문자열
 * 17,798 kb
 * 216 ms
 * 
 * 문자 비교 시에 모두 -97을 해줘야함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int num = Integer.parseInt(input.readLine());
		int answer = 0;
		boolean[] ap = new boolean[26];
	
		for (int i = 1; i <= num; i++) {
			Arrays.fill(ap, false);
			boolean groupWord = true;
			char[] ch = input.readLine().toCharArray();
			int primer = ch[0] - 97;
			for (int j = 1; j < ch.length; j++) {
				int current = ch[j] - 97;
				if (primer == current) {
					continue;
				} else {
					if (ap[current]) {
						groupWord = false;
						break;
					} else {
						ap[primer] = true;
						primer = current;
					}
				}
			}
			if (groupWord) {
				answer++;
			}
		}
		output.append(answer);
		System.out.println(output.toString());
	}

}
