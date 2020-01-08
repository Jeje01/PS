import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, cnt=0, tmp, sum=0;
		for(i=0; i<n; i++) {
			tmp = sc.nextInt();
			if(tmp==1) {
				sum+=++cnt;
			}
			else
				cnt=0;
		}
		System.out.println(sum);
	}
}
