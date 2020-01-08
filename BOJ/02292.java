import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), check, i, j, cnt=-1, answer=0;
		if(n==1)
			System.out.println(1);
		else {
			check=(n-2)/6;
			loop:
			for(i=0; ;i++) {
				for(j=0; j<=i; j++) {
					cnt++;
					if(cnt==check) {
						System.out.println(i+2);
						break loop;
					}
				}
			}
		}
	}
}
