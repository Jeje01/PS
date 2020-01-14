import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, cnt=1;
		char tmp;
		ArrayList<Character> answer = new ArrayList<Character>();
		String[] str = new String[n];
		for(i=0; i<n; i++)
			str[i]=sc.next();
		Arrays.sort(str);
		tmp = str[0].charAt(0);
		for(i=1; i<n; i++) {
			if(str[i].charAt(0)==tmp)
				cnt++;
			else {
				tmp=str[i].charAt(0);
				cnt=1;
			}
			if(cnt==5)
				answer.add(tmp);
		}
		if(answer.size()==0)
			System.out.println("PREDAJA");
		else {
			for(char a : answer) {
				System.out.print(a);
			}
		}
	}
}
