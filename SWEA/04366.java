/**
 * 정식이의 은행업무 - D4
 * 브루트포스
 * 18,628 kb
 * 101 ms
 *  
 *  2진수, 3진수 -> 10진수
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static Set<Long> set = new HashSet<>();
	static int T;
	static long answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			char[] a = input.readLine().toCharArray();
			char[] b = input.readLine().toCharArray();
			for(int i=0; i<a.length; i++) {
				a[i] = a[i]=='0'? '1': '0';
				set.add((long)Integer.parseInt(String.valueOf(a), 2));
				a[i] = a[i]=='0'? '1': '0';
			}
			outerLoop: for(int i=0; i<b.length; i++) {
				for(char ch='0'; ch<='2'; ch++) {
					if(b[i]==ch) continue;
					char tmp = b[i];
					b[i] = ch;
					long next = (long)Integer.parseInt(String.valueOf(b), 3);
					if(set.contains(next)) {
						answer = next;
						break outerLoop;
					}
					b[i] = tmp;
				}
			}
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(output.toString());
	}
	
}
