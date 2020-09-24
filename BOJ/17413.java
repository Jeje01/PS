/**
 * 단어 뒤집기 2 - S3
 * 구현, 문자열, 스택
 * 24,968 kb
 * 216 ms
 * 
 * 스택 사용하는 게 순서 뒤집는 데 적합
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		char[] line = input.readLine().toCharArray();
		boolean tag = false;
		
		for(int i=0; i<line.length; i++) {
			if(tag) {
				if(line[i]=='>') {
					tag = false;
				}
				output.append(line[i]);
			}else if(line[i]=='<') {
				while(!stack.isEmpty()) output.append(stack.pop());
				output.append(line[i]);
				tag = true;
			}else if(line[i]==' '){
				while(!stack.isEmpty()) output.append(stack.pop());
				output.append(line[i]);
			}else {
				stack.push(line[i]);
			}
		}
		while(!stack.isEmpty()) output.append(stack.pop());
		System.out.println(output.toString());
	}
}
