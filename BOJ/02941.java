/**
 * 크로아티아 알파벳 - S5
 * 문자열
 * 13,124 kb
 * 80 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException {
		String line = input.readLine();
		int answer = 0;
		int i=0, j;
		while(i<line.length()) {
			for(j=0; j<alpha.length; j++) {
				if(line.substring(i).startsWith(alpha[j])) {
					i+=alpha[j].length();
					break;
				}
			}
			if(j==alpha.length){
				i++;
			}
			answer++;
		}
		output.append(answer);
		System.out.println(output.toString());
	}

}
