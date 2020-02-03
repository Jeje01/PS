import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static String getAns(String s) {
		int i, cnt=0;
		char[] out = s.toCharArray();
		for(i=0; i<out.length-1; i++) {
			if(out[i]=='1')
				cnt++;
		}
		if(out[out.length-1]=='e') {
			if(cnt%2==0) {
				out[out.length-1]='0';
			}
			else {
				out[out.length-1]='1';
			}
		} else {
			if(cnt%2==0) {
				out[out.length-1]='1';
			}
			else {
				out[out.length-1]='0';
			}
		}
		return String.valueOf(out);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> answer = new ArrayList<>();
		while(true) {
			String input = sc.next();
			if(input.equals("#"))
				break;
			else
				answer.add(getAns(input));
		}
		for(String s : answer)  
			System.out.println(s);
	}	
}
